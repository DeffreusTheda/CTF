jumpy = bytes.fromhex("83F80074")
file = open('main', 'rb').read()
jumpers = []

for i, c in enumerate(file):
    if file[i:i+len(jumpy)] == jumpy:
        print(f'{i}', end=', ')
        jumpers.append(i)
print()

for i in range(len(jumpers) - 2):
    print(chr(jumpers[i + 1] - jumpers[i] - 5), end='')
print()
