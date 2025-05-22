output = open("output", "r").read()
data = open("data", "r").read()
known = "ENSEC_CTF{"

for i in range(len(output)):
    d = data[i]
    e = ord(output[i])

    if d.isnumeric(): # dec: alphabet
        e += 26 * int(data[i])
    else:
        e += 95 * (ord(d) - ord('A'))
    print(chr(e - ord(known[i]))) # key byte
