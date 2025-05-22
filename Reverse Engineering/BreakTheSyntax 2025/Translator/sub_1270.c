#include "./defs.h"

__int64 sub_1270(unsigned __int8 *a1)
{
  int v1; // edx
  int v3; // ecx
  int v4; // esi
  int v5; // r8d

  v1 = *a1;
  if ( !(_BYTE)v1 )
    return *a1;
  v3 = a1[1];
  if ( !(_BYTE)v3 )
    goto LABEL_6;
  v4 = a1[2];
  if ( !(_BYTE)v4 )
  {
LABEL_5:
    LOBYTE(v3) = (unsigned __int8)v3 >> 4;
    v3 += v4;
LABEL_6:
    LOBYTE(v1) = (unsigned __int8)v1 >> 4;
    return (unsigned int)(v3 + v1);
  }
  v5 = a1[3];
  if ( !(_BYTE)v5 )
  {
    LOBYTE(v4) = (unsigned __int8)v4 >> 4;
    v4 += v5;
    goto LABEL_5;
  }
  return (unsigned int)sub_1270(a1 + 4)
       + ((unsigned __int8)v5 >> 4)
       + ((unsigned __int8)v4 >> 4)
       + ((unsigned __int8)v3 >> 4)
       + ((unsigned __int8)v1 >> 4);
}
