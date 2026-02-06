s = input()
for i in range(0, len(s), 2):
    print(chr(int(s[i:i+2], 16)), end='')
