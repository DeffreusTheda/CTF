#include <stdint.h>
#include <stdio.h>

int main() {
  int32_t x = 1000000000;
  x += 16 * 1234567890;
  printf("%d\n", x);
}
