encoded = open('encodedflag', 'rb').read()
d = ''
for c in encoded:
    d = str(c & 1) + d
    if len(d) == 8:
        print(chr(int(d, 2) + 5), end='')
        d = ''
