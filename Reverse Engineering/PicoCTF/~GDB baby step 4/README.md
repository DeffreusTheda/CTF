# GDB baby step 4 Writeup by Deffreus - PicoCTF picoGym Exclusive

###### Author: LT 'syreal' Jones

## Description

`main` calls a function that multiplies `eax` by a constant. The flag for this challenge is that constant in decimal base. If the constant you find is 0x1000, the flag will be `picoCTF{4096}`.<br>
Debug [this](https://artifacts.picoctf.net/c/532/debugger0_d).

## Files

```
$ file debugger0_d 
debugger0_d: ELF 64-bit LSB executable, x86-64, version 1 (SYSV), dynamically linked, interpreter /lib64/ld-linux-x86-64.so.2, BuildID[sha1]=96ad8d8a802a567a7a1a27cf9b7231e2f7fa15f7, for GNU/Linux 3.2.0, not stripped

$ du -h debugger0_d
16K	debugger0_d
```

## Solution


```
$ gdb-multiarch debugger0_d 
GNU gdb (Debian 13.2-1+b2) 13.2
Copyright (C) 2023 Free Software Foundation, Inc.
License GPLv3+: GNU GPL version 3 or later <http://gnu.org/licenses/gpl.html>
This is free software: you are free to change and redistribute it.
There is NO WARRANTY, to the extent permitted by law.
Type "show copying" and "show warranty" for details.
This GDB was configured as "aarch64-linux-gnu".
Type "show configuration" for configuration details.
For bug reporting instructions, please see:
<https://www.gnu.org/software/gdb/bugs/>.
Find the GDB manual and other documentation resources online at:
    <http://www.gnu.org/software/gdb/documentation/>.

For help, type "help".
Type "apropos word" to search for commands related to "word"...
GEF for linux ready, type `gef' to start, `gef config' to configure
93 commands loaded and 5 functions added for GDB 13.2 in 0.00ms using Python engine 3.12
Reading symbols from debugger0_d...
(No debugging symbols found in debugger0_d)                                                                                                  
gef➤  disas main
Dump of assembler code for function main:
   0x000000000040111c <+0>:	endbr64
   0x0000000000401120 <+4>:	push   rbp
   0x0000000000401121 <+5>:	mov    rbp,rsp
   0x0000000000401124 <+8>:	sub    rsp,0x20
   0x0000000000401128 <+12>:	mov    DWORD PTR [rbp-0x14],edi
   0x000000000040112b <+15>:	mov    QWORD PTR [rbp-0x20],rsi
   0x000000000040112f <+19>:	mov    DWORD PTR [rbp-0x4],0x28e
   0x0000000000401136 <+26>:	mov    DWORD PTR [rbp-0x8],0x0
   0x000000000040113d <+33>:	mov    eax,DWORD PTR [rbp-0x4]
   0x0000000000401140 <+36>:	mov    edi,eax
   0x0000000000401142 <+38>:	call   0x401106 <func1>
   0x0000000000401147 <+43>:	mov    DWORD PTR [rbp-0x8],eax
   0x000000000040114a <+46>:	mov    eax,DWORD PTR [rbp-0x4]
   0x000000000040114d <+49>:	leave
   0x000000000040114e <+50>:	ret
End of assembler dump.
gef➤  disas func1
Dump of assembler code for function func1:
   0x0000000000401106 <+0>:	endbr64
   0x000000000040110a <+4>:	push   rbp
   0x000000000040110b <+5>:	mov    rbp,rsp
   0x000000000040110e <+8>:	mov    DWORD PTR [rbp-0x4],edi
   0x0000000000401111 <+11>:	mov    eax,DWORD PTR [rbp-0x4]
   0x0000000000401114 <+14>:	imul   eax,eax,0x3269
   0x000000000040111a <+20>:	pop    rbp
   0x000000000040111b <+21>:	ret
End of assembler dump.
gef➤  
```

There!
`0x0000000000401114 <+14>:	imul   eax,eax,0x3269`!
The constant is `0x3269`, or 12905 in decimals!
I know, the flag is `picoCTF{12905}`!

Flag: `picoCTF{12905}`
