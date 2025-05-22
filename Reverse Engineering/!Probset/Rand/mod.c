#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdint.h>
#include <stdbool.h>
#include <time.h>
#include <unistd.h>
#include <sys/ptrace.h> // For anti-debugging

// --- Configuration ---
// Set RELEASE to 1 and SOLVER to 0 for the final build
#define RELEASE 1
#define SOLVER 0 // Keep solver logic out of release build

// --- Obfuscated Constants ---
#define OBF_KEY 0xDEADBEEF // Simple key for obfuscation
#define OBF_ENTROPY (0x0FA57126 ^ OBF_KEY)
#define OBF_MULT (0x69 ^ (OBF_KEY & 0xFF))
#define ESC 0x1B

// --- Global Map for Collision-Free Encoding ---
uint8_t char_to_encoded[256];
uint8_t encoded_to_char[256]; // Inverse map needed for solving, but not included in release

// --- Function Pointers for Obfuscation ---
void (*my_srand)(unsigned int) = srand;
int (*my_rand)(void) = rand;

// --- Anti-Debugging ---
void check_debugger() {
    // Simple ptrace anti-debugging (for Linux/macOS)
    // If a debugger is attached, this will likely cause issues or be detected.
    if (ptrace(PTRACE_TRACEME, 0, NULL, NULL) == -1) {
        // Consider exiting, crashing, or misbehaving
        // printf("Debugger detected!\n"); // Don't print this in release
        exit(1);
    }
}

// --- String Obfuscation Utility ---
// Simple XOR decryption for strings
void decrypt_string(char *str, size_t len) {
    for (size_t i = 0; i < len; ++i) {
        str[i] ^= (OBF_KEY >> ((i % 4) * 8)) & 0xFF;
    }
}

void seq() {
    // Obfuscated strings (simple XOR)
    char msg1[] = { 0x7f ^ 0xEF, 0x0e ^ 0xBE, 0x0d ^ 0xAD, 0x0b ^ 0xDE, 0x0d ^ 0xEF, 0x01 ^ 0xBE, 0x0d ^ 0xAD, 0x06 ^ 0xDE, 0x11 ^ 0xEF, 0x45 ^ 0xBE, 0x1d ^ 0xAD, 0x00 ^ 0xDE, 0x1d ^ 0xEF, 0x17 ^ 0xBE, 0x01 ^ 0xAD, 0x11 ^ 0xDE, 0x1c ^ 0xEF, 0x1c ^ 0xBE, 0x11 ^ 0xAD, 0x0d ^ 0xDE, 0x10 ^ 0xEF, 0x7f ^ 0xBE, 0x3a ^ 0xAD, 0x2b ^ 0xDE, 0x7c ^ 0xEF, 0x77 ^ 0xBE, 0x3a ^ 0xAD, 0x3a ^ 0xDE, 0x2d ^ 0xEF, 0x3b ^ 0xBE, 0x7c ^ 0xAD, 0x00 }; // "[INCOMING TRANSMISSION]\n" ^ key
    char msg2[] = { 0x7f ^ 0xEF, 0x4e ^ 0xBE, 0x4f ^ 0xAD, 0x4e ^ 0xDE, 0x4e ^ 0xEF, 0x03 ^ 0xBE, 0x01 ^ 0xAD, 0x06 ^ 0xDE, 0x0f ^ 0xEF, 0x4e ^ 0xBE, 0x4f ^ 0xAD, 0x4e ^ 0xDE, 0x4e ^ 0xEF, 0x11 ^ 0xBE, 0x01 ^ 0xAD, 0x0e ^ 0xDE, 0x0f ^ 0xEF, 0x7f ^ 0xBE, 0x00 }; // "[__DATE__ __TIME__]" ^ key
    char msg3[] = { 0x1b ^ 0xEF, 0x0c ^ 0xBE, 0x17 ^ 0xAD, 0x5f ^ 0xDE, 0x1e ^ 0xEF, 0x0c ^ 0xBE, 0x00 ^ 0xAD, 0x4e ^ 0xDE, 0x19 ^ 0xEF, 0x00 ^ 0xBE, 0x10 ^ 0xAD, 0x0d ^ 0xDE, 0x4f ^ 0xEF, 0x03 ^ 0xBE, 0x1e ^ 0xAD, 0x11 ^ 0xDE, 0x45 ^ 0xEF, 0x0b ^ 0xBE, 0x1e ^ 0xAD, 0x4d ^ 0xDE, 0x0f ^ 0xEF, 0x1b ^ 0xBE, 0x00 ^ 0xAD, 0x0f ^ 0xDE, 0x55 ^ 0xEF, 0x48 ^ 0xBE, 0x19 ^ 0xAD, 0x00 }; // "\nI don't do pain, but ah, eto... bleh! :p\n> " ^ key

    decrypt_string(msg1, sizeof(msg1) - 1);
    printf("%c[1;31m%s%c[22;39m", ESC, msg1, ESC);
    sleep(2);

    decrypt_string(msg2, sizeof(msg2) - 1);
    printf("\n%s", msg2);
    sleep(1);
    printf("%c[18D%c[0K%s %s]", ESC, ESC, __DATE__, __TIME__);

    decrypt_string(msg3, sizeof(msg3) - 1);
    printf("%s", msg3);
    fflush(stdout); // Ensure output is displayed before potential fgets block
}

