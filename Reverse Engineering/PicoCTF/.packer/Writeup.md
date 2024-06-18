# Reverse Writeup by Deffreus - PicoCTF 2024

We get a *packed* binary file, which means it's *compressed* to reduce its size.

## Tools

- [bat](https://github.com/sharkdp/bat) (utility)
- [Ghidra](https://github.com/NationalSecurityAgency/ghidra)
- [dust](https://github.com/bootandy/dust)
- [Neovim](https://github.com/neovim/neovim)

<details><summary>Spoiler:</summary>
	upx (https://upx.github.io/)
</details>

## Recon

```$ file out
out: ELF 64-bit LSB executable, x86-64, version 1 (GNU/Linux), statically linked, no section header
```
```$ strings out | bat
4467   │ $Info: This file is packed with the UPX executable packer http://upx.sf.net $
4468   │ $Id: UPX 3.95 Copyright (C) 1996-2018 the UPX Team. All Rights Reserved. $
```

It seems like this binary is packed with [`upx`](https://upx.github.io/).
We need to unpack the binary file with this option:

```$ upx --help | bat
10   │   -d     decompress
```

## Reverse Engineering

```$ upx -d out -o out-upx
                       Ultimate Packer for eXecutables
                          Copyright (C) 1996 - 2024
UPX 4.2.4       Markus Oberhumer, Laszlo Molnar & John Reiser    May 9th 2024

        File size         Ratio      Format      Name
   --------------------   ------   -----------   -----------
[WARNING] bad b_info at 0x4b710

[WARNING] ... recovery at 0x4b70c

    877724 <-    336512   38.34%   linux/amd64   out-upx

Unpacked 1 file.
```

We can use [Ghidra](https://github.com/NationalSecurityAgency/ghidra) to decompile `out-upx` to C/C++ code.
File -> Export Program -> Format: C/C++ --> OK

```$ dust out.c
7.9M ┌── out.c│███████████████████████████████████████████████ │ 100%
```

Loading it with `nvim` takes a bit of time due to the size.
Jumping to `main` at line 2141, we can see the string output of correct input: "Password correct, please see flag: 7069636f4354467b5539585f556e5034636b314e365f42316e34526933535f36666639363465667d".
This seems like a hex strings, as `0x70` is the `p` in `picoCTF`. We'll convert it accordingly:

```solve.py
decoded = [0x70,0x69,0x63,0x6f,0x35,0x44,0x67,0xb5,0x53,0x95,0x85,0xf5,0x56,0xe5,0x03,0x46,0x36,0xb3,0x14,0xe3,0x65,0xf4,0x23,0x16,0xe3,0x45,0x26,0x93,0x35,0x35,0xf3,0x66,0x66,0x63,0x93,0x63,0x46,0x56,0x67]
for c in decoded:
    print(chr(c),end='')
```
```$ python3 solve.py
pico5DgµSõVåF6³ãeô#ãE&55óffccFVg
```

Seems like I got it wrong. Maybe it's encoded?
We'll try again using [CyberChef](https://gchq.github.io/CyberChef/#recipe=Magic(3,false,false,'')&input=NzA2OTYzNmY0MzU0NDY3YjU1Mzk1ODVmNTU2ZTUwMzQ2MzZiMzE0ZTM2NWY0MjMxNmUzNDUyNjkzMzUzNWYzNjY2NjYzOTM2MzQ2NTY2N2Q) to decode it. Apparently, it's encoded with base85 and the flag is: picoCTF{U9X_UnP4ck1N6_B1n4Ri3S_6ff964ef}!

> picoCTF{U9X_UnP4ck1N6_B1n4Ri3S_6ff964ef}
