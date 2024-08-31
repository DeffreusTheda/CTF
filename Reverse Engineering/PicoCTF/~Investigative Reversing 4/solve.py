# Encoded files
encoded = [open('Item01_cp.bmp', 'rb').read(), open('Item02_cp.bmp', 'rb').read(), open('Item03_cp.bmp', 'rb').read(), open('Item04_cp.bmp', 'rb').read(), open('Item05_cp.bmp', 'rb').read()]

# Reverse the order of the file
for file in encoded[::-1]:
    i = 0          # for ( int i = 0; i <= 49; ++i ); insert 50 byte
    d = ''         # decoded flag byte
    # 120 bytes after the first 2019 bytes
    for c in file[2019:2019+120]:
        if i % 5:
            # a filler byte inserted
            i += 1
        else:
            # concatenate the LSB
            d = str(c & 1) + d
        # a full byte/character
        if len(d) == 8:
            # print the flag character
            print(chr(int(d, 2)), end='')
            d = ''          # emptying for next flag byte
            i += 1          # a flag byte inserted
print() # end line

