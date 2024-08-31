codedInput = [55, 33, 52, 40, 35, 56, 86, 90, 66, 111, 81, 26, 23, 75, 109, 26, 88, 90, 75, 67, 92, 25, 87, 88, 92, 84, 23, 88]

codedInput = codedInput[0:14] + codedInput[14:28][::-1]

tmp3 = codedInput[17]
codedInput[17] = codedInput[12]
codedInput[12] = tmp3

tmp2  = codedInput[10]
codedInput[10] = codedInput[8]
codedInput[8] = tmp2

tmp1 = codedInput[6]
codedInput[6] = codedInput[9]
codedInput[9] = tmp1

for c in codedInput:
    print(chr((c ^ 15) + 27), end='')
