#include <stdio.h>

int enc(unsigned int key, char* text, size_t len, char* result) {
  int count = 0;
  for (int i = 0; ; i++) {
    count = i;
    if (i >= len) {
      break;
    }
    key = 1023 * key - 0x1337FACE;
    result[i] = (char)(((text[i] - (key>>19))^(key>>11))-(key>>3));
  }
  return count;
}

void list_connection() {
  FILE* f = fopen("/proc/net/tcp", "r");
}
