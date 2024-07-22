#include <md5.h>

void MD5(char* in, int len, unsigned char* out) {
	MD5Context ctx;
  md5Init(&ctx);
  md5Update(&ctx, in, len);
  md5Finalize(&ctx);
  *out = ctx.digest;
}

long long sub_1209(const char *a1) {
  char v13 = 0; // [rsp+8Dh] [rbp-53h]
  char v14[72]; // [rsp+90h] [rbp-50h] BYREF
	unsigned char* v10[18];
  strcpy(v10, "}");
	unsigned char* v11[16];
  char s[61]; // [rsp+50h] [rbp-90h] BYREF
  strcpy(s, "picoCTF{br1ng_y0ur_0wn_k3y_");

  md5String(s, &v10[2]);
  MD5(v10, strlen(v10), v11);

	for ( int i = 0; i < 16; ++i ) {
		printf("%d ", v11[i]);
	}

  int v4 = 0;
  for ( int i = 0; i <= 15; ++i ) {
    sprintf(&s[v4 + 32], "%02x", v10[i + 2]);
    v4 += 2;
  }
  int v5 = 0;
  for ( int j = 0; j <= 15; ++j ) {
    sprintf(&v14[v5], "%02x", v11[j]);
    v5 += 2;
  }
  for ( int k = 0; k <= 26; ++k ) {
    v14[k + 32] = s[k];
	}
  v14[59] = s[45];
  v14[60] = s[50];
  v14[61] = v13;
  v14[62] = s[33];
  v14[63] = s[46];
  v14[64] = s[56];
  v14[65] = s[58];
  v14[66] = v13;
  v14[67] = v10[0];
	long long res = 1LL;
  if ( strlen(a1) != 36 )
    return 0LL;
  for ( int m = 0; m <= 35; ++m ) {
    if ( a1[m] != v14[m + 32] ) {
			printf("<%c!%c>", a1[m], v14[m + 32]);
      res = 0LL;
			continue;
		}
		printf("%c", v14[m + 32]);
  }
  return res;
}

int main() {
	printf("\n%lld\n", sub_1209("picoCTF{br1ng_y0ur_0wn_k3y_19<!>36cd<!>}"));

	return 0;
}
