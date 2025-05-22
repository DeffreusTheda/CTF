#include "iostream"
#include <string.h>
using namespace std;

int main(int argc, const char** argv, const char** envp) {
    // Initialize strings
    string targetString = "asdghkashdfclkamsdfjalxsdkjfxhcaksvjnalsckuqpoiewt";
    string generatedKey = "";
    string userInput;
    
    // Array with encryption key values
    int keyValues[50];
    memcpy(keyValues, (void*)0x403020, sizeof(keyValues)); // Copying from a memory address
    
    // Welcome message
    cout << "Welcome to the Immersive Cybersecurity Experience." << endl;
    
    // Generate the key
    for (unsigned int i = 0; i <= 0x15D; i += 7) {
        unsigned int j = i;
        while (j >= targetString.length()) {
            j -= targetString.length();
        }
        generatedKey += targetString[j];
        cout << "*";
    }
    cout << endl;
    cout << generatedKey << endl;
    
    // Prompt user for password
    cout << "This is the login form to gain access to the internal interface." << endl << endl;
    cout << "Please enter the password: ";
    
    // Get user input
    getline(cin, userInput);
    
    // Validate input length
    if (userInput.length() <= 50) {
        if (userInput.length() > 49) {
            // Process input with the key
            string processedInput = "";
            
            for (unsigned int k = 0; k < generatedKey.length(); ++k) {
                processedInput += (char)(keyValues[k] ^ userInput[k]);
            }
            
            // Check if processed input matches the generated key
            if (processedInput == generatedKey) {
                cout << "Success!" << endl;
            } else {
                cout << "Incorrect :(" << endl;
            }
            return 0;
        } else {
            cout << "Too short" << endl;
            return 0;
        }
    } else {
        cout << "Too long" << endl;
        return 0;
    }
}
