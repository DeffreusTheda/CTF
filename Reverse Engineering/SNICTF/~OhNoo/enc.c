#include <stdio.h>
#include <string.h>
#include <stdint.h>
#include <stdlib.h>

void encrypt(uint8_t* p_input, size_t input_len, int64_t *the_number, size_t len) {
    if (input_len == 0) {
        *p_input = 0;
        return;
    }

    // Print
    printf("ENC: ");
    for (size_t i = 0; i < input_len; ++i) {
        printf("%c", p_input[i]);
    }
    putchar(10);

    // Push RBX to preserve it
    uint8_t step = 0x35;   // R8D = 0x35
    size_t idx = 0;        // RCX (len) = 0
    uint8_t tmp = 0;       // RSI = 0
    const uint8_t mult = 0x79;  // EBX = 0x79

    // First encryption loop
    do {
        // DIV R9 operation with idx
        size_t rem = idx % len;
        
        // MOVZX from byte ptr [R11 + rdx]
        uint8_t key_byte = ((uint8_t*)the_number)[rem];
        
        // XOR with input and multiply
        tmp = tmp ^ (key_byte ^ p_input[idx]) * mult;
        
        // Store result
        p_input[idx] = tmp + step;
        step += 0x35;
        
        idx++;
    } while (idx != input_len);

    // Print
    // for (size_t i = 0; i < len; ++i) {
        // printf("%d ", p_input[i]);
    // }
    // putchar(10);

    // Second transformation phase
    size_t half_len = input_len >> 1;
    uint8_t xor_byte = p_input[input_len - half_len];
    // printf("%d ", xor_byte);

    // Backward loop
    idx = input_len;
    do {
        idx--;
        if (idx < half_len) {
            xor_byte = p_input[input_len - 1];
        }
        p_input[idx] ^= xor_byte;
    } while (idx != 0);

    // Final XOR of first byte
    xor_byte ^= p_input[0];
    // p_input[0] = xor_byte;
}

void decrypt(uint8_t* p_input, size_t input_len, int64_t *the_number, size_t len, uint8_t mid) {
    if (input_len == 0) {
        *p_input = 0;
        return;
    }

    size_t half_len = input_len >> 1;
    uint8_t xor_byte = p_input[input_len - 1];
    
    // second encryption loop
    size_t idx = 0;
    while (idx != input_len) {
        if (idx == half_len) {
            xor_byte = p_input[input_len - half_len];
        }
        p_input[idx] ^= xor_byte;
        if (idx == half_len) {
            p_input[half_len] = mid;
            xor_byte = p_input[input_len - half_len];
        }
        idx++;
    }

    // first encryption loop
    uint8_t* temp = (uint8_t*)malloc(input_len);
    memcpy(temp, p_input, input_len); // make a copy
    
    uint8_t step = 0x35;
    uint8_t tmp = 0;
    const uint8_t mult = 0x79;
    uint8_t mult_inverse = 0;
    
    // find multiplicative inverse of 0x79 in GF(256)
    for (uint16_t i = 0; i < 256; i++) {
        if ((i * mult) % 256 == 1) {
            mult_inverse = i;
            break;
        }
    }

    for (idx = 0; idx < input_len; idx++) {
        uint8_t encrypted_tmp = temp[idx] - step;
        
        size_t rem = idx % len;
        uint8_t key_byte = ((uint8_t*)the_number)[rem];
        
        // tmp = tmp ^ (key[i] ^ input[i]) * mult
        // (tmp ^ prev_tmp) * mult_inverse = key[i] ^ input[i]
        // input[i] = key[i] ^ ((tmp ^ prev_tmp) * mult_inverse)
        uint8_t next_tmp = encrypted_tmp;
        uint8_t xor_diff = tmp ^ next_tmp;
        p_input[idx] = key_byte ^ (xor_diff * mult_inverse);
        
        tmp = next_tmp;
        step += 0x35;
    }

    free(temp);

    // print
    printf("DEC: ");
    for (size_t i = 0; i < input_len; ++i) {
        printf("%c", p_input[i]);
    }
    putchar(10);
}

// Test function
void test_encryption(void) {
    const char* test_data = "SNIOMG123456_0123456789ABCDEF_SE";
    size_t len = strlen(test_data);
    
    // Allocate and initialize test buffers
    uint8_t* original = (uint8_t*)malloc(len + 1);
    uint8_t* encrypted = (uint8_t*)malloc(len + 1);
    uint8_t* decrypted = (uint8_t*)malloc(len + 1);
    
    memcpy(original, test_data, len + 1);
    memcpy(encrypted, test_data, len + 1);
    
    // Test key and length
    uint8_t key[16] = {0}; // Initialize to zero for cleanliness.

    // Populate the key with data:
    // Step 1: Insert the 8-byte value (RAX: 0x341240e33a124223) at offset 0x4.
    uint64_t rax_value = 0x341240e33a124223;
    memcpy(key, &rax_value, sizeof(rax_value)); // Little-endian representation.

    // Step 2: Insert the 4-byte value (0x0A1002D3) at offset 0xC.
    uint32_t dword_value = 0x0A1002D3;
    memcpy(key + 8, &dword_value, sizeof(dword_value)); // Little-endian representation.

    size_t key_len = 0xc;
    
    // printf("Original text: %s\n", original);
    
    // Encrypt
    encrypt(encrypted, len, &key, key_len);
    // for (uint8_t mid = 0; mid < 255; ++mid) {
        memcpy(decrypted, encrypted, len);
        decrypt(decrypted, len, &key, key_len, 153);
    // }
    
    // printf("Encrypted hex: ");
    // for (size_t i = 0; i < len; i++) {
        // printf("%02x", encrypted[i]);
    // }
    // printf("\n");

    printf("\nOn the real one now...\n\n");

    unsigned char out[] = {0x8f, 0x6c, 0x54, 0x10, 0x3d, 0x16, 0x68, 0x2e, 0x98, 0xca, 0x66, 0xd8, 0xb1, 0xbb, 0x67, 0xa0, 0x00, 0x7d, 0x57, 0xe1, 0x66, 0xd7, 0x19, 0xf1, 0x2f, 0xcd, 0x2c, 0xa1, 0x88, 0x44, 0x54, 0xaa};
    len = 32;
    unsigned char out2[33];
    
    // Decrypt
    // for (uint8_t mid = 0; mid < 255; ++mid) {
        // decrypt(out, len, &key, key_len, mid);
    // }
    // decrypt(out, len, &key, key_len, 255u);
    for (uint8_t mid = 0; mid < 255; ++mid) {
        memcpy(out2, out, len);
        decrypt(out2, len, &key, key_len, mid);
    }
    
    // printf("Decrypted text: %s\n", decrypted);
    
    // Verify
    // if (memcmp(original, decrypted, len) == 0) {
        // printf("SUCCESS: Encryption/Decryption test passed!\n");
    // } else {
        // printf("FAILURE: Decrypted data doesn't match original!\n");
    // }
    
    free(original);
    free(encrypted);
    free(decrypted);
}

int main(void) {
    test_encryption();
    return 0;
}

