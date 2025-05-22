def swap(str: str, i1, i2):
    l = list(str)
    l[i1], l[i2] = l[i2], l[i1]
    return ''.join(l)

def main():
    enc = [0xF4, 0xC0, 0x97, 0xF0, 0x77, 0x97, 0xC0, 0xE4, 0xF0, 0x77, 0xA4, 0xD0, 0xC5, 0x77, 0xF4, 0x86, 0xD0, 0xA5, 0x45, 0x96, 0x27, 0xB5, 0x77, 0xD2, 0xD0, 0xB4, 0xE1, 0xC1, 0xE0, 0xD0, 0xD0, 0xE0]

    for e in enc:
        c = bin(e)[2:].rjust(8, '0')

        c = swap(c, 6, 7);
        c = swap(c, 2, 5);
        c = swap(c, 3, 4);
        c = swap(c, 0, 1);
        c = swap(c, 4, 7);
        c = swap(c, 5, 6);
        c = swap(c, 0, 3);
        c = swap(c, 1, 2);

        print(chr(int(c, 2)), end='')

    print()

if __name__ == "__main__":
    main()
