#include <iostream>
#include <string>
#include <vector>
#include <random>
#include <cmath>
#include <iomanip>
#include <sstream>

int main() {
    // Initialize random number generation
    std::random_device rd;
    std::mt19937 gen(rd());
    std::uniform_int_distribution<int> dist(0, 0xFF);

    // Get input from user
    std::string input;
    std::cin >> input;

    if (input.length() < 4) {
        std::cout << "Input is too short!" << std::endl;
        return 0;
    }

    // Calculate matrix dimensions
    std::vector<int> inputVector(input.begin(), input.end());
    int matrixSize = static_cast<int>(ceil(sqrt(inputVector.size())));
    int totalSize = matrixSize * matrixSize;

    // Pad the input vector to fit square matrix
    inputVector.resize(totalSize, dist(gen));

    // Create initial matrix
    std::vector<std::vector<int>> matrix(matrixSize, std::vector<int>(matrixSize, 0));

    // Fill matrix in spiral pattern
    int row = 0, col = 0;
    int direction = 0; // 0: right, 1: down, 2: left, 3: up
    
    for (int i = 0; i < totalSize; i++) {
        matrix[row][col] = inputVector[i];
        
        // Determine next position
        bool canMove = false;
        if (direction == 0 && col + 1 < matrixSize && matrix[row][col + 1] == 0) canMove = true;
        else if (direction == 1 && row + 1 < matrixSize && matrix[row + 1][col] == 0) canMove = true;
        else if (direction == 2 && col > 0 && matrix[row][col - 1] == 0) canMove = true;
        else if (direction == 3 && row > 0 && matrix[row - 1][col] == 0) canMove = true;

        if (!canMove) {
            direction = (direction + 1) % 4;
        }

        // Move to next position
        switch (direction) {
            case 0: col++; break;  // right
            case 1: row++; break;  // down
            case 2: col--; break;  // left
            case 3: row--; break;  // up
        }
    }

    // Create position matrix with pairs of indices
    std::vector<std::vector<std::pair<int, int>>> positions(matrixSize, 
        std::vector<std::pair<int, int>>(matrixSize));
    
    // Initialize positions
    for (int i = 0; i < matrixSize; i++) {
        for (int j = 0; j < matrixSize; j++) {
            positions[i][j] = std::make_pair(i, j);
        }
    }

    // Shuffle positions
    for (int i = 0; i < totalSize; i++) {
        int r1 = dist(gen) % matrixSize;
        int c1 = dist(gen) % matrixSize;
        int r2 = i / matrixSize;
        int c2 = i % matrixSize;
        std::swap(positions[r1][c1], positions[r2][c2]);
    }

    // Create result matrix
    std::vector<std::vector<int>> result(matrixSize, std::vector<int>(matrixSize));

    // Fill result matrix using positions
    for (int i = 0; i < matrixSize; i++) {
        for (int j = 0; j < matrixSize; j++) {
            int srcRow = positions[i][j].first;
            int srcCol = positions[i][j].second;
            result[i][j] = matrix[srcRow][srcCol] * 8;
        }
    }

    // Format output
    std::stringstream output;
    for (int i = 0; i < matrixSize; i++) {
        for (int j = 0; j < matrixSize; j++) {
            if (i != 0 || j != 0) {
                output << "-";
            }
            output << std::setfill('0') << std::setw(2) << std::hex 
                   << positions[i][j].first;
            output << std::setfill('0') << std::setw(2) << std::hex 
                   << positions[i][j].second;
            output << std::setfill('0') << std::setw(4) << std::hex 
                   << result[i][j];
        }
    }

    std::cout << output.str() << std::endl;
    return 0;
}