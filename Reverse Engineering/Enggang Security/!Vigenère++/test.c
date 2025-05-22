#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

void extendkey(char* key, int flag_len) {
  int key_len = strlen(key);
  int i_key_len = key_len;
  int iter = 0;

  while (key_len < flag_len) {
    if (key_len % i_key_len == 0) ++iter;
    key[key_len] = key[key_len % i_key_len] ^ iter;
    ++key_len;

    if (key_len == flag_len) {
      break;
    }
  }
  key[key_len] = '\0';

  // for (int i = 0; i < flag_len; ++i) {
    // if (i % i_key_len == 0) putchar('\n');
    // printf("%c ", key[i]);
  // }
}

void encrypt(char* flag, char* key, int flag_len) {
  FILE* data = fopen("data", "w");

  for (int i = 0; i < flag_len; ++i) {
    char c = flag[i], m, s, d;
    // printf("c: %c\t", c);

    if (isupper(c)) {
      // printf("u");
      m = 'Z';
      s = 26;
      d = '0';
    } else if (islower(c)) {
      // printf("l");
      m = 'z';
      s = 26;
      d = '0';
    } else {
      // printf("e");
      m = '~';
      s = 126 - 32 + 1;
      d = 'A';
    }

    flag[i] += key[i];
    // printf("%c -> %c (%3d)", c, flag[i], flag[i]);
    
    int div = 0;
    while ((unsigned char)flag[i] > m) {
      ++div;
      flag[i] -= s;
    }
    // printf(" -> %c (%d)", flag[i], div);
    fprintf(data, "%c", div + d);
    // putchar('\n');
  }

  fclose(data);
}

int main() {
  FILE* flag_file = fopen("flag.txt", "r");
  char* flag = malloc(400 + 4);
  fgets(flag, 400 + 1, flag_file);
  fclose(flag_file);
  int flag_len = strlen(flag);
  // printf("flag_len: %d\n", flag_len);

  char* key = (char*)malloc(flag_len + 4);
  printf("Pleasee~ gimme the car key 🥺\n> ");
  scanf("%s", key);
  if (strlen(key) != 8) {
    perror("nuh uh, wroonggg!!!!11\n");
    return 1;
  }

  extendkey(key, flag_len);

  encrypt(flag, key, flag_len);

  FILE* output = fopen("output", "w");
  for (int i = 0; i < flag_len; ++i) {
    fprintf(output, "%c", flag[i]);
  }

  return 0;
}
