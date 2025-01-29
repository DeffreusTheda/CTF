from Crypto.Util.number import getPrime, bytes_to_long

# for testing
m = 'SheWasThere'
# with open("secret.txt") as f:
        # m = f.read().strip() # 11 Characters


p = getPrime(96)
q = getPrime(96)
n = p * q
e = 65537
phi = (p - 1) * (q - 1)
d = pow(e, -1, phi)
c = pow(bytes_to_long(m.encode()), e, n)

print(f"c = {c}")
print(f"d = {d}")

answer = input("What's the secret: ").strip()

if answer == m:
    print("Kiled it!")
    with open("flag.txt") as f:
        flag = f.read().strip()
        print(flag)
else:
    print("Nice try...")
