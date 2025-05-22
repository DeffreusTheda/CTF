import random

def binary_math(A, B):
    """
    xor two matrix
    """

    # dimension must be equal
    if len(A) != len(B) or len(A[0]) != len(B[0]):
        raise Exception

    res = [[0]*len(A[0])]*len(A)
    for i in range(len(A)):
        for j in range(len(A[0])):
            res[i][j] = A[i][j] ^ B[i][j]
    return res

def omg_real_math(A, B):
    """
    Matrix multiplication
    """

    if len(A[0]) != len(B):
        raise Exception

    res = [[0]*len(B[0])]*len(A)
    for i in range(len(A)):
        for j in range(len(B[0])):
            for k in range(len(A[0])):
                res[i][j] += A[i][k] * B[k][j]
    return res

def not_math(L, r=3, n=0):
    """
    Turn a list into a r by c matrix from rightmost, topmost

    e.g. [1, 2, 3, 4, 5, 6] -> [[1, 4], [2, 5], [3, 6]]
    """
    # SHUT UP. I SAY SHUT UP. I KNOW WHAT YOU'RE THINKING. BUT THIS JUST WORKS, OKAY!??
    
    # repeat for key
    if n != 0 and n > len(L):
        i = len(L)
        while i < n:
            L.append(L[i % len(L)])
            i += 1

    i = 0
    j = 0
    l = len(L)
    c = l//r   # column
    c += 1 if l/r > l//r else 0
    res = [[0]*c for i in range(r)]
    for x in L:
        # x = ord(x) if type(x) == str else x
        res[i][j] = x
        i += 1
        if i == r: # next column
            i = 0
            j += 1
            j %= c
    return res

def basic_math(c):
    """
    Map characters into numbers
    """
    c = ord(c)
    if c in range(97,123): # a-z
        return c - 96
    if c in range(65,91): # A-Z
        return c - 38
    if c in range(48,58): # 0-9
        return c + 19
    # other mapping
    map = {
        33:53, 64:54, 35:55, 36:56,  37:57,  94:58,
        38:59, 42:60, 34:61, 63:62,  58:63,  59:64,
        47:65, 92:66, 32:77, 123:78, 125:79, 95:80
    }
    if c in map.keys():
        return map[c]
    # if not mapped
    raise Exception

def protecc_sensitive_electronic_information():
    name = input('Name: ')
    flag = input('Password: ')
    n = len(flag)
    flag = flag + '?'*n
    mayb = '?'*n + input('Reenter password: ')

    if flag[:n] != mayb[n:]:
        perror("Password is not the same!!")
        exit(1)

    keyy = [basic_math(c) for c in name]
    flag = [basic_math(c) for c in flag]
    mayb = [basic_math(c) for c in mayb]

    keyy = not_math(keyy, n=len(flag))
    flag = not_math(flag)
    mayb = not_math(mayb)

    flag = binary_math(flag, keyy)
    mayb = binary_math(mayb, keyy)

    random.seed(hash("i dare you to solve this with a GDC calculator"))
    ciph = not_math([random.randint(0,9) for i in range(len('Have fun!'))])
    flag = omg_real_math(ciph,flag)

    open('output.bin', 'w').write(flag.__repr__())

if __name__ == "__main__":
    # function names are 'obfuscated' by meaning
    protecc_sensitive_electronic_information()