#include "defs.h"
#include <string.h>
#include <stdio.h>
#include <math.h>

void solve();

__int64 right_bitwise_rotation(unsigned __int8 a1, char a2)
{
  return ((int)a1 >> (a2 & 7)) | (a1 << (8 - (a2 & 7)));
}
// right_bitwise_rotation
__int64 left_bitwise_rotation(unsigned __int8 a1, char a2)
{
  return (a1 << (a2 & 7)) | (unsigned int)((int)a1 >> (8 - (a2 & 7)));
}
__int64 rot13(char a1)
{
  if ( a1 > 96 && a1 <= 109 || a1 > 64 && a1 <= 77 )
    return (unsigned int)(unsigned __int8)a1 + 13;
  if ( (a1 <= 109 || a1 > 122) && (a1 <= 77 || a1 > 90) )
    return (unsigned __int8)a1;
  return (unsigned int)(unsigned __int8)a1 - 13;
}

unsigned int __ROL4__(int val, char bits) {
  return (val << bits % 32) & ((unsigned int)pow(2, 32) - 1) | ((val & ((unsigned int)pow(2, 32) - 1)) >> (32 - (bits % 32)));
}
unsigned int __ROR4__(int val, char bits) {
  return ((val & ((unsigned int)pow(2, 32) - 1)) >> bits % 32) | (val << (32 - (bits % 32)) & ((unsigned int)pow(2, 32) - 1));
}

__int64 rol4(int a1, char a2)
{
  return (unsigned int)__ROL4__(a1, a2 & 0x1F);
}
__int64 ror4(int a1, char a2)
{
  return (unsigned int)__ROR4__(a1, a2 & 0x1F);
}
__int64 take_number(int a1)
{
  unsigned int v2; // [rsp+4h] [rbp-4h]
  unsigned int v3; // [rsp+4h] [rbp-4h]
  unsigned int v4; // [rsp+4h] [rbp-4h]

  v2 = -1700506385 * (rol4((unsigned int)(-396357609 * a1), 13LL) ^ (-396357609 * a1));
  v3 = -1454520113 * (ror4(v2, 5LL) ^ v2);
  v4 = -633224058 * (rol4(v3, 24LL) ^ v3);
  return (unsigned int)ror4(v4, 17LL) ^ v4;
}

size_t encrypt(const char *a1, __int64 a2)
{
  __int64 endIdx; // rax
  size_t result; // rax
  char first; // [rsp+19h] [rbp-57h]
  char v5; // [rsp+1Ah] [rbp-56h]
  unsigned __int8 rot13d; // [rsp+1Bh] [rbp-55h]
  int rot; // [rsp+1Ch] [rbp-54h]
  unsigned int v8; // [rsp+20h] [rbp-50h]
  unsigned int v9; // [rsp+24h] [rbp-4Ch]
  size_t i; // [rsp+28h] [rbp-48h]
  unsigned __int64 rot_1; // [rsp+30h] [rbp-40h]
  size_t j; // [rsp+38h] [rbp-38h]
  unsigned __int64 k; // [rsp+40h] [rbp-30h]
  unsigned __int64 m; // [rsp+48h] [rbp-28h]
  unsigned __int64 n; // [rsp+50h] [rbp-20h]
  size_t ii; // [rsp+58h] [rbp-18h]
  size_t len; // [rsp+60h] [rbp-10h]

  len = strlen(a1);
  rot = 0;
  for ( i = 0LL; i < len; ++i )
  {
    rot13d = rot13(a1[i]);                      // rot13
    rot = (rot + 4) % 7 + 1;                    // 1-7
    if ( (i & 1) != 0 )
      first = right_bitwise_rotation(rot13d, rot);// odd
    else
      first = left_bitwise_rotation(rot13d, rot);// even
    *(_BYTE *)(i + a2) = first;
  }
  rot_1 = 0LL;                                  // left chars shift by rot_1
  for ( j = 0LL; j < len; j += 8LL )
  {
    endIdx = len - j;
    if ( len - j > 8 )
      endIdx = 8LL;
    rot_1 = (rot_1 + 3) % 7 + 1;
    for ( k = 0LL; k < rot_1; ++k )             // left shift chars
    {
      v5 = *(_BYTE *)(a2 + j);
      for ( m = 0LL; m < endIdx - 1; ++m )      // 0 to just before last
        *(_BYTE *)(m + j + a2) = *(_BYTE *)(j + m + 1 + a2);
      *(_BYTE *)(a2 + j + endIdx - 1) = v5;
    }
  }
  v8 = 0;
  for ( n = 0LL; n <= 3; ++n )                  // first 4 chars ("IERA")
    v8 |= (unsigned __int8)a1[n] << (8 * n);    // into a number (lil endian)
  v9 = take_number(v8);                         // 465499596
  for ( ii = 0LL; ; ++ii )
  {
    result = ii;
    if ( ii >= len )
      break;
    *(_BYTE *)(a2 + ii) ^= v9;
    v9 = take_number(v9);
  }
  return result;
}

int main() {
  size_t result;
  size_t strlen = 9;
  char* a2 = "";
  
  char* format = "IERAE{";
  unsigned int v8 = 0;
  for (unsigned __int64 n = 0LL; n <= 3; ++n )                  // first 4 chars
    v8 |= (unsigned __int8)format[n] << (8 * n);    // into a number (lil endian)
  unsigned int v9 = take_number(v8); // this function is complex, but just dynamically run it!
  printf("%u\n", v9);
  for (size_t ii = 0LL; ; ++ii )
  {
    result = ii;
    if ( ii >= strlen )
      break;
    // *(_BYTE *)(a2 + ii) ^= v9;
    v9 = take_number(v9);
  }
  return result;
}

void solve() {
  FILE* fenc = fopen("flag.enc", "rb");
  char[90] flag;
  fgets(flag, 88, fenc);
  unsigned int xor_key = 465499596;
  size_t len = 88;
  for (int i = 0; i <= len; i++) {
    flag[i] ^= xor_key;
    xor_key = take_number(xor_key);
    
  }
}
