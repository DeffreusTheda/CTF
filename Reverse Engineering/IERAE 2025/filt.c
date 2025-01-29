#include "defs.h"
#include <stdio.h>

__int64 __fastcall sub_12DB(char a1)
{
  if ( a1 > 96 && a1 <= 109 || a1 > 64 && a1 <= 77 )
    return (unsigned int)(unsigned __int8)a1 + 13;
  if ( (a1 <= 109 || a1 > 122) && (a1 <= 77 || a1 > 90) )
    return (unsigned __int8)a1;
  return (unsigned int)(unsigned __int8)a1 - 13;
}

int main() {
  for (char c = ' '; c <= '~'; c++) {
    printf("%c -> %c\n", c, (char)sub_12DB(c));
  }
}
