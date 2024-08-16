# Investigative Reversing 2 Writeup by Deffreus - PicoCTF 2019

I got two files, `encoded.bmp` and `mystery`.

```$ file encoded.bmp mystery 
encoded.bmp: PC bitmap, Windows 3.x format, 1765 x 852 x 8, image size 1506336, cbSize 1507414, bits offset 1078
mystery:     ELF 64-bit LSB pie executable, x86-64, version 1 (SYSV), dynamically linked, interpreter /lib64/ld-linux-x86-64.so.2, for GNU/Linux 3.2.0, BuildID[sha1]=2d2155d1fe9b3de7809f36ce63468d6e9a9ebbf7, not stripped
```
```$ du -h encoded.bmp mystery 
1.5M	encoded.bmp
20K	mystery
```

The *pretty* [decompiled]() `mystery` looks like this:

```mystery.c
long long codedChar(int n, char f, char ptr) {
  return (f >> n) & 1 | ptr & 0xFEu;
}

int main(int argc, const char **argv, const char **envp) {
  char ptr;
  FILE *original = fopen("original.bmp", "r");
  int v6 = fread(&ptr, 1uLL, 1uLL, original);
  FILE *flag = fopen("flag.txt", "r");
  FILE *encoded = fopen("encoded.bmp", "a");
  char flagBytes[56];

  if ( !flag )
    puts("No flag found, please make sure this is run on the server");
  if ( !original )
    puts("original.bmp is missing, please run this on the server");
  if ( fread(flagBytes, 0x32uLL, 1uLL, flag) <= 0 ) {
    puts("flag is not 50 chars");
    exit(0);
  }

  for ( int i = 0; i < 2000; ++i ) {
    fputc(ptr, encoded);
    v6 = fread(&ptr, 1uLL, 1uLL, original);
  }
  for ( int i = 0; i <= 49; ++i )
    for ( int n = 0; n <= 7; ++j ) {
      fputc(codedChar(n, flagBytes[i] - 5, ptr), encoded);
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

From this we can know that the flag is 50 character long.
Now,
we just need to get the flag,
these bytes from the .bmp file are just filler!

```mystery.c
  for ( int i = 0; i < 2000; ++i ) {
    fputc(ptr, v15);
    v6 = fread(&ptr, 1uLL, 1uLL, stream);
  }
```

^ We can see that the first 2000 bytes of `encoded.bmp` and `original.bmp` is just the same.
Now let's dissect what does `codedChar` does.

```mystery.c
long long codedChar(int n, char f, char ptr) {
  return (f >> n) & 1 | ptr & 0xFEu;
}
```

`(f >> n) & 1` will get the (`n + 1`)th byte (from the right) of `f`, the flag character.
`ptr & 0xFEu` will evaluated to the character at `ptr` (pointer), but with the least significant bit off (0).
It will then return the `|` (OR) of both result, which is just the character at `ptr` but with `f`'s least significant bit.

```mystery.c
  for ( int i = 0; i <= 49; ++i ) // 50x
    for ( int n = 0; n <= 7; ++j ) { // 8x
      fputc(codedChar(n, flagBytes[i] - 5, ptr), encoded);
      fread(&ptr, 1uLL, 1uLL, original);
    }
```

The code then use `codedChar` to write 8 character for each of the next 50 bytes from the flag, pretty much the entire flag.
`j` iterate from 0 to 7, and thus this code write the `flagBytes` from right to left.
However,
it subtract 5 from the flag byte,
so we need to reverse it when we're decrypting the `encoded.bmp`.

```mystery.c
  while ( v6 == 1 ) {
    fputc(ptr, encoded);
    v6 = fread(&ptr, 1uLL, 1uLL, original);
  }
```

And then, it just write the remaining bytes from `original.bmp` to `encoded.bmp`.
This means that we just need the 400 (8 x 50) bytes after the first 200 bytes from `encoded.bmp` to work with.

```$ dd count=400 bs=1 if=encoded.bmp of=encodedflag skip=2000 
400+0 records in
400+0 records out
400 bytes copied, 0.00212348 s, 188 kB/s
```

Let's use Python to solve this:

```solve.py
encoded = open('encodedflag', 'rb').read()
d = ''
for c in encoded:
    d = str(c & 1) + d
    if len(d) == 8:
        print(chr(int(d, 2) + 5), end='')
        d = ''
```

```$ python3 solve.py
picoCTF{n3xt_0n300000000000000000000000000394060c}
```

It's a bit weird at first, but that's the flag!
Yay!

Flag: `picoCTF{n3xt_0n300000000000000000000000000394060c}`
