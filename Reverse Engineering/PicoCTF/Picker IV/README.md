# Picker IV Writeup by Deffreus - PicoCTF picoGym Exclusive

###### Author: LT 'syreal' Jones

## Description

Can you figure out how this program works to get the flag?<br>
Connect to the program with netcat:<br>
`$ nc saturn.picoctf.net 61909`<br>
The program's source code can be downloaded [here](https://artifacts.picoctf.net/c/527/picker-IV.c). The binary can be downloaded [here](https://artifacts.picoctf.net/c/527/picker-IV).

## Files

```
$ file picker-IV picker-IV.c 
picker-IV:   ELF 64-bit LSB executable, x86-64, version 1 (SYSV), dynamically linked, interpreter /lib64/ld-linux-x86-64.so.2, BuildID[sha1]=12b33c5ff389187551aae5774324da558cee006c, for GNU/Linux 3.2.0, not stripped
picker-IV.c: C source, ASCII text

$ du -h picker-IV picker-IV.c
20K	picker-IV
4.0K	picker-IV.c
```

## Solution


