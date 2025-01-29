# reuse reduce recycle Writeup by Deffreus - CompfestCTF 16

###### Author: fahrul

## Description

I changed the mode to CTR, nothing can go wrong right?

`nc challenges.ctf.compfest.id 20016`

[chall.py](https://ctf.compfest.id/files/34c5a9e0ab2151ad92e8991113cace9e/chall.py?token=eyJ1c2VyX2lkIjo3MiwidGVhbV9pZCI6MzA3LCJmaWxlX2lkIjo0Mn0.Zq-X6Q.l65HRJowLAhqy56H84yt0m3r5wY)

## Files

`chall.py`:

```chall.py
from Crypto.Cipher import AES
from Crypto.Util.Padding import pad,unpad
import os

def encrypt(key, plaintext):
    cipher = AES.new(key, AES.MODE_CTR, nonce=IV)
    return cipher.encrypt(pad(plaintext, 16))

def decrypt(key, ciphertext):
    cipher = AES.new(key, AES.MODE_CTR, nonce=IV)
    return unpad(cipher.decrypt(ciphertext), 16)

def menu():
    print("1. Encrypt Message")
    print("2. Get Flag")
    print("3. Exit")
    choice = int(input(">> "))
    return choice

key = os.urandom(16)
IV = os.urandom(8)

while True:
    choice = menu()
    if choice == 1:
        plaintext = input("Message: ")
        print("Encrypted Message (hex):", encrypt(key, plaintext.encode()).hex())
    elif choice == 2:
        print("Encrypted Message (hex):", encrypt(key, b"COMPFEST16{RETACDED}").hex())
     
    elif choice == 3:
        break
```



## Solution

Some namer:

- `ef`: encrypted flag (hex)
- `pt`: plaintext flag
- `ct`: ciphertext flag

The encrypted flag from the server is `7752825ebccec486be54e208da167b1dde891ecd74d4f1c625a797cceb8329442b6fc0907497347e331b50740da94e6f`.
Through experimenting, the key length is 32 <= n < 48, because n lower or higher than that would produce an encrypted message with different length compared to `ef`.
Why?
Because when some `pt` is encrypted in CTR mode, the `ct` size is exactly of the same size as `pt`, since CTR mode is similar to a stream cipher.

The description said, "I changed the mode to CTR, nothing can go wrong right?".
According to [this](https://www.dlitz.net/software/pycrypto/api/2.6/Crypto.Cipher.AES-module.html), the `IV` parameter is ignored and is constant throughout multiple encryption.
This means that we would have to only guess the `key`.

