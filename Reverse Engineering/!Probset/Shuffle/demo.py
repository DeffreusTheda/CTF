def demonstrate_poset_reconstruction():
    """
    Demonstrate POSET reconstruction with a simple example
    """
    from collections import defaultdict
    import random
    
    # Create a sample original ordering
    original_ordering = ["A", "B", "C", "D", "E", "F"]
    print(f"Original ordering: {original_ordering}")
    
    # Generate partial ordering constraints (transitive reduction)
    constraints = [
        ("A", "C"), ("A", "D"), 
        ("B", "D"), ("B", "E"),
        ("C", "F"), ("D", "F")
    ]
    print(f"Partial ordering constraints: {constraints}")
    
    # Visualize the POSET as an adjacency list
    graph = defaultdict(list)
    for a, b in constraints:
        graph[a].append(b)
    
    print("\nPOSET structure (adjacency list):")
    for node in graph:
        print(f"{node} → {', '.join(graph[node])}")
    
    # Generate a valid topological sort (could be different from original)
    def topological_sort(graph, nodes):
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
    
    nodes = set([x for pair in constraints for x in pair])
    topo_sort = topological_sort(graph, nodes)
    print(f"\nOne possible topological sort: {topo_sort}")
    
    # Find all valid orderings
    def find_all_valid_orderings(constraints, nodes):
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
        return backtrack([], list(nodes))
    
    all_orderings = find_all_valid_orderings(constraints, nodes)
    print(f"\nFound {len(all_orderings)} possible valid orderings:")
    
    # Print a sample of orderings
    sample_size = min(5, len(all_orderings))
    for i in range(sample_size):
        print(f"  {i+1}. {all_orderings[i]}")
    
    if len(all_orderings) > sample_size:
        print(f"  ... and {len(all_orderings) - sample_size} more")
    
    # Check if original ordering is among valid orderings
    original_in_valid = any(ordering == list(original_ordering) for ordering in all_orderings)
    print(f"\nOriginal ordering is among valid orderings: {original_in_valid}")
    
    # Add position constraints to narrow down to original
    position_constraints = [
        ("A", 0),  # A must be at position 0
        ("E", 4)   # E must be at position 4
    ]
    print(f"\nAdding position constraints: {position_constraints}")
    
    # Filter by position constraints
    def satisfies_position_constraints(ordering, constraints):
        for elem, pos in constraints:
            if ordering.index(elem) != pos:
                return False
        return True
    
    filtered_by_position = [
        ordering for ordering in all_orderings 
        if satisfies_position_constraints(ordering, position_constraints)
    ]
    
    print(f"After position filtering: {len(filtered_by_position)} orderings remain")
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
demonstrate_poset_reconstruction()
