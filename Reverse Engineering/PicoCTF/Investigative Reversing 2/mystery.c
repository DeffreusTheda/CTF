long long codedChar(int a1, char a2, char a3) {
  return (a2 >> a1) & 1 | a3 & 0xFEu;
}

int main(int argc, const char **argv, const char **envp) {
  char ptr;
  FILE *original = fopen("original.bmp", "r");
  int v6 = fread(&ptr, 1uLL, 1uLL, original);
  FILE *flag = fopen("flag.txt", "r");
  FILE *encoded = fopen("encoded.bmp", "a");
  char v16[56];

  if ( !flag )
    puts("No flag found, please make sure this is run on the server");
  if ( !original )
    puts("original.bmp is missing, please run this on the server");
  if ( fread(v16, 0x32uLL, 1uLL, flag) <= 0 ) {
    puts("flag is not 50 chars");
    exit(0);
  }

  for ( int i = 0; i < 2000; ++i ) {
    fputc(ptr, encoded);
    v6 = fread(&ptr, 1uLL, 1uLL, original);
  }
  for ( int i = 0; i <= 49; ++i )
    for ( int j = 0; j <= 7; ++j ) {
      fputc(codedChar(j, v16[i] - 5, ptr), encoded);
      fread(&ptr, 1uLL, 1uLL, original);
    }
  while ( v6 == 1 ) {
    fputc(ptr, encoded);
    v6 = fread(&ptr, 1uLL, 1uLL, original);
  }

  fclose(encoded);
  fclose(original);
  fclose(flag);
  return 0;
}
