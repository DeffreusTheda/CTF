import struct

# Given encrypted flag
enc_flag_hex = "a6d869161e868078527902778bb36050aca976082df6ba6b550a126ba3ec244fac93043e2dffb968551d1169a3e7244880cd593433d2cb5a676c3e55a3e7244880cd593433d2cb5a676c3e55a3e7244880cd593433d2cb5a676c3e55a3e7244880cd593433d2cb5a2e25771ceaae6d01"  # Replace with actual hex string from challenge
enc_flag = bytes.fromhex(enc_flag_hex)

# Known plaintext (first block)
known_plaintext = b"RAMADAN{"

# Helpers for 64-bit packing/unpacking
p64 = lambda x: struct.pack('<Q', x)
u64 = lambda x: struct.unpack('<Q', x)[0]

# Extract IV and first ciphertext block
iv = enc_flag[:8]
c1 = enc_flag[8:16]

# Solve for key
key = p64(u64(known_plaintext) ^ u64(iv) ^ u64(c1))

print(f"Recovered Key: {key.hex()}")

# Decrypt function
def decrypt(ciphertext, key):
    iv, ciphertext = ciphertext[:8], ciphertext[8:]
    plaintext = b''

    for i in range(0, len(ciphertext), 8):
        c_block = ciphertext[i:i+8]
        p_block = p64(u64(iv) ^ u64(c_block) ^ u64(key))
        plaintext += p_block
        iv = c_block  # Update IV

    return plaintext.rstrip(plaintext[-1:])

# Decrypt the full flag
flag = decrypt(enc_flag, key)
print(f"Decrypted FLAG: {flag.decode()}")

