Do the same as previously...

```
undefined8 entry(void)

{
  int local_10 [2];
  
  local_10[1] = 0;
  _printf("Crackme Level 0x01 (created by Nox)\n");
  _printf("\nEnter the passphrase: ");
  _scanf("%d",local_10);
  if (local_10[0] == 45067) {
    _puts("\nGetting naught are ;]");
  }
  else {
    _puts("\nBetter luck next time.");
  }
  return 0;
}
```

It takes input as an integer,
and checks if that is equals to `45067`.
That's it.
Author is a bit naughty if you, eww,
change that number to hex :/


```
> ./crackme0x01
Crackme Level 0x01 (created by Nox)

Enter the passphrase: 45067

Getting naught are ;]
```
