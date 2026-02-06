import os
import struct

FLAG = os.getenv("FLAG", "RAMADAN{testing}").encode()
assert FLAG.startswith(b"RAMADAN{") and FLAG.endswith(b"}")

KEY_SIZE = 8
KEY = os.urandom(KEY_SIZE)

p64 = lambda x: struct.pack('<Q', x)
u64 = lambda x: struct.unpack('<Q', x)[0]

def encrypt(plaintext, key):
    padlen = KEY_SIZE - (len(plaintext) % KEY_SIZE)
    plaintext += bytes([padlen] * padlen)

    iv = os.urandom(KEY_SIZE)
    ciphertext = iv
    for i in range(0, len(plaintext), KEY_SIZE):
        p_block = plaintext[i:i+KEY_SIZE]
        c_block = p64(u64(iv) ^ u64(p_block) ^ u64(key))
        ciphertext += c_block
        iv = c_block

    return ciphertext

def decrypt(ciphertext, key):
    iv, ciphertext = ciphertext[:KEY_SIZE], ciphertext[KEY_SIZE:]

    plaintext = b''
    for i in range(0, len(ciphertext), KEY_SIZE):
        c_block = ciphertext[i:i+KEY_SIZE]
        p_block = p64(u64(iv) ^ u64(c_block) ^ u64(key))
        plaintext += p_block
        iv = c_block

    return plaintext.rstrip(plaintext[-1:])

if __name__ == '__main__':
    FLAG = FLAG.ljust(8 * 12, b'A')  
    ENC_FLAG = encrypt(FLAG, KEY)
    print("Nih Bang!, pecahin yak:", ENC_FLAG.hex())
    assert decrypt(ENC_FLAG, KEY) == FLAG
