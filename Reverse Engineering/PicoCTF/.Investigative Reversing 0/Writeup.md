# Investigative Reversing 0 Writeup by Deffreus - PicoCTF 2019

## Forensics

Oh boy I haven't done any forensics in quite a long time!
Let's just do the forensics part first.

```$ exiftool mystery.png 
ExifTool Version Number         : 12.70
File Name                       : mystery.png
Directory                       : .
File Size                       : 125 kB
File Modification Date/Time     : 2020:10:27 01:40:04+07:00
File Access Date/Time           : 2024:07:22 20:07:19+07:00
File Inode Change Date/Time     : 2024:07:22 20:07:19+07:00
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
```

Huh?
A warning?
First time seeing it!
Let's see...

```$ strings mystery.png | tail     
777[[[WW
^^^...
.]JHH8
###G
?NOO
%IIIo
!33S
IEND
picoCTK
k5zsid6q_3d659f57}
```

## Reverse Engineering

Now, let's move on to the Rev!

```$ file mystery
mystery: ELF 64-bit LSB pie executable, x86-64, version 1 (SYSV), dynamically linked, interpreter /lib64/ld-linux-x86-64.so.2, for GNU/Linux 3.2.0, BuildID[sha1]=34b772a4f30594e2f30ac431c72667c3e10fa3e9, not stripped
```

```$ ./mystery
No flag found, please make sure this is run on the server
[1]    80583 segmentation fault (core dumped)  ./mystery
```

Running it locally won't work.
[Decompile](https://dogbolt.org/?id=5025aa56-ad28-41a4-93ca-8b269765dc3a#Hex-Rays=179)!

```mystery.c
int main(int argc, const char **argv, const char **envp) {
  FILE *stream = fopen("flag.txt", "r");
  FILE *v8 = fopen("mystery.png", "a");
  char ptr[40];

  if ( !stream )
    puts("No flag found, please make sure this is run on the server");
  if ( !v8 )
    puts("mystery.png is missing, please run this on the server");
  if ( (int)fread(ptr, 0x1AuLL, 1uLL, stream) <= 0 )
    exit(0);

  puts("at insert");
  fputc(ptr[0], v8);
  fputc(ptr[1], v8);
  fputc(ptr[2], v8);
  fputc(ptr[3], v8);
  fputc(ptr[4], v8);
  fputc(ptr[5], v8);
  for ( int i = 6; i <= 14; ++i )
    fputc((char)(ptr[i] + 5), v8);
  fputc((char)(ptr[15] - 3), v8);
  for ( int i = 16; i <= 25; ++i )
    fputc(ptr[i], v8);

  fclose(v8);
  fclose(stream);
}
```

Insert...
Seems like that extra bytes after `IEND` was the result of this binary!
It looks like this: `picoCTKk5zsid6q_3d659f57}`
Although, some modification was done to the written characters.

```mystery.c
  fputc(ptr[0], v8);
  fputc(ptr[1], v8);
  fputc(ptr[2], v8);
  fputc(ptr[3], v8);
  fputc(ptr[4], v8);
  fputc(ptr[5], v8);
```

From the code,
the first six bytes (`picoCT`) are unchanged.

```mystery.c
  for ( int i = 6; i <= 14; ++i )
    fputc((char)(ptr[i] + 5), v8);
```

The 7th till the 15th bytes are 'rotated' forward 5 times,
so if we reverse it,
it would be `F{f0und_1`

```mystery.c
  fputc((char)(ptr[15] - 3), v8);
```
The 16th character are 'rotated' backward 3 times,
so reversing it would yield `t`.

```mystery.c
  for ( int i = 16; i <= 25; ++i )
    fputc(ptr[i], v8);
```

And then,
the 17th till the 26th character (`_3d659f57}`) is unchanged!
Now just concatenate them together and I got the flag:

`picoCTF{f0und_1t_3d659f57}`
