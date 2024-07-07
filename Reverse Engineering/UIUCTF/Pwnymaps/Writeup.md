# Pwnymaps Writeup by Deffreus - UIUCTF 2024

```$ file pwnymaps 
pwnymaps: ELF 64-bit LSB pie executable, x86-64, version 1 (SYSV), dynamically linked, interpreter /lib64/ld-linux-x86-64.so.2, BuildID[sha1]=539e9bb59c649a18d6dc41343004cb0fbb68a56f, for GNU/Linux 3.2.0, not stripped
```
```$ du -h pwnymaps 
28K	pwnymaps
```

Let's try with [Decompiler Explorer](https://dogbolt.org/?id=d0b2bcd3-e9d2-4798-bd07-1c8a4167ddca#Ghidra=531).
There's 27 local variables in main.
And quite a handful of custom functions that recurse to other custom functions.

`puts("You have reached your destination. PWNYMAPS does not support route plotting yet.");`

This line is our target.
To get here, we need to pass this check: `if ( v14 )`.
It's value is gained from:

```pwnymaps.c
v14 = correct_checksums[k] == (unsigned int)hash(v21)
```

Hey, how does the value of `v21` produced?
A line with 349 characters is needed, apparently.
That'll be a pain in the head.

First input is an unsigned int, '-1 < x < 0x201'.
Okay you know what, I'll make the decompiled code more beautiful.

One night later...

## input

### Constraint

First, the program take an unsigned integer input and use it:

```pwnymaps.c
__isoc99_scanf("%u", &v9);
getchar();
if ( (unsigned int)v9 > 0x200 ) {
  goto FAIL;
}
```

`0x200` is equal to 512, and because it's an unsigned int, we can input a number for `v9` from 0 to 512.

`0 <= v9 <= 512`

It then iterate this code for `v9` times:

```pwnymaps.c
printf("Indicate your 'Earth'-type coordinate %x {{hintText.toUpperCase()}}: ", k);
__isoc99_scanf("%u%u", &v10, &v11);
getchar();
if ( v11 > 0xFFFFFFF )
  goto FAIL;
v19 = v10 >> 8;
v6 = (16 * v10) & 0xFF0 | (v11 >> 28);
v7 = HIWORD(v11) & 0xFFF;
v8 = EncodeMorton_12bit((unsigned __int16)v11 >> 10, (v11 >> 4) & 0x3F);
v20 = EncodeMorton_24bit(v8, v7);
v24 = EncodeMorton_48bit(v19, v7);
v25 = (v24 << 12) | v6;
v26[8 * k]     = Unpad64Bit_8Bit(v25);
v26[8 * k + 1] = Unpad64Bit_8Bit(v25 >> 1);
v26[8 * k + 2] = Unpad64Bit_8Bit(v25 >> 2);
v26[8 * k + 3] = Unpad64Bit_8Bit(v25 >> 3);
v26[8 * k + 4] = Unpad64Bit_8Bit(v25 >> 4);
v26[8 * k + 5] = Unpad64Bit_8Bit(v25 >> 5);
v26[8 * k + 6] = Unpad64Bit_8Bit(v25 >> 6);
v26[8 * k + 7] = Unpad64Bit_8Bit(v25 >> 7);
//: Swap +1 with +5
v5 = v26[8 * k + 1];
v26[8 * k + 1] = v26[8 * k + 5];
v26[8 * k + 5] = v5;
v21 = numberOfSetBits((unsigned __int16)((((unsigned __int8)v26[8 * k + 4] << 8) | (unsigned __int8)v26[8 * k + 5]) ^ (((unsigned __int8)v26[8 * k + 2] << 8) | (unsigned __int8)v26[8 * k + 3]) ^ ((unsigned __int8)v26[8 * k + 1] | ((unsigned __int8)v26[8 * k] << 8)) ^ (((unsigned __int8)v26[8 * k + 6] << 8) | (unsigned __int8)v26[8 * k + 7])));
v3 = correct_checksums[k];
v14 = v3 == (unsigned int)hash(v21);
```

This thing asks for two as unsigned integer as input.
The maximum value for `v11` is 268435455, as one number above it will make the expression `(v11 >> 28)` not evaluate to `0`.
These two unsigned integers are the X and Y coordinate that we guess equal to a certain Z values.

## Morton Encoding

Hey, I think I should learn something about this `EncodeMorton` functions.

The process of Morton Encoding include converting the X and Y coordinate to binary and then interleave both of it.

Interleaving can be as simple as this:

```
x = 100101  =  1 0 0 1 0 1
y = 010101  = 0 1 0 1 0 1

interleaved = 011000110011
```

The code checks if the coordinates that we've supplied correspond to predetermined Z-value coordinates.

