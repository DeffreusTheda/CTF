s = '73626960647f6b206821204f21254f7d694f7624662065622127234f726927756d'
b = 0
while input() == '':
    for i in range(0, len(s), 2):
        print(chr(int(s[i:i+2], 16) ^ b), end='')
    print(f' <- {b}')
    b += 1
