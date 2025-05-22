#include <iostream>
#include <string>
#include <vector>
#include <random>
#include <cmath>
#include <iomanip>
#include <sstream>

class MatrixTransformer {
private:
    std::mt19937 generator;
    std::uniform_int_distribution<int> distribution;
    int matrixSize;
    std::vector<std::vector<int> > originalMatrix;
    std::vector<std::vector<std::pair<int, int> > > positionMatrix;
    std::vector<std::vector<int> > resultMatrix;

    void initializeRandom() {
        std::random_device rd;
        generator = std::mt19937(rd());
        distribution = std::uniform_int_distribution<int>(0, 0xFF);
    }

    void createSpiralMatrix(const std::vector<int>& input) {
        originalMatrix = std::vector<std::vector<int> >(matrixSize, std::vector<int>(matrixSize, 0));
        int row = 0, col = 0;
        int direction = 0;  // 0: right, 1: down, 2: left, 3: up
        
        for (size_t i = 0; i < input.size(); ++i) {
            originalMatrix[row][col] = input[i];
            
            bool needChangeDirection = false;
            switch (direction) {
                case 0:  // right
                    needChangeDirection = (col + 1 >= matrixSize || originalMatrix[row][col + 1] != 0);
                    break;
                case 1:  // down
                    needChangeDirection = (row + 1 >= matrixSize || originalMatrix[row + 1][col] != 0);
                    break;
                case 2:  // left
                    needChangeDirection = (col <= 0 || originalMatrix[row][col - 1] != 0);
                    break;
                case 3:  // up
                    needChangeDirection = (row <= 0 || originalMatrix[row - 1][col] != 0);
                    break;
            }

            if (needChangeDirection) {
                direction = (direction + 1) % 4;
            }

            switch (direction) {
                case 0: col++; break;
                case 1: row++; break;
                case 2: col--; break;
                case 3: row--; break;
            }
        }
    }

    void initializePositions() {
        positionMatrix = std::vector<std::vector<std::pair<int, int> > >(
            matrixSize, std::vector<std::pair<int, int> >(matrixSize));
        
        // Initialize with original positions
        for (int i = 0; i < matrixSize; ++i) {
            for (int j = 0; j < matrixSize; ++j) {
                positionMatrix[i][j] = std::make_pair(i, j);
            }
        }

        // Shuffle positions
        int totalSize = matrixSize * matrixSize;
        for (int i = 0; i < totalSize; ++i) {
            int r1 = distribution(generator) % matrixSize;
            int c1 = distribution(generator) % matrixSize;
            int r2 = i / matrixSize;
            int c2 = i % matrixSize;
            std::swap(positionMatrix[r1][c1], positionMatrix[r2][c2]);
        }
    }

    void transformMatrix() {
        resultMatrix = std::vector<std::vector<int> >(matrixSize, std::vector<int>(matrixSize));
        
        for (int i = 0; i < matrixSize; ++i) {
            for (int j = 0; j < matrixSize; ++j) {
                int srcRow = positionMatrix[i][j].first;
                int srcCol = positionMatrix[i][j].second;
                resultMatrix[i][j] = originalMatrix[srcRow][srcCol] * 8;
            }
        }
    }

public:
    std::string process(const std::string& input) {
        if (input.length() < 4) {
            throw std::runtime_error("Input is too short!");
        }

        // Initialize random number generation
        initializeRandom();

        // Convert input to vector and calculate matrix size
        std::vector<int> inputVector(input.begin(), input.end());
        matrixSize = static_cast<int>(ceil(sqrt(inputVector.size())));
        
        // Pad input vector if needed
        while (inputVector.size() < matrixSize * matrixSize) {
            inputVector.push_back(distribution(generator));
        }

        // Create and transform matrices
        createSpiralMatrix(inputVector);
        initializePositions();
        transformMatrix();

        // Format output
        std::stringstream output;
        output << std::hex << std::setfill('0');

        for (int i = 0; i < matrixSize; ++i) {
            for (int j = 0; j < matrixSize; ++j) {
                if (i != 0 || j != 0) {
                    output << "-";
                }
                output << std::setw(2) << positionMatrix[i][j].first;
                output << std::setw(2) << positionMatrix[i][j].second;
                output << std::setw(4) << resultMatrix[i][j];
            }
        }

        return output.str();
    }
};

int main() {
    std::string input;
    std::cin >> input;

    try {
        MatrixTransformer transformer;
        std::cout << transformer.process(input) << std::endl;
    }
    catch (const std::exception& e) {
        std::cout << e.what() << std::endl;
    }

    return 0;
}
