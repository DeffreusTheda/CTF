encoded = open('encodedflag', 'rb').read()
i = 0
d = ''
for c in encoded:
    if i & 1:
        i += 1
    else:
        d = str(c & 1) + d
    if len(d) == 8:
        print(chr(int(d, 2)), end='')
        d = ''
        i += 1
