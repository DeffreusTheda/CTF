import zlib as hash
from hashlib import sha256, md5

# I LOVE I LOVE I LOVE HELIX
filesize = 85 

map = {i: [] for i in range(filesize)}

for c in range(256):
  map[2].append(c) if c % 28 < 28 and c & 128 == 0 and c + 11 == 119 and c < 147 and c > 20 else ''
  map[7].append(c) if c % 12 < 12 and c & 128 == 0 and c - 15 == 82 and c < 131 and c > 18 else ''
  map[16].append(c) if c % 31 < 31 and c & 128 == 0 and c < 134 and c > 25 and c ^ 7 == 115 else ''
  map[21].append(c) if c % 11 < 11 and c & 128 == 0 and c - 21 == 94 and c < 138 and c > 7 else ''
  map[26].append(c) if c % 25 < 25 and c & 128 == 0 and c - 7 == 25 and c < 132 and c > 31 else ''
  map[27].append(c) if c % 26 < 26 and c & 128 == 0 and c < 147 and c > 23 and c ^ 21 == 40 else ''
  map[36].append(c) if c % 22 < 22 and c & 128 == 0 and c + 4 == 72 and c < 146 and c > 11 else ''
  map[45].append(c) if c % 17 < 17 and c & 128 == 0 and c < 136 and c > 17 and c ^ 9 == 104 else ''
  map[58].append(c) if c % 14 < 14 and c & 128 == 0 and c + 25 == 122 and c < 146 and c > 30 else ''
  map[65].append(c) if c % 22 < 22 and c & 128 == 0 and c - 29 == 70 and c < 149 and c > 1 else ''
  map[74].append(c) if c % 10 < 10 and c & 128 == 0 and c + 11 == 116 and c < 152 and c > 1 else ''
  map[75].append(c) if c % 24 < 24 and c & 128 == 0 and c - 30 == 86 and c < 142 and c > 30 else ''
  map[84].append(c) if c % 18 < 18 and c & 128 == 0 and c + 3 == 128 and c < 129 and c > 26 else ''

for c in range(256):
  try:
    map[2].remove(c)  if filesize ^ c == 205 or filesize ^ c == 54 else ''
    map[7].remove(c)  if filesize ^ c == 15 or filesize ^ c == 221 else ''
    map[14].remove(c) if filesize ^ c == 161 or filesize ^ c == 99 else ''
    map[15].remove(c) if filesize ^ c == 205 or filesize ^ c == 27 else ''
    map[16].remove(c) if filesize ^ c == 144 or filesize ^ c == 7 else ''
    map[21].remove(c) if filesize ^ c == 188 or filesize ^ c == 27 else ''
    map[26].remove(c) if filesize ^ c == 161 or filesize ^ c == 44 else ''
    map[27].remove(c) if filesize ^ c == 244 or filesize ^ c == 43 else ''
    map[36].remove(c) if filesize ^ c == 6 or filesize ^ c == 95 else ''
    map[45].remove(c) if filesize ^ c == 146 or filesize ^ c == 19 else ''
    map[56].remove(c) if filesize ^ c == 22 or filesize ^ c == 246 else ''
    map[57].remove(c) if filesize ^ c == 14 or filesize ^ c == 186 else ''
    map[58].remove(c) if filesize ^ c == 12 or filesize ^ c == 77 else ''
    map[65].remove(c) if filesize ^ c == 215 or filesize ^ c == 28 else ''
    map[74].remove(c) if filesize ^ c == 193 or filesize ^ c == 45 else ''
    map[75].remove(c) if filesize ^ c == 25 or filesize ^ c == 35 else ''
    map[84].remove(c) if filesize ^ c == 231 or filesize ^ c == 3 else ''
  except ValueError:
    pass

