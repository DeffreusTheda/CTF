# Investigative Reversing 4 Writeup by Deffreus - PicoCTF 2019

###### Author: Santiago C/Danny T

Hiding flag within 5 image file using a custom and funky LSB encoding.

## Description

We have recovered a [binary](https://jupiter.challenges.picoctf.org/static/c52816dbe0b91283b5459fc828150a1c/mystery) and 5 images: [image01](https://jupiter.challenges.picoctf.org/static/c52816dbe0b91283b5459fc828150a1c/Item01_cp.bmp), [image02](https://jupiter.challenges.picoctf.org/static/c52816dbe0b91283b5459fc828150a1c/Item02_cp.bmp), [image03](https://jupiter.challenges.picoctf.org/static/c52816dbe0b91283b5459fc828150a1c/Item03_cp.bmp), [image04](https://jupiter.challenges.picoctf.org/static/c52816dbe0b91283b5459fc828150a1c/Item04_cp.bmp), [image05](https://jupiter.challenges.picoctf.org/static/c52816dbe0b91283b5459fc828150a1c/Item05_cp.bmp).
See what you can make of it.
There should be a flag somewhere.

## Files

```
$ file Item01_cp.bmp Item02_cp.bmp Item03_cp.bmp Item04_cp.bmp Item05_cp.bmp mystery           
Item01_cp.bmp: PC bitmap, Windows 3.x format, 1765 x 852 x 8, image size 1506336, cbSize 1507414, bits offset 1078
Item02_cp.bmp: PC bitmap, Windows 3.x format, 1765 x 852 x 8, image size 1506336, cbSize 1507414, bits offset 1078
Item03_cp.bmp: PC bitmap, Windows 3.x format, 1765 x 852 x 8, image size 1506336, cbSize 1507414, bits offset 1078
Item04_cp.bmp: PC bitmap, Windows 3.x format, 1765 x 852 x 8, image size 1506336, cbSize 1507414, bits offset 1078
Item05_cp.bmp: PC bitmap, Windows 3.x format, 1765 x 852 x 8, image size 1506336, cbSize 1507414, bits offset 1078
mystery:       ELF 64-bit LSB pie executable, x86-64, version 1 (SYSV), dynamically linked, interpreter /lib64/ld-linux-x86-64.so.2, for GNU/Linux 3.2.0, BuildID[sha1]=b671dc4e37510bec651d650ed78ea135f8cdf702, not stripped

$ du -h Item01_cp.bmp Item02_cp.bmp Item03_cp.bmp Item04_cp.bmp Item05_cp.bmp mystery
1.5M	Item01_cp.bmp
1.5M	Item02_cp.bmp
1.5M	Item03_cp.bmp
1.5M	Item04_cp.bmp
1.5M	Item05_cp.bmp
16K	mystery
```

## Solution

Let's decompile `mystery` first into C.
I use [Decompiler Explorer, with Hex-Rays output](https://dogbolt.org/?id=e1881629-36cc-4ecf-b36e-39fbd1ecba03).
Well, the code shown here is the pretty version of it!

`mystery.c`:

```mystery.c
long long flag_index;
void *flag;

long long codedChar(int n, char f, char ptr) {
  return (f >> n) & 1 | ptr & 0xFEu;
}

int encodeDataInFile(const char *a1, const char *a2) {
  char ptr;
  FILE *stream = fopen(a1, L"ra");
  FILE *v6 = fopen(a2, L"a");
  int v11 = fread(&ptr, 1uLL, 1uLL, stream);

  if ( !stream ) {
    puts("No output found, please run this on the server");
    exit(0);
  }

  for ( int i = 0; i < 2019; ++i ) {
    fputc(ptr, v6);
    v11 = fread(&ptr, 1uLL, 1uLL, stream);
  }
  for ( int i = 0; i <= 49; ++i ) {
    if ( i % 5 ) {
      fputc(ptr, v6);
      fread(&ptr, 1uLL, 1uLL, stream);
			continue;
    }
    for ( int i = 0; i <= 7; ++i ) {
      fputc(codedChar(i, *((_BYTE *)flag + *(int *)flag_index), ptr), v6);
      fread(&ptr, 1uLL, 1uLL, stream);
    }
    ++*(_DWORD *)flag_index;
  }
  while ( v11 == 1 ) {
    fputc(ptr, v6);
    v11 = fread(&ptr, 1uLL, 1uLL, stream);
  }

  fclose(v6);

  return fclose(stream);
}

long long encodeAll() {
  long long result = 0x622E31306D657449LL;
  long long v1[2];
  _WORD v3[8];
  strcpy((char *)v3, "Item01_cp.bmp");
  v3[7] = 0;
  int v4 = 0;
  v1[0] = 0x622E31306D657449LL;
  v1[1] = 28781LL;

  for ( unsigned char i = 53; (char)i > 48; --i ) {
    BYTE5(v1[0]) = i;
    HIBYTE(v3[2]) = i;
    encodeDataInFile((const char *)v1, (const char *)v3);
    result = (unsigned int)i - 1;
  }

  return result;
}

int main(int argc, const char **argv, const char **envp) {
  char v5;
  flag = &v5;
  int v4 = 0;
  flag_index = (long long)&v4;

  FILE *stream = fopen("flag.txt", L"ra");
  if ( !stream )
    puts("No flag found, please make sure this is run on the server");
  if ( fread(flag, 0x32uLL, 1uLL, stream) <= 0 ) {
    puts("Invalid Flag");
    exit(0);
  }
  fclose(stream);

  encodeAll();

  return 0;
}
```

> [!NOTE]
> BTW, a character (e.g. 'A') has the size of a byte.<br>
> 'byte' and 'character' may be used interchangeably from here.

Overall, the code 'insert' a fifth of the flag to 5 separate image file from the same original `Item01_cp.bmp` into `Item05_cp.bmp` until `Item01_cp.bmp`, with a 4 byte gap between each inserted flag byte.
From `fread(flag, 0x32uLL, 1uLL, stream)`, we can know that the flag is `0x32` or `50` character long.

The main focus here is the `encodeDataInFile` function, responsible for LSB encoding a fifth of the flag and inserting it to one of the image file.

```mystery.c
long long encodeAll() {
  long long result = 0x622E31306D657449LL;
  long long v1[2];
  _WORD v3[8];
  strcpy((char *)v3, "Item01_cp.bmp");
  v3[7] = 0;
  int v4 = 0;
  v1[0] = 0x622E31306D657449LL;
  v1[1] = 28781LL;

  for ( unsigned char i = 53; (char)i > 48; --i ) {
    BYTE5(v1[0]) = i;
    HIBYTE(v3[2]) = i;
    encodeDataInFile((const char *)v1, (const char *)v3);
    result = (unsigned int)i - 1;
  }

  return result; // useless LOL
}
```

It's called from the `encodeAll` function 5 times, inserting a fifth for each image file starting from `Item05_cp.bmp` to `Item01_cp.bmp`.
This happen because `for ( unsigned char i = 53; (char)i > 48; --i )` and `HIBYTE(v3[2]) = i`.
`53` is the [ASCII](https://www.asciitable.com/) character value for `5`, and the loop end with `49` (ASCII's `1`).
We don't have to worry about *how exactly* `HIBYTE()` works, we can know what it does from deduction and that's enough!
`BYTE5(v1[0]) = i` is not a standard function, but we guess based on it's name that it modifies either the 6th or 5th byte of `v1` (`v1` is a 64bit integer with size of 8 byte), but former is more likely.
Why though? If we look at the string representation of `0x622E31306D657449LL`, it would be `b.10metI` or reverse of `Item01.b`.
`Item01.b` to `Item05.b` is the file containing the useless filler bytes.

Alright, now we're moving to `encodeDataInFile()`:

```mystery.c
int encodeDataInFile(const char *a1, const char *a2) {
  char ptr;
  FILE *stream = fopen(a1, L"ra");
  FILE *v6 = fopen(a2, L"a");
  int v11 = fread(&ptr, 1uLL, 1uLL, stream);
	/* --snip-- */
}
```

This part of the code means the first 2019 bytes of each image output is not altered:


```mystery.c
  for ( int i = 0; i < 2019; ++i ) {
    fputc(ptr, v6);
    v11 = fread(&ptr, 1uLL, 1uLL, stream);
  }
```

Then, we have the part where it 'insert' the flag:

```mystery.c
  for ( int i = 0; i <= 49; ++i ) {
    if ( i % 5 ) {
      fputc(ptr, v6);
      fread(&ptr, 1uLL, 1uLL, stream);
			continue;
    }
    for ( int n = 0; n <= 7; ++n ) {
      fputc(codedChar(n, *((_BYTE *)flag + *(int *)flag_index), ptr), v6);
      fread(&ptr, 1uLL, 1uLL, stream);
    }
    ++*(_DWORD *)flag_index;
  }
```

`i` is iterated from `0` to `49`, or in other word 50 times, and only a fifth of that iteration insert the flag byte.
This part of the code will insert 120 characters (`0.8*50 + 50*0.2*8`), including some filler byte.
So, from each `.bmp` file, we just need to use the 120 bytes after the first 2019 bytes.
This will only insert 10 bytes from the flag, so that's why there's 5 output file.
Now, let's break down `*((_BYTE *)flag + *(int *)flag_index)`!

- `*((_BYTE *)flag + *(int *)flag_index)`
  - `*(int *)flag_index)`: dereferences `flag_index` as an integer pointer, returning the value
	- `(_BYTE *)flag` cast the `flag` pointer to a byte pointer
	- `(_BYTE *)flag + *(int *)flag_index` adds value of `flag_index` to the byte pointer (i.e. move pointer forward)
	- The outermost `*` dereferences the byte pointer and return the value

It's basically similar to `flag[flag_index]`.

There's one custom function in that code, `codedChar()`:

```mystery.c
long long codedChar(int n, char f, char ptr) {
  return (f >> n) & 1 | ptr & 0xFEu;
}
```

`(f >> n) & 1` will get the (`n + 1`)th bit (from the right) of `f`, the flag character.
`ptr & 0xFEu` will evaluated to the character at `ptr` (pointer), but with the least significant bit off (0).
It will then return the `|` (OR) both result, basically just the **character at `ptr` but with `f`'s least significant bit**.
This function used 8 times for a flag character, corresponding to each bit in that character.
The way it's used, `n` is iterated from 0 to 7, which means that the least significant bit is put first into the output image.
With that known, we need to concatenate the LSB of these 8 concurrent bytes and we'll get `f`.

What the `if` branch does is to only insert the flag character when `i % 5` is equal to `0`.
This means that there's always a 4 byte gap between each 8 bytes we get from a flag byte.
We'll just ignore these 4 bytes, as can be seen in the final solution (`solve.py`).

And don't forget, after inserting the flag, it put the remaining bytes from `Item0X.b` into `Item0X_cp.bmp`:

```mystery.c
  while ( v6 == 1 ) {
    fputc(ptr, encoded);
    v6 = fread(&ptr, 1uLL, 1uLL, original);
  }
```

Alright, that's everything we need to know!
Here's the Python script to solve this challenge:

```solve.py
# Encoded files
encoded = [open('Item01_cp.bmp', 'rb').read(), open('Item02_cp.bmp', 'rb').read(), open('Item03_cp.bmp', 'rb').read(), open('Item04_cp.bmp', 'rb').read(), open('Item05_cp.bmp', 'rb').read()]

# Reverse the order of the file
for file in encoded[::-1]:
    i = 0          # for ( int i = 0; i <= 49; ++i ); insert 50 byte
    d = ''         # decoded flag byte
    # 120 bytes after the first 2019 bytes
    for c in file[2019:2019+120]:
        if i % 5:
            # a filler byte inserted
            i += 1
        else:
            # concatenate the LSB
            d = str(c & 1) + d
        # a full byte/character
        if len(d) == 8:
            # print the flag character
            print(chr(int(d, 2)), end='')
            d = ''          # emptying for next flag byte
            i += 1          # a flag byte inserted
print() # end line
```

```
$ python3 solve.py
picoCTF{N1c3_R3ver51ng_5k1115_00000000000f9d605bf}
```

Feels good.
I don't know, but the 'Hard' tag on it feels fake.
Many 'Medium' or even some 'Easy' challenge are harder than this.
I'm happy, regardless!

Flag: `picoCTF{N1c3_R3ver51ng_5k1115_00000000000f9d605bf}`
