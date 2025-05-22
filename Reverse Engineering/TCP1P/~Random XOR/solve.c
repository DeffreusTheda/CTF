#include <stdio.h>
#include <time.h>
#include <stdlib.h>

int main(int argc, const char **argv) {
  unsigned int seed; // [rsp+1Ch] [rbp-34h] BYREF
  int i; // [rsp+20h] [rbp-30h]
  int v6; // [rsp+24h] [rbp-2Ch]
  int v7; // [rsp+28h] [rbp-28h]
  int v8; // [rsp+2Ch] [rbp-24h]
  FILE *stream; // [rsp+30h] [rbp-20h]
  char *ptr; // [rsp+38h] [rbp-18h]
  FILE *s; // [rsp+40h] [rbp-10h]

	seed = 1712064365; // I hope this work
	srand(seed);
  stream = fopen(argv[1], "rb");
  if ( stream ) {
    fseek(stream, 0LL, 2);
    v6 = ftell(stream);
    fseek(stream, 0LL, 0);
    ptr = malloc(0x40uLL);
    fread(ptr, 1uLL, v6, stream);
    for ( i = 0; i < v6; ++i ) {
      v7 = rand();
      v8 = rand();
      *(ptr+i) ^= v7;
    }
    printf("%s\n", (const char *)ptr);
    fclose(stream);
    free(ptr);
    return 0;
  } else {
    puts("Error opening file.");
    return 1;
  }
}
