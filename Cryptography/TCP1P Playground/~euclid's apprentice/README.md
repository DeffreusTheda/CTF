# euclid's apprentice Writeup by Deffreus - TCP1P playgroud 365

###### Author: k1nomi

Pengetahuan yang baik dalam modular arithmetic akan sangat membantumu dalam crypto, terutama dalam memahami beberapa algoritma seperti RSA dan Diffie-Hellman. Kalau begitu, mari mulai dari basic-nya. Zaman dahulu kala, Euclid menemukan sebuah cara untuk menghitung faktor persekutuan terbesar/greatest common divisor (GCD) dari dua bilangan bulat a dan b dengan cepat (Euclidean algortihm). Memperluas algoritmanya (Extended euclidean algorithm), kita juga bisa menemukan bilangan bulat x dan y yang memenuhi ax + by = gcd(a,b).

- angka 23 dan getPrime(216) itu konstanta random, tidak perlu dipikirkan
- ingat baik-baik apa output yang diberikan gcd() dan egcd()

## Files

```
$ file d04b9f8d64f85306b2eb3782a046d75081f1c84d06b890fe979f016e9f24572a.zip
d04b9f8d64f85306b2eb3782a046d75081f1c84d06b890fe979f016e9f24572a.zip: Zip archive data, at least v2.0 to extract, compression method=store
$ unzip d04b9f8d64f85306b2eb3782a046d75081f1c84d06b890fe979f016e9f24572a.zip 
Archive:  d04b9f8d64f85306b2eb3782a046d75081f1c84d06b890fe979f016e9f24572a.zip
   creating: dist/
  inflating: dist/chall.py           
  inflating: dist/output.txt         
$ file dist/*
dist/chall.py:   Python script, ASCII text executable
dist/output.txt: ASCII text, with very long lines (339)
$ bat dist/chall.py                 
───────┬────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
       │ File: dist/chall.py
───────┼────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
   1   │ from Crypto.Util.number import *
   2   │ 
   3   │ flag1 = b"TCP1P{xxxxxxxxxxxxxxxxxxxxxx"
   4   │ flag2 = b"xxxxxxxxxxxxxxxxxxxxxxxxxxx}"
   5   │ 
   6   │ m1 = bytes_to_long(flag1)
   7   │ m2 = bytes_to_long(flag2)
   8   │ 
   9   │ # Euclidean algorithm
  10   │ def gcd(a, b):
  11   │     if a == 0:
  12   │         return b
  13   │     return gcd(b % a, a)
  14   │ 
  15   │ # Extended euclidean algorithm
  16   │ def egcd(a, b):
  17   │     if a == 0:
  18   │         return b, 0, 1
  19   │     gcd, x1, y1 = egcd(b % a, a)
  20   │     x = y1 - (b//a) * x1
  21   │     y = x1
  22   │     return gcd, x, y
  23   │ 
  24   │ # First part (GCD)
  25   │ c1 = m1**2 + 23
  26   │ c2 = m1*getPrime(216)
  27   │ 
  28   │ # Second part (EGCD)
  29   │ x = egcd(c1,c2)[1]
  30   │ y = egcd(c1,c2)[2]
  31   │ c3 = m2*x*y
  32   │ 
  33   │ print(f"c1 = {c1}")
  34   │ print(f"c2 = {c2}")
  35   │ print(f"c3 = {c3}")
───────┴────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
```

## Solution

The calculation for c1 until c3 are pretty simple,
so we can just easily reverse the equation to get m1 and m2!

`solve.py`:

```py
from mpmath import mp
#: mpmath allow us to works with really really big numbers!

mp.dps = 350 # set precision

c1 = mp.mpf('78746519456787459867769556096386983694811384946995098039293792505870820084109642385113547421713999358774318815448856015269135444869248')
c2 = mp.mpf('641606793310371792282348958798191776204340201299582820836362981880802983470403505850861414011727894326146227451752569563316980988515')
c3 = mp.mpf('-109446656897285649835873737145584471533031750955725947474427370335716970042821908651123104671422146210608911142611181104002645674675594082686127882379559257375421942958861654767279681238703674122770550747228463958701474897788409989299339399625811250434222728774602760597218984569772965378966746165388617777229993823306790649199310000')

# Euclidean algorithm
def gcd(a, b):
    if a == 0:
        return b
    return gcd(b % a, a)

# Extended euclidean algorithm
def egcd(a, b):
    if a == 0:
        return b, 0, 1
    gcd, x1, y1 = egcd(b % a, a)
    x = y1 - int(b/a) * x1
    y = x1
    return gcd, x, y

# First part (GCD)
m1 = (c1 - 23)**(1/2) # c1 = m1**2 + 23
print(f'{m1 = }')
m1 = int(m1)
flag1 = m1.to_bytes((m1.bit_length() + 7) // 8, byteorder='big').decode('utf-8')
print(f'{flag1 = }')
getPrime216 = c2 / m1
print(f'{getPrime216 = }') # useless but ok

# Second part (EGCD)
_, x, y = egcd(c1,c2)
m2 = c3 / x / y # c3 = m2 * x * y
print(f'{x = }')
print(f'{y = }')
print(f'{m2 = }')
m2 = int(m2)
flag2 = m2.to_bytes((m2.bit_length() + 7) // 8, byteorder='big').decode('utf-8')
print(f'{flag2 = }')
print(f'Here\'s your crown, queen:', flag1 + flag2)
```

```
$ python3 solve.py
m1 = mpf('8873923566088872948928984368453802491936381285911749924694424120685.0')
flag1 = 'TCP1P{eucl1de4n_alg0r1thmmmm'
getPrime216 = mpf('72302492638344419175568894793593396249486716992321548538874754319.0')
x = -298229820771473862361056605750968876218638822243032419375857496025479522008854401981028951586781785231494039306601248568997931236688
y = 36602730252911534333484752270383235527557719561024634343170459873139343690482256805336105685603737620436236262702760439324875838508875
m2 = mpf('10026236661114279241495165020343062271177957265692807510753631893885.0')
flag2 = '_4ndd_b3z0utsss_1d3ntityyyy}'
Here's your crown, king: TCP1P{eucl1de4n_alg0r1thmmmm_4ndd_b3z0utsss_1d3ntityyyy}
```

FLAG: `TCP1P{eucl1de4n_alg0r1thmmmm_4ndd_b3z0utsss_1d3ntityyyy}`