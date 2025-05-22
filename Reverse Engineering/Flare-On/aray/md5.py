for i in range(256):
    for j in range(256):
        print(f'\\x{hex(i)[2:]}\\x{hex(j)[2:]}')
