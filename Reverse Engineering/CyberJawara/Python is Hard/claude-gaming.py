import random
import string
from typing import List, Tuple
import time

def check_flag(inp: str) -> Tuple[bool, int]:
    if len(inp) != 36:
        return False, 0
        
    # Initialize arrays
    a = []
    b = []
    c = []
    
    # Process 4 bytes at a time
    for i in range(0, 36, 4):
        tmp = 0
        for j in range(4):
            try:
                tmp |= (ord(inp[i + j]) << (j * 8))
            except IndexError:
                break
        a.append(tmp)
    
    # Process 2 bytes at a time
    for i in range(0, 36, 2):
        tmp = 0
        for j in range(2):
            try:
                tmp |= (ord(inp[i + j]) << (j * 8))
            except IndexError:
                break
        b.append(tmp)
    
    # Process 1 byte at a time
    for i in range(36):
        try:
            c.append(ord(inp[i]))
        except IndexError:
            break
    
    # All validation checks
    checks = [
        a[3] + (b[5] + b[15]) ^ (c[12] + c[5] - c[28]) ^ c[19] ^ 1337,
        a[8] ^ (b[16] ^ b[7]) ^ (c[2] + c[33] + c[22] + c[8] - 1337),
        a[2] + (b[10] + b[2]) ^ (c[3] + c[20]) ^ (c[7] - c[25] + 1337),
        a[5] + (b[14] - b[13] + c[10]) ^ (c[11] - c[29]) ^ (c[13] + 1337),
        a[4] + (b[4] - b[17] + c[1]) ^ (c[16] - c[27] - c[26]) ^ 1337,
        a[1] + (b[6] - b[12] + c[18]) ^ (c[4] - c[17]) ^ c[23] ^ 1337,
        a[0] ^ (b[0] ^ (b[1] - c[9])) ^ (c[21] - c[30] + c[32] + 1337),
        a[6] + (b[8] - b[9] - c[31] - c[14] - c[6] - c[35] - 1337),
        a[7] + (b[3] - b[11] - c[15] + c[0] - c[24] - c[34] - 1337)
    ]
    targets = [
        1634073638,
        -892560024,
        1767917691,
        1948741702,
        1767849594,
        1769100975,
        1635149008,
        1601459038,
        809005425
    ]
    
    return all(checks), sum(abs(targets[i] - checks[i]) for i in range(len(checks)))

class GeneticSolver:
    def __init__(self, population_size=1000, elite_size=50, mutation_rate=0.3):
        self.population_size = population_size
        self.elite_size = elite_size
        self.mutation_rate = mutation_rate
        self.generation = 0
        self.best_fitness = 999999999999999999999999999
        self.best_solution = None
        self.stagnation_counter = 0
        self.charset = string.printable[:-6]  # printable ASCII without whitespace
        
    def create_individual(self) -> str:
        return ''.join(random.choice(self.charset) for _ in range(36))
    
    def initialize_population(self) -> List[str]:
        return [self.create_individual() for _ in range(self.population_size)]
    
    def fitness(self, individual: str) -> Tuple[int, int]:
        success, num_checks = check_flag(individual)
        # Return tuple of (number of passed checks, character score)
        char_score = sum(1 for c in individual if c in string.ascii_letters or c in string.digits)
        return num_checks, char_score
    
    def select_parent(self, ranked_population: List[Tuple[str, Tuple[int, int]]]) -> str:
        # Tournament selection
        tournament_size = 5
        tournament = random.sample(ranked_population, tournament_size)
        return max(tournament, key=lambda x: x[1])[0]
    
    def crossover(self, parent1: str, parent2: str) -> str:
        # Multi-point crossover
        points = sorted(random.sample(range(36), 3))
        child = list(parent1)
        for i in range(0, len(points), 2):
            start = points[i]
            end = points[i + 1] if i + 1 < len(points) else len(parent1)
            child[start:end] = parent2[start:end]
        return ''.join(child)
    
    def mutate(self, individual: str) -> str:
        chars = list(individual)
        for i in range(len(chars)):
            if random.random() < self.mutation_rate:
                # Smart mutation - prefer ASCII letters and numbers
                if random.random() < 0.7:
                    chars[i] = random.choice(string.ascii_letters + string.digits)
                else:
                    chars[i] = random.choice(self.charset)
        return ''.join(chars)
    
    def solve(self, max_generations=1000, target_fitness=0) -> str:
        population = self.initialize_population()
        start_time = time.time()
        
        while self.generation < max_generations:
            self.generation += 1
            
            # Evaluate population
            ranked_population = [(ind, self.fitness(ind)) for ind in population]
            ranked_population.sort(key=lambda x: (x[1][0], x[1][1]), reverse=False)
            
            current_best_fitness = ranked_population[0][1][0]
            current_best = ranked_population[0][0]
            
            # Update best solution
            if current_best_fitness < self.best_fitness:
                self.best_fitness = current_best_fitness
                self.best_solution = current_best
                self.stagnation_counter = 0
                print(f"\nGeneration {self.generation}:")
                print(f"Best fitness: {self.best_fitness}")
                print(f"Best solution: {self.best_solution}")
            else:
                self.stagnation_counter += 1
            
            # Check if solution found
            if current_best_fitness <= target_fitness:
                print(f"\nSolution found in generation {self.generation}!")
                print(f"Time taken: {time.time() - start_time:.2f} seconds")
                return current_best
            
            # Create new population
            new_population = [x[0] for x in ranked_population[:self.elite_size]]
            
            # Breed new individuals
            while len(new_population) < self.population_size:
                parent1 = self.select_parent(ranked_population)
                parent2 = self.select_parent(ranked_population)
                child = self.crossover(parent1, parent2)
                child = self.mutate(child)
                new_population.append(child)
            
            population = new_population
            
            # Adaptive mutation rate based on stagnation
            if self.stagnation_counter > 20:
                self.mutation_rate = min(0.8, self.mutation_rate * 1.2)
            else:
                self.mutation_rate = max(0.1, self.mutation_rate * 0.9)
            
            if self.generation % 10 == 0:
                print(f"Generation {self.generation}, Best fitness: {self.best_fitness}/9")
        
        print("\nMaximum generations reached without finding solution.")
        return self.best_solution

def main():
    print("Starting genetic algorithm solver...")
    solver = GeneticSolver(population_size=1000, elite_size=50, mutation_rate=0.3)
    solution = solver.solve(max_generations=9999999999999999999)
    
    print("\nFinal solution:", solution)
    success, num_checks = check_flag(solution)
    print(f"Passes {num_checks}/9 checks")
    print("Result:", "Success!" if success else "Failed")

if __name__ == "__main__":
    main()
