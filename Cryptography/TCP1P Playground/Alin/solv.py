from z3 import *

def multiply(matrix1, matrix2):
    rows = len(matrix1)
    cols = len(matrix2[0])
    n = cols
    result = [[0 for _ in range(cols)] for _ in range(rows)]
    
    for i in range(rows):
        for j in range(cols):
            for k in range(n):
                result[i][j] += matrix1[i][k] * matrix2[k][j]
    
    return result

def array_to_matrix(text):
    matrices = []
    for i in range(0, len(text), 9):
        matrix = [[0 for _ in range(3)] for _ in range(3)]
        for j in range(9):
            matrix[j // 3][j % 3] = text[i + j]
        matrices.append(matrix)
    return matrices

def main():
    # plaintext = input("plaintext: ")
    
    # # Pad the plaintext if necessary
    # if len(plaintext) % 9 != 0:
    #     plaintext += "?" * (9 - len(plaintext) % 9)

    s = Solver()
    plaintext = [BitVec(f'flag{i:02d}', 32) for i in range(63)]
    for c in plaintext:
        s.add(31 < c, c < 127)
    # s.add(plaintext[0] == ord('T'))
    # s.add(plaintext[1] == ord('C'))
    # s.add(plaintext[2] == ord('P'))
    # s.add(plaintext[3] == ord('1'))
    # s.add(plaintext[4] == ord('P'))
    # s.add(plaintext[5] == ord('{'))

    ct = [16591, 16716, 18720, 14700, 14839, 16596, 15681, 15810, 17737, 23089, 23142, 25955, 18377, 18305, 20521, 14746, 14738, 16272, 19214, 19535, 21465, 22507, 22778, 25463, 19780, 19694, 22182, 18507, 18417, 20641, 18043, 18278, 20120, 21986, 22215, 24733, 19077, 19278, 21221, 23126, 23249, 26010, 19701, 19598, 22096, 17963, 17903, 20089, 17817, 17747, 19921, 19586, 19894, 22442, 16831, 16778, 18597, 13356, 13482, 15057, 13356, 13482, 15057]
    
    result = [0] * 63
    matrices = array_to_matrix(plaintext)
    print(matrices)
    
    for i in range(len(matrices)):
        current_matrix = matrices[i]
        key_matrix = matrices[0]  # First block is used as key
        encrypted_matrix = multiply(current_matrix, key_matrix)
        
        # Flatten the encrypted matrix into the result array
        for row in range(3):
            for col in range(3):
                s.add(ct[i * 9 + row * 3 + col] == encrypted_matrix[row][col])
    print(s)
    
    # Print the ciphertext
    # print("ciphertext:", end=" ")
    # print(" ".join(map(str, result)))
    if s.check() == sat:
        model = s.model()
        print(model)
        # flag = ''.join([chr(model[x].as_long()) for x in c])
        if check_flag(flag):
            print("FOUND:", flag)
        else:
            print("Shitt:", flag)
    else:
        print("No solution found")


if __name__ == "__main__":
    main()
