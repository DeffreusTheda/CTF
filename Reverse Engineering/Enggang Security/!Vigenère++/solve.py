def extendkey(key: str, flag_len: int):
    if flag_len <= len(key):
        return

    xor = 0
    key_len = len(key)
    i_key_len = key_len

    while key_len != flag_len:
        if key_len % i_key_len == 0:
            xor += 1
            # print()
        key += chr(ord(key[key_len % i_key_len]) ^ xor)
        # print(key[-1], end='')
        key_len += 1  

    return key

def main():
    output = open("output", "r").read()
    data = open("data", "r").read()

    key = extendkey("3NDL355}", len(output))

    # print(f'{key=}')
    # print(f'{len(key)=}')

    for i in range(len(output)):
        e = ord(output[i])
        d = data[i]

        if d.isnumeric(): # alphabet
            e += 26 * int(d)
        else:
            e += 95 * (ord(d) - ord('A'))
        print(chr(e - ord(key[i])), end='') # decrypted
    print(key[:8])                          # + key -> flag!!
        
if __name__ == "__main__":
    main()
