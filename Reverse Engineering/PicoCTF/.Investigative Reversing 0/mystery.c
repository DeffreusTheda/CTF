int main(int argc, const char **argv, const char **envp) {
  FILE *stream; // [rsp+10h] [rbp-40h]
  FILE *v8; // [rsp+18h] [rbp-38h]
  char ptr[40]; // [rsp+20h] [rbp-30h] BYREF

  stream = fopen("flag.txt", "r");
  v8 = fopen("mystery.png", "a");
  if ( !stream )
    puts("No flag found, please make sure this is run on the server");
  if ( !v8 )
    puts("mystery.png is missing, please run this on the server");
  if ( (int)fread(ptr, 0x1AuLL, 1uLL, stream) <= 0 )
    exit(0);
  puts("at insert");
  fputc(ptr[0], v8);
  fputc(ptr[1], v8);
  fputc(ptr[2], v8);
  fputc(ptr[3], v8);
  fputc(ptr[4], v8);
  fputc(ptr[5], v8);
  for ( int i = 6; i <= 14; ++i )
    fputc((char)(ptr[i] + 5), v8);
  fputc((char)(ptr[15] - 3), v8);
  for ( int i = 16; i <= 25; ++i )
    fputc(ptr[i], v8);
  fclose(v8);
  fclose(stream);
}
