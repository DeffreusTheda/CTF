from Crypto.Util.number import getPrime, bytes_to_long as b2l

FLAG = open('flag.txt', 'rb').read()
assert len(FLAG) < 1024 // 8
pt = b2l(FLAG)

p = getPrime(512)
q = getPrime(512)
n = p * q
e = 0x10001

ct = pow(pt, e, n)

lt = pow(p, 0x11, (p+b2l(b'SNI'))**3)
bl = lt.bit_length()
ub = 2**bl-1

lk = ((lt << (bl // 4)) & ub) | ((lt >> (3 * bl // 4)) & ub)
lk = lk ^ (lk << 32)

print(f'n = {n}')
print(f'e = {e}')
print(f'ct = {ct}')
print(f'lk = {lk}')
