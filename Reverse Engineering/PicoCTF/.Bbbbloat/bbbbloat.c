#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char* sub_1249(long a1, const char *a2) {
  int v3; // [rsp+14h] [rbp-1Ch]
  size_t i; // [rsp+18h] [rbp-18h]
  char *v5; // [rsp+20h] [rbp-10h]
  size_t v6; // [rsp+28h] [rbp-8h]

  v5 = strdup(a2);
  v6 = strlen(v5);
  for ( i = 0LL; i < v6; ++i ) {
    if ( v5[i] > 32 && v5[i] != 127 ) {
      v3 = v5[i] + 47;
      if ( v3 <= 126 )
        v5[i] = v3;
      else
        v5[i] -= 47;
    }
  }
  return v5;
}

long main(int a1, char **a2, char **a3) {
  int v4; // [rsp+10h] [rbp-40h] BYREF
  int v5; // [rsp+14h] [rbp-3Ch]
  char *s; // [rsp+18h] [rbp-38h]
  char v7[40]; // [rsp+20h] [rbp-30h] BYREF

  strcpy(v7, "A:4@r%uL4Ff0f9b03=_cf0cc7fc2e_N");
  printf("What's my favorite number? ");
  v5 = 863305; // Like...
  __isoc99_scanf("%d", &v4);
  v5 = 863305; // Why?
  if ( v4 == 549255 ) {
    v5 = 863305;
    s = (char *)sub_1249(0LL, v7);
    fputs(s, stdout);
    putchar(10);
    free(s);
  }
  else
    puts("Sorry, that's not it!");
  return 0LL;
}
