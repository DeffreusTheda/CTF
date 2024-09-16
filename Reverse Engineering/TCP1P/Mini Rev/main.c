#include <stdio.h>
#include <string.h>

void xorMessage(char *a1, char *a2, char *a3) {
  int v8 = strlen(a3);
  for (int i = 0; i < strlen(a2); ++i)
    a1[i] = a3[i % v8] ^ a2[i];
}

int main(int argc, const char **argv) {
  const char *v3 = argv[1];
  char v9[32];
  char v10[32];
  char v11[32];
  char v12[520];

  strcpy(v9, v3);
  xorMessage(v11, v9, v10);
  FILE *file = fopen("enc.txt", "w");
  if (file == NULL)
    return 1;
  fprintf(file, "%s\n", v11);
  fclose(file);
  return 0;
}
