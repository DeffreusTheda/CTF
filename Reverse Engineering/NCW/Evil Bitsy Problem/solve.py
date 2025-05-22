with open('input', 'r') as file:
    idx = 0
    a = ''
    b = ''
    nums = []
    for line in file:
        if idx & 1 == 0:
            a = int(line, 2)
        if idx & 1 == 1:
            b = int(line, 2)
            r = a ^ b
            s_r = format(r, '#010b')[2:]
            print(s_r, end='')
            nums.append(s_r)
        idx += 1
