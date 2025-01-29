# hideme Writeup by Deffreus - PicoCTF 2023

###### Author: Geoffrey Njogu

## Description

Every file gets a flag.<br>
The SOC analyst saw one image been sent back and forth between two people. They decided to investigate and found out that there was more than what meets the eye [here](https://artifacts.picoctf.net/c/261/flag.png).

## Files

```
$ file flag.png            
flag.png: PNG image data, 512 x 504, 8-bit/color RGBA, non-interlaced
```

![flag.png](./flag.png)

## Solution

```
$ exiftool flag.png 
ExifTool Version Number         : 12.70
File Name                       : flag.png
Directory                       : .
File Size                       : 43 kB
File Modification Date/Time     : 2023:03:16 10:15:31+07:00
File Access Date/Time           : 2024:08:15 08:35:37+07:00
File Inode Change Date/Time     : 2024:08:15 08:35:17+07:00
File Permissions                : -rw-r--r--
File Type                       : PNG
File Type Extension             : png
MIME Type                       : image/png
Image Width                     : 512
Image Height                    : 504
Bit Depth                       : 8
Color Type                      : RGB with Alpha
Compression                     : Deflate/Inflate
Filter                          : Adaptive
Interlace                       : Noninterlaced
Warning                         : [minor] Trailer data after PNG IEND chunk
Image Size                      : 512x504
Megapixels                      : 0.258
```

Look at that warning!
There must be something concatenated at the end of the file...
Let's see what `binwalk` think about this:

```
$ binwalk flag.png 

DECIMAL       HEXADECIMAL     DESCRIPTION
--------------------------------------------------------------------------------
0             0x0             PNG image, 512 x 504, 8-bit/color RGBA, non-interlaced
41            0x29            Zlib compressed data, compressed
39739         0x9B3B          Zip archive data, at least v1.0 to extract, name: secret/
39804         0x9B7C          Zip archive data, at least v2.0 to extract, compressed size: 2858, uncompressed size: 3015, name: secret/flag.png
42897         0xA791          End of Zip archive, footer length: 22
```

Aight, something is definitely there,
it's a .zip of a file named `secret/flag.png`...

```
$ dd bs=1 skip=39739 if=flag.png of=secret.zip
3180+0 records in
3180+0 records out
3180 bytes (3.1 kB, 3.0 KiB) copied, 0.00297926 s, 1.0 MB/s
$ ls
flag.png  secret.zip  Writeup.md
$ unzip secret.zip
Archive:  secret.zip
   creating: secret/
  inflating: secret/flag.png
```

Let's open `secret/flag.png`:

![secret.png](./secret/flag.png)

FLAG: `picoCTF{Hiddinng_An_imag3_within_@n_ima9e_96539bea}`
