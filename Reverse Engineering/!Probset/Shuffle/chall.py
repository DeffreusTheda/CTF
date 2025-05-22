from collections import defaultdict
import random

def encode(string):
    l = [ord(c) + i // 2 * (1 if i & 1 == 0 else -1) for i, c in enumerate(string)]
    return ''.join(chr(c) for c in l)

def find_essential_pairs_and_graph(input_string):
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
                    # print(f'transitive edge: {char1} < {char2}')
                    graph[char1].discard(char2)
                    break
                    
    # Collect remaining edges as essential pairs
    for char1 in unique_chars:
        for char2 in graph[char1]:
            essential_pairs.append((char1, char2))
    
    return essential_pairs, graph

def topological_sort(graph, nodes):
    """
    Generate a valid topological sort (could be different from original)
    """
    result = []
    in_degree = {node: 0 for node in nodes}
    
    # Calculate in-degrees
    for node in graph:
        for neighbor in graph[node]:
            in_degree[neighbor] = in_degree.get(neighbor, 0) + 1
    
    # Start with nodes having in-degree 0
    queue = [node for node in nodes if in_degree.get(node, 0) == 0]
    random.shuffle(queue)  # Randomize to get different valid sort
    
    while queue:
        current = queue.pop(0)
        result.append(current)
        
        for neighbor in graph.get(current, []):
            in_degree[neighbor] -= 1
            if in_degree[neighbor] == 0:
                queue.append(neighbor)
                
    return result

def find_all_valid_orderings(constraints, nodes, original_ordering):
    """
    Find all valid orderings
    """
    # Build directed graph
    graph = defaultdict(set)
    for a, b in constraints:
        graph[a].add(b)
    
    # Find all valid orderings using backtracking
    def is_valid_next(result, candidate):
        for node in graph:
            if node == candidate:
                continue
            if candidate in graph[node] and node not in result:
                return False
        return True
    
    def backtrack(result, remaining):
        if not remaining:
            return [result.copy()]
            
        all_orderings = []
        for i, node in enumerate(remaining):
            if is_valid_next(result, node):
                result.append(node) 
                all_orderings.extend(backtrack(
                    result, 
                    remaining[:i] + remaining[i+1:]
                ))
                result.pop()
                
        return all_orderings
    
    # Start with nodes that have no prerequisites
    all_orderings = backtrack([], list(nodes))
    result = []
    for ordering in all_orderings:
        sets = []
        for s in ordering:
            for i in range(sum(1 for c in original_ordering if c == s)):
                sets.append(s)
        result.append(sets)
    return result

def find_constraint(constraint_type, all_orderings, original_ordering):
    """
    Find a constraint (position or distance) that keeps only the original_ordering,
    eliminating the most possible orderings from all_orderings.
    
    Args:
        constraint_type (str): 'position' or 'distance'
        all_orderings (list): List of all valid orderings (each a list of elements)
        original_ordering (list): The target ordering to enforce
    
    Returns:
        tuple: (constraint description, number of orderings eliminated)
    """
    n = len(original_ordering)
    
    if constraint_type == "position":
        # Try each element at its position in the original ordering
        max_eliminated = 0  # *** CHANGED: Start with 0 to maximize instead of len(all_orderings) ***
        best_constraint = None
        
        for idx, elem in enumerate(original_ordering):
            # Count how many orderings satisfy "elem at index idx"
            eliminated = sum(1 for ordering in all_orderings if ordering[idx] != elem)
            if eliminated > max_eliminated:  # *** CHANGED: Now > to maximize eliminations ***
                max_eliminated = eliminated
                best_constraint = f"{elem} must be at index {idx}"
        
        return best_constraint, max_eliminated
    
    elif constraint_type == "distance":
        # Try each pair of elements and their distance in the original ordering
        max_eliminated = 0  # *** CHANGED: Start with 0 to maximize instead of len(all_orderings) ***
        best_constraint = None
        
        for i in range(n):
            for j in range(i + 1, n):
                elem1, elem2 = original_ordering[i], original_ordering[j]
                distance = j - i
                # Count how many orderings satisfy "distance between elem1 and elem2 is distance"
                eliminated = 0
                for ordering in all_orderings:
                    try:
                        idx1 = ordering.index(elem1)
                        idx2 = ordering.index(elem2)
                        if idx2 - idx1 != distance or idx1 > idx2:
                            eliminated += 1
                    except ValueError:
                        eliminated += 1  # Element not found, consider it eliminated
                
                if eliminated > max_eliminated:  # *** CHANGED: Now > to maximize eliminations ***
                    max_eliminated = eliminated
                    best_constraint = f"Distance between {elem1} and {elem2} must be {distance}"
        
        return best_constraint, max_eliminated
    
    else:
        raise ValueError("Constraint type must be 'position' or 'distance'")

def main(flag):
    print(f'{flag=}')
    flag = encode(flag)
    
    original_ordering = list(flag)
    print(f"Original ordering: {original_ordering}")
    
    # Generate partial ordering constraints (transitive reduction)
    constraints, graph = find_essential_pairs_and_graph(flag)
    
    # Visualize the POSET as an adjacency list
    graph = defaultdict(list)
    for a, b in constraints:
        graph[a].append(b)
    print("\nPOSET structure (adjacency list):")
    for node in graph:
        print(f"{node} → {', '.join(graph[node])}")
    
    nodes = set([x for pair in constraints for x in pair])
    topo_sort = topological_sort(graph, nodes)
    print(f"\nOne possible topological sort: {topo_sort}")
    
    all_orderings = find_all_valid_orderings(constraints, nodes, original_ordering)
    
    # Print a sample of orderings
    print(f"\nFound {len(all_orderings)} possible valid orderings:")
    sample_size = min(5, len(all_orderings))
    for i in range(sample_size):
        print(f"  {i+1}. {all_orderings[i]}")
    if len(all_orderings) > sample_size:
        print(f"  ... and {len(all_orderings) - sample_size} more")
    
    # Check if original ordering is among valid orderings
    original_in_valid = any(ordering == list(original_ordering) for ordering in all_orderings)
    print(f"\nOriginal ordering is among valid orderings: {original_in_valid}")
    
    # Add position constraints to narrow down to original
    # Test with position constraint
    pos_constraint, pos_elim = find_constraint("position", all_orderings, original_ordering)
    print(f"Position constraint: {pos_constraint}, eliminates {pos_elim} orderings")
    # Test with distance constraint
    dist_constraint, dist_elim = find_constraint("distance", all_orderings, original_ordering)
    print(f"Distance constraint: {dist_constraint}, eliminates {dist_elim} orderings")    

    constraints = pos_constraint

    # Filter by position constraints
    def satisfies_position_constraints(ordering, constraints):
        for elem, pos in constraints:
            if ordering.index(elem) != pos:
                return False
        return True
    
    filtered_by_position = [
        ordering for ordering in all_orderings 
        if satisfies_position_constraints(ordering, constraints)
    ]
    
    print(f"After filtering: {len(filtered_by_position)} orderings remain")
    for i, ordering in enumerate(filtered_by_position[:3]):
        print(f"  {i+1}. {ordering}")
    
    # Add distance constraints
    distance_constraints = [
        ("B", "F", 4)  # B and F must be 4 positions apart
    ]
    print(f"\nAdding distance constraints: {distance_constraints}")
    
    # Filter by distance constraints
    def satisfies_distance_constraints(ordering, constraints):
        for a, b, dist in constraints:
            if ordering.index(b) - ordering.index(a) != dist:
                return False
        return True
    
    final_filtered = [
        ordering for ordering in filtered_by_position
        if satisfies_distance_constraints(ordering, distance_constraints)
    ]
    
    print(f"After all constraints: {len(final_filtered)} orderings remain")
    for i, ordering in enumerate(final_filtered):
        print(f"  {i+1}. {ordering}")
    
    # Check if we've narrowed down to the original ordering
    unique_solution = len(final_filtered) == 1 and final_filtered[0] == list(original_ordering)
    print(f"\nSuccessfully identified unique original ordering: {unique_solution}")

# Run the demonstration
if __name__ == "__main__":
    main(input("What's your flag?\n> "))

