#include <stdio.h>
#include <string.h>

// Global variables
unsigned char DAT_00104060[256];

// Function prototypes
void FUN_001013f8(void);
void FUN_00101169(long param_1, unsigned long param_2, unsigned char param_3);
void FUN_001011cd(long param_1, unsigned long param_2, unsigned char param_3);
void FUN_0010124d(long param_1, unsigned long param_2, char param_3, char param_4);
void FUN_001012b8(long param_1, unsigned long param_2);
void FUN_0010130c(void *param_1, unsigned long param_2, int param_3);
void FUN_001014e2(void *param_1, size_t param_2, void *param_3, void *param_4);

// Initialize substitution box
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

// Byte-wise addition and modulo
void FUN_00101169(long param_1, unsigned long param_2, unsigned char param_3) {
    for (unsigned long i = 0; i < param_2; i++) {
        *(unsigned char *)(param_1 + i) = (*(unsigned char *)(param_1 + i) + i) % param_3;
    }
}

// Circular bit shift
void FUN_001011cd(long param_1, unsigned long param_2, unsigned char param_3) {
    for (unsigned long i = 0; i < param_2; i++) {
        unsigned char byte = *(unsigned char *)(param_1 + i);
        *(unsigned char *)(param_1 + i) = (byte << param_3) | (byte >> (8 - param_3));
    }
}

// Affine cipher
void FUN_0010124d(long param_1, unsigned long param_2, char param_3, char param_4) {
    for (unsigned long i = 0; i < param_2; i++) {
        *(unsigned char *)(param_1 + i) = *(unsigned char *)(param_1 + i) * param_3 + param_4;
    }
}

// S-box substitution
void FUN_001012b8(long param_1, unsigned long param_2) {
    for (unsigned long i = 0; i < param_2; i++) {
        *(unsigned char *)(param_1 + i) = DAT_00104060[*(unsigned char *)(param_1 + i)];
    }
}

// Circular buffer shift
void FUN_0010130c(void *param_1, unsigned long param_2, int param_3) {
    int shift = param_3 % param_2;
    if (shift < 0) shift += param_2;
    
    unsigned char *buffer = (unsigned char *)param_1;
    unsigned char *temp = malloc(param_2);
    
    for (unsigned long i = 0; i < param_2; i++) {
        temp[i] = buffer[(i + param_2 - shift) % param_2];
    }
    
    memcpy(buffer, temp, param_2);
    free(temp);
}

// Main encryption function
void FUN_001014e2(void *param_1, size_t param_2, void *param_3, void *param_4) {
    memcpy(param_4, param_1, param_2);
    
    for (int i = 0; i < 10; i++) {
        FUN_00101169(param_4, param_2, 0xff);
        FUN_001011cd(param_4, param_2, 3);
        FUN_0010124d(param_4, param_2, 5, 8);
        FUN_001012b8(param_4, param_2);
        FUN_0010130c(param_4, param_2, 2);
    }
}

// Main function
int main(void) {
    FUN_001013f8();  // Initialize S-box
    
    char plaintext[] = "{fak3_fl4g}";
    size_t length = strlen(plaintext);
    unsigned char *ciphertext = malloc(length);
    
    FUN_001014e2(plaintext, length, NULL, ciphertext);
    
    printf("Ciphertext: ");
    for (size_t i = 0; i < length; i++) {
        printf("%d, ", ciphertext[i]);
    }
    printf("\n");
    
    puts("Encryption Done!");
    
    free(ciphertext);
    return 0;
}
