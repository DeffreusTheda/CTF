num = 0
num2 = 0
num3 = 0

num4 = ((num3 ^ 30866) + 19760 ^ 13345) % 65536
if num4 % 11 == 0:
    num4 /= 11
    print(f'{num4=}')
    if num4 <= 1000:
        num = num3
        print(f'{num=}')
        num2 = num4
        print(f'{num2=}')
    num3 += 1
    print(f'{num3=}')
while num3 < 65536:
    num4 = ((num3 ^ 30866) + 19760 ^ 13345) % 65536
    if num4 % 11 == 0:
        num4 /= 11
        print(f'{num4=}')
        if num4 <= 1000:
            num = num3
            print(f'{num=}')
            num2 = num4
            print(f'{num2=}')
        num3 += 1
        print(f'{num3=}')
num3 = 0
