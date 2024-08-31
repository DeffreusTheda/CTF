# Summarize Writeup by Deffreus - UIUCTF 2024

###### Author: Nikhil

> ![WARNING]
> I get quite dirty with words here.<br>
> Just saying...

## Description

All you have to do is find six numbers.
How hard can that be?

[summarize](https://uiuctf-2024-rctf-challenge-uploads.storage.googleapis.com/uploads/66e8392f3eaaf0ee279369f4bbdb61ca7ede335f802339359e67daaa171b4340/summarize)

## Files

```$ file summarize
summarize: ELF 64-bit LSB executable, x86-64, version 1 (SYSV), dynamically linked, interpreter /lib64/ld-linux-x86-64.so.2, BuildID[sha1]=a5c907b4b408b4a5c7b504432506d90a407886fb, for GNU/Linux 3.2.0, stripped
```
```$ du -h summarize
16K	summarize
```

## Solution

```summarize.c
puts("To get the flag, you must correctly enter six 9-digit positive integers: a, b, c, d, e, and f.");
putchar(10);
printf("a = ");
__isoc99_scanf("%d", &v4);
printf("b = ");
__isoc99_scanf("%d", &v5);
printf("c = ");
__isoc99_scanf("%d", &v6);
printf("d = ");
__isoc99_scanf("%d", &v7);
printf("e = ");
__isoc99_scanf("%d", &v8);
printf("f = ");
__isoc99_scanf("%d", &v9);
if ( check6Cardinals(v4, v5, v6, v7, v8, v9) )
```

I need to find 6 correct numbers to be the input to this program.
Let's call these the Cardinals.

I use [Decompiler Explorer](https://dogbolt.org/?id=8d09d83e-8514-464b-8722-515ca0f11d91#Hex-Rays=196) - Hex-Rays.

## Understanding the Functions

There' quite a handful of functions here and there.
It'll be easier to name them with anythings else than random hex numbers.
These are the mathematical functions used, with a bit relevant name:

- `check6Cardinals`
- `crazyMeth`
- `CrazyMethButNegateArg2`
- `tillArg1Is0DoMath`
- `whileArg1OrArg2DoXor`
- `whileArg1OrArg2DoAnd`

As its name suggest, I should avoid `crazyMeth` and focus on others functions, but it's used by all `res` variables that you'll see soon.
`check6Cardinals` is the parent functions of these functions mentioned above.
According to `main()`, we just need to make it return 1.

```main.c
_BOOL8 __fastcall check6Cardinals(
        unsigned int a1,
        unsigned int a2,
        unsigned int a3,
        unsigned int a4,
        unsigned int a5,
        unsigned int a6)
{
  unsigned int tmp1; // eax
  int tmp2; // ebx
  unsigned int tmp3; // eax
  unsigned int tmp4; // ebx
  unsigned int tmp5; // eax
  unsigned ires1 tmp6; // eax
  unsigned int res1; // [rsp+20h] [rbp-30h]
  unsigned int res2; // [rsp+24h] [rbp-2Ch]
  unsigned int res3; // [rsp+28h] [rbp-28h]
  unsigned int res4; // [rsp+2Ch] [rbp-24h]
  unsigned int res5; // [rsp+30h] [rbp-20h]
  unsigned int res6; // [rsp+34h] [rbp-1Ch]
  unsigned int res7; // [rsp+38h] [rbp-18h]
  unsigned int res8; // [rsp+3Ch] [rbp-14h]

  if ( a1 <= 0x5F5E100 || a2 <= 0x5F5E100 || a3 <= 0x5F5E100 || a4 <= 0x5F5E100 || a5 <= 0x5F5E100 || a6 <= 0x5F5E100 )
    return 0LL;
  if ( a1 > 0x3B9AC9FF || a2 > 0x3B9AC9FF || a3 > 0x3B9AC9FF || a4 > 0x3B9AC9FF || a5 > 0x3B9AC9FF || a6 > 0x3B9AC9FF )
    return 0LL;
  tmp1 = crazyMethButNegateArg2(a1, a2);
  res1 = (unsigned int)crazyMeth(tmp1, a3) % 0x10AE961;
  res2 = (unsigned int)crazyMeth(a1, a2) % 0x1093A1D;
  tmp2 = tillArg1Is0DoMath(2u, a2);
  tmp3 = tillArg1Is0DoMath(3u, a1);
  tmp4 = crazyMethButNegateArg2(tmp3, tmp2);
  res3 = tmp4 % (unsigned int)whileArg1OrArg2DoXor(a1, a4);
  tmp5 = crazyMeth(a3, a1);
  res4 = (unsigned int)whileArg1OrArg2DoAnd(a2, tmp5) % 0x6E22;
  res5 = (unsigned int)crazyMeth(a2, a4) % a1;
  tmp6 = crazyMeth(a4, a6);
  res6 = (unsigned int)whileArg1OrArg2DoXor(a3, tmp6) % 0x1CE628;
  res7 = (unsigned int)crazyMethButNegateArg2(a5, a6) % 0x1172502;
  res8 = (unsigned int)crazyMeth(a5, a6) % 0x2E16F83;
  return res1 == 4139449
      && res2 == 9166034
      && res3 == 556569677
      && res4 == 12734
      && res5 == 540591164
      && res6 == 1279714
      && res7 == 17026895
      && res8 == 23769303;
}
```

It's best to start from the end of the functions, and see what are the sets of numbers needed to achieve these.

The code gave us a starting set for each Cardinal:

```sets.c
  if ( a1 <= 0x5F5E100 || a2 <= 0x5F5E100 || a3 <= 0x5F5E100 || a4 <= 0x5F5E100 || a5 <= 0x5F5E100 || a6 <= 0x5F5E100 )
    return 0LL;
  if ( a1 > 0x3B9AC9FF || a2 > 0x3B9AC9FF || a3 > 0x3B9AC9FF || a4 > 0x3B9AC9FF || a5 > 0x3B9AC9FF || a6 > 0x3B9AC9FF )
    return 0LL;
```

No time to beautify it, for now.

### Function: CrazyMeth

Hey, after testing, out, I'm kinda pissed right now.
It seems like this shit just add both arg:

```output.txt
1 1
result: 2 
1 2
result: 3 
1 9 
result: 10 
 22 02
result: 24 
1000 1000
result: 2000 
1234 1234
result: 2468
```

Cvnt.
This just means `crazyMethButNegateArg2` is just 'arg1 - arg2'.
I'm severely pissed of.
This applies to all of the other function,
I only figure out the function purpose after experimenting with it.
Below is my take on this function before I realize this.

This is the most ubiquitous functions:

```crazyMeth.c
__int64 __fastcall crazyMeth(unsigned int a1, unsigned int a2)
{
  unsigned int v5; // [rsp+10h] [rbp-18h]
  char v6; // [rsp+14h] [rbp-14h]
  int v7; // [rsp+18h] [rbp-10h]
  int v8; // [rsp+1Ch] [rbp-Ch]
  __int64 v9; // [rsp+20h] [rbp-8h]

  v9 = 0LL;
  v5 = 0;
  v6 = 0;
  while ( a1 || a2 )
  {
    v7 = a1 & 1;
    v8 = a2 & 1;
    a1 >>= 1;
    a2 >>= 1;
    v9 += (v5 ^ v8 ^ v7) << v6;
    v5 = v5 & v7 | v8 & v7 | v5 & v8;
    ++v6;
  }
  return ((unsigned __int64)v5 << v6) + v9;
}
```

But, after analyzing, the main selling point is that a1 and a2 could affect the number of iteration.
We'll just have to see how many iterations needed to achieve this:

`res1 = (unsigned int)crazyMeth(tmp1, a3) % 0x10AE961;`
`res1 == 4139449`
`res1 == 0x3f29b9`
`res1 == 0b1111110010100110111001`

According to `crazyMeth`, this number is produced with 21 shifts, thus, 21 iteration.
Let's see here:

```crazyMeth.c
while ( a1 || a2 ) {
  a1 >>= 1;
  a2 >>= 1;
}
```

It mean that either arg1 or arg2 has the bit length of 21.
This applies to other calls of `crazyMeth` too.
From this functions, we can know the minimum number of bits required to represent each arguments, deduced from `resX` variables.

### Function: whileArg1OrArg2DoXor

After testing this out, this just `arg1 ^ arg2` ffs.
Below is my take on this function before I realize this.

`res6 == 1279714` comes from this function with arg1=`a3` and arg2=`crazyMeth(a4, a6)`.
The possible value for this case is '0x1CE628 * X + 1279714'.
1279714 in binary is 0b100111000011011100010, 21 bit long.

```whileArg1OrArg2DoXor.c
long long whileArg1OrArg2DoXor(unsigned int a1, unsigned int a2) {
  unsigned int v5; // [rsp+8h] [rbp-10h]
  int v6; // [rsp+Ch] [rbp-Ch]
  int v7; // [rsp+10h] [rbp-8h]
  int v8; // [rsp+14h] [rbp-4h]

  v5 = 0;
  v6 = 0;
  while ( a1 || a2 ) {
    v7 = a1 & 1;
    v8 = a2 & 1;
    a1 >>= 1;
    a2 >>= 1;
    v5 += (v8 ^ v7) << v6++;
  }
  return v5;
}
```

### Function: tillArg1Is0DoMath

Now that I tested it out, this function is just the equivalent of 'arg1 * arg2'.
God dang it.
Below is my take on this function before I realize this.

"add 0 by a2 with bit's index shift left if bit is 1 for bit in arg1"
The fact it can be explained briefly makes me relieved a bit.

```tillArg1Is0DoMath.c
long long tillArg1Is0DoMath(unsigned int a1, int a2) {
  unsigned int v4; // [rsp+Ch] [rbp-Ch]
  int v5; // [rsp+10h] [rbp-8h]

  v4 = 0;
  v5 = 0;
  while ( a1 ) {
    v4 += (a1 & 1) * (a2 << v5);
    a1 >>= 1;
    ++v5;
  }
  return v4;
}
```

What can be deduced from it?
It's hard to put into words.
Thankfully, it's only called twice and arg1 is hard coded: just `2u` and `3u`.
Both result get `crazyMethButNegateArg2`ed, then moduled by `(unsigned int)whileArg1OrArg2DoXor(a1, a4)` and ends in `res3 == 556569677`.

### Function: whileArg1OrArg2DoAnd

You know what, you've seen the trend already, *summarize* this shit.
Just guess it, you'll be correct, I'm sure:

```whileArg1OrArg2DoAnd.c
long long whileArg1OrArg2DoAnd(unsigned int a1, unsigned int a2) {
  unsigned int v5; // [rsp+8h] [rbp-10h]
  int v6; // [rsp+Ch] [rbp-Ch]
  int v7; // [rsp+10h] [rbp-8h]
  int v8; // [rsp+14h] [rbp-4h]

  v5 = 0;
  v6 = 0;
  while ( a1 || a2 ) {
    v7 = a1 & 1;
    v8 = a2 & 1;
    a1 >>= 1;
    a2 >>= 1;
    v5 += (v8 & v7) << v6++;
  }
  return v5;
}
```

...

It's just `arg1 & arg2`

## Get real

Tadaaa!

```check6Cardinals.c
_BOOL8 __fastcall check6Cardinals(
        unsigned int a1,
        unsigned int a2,
        unsigned int a3,
        unsigned int a4,
        unsigned int a5,
        unsigned int a6)
{
  unsigned int tmp1; // eax
  int tmp2; // ebx
  unsigned int tmp3; // eax
  unsigned int tmp4; // ebx
  unsigned int tmp5; // eax
  unsigned int tmp6; // eax
  unsigned int res1; // [rsp+20h] [rbp-30h]
  unsigned int res2; // [rsp+24h] [rbp-2Ch]
  unsigned int res3; // [rsp+28h] [rbp-28h]
  unsigned int res4; // [rsp+2Ch] [rbp-24h]
  unsigned int res5; // [rsp+30h] [rbp-20h]
  unsigned int res6; // [rsp+34h] [rbp-1Ch]
  unsigned int res7; // [rsp+38h] [rbp-18h]
  unsigned int res8; // [rsp+3Ch] [rbp-14h]

  if ( a1 <= 0x5F5E100 || a2 <= 0x5F5E100 || a3 <= 0x5F5E100 || a4 <= 0x5F5E100 || a5 <= 0x5F5E100 || a6 <= 0x5F5E100 )
    return 0LL;
  if ( a1 > 0x3B9AC9FF || a2 > 0x3B9AC9FF || a3 > 0x3B9AC9FF || a4 > 0x3B9AC9FF || a5 > 0x3B9AC9FF || a6 > 0x3B9AC9FF )
    return 0LL;
  tmp1 = a1 - a2;
  res1 = (unsigned int)(tmp1 + a3) % 0x10AE961;
  res2 = (unsigned int)(a1 + a2) % 0x1093A1D;
  tmp2 = 2u * a2;
  tmp3 = 3u * a1;
  tmp4 = tmp3 - tmp2;
  res3 = tmp4 % (unsigned int)(a1 ^ a4);
  tmp5 = a3 + a1;
  res4 = (unsigned int)(a2 & tmp5) % 0x6E22;
  res5 = (unsigned int)(a2 + a4) % a1;
  tmp6 = a4 + a6;
  res6 = (unsigned int)(a3 ^ tmp6) % 0x1CE628;
  res7 = (unsigned int)(a5 - a6) % 0x1172502;
  res8 = (unsigned int)(a5 + a6) % 0x2E16F83;
  return res1 == 4139449
      && res2 == 9166034
      && res3 == 556569677
      && res4 == 12734
      && res5 == 540591164
      && res6 == 1279714
      && res7 == 17026895
      && res8 == 23769303;
}
```

It's so simple, right?
I was just blabbering about LOL.
SUMMARIZE!

## Solving it

- `100000000 < a{1..6} <= 999999999`
- `4139449 == (unsigned int)(a1 - a2 + a3) % 0x10AE961`
- `9166034 == (unsigned int)(a1 + a2) % 0x1093A1D`
- `556569677 == (3 * a1 - 2 * a2) % (unsigned int)(a1 ^ a4)`
- `12734 == (unsigned int)(a2 & (a3 + a1)) % 0x6E22`
- `540591164 == (unsigned int)(a2 + a4) % a1`
- `1279714 == (unsigned int)(a3 ^ (a4 + a6)) % 0x1CE628`
- `17026895 == (unsigned int)(a5 - a6) % 0x1172502`
- `23769303 == (unsigned int)(a5 + a6) % 0x2E16F83`

I don't know.
`a5` is the least used (twice used), so it'll be the weak point.

Here's well be using `z3` in Python,
which allow use to solve (in)equations!

> ![NOTE]
> So I was stuck with an error,
> Dummy me took an hour to figure out that I just have some typo<br>

`solve.py`:

```solve.py
from z3 import *

a = BitVec('a', 64)
b = BitVec('b', 64)
c = BitVec('c', 64)
d = BitVec('d', 64)
e = BitVec('e', 64)
f = BitVec('f', 64)

solve(
    100000000 < a,
    a <= 999999999,
    100000000 < b,
    b <= 999999999,
    100000000 < c,
    c <= 999999999,
    100000000 < d,
    d <= 999999999,
    100000000 < e,
    e <= 999999999,
    100000000 < f,
    f <= 99999999,
    4139449 == (a - b + c) % 0x10ae961,
    4139449 == urem((a - b + c), 0x10ae961),
    9166034 == urem((a + b), 0x1093a1d),
    556569677 == (3 * a - 2 * b) % (a ^ d),
    12734 == urem((b & (c + a)), 0x6e22),
    540591164 == urem((b + d), a),
    1279714 == urem((c ^ (d + f)), 0x1ce628),
    17026895 == urem((e - f), 0x1172502),
    23769303 == urem((e + f), 0x2e16f8),
)
```
```
$ python3 solve.py
[d = 465893239,
 c = 341222189,
 a = 705965527,
 b = 780663452,
 f = 217433792,
 e = 966221407]
```

Thank god, please be correct !!

`printFlag.py`:

```printFlag.py
answer = [
    705965527,
    780663452,
    341222189,
    465893239,
    966221407,
    217433792
]

for ans in answer:
    print(format(ans, 'x'),end='')
```
```
$ python3 printFlag.py
2a142dd72e87fa9c1456a32d1bc4f77739975e5fcf5c6c0
```

It's correct!
YEAY!

FLAG: `uiuctf{2a142dd72e87fa9c1456a32d1bc4f77739975e5fcf5c6c0}`

Sowwy, this Write-up isn't the most structured, but the fact that I wrote it as I go, without deleting much, kinda shows exactly how I solve this challenge.

Overall, good challenge, hardest Rev I've solved, yet. duh.
