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

def reconstruct_order_from_pairs(pairs):
    """
    Reconstruct the full ordering of characters from essential pairs using topological sort.
    This verifies that our essential pairs are sufficient.
    """
    # Build a graph representation
    graph = {}
    all_chars = set()
    
    for first, second in pairs:
        all_chars.add(first)
        all_chars.add(second)
        if first not in graph:
            graph[first] = []
        graph[first].append(second)
    
    # Make sure all characters are in the graph
    for char in all_chars:
        if char not in graph:
            graph[char] = []
    
    # Compute in-degree for each character
    in_degree = {char: 0 for char in all_chars}
    for char in graph:
        for neighbor in graph[char]:
            in_degree[neighbor] += 1
    
    # Perform topological sort
    queue = [char for char in in_degree if in_degree[char] == 0]
    result = []
    
    while queue:
        current = queue.pop(0)
        result.append(current)
        
        for neighbor in graph.get(current, []):
            in_degree[neighbor] -= 1
            if in_degree[neighbor] == 0:
                queue.append(neighbor)
    
    # If we couldn't order all characters, there's a cycle
    if len(result) != len(all_chars):
        return "Error: Circular dependencies detected"
    
    return result

def verify_reconstruction(original_string, reconstructed_order):
    """
    Verify that our reconstructed order matches the original string's order.
    """
    # Get the original order of first occurrences
    original_order = []
    for char in original_string:
        if char not in original_order:
            original_order.append(char)
    
    return original_order == reconstructed_order

# Example usage
chars = ["q","w","e","r","t","y","u","i","o","p","a","s","d","f","g","h","j","k","l","z","x","c","v","b","n","m","1","2","3","4","5","6","7","8","9","0"]
flag = "{"
while len(chars) > 0:
    c = random.choice(chars)
    chars.remove(c)
    flag += c
flag += "}"
print(flag)
input_string = flag


# Find the essential pairs
essential_pairs = find_essential_pairs(input_string)

# Display the essential pairs
print(f"Found {len(essential_pairs)} essential pairs:")
for i, (first, second) in enumerate(essential_pairs, 1):
    print(f"{i}. '{first}' comes before '{second}'")

# Reconstruct the order from these pairs
reconstructed_order = reconstruct_order_from_pairs(essential_pairs)

# Verify our reconstruction
is_valid = verify_reconstruction(input_string, reconstructed_order)
print(f"\nReconstruction successful: {is_valid}")
print(f"Reconstructed order: {''.join(reconstructed_order)}")

# Compare with all possible pairs (n²) vs essential pairs (n-1)
all_chars = list(set(input_string))
total_possible_pairs = len(all_chars) * (len(all_chars) - 1) // 2
print(f"\nReduction analysis:")
print(f"Characters in string: {len(all_chars)}")
print(f"All possible pairs: {total_possible_pairs}")
print(f"Essential pairs needed: {len(essential_pairs)}")
print(f"Reduction ratio: {len(essential_pairs) / total_possible_pairs:.2%}")
