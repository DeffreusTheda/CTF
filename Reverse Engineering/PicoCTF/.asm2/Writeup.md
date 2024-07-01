# asm2 Writeup by Deffreus - PicoCTF 2019

What does asm2(0xb,0x2e) return?

Inputs are read starting from the last (second argument first):

```
	<+6>:	mov    eax,DWORD PTR [ebp+0xc] ; read()
	<+9>:	mov    DWORD PTR [ebp-0x4],eax ; arg2 = 0x2e
	<+12>:	mov    eax,DWORD PTR [ebp+0x8] ; read()
	<+15>:	mov    DWORD PTR [ebp-0x8],eax ; arg1 = 0xb
```

It then do a 'while ebp-0x8 <= 0x63f3', with 'add 1 to ebp-0x4' and 'ebp-0x8 -= 0xffffff80.'

```
	<+18>:	jmp    0x509 <asm2+28> ; jump
	<+20>:	add    DWORD PTR [ebp-0x4],0x1 ; ++arg2
	<+24>:	sub    DWORD PTR [ebp-0x8],0xffffff80 ; arg1 -= -128
	<+28>:	cmp    DWORD PTR [ebp-0x8],0x63f3 ; arg1 <= 0x63f3
	<+35>:	jle    0x501 <asm2+20> ; ? continue : jmp
```

According to two's complement, `0xffffff80` holds the value `-128`, which means the instruction above equals to `ebp-0x8 -= -128`, or in other word, `ebp-0x8 += 128`.

After breaking out of the while, it return the value of `ebp-0x4`:

```
	<+37>:	mov    eax,DWORD PTR [ebp-0x4]
	<+40>:	leave  
	<+41>:	ret    
```

To get how many iteration needed, we can use the formula `(0x6363 - 0xb) / 128 + 1` is around 199.6875, and rounding it up, it's 200.
Seems promising!
Now just add that with what we started with, `0x2e`, we got the number 246, or 0xf6 in hex.

So, the flag is `0xf6`
