def rol4(val, bits):
    val = val & 0xFFFFFFFF
    bits = bits % 32
    return ((val << bits) | (val >> (32 - bits))) & 0xFFFFFFFF

def ror4(val, bits):
    val = val & 0xFFFFFFFF
    bits = bits % 32
    return ((val >> bits) | (val << (32 - bits))) & 0xFFFFFFFF

def take_number(a1):
    a1 = a1 & 0xFFFFFFFF
    v2 = (-1700506385 * (rol4((-396357609 * a1) & 0xFFFFFFFF, 13) ^ (-396357609 * a1 & 0xFFFFFFFF))) & 0xFFFFFFFF
    v3 = (-1454520113 * (ror4(v2, 5) ^ v2)) & 0xFFFFFFFF
    v4 = (-633224058 * (rol4(v3, 24) ^ v3)) & 0xFFFFFFFF
    return (ror4(v4, 17) ^ v4) & 0xFFFFFFFF

def left_bitwise_rotation(byte, bits):
    byte = byte & 0xFF
    bits = bits % 8
    return ((byte << bits) | (byte >> (8 - bits))) & 0xFF

def right_bitwise_rotation(byte, bits):
    byte = byte & 0xFF
    bits = bits % 8
    return ((byte >> bits) | (byte << (8 - bits))) & 0xFF

def rot13_byte(b):
    if (97 <= b <= 109) or (65 <= b <= 77):
        return (b + 13) % 256
    elif (110 <= b <= 122) or (78 <= b <= 90):
        return (b - 13) % 256
    else:
        return b

# Encrypted message in hex
encrypted_hex = "e9f2e5b941b3cf57bd53324a191af54595217aeb3862924bc8aec9826240a421726fa2a3da7527a01b47354552b33f45acb3ddbde97c6bcd00b6bc1c3baeda92b2babef2d24dcfa6a5f3e746dbc5fe7415ca5c2e654e3608"
C = bytes.fromhex(encrypted_hex)
assert len(C) == 88

# Step 1: Reverse XOR operation
# Assume plaintext starts with "IERA" (ASCII: I=73, E=69, R=82, A=65)
v8 = (73 | (69 << 8) | (82 << 16) | (65 << 24))  # 0x41455249, little-endian
v9 = take_number(v8)
xor_seq = []
for _ in range(88):
    xor_seq.append(v9 & 0xFF)
    v9 = take_number(v9)
S = [c ^ x for c, x in zip(C, xor_seq)]

# Step 2: Reverse block-wise left rotations
# rot_1 sequence: 4, 1, 5, 2, 6, 3 for 6 blocks (5 of 8 bytes, 1 of 4 bytes)
R = []
rot_1_list = [4, 1, 5, 2, 6, 3]
for idx, k in enumerate(rot_1_list):
    start = idx * 8
    end = start + 8 if idx < 5 else 88
    block = S[start:end]
    n = len(block)
    if n > 0:
        block = block[-k:] + block[:-k]  # Right rotate by k positions
    R.extend(block)
assert len(R) == 88

# Step 3: Reverse ROT13 and bitwise rotations
P = []
rot = 0
for i in range(88):
    rot = (rot + 4) % 7 + 1
    if i % 2 == 0:
        temp = right_bitwise_rotation(R[i], rot)  # Reverse left rotation
    else:
        temp = left_bitwise_rotation(R[i], rot)   # Reverse right rotation
    P.append(rot13_byte(temp))

# Convert bytes to string, assuming printable ASCII (e.g., flag format)
decrypted_message = bytes(P).decode('ascii', errors='ignore')
print("Decrypted message (flag):", decrypted_message)
