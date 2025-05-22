def flipbit(r):
    bits = format(r, '#010b')[2:]
    bits2 = ''
    for bit in bits:
        if bit == '1':
            bits2 += '0'
        else:
            bits2 += '1'
    return int(bits2, 2)

with open('input3', 'r') as file:
    idx = 0
    a = ''
    b = ''
    for line in file:
        r = int(line, 2)
        if idx in [12, 14, 16]:
            r = flipbit(r)
        s_r = format(r, '#010b')[2:]
        print(s_r, end='')
        idx += 1
        # print(chr(r))
