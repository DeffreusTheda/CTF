from z3 import *

def debug_check_flag(inp):
    # Initialize arrays to store processed values
    a = []
    b = []
    c = []
    
    print("\nDebug Information:")
    print("Input string:", inp)
    print("\nProcessing arrays:")
    
    # Process input in groups of 4 characters (a array)
    print("\nArray a (4-char groups):")
    for i in range(0, 36, 4):
        tmp = 0
        for j in range(4):
            try:
                char_val = ord(inp[i + j])
                shift = j * 8
                component = char_val << shift
                tmp |= component
                print(f"Position {i+j}: char='{inp[i+j]}' ord={char_val} shift={shift} component={component:08x}")
            except IndexError:
                break
        a.append(tmp)
        print(f"Group {i//4}: {tmp:08x}")
    
    # Process input in groups of 2 characters (b array)
    print("\nArray b (2-char groups):")
    for i in range(0, 36, 2):
        tmp = 0
        for j in range(2):
            try:
                char_val = ord(inp[i + j])
                shift = j * 8
                component = char_val << shift
                tmp |= component
                print(f"Position {i+j}: char='{inp[i+j]}' ord={char_val} shift={shift} component={component:04x}")
            except IndexError:
                break
        b.append(tmp)
        print(f"Group {i//2}: {tmp:04x}")
    
    # Process input one character at a time (c array)
    print("\nArray c (single chars):")
    for i in range(36):
        try:
            tmp = ord(inp[i])
            c.append(tmp)
            print(f"Position {i}: char='{inp[i]}' ord={tmp:02x}")
        except IndexError:
            break
    
    # Debug each check individually
    checks = []
    print("\nChecking constraints:")
    
    # Check 1
    val1 = (a[3] + (b[5] + b[15]) ^ (c[12] + c[5] - c[28]) ^ c[19] ^ 1337)
    print(f"Check 1: {val1} == 1634073638")
    checks.append(val1 == 1634073638)
    
    # Check 2
    val2 = (a[8] ^ (b[16] ^ b[7]) ^ (c[2] + c[33] + c[22] + c[8] - 1337))
    print(f"Check 2: {val2} == -892560024")
    checks.append(val2 == -892560024)
    
    val3 = (a[2] + (b[10] + b[2]) ^ (c[3] + c[20]) ^ (c[7] - c[25] + 1337))
    print(f'Check 3: {val3} == 1767917691')
    checks.append(val3 == 1767917691)
    val4 = (a[5] + (b[14] - b[13] + c[10]) ^ (c[11] - c[29]) ^ (c[13] + 1337))
    print(f'Check 4: {val4} == 1948741702')
    checks.append(val4 == 1948741702)
    val5 = (a[4] + (b[4] - b[17] + c[1]) ^ (c[16] - c[27] - c[26]) ^ 1337)
    print(f'Check 5: {val5} == 1767849594')
    checks.append(val5 == 1767849594)
    val6 = (a[1] + (b[6] - b[12] + c[18]) ^ (c[4] - c[17]) ^ c[23] ^ 1337)
    print(f'Check 6: {val6} == 1769100975')
    checks.append(val6 == 1769100975)
    val7 = (a[0] ^ (b[0] ^ (b[1] - c[9])) ^ (c[21] - c[30] + c[32] + 1337))
    print(f'Check 7: {val7} == 1635149008')
    checks.append(val7 == 1635149008)
    val8 = (a[6] + (b[8] - b[9] - c[31] - c[14] - c[6] - c[35] - 1337))
    print(f'Check 8: {val8} == 1601459038')
    checks.append(val8 == 1601459038)
    val9 = (a[7] + (b[3] - b[11] - c[15] + c[0] - c[24] - c[34] - 1337))
    print(f'Check 9: {val9} == 809005425')
    checks.append(val9 == 809005425)
    
    return all(checks)

def debug_solve():
    s = Solver()
    chars = [BitVec(f'{i}', 8) for i in range(36)]

    # Add printable ASCII constraint
    for c in chars:
        s.add(c >= 32, c <= 126)

    # Create the same arrays as in check_flag
    a = [chars[i] | (chars[i + 1] << 8) | (chars[i + 2] << 16) | (chars[i + 3] << 24) for i in range(0, 36, 4)]
    b = [chars[i] | (chars[i + 1] << 8) for i in range(0, 36, 2)]
    c = chars

    # Add the same constraints
    s.add((a[3] + (b[5] + b[15]) ^ (c[12] + c[5] - c[28]) ^ c[19] ^ 1337) == 1634073638)
    s.add((a[8] ^ (b[16] ^ b[7]) ^ (c[2] + c[33] + c[22] + c[8] - 1337)) == -892560024)
    s.add((a[2] + (b[10] + b[2]) ^ (c[3] + c[20]) ^ (c[7] - c[25] + 1337)) == 1767917691)
    s.add((a[5] + (b[14] - b[13] + c[10]) ^ (c[11] - c[29]) ^ (c[13] + 1337)) == 1948741702)
    s.add((a[4] + (b[4] - b[17] + c[1]) ^ (c[16] - c[27] - c[26]) ^ 1337) == 1767849594)
    s.add((a[1] + (b[6] - b[12] + c[18]) ^ (c[4] - c[17]) ^ c[23] ^ 1337) == 1769100975)
    s.add((a[0] ^ (b[0] ^ (b[1] - c[9])) ^ (c[21] - c[30] + c[32] + 1337)) == 1635149008)
    s.add((a[6] + (b[8] - b[9] - c[31] - c[14] - c[6] - c[35] - 1337)) == 1601459038)
    s.add((a[7] + (b[3] - b[11] - c[15] + c[0] - c[24] - c[34] - 1337)) == 809005425)

    if s.check() == sat:
        model = s.model()
        flag = ''.join([chr(model[c].as_long()) for c in chars])
        print("\nZ3 Solution Found:", flag)
        print("\nValidating solution...")
        debug_check_flag(flag)
        print(model)
    else:
        print("No solution found")


if __name__ == "__main__":
    debug_solve()
