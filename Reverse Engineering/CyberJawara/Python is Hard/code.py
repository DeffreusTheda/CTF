from z3 import *

# Define 36 symbolic BitVec variables, one for each character in `inp`
inp = [BitVec(f'_{i}', 8) for i in range(36)]

# Initialize lists `a`, `b`, and `c` based on transformed values of `inp`
a, b, c = [], [], []

# Solver instance
s = Solver()

# Construct `a`: Groups of 4 characters
for i in range(0, 36, 4):
    a.append(inp[i] | (inp[i + 1] << 8) | (inp[i + 2] << 16) | (inp[i + 3] << 24))

# Construct `b`: Groups of 2 characters
for i in range(0, 36, 2):
    b.append(inp[i] | (inp[i + 1] << 8))

# Construct `c`: Each character individually
for i in range(36):
    c.append(inp[i])

# Add constraints based on original checks
# s.add(a[3] + (b[5] + b[15]) ^ (c[12] + c[5] - c[28]) ^ c[19] ^ 1337 == 1634073638)
# s.add(a[8] ^ (b[16] ^ b[7]) ^ (c[2] + c[33] + c[22] + c[8] - 1337) == -892560024)
# s.add(a[2] + (b[10] + b[2]) ^ (c[3] + c[20]) ^ (c[7] - c[25] + 1337) == 1767917691)
# s.add(a[5] + (b[14] - b[13] + c[10]) ^ (c[11] - c[29]) ^ (c[13] + 1337) == 1948741702)
# s.add(a[4] + (b[4] - b[17] + c[1]) ^ (c[16] - c[27] - c[26]) ^ 1337 == 1767849594)
# s.add(a[1] + (b[6] - b[12] + c[18]) ^ (c[4] - c[17]) ^ c[23] ^ 1337 == 1769100975)
# s.add(a[0] ^ (b[0] ^ (b[1] - c[9])) ^ (c[21] - c[30] + c[32] + 1337) == 1635149008)
# s.add(a[6] + (b[8] - b[9] - c[31] - c[14] - c[6] - c[35] - 1337) == 1601459038)
# s.add(a[7] + (b[3] - b[11] - c[15] + c[0] - c[24] - c[34] - 1337) == 809005425)
s.add(a[3] + (b[5] + b[15]) ^ (c[12] + c[5] - c[28]) == 1634072950)
s.add(a[8] ^ (b[16] ^ b[7]) ^ (118 + c[33] + c[22] + c[8] - 1337) == -892560024)
s.add(a[2] + (b[10] + b[2]) ^ (97 + c[20]) ^ (c[7] - c[25] + 1337) == 1767917691)
s.add(a[5] + (b[14] - b[13] + c[10]) ^ (105 - c[29]) ^ (c[13] + 1337) == 1948741702)
s.add(a[4] + (b[4] - b[17] + c[1]) ^ (c[16] - c[27] - c[26]) ^ 1337 == 1767849594)
s.add(a[1] + (b[6] - b[12] + c[18]) ^ (c[4] - c[17]) ^ 116 ^ 1337 == 1769100975)
s.add(a[0] ^ (b[0] ^ (b[1] - c[9])) ^ (c[21] - c[30] + c[32] + 1337) == 1635149008)
s.add(a[6] + (b[8] - b[9] - c[31] - c[14] - c[6] - c[35] - 1337) == 1601459038)
s.add(a[7] + (b[3] - b[11] - 97 + c[0] - c[24] - c[34] - 1337) == 809005425)

# s.add(c[15] == 97)
# s.add(c[11] == 105)
# s.add(c[23] == 116)
s.add(c[19] == 105)
s.add(c[ 7] == 105)
# s.add(c[ 3] == 97)
# s.add(c[ 2] == 118)
s.add(c[27] == 95)
s.add(c[31] == 48)

# Constraint each character in `inp` to be within printable ASCII range (32-126)
for ch in inp:
    s.add(ch >= 32, ch <= 126)

# Check if the solver can satisfy all constraints
charfreq = [{} for _ in range(36)]
while input() == '':
    if s.check() == sat:
        model = s.model()
        flag = ''.join(chr(model[inp[i]].as_long()) for i in range(36))
        print("Solution found:", flag)
    else:
        print("No solution found")
print(charfreq)

