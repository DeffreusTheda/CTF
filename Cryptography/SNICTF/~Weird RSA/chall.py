from Crypto.Util.number import *
import os

flag = open("flag.txt", "rb").read() 
flag += os.urandom(130-len(flag))

m = bytes_to_long(flag)
p,q = getPrime(512), getPrime(512)
n = p*q
e = 65537
d = inverse(e,(p-1)*(q-1))
c = pow(m,d,n)

print("n = ", n)
print("e = ", e)
print("c = ", c)
