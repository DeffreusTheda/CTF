import sys
a = "!\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ"+ \
            "[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~ "
def arg122(flag_enc, key):
    long_key = key
    i = 0
    while len(long_key) < len(flag_enc):
        long_key = long_key + key[i]
        i = (i + 1) % len(key)        
    return "".join([chr(ord(arg422) ^ ord(arg442)) for (arg422,arg442) in zip(flag_enc,long_key)])

flag_enc = open('flag.txt.enc', 'rb').read()
if input('Please enter correct password for flag:') != 'happychance':
    print('That password is incorrect')
    sys.exit(0)
print('Welcome back... your flag, user:')
flag = arg122(flag_enc.decode(), 'rapscallion')
print(flag)
sys.exit(0)

