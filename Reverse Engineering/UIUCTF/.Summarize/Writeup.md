# Summarize Writeup by Deffreus - UIUCTF 2024

```$ file summarize
summarize: ELF 64-bit LSB executable, x86-64, version 1 (SYSV), dynamically linked, interpreter /lib64/ld-linux-x86-64.so.2, BuildID[sha1]=a5c907b4b408b4a5c7b504432506d90a407886fb, for GNU/Linux 3.2.0, stripped
```
```$ du -h summarize
16K	summarize
```

I need to find 6 numbers to be the input to this program.
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

### Function: whileArg1OrArg2DoXor

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

After testing this out, this just `arg1 ^ arg2` ffs.

### Function: tillArg1Is0DoMath

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
Now that I tested it out, this function is just the equivalent of 'arg1 * arg2'.
God dang it.

### Function: whileArg1OrArg2DoAnd

You know what, you've seen the trend already, summarize this shit.
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

### Claude <3

Well, let my trusty Claude do some work:

#### Me:

$(a5 - a6) % 17891586 == 17026895$
$(a5 + a6) % 48498563 == 23769303$
Is there any way I can 'add' these equation, as a6 - a6 basically cancel it?

#### Claude:

Absolutely! Your insight about adding these equations is a great approach. Let's work through this:

1. We have: $(a5 - a6) % 17891586 == 17026895 (a5 + a6) % 48498563 == 23769303$
2. While we can't directly add modular equations with different moduli, we can still use this approach to eliminate a6 and get information about a5. Let's start by considering these equations without the modulo operation: $a5 - a6 = 17026895 + 17891586k (where k is some integer)$<br>$a5 + a6 = 23769303 + 48498563m (where m is some integer)$
3. Now, let's add these equations: $2a5 = (17026895 + 17891586k) + (23769303 + 48498563m)$<br>$2a5 = 40796198 + 17891586k + 48498563m$
4. Dividing both sides by 2: $a5 = 20398099 + 8945793k + 24249281.5m$
5. Since $a5$ must be an integer, $24249281.5m$ must be an integer. This is only possible if $m$ is even. Let's say $m = 2n$. Then: $a5 = 20398099 + 8945793k + 48498563n$
6. Remember, we know that $100000000 < a5 <= 999999999$
7. The smallest possible value for $a5$ is when $k = n = 0$, which gives: $a5 = 20398099$
8. This is too small, so we need to increase k and n until we get into the correct range.
9. After some trial and error (or using a simple program), we find that: When $k = 9$ and $n = 0$, $a5 = 20398099 + 8945793 * 9 = 100910136$

This value of a5 satisfies both the original equations and the constraint of being a 9-digit number.

To find a6, we can substitute this value of a5 back into either of the original equations. Let's use the first one:

$(100910136 - a6) % 17891586 == 17026895

Solving this, we get:

$a6 = 83883241$

You can verify that these values of a5 and a6 satisfy both original equations:

$(100910136 - 83883241) % 17891586 == 17026895$
$(100910136 + 83883241) % 48498563 == 23769303$

So, we've successfully found:

$a5 = 100910136$
$a6 = 83883241$

This demonstrates how combining equations can sometimes lead to a solution, even in modular arithmetic. For the remaining equations, similar techniques or computational methods would be needed to find the values of a1 through a4.

#### Stepping back...

Claude's answer isn't right, so he's done here.

### Z3 ?!

Yes please work I'm desperate now.
Dummy me took an hour to figure out that I mistyped twice T-T

```solve.py
from z3 import *

a = bitvec('a', 64)
b = bitvec('b', 64)
c = bitvec('c', 64)
d = bitvec('d', 64)
e = bitvec('e', 64)
f = bitvec('f', 64)

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
```$ python3 solve.py
[d = 465893239,
 c = 341222189,
 a = 705965527,
 b = 780663452,
 f = 217433792,
 e = 966221407]
```

Thank god, please be correct !!

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
```$ python3 printFlag.py
2a142dd72e87fa9c1456a32d1bc4f77739975e5fcf5c6c0
```

It's correct!
YEAY!
The flag is: `uiuctf{2a142dd72e87fa9c1456a32d1bc4f77739975e5fcf5c6c0}`

Sowwy, this Write-up isn't the most structured, but the fact that I wrote it as I go, without deleting much, kinda shows exactly how I solve this challenge.

Overall, good challenge, hardest Rev I've solved, yet.
