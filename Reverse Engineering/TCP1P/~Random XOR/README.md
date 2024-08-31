# Random XOR Writeup by Deffreus - TCP1P Playground 365

## Recon

```$ file dist/encrypt 
dist/encrypt: ELF 64-bit LSB pie executable, x86-64, version 1 (SYSV), dynamically linked, interpreter /lib64/ld-linux-x86-64.so.2, BuildID[sha1]=351e95a5b55a58a1dc086d73106a9f95b6927d39, for GNU/Linux 4.4.0, not stripped
```
```$ exiftool dist/encrypt 
ExifTool Version Number         : 12.70
File Name                       : encrypt
Directory                       : dist
File Size                       : 16 kB
File Modification Date/Time     : 2024:06:17 09:48:12+07:00
File Access Date/Time           : 2024:06:17 22:09:31+07:00
File Inode Change Date/Time     : 2024:06:17 22:09:24+07:00
File Permissions                : -rwxr-xr-x
File Type                       : ELF shared library
File Type Extension             : so
MIME Type                       : application/octet-stream
CPU Architecture                : 64 bit
CPU Byte Order                  : Little endian
Object File Type                : Shared object file
CPU Type                        : AMD x86-64
```
```$ xxd flag_enc.txt 
00000000: 6d07 0c66 e958 d809 01ac cc6d 5390 7b58  m..f.X.....mS.{X
00000010: a642 eca5 cf12 5dcd 8dbb 4e97 3411 f86f  .B....]...N.4..o
00000020: 4118 7cc3 2ae8 1eac ed82 3004 27         A.|.*.....0.'
```

