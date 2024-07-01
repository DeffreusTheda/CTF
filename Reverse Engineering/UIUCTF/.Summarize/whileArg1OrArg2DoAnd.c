long long whileArg1OrArg2DoAnd(unsigned int a1, unsigned int a2) {
  unsigned int v5; // [rsp+8h] [rbp-10h]
  int v6; // [rsp+Ch] [rbp-Ch]
  int v7; // [rsp+10h] [rbp-8h]
  int v8; // [rsp+14h] [rbp-4h]

  v5 = 0;
  v6 = 0;
  while ( a1 || a2 ) {
    v7 = a1 & 1;
    v8 = a2 & 1;
    a1 >>= 1;
    a2 >>= 1;
    v5 += (v8 & v7) << v6++;
  }
  return v5;
}

int main() {
	int cond = 1;
	while ( cond ) {
		unsigned int arg1, arg2;

		scanf("%u", &arg1);
		scanf("%u", &arg2);
		printf("result: %lld\n", whileArg1OrArg2DoAnd(arg1, arg2));
	}
}
