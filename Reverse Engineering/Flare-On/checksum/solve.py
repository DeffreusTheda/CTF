import base64 as b

s = b.b64decode('cQoFRQErX1YAVw1zVQdFUSxfAQNRBXUNAxBSe15QCVRVJ1pQEwd/WFBUAlElCFBFUnlaB1ULByRdBEFdfVtWVA==')
print(s)

key = b'FlareOn2024'
m = b''
for i in range(len(s)):
    m += chr(s[i] ^ key[i % len(key)]).encode()
print(m)