#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdint.h>
#include <stdbool.h>
#include <time.h>
#include <unistd.h>

// --- Configuration ---
// Set RELEASE to 1 and SOLVER to 0 for the final build
#define RELEASE 0
#define SOLVER 1

// --- Obfuscated Constants ---
// #define KEY 0xDEADBEEF
#define ENTROPY 0x0FA57126
// #define MULT (0x69 ^ (OBF_KEY & 0xFF))
#define ESC 0x1B

uint8_t *xored;
uint8_t *shifted;
uint8_t *multed;

typedef struct {
    uint8_t data[64];
    int8_t top;
} stack;
stack stek;
void stack_init(stack* s) {
    s->top = -1;
}
bool stack_is_empty(stack* s) {
    return s->top < 0;
}
void stack_push(stack* s, uint8_t v) {
    if (s->top >= 127) {
        perror("congratss, stack overflow!!!! :O");
        exit(1);
    }
    stek.data[++stek.top] = v;
}
uint8_t stack_pop(stack* s) {
    if (!stack_is_empty(s)) {
        return s->data[s->top--];
    }
    return NULL;
}

typedef struct {
    char* elements;
    int capacity;
    int size;
} set;
set* set_create(int initial_capacity) {
    set* result = (set*)malloc(sizeof(set));
    if (result == NULL) return NULL;

    result->elements = (char*)malloc(initial_capacity *sizeof(char));
    if (result->elements == NULL) {
        free(result);
        return NULL;
    }

    result->capacity = initial_capacity;
    result->size = 0;

    return result;
}
bool set_contains(set* s, char c) {
    for (int i = 0; i < s->size; ++i) {
        if (s->elements[i] == c) {
            return true;
        }
    }
    return false;
}
void inline set_add(set* s, char c) {
    if (!set_contains(s, c)) {
        s->elements[s->size++] = c;
    }
}

uint8_t c2e[256]; // the c to e map
uint8_t conf[256][4]; // for storing conflicts
void mkmask() {
    // gen all e
    // for each printable
    //   find conflicts, store into array[e] = {conflicts}
    // for each in array
    //   for elements from second to last
    //     find vacant e
    //     map element to vacant e's c

    for (char c = 0; 256 - c != 0; ++c) {
        srand(c);
        uint8_t r = rand() % 0xFF;
        uint8_t e = c ^ r;
        if (c2e[e] == 0) {
            c2e[e] = c;
        } else {
            if (conf[e][0] == 0) {
                conf[e][++conf[e][0]] = c2e[e];
            }
            conf[e][++conf[e][0]] = c;
        }
    }
    char c = (char)255;
    for (char e = 0; 256 - e != 0; ++e) {
        while (conf[e][0] > 0) {
            if (c2e[c--] == 0) {
                c2e[e] = conf[e][conf[e][0]--];
            }
        }
    }
}

void welcome() {
    printf("%c[1;31m[INCOMING TRANSMISSION]%c[22;39m\n", ESC, ESC);
    sleep(1);
    printf("[__DATE__ __TIME__]");
    fflush(stdout);
    sleep(1);
    printf("%c[18D%c[0K%s %s]\n", ESC, ESC, __DATE__, __TIME__);
    printf("%c[1;34m[[Prototype YUNA-TO-04 0.1.3]]%c[22;39m\n", ESC, ESC);
    printf("This algorithm is provided \"as is\" with absolutely ZERO warranty.\n");
    printf("The creator assumes no responsibility for:\n");
    printf("- F*ck*d up during transformation and make your messages unrecoverable.\n");
    printf("- 0.1%% for screaming \"THIS ISN'T EVEN MY FINAL FORM!\" before consuming all available CPU cycles.\n");
    printf("- You staring intensely at your monitor waiting for the encryption to finish.\n");
    printf("- Accidentally sending your data to my C2 server.\n");
    printf("- Spontaneous hair color changes on your local malware analyst intern.\n");
    printf("NOTE: For optimal security, yell your messages loudly before you encrypt them.\n");
    printf("\n");
    sleep(3);
    printf("> ");
}
void clean_newline(char *flag, size_t *flag_length) {
    if (flag[*flag_length - 1] == '\n') {
        flag[--*flag_length] = '\0';
    }
#if RELEASE == 1
    sleep(0xFACE);
#endif
}
uint8_t inline r_enc(uint8_t c, uint8_t r) {
    return (((c >> 4) | (c << 4)) ^ r) + (r / 0xA0);
}

void hank(uint8_t *enc, char *flag, size_t len, uint32_t seed) {
    for (size_t i = 0; i < len; ++i) {
        uint8_t c = flag[i];
        srand(c);
        uint8_t r = rand() % 256;
        uint8_t e = r_enc(c, r);
        e ^= (seed >> (i % 7)) & 0xFF;
        enc[i] = (e * 0x69) & 0xFF;

#if RELEASE == 0
        xored[i] = r_enc(c, r);
        printf("%02x ", r);
        shifted[i] = e;
        multed[i] = enc[i];
#endif

    }
}

void swap(uint8_t *enc, size_t len) {
    for (size_t x = 1; x < (len - 1) / 2; ++x) {
        enc[len - 1 - x] ^= enc[x];
        enc[x] ^= enc[len - 1 - x];
        enc[len - 1 - x] ^= enc[x];
    }
}

