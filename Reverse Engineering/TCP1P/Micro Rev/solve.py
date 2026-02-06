f = open('enc.txt', 'rb').read()
# retrieved from debugging
key = b'\x22\x11\x75\xe1\x66\x12\x0a\x75\xe1\x66'

for i, b in enumerate(f):
    print(chr(b ^ key[i % len(key)]), end='')
print()
