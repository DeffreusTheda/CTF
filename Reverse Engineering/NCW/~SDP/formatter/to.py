s = input()
for i in range(0,len(s),2):
    print('\\x' + s[i:i+2], end='')