```pwnymaps.c
for ( ii = 0; ii < v9; ++ii ) {
      v22 = EncodeMorton_9x7bit(
              v26[8 * ii] & 0x7F,
              v26[8 * (ii % v9) + 1] & 0x7F,
              v26[8 * (ii % v9) + 2] & 0x7F,
              v26[8 * (ii % v9) + 3] & 0x7F,
              v26[8 * (ii % v9) + 4] & 0x7F,
              v26[8 * (ii % v9) + 5] & 0x7F,
              v26[8 * (ii % v9) + 6] & 0x7F,
              v26[8 * (ii % v9) + 7] & 0x7F,
              ((int)(unsigned __int8)v26[8 * ii + 6] >> 6) & 2 | ((int)(unsigned __int8)v26[8 * ii + 5] >> 5) & 4 | ((int)(unsigned __int8)v26[8 * ii + 4] >> 4) & 8 | ((int)(unsigned __int8)v26[8 * ii + 3] >> 3) & 0x10 | ((int)(unsigned __int8)v26[8 * ii + 2] >> 2) & 0x20 | ((int)(unsigned __int8)v26[8 * ii + 1] >> 1) & 0x40u | ((unsigned __int8)v26[8 * ii + 7] >> 7));
      v23 = (unsigned __int8)v26[8 * ii] >> 7;
      v22 |= v23 << 63;
      if ( v22 != correct[ii] )
        goto FAIL;
    }
    puts("You have reached your destination. PWNYMAPS does not support route plotting yet.");
    return 0;
```

But, there's a catch, as with any other CTFs.
Seems like the custom `EncodeMorton` and `PadXBit` functions always use `|`, not similar to interleaving bits.
For example:

```pwnymaps.c
  v4 = Pad16Bit(a1);
  v5 = (2 * Pad16Bit(a2)) | v4;
  v6 = (4 * Pad16Bit(a3)) | v5;
  return v6 | (8 * Pad16Bit(a4));
```

I don't think it would work that way.
But if the result IS Morton encoding, so the `PadXBit` functions may have the answer for this.
Seems like just guessing by the name `PadXBit` isn't enough.

```pwnymaps.c
__int64 __fastcall Pad16Bit(unsigned __int16 a1) {
  unsigned __int64 v2; // [rsp+Ch] [rbp-8h]

  v2 = a1 & 3 | ((unsigned __int64)a1 << 32) & 0x80000000003LL | (((a1 | ((unsigned __int64)a1 << 32)) & 0xF800000007FFLL) << 16) & 0x80000400003LL | ((a1 & 0x3F | ((unsigned __int64)a1 << 32) & 0xF8000000003FLL | (((a1 | ((unsigned __int64)a1 << 32)) & 0xF800000007FFLL) << 16) & 0xF80007C0003FLL) << 8) & 0x40080300400803LL | (16 * (a1 & 7 | ((unsigned __int64)a1 << 32) & 0x380000000007LL | (((a1 | ((unsigned __int64)a1 << 32)) & 0xF800000007FFLL) << 16) & 0x380000C00007LL | ((a1 & 0x3F | ((unsigned __int64)a1 << 32) & 0xF8000000003FLL | (((a1 | ((unsigned __int64)a1 << 32)) & 0xF800000007FFLL) << 16) & 0xF80007C0003FLL) << 8) & 0xC0380700C03807LL)) & 0x843084308430843LL;
  return (v2 | (4 * v2)) & 0x101010101010101LL | (2 * ((v2 | (4 * v2)) & 0x909090909090909LL)) & 0x1111111111111111LL;
}
```

Ugh, looking at this makes me sick.
Let's make it prettier!

```pwnymaps.c
unsigned __int64 __fastcall Pad7Bit(char a1) {
	return a1
		& 1
		| (
				(unsigned __int64) (
					a1
					& 0x7F
				)
				<< 32
			)
		& 0x1000000001LL
		| (
				(
					a1
					& 0xF
					| (
							(unsigned __int64) (
								a1
								& 0x7F
							)
							<< 32
						)
					& 0x700000000FLL
				)
				<< 16
			)
		& 0x40001000040001LL
		| (
				(
					a1
					& 3
					| (
							(unsigned __int64) (
								a1
								& 0x7F
							)
							<< 32
						)
					& 0x3000000003LL
					| (
							(
								a1
								& 0xF
								| (
										(unsigned __int64) (
											a1
											& 0x7F
										)
										<< 32
									)
								& 0x700000000FLL
							)
							<< 16
						)
					& 0x400030000C0003LL
				)
				<< 8
			)
		& 0x40201008040201LL;
}
```

At least now you can dissect it better.
Sometimes, testing a function out is the best way to learn about it (looking at u Summarize).


