with open('rev2', 'r') as file:
    idx = 0
    a = ''
    b = ''
    nums = []
    for line in file:
        v = int(line, 2)
        r = int('00111001', 2) ^ v
        s_r = format(r, '#010b')[2:]
        # print(s_r, end='\n')
        nums.append(s_r)
        idx += 1
        print(chr(r))
