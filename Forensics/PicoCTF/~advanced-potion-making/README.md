Author: bigC

Ron just found his own [copy of advanced potion making](./advanced-potion-making), but its been corrupted by some kind of spell. Help him recover it! 

## Solution

`file` said the file is `data`,
but through `strings` there are `IHDR` and `IEND`,
which are chunk names belonging to the .png file format.
This, as confirmed by the challenge description,
means that the file is corrupted.
I look up [this](http://www.libpng.org/pub/png/spec/1.2/PNG-Chunks.html) and [this](http://www.libpng.org/pub/png/spec/1.2/PNG-Structure.html).

I just compared the file with [one sample valid image I have](./confidence.png).
This was done with `xxd <file> | head` on the file and the sample.

```
$ xxd advanced-potion-making|head
00000000: 8950 4211 0d0a 1a0a 0012 1314 4948 4452  .PB.........IHDR
00000010: 0000 0990 0000 04d8 0802 0000 0004 2de7  ..............-.
00000020: 7800 0000 0173 5247 4200 aece 1ce9 0000  x....sRGB.......
00000030: 0004 6741 4d41 0000 b18f 0bfc 6105 0000  ..gAMA......a...
00000040: 0009 7048 5973 0000 1625 0000 1625 0149  ..pHYs...%...%.I
00000050: 5224 f000 0076 3949 4441 5478 5eec fd61  R$...v9IDATx^..a
00000060: 72e3 4c94 a659 ce16 6afe 76cd fe57 d7dd  r.L..Y..j.v..W..
00000070: 5b18 45e9 4b8a 7a28 d19d 2048 07a9 6376  [.E.K.z(.. H..cv
00000080: ac2d 2b3e bfaf 5f07 1801 82d7 b2f3 fff3  .-+>.._.........
00000090: fffc 7fff 7f00 0000 0000 0000 4b18 5802  ............K.X.

$ xxd confidence.png|head
00000000: 8950 4e47 0d0a 1a0a 0000 000d 4948 4452  .PNG........IHDR
00000010: 0000 0438 0000 0436 0806 0000 00d6 1a0d  ...8...6........
00000020: ff00 0000 0970 4859 7300 0000 0000 0000  .....pHYs.......
00000030: 0100 8479 1773 0000 0c4d 6943 4350 4943  ...y.s...MiCCPIC
00000040: 4320 5072 6f66 696c 6500 0078 9c95 5707  C Profile..x..W.
00000050: 5853 c916 9e5b 5221 0408 4440 4ae8 4d10  XS...[R!..D@J.M.
00000060: 9112 404a 082d f48e 202a 2109 104a 8c09  ..@J.-.. *!..J..
00000070: 41c5 8e2c aee0 da45 04cb 8aae 5214 db0a  A..,...E....R...
00000080: c862 435d 7565 51ec 7db1 a0a2 ac8b eb62  .bC]ueQ.}......b
00000090: 57de 8400 baec 2bdf 9bef 9b3b fffd e7cc  W.....+....;....
```

There's two errors in the file:

- Magic number (offset `0x2-0x3`)
- the PNG chunk length (offset `0x8-0xB`)

I changed them to match exactly the sample
using ImHex,
and it worked!
`file` now identified the file as a PNG!
But, I opened it and, it's just all red?
Tried `zsteg`, but it doesn't find anything.
I then tried `stegsolve`,
just trying out all the modifications,
and found the flag with "Red Plane 0"!
Yup!
