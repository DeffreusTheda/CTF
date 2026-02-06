with open('orderofwrite', 'r') as f:
    idx = 0
    for line in f:
        wto = int(line[10:-1], 16)-0x10
        print(f'map[{wto:#02d}] = {idx}')
        idx += 1
