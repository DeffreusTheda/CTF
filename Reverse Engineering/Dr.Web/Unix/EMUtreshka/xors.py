s = "QQQQ!QQQQDWWWF'DWT!WWDQQQF'DWWTQT!WWWDQF'DWTWWWWWWWWWTWWWWWWWWWWWTQTQQTWWWTW!QQDWWWWWF'DTWWWWWWWWWWWWTWWWTW!QQDWWWWWF'DT"
for key in range(256):
    print(f'\n\nWITH KEY {key}', key)
    for c in s:
        print(chr(ord(c) ^ key), end='')
