Open the thing in Ghidra, do auto-analysis,
and you'll immediately jump to `entry`!
It's not even main :p

```
undefined8 entry(void)

{
  int iVar1;
  char local_88 [107];
  char local_1d [13];
  long local_10;
  
  local_10 = *(long *)PTR____stack_chk_guard_100004000;
  builtin_strncpy(local_1d,"NoxIsTheBest",0xd);
  _printf("Crackme Level 0x00 (created by Nox)\n");
  _printf("\nEnter the passphrase: ");
  _scanf("%99s",local_88);
  iVar1 = _strcmp(local_88,local_1d);
  if (iVar1 == 0) {
    _puts("\nCongrats on cracking the program!!");
  }
  else {
    _puts("\nHmmmm maybe try again.");
  }
  if (*(long *)PTR____stack_chk_guard_100004000 == local_10) {
    return 0;
  }
                    /* WARNING: Subroutine does not return */
  ___stack_chk_fail();
}
```

It just checks if the input is "NoxIsTheBest",
and that's the password for this chall :>
