#include <stdio.h>
#include <string.h>
#include <stdbool.h>

bool check(const char* str) {
    int len = strlen(str);
    for (int i = 0; i < len/2; i++) {
        if (str[i] != str[len-1-i]) {
            return false;
        }
    }
    return true;
}

int main() {
    char input[100];
    scanf("%s", input);
    int len = strlen(input);
    bool valid = true;

    valid = valid && check(input);
    valid = valid && (len == 0x15);
    valid = valid && (len > 0x14 && 
                     input[0] == 'a' && 
                     input[2] == 'a' && 
                     input[4] == 'a' && 
                     input[7] == 'a' && 
                     input[9] == 'a');
    valid = valid && (len > 3 && input[1] == input[3] - 1);
    valid = valid && (len > 0x13 && input[19] == 'm');
    valid = valid && (len > 0xf && input[15] == 'p');
    valid = valid && (len > 6 && input[6] == input[5] - 4);
    valid = valid && (len > 0x11 && input[8] == input[17]);
    valid = valid && (len > 0xa && input[10] == 'c');

    if (valid) {
        printf("%s\n", input);
    } else {
        puts("Wrong!");
    }

    return 0;
}
