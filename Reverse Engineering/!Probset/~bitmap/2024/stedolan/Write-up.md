So?
This binary is taken from IOCCC28, The 28th International Obfuscated C Code Competition (2024), from an "best-one liner" award-winning program.
What does it do? Although it seems like the recommended input is a MD5, a 128 bits input, the actual number of bits consumed/used by the binary is only 40 bits.

```main.c
int __fastcall main(int argc, const char **argv, const char **envp)
{
  __int64 Z; // x8
  __int64 X; // x9
  int C; // w0
  __int64 tmp; // x10

  puts("P1\n80 80");                            // PBM file header, an 80x80 image
  scanf("%10lx", &G);                           // get 10 byte characters, so 40 bits
  Z = z;
  if ( (unsigned __int64)(z - 6480) >= 2160 )
  {
    X = x;
    do
    {
      if ( X > 4 )
      {
        C = '\n';                               // newline!
      }
      else                                      // x_ <= 4
      {
        if ( X < 1 )
          LOBYTE(X) = ~(_BYTE)X;
        C = ((((32 * G) >> (5
                          * (((unsigned __int16)((unsigned __int128)(Z * (__int128)0x6522C3F35BA78195LL) >> 0x40) >> 8)
                           + ((((unsigned __int128)(Z * (__int128)0x6522C3F35BA78195LL) >> 0x40) & 0x8000000000000000LL) != 0LL)))) & (16u >> (X + 1))) == 0) ^ '1';
      }
      putchar(C);                               // this will either be 1 or 0, based on the output .pbm
      tmp = z;
      Z = ++z;
      X = ((int)((((int)tmp + 1) % 81 + (((unsigned int)(((int)tmp + 1) % 81) >> 12) & 7)) << 24) >> 27) - 5;
      x = X;
    }
    while ( (unsigned __int64)(tmp - 6479) > 2159 );
  }
  return 0;
}
```

Next is a weird while conditional expression, `(z - 6480) >= 2160`.
If z is a globally zero-initialized variable, then how does this makes sense?
The important trick being used here is the `(unsigned __int64)` cast:
if z is 0-6479, then it'll be a negative number,
and if it's casted into an unsigned number, it become really huge, like `-1` into `0xFFFFFF...`
However, when z is 6480, the expression become `0 >= 2160`, which is false.
Effectively, it's `for (z = 0; z < 6480; z++)`.
Now what does the number mean? 6480 / 80 is 81, so?
For the attentive, 81 is the length of a line in the output: 80 bit char + one newline.
Effecitvely, this loop iterates for all of 80x80 bit char in the image.
Therefore, we can conclude that Z is the char index of the output binary.

