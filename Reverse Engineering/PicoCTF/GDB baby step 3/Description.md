# GDB baby step 3 - PicoCTF picoGym

###### Author: LT 'SYREAL' JONES

## Description

Now for something a little different.
`0x2262c96b`` is loaded into memory in the main function.
Examine byte-wise the memory that the constant is loaded in by using the GDB command `x/4xb addr`.
The flag is the four bytes as they are stored in memory.
If you find the bytes `0x11 0x22 0x33 0x44` in the memory location,
your flag would be: `picoCTF{0x11223344}`.
Debug [this](https://artifacts.picoctf.net/c/531/debugger0_c).
