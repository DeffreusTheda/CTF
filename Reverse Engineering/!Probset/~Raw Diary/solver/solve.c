#include <stdlib.h>
#include <stdio.h>
#include <time.h>
#include <string.h>

int main() {
  FILE* fflag = fopen("enc.txt", "r");

  fseek(fflag, 0L, SEEK_END);
  int flag_len = ftell(fflag);
  rewind(fflag);
  char* enc = malloc(flag_len + 1);
  
  size_t b = fread(enc, 1, flag_len, fflag);
  enc[b] = '\0';
  fclose(fflag);

  /* Mar 2 2025 15:02:09 GMT --> 1740927729 */
  for (int t = 1740827729; ; ++t) {
    srand(t);

    char* dec = malloc(b + 1);

    for (int i = 0; i < b; ++i) {
      dec[i] = enc[i] ^ (rand() & 0xFF);
    }
    if (strstr(dec, "RAMADAN") != NULL) {
      printf("(%d) %s\n", t, dec);
      free(dec);
      break;
    }

    free(dec);

  }

  free(enc);
  return 0;
}
