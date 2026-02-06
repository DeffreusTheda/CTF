#include <defs.h>
#include <stdio.h>

char byte_2120[] = {0x42, 0x37, 0x13, 0x99, 0xAA, 0x55, 0x6F, 0x1, 0x23, 0x77, 0x88, 0x10, 0x0, 0x0, 0x0, 0x0};
char byte_2130[] = {4, 0x70, 0x47, 0xDC, 0xD1, 0x1D, 0x6, 0x65, 0x47, 0x12, 0xE6, 0x4F, 0x4D, 0x23, 0x43, 0x7B, 0x0C6, 0x0EC, 0x39, 0x0E, 0x66, 0x5E};

void sub_1260()
{
  char v0; // si
  unsigned __int64 v1; // rcx
  char v2; // al
  __int128 v4; // [rsp+0h] [rbp-98h] BYREF
  __int128 v5; // [rsp+10h] [rbp-88h]
  __int128 v6; // [rsp+20h] [rbp-78h]
  __int128 v7; // [rsp+30h] [rbp-68h]
  __int128 v8; // [rsp+40h] [rbp-58h]
  __int128 v9; // [rsp+50h] [rbp-48h]
  __int128 v10; // [rsp+60h] [rbp-38h]
  __int128 v11; // [rsp+70h] [rbp-28h]
  unsigned __int64 v12; // [rsp+88h] [rbp-10h]

  v0 = 4;
  v1 = 0;
  // v12 = __readfsqword(0x28u);
  v4 = 0;
  v2 = 66;
  v5 = 0;
  v6 = 0;
  v7 = 0;
  v8 = 0;
  v9 = 0;
  v10 = 0;
  v11 = 0;
  while ( 1 )
  {
    *((_BYTE *)&v4 + v1++) = v2 ^ v0;
    if ( v1 == 22 )
      break;
    v0 = byte_2130[v1];
    v2 = byte_2120[v1 % 0xD];
  }
  BYTE6(v5) = 0;
  printf("Good. Here's the flag: %s\n", (const char *)&v4);
  // return v12 - __readfsqword(0x28u);
}

int main() {
  sub_1260();
}
