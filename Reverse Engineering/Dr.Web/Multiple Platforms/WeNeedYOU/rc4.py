answer_key = [4, 2, 2, 1, 3, 3, 2, 1, 4, 1, 3, 4]
chars = b'\x61\x62\x63\x64\x65\x66\x67\x68\x69\x6a\x6b\x6c\x6d\x6e\x6f\x70\x71\x72\x73\x74\x75\x76\x77\x78\x79\x7a\x31\x32\x33\x34\x35\x36\x37\x38\x39\x30\x45\x58\x50\x41\x4e\x44\x33\x36\x42\x4b\x45\x59'

after = []
for i, k in enumerate(answer_key):
    after.append(chars[i * 4 + (k - 1)])

# init RC4
j = 0
qn = 12
S = [i for i in range(0x100)]
# swap RC4
j = 0
for i in range(0x100):
    k = S[i] + j + after[i - (i // qn) * qn]
    j = k % 0x100
    # swap
    x = S[i]
    S[i] = S[j]
    S[j] = x
# call_encrypt
key = b'\x2d\x70\xce\x09\xfa\x44\x91\xb2\x83\xf7\x37\x7b\xa5\x72\x60\x39\xc7\x5c\x68\xdd\x2e\xfe\xdc\x97\x77\xb8\x53\x79\x49\x61\x3c\x9f\x00\x87\x2f\x18\x30\x3d\xfe\xc4\xbb\x81\x09\x22\x13\x7b\x73\x13\x19\x47\xd6\x78\x99\x96\x93\x78\xcc\xdb\x78\x23\xff\xd0\xf8\x77\x01\x01\x01'
byte = [0 for i in range(64)]
n = 0x40
for idx in range(n):
    ni = i + 1
    i = ni % 256
    ni = S[i] + j
    j = ni % 256
    # swap
    x = S[i]
    S[i] = S[j]
    S[j] = x
    # end swap
    byte[idx] = S[(S[i] + S[j]) & 0xFF] ^ key[idx]
for i in range(0x40):
    print(chr(byte[i]), end='')
print()
