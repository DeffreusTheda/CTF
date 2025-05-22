# Baby xor

###### Author: **Gengg.**

This is a simple xor challenge🤔

## Files

```sh
> cat output.txt 
20 20 20 20 20 00 30 3d 21 16 15 0d 5f 00 3a 52 2c 2c 1d 0f 5e 3e 1d 5e 01 3a 01 6b 11 10 38 0e 09 51 02 1f 00 0d 38 40 14
```

## Solution

![[Reverse Engineering/Enggang Security/~Baby xor/Screenshot 2024-12-30 at 10.48.06 1.png]]

![[Reverse Engineering/Enggang Security/~Baby xor/Screenshot 2024-12-30 at 10.44.45.png]]

```py
enc = [0x20, 0x20, 0x20, 0x20, 0x20, 0x00, 0x30, 0x3d, 0x21, 0x16, 0x15, 0x0d, 0x5f, 0x00, 0x3a, 0x52, 0x2c, 0x2c, 0x1d, 0x0f, 0x5e, 0x3e, 0x1d, 0x5e, 0x01, 0x3a, 0x01, 0x6b, 0x11, 0x10, 0x38, 0x0e, 0x09, 0x51, 0x02, 0x1f, 0x00, 0x0d, 0x38, 0x40, 0x14]
key = "ensec_sigma"

key_len = len(key)
for i in range(len(enc)):
    print(chr(enc[i] ^ ord(key[i % key_len])), end='')
print()
```

Flag: `ENSEC_CTF{th1s_1s_th3_x0r_b4by_ch4lleng3}`
