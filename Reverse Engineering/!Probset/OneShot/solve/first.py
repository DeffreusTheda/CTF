from z3 import *

r1 = [[BitVec(f'f_{y}_{x}', 8) for x in range(27)] for y in range(6)]
r0 = 0

r3 = [121, 105, 121, 122, 103, 98, 70, 112, 41, 112, 102, 40, 105, 44, 112, 127, 47, 42, 112, 46, 105, 117, 112, 125, 46, 123, 41]
r2 = 0
while r2 < 27:
    # print(r1[r0][r2])
    r1 = r1[:r0] + [ r1[r0][:r2] + \
            bytes([r1[r0][r2] ^ (r1[r0][r2] >> 1)]) + \
            r1[r0][r2+1:] ] + \
        r1[r0+1:]
    
    if r1[0][r2] != r3[r2]:
        destruction(reg)
    r2 = r2 + 1
r0 = r0 + 1

r4 = [59, 60, 82, 46, 58, 91, 53, 75, 98, 75, 91, 94, 54, 67, 82, 50, 79, 57, 51, 47, 92, 91, 68, 56, 77, 57, 80]
r2 = 0
while r2 < 27:
    r3 = (r2 - 13) // 2 * (-1 if r2 & 1 == 0 else 1)
    r1 = r1[:r0] + [ r1[r0][:r2] + \
            bytes([r1[r0][r2] + reg.u2s(r3)]) + \
            r1[r0][r2+1:] ] + \
        r1[r0+1:]
    
    if r1[r0][r2] != r4[r2]:
        destruction(reg)
    r2 = r2 + 1
r0 = r0 + 1
    
