int main(int argc, const char **argv, const char **envp) {
  char v5 = ptr[3];
  char ptr[40];
  FILE *stream = fopen("flag.txt", "r");
  FILE *v12 = fopen("mystery.png", "a");
  FILE *v13 = fopen("mystery2.png", "a");
  FILE *v14 = fopen("mystery3.png", "a");

  if ( !stream )
    puts("No flag found, please make sure this is run on the server");
  if ( !v12 )
    puts("mystery.png is missing, please run this on the server");

  fread(ptr, 0x1AuLL, 1uLL, stream);
  fputc(ptr[1], v14);
  fputc((char)(ptr[0] + 21), v13);
  fputc(ptr[2], v14);
  fputc(ptr[5], v14);
  fputc(ptr[4], v12);
  for ( int i = 6; i <= 9; ++i ) {
    ++v5;
    fputc(ptr[i], v12);
  }
  fputc(v5, v13);
  for ( int i = 10; i <= 14; ++i )
    fputc(ptr[i], v14);
  for ( int i = 15; i <= 25; ++i )
    fputc(ptr[i], v12);
  fclose(v12);
  fclose(stream);
}
