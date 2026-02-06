## Description

In this misc challenge, participants have to analyze and understand file formats.

## Solution

`binwalk` shows it's just a PNG file.
I used `strings` and found `flag.txt` string in the end of the output.
Opening ImHex, I inspected the tail of the file, and see these `PK` bytes, which I recognize could be from PKZIP.
With [this document](https://users.cs.jmu.edu/buchhofp/forensics/formats/pkzip.html) as reference,
I tried locating the end of the PKZIP file, and seems like it goes till EOF (16 bytes comment).
I saved the file like this:

```
Hex View  00 01 02 03 04 05 06 07  08 09 0A 0B 0C 0D 0E 0F
 
00000000  50 4B 03 04 14 00 00 00  08 00 09 8A 92 58 A9 89  PK...........X..
00000010  BF 54 21 00 00 00 22 00  00 00 08 00 1C 00 66 6C  .T!...".......fl
00000020  61 67 2E 74 78 74 55 54  09 00 03 41 39 21 66 5A  ag.txtUT...A9!fZ
00000030  14 22 66 75 78 0B 00 01  04 F6 01 00 00 04 14 00  ."fux...........
00000040  00 00 4B CB 49 4C AF 2E  4F CD C9 89 2F CF 48 2C  ..K.IL..O.../.H,
00000050  89 2F C9 48 8D CF 30 06  F2 32 4D 81 6C C3 62 FB  ./.H..0..2M.l.b.
00000060  5A 2E 00 50 4B 01 02 1E  03 14 00 00 00 08 00 09  Z..PK...........
00000070  8A 92 58 A9 89 BF 54 21  00 00 00 22 00 00 00 08  ..X...T!..."....
00000080  00 18 00 00 00 00 00 01  00 00 00 A4 81 AF 81 00  ................
00000090  00 66 6C 61 67 2E 74 78  74 55 54 05 00 03 41 39  .flag.txtUT...A9
000000A0  21 66 75 78 0B 00 01 04  F6 01 00 00 04 14 00 00  !fux............
000000B0  00 50 4B 05 06 00 00 00  00 01 00 01 00 4E 00 00  .PK..........N..
000000C0  00 12 82 00 00 10 00 E3  03 BA 61 00 00 00 00 49  ..........a....I
000000D0  45 4E 44 AE 42 60 82                             END.B`.
```


`unzip polyglot`, it throws an error but `flag.txt` is extracted nonetheless.
