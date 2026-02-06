#!/usr/bin/env python3
import secrets

FLAG = "FAKE_FLAG"

def encrypt(key, plaintext):
    return ''.join(str(int(a) ^ int(b)) for a, b in zip(key, plaintext))


def main():
    # keygen
    key = format(secrets.randbits(365), 'b')
    print(f'[*] ({type(key)} {len(key)}) {key}')
    print("Welcome to the CryptoFarm!")
    while True:
        command = input('Would you like to encrypt a message yourself [1], get the flag [2], or exit [3] \n>').strip()
        try:
            if command == "1":
                data = input('Enter the binary string you want to encrypt \n>')
                print("Ciphertext = ", encrypt(key, data))
                key = format(secrets.randbits(365), 'b')
                print(f'[*] ({type(key)} {len(key)}) {key}')
            elif command == "2":
                print("Flag = ", encrypt(key, format(int.from_bytes(FLAG.encode(), 'big'), 'b')))
            elif command == "3":
                print("Exiting...")
                break
            else:
                print("Please enter a valid input")
        except Exception:
            print("Something went wrong.")

if __name__ == "__main__":
    main()