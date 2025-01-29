#include <stdio.h>
#include <stdlib.h>
#include <sys/mman.h>

struct Flag {
    int value;
    const char *name;
};

struct Flag mmap_flags[] = {
    { MAP_SHARED, "MAP_SHARED" },
    { MAP_PRIVATE, "MAP_PRIVATE" },
    { MAP_FIXED, "MAP_FIXED" },
    { MAP_ANONYMOUS, "MAP_ANONYMOUS" },
    { MAP_32BIT, "MAP_32BIT" },     // Only on x86-64
    { MAP_NORESERVE, "MAP_NORESERVE" },
    // { MAP_LOCKED, "MAP_LOCKED" },
    // { MAP_POPULATE, "MAP_POPULATE" },
    // { MAP_NONBLOCK, "MAP_NONBLOCK" },
    // { MAP_STACK, "MAP_STACK" },
    // { MAP_HUGETLB, "MAP_HUGETLB" },
    // { MAP_SYNC, "MAP_SYNC" },
    // { MAP_UNINITIALIZED, "MAP_UNINITIALIZED" }, // Might be obsolete
};

int main(int argc, char *argv[]) {
    if (argc != 2) {
        fprintf(stderr, "Usage: %s <flags_integer>\n", argv[0]);
        return EXIT_FAILURE;
    }

    int input = strtol(argv[1], NULL, 0);
    printf("Input: 0x%x (%d)\n", input, input);
    printf("Possible flags:\n");

    int remaining = input;
    for (size_t i = 0; i < sizeof(mmap_flags) / sizeof(mmap_flags[0]); i++) {
        if ((input & mmap_flags[i].value) == mmap_flags[i].value) {
            printf("  %s (0x%x)\n", mmap_flags[i].name, mmap_flags[i].value);
            remaining &= ~mmap_flags[i].value;
        }
    }

    if (remaining != 0) {
        printf("  Unknown or custom bits: 0x%x\n", remaining);
    }

    return EXIT_SUCCESS;
}

