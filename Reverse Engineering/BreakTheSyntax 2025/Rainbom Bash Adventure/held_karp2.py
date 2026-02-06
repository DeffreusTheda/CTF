import numpy as np
import time
from itertools import combinations

def held_karp(distance_matrix):
    """
    Implementation of Held-Karp algorithm for solving TSP
    Returns optimal cost and path
    """
    n = len(distance_matrix)
    
    # Maps each subset of the nodes to the cost to reach that subset, as well
    # as what node it came from
    # State is represented as a bitmask, with bit 1 = visited, 0 = unvisited
    C = {}
    
    # Set initial values: Cost from start node to itself is 0
    for k in range(1, n):
        C[(1 << k, k)] = (distance_matrix[0][k], 0)
    
    # Iterate subsets of increasing size and store intermediate results
    # Subset with size s ranges from range [0..n-1]
    for subset_size in range(2, n):
        print(f"Processing subsets of size {subset_size}/{n-1}...")
        for subset in combinations(range(1, n), subset_size):
            # Set bits for all nodes in this subset
            bits = 0
            for bit in subset:
                bits |= 1 << bit
            
            # Find the lowest cost to get to this subset
            for k in subset:
                prev = bits & ~(1 << k)
                
                res = []
                for m in subset:
                    if m == k:
                        continue
                    if (prev, m) in C:
                        res.append((C[(prev, m)][0] + distance_matrix[m][k], m))
                if res:
                    C[(bits, k)] = min(res)
    
    # Calculate optimal cost from the last subset back to origin
    bits = (2**n - 1) - 1  # all nodes except 0
    res = []
    for k in range(1, n):
        if (bits, k) in C:  # Check if we have a solution for this subset ending at k
            res.append((C[(bits, k)][0] + distance_matrix[k][0], k))
    
    # Return optimal cost and reconstruct the path
    if not res:
        print("No valid tour found. This usually happens with disconnected graphs.")
        return None, []
        
    opt, parent = min(res)
    
    # Reconstruct the path
    path = [0]
    bits = (2**n - 1) - 1
    
    for i in range(n - 1):
        path.append(parent)
        new_bits = bits & ~(1 << parent)
        if (bits, parent) not in C:
            print(f"Error reconstructing path at step {i+1}")
            return opt, path  # Return partial path
        _, parent = C[(bits, parent)]
        bits = new_bits
    
    # Add the starting city at the end to complete the cycle
    path.append(0)
    
    return opt, path

