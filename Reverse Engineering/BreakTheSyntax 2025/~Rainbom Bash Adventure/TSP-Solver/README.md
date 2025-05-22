<h1 align='center'> Travelling Salesman Problem Solver </h1>
<img center='align' src='https://miro.medium.com/v2/resize:fit:1400/format:webp/1*rb-su58K8YUM_qPdkTjnaw.png'/>

## Introduction
 The Travelling Salesman Problem (TSP) is a well-known optimization problem in computer science, operations research, and mathematics. The problem involves finding the shortest possible route that visits each node in a given graph exactly once and returns to the starting node. It is a challenging problem, as the number of possible solutions increases exponentially with the number of nodes.

 The TSP has numerous real-world applications, including logistics, transportation planning, and circuit board design. Many algorithms have been developed to solve the TSP, including exact algorithms, heuristic algorithms, and metaheuristic algorithms. The most widely used algorithms for the TSP are the Nearest Neighbor and 2-OPT algorithms, which are both simple to implement and can often provide good solutions in reasonable time.

 This project is a Java implementation of the Travelling Salesman Problem solver, which uses the Nearest Neighbor and 2-OPT algorithms. The aim of this project is to find the shortest possible path that visits each node in a given graph exactly once and returns to the starting node.

## Algorithms
<h3>Nearest Neighbor</h3>
The Nearest Neighbor algorithm is a simple heuristic algorithm for solving the Travelling Salesman Problem. It starts with a random node and then repeatedly selects the nearest unvisited node until all nodes have been visited, forming a tour. Although the Nearest Neighbor algorithm is not guaranteed to find the optimal solution, it can often find a good solution quickly, especially for small to medium-sized instances of the problem.

<h3>2-OPT</h3>
The 2-OPT algorithm is a local search algorithm for solving the Travelling Salesman Problem. It starts with an initial tour and then iteratively improves it by swapping pairs of edges in the tour to create a shorter tour. The name "2-OPT" comes from the fact that it swaps two edges at a time. The algorithm continues swapping edges until no further improvements can be made. The 2-OPT algorithm can be used as a post-processing step to further improve the solution obtained by other algorithms, such as the Nearest Neighbor algorithm.

There can n*(n-3) /2 changes can be made for a route that contains n cities.

After computing the length of those routes, the route should be changed only if there is an improvement. This is the 2-opt in nutshell.

If there is a route as a,b,c,d,a; a possible variation for 2-opt algorithm could be a,c,b,d,e.

2-opt algorithm does not have a polynomial time. It does not guarantee approximate correctness.

But empirically, typically returns the tour with total cost close to the minimum possible.
 
 ### Note
Please change the input file name(fileName variable) in the Main.java file before executing it.

# References

[1] Christian Nilsson “Heuristics for the Traveling Salesman Problem” January 2003

[2] Tim RoughGarden - Tim Roughgarden Lectures “Algorithms for NP-Hard Problems Section 20.4: The 2-OPT Heuristic for the TSP” May 2020

[3][http://on-demand.gputechconf.com/gtc/2014/presentations/S4534-high-speed-2-opt-tsp-solver.pdf](http://on-demand.gputechconf.com/gtc/2014/presentations/S4534-high-speed-2-opt-tsp-solver.pdf)
