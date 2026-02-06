KEY1 = int('a6c8b6733c9b22de7bc0253266a3867df55acde8635e19c73313', 16)
print(f'{KEY1 = }')
# KEY2 ^ KEY1 = 37dcb292030faa90d07eec17e3b1c6d8daf94c35d4c9191a5e1e
# KEY2 ^ KEY3 = c1545756687e7573db23aa1c3452a098b71a7fbf0fddddde5fc1
# FLAG ^ KEY1 ^ KEY3 ^ KEY2 = 04ee9855208a2cd59091d04767ae47963170d1660df7f56f5faf

KEY2 = KEY1 ^ int('37dcb292030faa90d07eec17e3b1c6d8daf94c35d4c9191a5e1e', 16)
print(f'{KEY2 = }')
KEY3 = KEY2 ^ int('c1545756687e7573db23aa1c3452a098b71a7fbf0fddddde5fc1', 16)
print(f'{KEY3 = }')
FLAG = int('04ee9855208a2cd59091d04767ae47963170d1660df7f56f5faf', 16) ^ KEY1 ^ KEY2 ^ KEY3
print(f'{FLAG = }')
s = str(hex(FLAG))[2:]
for i in range(0, len(s), 2):
    print(chr(int(s[i:i+2], 16)), end='')