_10 = hex(2448764514 - 383041523)[2:]
map[10] = [int(_10[:2], 16)]
map[10+1] = [int(_10[2:4], 16)]
map[10+2] = [int(_10[4:6], 16)]
map[10+3] = [int(_10[6:8], 16)]
_17 = hex(1412131772 + 323157430)[2:]
map[17] = [int(_17[:2], 16)]
map[17+1] = [int(_17[2:4], 16)]
map[17+2] = [int(_17[4:6], 16)]
map[17+3] = [int(_17[6:8], 16)]
_22 = hex(1879700858 ^ 372102464)[2:]
map[22] = [int(_22[:2], 16)]
map[22+1] = [int(_22[2:4], 16)]
map[22+2] = [int(_22[4:6], 16)]
map[22+3] = [int(_22[6:8], 16)]
_28 = hex(959764852 + 419186860)[2:]
map[28] = [int(_28[:2], 16)]
map[28+1] = [int(_28[2:4], 16)]
map[28+2] = [int(_28[4:6], 16)]
map[28+3] = [int(_28[6:8], 16)]
_3 = hex(2108416586 ^ 298697263)[2:]
map[3] = [int(_3[:2], 16)]
map[3+1] = [int(_3[2:4], 16)]
map[3+2] = [int(_3[4:6], 16)]
map[3+3] = [int(_3[6:8], 16)]
_37 = hex(1228527996 - 367943707)[2:]
map[37] = [int(_37[:2], 16)]
map[37+1] = [int(_37[2:4], 16)]
map[37+2] = [int(_37[4:6], 16)]
map[37+3] = [int(_37[6:8], 16)]
_41 = hex(1699114335 - 404880684)[2:]
map[41] = [int(_41[:2], 16)]
map[41+1] = [int(_41[2:4], 16)]
map[41+2] = [int(_41[4:6], 16)]
map[41+3] = [int(_41[6:8], 16)]
_46 = hex(1503714457 + 412326611)[2:]
map[46] = [int(_46[:2], 16)]
map[46+1] = [int(_46[2:4], 16)]
map[46+2] = [int(_46[4:6], 16)]
map[46+3] = [int(_46[6:8], 16)]
_52 = hex(1495724241 ^ 425706662)[2:]
map[52] = [int(_52[:2], 16)]
map[52+1] = [int(_52[2:4], 16)]
map[52+2] = [int(_52[4:6], 16)]
map[52+3] = [int(_52[6:8], 16)]
_59 = hex(1908304943 ^ 512952669)[2:]
map[59] = [int(_59[:2], 16)]
map[59+1] = [int(_59[2:4], 16)]
map[59+2] = [int(_59[4:6], 16)]
map[59+3] = [int(_59[6:8], 16)]
_66 = hex(849718389 ^ 310886682)[2:]
map[66] = [int(_66[:2], 16)]
map[66+1] = [int(_66[2:4], 16)]
map[66+2] = [int(_66[4:6], 16)]
map[66+3] = [int(_66[6:8], 16)]
_70 = hex(2034162376 - 349203301)[2:]
map[70] = [int(_70[:2], 16)]
map[70+1] = [int(_70[2:4], 16)]
map[70+2] = [int(_70[4:6], 16)]
map[70+3] = [int(_70[6:8], 16)]
_80 = hex(69677856 + 473886976)[2:]
map[80] = [int(_80[:2], 16)]
map[80+1] = [int(_80[2:4], 16)]
map[80+2] = [int(_80[4:6], 16)]
map[80+3] = [int(_80[6:8], 16)]

def find_crc32(offset, target):
  for a in range(256):
    for b in range(256):
      if hash.crc32((chr(a) + chr(b)).encode('utf-8')) == target:
        map[offset] = [a]
        map[offset+1] = [b]
        return
  print('NOT FOUND')

find_crc32(34, 0x5888fc1b)
find_crc32(63, 0x66715919)
find_crc32(78, 0x7cab8d64)
find_crc32(8, 0x61089c5c)

def find_md5(offset, target):
  for a in range(256):
    for b in range(256):
      if md5((chr(a) + chr(b)).encode('utf-8')).hexdigest() == target:
        map[offset] = [a]
        map[offset+1] = [b]
        return
  print('NOT FOUND')

find_md5(0, "89484b14b36a8d5329426a3d944d2983")
find_md5(32, "738a656e8e8ec272ca17cd51e12f558b")
find_md5(50, "657dae0913ee12be6fb2a6f687aae1c7")
find_md5(76, "f98ed07a4d5f50f7de1410d905f1477f")

def find_sha256(offset, target):
  for a in range(256):
    for b in range(256):
      if sha256((chr(a) + chr(b)).encode('utf-8')).hexdigest() == target:
        map[offset] = [a]
        map[offset+1] = [b]
        return
  print('NOT FOUND')

find_sha256(14, "403d5f23d149670348b147a15eeb7010914701a7e99aad2e43f90cfa0325c76f")
find_sha256(56, "593f2d04aab251f60c9e4b8bbc1e05a34e920980ec08351a18459b2bc7dbf2f6")

# for i in range(filesize):
#   print(f'{i}:', map[i])

for i in range(filesize):
  print(f'{chr(map[i][0])}', end='')