Next, the expression for C is dependent on X, so let's go to X's expression first. We have:
- (write) `X = ((((tmp + 1) % 81 + ((((tmp + 1) % 81) >> 12) & 7)) << 24) >> 27) - 5`
- (read, write) `if ( X < 1 ) LOBYTE(X) = ~(_BYTE)X;`
- (read) `& (16u >> (X + 1))`
X is only dependent on Z, the char index for the image. We only need the value of the read expression.
We can just try to pass testing values for Z and try to see the pattern:
```c
#include "defs.h"
#include <stdio.h>

int main(){
  __int64 Z, T, X;
  
  for (Z = 0; Z < 6480; ++Z) { // tmp = Z btw
    X = (X < 1) ? ~X : X;
    X = 16u >> (X + 1);
    printf("%lld ", X);
    X = ((int)((((int)Z + 1) % 81 + (((unsigned int)(((int)Z + 1) % 81) >> 12) & 7)) << 24) >> 27) - 5;
  }
  return 0;
}
// 0 0 0 0 0 0 0 0 1 1 1 1 1 1 1 1 2 2 2 2 2 2 2 2 4 4 4 4 4 4 4 4 8 8 8 8 8 8 8 8 16 16 16 16 16 16 16 16 4 4 4 4 4 4 4 4 2 2 2 2 2 2 2 2 1 1 1 1 1 1 1 1 0 0 0 0 0 0 0 0 0
// this 81 number pattern repeat 80 times, 6480 numbers in total
```
All of this numbers are multiple of 2, and looking at the X's read expression and it's bit selection usage,
X is effetively set at this bit from the LSB: 0,1,2,3,4,5,3,2,1,0, where 0 means X is cleared (no bit set).
In other words, 1,10,100,1000,10000,100,10,1,0.
Okay, now that X is done, let's decipher C:
```c
C = ((((32 * G) >> (5 * ((((Z * 0x6522C3F35BA78195LL) >> 0x40) >> 8) + ((((Z * 0x6522C3F35BA78195LL) >> 0x40) & 0x8000000000000000LL) != 0LL)))) & (16u >> (X + 1))) == 0) ^ '1';
```
`32 * ` is `<< 5`, but what are these big hexadecimals number? It does feels magical here. Well, it is.
This is a division optimization, namely the-multiplication-by-magic-number optimization. Wait?
How can multiplication become division? There's this thing named the multiplicative invert,
that in conjunction with shift right, can replaces the computationally expensive division operation.
But how? So dividing by N is the same as multiplying with 1/N, therefore, for 2^64 / N, we can represent it as an integer, multiply by it, then get the high 64 (0x40) bits to get the result.
There's a paper for this: https://gmplib.org/~tege/divcnst-pldi94.pdf
The question in this case is, what is this N exactly? We can do the same approach as we did with X:
```c
#include "defs.h"
#include <stdio.h>

int main(){
  int C;
  __int64 Z = 0, T;
  
  for (Z = 0; Z < 6480; ++Z) {
    // C = ((((32 * G) >> (5 * ((((Z * 0x6522C3F35BA78195LL) >> 0x40) >> 8) + ((((Z * 0x6522C3F35BA78195LL) >> 0x40) & 0x8000000000000000LL) != 0LL)))) & (16u >> (X + 1))) == 0) ^ '1';
    // first: ((Z * 0x6522C3F35BA78195LL) >> 0x40) >> 8
    // second: 
    C = (__int64)((__int128)((__int128)Z * (__int128)0x6522C3F35BA78195LL) >> 0x40) >> 8;
    if (Z == 0) {
      T = C;
    }
    if (T != C) {
      break;
    }
  }
  printf("%lld %d\n", Z, C);
  return 0;
}
```
It will start to print C as 0s, and when C become 1, we stop and peek at the value of Z.
This will print `648 1`, so the first expression is the multiplicative inverse of 648,
and doing the same for the second expression apparently always return 0.

So far, the expression has been simplified into:
```c
C = ((((G << 5) >> (5 * (Z / 648))) & (16u >> (X + 1))) == 0) ^ '1';
```
`5 * (Z / 648)` is `range(0, 50, 5)`, determining which 5 bits group of G is used,
Since G is shifted by 5 at first, the first group will always be all zero,
and the same can be said for `>> 45` (remember G is only 40 bits).
This is why there's a white margin at the image top and bottom.
In between, it start from the LSB (first row), to the MSB (last row).

The `& (16u >> (X + 1))) == 0)` effectively extracts one bit out of the group,
Remember X as 0,1,2,3,4,5,3,2,1,0? With the trailing 0s, we get another margin for the image's left and right.
Now the interesting part is, the bit extraction.
It's partially symmetrical: the outer 3 (4 if you count margin) column of the image is the same.
A row is defined the 5 bits group in this fashion, where A-E is LSB to MSB: `0ABCDECBA0`.

That's enough information to turn back the output image into a 10 hex character input,
and we can do that with these scripts:
```py
#!/usr/bin/env python3
import sys
import binascii

a = open(sys.argv[1], 'r').read()[9:]
rows = []
for i in range(0,6480,648):
    l = ""
    for j in range(0, 80, 8):
        l+=a[i+j]
    rows.append(l[1:1+8])

group = [row.strip()[:5][::-1] for row in rows] # row into 5 bit group
binary = ''.join(reversed(group[1:8+1])) # strip margin
G = int(binary, 2)
flag = binascii.unhexlify(f"{G:010x}").decode('ascii')
print(end=flag)
```
```
 $ for F in *.pbm; do python solve.py "$F";done
QNQSEC{_CR3D17_70_573PH3N_D0L4N!_10CCC28_-_B357_0N3_L1N3R!_}
```
