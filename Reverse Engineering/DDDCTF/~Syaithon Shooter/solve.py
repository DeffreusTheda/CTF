def rc4_decrypt(key, encrypted_flag):
    S = list(range(256))
    j = 0
    out = []

    key = [ord(c) for c in key]
    
    # KSA (Key Scheduling Algorithm)
    for i in range(256):
        j = (j + S[i] + key[i % len(key)]) % 256
        S[i], S[j] = S[j], S[i]

    i = j = 0
    for char in encrypted_flag:
        i = (i + 1) % 256
        j = (j + S[i]) % 256
        S[i], S[j] = S[j], S[i]
        K = S[(S[i] + S[j]) % 256]
        out.append(chr(ord(char) ^ K))  # XOR operation

    return ''.join(out)

key = "kepala_hidung_aneh_wayauwayau"
encrypted_flag = b"\xC9c\x95+\xE0\xD9\x15\xAF\xC4\xDE\x4E\x85\x8D\xBDsY\xEE\xCB\x18\xA2=\x94\xD6v\xB9\xB6\\\x91\x94k\xB3\xB7\x99l'*co\xC7\x8F\x10\x18\xFD"

flag = rc4_decrypt(key, encrypted_flag.decode('latin1'))
print(f"Flag: {flag}")

