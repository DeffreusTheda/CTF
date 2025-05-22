with open('out', 'r') as file:
    for line in file:
        v = int(line, 2)
        r = v ^ int('00111001', 2)
        print(chr(r), end='')
