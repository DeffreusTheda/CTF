#include <stdio.h>

int main() {
  unsigned long long v2; // [rsp+0h] [rbp-38h]
  char v3; // [rsp+10h] [rbp-28h]
  int v4; // [rsp+14h] [rbp-24h]
  unsigned long long v5; // [rsp+18h] [rbp-20h]
  unsigned long long v6; // [rsp+20h] [rbp-18h]

  for ( int a1 = -1; a1 >= -1; a1-=2 ) {
    v2 = a1;
    if ( a1 >= 0 )
      return 0;
    v5 = 0LL;
    while ( v2 ) {
      v4 = v2 & 1;
      v2 >>= 1;
      v6 = v5;
      v3 = 0;
      while ( v6 ) {
        ++v3;
        v6 >>= 1;
      }
      v5 |= (long long)v4 << v3;
    }
    if (a1 == v5)
      printf("TRUE %b\n", a1);
    else printf("%b\n", v5);
  }
}
