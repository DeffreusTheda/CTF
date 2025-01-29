#include <stdio.h>
#include <stdint.h>
#include <string.h>

uint32_t rol4(uint32_t val, int bits) {
  bits %= 32;
  return (val << bits) | (val >> (32 - bits));
}

uint32_t ror4(uint32_t val, int bits) {
  bits %= 32;
  return (val >> bits) | (val << (32 - bits));
}

uint32_t take_number(uint32_t a1) {
  uint32_t v2 = (uint32_t)((int64_t)-1700506385 * (rol4((uint32_t)((int64_t)-396357609 * a1), 13) ^ (uint32_t)((int64_t)-396357609 * a1)));
  uint32_t v3 = (uint32_t)((int64_t)-1454520113 * (ror4(v2, 5) ^ v2));
  uint32_t v4 = (uint32_t)((int64_t)-633224058 * (rol4(v3, 24) ^ v3));
  return ror4(v4, 17) ^ v4;
}

unsigned char left_bitwise_rotation(unsigned char byte, int bits) {
  bits %= 8;
  return (byte << bits) | (byte >> (8 - bits));
}

unsigned char right_bitwise_rotation(unsigned char byte, int bits) {
  bits %= 8;
  return (byte >> bits) | (byte << (8 - bits));
}

unsigned char rot13(unsigned char c) {
  if ((c >= 'a' && c <= 'm') || (c >= 'A' && c <= 'M')) return c + 13;
  if ((c >= 'n' && c <= 'z') || (c >= 'N' && c <= 'Z')) return c - 13;
  return c;
}

void hex_to_bytes(const char* hex, unsigned char* bytes, size_t len) {
  for (size_t i = 0; i < len; i++) {
    sscanf(hex + 2 * i, "%2hhx", &bytes[i]);
  }
}

int main() {
  // xxd -p
  const char* hex_str = "e9f2e5b941b3cf57bd53324a191af54595217aeb3862924bc8aec9826240a421726fa2a3da7527a01b47354552b33f45acb3ddbde97c6bcd00b6bc1c3baeda92b2babef2d24dcfa6a5f3e746dbc5fe7415ca5c2e654e3608";
  size_t len = 88;
  unsigned char bytes[88];
  hex_to_bytes(hex_str, bytes, len);

  // xors
  uint32_t v8 = 0x41524549; // it takes first 4 chars, which is format. do dynamic analysis.
  uint32_t v9 = take_number(v8);
  for (size_t i = 0; i < len; i++) {
    bytes[i] ^= (v9 & 0xFF);
    v9 = take_number(v9);
  }

  // left rotate chars crazyyyy
  int rot_1 = 0;
  for (int block = 0; block < 11; block++) {
    rot_1 = (rot_1 + 3) % 7 + 1; 
    size_t start = block * 8;
    unsigned char temp[8];
    for (size_t i = 0; i < 8; i++) {
      size_t src_idx = (i - rot_1 + 8) % 8; 
      temp[i] = bytes[start + src_idx];
    }
    memcpy(bytes + start, temp, 8);
  }

  // yea
  unsigned char original[88];
  int rot = 0;
  for (size_t i = 0; i < len; i++) {
    rot = (rot + 4) % 7 + 1; 
    unsigned char temp;
    if (i % 2 == 0) {
      temp = right_bitwise_rotation(bytes[i], rot); 
    } else {
      temp = left_bitwise_rotation(bytes[i], rot); 
    }
    original[i] = rot13(temp); 
  }

  for (size_t i = 0; i < len; i++) {
    putchar(original[i]);
  }
  printf("\n");

  return 0;
}
