serial = b'\x5B\x13\x49\x77\x13\x5E\x7D\x13'
key = b'\x10\x20\x30'

for i, c in enumerate(serial):
    print(chr(serial[i] ^ key[i % len(key)]), end='')