import random
import string

# flag = b'RAMADAN{1_book_4_n3w_499o1n7m3n7_4nd_17_15_ju57_4no7h3r_d15499o1n7m3n7}'
flag = string.printable.encode()
print(f'{flag=}')

enc = []
map = {}

for c in flag:
    r = -1
    random.seed(c)
    while True:
        r = random.randint(0, 255)
        if r == c:
            print(f'0: {c}')
            random.seed(r)
        else:
            break
    e = c ^ r
    enc.append(e)
    map[c] = e
enc = bytes(enc)

print(f'{enc=}')
# print()

# CHECK FOR DUPLICATE RAND
print(f'{len(map.keys())=}')
ori = set(map.keys())
print(f'{len(ori)=}')

for i, c in enumerate(flag):
    print(f'{c} -> {enc[i]}')
