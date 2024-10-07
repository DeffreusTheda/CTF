#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Global variables
unsigned char DAT_00104060[256];
unsigned char INV_DAT_00104060[256];

// Function prototypes for decryption
void FUN_001013f8(void);
void INV_FUN_00101169(long param_1, unsigned long param_2, unsigned char param_3);
void INV_FUN_001011cd(long param_1, unsigned long param_2, unsigned char param_3);
void INV_FUN_0010124d(long param_1, unsigned long param_2, char param_3, char param_4);
void INV_FUN_001012b8(long param_1, unsigned long param_2);
void INV_FUN_0010130c(void *param_1, unsigned long param_2, int param_3);
void FUN_00101decrypt(void *param_1, size_t param_2, void *param_3, void *param_4);

// Initialize substitution box (same as encryption)
void FUN_001013f8(void) {
    unsigned int seed = 0x3039;
    
    // Initialize S-box with values 0-255
    for (int i = 0; i < 256; i++) {
        DAT_00104060[i] = (unsigned char)i;
    }
    
    // Shuffle S-box
    for (int i = 255; i > 0; i--) {
        seed = (seed * 0x41c64e6d + 0x3039) % 0x7fffffff;
        unsigned int j = seed % (i + 1);
        
        // Swap values
        unsigned char temp = DAT_00104060[i];
        DAT_00104060[i] = DAT_00104060[j];
        DAT_00104060[j] = temp;
    }
}

// Initialize inverse substitution box
void init_inverse_sbox(void) {
    for (int i = 0; i < 256; i++) {
        INV_DAT_00104060[DAT_00104060[i]] = i;
    }
}

// Inverse of byte-wise addition and modulo
void INV_FUN_00101169(long param_1, unsigned long param_2, unsigned char param_3) {
    for (unsigned long i = 0; i < param_2; i++) {
        unsigned char *byte = (unsigned char *)(param_1 + i);
        *byte = (*byte >= i) ? *byte - i : *byte - i + param_3;
    }
}

// Inverse of circular bit shift
void INV_FUN_001011cd(long param_1, unsigned long param_2, unsigned char param_3) {
    for (unsigned long i = 0; i < param_2; i++) {
        unsigned char byte = *(unsigned char *)(param_1 + i);
        *(unsigned char *)(param_1 + i) = (byte >> param_3) | (byte << (8 - param_3));
    }
}

// Inverse of linear transformation
void INV_FUN_0010124d(long param_1, unsigned long param_2, char param_3, char param_4) {
    char inv_param3 = 0;
    for (int i = 1; i < 256; i++) {
        if ((i * param_3) % 256 == 1) {
            inv_param3 = i;
            break;
        }
    }
    
    for (unsigned long i = 0; i < param_2; i++) {
        unsigned char *byte = (unsigned char *)(param_1 + i);
        *byte = ((*byte - param_4 + 256) * inv_param3) % 256;
    }
}

// Inverse of S-box substitution
void INV_FUN_001012b8(long param_1, unsigned long param_2) {
    for (unsigned long i = 0; i < param_2; i++) {
        *(unsigned char *)(param_1 + i) = INV_DAT_00104060[*(unsigned char *)(param_1 + i)];
    }
}

// Inverse of circular buffer shift
void INV_FUN_0010130c(void *param_1, unsigned long param_2, int param_3) {
    unsigned char *buffer = (unsigned char *)param_1;
    unsigned char *temp = malloc(param_2);
    
    for (unsigned long i = 0; i < param_2; i++) {
        temp[i] = buffer[(i + param_3) % param_2];
    }
    
    memcpy(buffer, temp, param_2);
    free(temp);
}

// Main decryption function
void FUN_00101decrypt(void *param_1, size_t param_2, void *param_3, void *param_4) {
    memcpy(param_4, param_1, param_2);
    
    for (int i = 0; i < 10; i++) {
        INV_FUN_0010130c(param_4, param_2, 2);
        INV_FUN_001012b8((long long)param_4, param_2);
        INV_FUN_0010124d((long long)param_4, param_2, 5, 8);
        INV_FUN_001011cd((long long)param_4, param_2, 3);
        INV_FUN_00101169((long long)param_4, param_2, 0xff);
    }
}

int main(void) {
    FUN_001013f8();  // Initialize S-box
    init_inverse_sbox();  // Initialize inverse S-box
    
    // Example usage
    char encrypted[] = {107, 207, 161, 72, 67, 246, 216, 243, 182, 94, 113, 117, 163, 2, 159};
    size_t length = strlen(encrypted);
    unsigned char *decrypted = malloc(length);
    
    // Decrypt
    FUN_00101decrypt(encrypted, length, NULL, decrypted);
    
    printf("Decrypted: %s\n", decrypted);
    
    free(decrypted);
    return 0;
}
