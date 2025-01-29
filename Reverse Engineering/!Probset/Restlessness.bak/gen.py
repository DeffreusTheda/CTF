import hashlib

part1 = input("part 1: ").strip()
part2 = input("part 2: ").strip()
part3 = input("part 3: ").strip()
part5 = input("part 5: ").strip()

hash_hex = hashlib.sha256(f"{part1}{part2}{part3}{part5}".encode()).hexdigest()
charset = "0134567_abcdefhlmnortuy"
part4 = ""

k = [50, 11, 91, 8, 10, 110, 7, 26, 67, 104, 25, 26, 0, 1, 87, 92, 94, 108, 93, 85, 17]

for i in range(21):
    byte_val = int(hash_hex[i*2:i*2+2], 16)
    char_idx = byte_val % len(charset)
    part4 += chr(ord(charset[char_idx]) ^ k[i])

print(f"\npart 4: {part4} (if it's unintelligible then you're probably wrong)")

print(f"\nflag: QnQSec{part1}{part2}{part3}{part4}{part5} (if the flag format QnQSec doesn't work try all capitalized, i forgor )")