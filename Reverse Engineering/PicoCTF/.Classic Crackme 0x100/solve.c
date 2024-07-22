#include <string.h>
#include <stdio.h>

int main(int argc, const char **argv, const char **envp) {
  char input[51]; // [rsp+0h] [rbp-A0h] BYREF
  char output[51]; // [rsp+40h] [rbp-60h] BYREF
  int secret1 = 85, secret2 = 51, secret3 = 15;
  char fix = 97;

  strcpy(output, "xjagpediegzqlnaudqfwyncpvkqneusycourkguerjpzcbstcc");
  int len = strlen(output); // 50
	char printables[97];
	strcpy(printables, "`1234567890-=qwertyuiop[]\\asdfghjkl;'zxcvbnm,./~!@#$%^&*()_+QWERTYUIOP{}|ASDFGHJKL:\"ZXCVBNM<>?");

	for ( int i = 0; i < len; ++i ) {
		for ( int j = 0; j <= strlen(printables); ++j ) {
			char num = printables[j];
		  for ( int k = 0; k < 3; ++k ) {
		    int random1 = (secret1 & (i % 255)) + (secret1 & ((i % 255) >> 1));
		    int random2 = (random1 & secret2) + (secret2 & (random1 >> 2));
		    num = ((random2 & secret3) + num - fix + (secret3 & (random2 >> 4))) % 26 + fix;
		  }
			if ( num == output[i] ) {
				printf("%c", printables[j]);
				input[i] = printables[j];
				break;
			}
		}
	}

	// int i = 0;
	//  while ( i <= 2 ) {
	//    for ( int i_0 = 0; i_0 < len; ++i_0 ) {
	//      int random1 = (secret1 & (i_0 % 255)) + (secret1 & ((i_0 % 255) >> 1));
	//      int random2 = (random1 & secret2) + (secret2 & (random1 >> 2));
	//      input[i_0] = ((random2 & secret3) + input[i_0] - fix + (secret3 & (random2 >> 4))) % 26 + fix;
	//    }
	//    ++i;
	//  }
	// printf("\n%s == %s -> %d", input, output, memcmp(input, output, len));

  return 0;
}
