from z3 import *

# Define 36 symbolic BitVec variables, one for each character in `inp`
inp = [BitVec(f'inp_{i}', 32) for i in range(36)]

# Initialize lists `a`, `b`, and `c` based on transformed values of `inp`
a, b, c = [], [], []

# Solver instance
s = Solver()

# Constraint each character in `inp` to be within printable ASCII range (32-126)
for ch in inp:
    s.add(ch >= 32, ch <= 126)

# Construct `a`: Groups of 4 characters
for i in range(0, 36, 4):
    tmp = inp[i] | (inp[i + 1] << 8) | (inp[i + 2] << 16) | (inp[i + 3] << 24)
    a.append(tmp)

# Construct `b`: Groups of 2 characters
for i in range(0, 36, 2):
    tmp = inp[i] | (inp[i + 1] << 8)
    b.append(tmp)

# Construct `c`: Each character individually
for i in range(36):
    c.append(inp[i])

# Ensure constants are BitVec types matching the type of variables
const_1337 = BitVecVal(1337, 32)
const_1634073638 = BitVecVal(1634073638, 32)
const_neg_892560024 = BitVecVal(-892560024, 32)
const_1767917691 = BitVecVal(1767917691, 32)
const_1948741702 = BitVecVal(1948741702, 32)
const_1767849594 = BitVecVal(1767849594, 32)
const_1769100975 = BitVecVal(1769100975, 32)
const_1635149008 = BitVecVal(1635149008, 32)
const_1601459038 = BitVecVal(1601459038, 32)
const_809005425 = BitVecVal(809005425, 32)

# Add constraints based on original checks, with explicit parentheses for clarity
s.add((a[3] + ((b[5] + b[15]) ^ ((c[12] + c[5] - c[28]) ^ c[19] ^ const_1337))) == const_1634073638)
s.add((a[8] ^ ((b[16] ^ b[7]) ^ ((c[2] + c[33] + c[22] + c[8] - const_1337))) == const_neg_892560024))
s.add((a[2] + ((b[10] + b[2]) ^ ((c[3] + c[20]) ^ (c[7] - c[25] + const_1337))) == const_1767917691))
s.add((a[5] + ((b[14] - b[13] + c[10]) ^ ((c[11] - c[29]) ^ (c[13] + const_1337))) == const_1948741702))
s.add((a[4] + ((b[4] - b[17] + c[1]) ^ ((c[16] - c[27] - c[26]) ^ const_1337)) == const_1767849594))
s.add((a[1] + ((b[6] - b[12] + c[18]) ^ ((c[4] - c[17]) ^ c[23] ^ const_1337)) == const_1769100975))
s.add((a[0] ^ ((b[0] ^ (b[1] - c[9])) ^ ((c[21] - c[30] + c[32] + const_1337))) == const_1635149008))
s.add((a[6] + ((b[8] - b[9] - c[31] - c[14] - c[6] - c[35] - const_1337)) == const_1601459038))
s.add((a[7] + ((b[3] - b[11] - c[15] + c[0] - c[24] - c[34] - const_1337)) == const_809005425))

# Check if the solver can satisfy all constraints
if s.check() == sat:
    model = s.model()
    # Retrieve the solution for `inp` as a string
    flag = ''.join(chr(model[inp[i]].as_long()) for i in range(36))
    print("Solution found:", flag)
else:
    print("No solution found")

