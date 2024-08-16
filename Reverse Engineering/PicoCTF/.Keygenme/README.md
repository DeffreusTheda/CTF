# Keygenme Writeup by Deffreus - PicoCTF 2022

```$ file keygenme 
keygenme: ELF 64-bit LSB pie executable, x86-64, version 1 (SYSV), dynamically linked, interpreter /lib64/ld-linux-x86-64.so.2, BuildID[sha1]=5ca9150c0fe861829a16033b7398e52e1e1b97af, for GNU/Linux 3.2.0, stripped
```
```$ du -h keygenme 
16K	keygenme
```

After decompiling it with [Decompiler Explorer](https://dogbolt.org/?id=2ff90bc8-1580-49a6-be1c-2d1650fd225a#Hex-Rays=273)/Hex-Rays into C, I got the `main` function as the following:

```keygenme.c
long long main(int a1, char **a2, char **a3) {
  char s[40]; // [rsp+10h] [rbp-30h] BYREF
  unsigned long long v5; // [rsp+38h] [rbp-8h]

  v5 = __readfsqword(0x28u);
  printf("Enter your license key: ");
  fgets(s, 37, stdin);
  if ( (u_int8)sub_1209(s) )
    puts("That key is valid.");
  else
    puts("That key is invalid.");
  return 0LL;
}
```

From `fgets(s, 37, stdin)` we can know that we need to input a string with length at most 36 characters with a newline character in the end.
This input is then used for `sub_1209(s)` and I need to make it return a long long value evaluated as true.

```keygenme.c
long long sub_1209(const char *a1) {
  size_t v1; // rax
  size_t v2; // rax
  int v4; // [rsp+18h] [rbp-C8h]
  int v5; // [rsp+18h] [rbp-C8h]
  int i; // [rsp+1Ch] [rbp-C4h]
  int j; // [rsp+20h] [rbp-C0h]
  int k; // [rsp+24h] [rbp-BCh]
  int m; // [rsp+28h] [rbp-B8h]
  char v10[18]; // [rsp+2Eh] [rbp-B2h] BYREF
  char v11[16]; // [rsp+40h] [rbp-A0h] BYREF
  char s[61]; // [rsp+50h] [rbp-90h] BYREF
  char v13; // [rsp+8Dh] [rbp-53h]
  char v14[72]; // [rsp+90h] [rbp-50h] BYREF
  unsigned long long v15; // [rsp+D8h] [rbp-8h]

  v15 = __readfsqword(0x28u);
  strcpy(s, "picoCTF{br1ng_y0ur_0wn_k3y_");
  strcpy(v10, "}");
  v1 = strlen(s);
  MD5(s, v1, &v10[2]);
  v2 = strlen(v10);
  MD5(v10, v2, v11);
  v4 = 0;
  for ( i = 0; i <= 15; ++i )
  {
    sprintf(&s[v4 + 32], "%02x", (unsigned __int8)v10[i + 2]);
    v4 += 2;
  }
  v5 = 0;
  for ( j = 0; j <= 15; ++j )
  {
    sprintf(&v14[v5], "%02x", (unsigned __int8)v11[j]);
    v5 += 2;
  }
  for ( k = 0; k <= 26; ++k )
    v14[k + 32] = s[k];
  v14[59] = s[45];
  v14[60] = s[50];
  v14[61] = v13;
  v14[62] = s[33];
  v14[63] = s[46];
  v14[64] = s[56];
  v14[65] = s[58];
  v14[66] = v13;
  v14[67] = v10[0];
  if ( strlen(a1) != 36 )
    return 0LL;
  for ( m = 0; m <= 35; ++m )
  {
    if ( a1[m] != v14[m + 32] )
      return 0LL;
  }
  return 1LL;
}
```

I used Hex-Rays, but it haven't able to decompile `MD5()`. Other decompiler such as Ghidra does it but it doesn't seem right, like this:

```keygenme.c
// WARNING: Unknown calling convention -- yet parameter storage is locked

uchar * MD5(uchar *d,size_t n,uchar *md) {
  uchar *puVar1;
  
  puVar1 = MD5(d,n,md);
  return puVar1;
}
```

I'm thinking...
I tried `gdb keygenme` but there's no debugging symbols on the binary.
Plus, the binary is compiled for x86_64 whereas my machine now is aarch64,
so no way I can run it.
What left is to just replicate `sub_1209` and tries to get the correct flag through testing.

There are a few hints:
`char v10[18], char v11[16];` which shows the size of `v10` and `v11`.
MD5 produce a 128-bit hash value, which is 16 byte or 16 characters.
The syntax of `MD5(s, strlen(s), &v10[2]);` (and `MD5(v10, strlen(v10), v11);`) indicate it MD5 the first `strlen(s)` characters from `s` and put the 16 byte into `&v10[2]`.
`v10` has size `18` and it's first index has the character '}', this left space for 16 characters when you exclude the null terminator `\0` at the end of the string at index 1 (second character).
`MD5(s, v1, &v10[2])` seems to fill up that space, thanks to the pointer.
This function should be the same as the standard MD5, so I hardcoded the MD5 of `"picoCTF{br1ng_y0ur_0wn_k3y_"` and `"}"`.

