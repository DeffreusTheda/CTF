colors = "aec8a7b35777734974b6bbb7cb4bae"

for i in range(0,len(colors),2):
    print(chr(int(colors[i:i+2], 16)), end='')

