#include <stdio.h>

int main() {
  long long a, d;
  for (int x = 0; x < 4; ++x) {
    for (int y = 0; y < 4; ++y) {
      for (int z = 0; z < 4; ++z) {
        a = x;
        a *= 5;
        a *= 5;
        a <<= 4;

        d = y;
        d *= 5;
        a += d * 4;

        d = z;
        a += d;
        a <<= 4;

        printf("\n{x:%d,y:%d,z:%d}\n%64llx\n%64llx\n", x, y, z, a, d);
      }
    }
  }
}
