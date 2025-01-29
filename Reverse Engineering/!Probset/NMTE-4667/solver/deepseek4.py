import numpy as np
from itertools import product

def embedding_to_char(value):
    value = int(value)
    if 0 <= value <= 25: return chr(value + 65)
    elif 26 <= value <= 35: return chr(value + 22)
    elif value == 36: return '_'
    elif value == 37: return ','
    elif value == 38: return '?'
    elif value == 39: return '!'
    elif value == 40: return '-'
    elif value == 41: return '{'
    elif value == 42: return '}'
    else: return '?'

def char_to_embedding(char):
    if 'A' <= char <= 'Z': return ord(char) - 65
    elif '0' <= char <= '9': return ord(char) - 22
    elif char == '_': return 36
    elif char == ',': return 37
    elif char == '?': return 38
    elif char == '!': return 39
    elif char == '-': return 40
    elif char == '{': return 41
    elif char == '}': return 42
    else: return -1

# We know the first 5 characters must be "XMAS{"
known_start = "XMAS{"
known_embeddings = [char_to_embedding(c) for c in known_start]

print("Known start:", known_start)
print("Embeddings:", known_embeddings)

# Let's try to recover more by testing what makes sense
# The flag likely continues with readable English

common_patterns = [
    "S0LV1NG", "S0LV1NG_", "S0LV1NG_TH", "D3COD1NG", "D3COD1NG_",
    "UND3RST4ND", "UND3RST4ND_", "M4TR1X", "M4TR1X_", "TR4NSL4T",
    "4R3_Y0U_", "G00D_4T_", "3NJ0Y1NG", "TH1S_CH4"
]

print("\nTrying common CTF flag patterns...")
for pattern in common_patterns:
    test_flag = known_start + pattern
    if len(test_flag) <= 24:  # v44 holds first 24 chars
        print(f"Pattern: {test_flag}")
