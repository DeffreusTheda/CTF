# jmp flag Writeup by Deffreus - DownUnderCTF 2024

```$ file jmp_flag 
jmp_flag: ELF 64-bit LSB pie executable, x86-64, version 1 (SYSV), dynamically linked, interpreter /lib64/ld-linux-x86-64.so.2, BuildID[sha1]=27fc75a630e88cc3ded269794b4db7c54f9b6615, for GNU/Linux 3.2.0, stripped
```
```$ du -h jmp_flag
36K	jmp_flag
```

[Decompiler Explorer](https://dogbolt.org/?id=7584071c-42e6-46d8-a4ea-6a1a69ff6973)

A comprehensible `main`, thank god.

```jmp_flag.c
__int64 __fastcall main(int a1, char **a2, char **a3)
{
  int i; // [rsp+Ch] [rbp-54h]
  __int64 v5[8]; // [rsp+10h] [rbp-50h] BYREF
  char v6; // [rsp+50h] [rbp-10h]
  unsigned __int64 v7; // [rsp+58h] [rbp-8h]

  v7 = __readfsqword(0x28u);
  memset(v5, 0, sizeof(v5));
  v6 = 0;
  __isoc99_scanf("%64s", v5);
  for ( i = 0; i <= 63; ++i )
    sub_1280(*((_BYTE *)v5 + i));
  if ( sub_1200() )
    printf("Correct! DUCTF{%s}\n", (const char *)v5);
  else
    puts("Incorrect!");
  return 0LL;
}
```


`sub_1280` is surely something I never seen before.

```jmp_flag.c
void __fastcall sub_1280(char a1)
{
  __asm { jmp     rax }
}
```

You can do that, for real?
So, what is `rax` again?

"It's just using a scratch reg to load a stack arg. RAX is the go-to choice for a scratch reg."

By convention, the `rax` register is used to store the return value of a function.

Now, when `main` call `sub_1280`, it'll jump to `rax` as if it's a memory address.

I think we could control the jumps with our input, a 64 byte input to be exact.
There are a lot of `sub_XXXX` functions above the `main` function, 
