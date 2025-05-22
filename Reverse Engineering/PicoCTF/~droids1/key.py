alphabet = b"abcdefghijklmnopqrstuvwxyz"

key = [alphabet[0xe], alphabet[0xf], alphabet[0xe], alphabet[0x12], alphabet[0x12], alphabet[0x14], alphabet[0xc]]

print(''.join(chr(c) for c in key))