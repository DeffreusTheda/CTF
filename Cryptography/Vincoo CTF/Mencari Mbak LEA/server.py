#!/usr/bin/python3
import os
import sys
from hashlib import *

FLAG = os.getenv("FLAG", "VincooCTF{FakeFlagOm}").encode()

def hash1(x: bytes):
    return md5(x).digest()

def hash2(x: bytes):
    return sha1(x).digest()

def hash3(x: bytes):
    return sha256(x).digest()

def hash4(x: bytes):
    return sha512(x).digest()

def challenge(hash):
    m = os.urandom(16)
    print(f"hash: {hash(m).hex()}")
    sys.stdout.flush() 
    
    try:
        evil_text = bytes.fromhex(input().strip()) 
        evil_hash = bytes.fromhex(input().strip())
    except:
        print("Format input harus hex string!")
        return False

    if hash(m + evil_text) != evil_hash:
        print("Eror Woy!!")
        return False
    if b"Bagi flagnya dong om..." not in evil_text:
        print("Wlekk salah lu wok?")
        return False
    return True

def challenges():
    sys.stdout.reconfigure(line_buffering=True)
    
    for h in [hash1, hash2, hash3, hash4]:
        if not challenge(h):
            print("Nub Banget lu Coy!")
            return
    print(f"Ni flagnya wok!: {FLAG.decode()}")

if __name__ == "__main__":
    challenges()
