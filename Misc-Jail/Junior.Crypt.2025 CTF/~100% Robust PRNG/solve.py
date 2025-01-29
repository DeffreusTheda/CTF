from pwn import *
from symbolic_mersenne_cracker import Untwister

conn = remote('ctf.mf.grsu.by', 9046)
context.log_level = "debug"
ut = Untwister()

bits = 31

def p(x):
    print(f':: {x} ::')
    return x

for _ in range(999):
    conn.sendafter(b'>', b'1\n')
    conn.recvuntil(b': ')
    num = int(conn.recvline().strip().decode())
    print(num)

    s = p(bin(num))
    s = p(s[2:])
    s = p(s.rjust(31, '0'))
    s = p(s + "?"*(32-bits))

    assert len(s) == 32
    ut.submit(s)  # Submit samples here

guess = p(ut.get_random().getrandbits(31))
print(f"!!!!! GUESSING: {guess} !!!!!")
conn.sendafter(b'>', b'2\n')
guess = p(str(guess))
guess = p(guess.encode())
guess = p(guess+b'\n')
conn.sendafter(b': ', guess)
conn.interactive()

exit(0)
