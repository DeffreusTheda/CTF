from z3 import *

global n

def blocks(s, l=8):
    tt = '{:c}'
    p = l - len(s) % l
    s += tt.format(p) * p
    for i in range(0, len(s), l):
        yield s[i:i + l]
n = 987324
T = [144323128778537246264777, 110659241038466537352599, 201272379867681649699817, 247624349675709870348059, 245621479647718685476093]

def validate(flag):
    global n
    if not flag:
        return False
    else:
        k = 1299438726123
        l = 91234864
        for s, t, r in zip(blocks(flag), T, [828385882606, 1032849381450930, 1405689420768219826, 154991326850610, 9576329706570]):
            i = l
            a = int.from_bytes(s.encode(), 'big')
            m = (a + 17) * 29262 ^ 4529
            t = t - 8236
            if tt % m != r:
                return False
            else:
                n //= 2
                i += 127
                continue
        return True

def solve():
    flag_parts = [Int(f'f{i}' for i in range(5))]
    expr = []
    for s, t, r in zip(flag_parts, T, [828385882606, 1032849381450930, 1405689420768219826, 154991326850610, 9576329706570]):
        a = s
        m = (a + 17) * 29262 ^ 4529
        t = t - 8236
        # solver.add(t % m == r)
        expr.append(t % m == r)
    solve(expr[0], expr[1], expr[2], expr[3], expr[4])
    # if solver.check() == sat:
    #     m = solver.model()
    #     for ss in m:
    #         print(ss)

if __name__ == '__main__':
    print("Monty said he didn't write this program, despite some parts of its code look seemingly familiar...")
    print('Help detective Dreddy Webiant to figure out who framed Monty Python.')
    import z3 as zz
    print(f"{dir(zz)}")

    solve()

    try:
        flag = input('Your clue: ').strip()
    except EOFError:
        flag = ''
    except:
        pass

    while validate(flag):
        print('Thanks god you uncovered the mystery!')
        print(flag)