with open('rev3', 'r') as file:
    idx = 0
    a = ''
    b = ''
    nums = []
    for line in file:
        r = int(line, 2)
        s_r = format(r, '#010b')[2:]
        # print(s_r, end='\n')
        nums.append(s_r)
        idx += 1
        print(chr(r))
