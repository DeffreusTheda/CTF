int main(int argc, const char **argv, const char **envp) {
  char input[51]; // [rsp+0h] [rbp-A0h] BYREF
  char output[51]; // [rsp+40h] [rbp-60h] BYREF
  int random2; // [rsp+7Ch] [rbp-24h]
  int random1; // [rsp+80h] [rbp-20h]
  char fix; // [rsp+87h] [rbp-19h]
  int secret3; // [rsp+88h] [rbp-18h]
  int secret2; // [rsp+8Ch] [rbp-14h]
  int secret1; // [rsp+90h] [rbp-10h]
  int len; // [rsp+94h] [rbp-Ch]
  int i_0; // [rsp+98h] [rbp-8h]
  int i; // [rsp+9Ch] [rbp-4h]

  strcpy(output, "xjagpediegzqlnaudqfwyncpvkqneusycourkguerjpzcbstcc");
  setvbuf(_bss_start, 0LL, 2, 0LL);
  printf("Enter the secret password: ");
  __isoc99_scanf("%50s", input);
  i = 0;
  len = strlen(output); // 50
  secret1 = 85;
  secret2 = 51;
  secret3 = 15;
  fix = 97;
  while ( i <= 2 ) {
    for ( i_0 = 0; i_0 < len; ++i_0 ) {
      random1 = (secret1 & (i_0 % 255)) + (secret1 & ((i_0 % 255) >> 1));
      random2 = (random1 & secret2) + (secret2 & (random1 >> 2));
      input[i_0] = ((random2 & secret3) + input[i_0] - fix + (secret3 & (random2 >> 4))) % 26 + fix;
    }
    ++i;
  }
  if ( !memcmp(input, output, len) )
    printf("SUCCESS! Here is your flag: %s\n", "picoCTF{sample_flag}");
  else
    puts("FAILED!");
  return 0;
}
