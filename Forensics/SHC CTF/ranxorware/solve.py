m = open('./office/salaries.png.enc.dec', 'rb').read()[:8]
e = open('./secret/flag.png.enc', 'rb').read()[:9]
print(f'{m=}')
print(f'{e=}')
k = bytes([mm^ee for mm,ee in zip(m,e)])
print(f'{k=}')
d = bytes([b^k[i % len(k)] for i, b in enumerate(open('./secret/flag.png.enc', 'rb').read())])
print(f'{d=}')
open('flag.png', 'wb').write(d)
