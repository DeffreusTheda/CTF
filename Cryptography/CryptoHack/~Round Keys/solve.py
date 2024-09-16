state = [
    [206, 243, 61, 34],
    [171, 11, 93, 31],
    [16, 200, 91, 108],
    [150, 3, 194, 51],
]

round_key = [
    [173, 129, 68, 82],
    [223, 100, 38, 109],
    [32, 189, 53, 8],
    [253, 48, 187, 78],
]


def matrix2bytes(matrix):
    """ Converts a 4x4 matrix into a 16-byte array.  """
    iamsuckatthisokay = ''
    for mm in matrix:
        for mmm in mm:
            iamsuckatthisokay += chr(mmm)
    return iamsuckatthisokay

def add_round_key(s, k):
    heyaa = [[0, 0, 0, 0] for i in range(4)]
    for row in range(len(s)):
        for col in range(len(s[row])):
            heyaa[row][col] = state[row][col] ^ round_key[row][col]
    return heyaa


print(add_round_key(state, round_key))
print(matrix2bytes(add_round_key(state, round_key)))
