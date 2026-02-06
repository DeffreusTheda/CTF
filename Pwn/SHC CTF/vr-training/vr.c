
#include <stdio.h>
#include <stdlib.h>
#include <string.h>


void print_pattern() {
  puts("  _____        _____        _____");
  puts(" /     \\      /     \\      /     \\");
  puts("<       >----<       >----<       >");
  puts(" \\_____/      \\_____/      \\_____/");
  puts(" /     \\      /     \\      /     \\");
  puts("<       >----<       >----<       >----.");
  puts(" \\_____/      \\_____/      \\_____/      \\");
  puts("       \\      /     \\      /     \\      /");
  puts("        >----<       >----<       >----<");
  puts("       /      \\_____/      \\_____/      \\_____");
  puts("       \\      /     \\      /     \\      /     \\");
  puts("        `----<       >----<       >----<       >");
  puts("              \\_____/      \\_____/      \\_____/");
  puts("                           /     \\      /");
  puts("                          <       >----'");
  puts("                           \\_____/");
  puts("");
}


void fail() {
  puts("[-] VR Training failed!");
  exit(0);
}

int main() {
  setbuf(stdout, 0);
  print_pattern();

  puts("Welcome to the VR training soldier.");
  puts("Binary Exploitation is an important skillset for members of the Force XXI!");
  puts("[...] We start with Buffer Overflow 10");

  // exploit a stack based buffer overflow
  int value = 0;
  char buffer[64];
  printf("Your input: ");
  fgets(buffer, 100, stdin);

  if(value != 0xdeadbeef) {
   fail();
  }

  // exploit a format string attack
  puts("[+] Good!");
  puts("[...] Next is Format String 10");


  FILE *access_code_file = fopen("access_code", "r");
  char access_code[64];
  fread(access_code, 64, 1, access_code_file);

  char format[64];
  printf("Your input: ");
  fgets(format, 64, stdin);
  printf(format);

  char input_access_code[64];
  printf("Your access code: ");
  fgets(input_access_code, 64, stdin);

  if(strcmp(access_code, input_access_code) != 0) {
    fail();
  }


  puts("[+] Congratulations, you have successfully completed the VR training!");

  FILE *flag_file = fopen("flag", "r");
  char flag[64];
  fread(flag, 64, 1, flag_file);
  printf("[+] Flag: %s\n", flag);
}
