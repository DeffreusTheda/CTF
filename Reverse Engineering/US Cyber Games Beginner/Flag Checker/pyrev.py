codedPass = [55, 33, 52, 40, 35, 56, 86, 90, 66, 111, 81, 26, 23, 75, 109, 26, 88, 90, 75, 67, 92, 25, 87, 88, 92, 84, 23, 88]

input = input("Enter the flag: ")
ordInput = [ord(i) for i in input]
ordInputLen = len(ordInput)
codedPassLen = len(codedPass) # 28

makeupRoof = []
codedInput = []
if codedPassLen == ordInputLen:
    for c in ordInput:
        makeupRoof.append(c - 27)
    for c in makeupRoof:
        codedInput.append(c ^ 15)

    # Swap 7th and 10th char
    tmp1 = codedInput[6]
    codedInput[6] = codedInput[9]
    codedInput[9] = tmp1

    # Swap 9th and 11st char
    tmp2  = codedInput[10]
    codedInput[10] = codedInput[8]
    codedInput[8] = tmp2

    # Swap 18th and 12nd char
    tmp3 = codedInput[17]
    codedInput[17] = codedInput[12]
    codedInput[12] = tmp3

    # Reverse the second half
    firstHalf = codedInput[0:14]
    secondHalf = codedInput[14:28]
    codedInput = firstHalf + secondHalf[::-1]

    if codedInput == codedPass:
        print("Correct!! :)")
    else:
        print("Incorrect flag :(")

else:
    print("Incorrect :(")
