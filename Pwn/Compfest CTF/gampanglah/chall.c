int setup() {
  setvbuf(stdin, 0LL, 2, 0LL);
  setvbuf(stdout, 0LL, 2, 0LL);
  return setvbuf(stderr, 0LL, 2, 0LL);
}

__int64 get_rand() {
  unsigned int seed; // [rsp+8h] [rbp-8h]

  seed = time(0LL);
  srand(seed);
  return (unsigned int)(rand() % 256);
}

size_t xor(const char *a1, char a2) {
  size_t result; // rax
  size_t i; // [rsp+10h] [rbp-10h]

  for ( i = 0LL; i < strlen(a1); ++i ) {
    result = i;
    a1[i] ^= a2;
  }
  return result;
}

int main(int argc, const char **argv, const char **envp) {
  int i; // [rsp+Ch] [rbp-54h]
  char format[72]; // [rsp+10h] [rbp-50h] BYREF

  setup();
  key = get_rand();
  puts("Welcome to COMPFEST 16. Can you help me test this XOR function?\n");
  puts("You only got 2 chances!");
  for ( i = 0; i <= 1; ++i ) {
    printf("> ");
    gets(format);
    xor(format, key);
    printf("Here is your XORed result : ");
    printf(format);
    putchar(10);
  }
  puts("Thanks for joining COMPFEST16");
  return 0;
}
