def minimal_deduction(f1, f2):
    """Calculate minimal point deduction for formation transition."""
    INSERT, DELETE, SUBSTITUTE = 11, 7, 15
    prev = [j * INSERT for j in range(len(f2) + 1)]
    
    for i in range(1, len(f1) + 1):
        curr = [prev[0] + DELETE]
        for j in range(1, len(f2) + 1):
            if f1[i-1] == f2[j-1]:
                cost = prev[j-1]
            else:
                cost = min(
                    prev[j] + DELETE,
                    curr[j-1] + INSERT,
                    prev[j-1] + SUBSTITUTE
                )
            curr.append(cost)
        prev = curr
    
    return prev[-1]

def solve():
    """Solve deer dance formation transition problem."""
    T = int(input())
    
    # Encode formations to handle color mapping
    color_map, encoded = {}, []
    color_id = 1
    
    for _ in range(T):
        formation = input().split()
        encoded_line = []
        
        for color in formation:
            if color not in color_map:
                color_map[color] = color_id
                color_id += 1
            encoded_line.append(color_map[color])
        
        encoded.append(encoded_line)
    
    # Calculate total minimum deduction points
    total_points = sum(
        minimal_deduction(encoded[i], encoded[i+1]) 
        for i in range(T-1)
    )
    
    print(total_points)

if __name__ == "__main__":
    solve()
