from Crypto.Util.number import isPrime, long_to_bytes
from math import isqrt

def nextPrime(n):
    n += 1
    while not isPrime(n):
        n += 1
    return n

# Provided values
n = 18307564183336174372957570419285112053386287578636115613810768749885553622091399241390778725602944089106231437595887
e = 65537
c = 14461562873315648876900863314412430050179928115118140218391238322269424888840823494182924552959513459002994495040816
r = 272617646727976431124665621907966000454

# Step 1: Compute a = nextPrime(r)
a = nextPrime(r)

# Step 2: Compute s = a + r
s = a + r

# Step 3: Compute t = n // s
t = n // s

# Step 4: Compute q_approx = isqrt(t)
q_approx = isqrt(t)

# Step 5: Search for q around q_approx
for delta in range(-500, 501):
    q_candidate = q_approx + delta
    if q_candidate > 0 and isPrime(q_candidate) and n % q_candidate == 0:
        q = q_candidate
        print(f'found q!! = {q}')
        break
else:
    raise ValueError("q not found in the range")

# Step 6: Compute p = n // q
p = n // q

# Step 7: Verify p is prime
if not isPrime(p):
    raise ValueError("p is not prime")

# Step 8: Compute phi = (p - 1) * (q - 1)
phi = (p - 1) * (q - 1)

# Step 9: Compute d = e^{-1} mod phi
d = pow(e, -1, phi)

# Step 10: Decrypt m = c^d mod n
m = pow(c, d, n)

# Step 11: Convert m to bytes to get the flag
flag = long_to_bytes(m)
print("Flag:", flag.decode())
