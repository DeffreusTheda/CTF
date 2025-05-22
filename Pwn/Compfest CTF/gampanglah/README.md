# gampanglah Writeup by Deffreus - CompfestCTF 16

###### Author: tipsen

## Description

should be an easy challenge i guess?

`nc challenges.ctf.compfest.id 9006`

## Files

[chall](https://ctf.compfest.id/files/602619ac50902d620d496524a0ef0409/chall?token=eyJ1c2VyX2lkIjo3MiwidGVhbV9pZCI6MzA3LCJmaWxlX2lkIjo5N30.ZtLiFA.6AiIAHHzECHXdXufd7t3czcXEc4):                ELF 64-bit LSB executable, x86-64, version 1 (SYSV), dynamically linked, interpreter /lib64/ld-linux-x86-64.so.2, BuildID[sha1]=0c5cd91e4abf049545e2ff4b77afaab003ca1611, for GNU/Linux 3.2.0, not stripped
[ld-linux-x86_64.so.2](https://ctf.compfest.id/files/c5d6bfdfdbdcfdef00ea6b7d146cbf3f/ld-linux-x86-64.so.2?token=eyJ1c2VyX2lkIjo3MiwidGVhbV9pZCI6MzA3LCJmaWxlX2lkIjo5OH0.ZtLiFA.j6ZW8-C7Oh3aRw1aPaX0gOaJyOM): ELF 64-bit LSB shared object, x86-64, version 1 (SYSV), dynamically linked, BuildID[sha1]=db0420f708b806cf03260aadb916c330049580b7, stripped
[libc.so.6](https://ctf.compfest.id/files/cb2e6d7d68209fca9221a048ca7fc5d2/libc.so.6?token=eyJ1c2VyX2lkIjo3MiwidGVhbV9pZCI6MzA3LCJmaWxlX2lkIjo5OX0.ZtLiQg.0byjSPLotv2jd8M5Pq5nub5162o):            ELF 64-bit LSB shared object, x86-64, version 1 (GNU/Linux), dynamically linked, interpreter /lib64/ld-linux-x86-64.so.2, BuildID[sha1]=0702430aef5fa3dda43986563e9ffcc47efbd75e, for GNU/Linux 3.2.0, stripped

## Solution

[Dogbolt.org](https://dogbolt.org/?id=bdbaf276-bc12-4fcf-add3-70c4423b7920#Ghidra=315&Hex-Rays=309)!

![[Pwn/Compfest CTF/gampanglah/chall.c|chall]]