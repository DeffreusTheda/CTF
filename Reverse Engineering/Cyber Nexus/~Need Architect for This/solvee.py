
for X in range(256):
    data = [48, 48, 48, 48, 49, 51, 52, 52, 67, 68, 69, 71, 78, 83, 83, 85, 88, 89, 95, 95, 95, 95, 99, 104, 111, 111, 111, 114, 115, 116, 116, 117, 123, 125]
    # for d in data:
        # print(chr(d), end='')
    magic = [237, 255, 255, 255, 72, 255, 255, 255, 64, 246, 220, 111, 64, 214, 220, 110, 64, 214, 220, 110, 64, 214, 212, 110, 64, 212, 148, 110, 0, 212, 148, 106, 0, 212, 148, 106, 0, 212, 148, 42, 0, 208, 148, 42, 0, 128, 148, 42, 0, 128, 148, 42, 0, 0, 148, 42, 0, 0, 148, 42, 0, 0, 144, 42, 0, 0, 144, 42, 0, 0, 128, 42, 0, 0, 128, 42, 0, 0, 0, 42, 0, 0, 0, 40, 0, 0, 0, 40, 0, 0, 0, 40, 0, 0, 0, 40, 0, 0, 0, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]

    s = ''.join(bin(m)[2:].rjust(8, '0') for m in magic[::-1])[X:]
    print(f'{len(s) = }')
    p = 32
    for ss in s:
        if p == -1:
            p = 32
        if ss == "1":
            # print(p, p + 1)
            tmp = data[p]
            data[p] = data[p + 1]
            data[p + 1] = tmp
        p -= 1
    print(''.join(chr(c) for c in data))

# si = 0
# b = 0
# for i in range(34):
    # for j in range(33):
        # if (magic[si] >> b) & 1 == 1:
            # data[j], data[j + 1] = data[j + 1], data[j]
        # b += 1
        # if b > 7:
            # b = 0
            # si += 1

# p = 0
# for m in magic:
#     for bit in range(8):
#         if p + 1 == 34:
#             p = 0
#         if (m >> bit) & 1 == 1:
#             data[p], data[p + 1] = data[p + 1], data[p]
#         p += 1

# def xor(p, m, b):
#     if p + 1 != len(data):
#         if (magic[m] >> b) & 1 == 1:
#             data[p], data[p + 1] = data[p + 1], data[p]
#         p += 1
#         b += 1
#         if (7 < b):
#             m += 1
#             b = 0
#         xor(p, m, b)
# for i in range(145):
#     xor(0, 0, 0)

# s = ''.join([bin(m)[2:].rjust(8, '0')[::-1] for m in magic])
# print(s)
# si = 0
# for i in range(34):
    # for j in range(33):
        # if s[si] == "1":
            # data[j], data[j + 1] = data[j + 1], data[j]
        # si += 1

# s = ''.join([bin(m)[2:].rjust(8, '0') for m in magic[::-1]])
# si = 0
# try:
#     for i in range(34):
#         for j in range(33,0,-1):
#             if s[si] == "1":
#                 data[j], data[j - 1] = data[j - 1], data[j]
#             si += 1
# except:
#     print("pass")
#     pass

# s = ''.join([bin(m)[2:].rjust(8, '0')[::-1] for m in magic])
# p = 0
# for ss in s:
#     p %= 33
#     if ss == "1":
#         data[p], data[p + 1] = data[p + 1], data[p]
#     p += 1


# 4GSXst_oo_0U01E004DS_hurNY_oct{C3}
# NEXUS{}

# 4Gst_oo_001004DS_hurY_oct{C3}
# NEXUS{}

# NEXUS{4Gst_oo_001004DS_hurY_octC3}
# ENUSX{4Gst_oo_001004DS_hurY_octC3}

# 9_8 7 4 1 2
# 8 9_7 4 1 2
# 8 7 9_4 1 2
# 8 7 4 9_1 2
# 8 7 4 1 9_2
# 8_7 4 1 2 9
# 7 8_4 1 2 9
# 7 4 8_1 2 9
# 7 4 1 8_2 9
# 7_4 1 2 8 9
# 4 7_1 2 8 9
# 4 1 7_2 8 9
# 4_1 2 7 8 9
# 1 4_2 7 8 9
# 1 2 4 7 8 9
