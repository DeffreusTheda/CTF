enc = [0, 24, 59, 86, 2, 14, 43, 17, 17, 24, 0, 54, 7, 46, 49, 11, 1, 11, 16, 10, 1, 0, 53, 58, 0, 0, 18, 18, 1, 53, 90, 57]
key = "SerikatNewbieIndonesia"
shu = []

for idx, e in enumerate(enc):
    shu.append(enc[idx] ^ ord(key[idx % len(key)]))

left = 1
right = len(enc) - (1 if len(enc) & 1 == 0 else 2)

while left < right:
    tmp = shu[left]
    shu[left] = shu[right]
    shu[right] = tmp

    left += 2
    right -= 2

for w in shu:
    print(chr(w), end='')
