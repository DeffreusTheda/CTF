from param import n, p
from secrets import randbelow
from Crypto.Cipher import ARC4
from hashlib import sha256

flag = open('flag.txt').read()

class DHKey:
    def __init__(self, gen: int):
        self.secret = randbelow(p)
        self.public = pow(gen, self.secret, n)
        
    def calc_shared(self, other_pub: int):
        self.shared = pow(other_pub, self.secret, n)

def main():
    print("Here are the params:")
    print(f"{hex(n)=}")
    print(f"{hex(p)=}")
    print("="*50)
    
    g = int(input("Choose the generator: "), 16)
    if not (4 * p < g < 5 * p):
        print("Baaaakaaaa!")
        exit(1)
    
    Alice = DHKey(g)
    print(f"{hex(Alice.public)=}")
    Bob = DHKey(g)
    print(f"{hex(Bob.public)=}")
    
    Alice.calc_shared(Bob.public)
    Bob.calc_shared(Alice.public)
    assert(Alice.shared == Bob.shared)
    
    key = sha256(str(Alice.shared).encode()).digest()
    cipher = ARC4.new(key)
    ct = cipher.encrypt(flag.encode())
    print(f"{ct.hex()=}")
    print("Good luck!")
    
if __name__ == '__main__':
    main()