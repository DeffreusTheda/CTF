import numpy as np

# First, let's decode the embedding mapping
def embedding_to_char(value):
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

def char_to_embedding(char):
    if 'A' <= char <= 'Z':
        return ord(char) - 65
    elif '0' <= char <= '9':
        return ord(char) - 22
    elif char == '_': return 36
    elif char == ',': return 37
    elif char == '?': return 38
    elif char == '!': return 39
    elif char == '-': return 40
    elif char == '{': return 41
    elif char == '}': return 42
    else: return -1

# Extract v41 from grammar matrix (6x7)
# 语法矩阵 characters decoded
grammar_chars = "丙丌两丢丄丣丛丘丢万丅丑並不东丆丅丂丌严上丄並両丑丛丢丑丁丅丐丙上严丒丐並丅丆丑七丐"
grammar_unicode = [ord(c) for c in grammar_chars]
v41_values = [u - 19968 for u in grammar_unicode]
v41 = np.array(v41_values).reshape(6, 7)
print("v41 shape:", v41.shape)
print("v41:\n", v41)

# Extract v28 from tone layer (4x7)  
# 声调层 characters decoded
tone_chars = "厰墙圈圱咦官国堋媈囿喵囁愃坘墓尕孩夘垸搱妑埤廔垵噻夬扠墱"
tone_unicode = [ord(c) for c in tone_chars]
v28_values = [u - 19968 for u in tone_unicode]
v28 = np.array(v28_values).reshape(4, 7)
print("\nv28 shape:", v28.shape)
print("v28:\n", v28)

# We need to solve: v44 (4x6) × v41 (6x7) = v28 (4x7)
# This is underdetermined, but we know the flag starts with "XMAS{"
# Let's use constraints to solve for v44

# Convert "XMAS{" to embedding values
known_start = "XMAS{"
known_embeddings = [char_to_embedding(c) for c in known_start]
print(f"\nKnown start: {known_start} -> {known_embeddings}")

# We'll use least squares with constraints
# Let me try to solve this systematically
print("\nAttempting to solve for v44...")

# Since the system is underdetermined, let's use pseudoinverse
# v44 × v41 = v28  =>  v44 = v28 × pinv(v41)
v41_pinv = np.linalg.pinv(v41)
v44_approx = v28 @ v41_pinv

print("v44 approximate solution shape:", v44_approx.shape)
print("First row of v44 (approximate):", v44_approx[0])

# Round to nearest integer (since embeddings are integers)
v44_rounded = np.round(v44_approx).astype(int)
print("\nRounded v44 first row:", v44_rounded[0])

# Convert first row back to characters
first_row_chars = ''.join([embedding_to_char(val) for val in v44_rounded[0]])
print(f"First row as string: {first_row_chars}")

# Let me check if this makes sense and try to refine
print("\nChecking if 'XMAS{' appears in solution...")

# The first 5 characters should be XMAS{
# Let's force those values and solve for the rest
print("We need to implement constrained solving...")
