#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>

int main() {
    struct tm timeinfo;
    time_t rawtime;
    unsigned int seed;
    FILE *flag_file, *output_file;
    char *flag;
    long file_size;
    int i;
    char char_flag, char_enc;

    // Set the time components.
    timeinfo.tm_year = 2025 - 1900;
    timeinfo.tm_mon = 3 - 1;
    timeinfo.tm_mday = 2;

    // Convert to UTC timestamp.
    rawtime = timegm(&timeinfo);

    if (rawtime == -1) {
        perror("timegm failed");
        return 1;
    }

    // Open flag.txt for reading.
    flag_file = fopen("output.txt", "rb"); // Open in binary mode!
    if (flag_file == NULL) {
        perror("Error opening flag.txt");
        return 1;
    }

    // Get the file size.
    fseek(flag_file, 0, SEEK_END);
    file_size = ftell(flag_file);
    fseek(flag_file, 0, SEEK_SET);

    // Allocate memory for the flag.
    flag = (char *)malloc(file_size + 1); // +1 for null terminator (if needed)

    if (flag == NULL) {
        perror("Memory allocation failed");
        fclose(flag_file);
        return 1;
    }

    // Read the flag from the file.
    fread(flag, 1, file_size, flag_file);
    fclose(flag_file);

    // Open output.txt for writing.
    seed = (int)rawtime;
    
    for (int j = 0; j < (60*60*24); j++) {
        char* dec = malloc(file_size + 1);
        // Seed the random number generator.
        srand(seed + j);
        // printf("%d", seed + j);

        // XOR each character with rand() and write to output.txt.
        for (i = 0; i < file_size; i++) {
            char_flag = flag[i];
            dec[i] = char_flag ^ (rand() & 0xFF);
            // if (char_enc >= 32 && char_enc <= 125)
              // putchar(char_enc);
        }
        if (strstr(dec, "RAMADAN") != NULL) {
            printf("(%d) %s\n", seed + j, dec);
        }

        free(dec);
    }
    
    free(flag);

    return 0;
}
