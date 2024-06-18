# Reverse Writeup by Deffreus - PicoCTF 2022

## Recon

Looking through `bloat.flag.py`, it's seems obfuscated.

## Reverse Engineering

We'll just do find and replace on `a[X]` and we'll eventually get it; Not only variables but also functions.

- De-obfuscation Start: 20:32:40
- De-obfuscation End: 20:51:33

It was at this state that I realized I just needed to input correctly, which is 'happychance':

```bloat-decoded.flag.py
import sys
a = "!\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~ "
def arg122(flag_enc, key):
    long_key = key
    i = 0
    while len(long_key) < len(flag_enc):
        long_key = long_key + key[i]
        i = (i + 1) % len(key)        
    return "".join([chr(ord(arg422) ^ ord(arg442)) for (arg422,arg442) in zip(flag_enc,long_key)])

flag_enc = open('flag.txt.enc', 'rb').read()
if input('Please enter correct password for flag:') != 'happychance':
    print('That password is incorrect')
    sys.exit(0)
print('Welcome back... your flag, user:')
flag = arg122(flag_enc.decode(), 'rapscallion')
print(flag)
sys.exit(0)
```

```/bin/sh python3 bloat-decoded.flag.py 
Please enter correct password for flag:happychance
Welcome back... your flag, user:
picoCTF{d30bfu5c4710n_f7w_161a4f09}
```

> picoCTF{d30bfu5c4710n_f7w_161a4f09}
