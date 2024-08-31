long long flag_index;
void *flag;

long long codedChar(int n, char f, char ptr) {
  return (f >> n) & 1 | ptr & 0xFEu;
}

int encodeDataInFile(const char *a1, const char *a2) {
  char ptr;
  FILE *stream = fopen(a1, L"ra");
  FILE *v6 = fopen(a2, L"a");
  int v11 = fread(&ptr, 1uLL, 1uLL, stream);

  if ( !stream ) {
    puts("No output found, please run this on the server");
    exit(0);
  }

  for ( int i = 0; i < 2019; ++i ) {
    fputc(ptr, v6);
    v11 = fread(&ptr, 1uLL, 1uLL, stream);
  }
  for ( int i = 0; i <= 49; ++i ) {
    if ( i % 5 ) {
      fputc(ptr, v6);
      fread(&ptr, 1uLL, 1uLL, stream);
			continue;
    }
    for ( int n = 0; n <= 7; ++n ) {
      fputc(codedChar(n, *((_BYTE *)flag + *(int *)flag_index), ptr), v6);
      fread(&ptr, 1uLL, 1uLL, stream);
    }
    ++*(_DWORD *)flag_index;
  }
  while ( v11 == 1 ) {
    fputc(ptr, v6);
    v11 = fread(&ptr, 1uLL, 1uLL, stream);
  }

  fclose(v6);

  return fclose(stream);
}

long long encodeAll() {
  long long result = 0x622E31306D657449LL;
  long long v1[2];
  _WORD v3[8];
  strcpy((char *)v3, "Item01_cp.bmp");
  v3[7] = 0;
  int v4 = 0;
  v1[0] = 0x622E31306D657449LL;
  v1[1] = 28781LL;

  for ( unsigned char i = 53; (char)i > 48; --i ) { // 53 - 49 (5)
    BYTE5(v1[0]) = i;
    HIBYTE(v3[2]) = i;
    encodeDataInFile((const char *)v1, (const char *)v3);
    result = (unsigned int)i - 1;
  }

  return result;
}

int main(int argc, const char **argv, const char **envp) {
  char v5;
  flag = &v5;
  int v4 = 0;
  flag_index = (long long)&v4;

  FILE *stream = fopen("flag.txt", L"ra");
  if ( !stream )
    puts("No flag found, please make sure this is run on the server");
  if ( fread(flag, 0x32uLL, 1uLL, stream) <= 0 ) {
    puts("Invalid Flag");
    exit(0);
  }
  fclose(stream);

  encodeAll();

  return 0;
}