void clean_newline(char *flag, size_t *flag_length) {
    if (*flag_length > 0 && flag[*flag_length - 1] == '\n') {
        flag[--*flag_length] = '\0';
    }
}

// Inlining encouraged
static inline uint8_t flip(uint8_t c) {
    return (c >> 4) | (c << 4);
}

// Original problematic encoding function (used ONLY for map generation)
uint8_t r_enc_orig(uint8_t c) {
    my_srand(c);
    uint8_t r = my_rand() % 256;
    uint8_t flipped_c = flip(c);
    // Combine operations slightly to obscure steps
    return (flipped_c ^ r) + (r / 0xA0);
}

// --- Collision Resolution Map Generation ---
void generate_collision_free_map() {
    uint8_t initial_e[256];
    uint8_t e_is_used[256] = {0};
    uint8_t e_collision_count[256] = {0};
    uint8_t conflicting_chars[256][10]; // Store chars causing collision for an 'e'
    uint8_t vacant_e[256];
    int vacant_count = 0;
    int conflict_remap_idx = 0;

    // 1. Calculate initial encoding and mark used 'e' values (for printable ASCII)
    memset(char_to_encoded, 0, sizeof(char_to_encoded)); // Initialize map
    memset(conflicting_chars, 0, sizeof(conflicting_chars));

    for (int c = 0; c < 256; ++c) { // Calculate for all, but focus on 32-126 for collisions
         if (c >= 32 && c < 127) {
             initial_e[c] = r_enc_orig(c);
             e_is_used[initial_e[c]] = 1;
             e_collision_count[initial_e[c]]++;
             if (e_collision_count[initial_e[c]] > 1) {
                 // Store the conflicting character index (c)
                 int count = ++conflicting_chars[initial_e[c]][0]; // Index 0 stores the count
                 if (count < 10) { // Avoid buffer overflow
                     conflicting_chars[initial_e[c]][count] = c;
                 }
                 // Also store the first char that mapped here if this is the 2nd collision
                 if (count == 2) {
                    for(int prev_c = 32; prev_c < c; ++prev_c) {
                        if (initial_e[prev_c] == initial_e[c]) {
                            conflicting_chars[initial_e[c]][1] = prev_c;
                            break;
                        }
                    }
                 }
             } else {
                 // First time seeing this 'e', directly map c -> e
                 char_to_encoded[c] = initial_e[c];
             }
         } else {
             // For non-printable, maybe assign a default or leave 0?
             // Let's compute their original encoding but don't use them for collision resolution
             initial_e[c] = r_enc_orig(c);
             char_to_encoded[c] = initial_e[c]; // Non-printable chars keep their original mapping
                                                // They might collide with others, but we prioritize printable
         }
    }

    // 2. Find vacant 'e' values
    for (int e = 0; e < 256; ++e) {
        if (!e_is_used[e]) {
            vacant_e[vacant_count++] = e;
        }
    }

    // 3. Remap conflicting printable characters (all except the first one mapping to e)
    for (int e = 0; e < 256; ++e) {
        int collision_count = conflicting_chars[e][0];
        if (collision_count > 1) { // If there was a collision for this 'e'
            // Keep the first char mapped to 'e' (already done in step 1)
            // Remap the others (stored from index 2 upwards in conflicting_chars[e])
            for (int i = 2; i <= collision_count; ++i) {
                uint8_t char_to_remap = conflicting_chars[e][i];
                if (char_to_remap >= 32 && char_to_remap < 127) { // Only remap printable ASCII conflicts
                    if (conflict_remap_idx < vacant_count) {
                        char_to_encoded[char_to_remap] = vacant_e[conflict_remap_idx++];
                    } else {
                        // Should not happen if there are enough vacant slots for conflicts
                        // Handle error: Not enough vacant 'e' values!
                        // fprintf(stderr, "Error: Not enough vacant e values to resolve collisions.\n");
                        // For a CTF, maybe just let it be imperfect or crash
                         char_to_encoded[char_to_remap] = 0; // Or some error value
                    }
                }
            }
        }
    }

    // (Optional: Build inverse map for solver - not included in release)
#if SOLVER == 1 && RELEASE == 0
    memset(encoded_to_char, 0, sizeof(encoded_to_char)); // Use 0 as 'unmapped'
    for(int c = 0; c < 256; ++c) {
        // This assumes the remapping made it unique for 32-126.
        // Need careful checking if multiple 'c' could still map to the same 'e'
        // especially considering non-printable chars.
        if (encoded_to_char[char_to_encoded[c]] == 0) { // Store first mapping found
             encoded_to_char[char_to_encoded[c]] = c;
        } else {
            // If collision still exists after remapping (e.g. non-printable collided), flag it.
            // fprintf(stderr, "Warning: Collision persists for e=0x%02x after remapping (c=%d vs %d)\n",
            //         char_to_encoded[c], c, encoded_to_char[char_to_encoded[c]]);
        }
    }
#endif
}


