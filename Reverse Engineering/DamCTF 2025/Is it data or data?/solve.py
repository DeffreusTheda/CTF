import string
from pwn import *

context.log_level = "DEBUG"

con = remote('isitdata.chals.damctf.xyz', 39531)
lis = ['4', '6', '10', '6', '5', '5', '7', '7', '4', '6', '6', '7', '9', '5', '5', '9', '5', '4', '7', '15', '4', '7', '15', '7', '7', '11', '6', '7', '9', '5', '4', '13', '00111111']
for num in lis:
    con.sendafter(b'> ', (num+'\n').encode())
con.interactive()
