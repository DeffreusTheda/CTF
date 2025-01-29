from z3 import *

flag = [BitVec(f'f{hex(i)[2:].rjust(2, '0')}', 8) for i in range(23)]
s = Solver()

R0 = flag[0x01]
R1 = flag[0x03]
R0 ^= R1
R2 = flag[0x15]
R0 += R2
R3 = 0x00000079
s.add(R0 == R3)

R0 = flag[0x02]
R1 = flag[0x0B]
R0 += R1
R2 = flag[0x13]
R0 ^= R2
R3 = 0x00000090
s.add(R0 == R3)

R0 = flag[0x0D]
R1 = flag[0x0E]
R0 += R1
R2 = flag[0x11]
R0 += R2
R3 = 0x000000DF
s.add(R0 == R3)

R0 = flag[0x0E]
R1 = flag[0x10]
R0 += R1
R2 = flag[0x12]
R0 ^= R2
R3 = 0x000000F9
s.add(R0 == R3)

R0 = flag[0x04]
R1 = flag[0x0E]
R0 += R1
R2 = flag[0x11]
R0 += R2
R3 = 0x0000011D
s.add(R0 == R3)

R0 = flag[0x02]
R1 = flag[0x0C]
R0 += R1
R2 = flag[0x0D]
R0 ^= R2
R3 = 0x00000097
s.add(R0 == R3)

R0 = flag[0x04]
R1 = flag[0x06]
R0 ^= R1
R2 = flag[0x09]
R0 += R2
R3 = 0x00000049
s.add(R0 == R3)

R0 = flag[0x10]
R1 = flag[0x15]
R0 ^= R1
R2 = flag[0x16]
R0 += R2
R3 = 0x000000E2
s.add(R0 == R3)

R0 = flag[0x03]
R1 = flag[0x0C]
R0 ^= R1
R2 = flag[0x13]
R0 ^= R2
R3 = 0x0000005F
s.add(R0 == R3)

R0 = flag[0x08]
R1 = flag[0x0B]
R0 ^= R1
R2 = flag[0x13]
R0 ^= R2
R3 = 0x00000070
s.add(R0 == R3)

R0 = flag[0x02]
R1 = flag[0x03]
R0 ^= R1
R2 = flag[0x06]
R0 ^= R2
R3 = 0x00000027
s.add(R0 == R3)

R0 = flag[0x04]
R1 = flag[0x07]
R0 ^= R1
R2 = flag[0x08]
R0 += R2
R3 = 0x00000077
s.add(R0 == R3)

R0 = flag[0x02]
R1 = flag[0x0F]
R0 += R1
R2 = flag[0x14]
R0 ^= R2
R3 = 0x0000009B
s.add(R0 == R3)

R0 = flag[0x08]
R1 = flag[0x11]
R0 += R1
R2 = flag[0x14]
R0 += R2
R3 = 0x00000158
s.add(R0 == R3)

R0 = flag[0x01]
R1 = flag[0x02]
R0 ^= R1
R2 = flag[0x08]
R0 ^= R2
R3 = 0x00000075
s.add(R0 == R3)

R0 = flag[0x09]
R1 = flag[0x0C]
R0 += R1
R2 = flag[0x14]
R0 ^= R2
R3 = 0x00000014
s.add(R0 == R3)

R0 = flag[0x04]
R1 = flag[0x0F]
R0 += R1
R2 = flag[0x15]
R0 += R2
R3 = 0x0000011E
s.add(R0 == R3)

R0 = flag[0x06]
R1 = flag[0x08]
R0 ^= R1
R2 = flag[0x11]
R0 += R2
R3 = 0x0000008A
s.add(R0 == R3)

R0 = flag[0x06]
R1 = flag[0x0C]
R0 += R1
R2 = flag[0x14]
R0 ^= R2
R3 = 0x000000E5
s.add(R0 == R3)

R0 = flag[0x08]
R1 = flag[0x0D]
R0 ^= R1
R2 = flag[0x0F]
R0 ^= R2
R3 = 0x0000003D
s.add(R0 == R3)

R0 = flag[0x0B]
R1 = flag[0x11]
R0 += R1
R2 = flag[0x15]
R0 += R2
R3 = 0x00000108
s.add(R0 == R3)

R0 = flag[0x01]
R1 = flag[0x02]
R0 += R1
R2 = flag[0x0E]
R0 += R2
R3 = 0x0000011A
s.add(R0 == R3)

R0 = flag[0x03]
R1 = flag[0x04]
R0 += R1
R2 = flag[0x16]
R0 ^= R2
R3 = 0x000000D3
s.add(R0 == R3)

