# Investigative Reversing 1 Writeup by Deffreus - PicoCTF 2019

## Forensic

Now,
three images?

```$ exiftool mystery.png mystery2.png mystery3.png
======== mystery.png
ExifTool Version Number         : 12.70
File Name                       : mystery.png
Directory                       : .
File Size                       : 125 kB
File Modification Date/Time     : 2020:10:27 01:39:33+07:00
File Access Date/Time           : 2024:07:22 20:56:02+07:00
File Inode Change Date/Time     : 2024:07:22 20:54:43+07:00
File Permissions                : -rw-r--r--
File Type                       : PNG
File Type Extension             : png
MIME Type                       : image/png
Image Width                     : 1411
Image Height                    : 648
Bit Depth                       : 8
Color Type                      : RGB
Compression                     : Deflate/Inflate
Filter                          : Adaptive
Interlace                       : Noninterlaced
SRGB Rendering                  : Perceptual
Gamma                           : 2.2
Pixels Per Unit X               : 5669
Pixels Per Unit Y               : 5669
Pixel Units                     : meters
Warning                         : [minor] Trailer data after PNG IEND chunk
Image Size                      : 1411x648
Megapixels                      : 0.914
======== mystery2.png
ExifTool Version Number         : 12.70
File Name                       : mystery2.png
Directory                       : .
File Size                       : 125 kB
File Modification Date/Time     : 2020:10:27 01:39:33+07:00
File Access Date/Time           : 2024:07:22 20:56:02+07:00
File Inode Change Date/Time     : 2024:07:22 20:55:00+07:00
File Permissions                : -rw-r--r--
File Type                       : PNG
File Type Extension             : png
MIME Type                       : image/png
Image Width                     : 1411
Image Height                    : 648
Bit Depth                       : 8
Color Type                      : RGB
Compression                     : Deflate/Inflate
Filter                          : Adaptive
Interlace                       : Noninterlaced
SRGB Rendering                  : Perceptual
Gamma                           : 2.2
Pixels Per Unit X               : 5669
Pixels Per Unit Y               : 5669
Pixel Units                     : meters
Warning                         : [minor] Trailer data after PNG IEND chunk
Image Size                      : 1411x648
Megapixels                      : 0.914
======== mystery3.png
ExifTool Version Number         : 12.70
File Name                       : mystery3.png
Directory                       : .
File Size                       : 125 kB
File Modification Date/Time     : 2020:10:27 01:39:33+07:00
File Access Date/Time           : 2024:07:22 20:56:02+07:00
File Inode Change Date/Time     : 2024:07:22 20:55:13+07:00
File Permissions                : -rw-r--r--
File Type                       : PNG
File Type Extension             : png
MIME Type                       : image/png
Image Width                     : 1411
Image Height                    : 648
Bit Depth                       : 8
Color Type                      : RGB
Compression                     : Deflate/Inflate
Filter                          : Adaptive
Interlace                       : Noninterlaced
SRGB Rendering                  : Perceptual
Gamma                           : 2.2
Pixels Per Unit X               : 5669
Pixels Per Unit Y               : 5669
Pixel Units                     : meters
Warning                         : [minor] Trailer data after PNG IEND chunk
Image Size                      : 1411x648
Megapixels                      : 0.914
    3 image files read
```

Each image has that extra bytes at the end of file.

Here are the bytes for `mystery.png`, `mystery2.png`, and `mystery3.png`, respectively: `CF{An1_e2630725}`, `s`, and `icT0tha_`.

## Reverse Engineering

The [decompiled](https://dogbolt.org/?id=294f8f97-453a-4130-b5e9-cf6bdfe349ac#Hex-Rays=191) `mystery` looks like this:

```mystery.c
int main(int argc, const char **argv, const char **envp) {
  char v5 = ptr[3];
  char ptr[40];
  FILE *stream = fopen("flag.txt", "r");
  FILE *v12 = fopen("mystery.png", "a");
  FILE *v13 = fopen("mystery2.png", "a");
  FILE *v14 = fopen("mystery3.png", "a");

  if ( !stream )
    puts("No flag found, please make sure this is run on the server");
  if ( !v12 )
    puts("mystery.png is missing, please run this on the server");

  fread(ptr, 0x1AuLL, 1uLL, stream);
  fputc(ptr[1], v14);
  fputc((char)(ptr[0] + 21), v13);
  fputc(ptr[2], v14);
  fputc(ptr[5], v14);
  fputc(ptr[4], v12);
  for ( int i = 6; i <= 9; ++i ) {
    ++v5;
    fputc(ptr[i], v12);
  }
  fputc(v5, v13);
  for ( int i = 10; i <= 14; ++i )
    fputc(ptr[i], v14);
  for ( int i = 15; i <= 25; ++i )
    fputc(ptr[i], v12);
  fclose(v12);
  fclose(stream);
}
```

Now,
let's focus on the first image (`v12`),

```mystery.c
  fputc(ptr[4], v12);
  for ( int i = 6; i <= 9; ++i ) {
    fputc(ptr[i], v12);
  }
  for ( int i = 15; i <= 25; ++i )
    fputc(ptr[i], v12);
```

By putting the characters based on their index,
the flag is now like this: `    C F{An     1_e2630725}`

```mystery.c
  char v5 = ptr[3];
  fputc((char)(ptr[0] + 21), v13);
  for ( int i = 6; i <= 9; ++i )
    ++v5;
  fputc(v5, v13);
```

Reverse the `+ 21` operation,
decrease `v5` by `4`,
and do the same as image one!
The flag is now: `p  oC F{An     1_e2630725}`

```mystery.c
  fputc(ptr[1], v14);
  fputc(ptr[2], v14);
  fputc(ptr[5], v14);
  for ( int i = 10; i <= 14; ++i )
    fputc(ptr[i], v14);
```
icT0tha_
Here's the third image!
You get the gists already.
After adding info from the third image,
our flag will look like `picoCTF{An0tha_1_e2630725}`
That's it!