Using [Decompiler Explorer](https://dogbolt.org/?id=03b71290-01af-41f7-b9c6-8b6f39e1f10b#Hex-Rays=139) (Hex-Rays):
```encrypt.c
 119   │ int __fastcall main(int argc, const char **argv, const char **envp)
 120   │ {
 121   │   unsigned int seed; // [rsp+1Ch] [rbp-34h] BYREF
 122   │   int i; // [rsp+20h] [rbp-30h]
 123   │   int v6; // [rsp+24h] [rbp-2Ch]
 124   │   int v7; // [rsp+28h] [rbp-28h]
 125   │   int v8; // [rsp+2Ch] [rbp-24h]
 126   │   FILE *stream; // [rsp+30h] [rbp-20h]
 127   │   void *ptr; // [rsp+38h] [rbp-18h]
 128   │   FILE *s; // [rsp+40h] [rbp-10h]
 129   │   unsigned __int64 v12; // [rsp+48h] [rbp-8h]
 130   │ 
 131   │   v12 = __readfsqword(0x28u);
 132   │   seed = time(0LL);
 133   │   srand(seed);
 134   │   stream = fopen(argv[1], "rb");
 135   │   if ( stream )
 136   │   {
 137   │     fseek(stream, 0LL, 2);
 138   │     v6 = ftell(stream);
 139   │     fseek(stream, 0LL, 0);
 140   │     ptr = malloc(0x40uLL);
 141   │     fread(ptr, 1uLL, v6, stream);
 142   │     for ( i = 0; i < v6; ++i )
 143   │     {
 144   │       v7 = (unsigned __int8)rand();
 145   │       v8 = rand();
 146   │       *((_BYTE *)ptr + i) ^= v7;
 147   │     }
 148   │     s = fopen(argv[2], "wb");
 149   │     fwrite(&seed, 1uLL, 4uLL, s);
 150   │     fwrite(ptr, 1uLL, v6, s);
 151   │     printf("Encrypted flag: %s\n", (const char *)ptr);
 152   │     fclose(stream);
 153   │     fclose(s);
 154   │     free(ptr);
 155   │     return 0;
 156   │   }
 157   │   else
 158   │   {
 159   │     puts("Error opening file.");
 160   │     return 1;
 161   │   }
 162   │ }
```

There are a few notable functions:

- `time(0LL)` @ 132: The C library function time_t time(time_t *seconds) returns the time since the Epoch (00:00:00 UTC, January 1, 1970), measured in seconds. If seconds is not NULL, the return value is also stored in variable seconds.
- `ftell()` @ 138: The C library function long int ftell(FILE *stream) returns the current file position of the given stream.
- `fseek()` @ 137, 139: The C library function int fseek(FILE *stream, long int offset, int whence) sets the file position of the stream to the given offset.
- `fread()` @ 141 : The C library function size_t fread(void *ptr, size_t size, size_t nmemb, FILE *stream) reads data from the given stream into the array pointed to, by ptr.
- `fwrite()` @ 149, 150: The C library function size_t fwrite(const void *ptr, size_t size, size_t nmemb, FILE *stream) writes data from the array pointed to, by ptr to the given stream.

It seems like `uLL` stands for 'unsigned long long'.

## Code Analysis

Let's break it down!

### Getting `stream` size

```encrypt.c
fseek(stream, 0LL, 2);
v6 = ftell(stream);
fseek(stream, 0LL, 0);
```

- `fseek` goes to the end of stream as the third argument specify the position from where offset (arg2) is added; The constant `SEEK_END` has the value of `2`.
- Then, `ftell` return the current file position of the given stream, which currently at the end of the stream, basically the stream size.
- After that, it return back to beginning of the stream; The constant `SEEK_SET` has the value of `0`.

### Reading `stream`

```encrypt.c
ptr = malloc(0x40uLL);
fread(ptr, 1uLL, v6, stream);
```

The code allocate 64 bytes (`0x40`) of memory to hold the flag.
`fread()` can be paraphrased as 'store to ptr for v6 number of 1uLL byte from stream'.

### Encrypting the Flag

```encrypt.c
for ( i = 0; i < v6; ++i )
{
  v7 = (unsigned __int8)rand();
  v8 = rand();
  *((_BYTE *)ptr + i) ^= v7;
}
```

We know that the seed for `rand()` is from `time()`.
With `exiftool`, the `File Modification Date/Time` should stand for the time the binary is compiled, which is `2024:06:17 09:48:12+07:00` (`1718592492`).
It's also interesting that `v8` is never used, but because it call `rand()`, it skip that random value.

### Reverse Engineering



~/CTF/Reverse Engineering/TCP1P/Random XOR (maint ✗)  gdb dist/encrypt 
GNU gdb (Fedora Linux) 14.2-1.fc39
Copyright (C) 2023 Free Software Foundation, Inc.
License GPLv3+: GNU GPL version 3 or later <http://gnu.org/licenses/gpl.html>
This is free software: you are free to change and redistribute it.
There is NO WARRANTY, to the extent permitted by law.
Type "show copying" and "show warranty" for details.
This GDB was configured as "aarch64-redhat-linux-gnu".
Type "show configuration" for configuration details.
For bug reporting instructions, please see:
<https://www.gnu.org/software/gdb/bugs/>.
Find the GDB manual and other documentation resources online at:
    <http://www.gnu.org/software/gdb/documentation/>.

For help, type "help".
Type "apropos word" to search for commands related to "word"...
Reading symbols from dist/encrypt...

This GDB supports auto-downloading debuginfo from the following URLs:
  <https://debuginfod.fedoraproject.org/>
Enable debuginfod for this session? (y or [n]) n
Debuginfod has been disabled.
To make this setting permanent, add 'set debuginfod enabled off' to .gdbinit.
(No debugging symbols found in dist/encrypt)
(gdb) p/x 0x
Invalid number "0x".
(gdb) p/x 0x1823
$1 = 0x1823
(gdb) p/x 0x1823412
$2 = 0x1823412
(gdb) p/x 0x18234
$3 = 0x18234
(gdb) x $esp
Value can't be converted to integer.
(gdb) q
~/CTF/Reverse Engineering/TCP1P/Random XOR (maint ✗)  xxd dist/flag_enc.txt 
00000000: e958 d809 01ac cc6d 5390 7b58 a642 eca5  .X.....mS.{X.B..
00000010: cf12 5dcd 8dbb 4e97 3411 f86f 4118 7cc3  ..]...N.4..oA.|.
00000020: 2ae8 1eac ed82 3004 270a                 *.....0.'.
~/CTF/Reverse Engineering/TCP1P/Random XOR (maint ✗)  ls                   
dist  encrypt.c  flag_enc_no-seed.txt  solve  solve.c  Writeup.md
~/CTF/Reverse Engineering/TCP1P/Random XOR (maint ✗)  diff dist/flag_enc.txt flag_enc_no-seed.txt 
~/CTF/Reverse Engineering/TCP1P/Random XOR (maint ✗)  ls                                         
dist  encrypt.c  flag_enc_no-seed.txt  solve  solve.c  Writeup.md
~/CTF/Reverse Engineering/TCP1P/Random XOR (maint ✗)  gdb solve 
GNU gdb (Fedora Linux) 14.2-1.fc39
Copyright (C) 2023 Free Software Foundation, Inc.
License GPLv3+: GNU GPL version 3 or later <http://gnu.org/licenses/gpl.html>
This is free software: you are free to change and redistribute it.
There is NO WARRANTY, to the extent permitted by law.
Type "show copying" and "show warranty" for details.
This GDB was configured as "aarch64-redhat-linux-gnu".
Type "show configuration" for configuration details.
For bug reporting instructions, please see:
<https://www.gnu.org/software/gdb/bugs/>.
Find the GDB manual and other documentation resources online at:
    <http://www.gnu.org/software/gdb/documentation/>.

For help, type "help".
Type "apropos word" to search for commands related to "word"...
Reading symbols from solve...

This GDB supports auto-downloading debuginfo from the following URLs:
  <https://debuginfod.fedoraproject.org/>
Enable debuginfod for this session? (y or [n]) y
Debuginfod has been enabled.
To make this setting permanent, add 'set debuginfod enabled on' to .gdbinit.
Downloading separate debug info for /home/vinnie/CTF/Reverse Engineering/TCP1P/Random XOR/solve
(No debugging symbols found in solve)                                                                                                        
(gdb) x 0x6d070c66
0x6d070c66:	Cannot access memory at address 0x6d070c66
(gdb) x 0x660c076d
0x660c076d:	Cannot access memory at address 0x660c076d
(gdb) info vari
All defined variables:

Non-debugging symbols:
0x00000000004002e8  __abi_tag
0x0000000000420000  _IO_stdin_used
0x0000000000420008  __dso_handle
0x000000000042002c  __GNU_EH_FRAME_HDR
0x0000000000420148  __FRAME_END__
0x000000000043fde8  __frame_dummy_init_array_entry
0x000000000043fdf0  __do_global_dtors_aux_fini_array_entry
0x000000000043fdf8  _DYNAMIC
0x000000000043ffc8  _GLOBAL_OFFSET_TABLE_
0x0000000000440070  __data_start
0x0000000000440070  data_start
0x0000000000440074  __bss_start
0x0000000000440074  __bss_start__
0x0000000000440074  _edata
0x0000000000440074  completed
0x0000000000440078  __TMC_END__
0x0000000000440078  __bss_end__
0x0000000000440078  __end__
0x0000000000440078  _bss_end__
0x0000000000440078  _end
(gdb) p 0x660c076d
$1 = 1712064365
(gdb) p 0x6d070c66
$2 = 1829178470
(gdb) exit
~/CTF/Reverse Engineering/TCP1P/Random XOR (maint ✗)  nvim solve.c 
~/CTF/Reverse Engineering/TCP1P/Random XOR (maint ✗)  gcc solve.c -o solve
 %                                                                                                                                           ~/CTF/Reverse Engineering/TCP1P/Random XOR (maint ✗)  ./solve flag_enc_no-seed.txt 
TCP1P{p53uDO_RANDOM_IS_NOt_R4ndOM_at_A11}<
~/CTF/Reverse Engineering/TCP1P/Random XOR (maint ✗)  echo 'TCP1P{p53uDO_RANDOM_IS_NOt_R4ndOM_at_A11
