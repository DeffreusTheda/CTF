import random

def add(A, B, x=1):
    if len(A) != len(B) or len(A[0]) != len(B[0]):
        raise Exception
    res = [[0]*len(A[0]) for i in range(len(A))]
    for i in range(len(A)):
        for j in range(len(A[0])):
            res[i][j] = A[i][j] + B[i][j] * x
    return res

def sub(A, B):
    return add(A, B, -1)

def mxor(A, B):
    if len(A) != len(B) or len(A[0]) != len(B[0]):
        raise Exception
    res = [[0]*len(A[0]) for i in range(len(A))]
    for i in range(len(A)):
        for j in range(len(A[0])):
            res[i][j] = A[i][j] ^ B[i][j]
    return res

def xor(L, key):
    return [L[i] ^ key[i % len(key)] for i in range(len(L))]

def mult(A, B):
    # print('MULT')
    if len(A[0]) != len(B):
        raise Exception
    res = [[0]*len(B[0]) for i in range(len(A))]
    # print(f'{A=}')
    # print(f'{B=}')
    for i in range(len(A)):
    #     print(f'i:{i} ')
        for j in range(len(B[0])):
    #         print(f'j:{j} ')
    #         print(f'[{i}][{j}]={res[i][j]}')
            for k in range(len(A[0])):
    #             print(f'k:{k} ')
                res[i][j] += A[i][k] * B[k][j]
    #             print(f'[{i}][{j}]:[{i}:{k}]:[{k}:{j}]={res[i][j]}={A[i][k]}*{B[k][j]}')
    #         print(f'[{i}][{j}]={res[i][j]}')
    return res

def mkmat(L, r=3, n=0):
    if n != 0 and n > len(L):
        while len(L) < n:
            L += L
        L = L[0:n]
    i = 0
    j = 0
    l = len(L)
    c = l//r
    c += 1 if l/r > l//r else 0
    res = [[0]*c for i in range(r)]
    for x in L:
        x = ord(x) if type(x) == str else x
        res[i][j] = x
        # print(f'res[{i}][{j}]={x}')
        i += 1
        if i == r:
            i = 0
            j += 1
            j %= c
    return res

def c2n(c):
    c = ord(c)
    if c in range(97,123):
        return c - 96
    if c in range(65,91):
        return c - 38
    if c in range(48,58):
        return c + 19
    map = { 33:53, 64:54, 35:55, 36:56, 37:57, 94:58, 38:59, 42:60, 34:61, 63:62, 58:63, 59:64, 47:65, 92:66, 32:77, 123:78, 125:79, 95:80 }
    if c in map.keys():
        return map[c]
    raise Exception

def main():
    flag = 'QNQSEC{1_b3_m47h_4ppl1c4710n5_4nd_1n73rpr374710n_h16h3r_l3v3' # input('Enter the flag: ')
    n = len(flag)
    flag = flag + '?'*n
    mayb = '?'*n + 'A_FLAG{heyy_can_you_look_after_my_cat_i_wanna_catch_the_bus}' # input('Enter another flag (same length): ')
    assert len(flag) == len(mayb)
    keyy = [c2n(c) for c in 'l_53v3n!}'] # input('Enter the key: ')
    flag = [c2n(c) for c in flag]
    mayb = [c2n(c) for c in mayb]

    print('INIT')
    print(f'{flag=}')
    print(f'{mayb=}')
    print(f'{keyy=}')

    keyy = mkmat(keyy, n=len(flag))
    flag = mkmat(flag)
    mayb = mkmat(mayb)

    print('MKMAT')
    print(f'{flag=}')
    print(f'{mayb=}')
    print(f'{keyy=}')
    
    flag = mxor(flag, keyy)
    mayb = mxor(mayb, keyy)

    print('MXOR')
    print(f'{flag=}')
    print(f'{mayb=}')

    random.seed(17)
    ciph = mkmat([random.randint(-4,9) for i in range(len('Have fun!'))])
    flag = mult(ciph,flag)

    print('MULT')
    print(f'{ciph=}')
    print(f'{flag=}')

    o = open('output.bin', 'w')
    o.write(flag.__repr__())
    o.write('\n')
    o.write(mayb.__repr__())

    ## solution
    # z3 to reverse MULT
    # mxor_flag ^ mxor_mayb ^ '?'
    # reverse mapping
    # flag!

if __name__ == "__main__":
    main()