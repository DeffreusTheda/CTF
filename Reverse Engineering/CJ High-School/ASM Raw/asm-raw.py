def is_valid(s):
    if len(s) != 0x15:
        return False
    if s != s[::-1]:
        return False
    if not all(s[i] == 'a' for i in [0,2,4,7,9]):
        return False
    if ord(s[1]) != ord(s[3]) - 1:
        return False
    if s[19] != 'm':
        return False
    if s[15] != 'p':
        return False
    if ord(s[6]) != ord(s[5]) - 4:
        return False
    if s[8] != s[17]:
        return False
    if s[10] != 'c':
        return False
    return True

result = ['a'] * 21
result[19] = 'm'
result[15] = 'p'
result[10] = 'c'

for b1 in range(97, 123):
    result[1] = chr(b1)
    result[3] = chr(b1 + 1)

    for b5 in range(97, 123):
        result[5] = chr(b5)
        result[6] = chr(b5 - 4)

        for b8 in range(97, 123):
            result[8] = chr(b8)
            result[17] = chr(b8)

            # fill for palindrome
            for i in range(len(result)):
                if i > len(result)//2:
                    result[i] = result[len(result)-1-i]
            test = ''.join(result)

            if is_valid(test):
                print(f"Found valid string: {test}")
                exit()

print("No valid string found")
