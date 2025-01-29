from Crypto.Cipher import AES
from Crypto.Util.Padding import unpad
import base64
import argparse

def main():
    parser = argparse.ArgumentParser()
    parser.add_argument('input')
    parser.add_argument('key')
    args = parser.parse_args()
    
    if len(args.key) not in (16, 24, 32):
        print(f'{len(args.key) not in (16, 24, 32)=}')
        exit(1)
    
    cipher = AES.new(args.key.encode('utf-8'), AES.MODE_ECB)
    
    with open(args.input, 'rb') as f:
        enc = f.read()
    print(f'{enc=}')
    
    dec = unpad(cipher.decrypt(enc), AES.block_size)
    print(f'{dec=}')

if __name__ == '__main__':
    main()