```sub_1209.c
long long sub_1209(const char *a1) {
  char v13;
  char v14[72];

  char s[61]; strcpy(s, "picoCTF{br1ng_y0ur_0wn_k3y_");
  size_t v1 = strlen(s); printf("strlen(s): %d\n", v1);
	/* MD5 from 'picoCTF{br1ng_y0ur_0wn_k3y_' */
	char v10[18] = {125, 0, 67, 130, 24, 213, 114, 233, 1, 98, 208, 152, 28, 187, 199, 212, 56, 130}; // strcpy(v10, "}"); MD5(s, v1, &v10[2]);
  size_t v2 = strlen(v10); printf("strlen(v10): %d\n", v2);
	/* MD5 from '}' */
  char v11[16] = {203, 177, 132, 221, 142, 5, 201, 112, 158, 93, 202, 237, 170, 4, 149, 207}; // MD5(v10, v2, v11);

  int v4 = 0;
  for ( int i = 0; i <= 15; ++i ) {
    sprintf(&s[v4 + 32], "%02x", (unsigned short)v10[i + 2]);
    v4 += 2;
  }
  int v5 = 0;
  for ( int i = 0; i <= 15; ++i ) {
    sprintf(&v14[v5], "%02x", (unsigned short)v11[i]);
    v5 += 2;
  }
  for ( int i = 0; i <= 26; ++i )
    v14[i + 32] = s[i];
  v14[59] = s[45];
  v14[60] = s[50];
  v14[61] = v13;
  v14[62] = s[33];
  v14[63] = s[46];
  v14[64] = s[56];
  v14[65] = s[58];
  v14[66] = v13;
  v14[67] = v10[0];

	// for ( int i = 0; i < strlen(v14); ++i )
	// 	printf("s[%d]=%c\n", i, v14[i]);

	long long res = 1LL;
  if ( strlen(a1) != 36 )
    res = 0LL;
  for ( int i = 0; i <= 35; ++i ) {
    if ( a1[i] != v14[i + 32] ) {
      res = 0LL;
			printf("<%d>", v14[i + 32]);
			continue;
		}
		printf("%c", v14[i + 32]);
  }
  return res;
}
```

```$ rgcc sub_1209.c 
strlen(s): 27
strlen(v10): 1
picoCTF{br1ng_y0ur_0wn_k3y_19<0>36cd<0>}
1
```

I set `a1` with the string I got from testing,
but what's left is `v13`.
These are all the mentions of `v13`:

```sub_1209.c
  char v13;
  v14[61] = v13;
  v14[66] = v13;
```

Absolutely no initialization,
so it's value is just 0.
You know what?
This dumb but I just brute-force it.
I got the flag in the end and it's `picoCTF{br1ng_y0ur_0wn_k3y_19836cd8}`.
