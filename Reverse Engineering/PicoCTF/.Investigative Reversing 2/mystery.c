long long codedChar(int n, char f, char ptr) {
  return (f >> n) & 1 | ptr & 0xFEu;
}

int main(int argc, const char **argv, const char **envp) {
  char ptr;
  FILE *original = fopen("original.bmp", "r");
  int v6 = fread(&ptr, 1uLL, 1uLL, original);
  FILE *flag = fopen("flag.txt", "r");
  FILE *encoded = fopen("encoded.bmp", "a");
  char flagBytes[56];

  if ( !flag )
    puts("No flag found, please make sure this is run on the server");
  if ( !original )
    puts("original.bmp is missing, please run this on the server");
  if ( fread(flagBytes, 0x32uLL, 1uLL, flag) <= 0 ) {
    puts("flag is not 50 chars");
    exit(0);
  }

  for ( int i = 0; i < 2000; ++i ) {
    fputc(ptr, encoded);
    v6 = fread(&ptr, 1uLL, 1uLL, original);
  }
  for ( int i = 0; i <= 49; ++i )
    for ( int n = 0; n <= 7; ++j ) {
      fputc(codedChar(n, flagBytes[i] - 5, ptr), encoded);
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
