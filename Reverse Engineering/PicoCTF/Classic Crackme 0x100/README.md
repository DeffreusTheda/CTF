# Classic Crackme 0x100 Writeup by Deffreus - PicoCTF 2024

```$ file crackme100
crackme100: ELF 64-bit LSB executable, x86-64, version 1 (SYSV), dynamically linked, interpreter /lib64/ld-linux-x86-64.so.2, BuildID[sha1]=1ea93b145c2407916c88a68aa90f0a373edeb42a, for GNU/Linux 3.2.0, with debug_info, not stripped
```
```$ du -h crackme100
20K	crackme100
```

I decompiled the binary with [Decompiler Explorer](https://dogbolt.org/?id=2243297e-b27d-491f-a938-b198c2592853#Hex-Rays=160) into C. The only thing notable here is the `main` function:

```crackme100.c
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
    printf("success! here is your flag: %s\n", "picoctf{sample_flag}");
  else
    puts("failed!");
  return 0;
}
```

Just see it for yourself if you wanna, but as the hint said: "Let the machine figure out the symbols!".
I focus on what I can control here: `input`.
It's a 50 character long string.
I can just try and brute force which character value will result in the output character wanted by the program.
This program will do the job:

```solve.c
#include <string.h>
#include <stdio.h>

int main(int argc, const char **argv, const char **envp) {
  char input[51]; // [rsp+0h] [rbp-A0h] BYREF
  char output[51]; // [rsp+40h] [rbp-60h] BYREF
  int secret1 = 85, secret2 = 51, secret3 = 15;
  char fix = 97;

  strcpy(output, "xjagpediegzqlnaudqfwyncpvkqneusycourkguerjpzcbstcc");
  int len = strlen(output); // 50
	char printables[97];
	strcpy(printables, "`1234567890-=qwertyuiop[]\\asdfghjkl;'zxcvbnm,./~!@#$%^&*()_+QWERTYUIOP{}|ASDFGHJKL:\"ZXCVBNM<>?");

	for ( int i = 0; i < len; ++i ) {
		for ( int j = 0; j <= strlen(printables); ++j ) {
			char num = printables[j];
		  for ( int k = 0; k < 3; ++k ) {
		    int random1 = (secret1 & (i % 255)) + (secret1 & ((i % 255) >> 1));
		    int random2 = (random1 & secret2) + (secret2 & (random1 >> 2));
		    num = ((random2 & secret3) + num - fix + (secret3 & (random2 >> 4))) % 26 + fix;
		  }
			if ( num == output[i] ) {
				printf("%c", printables[j]);
				input[i] = printables[j];
				break;
			}
		}
	}

  return 0;
}
```

"For each index, try every printable character and print that result in output character in that index."

Now let's run the program and see what valid input it'll give!

```$ rgcc solve.c 
xgxamyx`bathferiak`nsetdpbhb\igj`ioiexlslagntpgewt
```

Looks good!

```$ nc titan.picoctf.net 59248
Enter the secret password: xgxamyx`bathferiak`nsetdpbhb\igj`ioiexlslagntpgewt
SUCCESS! Here is your flag: picoCTF{s0lv3_angry_symb0ls_31b29976}
```

The flag is `picoCTF{s0lv3_angry_symb0ls_31b29976}`!
