# Forky - PicoCTF 2019

###### Author: Samuel

In [this program](https://jupiter.challenges.picoctf.org/static/7bd9504475583513cd7a9f72ee79b106/vuln), identify the last integer value that is passed as parameter to the function doNothing().

<details><summary>Hint</summary>
What happens when you fork?
The flag is picoCTF{IntegerYouFound}.
For example, if you found that the last integer passed was 1234, the flag would be picoCTF{1234}
</details>

## Files

```sh
> file vuln
vuln: ELF 32-bit LSB pie executable, Intel 80386, version 1 (SYSV), dynamically linked, interpreter /lib/ld-linux.so.2, for GNU/Linux 3.2.0, BuildID[sha1]=836c8d5ecaad6d64f4a358cf73d060d0c5050e87, not stripped
```

We're given an intel executable.
## Solution

My first though on this was to just debug it!
But before doing that,
some static reversing could help with understanding what the program does.

![[Reverse Engineering/PicoCTF/Forky/Screenshot 2025-01-01 at 17.01.42.png]]

What you see as `fork` is an external function call.
I haven't run this yet, so I think this could be a fork bomb?
If that's the case running it unpatched gonna be dangerous.
What I thought of is to just patch the binary,
so that these `fork` calls are gone~

Before that, I wanna see if there's any other call to `doNothing()` other than main...

![[Reverse Engineering/PicoCTF/Forky/Screenshot 2025-01-01 at 16.57.56.png]]

`doNothing()` is ONLY called once in main?
The reference on Entry Point is irrelevant,
and the other two external references are just from Frame Description Entry Table and Frame Descriptor Entry respectively.
I thought this gonna be harder...

Okay, but when I debug this it's hard!
GDB can't reliably follow forks! >\_<

So just static analysis, duh,
4 call of forks,
$2^4$ instances that adds _that variable_ by `1234567890`,
so the end result should be $1000000000 + 16 \times 1234567890$!
Because the variable size is 32 bits,
there should be overflow.
Also, it's signed.

## Solver

```C
   1   │ #include <stdint.h>
   2   │ #include <stdio.h>
   3   │ 
   4   │ int main() {
   5   │   int32_t x = 1000000000;
   6   │   x += 16 * 1234567890;
   7   │   printf("%d\n", x);
   8   │ }
```

```sh
gcc solve.c -o solve; ./solve
solve.c:6:11: warning: overflow in expression; result is -1721750240 with type 'int' [-Winteger-overflow]
    6 |   x += 16 * 1234567890;
      |           ^
1 warning generated.
-721750240
```

Flag: `picoCTF{-721750240}`