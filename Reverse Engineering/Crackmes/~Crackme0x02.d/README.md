Again,

```
undefined8 entry(void)

{
  int local_10 [2];
  
  local_10[1] = 0;
  _printf("Crackme Level 0x02 (created by Nox)\n");
  _printf("\nEnter the passphrase: ");
  _scanf("%99d",local_10);
  _check(local_10[0],14478);
  return 1;
}
```

It's... the same as previous?
Yeah...

```
> ./crackme0x02
Crackme Level 0x02 (created by Nox)

Enter the passphrase: 14478

The password is correct!!
```
