#include "defs.h"
#include <stdio.h>
#include <time.h>
#include <string.h>
#include <stdlib.h>

char lockers[] = {0x74, 0x68, 0x65, 0x20, 0x73, 0x65, 0x63, 0x72, 0x65, 0x74, 0x20, 0x69, 0x73, 0x20, 0x6F, 0x6E, 0x6C, 0x79, 0x20, 0x61, 0x76, 0x61, 0x69, 0x6C, 0x61, 0x62, 0x6C, 0x65, 0x20, 0x69, 0x6E, 0x20, 0x74, 0x68, 0x65, 0x20, 0x6F, 0x6E, 0x6C, 0x69, 0x6E, 0x65, 0x20, 0x69, 0x6E, 0x73, 0x74, 0x61, 0x6E, 0x63, 0x65, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0x54, 0x68, 0x69, 0x73, 0x20, 0x69, 0x73, 0x20, 0x61, 0x20, 0x64, 0x65, 0x6D, 0x6F, 0x20, 0x6D, 0x65, 0x73, 0x73, 0x61, 0x67, 0x65, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

char * verify_key(const char *a1)
{
  time_t v2; // rbx
  time_t v3; // rbx
  char v4; // [rsp+13h] [rbp-3Dh]
  int i; // [rsp+14h] [rbp-3Ch]
  int j; // [rsp+18h] [rbp-38h]
  int k; // [rsp+1Ch] [rbp-34h]
  int *dest; // [rsp+20h] [rbp-30h]
  _BYTE src[13]; // [rsp+2Bh] [rbp-25h] BYREF
  unsigned __int64 v10; // [rsp+38h] [rbp-18h]

  if ( strlen(a1) == 26 )
  {
    for ( i = 0; i <= 12; ++i )
      sscanf(&a1[2 * i], "%2hhx", &src[i]);
    for ( j = 0; j <= 12; ++j )
      src[j] ^= 0x42u;
    v4 = 0;
    for ( k = 0; k <= 12; ++k ) {
      v4 ^= src[k];
      printf("v4=%d %x\n", v4, v4);
    }
    if ( v4 )
    {
      puts("Invalid key");
      return 0LL;
    }
    else
    {
      dest = (int *)malloc(0xCuLL);
      if ( dest )
      {
        memcpy(dest, src, 12uLL);
        v2 = dest[2];
        if ( v2 >= time(0LL) )
        {
          v3 = dest[1];
          if ( v3 <= time(0LL) )
          {
            if ( (unsigned int)*dest < 2 )
            {
              return &lockers[255 * *dest];
            }
            else
            {
              puts("Invalid locker id");
              free(dest);
              return 0LL;
            }
          }
          else
          {
            printf("v3=%ld %lx\n", v3, v3);
            puts("Time travel is not allowed");
            free(dest);
            return 0LL;
          }
        }
        else
        {
          printf("v2=%ld %lx\n", v2, v2);
          puts("Key expired");
          free(dest);
          return 0LL;
        }
      }
      else
      {
        return 0LL;
      }
    }
  }
  else
  {
    puts("Invalid key length");
    return 0LL;
  }
}

int main() {
  verify_key("43424242f958e325b91ef23243");
}
