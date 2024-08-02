# Investigative Reversing 5 Writeup by Deffreus - PicoCTF 2019

###### Author: Santiago C/Danny T

Reversing an LSB encoding algorithm, with odd or even.

## Description

We have recovered a [binary](https://jupiter.challenges.picoctf.org/static/f3e80981e58aeb676687a8172a3877a7/mystery) and an [image](https://jupiter.challenges.picoctf.org/static/f3e80981e58aeb676687a8172a3877a7/encoded.bmp)
See what you can make of it.
There should be a flag somewhere.

<details><summary>Hint 1</summary>
You will want to reverse how the LSB encoding works on this problem
</details>

## Files

```
$ file mystery encoded.bmp 
mystery:     ELF 64-bit LSB pie executable, x86-64, version 1 (SYSV), dynamically linked, interpreter /lib64/ld-linux-x86-64.so.2, for GNU/Linux 3.2.0, BuildID[sha1]=84b6f32deb8d6ef5099ab1fac1a24f3f273cfaa0, not stripped
encoded.bmp: PC bitmap, Windows 3.x format, 1765 x 852 x 8, image size 1506336, cbSize 1507414, bits offset 1078
```

## Solution

The decompiled C code for `mystery` is .
I use the Hex-Rays output for this write-up (cuz it's neatest :3).

`mystery.c` (or [here](https://dogbolt.org/?id=c308704b-82b7-48a3-a34a-79e4cc315a78))
```mystery.c
long long codedChar(int n, char f, char ptr) {
  return (f >> n) & 1 | ptr & 0xFEu;
}

int main(int argc, const char **argv, const char **envp) {
  char ptr;
  char flagBytes[56];
  FILE *flag = fopen("flag.txt", "r");
  FILE *original = fopen("original.bmp", "r");
  FILE *encoded = fopen("encoded.bmp", "a");

  if ( !flag )
    puts("No flag found, please make sure this is run on the server");
  if ( !original )
    puts("No output found, please run this on the server");

  int v6 = fread(&ptr, 1uLL, 1uLL, original);
  for ( int i = 0; i < 723; ++i ) {
    fputc(ptr, encoded);
    v6 = fread(&ptr, 1uLL, 1uLL, original);
  }

  if ( fread(flagBytes, 0x32uLL, 1uLL, flag) <= 0 ) {
    puts("Invalid Flag");
    exit(0);
  }

  for ( int i = 0; i <= 99; ++i )
    if ( i & 1 ) {
      fputc(ptr, encoded);
      fread(&ptr, 1uLL, 1uLL, original);
			continue;
    }
    for ( int i = 0; i <= 7; ++i ) {
      fputc(codedChar(i, flagBytes[i / 2], ptr), encoded);
      fread(&ptr, 1uLL, 1uLL, original);
    }
  while ( v6 == 1 ) {
    fputc(ptr, encoded);
    v6 = fread(&ptr, 1uLL, 1uLL, original);
  }

  fclose(encoded);
  fclose(original);
  fclose(flag);

  return 0;
}
```

This code take the bytes from `original.bmp`, and 'insert' the flag to `encoded.bmp` with some kind of encryption, a LSB one.
LSB is an abbreviation for 'least significant bit', which is the rightmost bit in big endian.

Let's get some unnecessary things first.
This part of the code means the first 723 bytes of `encoded.bmp` and `original.bmp`.:

```mystery.c
  int v6 = fread(&ptr, 1uLL, 1uLL, original);
  for ( int i = 0; i < 723; ++i ) {
    fputc(ptr, encoded);
    v6 = fread(&ptr, 1uLL, 1uLL, original);
  }
```

Then, we have the part where it 'insert' the flag:

```mystery.c
  for ( int i = 0; i <= 99; ++i )
    if ( i & 1 ) {
      fputc(ptr, encoded);
      fread(&ptr, 1uLL, 1uLL, original);
			continue;
    }
    for ( int i = 0; i <= 7; ++i ) {
      fputc(codedChar(i, flagBytes[i / 2], ptr), encoded);
      fread(&ptr, 1uLL, 1uLL, original);
    }
```

> [!NOTE]
> BTW, a character (e.g. 'A') has the size of a byte.<br>
> 'byte' and 'character' may be used interchangeably from here.

There's one custom function in that code, `codedChar()`.
First off, let's dissect what does `codedChar` does.

```mystery.c
long long codedChar(int n, char f, char ptr) {
  return (f >> n) & 1 | ptr & 0xFEu;
}
```

`(f >> n) & 1` will get the (`n + 1`)th byte (from the right) of `f`, the flag character.
`ptr & 0xFEu` will evaluated to the character at `ptr` (pointer), but with the least significant bit off (0).
It will then return the `|` (OR) of both result, which is just the character at `ptr` but with `f`'s least significant bit.
This function used 8 times for each flag bytes, corresponding to each bytes.

Going back to the code, the insertion branch into either putting a byte from `original.bmp` if `i` is odd, else a byte from the flag.
This part of the code will put 450 characters (50 * 8 + 50), so anything after that is irrelevant.
The command `dd bs=1 if=encoded.bmp of=encodedflag count=450 skip=723` will get these bytes for us to work with into the `encodedflag` file.


And don't forget, after inserting the flag, it put the remaining bytes from `original.bmp` into `encoded.bmp`:

```mystery.c
  while ( v6 == 1 ) {
    fputc(ptr, encoded);
    v6 = fread(&ptr, 1uLL, 1uLL, original);
  }
```

Alright, now we just need to make a script to get the flag!
I'll use Python, here's the code:

```solve.py
encoded = open('encodedflag', 'rb').read()
i = 0
d = ''
for c in encoded:
    if i & 1:
        i += 1
    else:
        d = str(c & 1) + d
    if len(d) == 8:
        print(chr(int(d, 2)), end='')
        d = ''
        i += 1
```

```
$ python3 solve.py
picoCTF{4n0th3r_L5b_pr0bl3m_0000000000000dec3960d}
```

Yup!
That's the flag, boy! XD

Flag: `picoCTF{4n0th3r_L5b_pr0bl3m_0000000000000dec3960d}`
