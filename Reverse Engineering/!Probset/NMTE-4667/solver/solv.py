from z3 import *
import numpy as np
import sys

def mkmatrix(name, rows, cols):
    return [[Int(f"{name}{i}{j}") for j in range(cols)] for i in range(rows)]

def unb64(value):
    if 0 <= value <= 25:  # A-Z
        return chr(int(value) + 65)
    elif 26 <= value <= 35:  # 0-9
        return chr(int(value) + 22)  # 26->48='0'
    elif value == 36: return '_'
    elif value == 37: return ','
    elif value == 38: return '?'
    elif value == 39: return '!'
    elif value == 40: return '-'
    elif value == 41: return '{'
    elif value == 42: return '}'
    else: return '?'

def matmult(A, B, C):
    constraints = []
    rows_A, cols_A = len(A), len(A[0])
    rows_B, cols_B = len(B), len(B[0])
    
    for i in range(rows_A):
        for j in range(cols_B):
            # C[i][j] = sum(A[i][k] * B[k][j] for k in range(cols_A))
            constraints.append(
                C[i][j] == Sum([A[i][k] * B[k][j] for k in range(cols_A)])
            )
    return constraints

output = [line.strip() for line in open(sys.argv[1], 'r')]

def china2arr(china, c):
    return [([ord(x)-19968 for x in china[i:i+c]]) for i in range(0,len(china),c)]

blocks = output[25].split(' ')
print(blocks)

D = china2arr(blocks[0].strip(), 6)
E = china2arr(blocks[1].strip(), 7)
F = china2arr(blocks[2].strip(), 7)
H = china2arr(blocks[3].strip(), 7)
G = china2arr(blocks[4].strip(), 7)

G_np = np.array(G)
H_np = np.array(H)
G_pinv = np.linalg.pinv(G_np)
A_approx = H_np @ G_pinv
A_rounded = np.round(A_approx).astype(int)
A_rounded = np.clip(A_rounded, 0, 42)

# print(A_rounded.tolist(), type(A_rounded))

s = Solver()

# A = mkmatrix("A", 4, 6)
A = A_rounded.tolist()
B = mkmatrix("B", 6, 6)
C = mkmatrix("C", 6, 7)

# baby = True
# if baby:
    # for i in range(len(C)):
        # for j in range(len(C[0])):
            # s.add(C[i][j] == 63)

flag = [e for row in A for e in row]
flag = ''.join([unb64(x) for x in flag])
print(flag)

             # AB = D
s.add(matmult(A, B, D))
             # AC = E
s.add(matmult(A, C, E))
             # BC = F
s.add(matmult(B, C, F))
             # AG = H
s.add(matmult(A, G, H))

for mat in [A, B, C]:
    for row in mat:
        for var in row: s.add(var >= 0, var <= 42)
    
print(f"solving!")
block = []
while s.check() == sat:
    print("found!")

    m = s.model()
    for ss in sorted(m.decls(), key=lambda x: x.name()):
        flag+=unb64(m[ss].as_long())
    print(flag)

    for var in m.decls():
        if (var(), m[var]) not in block:
            block.append((var(), m[var]))
            s.add(Or(var() != m[var]))
            break
else:
    print('done.')
