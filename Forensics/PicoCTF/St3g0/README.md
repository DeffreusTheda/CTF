# St3g0 Writeup by Deffreus - PicoCTF 2022

###### Author: LT 'syreal' Jones (ft. djrobin17)

## Description

Download this image and find the flag.

- [Download image](https://artifacts.picoctf.net/c/216/pico.flag.png)

## Files

```
$ file pico.flag.png 
pico.flag.png: PNG image data, 585 x 172, 8-bit/color RGBA, non-interlaced
```

![flag.png](./pico.flag.png)

## Solution

Stegonography...

`stegoveritas` is a great tool!

```
$ stegoveritas pico.flag.png 
Running Module: SVImage
+---------------------------+------+
|        Image Format       | Mode |
+---------------------------+------+
| Portable network graphics | RGBA |
+---------------------------+------+
Found something worth keeping!
8086 relocatable (Microsoft), "\210\200", 1st record data length 8, 2nd record type 0x88, 2nd record data length 2184
Found something worth keeping!
Targa image data - Color 2048 x 33312 x 8 +544 +8192 - top ""
Found something worth keeping!
Targa image data - Color 128 x 32 x 8 +8 - top "\202"
Found something worth keeping!
Atari DEGAS Elite compressed bitmap 320 x 200 x 16, color palette 0400 0000 4081 0200 0000 ...
Found something worth keeping!
Atari DEGAS Elite compressed bitmap 320 x 200 x 16, color palette 0040 1084 0008 4000 0401 ...
Found something worth keeping!
Atari DEGAS Elite compressed bitmap 320 x 200 x 16, color palette 0002 0020 8200 0082 0000 ...
Found something worth keeping!
Atari DEGAS Elite compressed bitmap 320 x 200 x 16, color palette 0000 1000 4081 0000 0810 ...
Found something worth keeping!
Atari DEGAS Elite compressed bitmap 320 x 200 x 16, color palette 0000 0080 0080 8080 0000 ...
+--------+------------------+------------------------------------------------------------------------------------------------+-----------+
| Offset | Carved/Extracted | Description                                                                                    | File Name |
+--------+------------------+------------------------------------------------------------------------------------------------+-----------+
| 0x575e | Carved           | Linux EXT filesystem, rev 0.0, ext4 filesystem data, UUID=eddbb76e-ddbb-76ed-dbb7-6efa00000000 | 575E.ext2 |
| 0x575e | Extracted        | Linux EXT filesystem, rev 0.0, ext4 filesystem data, UUID=eddbb76e-ddbb-76ed-dbb7-6efa00000000 | ext-root  |
+--------+------------------+------------------------------------------------------------------------------------------------+-----------+
WARNING:StegoVeritas:Couldn't find extracted file named /tmp/tmpr44c6lza/_scanme.extracted/ext-root
WARNING:StegoVeritas:Modules:Image:Analysis:Filters:Error: not supported for this image mode. Op: autocontrast
WARNING:StegoVeritas:Modules:Image:Analysis:Filters:Error: not supported for this image mode. Op: equalize
WARNING:StegoVeritas:Modules:Image:Analysis:Filters:Error: not supported for this image mode. Op: invert
WARNING:StegoVeritas:Modules:Image:Analysis:Filters:Error: not supported for this image mode. Op: solarize
Running Module: MultiHandler

Found something worth keeping!
PNG image data, 585 x 172, 8-bit/color RGBA, non-interlaced
+--------+------------------+-------------------------------------------+-----------+
| Offset | Carved/Extracted | Description                               | File Name |
+--------+------------------+-------------------------------------------+-----------+
| 0x29   | Carved           | Zlib compressed data, default compression | 29.zlib   |
| 0x29   | Extracted        | Zlib compressed data, default compression | 29        |
+--------+------------------+-------------------------------------------+-----------+
Exif
====
+---------------------+--------------------------------------------------------+
| key                 | value                                                  |
+---------------------+--------------------------------------------------------+
| SourceFile          | /home/vinnie/CTF/Forensics/PicoCTF/St3g0/pico.flag.png |
| ExifToolVersion     | 12.7                                                   |
| FileName            | pico.flag.png                                          |
| Directory           | /home/vinnie/CTF/Forensics/PicoCTF/St3g0               |
| FileSize            | 13 kB                                                  |
| FileModifyDate      | 2023:08:05 03:36:17+07:00                              |
| FileAccessDate      | 2024:08:15 11:51:25+07:00                              |
| FileInodeChangeDate | 2024:08:15 11:48:57+07:00                              |
| FilePermissions     | -rw-r--r--                                             |
| FileType            | PNG                                                    |
| FileTypeExtension   | png                                                    |
| MIMEType            | image/png                                              |
| ImageWidth          | 585                                                    |
| ImageHeight         | 172                                                    |
| BitDepth            | 8                                                      |
| ColorType           | RGB with Alpha                                         |
| Compression         | Deflate/Inflate                                        |
| Filter              | Adaptive                                               |
| Interlace           | Noninterlaced                                          |
| ImageSize           | 585x172                                                |
| Megapixels          | 0.101                                                  |
+---------------------+--------------------------------------------------------+
```
