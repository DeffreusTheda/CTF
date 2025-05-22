from Crypto.Cipher import AES
from Crypto.Util.Padding import pad
from Crypto.Util.number import *
from random import getrandbits

FLAG = b'NCW{REDACTED}'

def findrand(intval, stateboolstatus):
    intval = ((intval << 46) | (intval >> 18)) & 18446744073709551615
    if not stateboolstatus:
        return intval & 4294967295, intval
    else:
        return (intval >> 32) & 4294967295, intval
    
intval = getrandbits(64)

keys, ivs = [], []

for i in range(4):
    if i % 2 == 0:
        temp,intval = findrand(intval,stateboolstatus=False)
    elif i % 2 == 1:
        temp,intval = findrand(intval,stateboolstatus=True)
    keys.append(long_to_bytes(temp))

for i in range(4):
    if i % 2 == 0:
        temp,intval = findrand(intval,stateboolstatus=False)
    elif i % 2 == 1:
        temp,intval = findrand(intval,stateboolstatus=True)
    ivs.append(long_to_bytes(temp))

key = b''.join(keys) 
iv = b''.join(ivs)    

cipher = AES.new(key, AES.MODE_CBC, iv)
enc = cipher.encrypt(pad(FLAG,16))

print(f'enc = {enc.hex()}')
print(f'iv = {iv.hex()}')
