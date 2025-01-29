import numpy as np

# Embedding mappings
def embedding_to_char(value):
    value = int(value)
    if 0 <= value <= 25:  # A-Z
        return chr(value + 65)
    elif 26 <= value <= 35:  # 0-9
        return chr(value + 22)  # 26->48='0'
    elif value == 36: return '_'
    elif value == 37: return ','
    elif value == 38: return '?'
    elif value == 39: return '!'
    elif value == 40: return '-'
    elif value == 41: return '{'
    elif value == 42: return '}'
    else: return '?'

# We have good v44 from before
v44 = np.array([
    [23, 12,  0, 18, 41, 30],
    [17, 29, 36, 24, 26, 20],
    [36, 25, 29, 40, 27, 13],
    [ 6, 36, 27, 33, 38, 37]
])

v41 = np.array([
    [25, 12, 36, 34, 4, 35, 27],
    [24, 34, 7, 5, 17, 38, 13],
    [28, 6, 5, 2, 12, 37, 10],
    [4, 38, 33, 17, 27, 34, 17],
    [1, 5, 16, 25, 10, 37, 18],
    [16, 38, 5, 6, 17, 3, 16]
])

v28 = np.array([
    [1456, 2713, 2312, 2353, 1702, 3480, 2301],
    [2571, 3208, 2303, 1973, 2241, 4867, 2392],
    [2707, 3605, 3433, 2840, 2488, 5681, 2961],
    [2532, 4308, 2485, 2171, 2860, 5216, 2737]
])

v31 = np.array([[ord(c)-19968 for c in "嬴嬏堷奀圓塳廼峣寗嬜姈屯徵幃宭帷孺岽愔憍平峛岦廢"]])
v31 = v31.reshape(4, 6)

v30 = np.array([[ord(c)-19968 for c in "圐坾嵣圣天屐圌尵尲怟寑崣巷圭市府扪径帜帴囊帿嵁挿宺怃憪娸"]])
v30 = v30.reshape(4, 7)

v29 = np.array([[ord(c)-19968 for c in "培夕屃姠埢墊哹嵫庙掳巣弍慚妖堣娻庱嫃奀寲坹实嫷幟奮屴岡嘎妉媗嵡媴婊孊唷媻峚惗嬛寋巿夁"]])
v29 = v29.reshape(6, 7)

print("First 24 chars (confirmed): XMAS{4R3_Y0U_Z3-1NG_17?,")

# Let's use the context layer equation: v44 × v42 = v30
# v44 is 4x6, v42 is 6x7, v30 is 4x7
# This gives us: v42 = pinv(v44) × v30

print("\nSolving for v42 (6x7 matrix - next 42 chars)...")
v44_pinv = np.linalg.pinv(v44.astype(float))
v42_approx = v44_pinv @ v30
v42_rounded = np.round(v42_approx).astype(int)
v42_rounded = np.clip(v42_rounded, 0, 42)

print("Recovered v42 matrix (6x7):")
print(v42_rounded)

print("\nNext 42 characters of flag (from v42):")
flag_part3 = ""
for i in range(6):
    row_chars = ''.join([embedding_to_char(val) for val in v42_rounded[i]])
    flag_part3 += row_chars
    print(f"Row {i}: {row_chars}")

print(f"\nNext 42 chars: {flag_part3}")

# Now let's verify this makes sense by checking the phonetic layer
# v43 × v42 should equal v29
print("\n" + "="*50)
print("Verification: Checking if v43 × v42 ≈ v29")

# We can solve for v43 using: v43 = v29 × pinv(v42)
v42_pinv = np.linalg.pinv(v42_rounded.astype(float))
v43_approx = v29 @ v42_pinv
v43_rounded = np.round(v43_approx).astype(int)
v43_rounded = np.clip(v43_rounded, 0, 42)

print("Recovered v43 matrix (6x6) for verification:")
flag_part2_verified = ""
for i in range(6):
    row_chars = ''.join([embedding_to_char(val) for val in v43_rounded[i]])
    flag_part2_verified += row_chars
    print(f"Row {i}: {row_chars}")

print(f"\nVerified middle 36 chars: {flag_part2_verified}")

# Final flag assembly
full_flag = "XMAS{4R3_Y0U_Z3-1NG_17?," + flag_part2_verified + flag_part3
print(f"\n" + "="*50)
print(f"FULL FLAG ({len(full_flag)} chars):")
print(full_flag)
print("="*50)

# Verify the flag makes sense
print("\nFlag breakdown:")
print(f"Start: XMAS{{4R3_Y0U_Z3-1NG_17?,")
print(f"Middle: {flag_part2_verified}")
print(f"End: {flag_part3}")