R0 = flag[0x00]
R1 = flag[0x06]
R0 += R1
R2 = flag[0x0F]
R0 += R2
R3 = 0x00000112
s.add(R0 == R3)

R0 = flag[0x07]
R1 = flag[0x0C]
R0 += R1
R2 = flag[0x16]
R0 ^= R2
R3 = 0x000000DE
s.add(R0 == R3)

R0 = flag[0x01]
R1 = flag[0x04]
R0 += R1
R2 = flag[0x0E]
R0 ^= R2
R3 = 0x000000D2
s.add(R0 == R3)

R0 = flag[0x03]
R1 = flag[0x10]
R0 ^= R1
R2 = flag[0x11]
R0 ^= R2
R3 = 0x0000001A
s.add(R0 == R3)

R0 = flag[0x0E]
R1 = flag[0x0F]
R0 ^= R1
R2 = flag[0x12]
R0 += R2
R3 = 0x000000B9
s.add(R0 == R3)

R0 = flag[0x0A]
R1 = flag[0x11]
R0 ^= R1
R2 = flag[0x13]
R0 ^= R2
R3 = 0x0000005B
s.add(R0 == R3)

R0 = flag[0x03]
R1 = flag[0x05]
R0 ^= R1
R2 = flag[0x0C]
R0 ^= R2
R3 = 0x0000005F
s.add(R0 == R3)

R0 = flag[0x02]
R1 = flag[0x15]
R0 += R1
R2 = flag[0x16]
R0 += R2
R3 = 0x00000119
s.add(R0 == R3)

R0 = flag[0x04]
R1 = flag[0x0F]
R0 += R1
R2 = flag[0x11]
R0 ^= R2
R3 = 0x0000009D
s.add(R0 == R3)

R0 = flag[0x03]
R1 = flag[0x0C]
R0 += R1
R2 = flag[0x10]
R0 ^= R2
R3 = 0x00000039
s.add(R0 == R3)

R0 = flag[0x07]
R1 = flag[0x0F]
R0 ^= R1
R2 = flag[0x13]
R0 ^= R2
R3 = 0x00000053
s.add(R0 == R3)

R0 = flag[0x02]
R1 = flag[0x05]
R0 ^= R1
R2 = flag[0x09]
R0 ^= R2
R3 = 0x0000001C
s.add(R0 == R3)

R0 = flag[0x02]
R1 = flag[0x14]
R0 ^= R1
R2 = flag[0x16]
R0 += R2
R3 = 0x00000078
s.add(R0 == R3)

R0 = flag[0x03]
R1 = flag[0x06]
R0 += R1
R2 = flag[0x08]
R0 ^= R2
R3 = 0x000000E7
s.add(R0 == R3)

R0 = flag[0x06]
R1 = flag[0x0B]
R0 ^= R1
R2 = flag[0x12]
R0 ^= R2
R3 = 0x00000056
s.add(R0 == R3)

R0 = flag[0x03]
R1 = flag[0x0F]
R0 += R1
R2 = flag[0x11]
R0 ^= R2
R3 = 0x000000DA
s.add(R0 == R3)

R0 = flag[0x00]
R1 = flag[0x0B]
R0 ^= R1
R2 = flag[0x12]
R0 ^= R2
R3 = 0x00000007
s.add(R0 == R3)

R0 = flag[0x09]
R1 = flag[0x0C]
R0 += R1
R2 = flag[0x11]
R0 ^= R2
R3 = 0x00000010
s.add(R0 == R3)

R0 = flag[0x08]
R1 = flag[0x0C]
R0 += R1
R2 = flag[0x0F]
R0 += R2
R3 = 0x0000011C
s.add(R0 == R3)

R0 = flag[0x00]
R1 = flag[0x10]
R0 += R1
R2 = flag[0x15]
R0 += R2
R3 = 0x000000C7
s.add(R0 == R3)

R0 = flag[0x01]
R1 = flag[0x05]
R0 ^= R1
R2 = flag[0x12]
R0 += R2
R3 = 0x00000097
s.add(R0 == R3)

R0 = flag[0x0A]
R1 = flag[0x14]
R0 ^= R1
R2 = flag[0x15]
R0 += R2
R3 = 0x00000033
s.add(R0 == R3)

R0 = flag[0x0B]
R1 = flag[0x0C]
R0 += R1
R2 = flag[0x0E]
R0 ^= R2
R3 = 0x000000A7
s.add(R0 == R3)

