Decompile it with Ghidra!
Auto-analysis!
BAM, you're on the `entry`!

```
undefined8 entry(void) {
  char input [104];
  
  _printf("Crackme Level 0x03 (created by Nox)\n");
  _printf("\nEnter the passcode: ");
  _scanf("%99s",input);
  check(input);
}
```

It takes at most 99 character of string as input,
and pass it to the function `check`.

```
void check(char *arg) {
  size_t input_len;
  int sum;
  int i;
  int digit;
  char c;
  char *passcode;
  
  i = 0;
  sum = 0;
  passcode = arg;
  input_len = _strlen(arg);
  for (; i < (int)input_len; i = i + 1) {
    c = passcode[i];
    _sscanf(&c,"%d",&digit);
    sum = digit + sum;
  }
  if (sum == 15) {
    success(passcode);
    _exit(0);
  }
  _puts("Invalid passcode.\n");
  return;
}
```

What this essentially does is takes each character as an integer digit,
and adds them up, then compare it to `15`.
If the sum is `15`, then it's correct, and that should print the passcode!
It doesn't matter how long is your input,
as long as the sum is `15`, it's valid!

```
./crackme0x03
Crackme Level 0x03 (created by Nox)

Enter the passcode: 78
78 is a valid passcode.

> ./crackme0x03
Crackme Level 0x03 (created by Nox)

Enter the passcode: 555
555 is a valid passcode.
```

For that 99 maximum length, here's a demonstration:

```
./crackme0x03
Crackme Level 0x03 (created by Nox)

Enter the passcode: 0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000078
Invalid passcode.

~ ./crackme0x03
Crackme Level 0x03 (created by Nox)

Enter the passcode: 000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000078 
000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000078 is a valid passcode.
```
