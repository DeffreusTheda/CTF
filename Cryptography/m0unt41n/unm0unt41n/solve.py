import sys
m = open('./ECSC_2022_img_10.jpg', 'rb').read()
e = open('./home/shc/imgs/ECSC_2022_img_10.jpg', 'rb').read()
k = b""
print(f'is same length? {len(m) == len(e)} ({len(m)})')
s = b''
i = 0
for mm,ee in zip(m,e):
    s += bytes(mm^ee)
    i += 1
    if i % 1000 == 0:
        print(i, end='... ')
open('key', 'wb').write(s)

