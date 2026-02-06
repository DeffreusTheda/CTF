s = 'label'
print('crypto{', end='')
for ss in s:
    print(chr(ord(ss)^13), end='')
print('}')