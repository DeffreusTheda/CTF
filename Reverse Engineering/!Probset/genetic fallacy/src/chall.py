import argparse
parser = argparse.ArgumentParser(prog='genetic fallacy', description='This program check flags', epilog="There's no more help available")
parser.add_argument('flag')
args = parser.parse_args()
flag = args.flag.encode()

import binascii
tmp1 = binascii.hexlify(flag, '!', 106)
tmp2 = binascii.hexlify(flag, '@', 105)
if b'!' in tmp1 or b'@' not in tmp2:
    import sys
    sys.exit(binascii.crc32(flag))

print(flag)

import atexit
@atexit.register
def checker():
    global flag
    fag = input("Enter your flag!\n> ")
    import sys, base64
    target = sys.intern("V2UncmUgc29ycnksIHRoZSBtZXNzYWdlIHlvdSBoYXZlIGRlY3J5cHRlZCBoYXMgYmVlbiBwdXJnZWQgb3IgaXMgbm8gbG9uZ2VyIGF2YWlsYWJsZS4=")
    flag = sys.intern(base64.b64encode(flag).decode())
    if flag is target:
        print('yay did you did it?')
    else:
        print('yay but you did not did it...')