// Main encryption routine using the collision-free map
void hank(uint8_t *enc, const char *flag, size_t len, uint32_t seed) {
    uint8_t mult_val = OBF_MULT ^ (OBF_KEY & 0xFF); // De-obfuscate multiplier

    for (size_t i = 0; i < len; ++i) {
        uint8_t c = flag[i];

        // Opaque predicate: (seed | 1) is always non-zero, doesn't change logic
        // but adds analysis overhead.
        if ((seed | 1) > 0) {
             // 1. Use the precomputed map (handles collisions)
             uint8_t e = char_to_encoded[c];

             // 2. XOR with seed component
             e ^= (seed >> (i % 7)) & 0xFF;

             // 3. Multiply
             enc[i] = (e * mult_val); // Use uint8_t multiplication (implicit modulo 256)

        } else {
            // Dead code - never reached
            enc[i] = 0;
        }
    }
}

// Swap bytes (no changes needed, but could be obfuscated further)
void swap(uint8_t *enc, size_t len) {
    // Avoid swapping the first and last elements? The original loop started at x=1.
    // Let's keep the original logic: swaps [1]...[len-2]
    size_t iterations = (len > 2) ? (len - 2) / 2 : 0;
    for (size_t x = 1; x <= iterations; ++x) {
         // Check bounds carefully: indexes are x and len-1-x
         if (x < len && (len - 1 - x) < len && x != (len - 1- x)) {
            enc[len - 1 - x] ^= enc[x];
            enc[x] ^= enc[len - 1 - x];
            enc[len - 1 - x] ^= enc[x];
         }
    }
}