def optimize_large_tsp(distance_matrix, time_limit=60, chunk_size=None):
    """
    For larger problems (n > 15), uses held-karp with a time limit and
    falls back to a 2-opt local search heuristic if time limit is exceeded
    """
    n = len(distance_matrix)
    
    # Make a copy of the distance matrix to ensure it's a numpy array
    distance_matrix = np.array(distance_matrix)
    
    # Check if the matrix is valid (has zeros on diagonal)
    for i in range(n):
        if distance_matrix[i, i] != 0:
            print(f"Warning: Distance to self at position [{i},{i}] is not zero: {distance_matrix[i,i]}")
            distance_matrix[i, i] = 0  # Fix it automatically
    
    # For smaller problems, just use Held-Karp
    if n <= 15:
        print(f"Using exact Held-Karp algorithm for {n}x{n} matrix...")
        return held_karp(distance_matrix)
    
    # For larger problems, we'll use held-karp with a time limit
    print(f"Attempting exact solution with time limit of {time_limit} seconds...")
    start_time = time.time()
    
    try:
        # Set a reasonable timeout for Held-Karp
        result = held_karp(distance_matrix)
        if time.time() - start_time <= time_limit:
            return result
        else:
            print("Time limit exceeded for exact solution.")
    except Exception as e:
        print(f"Held-Karp encountered an error: {e}")

    # If we get here, either timeout occurred or there was an error
    print("Falling back to nearest neighbor + 2-opt heuristic")
    
    # Nearest neighbor heuristic for initial tour
    path = [0]
    unvisited = set(range(1, n))
    
    while unvisited:
        last = path[-1]
        next_city = min(unvisited, key=lambda city: distance_matrix[last][city])
        path.append(next_city)
        unvisited.remove(next_city)
    
    # Add return to origin
    path.append(0)
    
    # Calculate initial cost
    cost = sum(distance_matrix[path[i]][path[i+1]] for i in range(n))
    
    print(f"Initial heuristic tour cost: {cost}")
    
    # 2-opt local search improvement
    improved = True
    iteration = 0
    while improved and (time.time() - start_time <= time_limit):
        iteration += 1
        improved = False
        if chunk_size is None:
            chunk_size = max(1, n // 10)
        
        for i in range(1, n - chunk_size):
            for j in range(i + chunk_size, n):
                # Calculate current cost of segments
                current_cost = distance_matrix[path[i-1]][path[i]] + distance_matrix[path[j]][path[j+1]]
                
                # Calculate cost if we reverse the segment [i,j]
                new_cost = distance_matrix[path[i-1]][path[j]] + distance_matrix[path[i]][path[j+1]]
                
                if new_cost < current_cost:
                    # Reverse the segment
                    path[i:j+1] = reversed(path[i:j+1])
                    improved = True
                    # Update cost
                    cost = sum(distance_matrix[path[i]][path[i+1]] for i in range(n))
                    print(f"Improved tour cost (iteration {iteration}): {cost}")
                    break
            if improved:
                break
    
    # Calculate final cost
    cost = sum(distance_matrix[path[i]][path[i+1]] for i in range(n))
    
    return cost, path

def run_tsp_solver(matrix_file=None, random=False, size=20, seed=42, time_limit=120, custom_matrix=None):
    """
    Main function to solve the TSP problem
    - Can read a matrix from file, use a provided custom matrix, or generate a random one
    - Returns the optimal tour and its cost
    """
    if custom_matrix is not None:
        # Use the provided custom matrix directly
        dist_matrix = np.array(custom_matrix, dtype=float)
        print(f"Using provided custom matrix of shape {dist_matrix.shape}")
    elif random:
        # Generate a random distance matrix for testing
        np.random.seed(seed)
        dist_matrix = np.random.randint(10000000, 99999999, size=(size, size)).astype(float)
        # Set diagonal to 0 (distance to self is 0)
        np.fill_diagonal(dist_matrix, 0)
        print(f"Generated random {size}x{size} matrix with 8-digit weights")
    elif matrix_file:
        # Load matrix from file
        try:
            print(f"Loading matrix from file: {matrix_file}")
            dist_matrix = np.loadtxt(matrix_file, delimiter=',', dtype=float)
            print(f"Successfully loaded matrix of shape {dist_matrix.shape}")
        except Exception as e:
            print(f"Error loading matrix file: {e}")
            print("Trying alternative loading method...")
            try:
                # Try a different approach with manual parsing
                with open(matrix_file, 'r') as f:
                    lines = f.readlines()
                
                # Create matrix from parsed lines
                rows = []
                for line in lines:
                    # Remove whitespace and split by comma
                    values = [float(v.strip()) for v in line.strip().split(',')]
                    rows.append(values)
                
                dist_matrix = np.array(rows, dtype=float)
                print(f"Alternative loading successful, matrix shape: {dist_matrix.shape}")
            except Exception as e2:
                print(f"Alternative loading also failed: {e2}")
                return None, None
    else:
        print("Please provide a matrix file, a custom matrix, or set random=True")
        return None, None
    
    # Ensure the matrix is square
    if dist_matrix.shape[0] != dist_matrix.shape[1]:
        print(f"Error: Distance matrix must be square, but got {dist_matrix.shape}")
        return None, None
    
    # Check matrix size
    n = dist_matrix.shape[0]
    print(f"Solving TSP for {n}x{n} matrix...")
    
    # Debug: Print the first few rows and columns
    print("\nMatrix preview (top-left corner):")
    preview_size = min(5, n)
    for i in range(preview_size):
        print("[", end=" ")
        for j in range(preview_size):
            print(f"{dist_matrix[i][j]:.0f}", end=" ")
            if j < preview_size - 1:
                print(",", end=" ")
        print("]")
    
    start_time = time.time()
    
    # If n is large, use the optimized approach with time limit
    if n > 15:
        opt_distance, opt_path = optimize_large_tsp(dist_matrix, time_limit)
    else:
        opt_distance, opt_path = held_karp(dist_matrix)
    
    end_time = time.time()
    
    print(f"\nComputation time: {end_time - start_time:.2f} seconds")
    
    if opt_distance is None:
        print("No solution found!")
        return None, None
        
    print(f"Optimal tour cost: {opt_distance}")
    print(f"Optimal tour: {opt_path}")
    
    return opt_distance, opt_path

# Example usage
if __name__ == "__main__":
    # For a 20x20 matrix with 8-digit weights
    
    # OPTION 1: Create and use a random matrix
    np.random.seed(42)  # For reproducibility
    size = 20
    dist_matrix = np.random.randint(10000000, 99999999, size=(size, size))
    np.fill_diagonal(dist_matrix, 0)  # Set diagonal to 0
    np.savetxt("tsp_20x20_matrix.csv", dist_matrix, delimiter=',', fmt='%d')
    
    # Solve the TSP with random matrix
    # opt_distance, opt_path = run_tsp_solver(random=True, size=size, time_limit=300)
    
    # OPTION 2: Use your own matrix from a file
    # opt_distance, opt_path = run_tsp_solver(matrix_file="your_matrix.csv", time_limit=300)
    
    # OPTION 3: Use your own matrix directly
    # Example 3x3 matrix for demonstration
    my_matrix = [
    	[0,27207933,29257191,30767375,33358061,31710853,18267351,28646422,25181575,32668955,31721351,31311914,17436287,31231519,27398390,26665226,33405147,29479064,28859609,32875400],
    	[27207933,0,18723267,27461140,27706598,17153389,26073565,31907885,30552119,31028215,32910477,33323884,31917434,32961668,32744601,32930203,33402104,29926349,26989354,28354374],
    	[29257191,18723267,0,26971581,30094007,26800381,25822626,31797481,30354002,29221683,26252638,25958512,30021148,26305193,32130369,17552296,28667078,30263697,27936885,25722954],
    	[30767375,27461140,26971581,0,31156816,30331322,28073673,26204203,18396217,25838588,16791286,26131377,29700497,27798881,33059254,29477864,29721951,29439773,27739929,30777073],
    	[33358061,27706598,30094007,31156816,0,27346875,16937956,32281098,30112898,27364910,30685671,33231675,28723588,31226010,30541690,25856444,31229621,31201226,17392801,27161053],
    	[31710853,17153389,26800381,30331322,27346875,0,27018180,26738900,28340609,26024216,31493000,17879357,33432247,26366524,28566084,30498671,27754527,30294100,25178897,25771567],
    	[18267351,26073565,25822626,28073673,16937956,27018180,0,25268124,32590760,27138017,32999152,26220279,26204222,27031462,25273715,25443122,28617815,27829458,29730434,29457736],
    	[28646422,31907885,31797481,26204203,32281098,26738900,25268124,0,25545320,33382954,31145177,27664100,32470009,27768727,27949390,27242094,28136501,18433903,31905380,18428695],
    	[25181575,30552119,30354002,18396217,30112898,28340609,32590760,25545320,0,27003713,25437214,31796476,32892705,25571056,29517404,29493907,17863705,30959457,29889268,30146332],
    	[32668955,31028215,29221683,25838588,27364910,26024216,27138017,33382954,27003713,0,18199400,27564338,29696304,17432494,29903977,25517772,27950322,31033257,25934690,27689266],
    	[31721351,32910477,26252638,16791286,30685671,31493000,32999152,31145177,25437214,18199400,0,25876546,31958139,27864810,28321738,32744171,30132076,26162759,30621460,26660593],
    	[31311914,33323884,25958512,26131377,33231675,17879357,26220279,27664100,31796476,27564338,25876546,0,28787506,26446653,18665171,26795144,28330910,27423379,31975694,29184736],
    	[17436287,31917434,30021148,29700497,28723588,33432247,26204222,32470009,32892705,29696304,31958139,28787506,0,30143172,25912069,18840703,26932680,31591461,25437981,31899333],
    	[31231519,32961668,26305193,27798881,31226010,26366524,27031462,27768727,25571056,17432494,27864810,26446653,30143172,0,31608667,32254626,33332666,28876524,33245767,18585598],
    	[27398390,32744601,32130369,33059254,30541690,28566084,25273715,27949390,29517404,29903977,28321738,18665171,25912069,31608667,0,32919698,31369881,17023154,28664099,32553702],
    	[26665226,32930203,17552296,29477864,25856444,30498671,25443122,27242094,29493907,25517772,32744171,26795144,18840703,32254626,32919698,0,32324337,31222350,27812923,28001748],
    	[33405147,33402104,28667078,29721951,31229621,27754527,28617815,28136501,17863705,27950322,30132076,28330910,26932680,33332666,31369881,32324337,0,26022470,18709664,29315967],
    	[29479064,29926349,30263697,29439773,31201226,30294100,27829458,18433903,30959457,31033257,26162759,27423379,31591461,28876524,17023154,31222350,26022470,0,29138946,27237135],
    	[28859609,26989354,27936885,27739929,17392801,25178897,29730434,31905380,29889268,25934690,30621460,31975694,25437981,33245767,28664099,27812923,18709664,29138946,0,30105348],
    	[32875400,28354374,25722954,30777073,27161053,25771567,29457736,18428695,30146332,27689266,26660593,29184736,31899333,18585598,32553702,28001748,29315967,27237135,30105348,0]
    ]
    opt_distance, opt_path = run_tsp_solver(custom_matrix=my_matrix, time_limit=3600)
    
    if opt_path:
        print("\nVerification:")
        # Verify the solution by calculating the total distance manually
        total = 0
        for i in range(len(opt_path)-1):
            total += dist_matrix[opt_path[i]][opt_path[i+1]]
        print(f"Calculated tour cost: {total}")
        print(f"Reported tour cost: {opt_distance}")
        if abs(total - opt_distance) < 1e-6:
            print("Solution verified ✓")
        else:
            print("Solution verification failed!")
