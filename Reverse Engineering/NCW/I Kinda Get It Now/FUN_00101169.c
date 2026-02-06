#include <stdio.h>

int main() {
  char buf[] = "{fak3_fl4g}";
  for (long i = 0; i < 15; i++) {
    printf("%d, ", buf[i]);
    *(char *)(buf + i) = (*(char *)(buf + i) + i) % 0xFF;
  }
  printf("\n");
  for (long i = 0; i < 15; ++i) {
    *(char *)(buf + i) -= i;
    printf("%d, ", buf[i]);
  }
  printf("\n");
}
