f = open("./sus", "r")
a = ''

map = {0b00101011: 62, 0b00101111: 63}
for i in range(26):
    map[ord('A') + i] = i
    map[ord('a') + i] = i + 26
for i in range(10):
    map[ord('0') + i] = i + 52

for line in f:
    a += bin(map[ord(line[1])])[2:].rjust(8, '0')[-4:]
    if len(a) == 8:
        # print(a)
        print(end=chr(int(a, 2)))
        a = ''
