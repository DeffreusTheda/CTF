def analyze_complete_character_relationships(input_string):
    """
    Analyze positional relationships between characters in a string
    where each character can occur multiple times.
    
    For characters A and B, we say "A comes before B" only if 
    the LAST occurrence of A comes before the FIRST occurrence of B.
    """
    results = []
    
    # Track first and last positions of each character
    first_positions = {}
    last_positions = {}
    
    for index, char in enumerate(input_string):
        if char not in first_positions:
            first_positions[char] = index
        last_positions[char] = index
    
    # Compare last occurrence of one character with first occurrence of another
    unique_chars = list(first_positions.keys())
    for i in range(len(unique_chars)):
        for j in range(i + 1, len(unique_chars)):
            char1 = unique_chars[i]
            char2 = unique_chars[j]
            
            last_pos_of_char1 = last_positions[char1]
            first_pos_of_char2 = first_positions[char2]
            
            if last_pos_of_char1 < first_pos_of_char2:
                results.append(f"All '{char1}' come before all '{char2}'")
            elif last_positions[char2] < first_positions[char1]:
                results.append(f"All '{char2}' come before all '{char1}'")
            else:
                results.append(f"'{char1}' and '{char2}' have overlapping positions")
    
    return results

def find_essential_pairs_with_overlap(input_string):
    """
    Find the minimal set of character pair relationships for a string
    where characters can appear multiple times.
    
    This creates a directed graph where an edge from A to B exists
    if all occurrences of A come before all occurrences of B.
    """
    # Track first and last positions
    first_positions = {}
    last_positions = {}
    
    for index, char in enumerate(input_string):
        if char not in first_positions:
            first_positions[char] = index
        last_positions[char] = index
    
    # Build a complete directed graph of character relationships
    unique_chars = list(first_positions.keys())
    graph = {char: set() for char in unique_chars}
    
    for char1 in unique_chars:
        for char2 in unique_chars:
            if char1 != char2 and last_positions[char1] < first_positions[char2]:
                graph[char1].add(char2)
    
    # Find transitive reduction of the graph (minimal set of edges)
    essential_pairs = []
    
    for char1 in unique_chars:
        for char2 in graph[char1].copy():
            # Check if there's an indirect path from char1 to char2
            # through another node
            for intermediate in graph[char1]:
                if intermediate != char2 and char2 in graph[intermediate]:
                    # This is a transitive edge, so remove it
                    print(f'transitive edge: {char1} < {char2}')
                    graph[char1].discard(char2)
                    break
                    
    # Collect remaining edges as essential pairs
    for char1 in unique_chars:
        for char2 in graph[char1]:
            essential_pairs.append((char1, char2))
    
    return essential_pairs, graph

def visualize_character_positions(input_string):
    """
    Create a visualization of where each character appears in the string.
    """
    char_positions = {}
    
    for index, char in enumerate(input_string):
        if char not in char_positions:
            char_positions[char] = []
        char_positions[char].append(index)
    
    # Sort by first appearance
    sorted_chars = sorted(char_positions.keys(), key=lambda c: char_positions[c][0])
    
    visualization = []
    for char in sorted_chars:
        positions = char_positions[char]
        line = f"'{char}': " + " " * positions[0] + "*"
        
        for i in range(1, len(positions)):
            spaces = positions[i] - positions[i-1] - 1
            line += " " * spaces + "*"
            
        visualization.append(line)
    
    return visualization

# Example usage
input_string = "{1_am_not_the_g1rl_1_w1sh_that_1_could_be}"

# Analyze character relationships
relationships = analyze_complete_character_relationships(input_string)
essential_pairs, graph = find_essential_pairs_with_overlap(input_string)

print(f'{len(relationships)} relationships')

print(f"{len(essential_pairs)} essential pairs")
for i, (first, second) in enumerate(essential_pairs[:10], 1):
    print(f"{i}. All '{first}' come before all '{second}'")

# Count character frequencies
char_count = {}
for char in input_string:
    char_count[char] = char_count.get(char, 0) + 1

print(f"\nCharacter frequency analysis:")
repeating_chars = [char for char, count in char_count.items() if count > 1]
print(f"Characters that appear multiple times: {', '.join(repeating_chars)}")
print(f"Number of characters with multiple occurrences: {len(repeating_chars)}")
