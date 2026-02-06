# Decompiled with PyLingual (https://pylingual.io)
# Internal filename: chall.py
# Bytecode version: 3.10.0rc2 (3439)
# Source timestamp: 1970-01-01 00:00:00 UTC (0)

from Crypto.Cipher import AES
import base64
import sys
ENC_FLAG = 'moUzGvsTTimEvTPhCph7iG45QRnSxuNT3A7OGC+Ox3bcd5z+44FKW6Y2AB1TY0Pf'
KEY = b'this_is_16byte!!'

def unpad(s):
    return s[:-s[-1]]

def decrypt_flag(enc_b64):
    enc = base64.b64decode(enc_b64)
    cipher = AES.new(KEY, AES.MODE_ECB)
    plain = cipher.decrypt(enc)
    return unpad(plain).decode('utf-8')

def main():
    print('Welcome to the verification challenge!')
    pw = input('Enter password: ')
    if pw == 'open_sesame':
        print("Good. Here's the flag:")
        print(decrypt_flag(ENC_FLAG))
    else:
        print('Wrong password. Try harder!')
if __name__ == '__main__':
    print(decrypt_flag(ENC_FLAG))
