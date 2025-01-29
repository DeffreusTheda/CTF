from functools import reduce
import operator
import random
import string

# Define the letter variables
letters = {
    'e': 9,
    'u': 1,
    'y': 1,
    'f': 0.2484519975,
    'o': 1,
    'v': 0.0276057775,
    'g': 4.7702783519,
    'x': 0.0026291216,
    'w': 1/5,
    't': 10,
    'n': 1/9,
    'i': 81,
    'h': 0.0002300481,
    'r': 16.0996894379,
    's': 28.1744565164
}

def find_multiplications(target_x, max_depth=6, tolerance_factor=0.5, find_first_only=False):
    """
    Find all possible multiplications of letter variables that round to target_x.
    Letters can be used multiple times.
    
    Args:
        target_x: The target integer value
        max_depth: Maximum number of letters to multiply (to limit search space)
        tolerance_factor: Tolerance for rounding (default 0.5)
        find_first_only: If True, return immediately after finding first solution
    
    Returns:
        List of tuples (letter_sequence, product, rounded_value)
    """
    results = []
    letter_items = list(letters.items())
    found_first = [False]  # Use list to allow modification in nested function
    
    def search(current_product, current_combo, depth, start_idx):
        """Recursive search allowing letter reuse."""
        # Early exit if we already found one and only need one
        if find_first_only and found_first[0]:
            return
        
        # Check if current product rounds to target
        rounded_val = round(current_product)
        if rounded_val == target_x and len(current_combo) > 0:
            results.append((tuple(current_combo), current_product, rounded_val))
            if find_first_only:
                found_first[0] = True
                return
        
        # Stop if we've reached max depth
        if depth >= max_depth:
            return
        
        # Try adding each letter (including letters we've already used)
        for idx in range(len(letter_items)):
            # Early exit if we already found one and only need one
            if find_first_only and found_first[0]:
                return
                
            letter_name, letter_val = letter_items[idx]
            new_product = current_product * letter_val
            
            # Prune if product is getting too far from target
            # Allow some margin for future multiplications
            if new_product > target_x * 100 or new_product < target_x / 100:
                continue
            
            search(new_product, current_combo + [letter_name], depth + 1, idx)
    
    # Start the search
    search(1.0, [], 0, 0)
    
    # If find_first_only, skip deduplication and return immediately
    if find_first_only and results:
        return [results[0]]
    
    # Remove duplicates (same letters in different order are considered same)
    unique_results = {}
    for combo, product, rounded_val in results:
        # Sort the combo to create a canonical form
        sorted_combo = tuple(sorted(combo))
        if sorted_combo not in unique_results:
            unique_results[sorted_combo] = (combo, product, rounded_val)
    
    return list(unique_results.values())

def format_result(combo, product, rounded_val):
    """Format a result for display."""
    # Count occurrences of each letter
    from collections import Counter
    counts = Counter(combo)
    
    # Format with exponents for repeated letters
    parts = []
    for letter in sorted(set(combo)):
        count = counts[letter]
        if count == 1:
            parts.append(letter)
        else:
            # parts.append(f"{letter}^{count}")
            for i in range(count):
                parts.append(f"{letter}")
    
    random.shuffle(parts)
    letters_str = ''.join(parts)
    # letters_str = '*'.join(parts)
    return f"{letters_str} = {product:.10f} → {rounded_val}"

def verify_example():
    """Verify the given example works."""
    combo = ('t', 'i', 'n', 'g', 'e')
    product = 1.0
    for letter in combo:
        product *= letters[letter]
    print(f"Verification of example: {format_result(combo, product, round(product))}")
    print()

# Example usage
if __name__ == "__main__":
    # Verify the example first
    verify_example()
    
    # Test with various targets
    targets = [3864, 100, 22605, 1, 10, 50, 1000]
    
    for target in targets:
        print(f"Finding multiplications that round to {target}:")
        print("-" * 60)
        
        # First, try to find just one solution quickly
        results = find_multiplications(target, max_depth=8, find_first_only=True)
        
        if results:
            print(f"First solution found:")
            combo, product, rounded_val = results[0]
            print(format_result(combo, product, rounded_val))
            
            # Now find all solutions
            # print(f"\nFinding all solutions...")
            # all_results = find_multiplications(target, max_depth=8, find_first_only=False)
            
            # if len(all_results) > 1:
            #     print(f"Found {len(all_results)} total solution(s):\n")
            #     # Sort by number of letters used, then by product
            #     all_results.sort(key=lambda x: (len(x[0]), abs(x[1] - target)))
                
            #     for combo, product, rounded_val in all_results[:20]:  # Show first 20
            #         print(format_result(combo, product, rounded_val))
                
            #     if len(all_results) > 20:
            #         print(f"\n... and {len(all_results) - 20} more solutions")
        else:
            print(f"No solutions found for {target}")
        
        print("\n" + "=" * 60 + "\n")

    # for target in list(string.printable):
    for target in list('XMAS{G07_M0l3_pr08l3m5?__C4ll_Av094dr0_47_6.02_x_10^23}'):
        # target = int(''.join([hex(ord(x))[2:] for x in input('target: ')]), 16)
        print(target, end='\t')
        target = int(''.join([hex(ord(x))[2:] for x in target]), 16)
        results = find_multiplications(target, find_first_only=True)
        if results:
            # print(f"Found {len(results)} solution(s):\n")
            # Sort by number of letters used
            results.sort(key=lambda x: len(x[0]))
        
            for combo, product, rounded_val in results[:15]:  # Show first 15
                print(format_result(combo, product, rounded_val))
        
            if len(results) > 15:
                print(f"\n... and {len(results) - 15} more solutions")
        else:
            print(f"No solutions found for {target}")
