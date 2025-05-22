long long codedChar(int n, char f, char ptr) {
  return (f >> n) & 1 | ptr & 0xFEu;
}

int main(int argc, const char **argv, const char **envp) {
  char ptr;
  char flagBytes[56];
  FILE *flag = fopen("flag.txt", "r");
  FILE *original = fopen("original.bmp", "r");
  FILE *encoded = fopen("encoded.bmp", "a");

  if ( !flag )
    puts("No flag found, please make sure this is run on the server");
  if ( !original )
    puts("No output found, please run this on the server");

  int v6 = fread(&ptr, 1uLL, 1uLL, original);
  for ( int i = 0; i < 723; ++i ) {
    fputc(ptr, encoded);
    v6 = fread(&ptr, 1uLL, 1uLL, original);
  }

  if ( fread(flagBytes, 0x32uLL, 1uLL, flag) <= 0 ) {
    puts("Invalid Flag");
    exit(0);
  }

  for ( int i = 0; i <= 99; ++i ) {
    if ( (i & 1) != 0 ) {
      fputc(ptr, encoded);
      fread(&ptr, 1uLL, 1uLL, original);
    }
    else {
      for ( int i = 0; i <= 7; ++i ) {
        fputc(codedChar(i, flagBytes[i / 2], ptr), encoded);
        fread(&ptr, 1uLL, 1uLL, original);
      }
    }
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
