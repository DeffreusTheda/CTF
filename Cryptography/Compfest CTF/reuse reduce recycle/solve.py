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
    result = encrypt(bytes(key), 'a'.encode()).hex()
    if result == 'd28ad6327393868dc7081a1916f4dc16':
        break
    key = os.urandom(16)
print(f'key: int = {key}')
