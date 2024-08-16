# Lost Canary Writeup by Deffreus - UIUCTF 2024

This challenge has 5 toys!<br>
But, these are new kinds of toy that I have never played with.
Like, all 5 of them.
Time to learn it then!

## Toys:

### Dockerfile

```$file Dockerfile 
Dockerfile: ASCII text
```
```$ du -h Dockerfile 
4.0K	Dockerfile
```
```$ binwalk Dockerfile 

DECIMAL       HEXADECIMAL     DESCRIPTION
--------------------------------------------------------------------------------
412           0x19C           Unix path: /home/user/nsjail.cfg -- /home/user/lost_canary"

```

Not sure what to make of these.
I'll consult the web...

"A Dockerfile is a text document that contains instructions for building a Docker image. It’s a sequence of commands that the Docker daemon executes to assemble the image. A Dockerfile typically starts with a FROM instruction, which specifies the parent image to build upon. It then includes a series of instructions, such as COPY, RUN, and CMD, to configure the image."

I realized that I don't have docker on my system, so I install it.

### lost_canary

```$ file lost_canary 
lost_canary: ELF 64-bit LSB pie executable, x86-64, version 1 (SYSV), dynamically linked, interpreter /lib64/ld-linux-x86-64.so.2, BuildID[sha1]=6966835d6fd9afec25467c91e544e5a23e08e266, for GNU/Linux 3.2.0, not stripped
```
```$ du -h lost_canary 
9.7M	lost_canary
```

Do I still need these other 4 files?
What if I just decompile and analyze this file, huh?
Well, it's too big for decompiler explorer, so I'll just try with my own Ghidra.

## Static Analysis

I can't.
