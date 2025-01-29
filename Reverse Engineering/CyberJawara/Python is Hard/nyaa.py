from z3 import *

def solve_flag():
    s = Solver()
    
    inp = [BitVec(f'_{i}', 32) for i in range(36)]
    
    # Add constraints for printable ASCII characters (32-126)
    for i in range(36):
        s.add(inp[i] >= 33)
        s.add(inp[i] <= 127)

    a = []
    for i in range(0, 36, 4):
        tmp = inp[i]
        for j in range(1, 4):
            tmp |= (inp[i + j] << (j * 8))
        a.append(tmp)
    
    b = []
    for i in range(0, 36, 2):
        tmp = inp[i]
        for j in range(1, 2):
            tmp |= (inp[i + j] << (j * 8))
        b.append(tmp)
    
    c = inp[:36]

    s.add(a[3] + (b[5] + b[15]) ^ (c[12] + c[5] - c[28]) ^ c[19] ^ 1337 == 1634073638)
    s.add(a[8] ^ (b[16] ^ b[7]) ^ (c[2] + c[33] + c[22] + c[8] - 1337) == -892560024)
    s.add(a[2] + (b[10] + b[2]) ^ (c[3] + c[20]) ^ (c[7] - c[25] + 1337) == 1767917691)
    s.add(a[5] + (b[14] - b[13] + c[10]) ^ (c[11] - c[29]) ^ (c[13] + 1337) == 1948741702)
    s.add(a[4] + (b[4] - b[17] + c[1]) ^ (c[16] - c[27] - c[26]) ^ 1337 == 1767849594)
    s.add(a[1] + (b[6] - b[12] + c[18]) ^ (c[4] - c[17]) ^ c[23] ^ 1337 == 1769100975)
    s.add(a[0] ^ (b[0] ^ (b[1] - c[9])) ^ (c[21] - c[30] + c[32] + 1337) == 1635149008)
    s.add(a[6] + (b[8] - b[9] - c[31] - c[14] - c[6] - c[35] - 1337) == 1601459038)
    s.add(a[7] + (b[3] - b[11] - c[15] + c[0] - c[24] - c[34] - 1337) == 809005425)

    if s.check() == sat:
        m = s.model()
        result = []
        for i in range(36):
            result.append(m[inp[i]].as_long())
        return result
    else:
        print("No solution found", end='')
        return [0]

print(''.join(chr(c) for c in solve_flag()))
