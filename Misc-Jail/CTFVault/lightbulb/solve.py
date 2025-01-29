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
p = start()
sa = lambda i,o: p.sendlineafter(i,o)

p.interactive()
