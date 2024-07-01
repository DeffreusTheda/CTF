# unpackme Writeup by Deffreus - PicoCTF 2022

```$ file unpackme-upx 
unpackme-upx: ELF 64-bit LSB executable, x86-64, version 1 (GNU/Linux), statically linked, no section header
```
```$ du -h unpackme-upx 
372K	unpackme-upx
```

UPX is a packer for executables. We just need to unpackage the binary with `upx -d unpackme-upx`, then decompile it with [Decompiler Explorer](https://play.picoctf.org/practice/challenge/313?category=3&page=1&solved=1), but most exceeded time limit. That means we'll have to use local software, so I use Ghidra to decompile it to C.

Here's the size of the unpackaged binary:

```$ du -h unpackme-upx 
980K	unpackme-upx
```
```$ file unpackme-upx 
unpackme-upx: ELF 64-bit LSB executable, x86-64, version 1 (GNU/Linux), statically linked, BuildID[sha1]=ff92c782295ce13fa05b71b14d8f88b2f46f3a5e, for GNU/Linux 3.2.0, not stripped
```

```$ du -h unpackme-upx.c
8.7M	unpackme-upx.c
```
```$ nl unpackme-upx.c | tail   
       
       
       
238647	void _fini(void)
       
238648	{
238649	 return;
238650	}
       
       
```

It's a big file, for sure. Main is at line 1656. It's annoying having so many undefined types because I'm on aarch64.

```.c
  1669  | lStack_10 = *(long *)(in_FS_OFFSET + 0x28);
  1670  | uStack_38 = 0x4c75257240343a41;
  1671  | uStack_30 = 0x30623e306b6d4146;
  1672  | uStack_28 = 0x6865666430486637;
  1673  | uStack_20 = 0x36636433;
  1674  | uStack_1c = 0x4e;
  1675  | printf(&UNK_004b3004); // Some prompt, I guess
  1676  | __isoc99_scanf(&UNK_004b3020,&iStack_44);
  1677  | if (iStack_44 == 0xb83cb) {
  1678  |   uStack_40 = rotate_encrypt(0,&uStack_38);
  1679  |   fputs(uStack_40,stdout);
  1680  |   putchar(10);
  1681  |   free(uStack_40);
  1682  | }
  1683  | else {
  1684  |   puts(&UNK_004b3023); // Failure, uh
  1685  | }
```

Aight, we just need to input the decimal form of `0xb83cb`, `754635`.

```sh
d3ffr3u5-picoctf@webshell:~$  ./unpackme-upx 
What's my favorite number? 754635
picoCTF{up><_m3_f7w_5769b54e}
```
