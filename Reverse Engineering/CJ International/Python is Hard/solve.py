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
    for i in range(0, 36, 1):
        tmp = 0
        for j in range(1):
            try:
                tmp |= (ord(inp[i + j]) << (j * 8))
            except IndexError:
                break
        c.append(tmp)
    
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

    for check in checks:
        print(f'{check = }')
    
    return all(checks)

def solve():
    s = Solver()
    c = [BitVec(f'c{i}', 32) for i in range(36)]
    # b = [BitVec(f'b{i}', 32) for i in range(36//2)]
    # a = [BitVec(f'b{i}', 32) for i in range(36//4)]

    for x in c:
        s.add(x >= 0x00000020, x <= 0x0000007e)
    
    # # a - b
    # for i in range(36//4):
    #     a[i] & 0x0000FFFF == b[i*2]
    #     LShR(a[i] & 0xFFFF0000, 16) == b[i*2+1]
    
    # # a - c
    # for i in range(36//4):
    #     s.add(a[i]      & 0x000000FF      == c[i*4])
    #     s.add(LShR(a[i] & 0x0000FF00,  8) == c[i*4+1])
    #     s.add(LShR(a[i] & 0x00FF0000, 16) == c[i*4+2])
    #     s.add(LShR(a[i],              24) == c[i*4+3])

    # # b - c
    # for i in range(36//2):
    #     s.add(b[i] & 0x00FF == c[i*2])
    #     s.add(LShR(b[i], 8) == c[i*2+1])

    s.add(( (c[3*4]|(c[3*4+1]<<8)|(c[3*4+2]<<16)|(c[3*4+3]<<24)) + ( c[ 5*2]|(c[ 5*2+1]) +  c[15*2]|(c[15*2+1])) ^ (c[12]   +  c[ 5]  -  c[28]) ^  c[19]  ^ 1337)  == 1634073638)
    s.add(( (c[8*4]|(c[8*4+1]<<8)|(c[8*4+2]<<16)|(c[8*4+3]<<24)) ^ ( c[16*2]|(c[16*2+1]) ^  c[ 7*2]|(c[ 7*2+1])) ^ (c[ 2]   +  c[33]  +  c[22]  +  c[ 8]  - 1337)) == -892560024)
    s.add(( (c[2*4]|(c[2*4+1]<<8)|(c[2*4+2]<<16)|(c[2*4+3]<<24)) + ( c[10*2]|(c[10*2+1]) +  c[ 2*2]|(c[ 2*2+1])) ^ (c[ 3]   +  c[20]) ^ (c[ 7]  -  c[25]  + 1337)) == 1767917691)
    s.add(( (c[5*4]|(c[5*4+1]<<8)|(c[5*4+2]<<16)|(c[5*4+3]<<24)) + ( c[14*2]|(c[14*2+1]) -  c[13*2]|(c[13*2+1])  +  c[10])  ^ (c[11]  -  c[29]) ^ (c[13]  + 1337)) == 1948741702)
    s.add(( (c[4*4]|(c[4*4+1]<<8)|(c[4*4+2]<<16)|(c[4*4+3]<<24)) + ( c[ 4*2]|(c[ 4*2+1]) -  c[17*2]|(c[17*2+1])  +  c[ 1])  ^ (c[16]  -  c[27]  -  c[26]) ^ 1337)  == 1767849594)
    s.add(( (c[1*4]|(c[1*4+1]<<8)|(c[1*4+2]<<16)|(c[1*4+3]<<24)) + ( c[ 6*2]|(c[ 6*2+1]) -  c[12*2]|(c[12*2+1])  +  c[18])  ^ (c[ 4]  -  c[17]) ^  c[23]  ^ 1337)  == 1769100975)
    s.add(( (c[0*4]|(c[0*4+1]<<8)|(c[0*4+2]<<16)|(c[0*4+3]<<24)) ^ ( c[ 0*2]|(c[ 0*2+1]) ^ (c[ 1*2]|(c[ 1*2+1])  -  c[ 9])) ^ (c[21]  -  c[30]  +  c[32]  + 1337)) == 1635149008)
    s.add(( (c[6*4]|(c[6*4+1]<<8)|(c[6*4+2]<<16)|(c[6*4+3]<<24)) + ( c[ 8*2]|(c[ 8*2+1]) -  c[ 9*2]|(c[ 9*2+1])  -  c[31]   -  c[14]  -  c[ 6]  -  c[35]  - 1337)) == 1601459038)
    s.add(( (c[7*4]|(c[7*4+1]<<8)|(c[7*4+2]<<16)|(c[7*4+3]<<24)) + ( c[ 3*2]|(c[ 3*2+1]) -  c[11*2]|(c[11*2+1])  -  c[15]   +  c[ 0]  -  c[24]  -  c[34]  - 1337)) ==  809005425)

    # illegal chars

    # while True:
    # print(s)
    if s.check() == sat:
        model = s.model()
        flag = ''.join([chr(model[x].as_long()) for x in c])
        if check_flag(flag):
            print("FOUND:", flag)
        else:
            print("Shitt:", flag)
    else:
        print("No solution found")

if __name__ == "__main__":
    solve()
