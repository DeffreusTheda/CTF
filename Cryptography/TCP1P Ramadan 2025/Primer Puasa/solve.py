from Crypto.Util.number import bytes_to_long, getRandomNBitInteger, isPrime, getPrime, long_to_bytes
from z3 import Int, solve, Real
from gmpy2 import mpz, invert

def nextPrime(n):
    while not isPrime(n := n + 1):
        continue
    return n

def gen():
    attempts = 0
    max_attempts = 1000
    while attempts < max_attempts:
        q = getPrime(128)
        r = getRandomNBitInteger(128)
        p = q * nextPrime(r) + nextPrime(q) * r
        if p.bit_length() <= 256 and isPrime(p) and isPrime(q):
            return p, q, r
        attempts += 1

    raise ValueError("Failed to generate primes within attempts")

# flag = b"TCP1P{testing}"
# m = bytes_to_long(flag)
# p, q, r = gen()
# n = p * q
# phi = (p - 1) * (q - 1)
# e = 0x10001
# d = pow(e, -1, phi)
# c = pow(m, e, n)
# print(f"{n=}")
# print(f"{e=}")
# print(f"{c=}")
# print(f"{r=}")

## SOLUTION

n=18307564183336174372957570419285112053386287578636115613810768749885553622091399241390778725602944089106231437595887
e=65537
c=14461562873315648876900863314412430050179928115118140218391238322269424888840823494182924552959513459002994495040816
r=272617646727976431124665621907966000454

q = Int('q')
nr = nextPrime(r)
# solve((q * nr + q * r) * q == 18307564183336174372957570419285112053386287578636115613810768749885553622091399241390778725602944089106231437595887, q > 0)
nq = nextPrime(183241273991286504943988493513185575130)
# solve((q * nr + nq * r) * q == 18307564183336174372957570419285112053386287578636115613810768749885553622091399241390778725602944089106231437595887, q > 0)
q = 183241273991286504943988493513185575127
p = mpz(n / q)
print(f'{q=} {p=}')
pi = (99909609797881765357355845070171094192933109055589425990125635137893348409344 - 1) * (q - 1)
d = invert(e, pi)
m = pow(c, d, n)
print(f'{long_to_bytes(m)=}')

## SOLUTION 2

from sympy import primerange

for q in primerange(2**127, 2**128):  
    nq = nextPrime(q)
    nr = nextPrime(r)

    # Compute p using the formula from `gen()`
    p = q * nr + nq * r

    # Check if p is a valid prime and the modulus matches
    if isPrime(p) and p * q == n:
        print(f"Found factors: p={p}, q={q}")
        break

# Compute phi(n)
phi = (p - 1) * (q - 1)

# Compute the private exponent d
d = invert(e, phi)

# Decrypt the ciphertext
m = pow(c, d, n)
flag = long_to_bytes(m)
print(f"Recovered FLAG: {flag.decode()}")
