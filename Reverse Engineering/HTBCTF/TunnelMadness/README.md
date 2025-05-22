a maze?
it's all the way from 0x20E0 - 0x214DF...
*extract it with ImHex*
I haven't figure out where even is the starting position...
the dimension? I saw this `6400 * a[0] + 320 * a[1] + 16 * a[3]`...
based on Arcanum, he said it's Z, Y, and X, respectively.
So? is it?
I looked more in depth and,
here's what the moves modifies:

```asm
mov     rdx, [rbx]
mov     [rsp+18h+var_18], rdx
mov     edx, [rbx+8]
mov     [rsp+18h+var_10], edx

+/- -> address
R/L -> [rsp+18h+var_18]
F/B -> [rsp+18h+var_18+4]
U/D -> [rsp+18h+var_10]
```

I look into the functions that calls `get_cell`s, 
and it seems like the value `2` is a wall,
cuz we "Cannot move that way".

Okay, honestly I'm confused.
The maze length doesn't seems to be enough for the `get_cell` position calculation.
huh?
...

```
mov     eax, [rdi]       ; a32 = x
lea     rax, [rax+rax*4] ; a64 *= 5
lea     rax, [rax+rax*4] : a64 *= 5
shl     rax, 4           ; a64 <<= 4
mov     edx, [rdi+4]     ; d32 = y
lea     rdx, [rdx+rdx*4] ; d64 *= 5
lea     rax, [rax+rdx*4] ; a64 += d64 * 4
mov     edx, [rdi+8]     ; d32 = z
add     rax, rdx         ; a64 += d64
shl     rax, 4           ; a64 <<= 4
lea     rdx, maze
add     rax, rdx
retn
```

It's best to just run this in a C program.

```get_cell.c
#include <stdio.h>

int main() {
  long long a, d;
  for (int x = 0; x < 4; ++x) {
    for (int y = 0; y < 4; ++y) {
      for (int z = 0; z < 4; ++z) {
        a = x;
        a *= 5;
        a *= 5;
        a <<= 4;

        d = y;
        d *= 5;
        a += d * 4;

        d = z;
        a += d;
        a <<= 4;

        printf("\n{x:%d,y:%d,z:%d}\n%64llx\n%64llx\n", x, y, z, a, d);
      }
    }
  }
}
```

What I got was,
Z step in 10,
y step in 140(?), and
x step in 1900...

IT STILL DOESN'T MATCH THE MAZE LENGTH.

Heck, maybe I should just debug it.
really should, didn't i?

dang I just noticed it now that `3` is the goal position...
I'll continue later.