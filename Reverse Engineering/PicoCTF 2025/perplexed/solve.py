# these are in little endian, apparently.
# took me hours to figure that out, dagnabit.
b1   = 0x617B2375F81EA7E1
b2_0 = 0xD269DF5B5AFC9DB9
# b2_1 is originally
#      0xF467EDF4ED1BFED2,
# but the ending D2 overlap with b2_0! annoying!!
b2_1 = 0xF467EDF4ED1BFE

memory = bytearray()
memory.extend(b1  .to_bytes(8, byteorder='little'))  # Bytes 0-7
memory.extend(b2_0.to_bytes(8, byteorder='little'))  # Bytes 8-15
memory.extend(b2_1.to_bytes(8, byteorder='little'))  # Bytes 8-15

bits = ''.join([bin(c)[2:].rjust(8, "0") for c in memory])
# i tried it with cyberchef From_Binary(Delimiter=None, ByteLength=7)
# and got the flag!
# https://gchq.github.io/CyberChef/#recipe=From_Binary('None',7)&input=MTExMDAwMDExMDEwMDExMTAwMDExMTEwMTExMTEwMDAwMTExMDEwMTAwMTAwMDExMDExMTEwMTEwMTEwMDAwMTEwMTExMDAxMTAwMTExMDExMTExMTEwMDAxMDExMDEwMDEwMTEwMTExMTAxMTExMTAxMTAxMDAxMTEwMTAwMTAxMTExMTExMDAwMDExMDExMTExMDExMDExMTExMDEwMDExMTAxMTAxMDExMDAxMTExMTExMDEwMDAwMDAwMDAw&oeol=CR
print(bits)

ch = ""
for bit in bits:
    ch += bit
    if len(ch) == 7:
        print(end=f'{chr(int(ch, 2))}')
        ch = ""
print()
