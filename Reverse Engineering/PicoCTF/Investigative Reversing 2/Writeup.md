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
long long codedChar(int a1, char a2, char a3) {
  char v4 = a2;

  if ( a1 )
    v4 = a2 >> a1;
  return v4 & 1 | a3 & 0xFEu;
}

int main(int argc, const char **argv, const char **envp) {
  char ptr;
  FILE *stream = fopen("original.bmp", "r");
  int v6 = fread(&ptr, 1uLL, 1uLL, stream);
  FILE *v13 = fopen("flag.txt", "r");
  FILE *v15 = fopen("encoded.bmp", "a");
  char v16[56];

  if ( !v13 )
    puts("No flag found, please make sure this is run on the server");
  if ( !stream )
    puts("original.bmp is missing, please run this on the server");

  for ( int i = 0; i < 2000; ++i ) {
    fputc(ptr, v15);
    v6 = fread(&ptr, 1uLL, 1uLL, stream);
  }
  if ( fread(v16, 0x32uLL, 1uLL, v13) <= 0 ) {
    puts("flag is not 50 chars");
    exit(0);
  }
  for ( int i = 0; i <= 49; ++i ) {
    for ( int j = 0; j <= 7; ++j ) {
      fputc(codedChar(j, v16[i] - 5, ptr), v15);
      fread(&ptr, 1uLL, 1uLL, stream);
    }
  }
  while ( v6 == 1 ) {
    fputc(ptr, v15);
    v6 = fread(&ptr, 1uLL, 1uLL, stream);
  }

  fclose(v15);
  fclose(stream);
  fclose(v13);
  return 0;
}
```

I just need to get the flag,
these .bmp bytes are just dumps!

```mystery.c
  for ( int i = 0; i < 2000; ++i ) {
    fputc(ptr, v15);
    v6 = fread(&ptr, 1uLL, 1uLL, stream);
  }
```

The first 2000 bytes of `encoded.bmp` and `original.bmp` is just the same.

```mystery.c
long long codedChar(int a1, char a2, char a3) {
  return (a2 >> a1) & 1 | a3 & 0xFEu;
}
// -- snip --
  for ( int i = 0; i <= 49; ++i )
    for ( int j = 0; j <= 7; ++j ) {
      fputc(codedChar(j, v16[i] - 5, ptr), encoded);
      fread(&ptr, 1uLL, 1uLL, original);
    }
```

This is a bit strange.
