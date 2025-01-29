#include <stdio.h>

long long crazyMeth(unsigned int a1, unsigned int a2)
{
  unsigned int v5; // [rsp+10h] [rbp-18h]
  char v6; // [rsp+14h] [rbp-14h]
  int v7; // [rsp+18h] [rbp-10h]
  int v8; // [rsp+1Ch] [rbp-Ch]
  long long v9; // [rsp+20h] [rbp-8h]

  v9 = 0LL;
  v5 = 0;
  v6 = 0;
  while ( a1 || a2 ) {
    v7 = a1 & 1;
    v8 = a2 & 1;
    a1 >>= 1;
    a2 >>= 1;
    v9 += (v5 ^ v8 ^ v7) << v6;
    v5 = v5 & v7 | v8 & v7 | v5 & v8;
    ++v6;
  }
  return ((unsigned long long)v5 << v6) + v9;
}

int main() {
	int cond = 1;
	while ( cond ) {
		unsigned int arg1, arg2;

		scanf("%u", &arg1);
		scanf("%u", &arg2);
		printf("result: %lld \n", crazyMeth(arg1, arg2));
	}
}
