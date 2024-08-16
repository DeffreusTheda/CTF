# Math Reversal Writeup - US Cyber Game 2024

I'm playing on an aarch64 machine, btw.

## Recon

```$ file beginnerREChal_1 
beginnerREChal_1: ELF 64-bit LSB pie executable, x86-64, version 1 (SYSV), dynamically linked, interpreter /lib64/ld-linux-x86-64.so.2, BuildID[sha1]=c8fd3350ec8609c47517e5f42c5c4f3c76dc5cc8, for GNU/Linux 3.2.0, not stripped
```

## Solution

I used [Decompiler Explorer](https://dogbolt.org/?id=6eabe7ad-9759-4265-9537-854c1aac312f#Hex-Rays=283) (Hex-Rays) to decompile the binary.

```decompiled.c
_DWORD flagCheck[31] = { 45, 55, 42, 62, 57, 46, 5, 10, 77, 14, 7, 33, 28, 79, 26, 26, 79, 29, 11, 20, 12, 33, 16, 31, 13, 13, 9, 80, 14, 28, 3 }; // weak

_BOOL8 __fastcall checkflag(const char *a1)
{
  int i; // [rsp+1Ch] [rbp-14h]

  for ( i = 0; i < strlen(a1) && i <= 30; ++i ) {
    if ( a1[i] + flagCheck[i] != 128 )
      return 0LL;
  }
  return strlen(a1) == 31;
}

int __fastcall main(int argc, const char **argv, const char **envp) {
  if ( argc == 2 ) {
    if ( checkflag(argv[1]) )
      printf("%s was the correct flag\n", argv[1]);
    else
      puts("nope!");
    return 0;
  } else {
    puts("put in a flag guess");
    return 1;
  }
}
```

There's a `flagCheck` variable and we can use it to find input characters that pass the comparison.

```solve.py
flagCheck = [ 45, 55, 42, 62, 57, 46, 5, 10, 77, 14, 7, 33, 28, 79, 26, 26, 79, 29, 11, 20, 12, 33, 16, 31, 13, 13, 9, 80, 14, 28, 3 ]

for c in flagCheck:
    print(chr(128 - c),end='')
```

Run it, and I got the flag: `SIVBGR{v3ry_d1ff1cult_passw0rd}`