int main() {
    check_debugger(); // Anti-debugging check

    generate_collision_free_map(); // Setup the encoding map

    seq(); // Display intro sequence

    char flag[260];
    if (!fgets(flag, sizeof(flag) -1 , stdin)) {
        // Handle fgets error
        return 1;
    }
    size_t flag_length = strlen(flag);

    clean_newline(flag, &flag_length);

    if (flag_length == 0) return 1; // Exit if input is empty

    uint8_t *enc = malloc(flag_length);
    if (!enc) return 1; // Malloc check

    uint32_t t = time(NULL);
    uint32_t seed = t ^ (OBF_ENTROPY ^ OBF_KEY); // De-obfuscate entropy

    hank(enc, flag, flag_length, seed);

    swap(enc, flag_length);

    // Output the result
    char res_msg[] = { 0x0f ^ 0xEF, 0x0f ^ 0xBE, 0x17 ^ 0xAD, 0x1e ^ 0xDE, 0x0f ^ 0xEF, 0x11 ^ 0xBE, 0x4c ^ 0xAD, 0x00 }; // "\nresult:" ^ key
    decrypt_string(res_msg, sizeof(res_msg) - 1);
    printf("%s", res_msg);

    for (size_t i = 0; i < flag_length; i++) {
        printf("%02x", enc[i]);
    }
    putchar('\n');

    free(enc);

    return 0;
}

/************************ REVERSING ************************/
// The SOLVER section should be completely removed for a release build.
// It contains the exact inverse operations and makes reversing trivial.
// Building the inverse map (encoded_to_char) would be part of the solver.
#if SOLVER == 1 && RELEASE == 0 // Only include solver if explicitly enabled AND not a release build

#error "Solver code is present! Define RELEASE=1 and SOLVER=0 for final build."
// The solver would need:
// 1. The collision-free inverse map (`encoded_to_char`) generated by `generate_collision_free_map`.
// 2. Knowledge of the obfuscated constants (`OBF_ENTROPY`, `OBF_MULT`, `OBF_KEY`).
// 3. The modular multiplicative inverse of `(OBF_MULT ^ (OBF_KEY & 0xFF))`.
// 4. The ability to reverse the `swap` operation.
// 5. The ability to reverse the XOR with the seed `t ^ (OBF_ENTROPY ^ OBF_KEY)`. This requires knowing/guessing `t`.
// 6. The logic to use `encoded_to_char` map to get the final characters.

// Example (Conceptual - needs inverse map and modular inverse calculation):
/*
void solve(uint8_t *encoded_data, size_t len, uint32_t guessed_time) {
    uint32_t seed = guessed_time ^ (OBF_ENTROPY ^ OBF_KEY);
    uint8_t mult_val = OBF_MULT ^ (OBF_KEY & 0xFF);
    uint8_t inv_mult = /* Calculate modular multiplicative inverse of mult_val */;
/*
    uint8_t *dec = malloc(len);
    memcpy(dec, encoded_data, len); // Work on a copy

    // 1. Reverse swap
    swap(dec, len); // Swap is its own inverse

    // 2. Reverse operations in hank loop (in reverse order)
    for (size_t i = 0; i < len; ++i) {
        // 2a. Reverse multiply
        dec[i] = (dec[i] * inv_mult);

        // 2b. Reverse XOR with seed
        dec[i] ^= (seed >> (i % 7)) & 0xFF;

        // 2c. Reverse mapping using the inverse map
        dec[i] = encoded_to_char[dec[i]]; // Requires encoded_to_char to be generated
    }

    printf("\nPotential flag (time=%u): ", guessed_time);
    for(size_t i=0; i<len; ++i) {
        printf("%c", (dec[i] >= 32 && dec[i] < 127) ? dec[i] : '?'); // Print printable chars
    }
    printf("\n");

    free(dec);
}

// In main or a separate tool, you'd need to brute-force 't' around the expected time
// and call solve() for each guess.
*/
#endif // SOLVER == 1 && RELEASE == 0
