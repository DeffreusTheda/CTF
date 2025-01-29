i = int(input(), 16)
result = ''
while i > 0:
    result = result + str(bin(i & 127))[2:]
    i >>= 8
print(int(result, 2))
print(hex(int(result, 2)))