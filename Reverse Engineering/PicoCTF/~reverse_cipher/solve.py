output = b"picoCTF{w1{1wq8/7376j.:}"

print("picoCTF{", end='')

for i in range(8, 0x17):
    if i & 1 == 0:
        print(f'{chr(output[i] - 5)}', end='')
    else:
        print(f'{chr(output[i] + 2)}', end='')
print("}")
