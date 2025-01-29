from Crypto.Util.number import getPrime, inverse, bytes_to_long
import random, math
from textwrap import wrap

LR = 0.28
GROUP = 4
FKP = 24
FKS = 24

def mask_bits_as_r(bs: str, hr: float, fp: int, fs: int) -> str:
    n = len(bs)
    alw_ids = list(range(n))
    if fp > 0:
        alw_ids = alw_ids[fp:]
    if fs > 0:
        alw_ids = [i for i in alw_ids if i < n - fs]
    to_hide_target = int(hr * len(alw_ids))
    to_hide = set(random.sample(alw_ids, k=min(to_hide_target, len(alw_ids))))
    masked = []
    for i, b in enumerate(bs):
        if (fp and i < fp) or (fs and i >= n - fs):
            masked.append(b)
        elif i in to_hide:
            masked.append('r')
        else:
            masked.append(b)
    return ''.join(masked)

def groupify(s: str, size: int) -> str:
    return ' '.join(wrap(s, size))

def int_to_bin(x: int) -> str:
    return bin(x)[2:]

flag = open("flag.txt", "rb").read().strip()
e = 4099
while True:
    p = getPrime(128)
    q = getPrime(128)
    n = p * q
    phi = (p - 1) * (q - 1)
    if math.gcd(e, phi) != 1:
        continue
    d = inverse(e, phi)
    dp = d % (p - 1)
    dq = d % (q - 1)
    kp = (e * dp - 1) // (p - 1)
    kq = (e * dq - 1) // (q - 1)
    if kp == 0 or kq == 0:
        continue
    break
m = bytes_to_long(flag)
if m >= n:
    raise ValueError("flag too large for modulus")
c = pow(m, e, n)
dp_bits = int_to_bin(dp)
dq_bits = int_to_bin(dq)
masked_dp = mask_bits_as_r(dp_bits, LR, FKP, FKS)
masked_dq = mask_bits_as_r(dq_bits, LR, FKP, FKS)
dp = groupify(masked_dp, GROUP)
dq = groupify(masked_dq, GROUP)
with open("output.txt", "w") as f:
    f.write(f"n={n}\n")
    f.write(f"e={e}\n")
    f.write(f"c={c}\n")
    f.write(f"dp={dp}\n")
    f.write(f"dq={dq}\n")