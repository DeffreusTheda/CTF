def solve_bengsky(N, M, prices):
    # Convert prices to tuples with original indices to maintain order
    prices_with_index = [(p, i) for i, p in enumerate(prices)]
    
    # Dictionary to store all possible sums for first half
    first_half_sums = {}
    
    # Generate all possible combinations for first half
    mid = N // 2
    for mask in range(1 << mid):
        curr_sum = 0
        combination = []
        for i in range(mid):
            if mask & (1 << i):
                curr_sum += prices_with_index[i][0]
                combination.append(prices_with_index[i])
        first_half_sums[curr_sum] = combination
    
    # Check all combinations of second half
    result = None
    for mask in range(1 << (N - mid)):
        curr_sum = 0
        combination = []
        for i in range(N - mid):
            if mask & (1 << i):
                curr_sum += prices_with_index[i + mid][0]
                combination.append(prices_with_index[i + mid])
        
        # Look for complementary sum in first half
        target = M - curr_sum
        if target in first_half_sums:
            complete_combination = first_half_sums[target] + combination
            # Sort by price
            complete_combination.sort(key=lambda x: x[0])
            result = [price for price, _ in complete_combination]
            break
    
    return result

# Read input
N, M = map(int, input().split())
prices = list(map(int, input().split()))

# Get and print result
result = solve_bengsky(N, M, prices)
print(" ".join(map(str, result)))
