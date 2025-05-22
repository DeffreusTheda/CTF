#include <stdio.h>

typedef char (*func_ptr)(char, char);

char _pusing(char param_1,char param_2) {
  char bVar1;
  char local_20;
  char local_1c;
  
  local_20 = param_2;
  local_1c = param_1;
  while (local_20 != 0) {
    bVar1 = local_1c & local_20;
    local_1c = local_1c ^ local_20;
    local_20 = bVar1 * 2;
  }
  return local_1c;
}

char _geram_sekali_aduhai(char param_1) {
  unsigned int local_10;
  unsigned int local_9;
  
  local_9 = 0;
  for (local_10 = 0; local_10 < 8; local_10 = local_10 + 1) {
    local_9 = local_9 | (((int)(unsigned int)param_1 >> ((char)local_10 & 0x1f) & 1U) == 0) <<
                        ((char)local_10 & 0x1f);
  }
  return local_9;
}

char _grrr(char param_1,char param_2) {
  char bVar1;
  char local_20;
  char local_1c;
  
  local_1c = param_1;
  for (local_20 = param_2; local_20 != 0; local_20 = (bVar1 & local_20) * '\x02') {
    bVar1 = _geram_sekali_aduhai(local_1c);
    local_1c = local_1c ^ local_20;
  }
  return local_1c;
}

char _charcoal(char param_1,char param_2) {
  char bVar1;
  unsigned int local_20;
  unsigned int local_1c;
  char local_9;
  
  local_9 = 0;
  local_1c = param_1;
  for (local_20 = param_2; local_20 != 0; local_20 = local_20 >> 1) {
    bVar1 = local_1c;
    if ((local_20 & 1) == 0) {
      bVar1 = 0;
    }
    local_9 = _pusing(local_9,bVar1);
    local_1c = local_1c << 1;
  }
  // printf("charcoal");
  return local_9;
}

char target[] = {0x47, 0x7f, 0xe9, 0xbf, 0x87, 0xfb, 0x53, 0xc3, 0x83, 0xe6, 0xf7, 0xde, 0xc6, 0x4c, 0xa8, 0x3f, 0x2b, 0x6e, 0xb0, 0xcc, 0x1a, 0xbb, 0xc3, 0xef, 0x9a, 0x3e, 0x77, 0xaa, 0x05, 0xc1, 0x5c, 0xef};
char key[] = {0xe0, 0x10, 0x35, 0xa0, 0x65, 0xdf, 0x57, 0x1d, 0xef, 0x68, 0x95, 0x96, 0x9d, 0x17, 0xb9, 0xcd, 0xae, 0x08, 0xbf, 0x2b, 0x9d, 0x49, 0x1d, 0x75, 0xd5, 0xf5, 0x05, 0x7d, 0xb2, 0x4c, 0xe9, 0x7c};
func_ptr func_array[] = {_pusing, _pusing, _charcoal, _grrr, _charcoal, _charcoal, _charcoal, _charcoal, _grrr, _grrr, _pusing, _grrr, _grrr, _grrr, _grrr, _pusing, _pusing, _pusing, _grrr, _charcoal, _charcoal, _pusing, _charcoal, _grrr, _grrr, _pusing, _pusing, _charcoal, _pusing, _pusing, _pusing, _pusing};

func_ptr func(size_t idx) {
  return func_array[idx];
}

int main() {
  int map[32];
  char flag[33];

  map[28] = 0;
  map[9] = 1;
  map[25] = 2;
  map[4] = 3;
  map[24] = 4;
  map[20] = 5;
  map[17] = 6;
  map[29] = 7;
  map[31] = 8;
  map[12] = 9;
  map[14] = 10;
  map[11] = 11;
  map[5] = 12;
  map[23] = 13;
  map[22] = 14;
  map[13] = 15;
  map[1] = 16;
  map[19] = 17;
  map[2] = 18;
  map[3] = 19;
  map[0] = 20;
  map[18] = 21;
  map[6] = 22;
  map[30] = 23;
  map[7] = 24;
  map[10] = 25;
  map[26] = 26;
  map[15] = 27;
  map[27] = 28;
  map[21] = 29;
  map[8] = 30;
  map[16] = 31;
  
  for (int i = 0; i < 32; ++i) {
    func_ptr function = func(i);
    // printf("%x of ", function);
    for (char g = 0; g < 127; ++g) {
      if (function(g, key[i]) == target[i]) {
        flag[map[i]] = g;
      }
    }
    // putchar(10);
  }

  for (int i = 0; i < 32; ++i) {
    printf("%c", flag[i]);
  }
}