r4 = [63, 43, 39, 12, 19, 36, 61, 6, 34, 50, 63, 61, 54, 53, 24, 37, 59, 44, 46, 66, 55, 57, 13, 59, 41, 11, 13, 15, 53, 23, 51, 22, 64, 0, 32]
r3 = int.from_bytes(r1[r0])
r2 = 0
while r2 < len(r4):
    r5 = (r3 // (69 ** (len(r4) - 1 - r2))) % 69
    r3 = r3 - (r5 * 69**(len(r4) - 1 - r2))
    if r5 != r4[r2]:
        destruction(reg)
    r2 = r2 + 1
r0 = r0 + 1

r4 = """
========================
THE E†IGMA OF HEAVEN
========================

PRAISE THE LORD! The air conditioner †eeps them away it sings gospels and
†RAISE THE LORD! Finding faith in wh†te noise.
PRAISE THE LORD! The messages are coming in loud and clear †nd
I hear them and I see them in t†e sky the towers are sending messages and
I hear them and I see them.
PRAISE T†E LORD! The people in the parkin† lot can't hurt me anymore
they can't †urt me anymore their words are weak and the lord is strong.
PRAISE THE LORD! T†e bible shows the way and the way prot†cts me and
I've seen the messag†s and I heart them and I see them and they can't
hurt me anymore.
PRAISE THE L†RD!

CHAPTERS:                        †        ╔═══════════════╗
—————————                    †            ║               ║
I. T†e Enigma of Heaven:                  ║    HEAVEN     ║
9,999,999 Channels, Fi†ding Faith        ╟───────────────╢
in White Noise... The God St†mulation!   ║               ║
II. †he Hierarchy of Equality:            †   RADIATION   ║
Angelic Voices†Echo Through the Halls    ╟─────────†─────╢
of Heaven, Under the Railroad †ridge     ║               ║    "And I have
III. The Paradox of Fa†th:                ║     RADIO     ║      told you
There's a Knocking a† the Door!          ╟──────†────────╢     the TRUTH,
God is in, God is in!                    ║          †    ║
IV. The Senselessness of Endlessness:     ║  TELEVISION   ║      for you
Returning to an Empty Apartment          ║               ║   are my child,
with a Grocery Store Guardian Angel      ╚═══════════════╝    and you have
                                                  seen my face"

An EP titled "The Enigma of Heaven and Other Daily Delusions" """
r2 = 0
r3 = 0
while r2 < 27:
    r3 = r3 + r1[r0][r2] - 0x10
    try:
        if r4[r3] != '†':
            destruction(reg)
    except IndexError:
        destruction(reg)
    r2 = r2 + 1
r0 = r0 + 1

r4 = [1611216, 946813, 716893, 716989, 488303, 939977, 1175675, 1391467, 1391323]
r2 = 0
while r2 < 9:
    r6 = (r1[r0][r2*3+0] | (r1[r0][r2*3+0] << 16)) & 0x030000FF
    r6 = (r6 | (r6 << 8))  & 0x0300F00F
    r6 = (r6 | (r6 << 4))  & 0x030C30C3
    r6 = (r6 | (r6 << 2))  & 0x09249249
    r5 = r6
    r6 = (r1[r0][r2*3+1] | (r1[r0][r2*3+1] << 16)) & 0x030000FF
    r6 = (r6 | (r6 << 8))  & 0x0300F00F
    r6 = (r6 | (r6 << 4))  & 0x030C30C3
    r6 = (r6 | (r6 << 2))  & 0x09249249
    r5 = r5 | (r6 << 1)
    r6 = (r1[r0][r2*3+2] | (r1[r0][r2*3+2] << 16)) & 0x030000FF
    r6 = (r6 | (r6 << 8))  & 0x0300F00F
    r6 = (r6 | (r6 << 4))  & 0x030C30C3
    r6 = (r6 | (r6 << 2))  & 0x09249249
    r5 = r5 | (r6 << 2)
    # print(f'{r5} {r4[r2]}')
    if r5 != r4[r2]:
        destruction(reg)
    r2 = r2 + 1
r0 = r0 + 1

r2 = 0
while r2 < 27:
    r1 = r1[:r0] + [ r1[r0][:r2] + \
            bytes([r1[r0][r2] + ((r1[r0][r2] - 13 + (1 if r1[r0][r2] > 12 else 0)) // 2 * (-1 if r1[r0][r2] & 1 == 0 else 1))]) + \
            r1[r0][r2+1:] ] + \
        r1[r0+1:]
    
    r2 = r2 + 1

r2 = []  # Recording: list of [m, j] for swaps
r3 = [[0, 26, 0]]  # Call stack: list of [i, j, phase]

while len(r3) > 0:
    r4 = r3[-1][0]  # i
    r5 = r3[-1][1]  # j
    r6 = r3[-1][2]  # phase (NOT mid)
    r7 = (r4 + r5) // 2  # mid

    if r4 >= r5:
        r3 = r3[:-1]  # Pop
        continue

    if r6 == 0:  # Push left child
        r3 = r3[:-1] + [[r4, r5, 1]]
        r3 = r3 + [[r4, r7, 0]]

    elif r6 == 1:  # Push right child
        r3 = r3[:-1] + [[r4, r5, 2]]
        r3 = r3 + [[r7+1, r5, 0]]

    elif r6 == 2:  # Merge phase
        if r1[r0][r5] < r1[r0][r7]:
            r1 = r1[:r0] + [ r1[r0][:r7] + \
                    bytes([r1[r0][r5]]) + \
                    r1[r0][r7+1:r5] + \
                    bytes([r1[r0][r7]]) + \
                    r1[r0][r5+1:] ] + \
                r1[r0+1:]
            
            r2 = r2 + [[r7, r5]]
        r3 = r3[:-1] + [[r4, r5, 3]]

    elif r6 == 3:  # Final recursive call
        r3 = r3[:-1] + [[r4, r5-1, 0]]

if r1[r0] != bytes([30, 30, 32, 40, 42, 45, 45, 45, 46, 67, 70, 70, 70, 70, 73, 76, 76, 76, 76, 94, 109, 136, 136, 136, 136, 136, 181]):
    destruction(reg)
if r2 != [[2, 3], [1, 3], [1, 2], [0, 1], [4, 5], [5, 6], [4, 5], [3, 6], [3, 4], [4, 5], [2, 4], [2, 3], [1, 3], [1, 2], [8, 9], [11, 12], [12, 13], [11, 12], [10, 11], [9, 10], [8, 9], [7, 8], [6, 12], [6, 7], [7, 8], [8, 10], [8, 9], [5, 11], [4, 5], [5, 10], [5, 6], [6, 7], [7, 9], [7, 8], [4, 8], [4, 5], [5, 7], [3, 6], [3, 4], [2, 5], [2, 3], [16, 17], [15, 16], [19, 20], [18, 19], [17, 20], [17, 18], [16, 19], [16, 17], [15, 16], [22, 23], [21, 22], [23, 24], [20, 21], [21, 22], [22, 23], [19, 20], [20, 21], [18, 19], [17, 18], [13, 14], [14, 16], [14, 15], [16, 19], [16, 17], [19, 20], [20, 21], [21, 22], [12, 13], [13, 14], [14, 17], [14, 16], [14, 15], [17, 18], [18, 19], [19, 21], [11, 12], [12, 13], [13, 16], [13, 15], [13, 14], [16, 17], [17, 18], [18, 20], [10, 11], [11, 12], [12, 14], [12, 13], [14, 19], [14, 15], [15, 17], [15, 16], [9, 10], [10, 11], [11, 13], [11, 12], [13, 14], [14, 16], [14, 15], [8, 9], [9, 11], [9, 10], [11, 15], [11, 14], [11, 12], [7, 8], [8, 10], [8, 9], [10, 11], [6, 7], [7, 8], [8, 10], [8, 9], [5, 6], [6, 7], [7, 8], [4, 5], [5, 6], [3, 4], [4, 5], [2, 4], [2, 3]]:
    destruction(reg)
r0 = r0 + 1

print()
print("Niko's eyes light up. The puzzle dissolves.")
print("\"We did it! We actually made it!\"")
print("The way forward opens. Niko is free.")
print()
r8 = '.effie'
