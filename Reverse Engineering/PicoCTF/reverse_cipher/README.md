# reverse_cipher

###### Author: Danny Tunitis

We have recovered a [binary](https://jupiter.challenges.picoctf.org/static/48babf8f8c4c6b8baf336680ea5b9ddf/rev) and a [text file](https://jupiter.challenges.picoctf.org/static/48babf8f8c4c6b8baf336680ea5b9ddf/rev_this).
Can you reverse the flag.

<details><summary>Hint</summary>
objdump and Gihdra are some tools that could assist with this
</details>

## Files

```sh
> file rev rev_this
rev:      ELF 64-bit LSB pie executable, x86-64, version 1 (SYSV), dynamically linked, interpreter /lib64/ld-linux-x86-64.so.2, for GNU/Linux 3.2.0, BuildID[sha1]=523d51973c11197605c76f84d4afb0fe9e59338c, not stripped
rev_this: ASCII text, with no line terminators
```

```sh
> cat rev_this
picoCTF{w1{1wq8/7376j.:}
```

We got an x86_64 ELF binary, and a text file, presumably the output of the cipher.

## Solution

This is what the main function looks like:

![[Reverse Engineering/PicoCTF/reverse_cipher/Screenshot 2025-01-01 at 16.46.04.png]]

There's no function call or anything,
and all the cipher logic is there...

It reads the flag from `flag.txt`, and from the second argument of `fread` we know the length is 24.
This can be backup by the length of the output file `rev_this`!

Now to the 'cipher':
1. It simply prints the first 8 bytes of the flag, effectively skipping it. These first bytes are `picoCTF{`.
2. For index 8 until 22, it it's even, it adds 5 or else it subtract 2 from the bytes.
3. Lastly, it prints the closing bracket of the flag, `}`.

That's simple!
Just reverse back these addition or subtraction!

## Solver

```python
   1   │ output = b"picoCTF{w1{1wq8/7376j.:}"
   2   │ 
   3   │ print("picoCTF{", end='')
   4   │ 
   5   │ for i in range(8, 0x17):
   6   │     if i & 1 == 0:
   7   │         print(f'{chr(output[i] - 5)}', end='')
   8   │     else:
   9   │         print(f'{chr(output[i] + 2)}', end='')
  10   │ print("}")
```

```sh
> python3 solve.py
picoCTF{r3v3rs312528e05}
```

Flag: `picoCTF{r3v3rs312528e05}`