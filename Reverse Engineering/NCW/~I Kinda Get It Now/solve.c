#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Global S-box
unsigned char byte_4060[256];

// Decryption for sub_1169 !
void decrypt_1169(long long a1, unsigned long long a2, unsigned char a3) {
    for (unsigned long long i = 0; i < a2; ++i) {
        unsigned char *byte = (unsigned char *)(a1 + i);
        *byte = (*byte - i);
        if (*byte < 0) *byte += 256;
    }
}

// Decryption for sub_11CD !
void decrypt_11CD(long long a1, unsigned long long a2, char a3) {
    for (unsigned long long i = 0; i < a2; ++i) {
        unsigned char *byte = (unsigned char *)(a1 + i);
        *byte = (*byte << (8 - a3)) | (*byte >> a3);
    }
}

// Decryption for sub_124D !
void decrypt_124D(long long a1, unsigned long long a2) {
    for (unsigned long long i = 0; i < a2; ++i) {
        unsigned char *byte = (unsigned char *)(a1 + i);
        *byte -= 8;
        if (*byte < 0) *byte += 256;
        *byte /= 5;
    }
}

// Decryption for sub_12B8
void decrypt_12B8(long long a1, unsigned long long a2) {
    for (unsigned long long i = 0; i < a2; ++i) {
        unsigned char *byte = (unsigned char *)(a1 + i);
        for (int j = 0; j < 256; j++) {
            if (byte_4060[j] == *byte) {
                *byte = j;
                break;
            }
        }
    }
}

// Decryption for sub_130C
void decrypt_130C(void *a1, size_t a2) {
    void *src = alloca(a2);
    for (size_t i = 0; i < a2; ++i)
        ((char *)src)[i] = ((char *)a1)[(i + 2) % a2];

    memcpy(a1, src, a2);
}

// Combined decryption function (reverse of sub_14E2)
void allDecrypt(const void *a1, size_t a2, long long a3, void *a4) {
    memcpy(a4, a1, a2);
    for (int i = 0; i < 10; ++i) {
        decrypt_130C(a4, a2);
        decrypt_12B8((long long)a4, a2);
        decrypt_124D((long long)a4, a2);
        decrypt_11CD((long long)a4, a2, 3);
        decrypt_1169((long long)a4, a2, 0xFFu);
    }
}

// Initialize S-box (same as sub_13F8)
void initSBox() {
    unsigned int random_value = 0x3039;
    for (int i = 0; i < 256; ++i) {
        byte_4060[i] = (char)i;
    }
    // Fisher-Yates shuffle algorithm
    for (int i = 255; i > 0; --i) {
        random_value = (random_value * 0x41c64e6d + 0x3039) % 0x7fffffff;
        int j = random_value % (i + 1);
        // Swap elements at indices i and j
        char temp = byte_4060[i];
        byte_4060[i] = byte_4060[j];
        byte_4060[j] = temp;
    }
}

int main() {
    // Initialize S-box
    initSBox();

    // Example encrypted data (you would replace this with actual encrypted data)
    unsigned char encrypted[] = {107, 207, 161, 72, 67, 246, 216, 243, 182, 94, 113, 117, 163, 2, 159};
    size_t dataSize = sizeof(encrypted);

    // Allocate buffer for decrypted data
    unsigned char *decrypted = malloc(dataSize);

    // Decrypt
    allDecrypt(encrypted, dataSize, 0, decrypted);

    // Print decrypted data
    printf("Decrypted: ");
    for (size_t i = 0; i < dataSize; ++i) {
        printf("%d, ", decrypted[i]);
    }
    printf("\n");
    for (size_t i = 0; i < dataSize; ++i) {
        printf("%c", decrypted[i]);
    }
    printf("\n");

    // Clean up
    free(decrypted);

    return 0;
}