import random

encoded = b'!vP3\xc2\x91\xc2\x89\x11\x1f\x06C\x17_\x19t)\xc2\x929\x06li\x1d\x1f\xc2\x88*\x19E+4E\x16\x07v1S$\x1a c\x1flcr4> 3vlt\xc2\x85Yj-$0 '
decoded = encoded.decode("utf-8")

flag = "COMPFEST16{"
random.seed(int(flag[8:10]))
for c in flag[:8]:
    random.seed(random.randint(1, 0xCF) + ord(c))

for char in decoded:
    result = ord(char)
    offset = random.randint(1, 10)
    MyFriend = random.randint(1, 127)
    if random.randint(0, 1):
        result -= 0x16
    result = (result ^ MyFriend) + offset
    print(chr(result), end='')
