#include <stdio.h>
#include <string.h>
#include <unistd.h>

#define FLAG_PARTS 5

unsigned char part2[] = { 0x36, 0x0b, 0x07, 0x40, 0x11 };
unsigned char part4[] = { 0x89, 0xe2, 0xfa, 0xf9, 0xff };
unsigned char part5[] = { 0x9a, 0xa2, 0xf5, 0xa1, 0xb8 };
unsigned char part1[] = { 0x2a, 0x31, 0x3d, 0x3c, 0x2b };
unsigned char part3[] = { 0x63, 0x54, 0x7e, 0x79, 0x54 };


unsigned char *flag_parts[] = { part1, part2, part3, part4, part5};
unsigned char keys[] = { 0x7f, 0x70, 0x0b, 0xbd, 0xc5};

void xor_transform(unsigned char *part, unsigned char *output, unsigned char key) {
    for (size_t i = 0; i < 5; i++) {
        output[i] = part[i] ^ key;
    }
}

int compare_strings(const char *str1, const char *str2) {
    return strcmp(str1, str2);
}

int main() {
    char input[26];
    unsigned char decrypted_flag[25];
    size_t total_len = 0;

    printf("Enter the flag and wait: ");

    fgets(input, sizeof(input), stdin);
    input[strcspn(input, "\n")] = 0;

    sleep(9999999);

    size_t offset = 0;
    for (int i = 0; i < FLAG_PARTS; i++) {
        xor_transform(flag_parts[i], decrypted_flag + offset, keys[i]);
        offset += 5;
    }

    char decrypted_flag_str[26];
    sprintf(decrypted_flag_str, "%s", decrypted_flag);
    decrypted_flag_str[25] = '\0';

    if (compare_strings(input, decrypted_flag_str) == 0) {
        printf("Correct.\n");
    } else {
        printf("WRONG!!! Have you considered getting better?\n");
    }

    return 0;
}
