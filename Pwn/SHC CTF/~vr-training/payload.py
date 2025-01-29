from pwn import *
from sys import argv
from os.path import isfile

target = sys.argv[1]
if not isfile(target):
  print(f'[!] {target}: not found or not a file.')
elf = context.binary = ELF(target, checksec=False)

sa = print

g = cyclic_gen()
sa(b'Your input: ', g.get(100))

# p.interactive()
