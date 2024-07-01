from z3 import *

def printSolve():
    a = BitVec('a', 64)
    b = BitVec('b', 64)
    c = BitVec('c', 64)
    d = BitVec('d', 64)
    e = BitVec('e', 64)
    f = BitVec('f', 64)
    
    solve(
        100000000 < a,
        a <= 999999999,
        100000000 < b,
        b <= 999999999,
        100000000 < c,
        c <= 999999999,
        100000000 < d,
        d <= 999999999,
        100000000 < e,
        e <= 999999999,
        100000000 < f,
        f <= 999999999,
        4139449 == (a - b + c) % 0x10ae961,
        4139449 == URem((a - b + c), 0x10ae961),
        9166034 == URem((a + b), 0x1093a1d),
        556569677 == (3 * a - 2 * b) % (a ^ d),
        12734 == URem((b & (c + a)), 0x6e22),
        540591164 == URem((b + d), a),
        1279714 == URem((c ^ (d + f)), 0x1ce628),
        17026895 == URem((e - f), 0x1172502),
        23769303 == URem((e + f), 0x2e16f83),
    )

# printSolve()

#: After running that funtion, just do this now:
answer = [
    705965527,
    780663452,
    341222189,
    465893239,
    966221407,
    217433792
]

for ans in answer:
    print(format(ans, 'x'),end='')
