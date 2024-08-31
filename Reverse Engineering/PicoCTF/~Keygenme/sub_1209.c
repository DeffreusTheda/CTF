#include <md5.h>

long long sub_1209(const char *a1) {
  char v13;
  char v14[72];

  char s[61]; strcpy(s, "picoCTF{br1ng_y0ur_0wn_k3y_");
  size_t v1 = strlen(s); printf("strlen(s): %d\n", v1);
	/* MD5 from 'picoCTF{br1ng_y0ur_0wn_k3y_' */
	char v10[18] = {125, 0, 67, 130, 24, 213, 114, 233, 1, 98, 208, 152, 28, 187, 199, 212, 56, 130}; // strcpy(v10, "}"); MD5(s, v1, &v10[2]);
  size_t v2 = strlen(v10); printf("strlen(v10): %d\n", v2);
	/* MD5 from '}' */
  char v11[16] = {203, 177, 132, 221, 142, 5, 201, 112, 158, 93, 202, 237, 170, 4, 149, 207}; // MD5(v10, v2, v11);

  int v4 = 0;
  for ( int i = 0; i <= 15; ++i ) {
    sprintf(&s[v4 + 32], "%02x", (unsigned short)v10[i + 2]);
    v4 += 2;
  }
  int v5 = 0;
  for ( int i = 0; i <= 15; ++i ) {
    sprintf(&v14[v5], "%02x", (unsigned short)v11[i]);
    v5 += 2;
  }
  for ( int i = 0; i <= 26; ++i )
    v14[i + 32] = s[i];
  v14[59] = s[45];
  v14[60] = s[50];
  v14[61] = v13;
  v14[62] = s[33];
  v14[63] = s[46];
  v14[64] = s[56];
  v14[65] = s[58];
  v14[66] = v13;
  v14[67] = v10[0];

	// for ( int i = 0; i < strlen(v14); ++i )
	// 	printf("s[%d]=%c\n", i, v14[i]);

	long long res = 1LL;
  if ( strlen(a1) != 36 )
    res = 0LL;
  for ( int i = 0; i <= 35; ++i ) {
    if ( a1[i] != v14[i + 32] ) {
      res = 0LL;
			printf("<%d>", v14[i + 32]);
			continue;
		}
		printf("%c", v14[i + 32]);
  }
  return res;
}

int main() {
	printf("\n%lld\n", sub_1209("picoCTF{br1ng_y0ur_0wn_k3y_19236cd2}"));

	return 0;
}
