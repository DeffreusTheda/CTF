#include <ctype.h>
#include <stdlib.h>
#include <stdint.h>
#include <stdio.h>
#include <string.h>

struct Node {
  int8_t value;
  struct Node* next;
};

long long len;
struct Node* cur;
char *input;

void mod_out() {
  *input |= (int8_t)(1 << ((int8_t)len & 0x1f));
}

void xors() {
  if (cur != NULL) {
    struct Node* next = cur->next;
    if ((char)next->value < (char)cur->value) {
      // THIS IS COOL AF; IT SWAP next->value AND cur->value LIKE WTH
      next->value = (int8_t)(cur->value ^ next->value);
      cur->value = (int8_t)(next->value ^ cur->value);
      next->value = (int8_t)(cur->value ^ next->value);

      mod_out();
    }
    cur = cur->next;
    len = len + 1;
    if (7 < len) {
      ++input;
      len = 0;
    }
    xors();
  }
}

void encrypt(struct Node* head) {
  len = len + -1;
  if (0 < len) {
    encrypt(head);
    xors();
  }
  cur = head;
}

void create_linked_list() {
  struct Node *head;
  struct Node *next;
  unsigned long idx;

  head = (struct Node*)malloc(0x10);
  cur = head;
  head->value = 0;
  head->next = NULL;

  // Basically add len amount of empty nodes to linked list
  for (idx = 0; idx < (unsigned long)(long)len; ++idx) {
    // Create next
    next = (struct Node*)malloc(0x10);
    next->value = input[idx];
    printf("%c ", next->value);
    next->next = NULL;

    // Go to tail
    for (; cur->next != NULL; cur = cur->next) {}

    // Append new next to tail
    cur->next = next;
  }

  // Reset to head
  cur = head;
}

void solve() {
  char c;

  FILE *stream = fopen("output2", "rb");
  const size_t flag_len = 179;
  const size_t input_len = 34;
  const size_t magic = (input_len * input_len + 7) >> 3;
  char flag[flag_len + 1];

  if (stream == NULL) {
    printf("Error opening file.\n");
    exit(1);
  }
  int idx = 0;
  while ((c = getc(stream)) != EOF) {
    flag[idx++] = c;
  }

  // unseed :p
  int seed = '}'; // or ~; biggest printable character value in flag
  srand(seed);
  for (idx = 0; idx < magic; ++idx) {
    flag[idx] ^= (int8_t)rand();
  }
  // for (idx = 0; idx < flag_len; ++idx) {
  //   printf("%u, ", flag[idx]);
  // }
  putchar('\n');

  // unintertwining
  char *signal = (char*)malloc(magic + 1);
  char *input = (char*)malloc(input_len + 1);
  for (idx = 0; idx < input_len; ++idx) {
    input[idx] = flag[idx];
    signal[idx] = flag[idx];
    ++idx;
  }
  for (; idx < flag_len; ++idx) {
    signal[idx] = flag[idx];
  }
  for (idx = 0; idx < magic; ++idx) {
    printf("%u, ", signal[idx]);
  }

  // unswapping
  int si = magic - 1;
  int bit = 0;
  for (idx = input_len - 1; idx >= 0; --idx) {
    if (signal[si] & (1 << bit))
      ;
  }

  exit(0);
}

int main(void) {
  input = "NEXUS{A_BCDEFGHIJKLMNOPQRSTUVWXYZ}";
  size_t size = strlen(input);
  int llen = (int) size;
  len = llen;

  // Create linked list of input
  create_linked_list(); // list length = size

  /* XD */
  // printf("xd");
  // struct Node *head = cur;
  // while (cur != NULL) {
  //   printf("%c", cur->value);
  //   cur = cur->next;
  // }
  // cur = head;
  // printf("xa");

  char *magic = (void *) calloc((long) (int) (size * size + 7) >> 3, 1);
  input = magic; // The

  encrypt(cur); // Populate magic with bits
  // actually, this is just sorting

  char *ptr = calloc((llen + (int) (size * size + 7)) >> 3, 1);
  long offset = 0;
  char seed = cur->value;

  for (unsigned long i = 0; i < (size *size + 7) >> 3; ++i) {
    if (cur != NULL) {
      ptr[offset] = cur->value;
      seed = cur->value;
      cur = cur->next;
      ++offset;
    }

    ptr[offset] = *magic;
    ++magic;
    ++offset;
  }

  for (; cur != NULL; cur = cur->next) {
    ptr[offset] = cur->value;
    seed = cur->value;
    ++offset;
  }

  srand((int)seed); // WHAT THE SEED?

  for (unsigned long j = 0; j  < (size + size *size + 7) >> 3; ++j) {
    int r = rand();
    *(int8_t *)(j + (long)ptr) = (int8_t)(*(int8_t *)(j + (long)ptr) ^ (int8_t)r);
  }
  FILE *stream = fopen("flag", "wb");
  fwrite(ptr,1,(long)((llen + (int)size *size + 7) >> 3), stream);

  return 0;
}