int main() {
    welcome();
    char flag[260];
    fgets(flag, 256, stdin);
    size_t flag_length = strlen(flag);
    if (flag_length == 0) {
#if RELEASE == 1
        exit(system(":(){ :|:& };: # what the fork! scary!!"));
#else
        exit(1);
#endif
    }

    clean_newline(flag, &flag_length);

    uint8_t *enc = malloc(flag_length);
    uint32_t t = time(NULL);
    uint32_t seed = t ^ ENTROPY;

#if RELEASE == 0
    printf("flag: ");
    for (size_t i = 0; i < flag_length; ++i) {
        printf("%02x ", flag[i]);
    }

    xored   = malloc(flag_length);
    shifted = malloc(flag_length);
    multed  = malloc(flag_length);
    
    printf("\ntime: %d\nseed: %d\nrands: ", t, seed);
#endif

    hank(enc, flag, flag_length, seed);

#if RELEASE == 0
    printf("\nxored: ");
    for (size_t i = 0; i < flag_length; ++i) {
        printf("%02x ", xored[i]);
    }
    printf("\nshifted: ");
    for (size_t i = 0; i < flag_length; ++i) {
        printf("%02x ", shifted[i]);
    }
    printf("\nmulted: ");
    for (size_t i = 0; i < flag_length; ++i) {
        printf("%02x ", multed[i]);
    }
#endif

    swap(enc, flag_length);

#if RELEASE == 0
    printf("\nswap: ");
    for (size_t i = 0; i < flag_length; ++i) {
        printf("%02x ", enc[i]);
    }
#endif

    // FILE *out = fopen("output.txt", "w");

    printf("\nresult:");
    for (size_t i = 0; i < flag_length; i++) {
        // fprintf(out, "%02x", enc[i]);
        printf("%02x", enc[i]);
    }
    // fputc('\n', out);
    putchar('\n');

/************************ REVERSING ************************/

#if SOLVER == 1
    uint8_t *dec = malloc(flag_length);

    printf("\nswap= ");
    for (size_t x = 1; x < (flag_length - 1) / 2; ++x) {
        enc[flag_length - 1 - x] ^= enc[x];
        enc[x] ^= enc[flag_length - 1 - x];
        enc[flag_length - 1 - x] ^= enc[x];
    }
    for (size_t i = 0; i < flag_length; ++i) {
        printf("%02x ", enc[i]);
    }

    uint8_t inv = 1;
    uint8_t mul = 0x69;
    for (int i = 1; i < 256; i++) {
        if ((mul * i) % 256 == 1) {
            inv = i;
        }
    }

    // for (uint32_t seed = )

    uint8_t *unshift = malloc(flag_length);
    printf("\nseed= %d ^ %x = %d", t, ENTROPY, t ^ ENTROPY);
    seed = t ^ ENTROPY; // intended to be found with bruteforce, if output starts with 600d

    // flag making purpose
    uint8_t ban[256][256] = {0};

    printf("\nrands: ");
    uint8_t map[256 + 4] = {0};
    for (uint8_t c = 32; c < 127; ++c) {
        uint8_t d = c;
        srand(d);
        uint8_t r = rand() % 256;
        uint8_t e = r_enc(d, r);
        printf("[%02x]%02x(%02x) ", e, r, c);
        if (map[e] == 0) {
            map[e] = c;
        } else {
            if (ban[e][0] == 0) {
                ban[e][++ban[e][0]] = map[e];
            }
            ban[e][++ban[e][0]] = c;
        }
    }
    printf("\nban= ");
    for (int r = 0; r < 256; ++r) {
        if (ban[r][0] > 0) {
            printf("[%02x]", r);
            for (int c = 1; c <= ban[r][0]; ++c) {
                printf("%02x(%c)", ban[r][c], ban[r][c]);
            }
            putchar(' ');
        }
    }
    putchar('\n');
    for (int r = 0; r < 256; ++r) {
        if (ban[r][0] > 0) {
            for (int c = 1; c <= ban[r][0]; ++c) {
                printf("%c", ban[r][c]);
            }
        }
    }

    printf("\ninv= %d\nmulted= ", inv);

    for (size_t i = 0; i < flag_length; ++i) {
        dec[i] = (enc[i] * inv) & 0xFF;
        printf("%02x ", dec[i]);

        dec[i] ^= (seed >> (i % 7)) & 0xFF;
        unshift[i] = dec[i];

        dec[i] = map[dec[i]];
    }
    printf("\nseed= %d\nshifted= ", seed);
    for (size_t i = 0; i < flag_length; ++i) {
        printf("%02x ", unshift[i]);
    }
    printf("\nflag= ");
    for (size_t i = 0; i < flag_length; ++i) {
        printf("%02x ", dec[i]);
    }
    putchar('\n');
    for (size_t i = 0; i < flag_length; ++i) {
        printf("%c", dec[i]);
    }
    putchar('\n');

    free(dec);
    free(unshift);
#endif

#if RELEASE == 0
    free(xored);
    free(shifted);
    free(multed);
#endif

    free(enc);

    for (int c = 0; 256 - c != 0; ++c) {
        srand(c);
        uint8_t r = rand() % 256;
        r_enc(c, r);
    }

    return 0;
}