R0 = flag[0x02]
R1 = flag[0x09]
R0 ^= R1
R2 = flag[0x0C]
R0 ^= R2
R3 = 0x00000070
s.add(R0 == R3)

R0 = flag[0x04]
R1 = flag[0x06]
R0 += R1
R2 = flag[0x0A]
R0 ^= R2
R3 = 0x000000A4
s.add(R0 == R3)

R0 = flag[0x05]
R1 = flag[0x0B]
R0 += R1
R2 = flag[0x0F]
R0 += R2
R3 = 0x00000137
s.add(R0 == R3)

R0 = flag[0x04]
R1 = flag[0x09]
R0 += R1
R2 = flag[0x0A]
R0 += R2
R3 = 0x00000117
s.add(R0 == R3)

R0 = flag[0x07]
R1 = flag[0x08]
R0 ^= R1
R2 = flag[0x0A]
R0 += R2
R3 = 0x00000077
s.add(R0 == R3)

R0 = flag[0x03]
R1 = flag[0x0B]
R0 += R1
R2 = flag[0x15]
R0 += R2
R3 = 0x000000C5
s.add(R0 == R3)

R0 = flag[0x0B]
R1 = flag[0x0F]
R0 ^= R1
R2 = flag[0x14]
R0 ^= R2
R3 = 0x00000054
s.add(R0 == R3)

R0 = flag[0x00]
R1 = flag[0x05]
R0 ^= R1
R2 = flag[0x08]
R0 ^= R2
R3 = 0x0000001A
s.add(R0 == R3)

R0 = flag[0x02]
R1 = flag[0x06]
R0 ^= R1
R2 = flag[0x16]
R0 += R2
R3 = 0x0000008A
s.add(R0 == R3)

R0 = flag[0x09]
R1 = flag[0x0F]
R0 ^= R1
R2 = flag[0x14]
R0 ^= R2
R3 = 0x00000038
s.add(R0 == R3)

R0 = flag[0x04]
R1 = flag[0x12]
R0 += R1
R2 = flag[0x15]
R0 += R2
R3 = 0x00000112
s.add(R0 == R3)

R0 = flag[0x03]
R1 = flag[0x0B]
R0 ^= R1
R2 = flag[0x0E]
R0 += R2
R3 = 0x000000A1
s.add(R0 == R3)

R0 = flag[0x07]
R1 = flag[0x09]
R0 += R1
R2 = flag[0x10]
R0 ^= R2
R3 = 0x000000F7
s.add(R0 == R3)

R0 = flag[0x05]
R1 = flag[0x0B]
R0 ^= R1
R2 = flag[0x10]
R0 ^= R2
R3 = 0x0000005F
s.add(R0 == R3)

R0 = flag[0x05]
R1 = flag[0x07]
R0 += R1
R2 = flag[0x0E]
R0 ^= R2
R3 = 0x000000E1
s.add(R0 == R3)

R0 = flag[0x08]
R1 = flag[0x0E]
R0 ^= R1
R2 = flag[0x0F]
R0 ^= R2
R3 = 0x0000003C
s.add(R0 == R3)

R0 = flag[0x07]
R1 = flag[0x0A]
R0 ^= R1
R2 = flag[0x0E]
R0 += R2
R3 = 0x0000003C
s.add(R0 == R3)

R0 = flag[0x03]
R1 = flag[0x04]
R0 += R1
R2 = flag[0x08]
R0 += R2
R3 = 0x00000115
s.add(R0 == R3)

R0 = flag[0x03]
R1 = flag[0x08]
R0 ^= R1
R2 = flag[0x14]
R0 ^= R2
R3 = 0x00000031
s.add(R0 == R3)

R0 = flag[0x09]
R1 = flag[0x0B]
R0 += R1
R2 = flag[0x14]
R0 += R2
R3 = 0x00000104
s.add(R0 == R3)

R0 = flag[0x01]
R1 = flag[0x0B]
R0 ^= R1
R2 = flag[0x15]
R0 ^= R2
R3 = 0x00000019
s.add(R0 == R3)

R0 = flag[0x03]
R1 = flag[0x08]
R0 += R1
R2 = flag[0x15]
R0 += R2
R3 = 0x000000D6
s.add(R0 == R3)

R0 = flag[0x03]
R1 = flag[0x08]
R0 += R1
R2 = flag[0x09]
R0 ^= R2
R3 = 0x00000090
s.add(R0 == R3)

if s.check() == sat:
    print('yes')
    m = s.model()
    for ss in m:
        print(ss, m[ss], chr(m[ss].as_long()))
else:
    print('no')
