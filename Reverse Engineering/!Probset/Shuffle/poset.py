import random

def find_essential_pairs(input_string):
    """
    Find the minimal set of character pair relationships that can reconstruct
    the original string order using transitive closure.
    
    For example, if we have a < b < c < d, we only need the pairs (a,b), (b,c), (c,d)
    rather than all possible pairs like (a,c), (a,d), (b,d).
    """
    # First, get the distinct characters in their original order
    char_order = []
    for char in input_string:
        if char not in char_order:
            char_order.append(char)
    
    # The essential pairs are just adjacent characters in the order
    essential_pairs = []
    for i in range(len(char_order) - 1):
        essential_pairs.append((char_order[i], char_order[i + 1]))
    
    return essential_pairs

def analyze_character_relationships(input_string):
    """
    Analyze positional relationships between characters in a string.
    Returns a list of conditions describing which characters appear before others.
    """
    results = []
    
    # Create a dictionary to store the first position of each unique character
    first = {}
    last = {}
    for index, char in enumerate(input_string):
        if char not in first:
            first[char] = index
        last[char] = index
    
    # Compare positions of each unique character pair
    unique_chars = list(first.keys())
    for i in range(len(unique_chars)):
        for j in range(i + 1, len(unique_chars)):
            char1 = unique_chars[i]
            char2 = unique_chars[j]
            pos1 = last[char1]
            pos2 = first[char2]
            
            if pos1 < pos2:
                results.append(f"'{char1}' comes before '{char2}'")
            else:
                results.append(f"'{char2}' comes before '{char1}'")
    
    return results

# generate
chars = ["q","w","e","r","t","y","u","i","o","p","a","s","d","f","g","h","j","k","l","z","x","c","v","b","n","m","1","2","3","4","5","6","7","8","9","0"]
flag = "{"
while len(chars) > 0:
    c = random.choice(chars)
    chars.remove(c)
    flag += c
flag += "}"
print(flag)

# Get the first 10 conditions as a demonstration
relationships = analyze_character_relationships(flag)
for i in range(len(relationships)):
    print(relationships[i])

# # Function to check specific character relationships
# def check_specific_relationships(input_string, char_pairs):
#     """
#     Check if specific character relationships exist in the string
#     char_pairs is a list of tuples where first char should come before second char
#     """
#     results = []
    
#     for first_char, second_char in char_pairs:
#         if first_char in input_string and second_char in input_string:
#             first_pos = input_string.find(first_char)
#             second_pos = input_string.find(second_char)
            
#             if first_pos < second_pos:
#                 results.append(f"✓ '{first_char}' comes before '{second_char}' as expected")
#             else:
#                 results.append(f"✗ '{first_char}' does NOT come before '{second_char}'")
#         else:
#             results.append(f"! Cannot compare '{first_char}' and '{second_char}' - one or both not in string")
    
#     return results

# # Check some specific relationships
# specific_checks = [
#     ('?', 'r'),
#     ('{', '}'),
#     ('b', 'u'),
#     ('m', 'n'),
#     ('1', '4'),
#     ('h', '3')
# ]

# specific_results = check_specific_relationships(flag, specific_checks)
# for result in specific_results:
#     print(result)
