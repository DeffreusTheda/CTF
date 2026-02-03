char_map = {
    'a': '000',
    'c': '001',
    'e': '010',
    'o': '011',
    'p': '100',
    'x': '101',
    'y': '110',
    'O': '011'  # same as o
}

for k in char_map.keys():
    print(bin(ord(k))[2:])

s = "eaaacccooapaceyopcoocopxeooOcxpaxoaaoacpccaeecopaoOocpaaoyyyeoappapeeooeeceoyypacoecaeeocoaaaaoayceopaaapecy"
# s = "eaaacccooapaceyopcoocopxeoocxpaxoaaoacpccaeecopaoocpaaoyyyeoappapeeooeeceoyypacoecaeeocoaaaaoayceopaaapecy"
# s = s[::-1]
# print(''.join([" "+ss for ss in s[:10]]))
bits = ''.join(bin(ord(c))[2:][4:8] for c in s)
# bits = ''.join(char_map.get(c, '') for c in s)

format = 'grodno{'
ss = ''
for ff in format:
    ss += bin(ord(ff))[2:].rjust(8, '0')
print(ss)

# break into bytes and decode
decoded = ''.join(chr(int(bits[i:i+8], 2)) for i in range(0, len(bits), 8))
print(decoded)
