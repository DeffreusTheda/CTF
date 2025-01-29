from sympy import factorint, isprime
from itertools import product

c = 3303990128537235488004793416585318461904596552605572639140
d = 243073960507607943926313403235762089661464749813337232273
e = 65537
k = e * d - 1

def get_divisors(factors):
   divs = []
   for el in product(*[range(0, e+1) for e in factors.values()]):
       div = 1
       for p, e in zip(factors.keys(), el):
           div *= p ** e
       divs.append(div)
   return divs

facts = factorint(k)
print(f'{facts=}')
phis = get_divisors(facts)
print(f'{phis=}')
print(f'{len(phis)=}') # 16128

for phi in phis:
    if 191 <= len(bin(phi)[2:]) <= 192:
        facts = factorint(phi)
        divs = get_divisors(facts)
        for pp in divs:
            if phi % pp != 0: continue
            qq = phi // pp
            p = pp + 1
            q = qq + 1
            if isprime(p) and isprime(q):
                print('found!!!')
                n = p * q
                if n.bit_length() != 192: continue
                m = pow(c, d, n)
                m = hex(m)[2:]
                m = ''.join([chr(int(m[i:i+2], 16)) for i in range(0,len(m),2)])
                if m.isprintable():
                    print(f'{m=}')
