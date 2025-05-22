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
        ((a[3] + (b[5] + b[15]) ^ (c[12] + c[5] - c[28]) ^ c[19] ^ 1337) == 1634073638),
        ((a[8] ^ (b[16] ^ b[7]) ^ (c[2] + c[33] + c[22] + c[8] - 1337)) == -892560024),
        ((a[2] + (b[10] + b[2]) ^ (c[3] + c[20]) ^ (c[7] - c[25] + 1337)) == 1767917691),
        ((a[5] + (b[14] - b[13] + c[10]) ^ (c[11] - c[29]) ^ (c[13] + 1337)) == 1948741702),
        ((a[4] + (b[4] - b[17] + c[1]) ^ (c[16] - c[27] - c[26]) ^ 1337) == 1767849594),
        ((a[1] + (b[6] - b[12] + c[18]) ^ (c[4] - c[17]) ^ c[23] ^ 1337) == 1769100975),
        ((a[0] ^ (b[0] ^ (b[1] - c[9])) ^ (c[21] - c[30] + c[32] + 1337)) == 1635149008),
        ((a[6] + (b[8] - b[9] - c[31] - c[14] - c[6] - c[35] - 1337)) == 1601459038),
        ((a[7] + (b[3] - b[11] - c[15] + c[0] - c[24] - c[34] - 1337)) == 809005425)
    ]
    
    return all(checks)

def main():
    flag = input("Input flag: ")
    if len(flag) != 36:
        print("failed")
        return
        
    if check_flag(flag):
        print("congrats")
    else:
        print("failed")

if __name__ == "__main__":
    main()
