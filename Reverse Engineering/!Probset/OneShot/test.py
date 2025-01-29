def expand_bits(v):
    """Spread bits for Morton encoding"""
    v = (v | (v << 16)) & 0x030000FF
    v = (v | (v << 8))  & 0x0300F00F
    v = (v | (v << 4))  & 0x030C30C3
    v = (v | (v << 2))  & 0x09249249
    return v

def morton_encode_3d(x, y, z):
    """Interleave 3 bytes into Morton code"""
    return expand_bits(x) | (expand_bits(y) << 1) | (expand_bits(z) << 2)

# Validate
data = b'4ND_R37R13V3_17_L473R_1N_7H'
expected = [1773468, 985071, 984495, 984751, 984959, 853983, 1509663, 1511295, 1510271]

for i in range(9):
    x, y, z = data[i*3], data[i*3+1], data[i*3+2]
    result = morton_encode_3d(x, y, z)
    # print(f"Group {i}: ({chr(x)},{chr(y)},{chr(z)}) = ({x},{y},{z}) -> {result} (expected {expected[i]}) {'✓' if result == expected[i] else '✗'}")
    print(f'{result}')
