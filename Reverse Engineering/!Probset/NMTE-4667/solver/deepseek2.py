import numpy as np

def unb64(value):
    if 0 <= value <= 25:  # A-Z
        return chr(int(value) + 65)
    elif 26 <= value <= 35:  # 0-9
        return chr(int(value) + 22)  # 26->48='0'
    elif value == 36: return '_'
    elif value == 37: return ','
    elif value == 38: return '?'
    elif value == 39: return '!'
    elif value == 40: return '-'
    elif value == 41: return '{'
    elif value == 42: return '}'
    else: return '?'

G = np.array([
    [25, 12, 36, 34, 4, 35, 27],
    [24, 34, 7, 5, 17, 38, 13],
    [28, 6, 5, 2, 12, 37, 10],
    [4, 38, 33, 17, 27, 34, 17],
    [1, 5, 16, 25, 10, 37, 18],
    [16, 38, 5, 6, 17, 3, 16]
])

H = np.array([
    [1456, 2713, 2312, 2353, 1702, 3480, 2301],
    [2571, 3208, 2303, 1973, 2241, 4867, 2392],
    [2707, 3605, 3433, 2840, 2488, 5681, 2961],
    [2532, 4308, 2485, 2171, 2860, 5216, 2737]
])

G_pinv = np.linalg.pinv(G)
H_approx = H @ G_pinv
H_rounded = np.round(H_approx).astype(int)
H_rounded = np.clip(H_rounded, 0, 42)

print("Recovered Hjmatrix (4x6):")
print(H_rounded)
print(H)

print(''.join([(' '.join([val for val in H_rounded[i]])) for i in range(4)]))
print(''.join([(''.join([unb64(val) for val in H_rounded[i]])) for i in range(4)]))
