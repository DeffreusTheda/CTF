# Color Palette Writeup by Deffreus - CompfestCTF 16

######  Author: kilometer

## Description

The visual design team already brainstormed the theme for the Colorfest event, which is "dominance in art".
But they are still discussing to choose 5 colors to put into their color palette, can you help them?

Flag : COMPFEST16{flag}

[coming_soon_colorfest.png](https://ctf.compfest.id/files/3c23cb25d447e2457295626dbb07984f/coming_soon_colorfest.png?token=eyJ1c2VyX2lkIjo3MiwidGVhbV9pZCI6MzA3LCJmaWxlX2lkIjo0OH0.Zrg07Q.TROyKnAjcy4cwSczenhXldvighA)

## Files

```
$ file coming_soon_colorfest.png 
coming_soon_colorfest.png: PNG image data, 1748 x 1240, 8-bit/color RGBA, non-interlaced
$ du -h coming_soon_colorfest.png 
132K	coming_soon_colorfest.png
$ exiftool coming_soon_colorfest.png 
ExifTool Version Number         : 12.70
File Name                       : coming_soon_colorfest.png
Directory                       : .
File Size                       : 135 kB
File Modification Date/Time     : 2024:08:02 17:23:46+07:00
File Access Date/Time           : 2024:08:11 10:52:36+07:00
File Inode Change Date/Time     : 2024:08:11 10:52:33+07:00
File Permissions                : -rw-r--r--
File Type                       : PNG
File Type Extension             : png
MIME Type                       : image/png
Image Width                     : 1748
Image Height                    : 1240
Bit Depth                       : 8
Color Type                      : RGB with Alpha
Compression                     : Deflate/Inflate
Filter                          : Adaptive
Interlace                       : Noninterlaced
Pixels Per Unit X               : 11811
Pixels Per Unit Y               : 11811
Pixel Units                     : meters
Comment                         : xr:d:DAFD6kH8_pY:64,j:33373716547,t:22082113
Image Size                      : 1748x1240
Megapixels                      : 2.2
```

## Solution

### Session 1

```
>look at metadata
>not much
>try strings
>didn't work
>look at image
>it has only 5 colors
>thonk
>"maybe the RGB value could be turned into ASCII"
>open it in GIMP unironically
>#aec8a7, #b35777, #734974, #b6bbb7, #cb4bae
>®È§, ³Ww, sIt, ¶»·, ËK®
>wtf.png
>autism kicks in
>count how many objects each color has
>2, 31+9+6, 13, 1, 1
>can't make any connection
>try binwalk
>what why is there a zlib @ 0x7E there
>dd if=coming_soon_colorfest.png of=zlib bs=1 skip=127
>cat zlib | zlib-flate -uncompress >uncompressed
>file uncompressed
>uncompressed: data
>bruh.png
>looks up at https://book.hacktricks.xyz/crypto-and-stego/stego-tricks
>zsteg -a coming_soon_colorfest.png
>absolute gibberish
>stegoveritas coming_soon_colorfest.png
>nothing new
>stegsolve coming_soon_colorfest.png
>nothing
>quit and try other challange
```
### Session 2

"dominant in art" huh?

https://www.coolphptools.com/color_extract#demo

| Color Code | Percentage |
| ---------- | ---------- |
| #ffffff    | 0.524151   |
| #b6bbb7    | 0.240000   |
| #734974    | 0.055975   |
| #aec8a7    | 0.045597   |
| #b7bcb8    | 0.002956   |
| #b8bdb9    | 0.002830   |

Dunno..
