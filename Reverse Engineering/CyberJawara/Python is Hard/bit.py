from z3 import *

def check_flag(inp):
    # Initialize arrays to store processed values
    a = []
    b = []
    c = []
    
    # Process input in groups of 4 characters
    for i in range(0, 36, 4):
        tmp = 0
        for j in range(4):
            try:
                tmp |= (ord(inp[i + j]) << (j * 8))
            except IndexError:
                break
        a.append(tmp)
    
    # Process input in groups of 2 characters
    for i in range(0, 36, 2):
        tmp = 0
        for j in range(2):
            try:
                tmp |= (ord(inp[i + j]) << (j * 8))
            except IndexError:
                break
        b.append(tmp)
    
    # Process input one character at a time
    c = [ord(inp[i]) for i in range(36)]
    
    # Validation checks
    checks = [
        (a[3] + (b[5] + b[15]) ^ (c[12] + c[5] - c[28]) ^ c[19] ^ 1337) == 1634073638,
        (a[8] ^ (b[16] ^ b[7]) ^ (c[2] + c[33] + c[22] + c[8] - 1337) == -892560024),
        (a[2] + (b[10] + b[2]) ^ (c[3] + c[20]) ^ (c[7] - c[25] + 1337) == 1767917691),
        (a[5] + (b[14] - b[13] + c[10]) ^ (c[11] - c[29]) ^ (c[13] + 1337) == 1948741702),
        (a[4] + (b[4] - b[17] + c[1]) ^ (c[16] - c[27] - c[26]) ^ 1337 == 1767849594),
        (a[1] + (b[6] - b[12] + c[18]) ^ (c[4] - c[17]) ^ c[23] ^ 1337 == 1769100975),
        (a[0] ^ (b[0] ^ (b[1] - c[9])) ^ (c[21] - c[30] + c[32] + 1337) == 1635149008),
        (a[6] + (b[8] - b[9] - c[31] - c[14] - c[6] - c[35] - 1337) == 1601459038),
        (a[7] + (b[3] - b[11] - c[15] + c[0] - c[24] - c[34] - 1337) == 809005425)
    ]
    
    return all(checks)

