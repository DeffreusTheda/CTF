#include <stdio.h>
#include <string.h>
#include <stdint.h>
#include <stdlib.h>

void encrypt(uint8_t *p_input, size_t input_len, uint64_t* key, size_t key_len) {
    if (input_len == 0) {
        *p_input = 0;
        return;
    }

    uint8_t step = 0x35;
    uint8_t tmp = 0;
    uint8_t *key_bytes = (uint8_t*)&key;

    // First pass: forward encryption
    for (size_t i = 0; i < input_len; i++) {
        tmp = tmp ^ (key_bytes[i % key_len] ^ p_input[i]) * 0x79;
        p_input[i] = tmp + step;
        step += 0x35;
    }

    // Second pass: backward transformation
    tmp = p_input[input_len - 1] - (input_len >> 1);
    for (size_t i = input_len - 1; i > 0; i--) {
        if (i < (input_len >> 1)) {
            tmp = p_input[input_len - 1];
        }
        p_input[i] ^= tmp;
    }
    p_input[0] ^= tmp;
}

void decrypt(uint8_t *p_input, size_t input_len, uint64_t* key, size_t key_len) {
    if (input_len == 0) {
        *p_input = 0;
        return;
    }

    // First pass: reverse the backward transformation
    uint8_t tmp = p_input[input_len - 1 - (input_len >> 1)];
    p_input[0] ^= tmp;
    for (size_t i = 1; i < input_len; i++) {
        if (i < (input_len >> 1)) {
            tmp = p_input[input_len - 1];
        }
        p_input[i] ^= tmp;
    }

    // Second pass: reverse the forward encryption
    uint8_t step = 0x35;
    tmp = 0;
    uint8_t *key_bytes = (uint8_t*)&key;
    uint8_t *result = (uint8_t*)malloc(input_len);
    memcpy(result, p_input, input_len);

    for (size_t i = 0; i < input_len; i++) {
        uint8_t original_byte = result[i] - step;
        tmp = tmp ^ (key_bytes[i % key_len] ^ p_input[i]) * 0x79;
        p_input[i] = original_byte ^ (tmp * 0x79);
        step += 0x35;
    }

    free(result);
}

// Test function
void test_encryption() {
    const char *test_str = "hii";
    size_t len = strlen(test_str);
    uint8_t *data = (uint8_t*)malloc(len + 1);
    uint8_t *verify = (uint8_t*)malloc(len + 1);
    
    memcpy(data, test_str, len + 1);
    memcpy(verify, test_str, len + 1);

    
    uint64_t key[16] = {0};
    uint64_t rax_value = 0x341240e33a124223;
    memcpy(key, &rax_value, sizeof(rax_value)); // Little-endian representation.
    uint32_t dword_value = 0x0A1002D3;
    memcpy(key + 8, &dword_value, sizeof(dword_value)); // Little-endian representation.

    size_t key_len = 0xc;
    for (size_t i = 0; i < len; i++) {
        printf("%02x ", key[i]);
    }

    printf("Original: %s\n", data);

    // Encrypt
    encrypt(data, len, &key, key_len);
    printf("Encrypted: ");
    for (size_t i = 0; i < len; i++) {
        printf("%02x ", data[i]);
    }
    printf("\n");

    // Decrypt
    decrypt(data, len, &key, key_len);
    printf("Decrypted: %s\n", data);

    // Verify
    if (memcmp(data, verify, len) == 0) {
        printf("Encryption/Decryption test passed!\n");
    } else {
        printf("Test failed!\n");
    }

    free(data);
    free(verify);
}

int main() {
    test_encryption();
    return 0;
}
