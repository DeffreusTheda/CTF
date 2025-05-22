#include <iostream>
#include <string>
#include <iterator>
#include <vector>

int main() {
    std::cout << "What's the flag? ";
    std::string input;
    std::cin >> input;
    auto it1 = std::find_if(input.begin(), input.end(),[](char c) { return c == 123; });
    auto it2 = std::find_if(input.begin(), input.end(),[](char c) { return c == 125; });

    auto index1 = std::distance(input.begin(), it1);
    auto index2 = std::distance(input.begin(), it2);

    char selected_char = input[index1];

    if (input.find(selected_char) == std::string::npos || input.find(input[index2]) == std::string::npos) {
        std::cout << "Invalid flag!" << std::endl;
        return 1;
    }
}