def solve():
    s = Solver()
    
    # Create 8-bit BitVecs for the input characters
    chars = [BitVec(f'char_{i}', 8) for i in range(36)]
    
    # Add printable ASCII constraint
    # for c in chars:
        # s.add(c >= 32, c <= 126)
    
    # Create 32-bit values for array a (4-char groups)
    # a = []
    # for i in range(0, 36, 4):
    #     # Create a fresh 32-bit BitVec for each group
    #     group = BitVec(f'a_{i//4}', 32)
    #     # Add constraints to link it with the individual characters
    #     s.add(group == ZeroExt(24, chars[i]) | 
    #                   ZeroExt(24, chars[i+1]) << 8 | 
    #                   ZeroExt(24, chars[i+2]) << 16 | 
    #                   ZeroExt(24, chars[i+3]) << 24)
    #     a.append(group)
    a = [
        ZeroExt(24,chars[ 0]) | ZeroExt(24,chars[ 1])<<8 | ZeroExt(24,chars[ 2])<<16 | ZeroExt(24,chars[ 3])<<24,
        ZeroExt(24,chars[ 4]) | ZeroExt(24,chars[ 5])<<8 | ZeroExt(24,chars[ 6])<<16 | ZeroExt(24,chars[ 7])<<24,
        ZeroExt(24,chars[ 8]) | ZeroExt(24,chars[ 9])<<8 | ZeroExt(24,chars[10])<<16 | ZeroExt(24,chars[11])<<24,
        ZeroExt(24,chars[12]) | ZeroExt(24,chars[13])<<8 | ZeroExt(24,chars[14])<<16 | ZeroExt(24,chars[15])<<24,
        ZeroExt(24,chars[16]) | ZeroExt(24,chars[17])<<8 | ZeroExt(24,chars[18])<<16 | ZeroExt(24,chars[19])<<24,
        ZeroExt(24,chars[20]) | ZeroExt(24,chars[21])<<8 | ZeroExt(24,chars[22])<<16 | ZeroExt(24,chars[23])<<24,
        ZeroExt(24,chars[24]) | ZeroExt(24,chars[25])<<8 | ZeroExt(24,chars[26])<<16 | ZeroExt(24,chars[27])<<24,
        ZeroExt(24,chars[28]) | ZeroExt(24,chars[29])<<8 | ZeroExt(24,chars[30])<<16 | ZeroExt(24,chars[31])<<24,
        ZeroExt(24,chars[32]) | ZeroExt(24,chars[33])<<8 | ZeroExt(24,chars[34])<<16 | ZeroExt(24,chars[35])<<24,
    ]
    # a = [
    #     ZeroExt(24,chars[ 0])<<24 | ZeroExt(24,chars[ 0])<<16 | ZeroExt(24,chars[ 0])<<8 | ZeroExt(24,chars[ 0]),
    #     ZeroExt(24,chars[ 4])<<24 | ZeroExt(24,chars[ 4])<<16 | ZeroExt(24,chars[ 4])<<8 | ZeroExt(24,chars[ 4]),
    #     ZeroExt(24,chars[ 8])<<24 | ZeroExt(24,chars[ 8])<<16 | ZeroExt(24,chars[ 8])<<8 | ZeroExt(24,chars[ 8]),
    #     ZeroExt(24,chars[12])<<24 | ZeroExt(24,chars[13])<<16 | ZeroExt(24,chars[14])<<8 | ZeroExt(24,chars[15]),
    #     ZeroExt(24,chars[16])<<24 | ZeroExt(24,chars[17])<<16 | ZeroExt(24,chars[18])<<8 | ZeroExt(24,chars[19]),
    #     ZeroExt(24,chars[20])<<24 | ZeroExt(24,chars[21])<<16 | ZeroExt(24,chars[22])<<8 | ZeroExt(24,chars[23]),
    #     ZeroExt(24,chars[24])<<24 | ZeroExt(24,chars[25])<<16 | ZeroExt(24,chars[26])<<8 | ZeroExt(24,chars[27]),
    #     ZeroExt(24,chars[28])<<24 | ZeroExt(24,chars[29])<<16 | ZeroExt(24,chars[30])<<8 | ZeroExt(24,chars[31]),
    #     ZeroExt(24,chars[32])<<24 | ZeroExt(24,chars[33])<<16 | ZeroExt(24,chars[34])<<8 | ZeroExt(24,chars[35]),
    # ]
    
    # Create 16-bit values for array b (2-char groups)
    # b = []
    # for i in range(0, 36, 2):
    #     # Create a fresh 16-bit BitVec for each group
    #     group = BitVec(f'b_{i//2}', 16)
    #     # Add constraints to link it with the individual characters
    #     s.add(group == ZeroExt(8, chars[i]) | 
    #                   ZeroExt(8, chars[i+1]) << 8)
    #     b.append(group)
    b = [
        ZeroExt(8, chars[ 0]) | ZeroExt(8, chars[ 1])<<8,
        ZeroExt(8, chars[ 2]) | ZeroExt(8, chars[ 3])<<8,
        ZeroExt(8, chars[ 4]) | ZeroExt(8, chars[ 5])<<8,
        ZeroExt(8, chars[ 6]) | ZeroExt(8, chars[ 7])<<8,
        ZeroExt(8, chars[ 8]) | ZeroExt(8, chars[ 9])<<8,
        ZeroExt(8, chars[10]) | ZeroExt(8, chars[11])<<8,
        ZeroExt(8, chars[12]) | ZeroExt(8, chars[13])<<8,
        ZeroExt(8, chars[14]) | ZeroExt(8, chars[15])<<8,
        ZeroExt(8, chars[16]) | ZeroExt(8, chars[17])<<8,
        ZeroExt(8, chars[18]) | ZeroExt(8, chars[19])<<8,
        ZeroExt(8, chars[20]) | ZeroExt(8, chars[21])<<8,
        ZeroExt(8, chars[22]) | ZeroExt(8, chars[23])<<8,
        ZeroExt(8, chars[24]) | ZeroExt(8, chars[25])<<8,
        ZeroExt(8, chars[26]) | ZeroExt(8, chars[27])<<8,
        ZeroExt(8, chars[28]) | ZeroExt(8, chars[29])<<8,
        ZeroExt(8, chars[30]) | ZeroExt(8, chars[31])<<8,
        ZeroExt(8, chars[32]) | ZeroExt(8, chars[33])<<8,
        ZeroExt(8, chars[34]) | ZeroExt(8, chars[35])<<8,
    ]
    # b = [
    #     ZeroExt(8, chars[ 0])<<8 | ZeroExt(8, chars[ 0]),
    #     ZeroExt(8, chars[ 2])<<8 | ZeroExt(8, chars[ 2]),
    #     ZeroExt(8, chars[ 4])<<8 | ZeroExt(8, chars[ 4]),
    #     ZeroExt(8, chars[ 6])<<8 | ZeroExt(8, chars[ 6]),
    #     ZeroExt(8, chars[ 8])<<8 | ZeroExt(8, chars[ 8]),
    #     ZeroExt(8, chars[10])<<8 | ZeroExt(8, chars[11]),
    #     ZeroExt(8, chars[12])<<8 | ZeroExt(8, chars[13]),
    #     ZeroExt(8, chars[14])<<8 | ZeroExt(8, chars[15]),
    #     ZeroExt(8, chars[16])<<8 | ZeroExt(8, chars[17]),
    #     ZeroExt(8, chars[18])<<8 | ZeroExt(8, chars[19]),
    #     ZeroExt(8, chars[20])<<8 | ZeroExt(8, chars[21]),
    #     ZeroExt(8, chars[22])<<8 | ZeroExt(8, chars[23]),
    #     ZeroExt(8, chars[24])<<8 | ZeroExt(8, chars[25]),
    #     ZeroExt(8, chars[26])<<8 | ZeroExt(8, chars[27]),
    #     ZeroExt(8, chars[28])<<8 | ZeroExt(8, chars[29]),
    #     ZeroExt(8, chars[30])<<8 | ZeroExt(8, chars[31]),
    #     ZeroExt(8, chars[32])<<8 | ZeroExt(8, chars[33]),
    #     ZeroExt(8, chars[34])<<8 | ZeroExt(8, chars[35]),
    # ]
    
    # Array c is just the 8-bit chars array
    c = chars
    
    # Add the validation constraints with proper bit extension
    s.add(a[3] + ZeroExt(16, (b[5] + b[15])) ^ 
          ZeroExt(24, (c[12] + c[5] - c[28])) ^ 
          ZeroExt(24, c[19]) ^ 1337 == 1634073638)
    
    s.add(a[8] ^ ZeroExt(16, (b[16] ^ b[7])) ^ 
        ZeroExt(24, c[2]) + ZeroExt(24, c[33]) + ZeroExt(24, c[22]) + ZeroExt(24, c[8]) - 1337 == -892560024)
    
    s.add(a[2] + ZeroExt(16, (b[10] + b[2])) ^ 
          ZeroExt(24, (c[3] + c[20])) ^ 
          ZeroExt(24, (c[7] - c[25])) + 1337 == 1767917691)
    
    s.add(a[5] + ZeroExt(16, (b[14] - b[13])) + ZeroExt(24, c[10]) ^ 
          ZeroExt(24, (c[11] - c[29])) ^ 
          ZeroExt(24, (c[13])) + 1337 == 1948741702)
    
    s.add(a[4] + ZeroExt(16, (b[4] - b[17])) + ZeroExt(24, c[1]) ^ 
          ZeroExt(24, (c[16] - c[27] - c[26])) ^ 1337 == 1767849594)
    
    s.add(a[1] + ZeroExt(16, (b[6] - b[12])) + ZeroExt(24, c[18]) ^ 
          ZeroExt(24, (c[4] - c[17])) ^ 
          ZeroExt(24, c[23]) ^ 1337 == 1769100975)
    
    s.add(a[0] ^ ZeroExt(16, (b[0] ^ (b[1] - ZeroExt(8, c[9])))) ^ 
          ZeroExt(24, (c[21] - c[30] + c[32])) + 1337 == 1635149008)
    
    s.add(a[6] + ZeroExt(16, (b[8] - b[9])) - 
          ZeroExt(24, (c[31] + c[14] + c[6] + c[35])) + 1337 == 1601459038)
    
    s.add(a[7] + (ZeroExt(16, (b[3] - b[11])) - 
          ZeroExt(24, c[15]) - ZeroExt(24, c[0]) + ZeroExt(24, c[24]) + ZeroExt(24, c[34]) + 1337) == 809005425)

    # From yeah,
    s.add()

    print(s)
    print(s.check())
    if s.check() == sat:
        model = s.model()
        flag = ''
        for c in chars:
            try:
                flag += chr(model[c].as_long())
            except:
                flag += '<?>'
        print(model)
        if check_flag(flag):
            print("FOUND:", flag)
        else:
            print("Failed verification:", flag)
    else:
        print("No solution found")

if __name__ == "__main__":
    solve()
