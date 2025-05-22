# Equivalent Exchange Writeup by Deffreus - CompfestCTF 16

###### Author: Zanark

## Description

You give me key, I give you flag

nc challenges.ctf.compfest.id 9011

[chall](https://ctf.compfest.id/files/00b40b14f157bbd4c144da43c1d195bf/chall?token=eyJ1c2VyX2lkIjo3MiwidGVhbV9pZCI6MzA3LCJmaWxlX2lkIjo3MH0.ZtJ5Rw.StiCN3ApSajc9hAJemT63-FBgQA)

## Files

```
$ file chall 
chall: ELF 64-bit LSB pie executable, x86-64, version 1 (SYSV), dynamically linked, interpreter /lib64/ld-linux-x86-64.so.2, BuildID[sha1]=8cc90daa151a576d3688e70f5a2308bd1570c17d, for GNU/Linux 3.2.0, not stripped
```



## Solution

[Dogbolt]()

From the decompiled source code,
there's a check function for each key!

The key is a long interger (`%ld`), or 32-bit.

```
if ( check1(v4) && check2(v4, v5) && check3(v6) && check4(v6, v7) )
  {
    stream = fopen("flag.txt", "r");
    fgets(s, 64, stream);
    printf("Thanks for the keys! Here's your flag as promised: %s\n", s);
    return 0;
  }
  else
  {
    puts("Those aren't valid keys! >:(");
    return 1;
  }

```

Let's see each function:

### check1

```
bool __fastcall check1(unsigned __int64 a1) {
  int v3; // [rsp+14h] [rbp-4h]

  v3 = 0;
  while ( a1 )
  {
    ++v3;
    a1 /= 0xAuLL; // 10
  }
  return v3 > 15;
}
```

`key1` must be divisible by 10 for more than 15 times,
in other words, it has 16 digits.

### check2

```
bool __fastcall check2(unsigned __int64 a1, unsigned __int64 a2) {
  unsigned __int64 v3; // [rsp+0h] [rbp-20h]
  int v5; // [rsp+10h] [rbp-10h]
  int v6; // [rsp+14h] [rbp-Ch]
  unsigned __int64 i; // [rsp+18h] [rbp-8h]

  v3 = a2;
  if ( !a2 )
    return 0;
  v5 = 0;
  for ( i = a2; i; i >>= 2 )
    v5 += i & 1;
  if ( v5 <= 6 )
    return 0;
  v6 = 0;
  while ( a1 ) {
    v6 += a1 % 0xA;
    a1 /= 0xAuLL;
  }
  while ( v3 ) {
    v6 -= v3 % 0xA;
    v3 /= 0xAuLL;
  }
  return v6 == 105;
}

```

`key2` must not be `0`.
`key2` is divided by 4 until it's `0`, and the number of iteration is added if each `key2` is odd. 
`key2` is at least $4^7$.
digits of `key1` are summed into `v6`.
then, `v6` is reduced by the sums of the digits of  `key2`.
`v6` must be `105`.

A value that pass the check is `17749`, with digit sum `28`.

### key1 & key2

```
>>> def sd(x):
...     while x:
...             res += x % 10
...             x /= 10
...     return res
... 
>>> sd(17749)
Traceback (most recent call last):
  File "<stdin>", line 1, in <module>
  File "<stdin>", line 3, in sd
UnboundLocalError: cannot access local variable 'res' where it is not associated with a value
>>> def sd(x):
...     res = 0
...     while x:
...             res += x % 10
...             x /= 10
...     return res
... 
>>> sd(17749)
31.11111111111121
>>> def sd(x):
...     res = 0
...     while x:
...             res += x % 10
...             x //= 10
...     return res
... 
>>> sd(17749)
28
>>> sd(9999999999999999)
144
>>> sd(9999999999999999) - sd(17749)
116
>>> sd(9999999999999991) - sd(17749)
108
>>> sd(9999999999999971) - sd(17749)
106
>>> sd(9999999999999961) - sd(17749)
105
>>> 
```

### check3

```
bool __fastcall check3(__int64 a1) {
  unsigned __int64 v2; // [rsp+0h] [rbp-38h]
  char v3; // [rsp+10h] [rbp-28h]
  int v4; // [rsp+14h] [rbp-24h]
  unsigned __int64 v5; // [rsp+18h] [rbp-20h]
  unsigned __int64 v6; // [rsp+20h] [rbp-18h]

  v2 = a1;
  if ( a1 >= 0 )
    return 0;
  v5 = 0LL;
  while ( v2 ) {
    v4 = v2 & 1;
    v2 >>= 1;
    v6 = v5;
    v3 = 0;
    while ( v6 ) {
      ++v3;
      v6 >>= 1;
    }
    v5 |= (__int64)v4 << v3;
  }
  return a1 == v5;
}

```

`key3` must be negative.
this function basically reverses the bit, and check if it's still the same.
`-1` should pass this.
From testing, `v5` is always `-1`.
Idk why?

### check4

```
bool __fastcall check4(unsigned __int64 a1, unsigned __int64 a2) {
  unsigned __int64 v3; // rax
  unsigned __int64 i; // [rsp+18h] [rbp-8h]

  if ( (a2 & 1) == 0 || a2 == 1 )
    return 0;
  v3 = a1;
  if ( a2 <= a1 )
    v3 = a2;
  for ( i = v3; i && (a1 % i || a2 % i); --i )
    ;
  return i == 1;
}
```

`key4` must be odd and is not `1`.
The function is checking if key3 and key4 are coprime (their greatest common divisor is 1).
Keep in mind that both keys here is unsigned,
so there's no negative.
`-1` -> `4294967295`.

| i | a1 % i | a2 % i |
| --- | --- | --- |
| 7 | 3 | 0 |
| 6 | 3 |  |
| 5 | 0 | 2 |
| 4

## Payload


FLAG: `COMPFEST16{jUsT_s0m3_s1mpl3_op3rAti0n5_ecac5ed827}`