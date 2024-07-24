# not crypto Writeup by Deffreus - PicoCTF picoMini by redpwn

```$ file not-crypto 
not-crypto: ELF 64-bit LSB pie executable, x86-64, version 1 (SYSV), dynamically linked, interpreter /lib64/ld-linux-x86-64.so.2, BuildID[sha1]=1f838db474ea41305b3181bc0acdc8231273189d, for GNU/Linux 4.4.0, stripped
```

Goddamit it's stripped!

```$ du -h not-crypto 
16K	not-crypto
```

Aight, let's [decompile](https://dogbolt.org/?id=c3427394-3b65-4e25-948e-1ab76f79a24c#Hex-Rays=786) it and see what'll happen...
There's dumps around the actual code and I cleaned it ^_^

Here's the final check:

```not-crypto.c
  while ( &v116 != v98 ); // wtf
  v18 = memcmp(v115, ptr, 0x40uLL);
  if ( v18 ) {
    v18 = 1;
    puts("Nope, come back later");
  }
  else {
    puts("Yep, that's it!");
  }
  return v18;
```

`ptr` is the input with length of 40 characters. These are all the usage of it:

```not-crypto.c
  char ptr[64]; // [rsp+70h] [rbp-198h] BYREF
  fread(ptr, 1uLL, 0x40uLL, stdin);
  v18 = memcmp(v115, ptr, 0x40uLL);
```

```
> be me
> flag constructing algorithm is 251 lines long
> trying to understand it
> got bored
> search for a write-up for this challenge
> word count: 170
> the guy just read the flag at compare instruction
> binary is x86_64
> i'm on aarch64
> mfw
```

HOLY SHIT I MADE IT FINALLY
I CAN RUN x86_64 BINARY NOW.
But still, 
the binary is stripped :(

fLAG is `picoCTF{c0mp1l3r_0pt1m1z4t10n_15_pur3_w1z4rdry_but_n0_pr0bl3m?}`!
