with open('datalen56') as file:
    while line := file.readline():
        print( chr(int(line[:2], 16)), end='' )
