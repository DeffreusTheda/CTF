# Brainrot Song Library Writeup by Deffreus - CompfestCTF 16

###### Author: nabilmuafa

## Description

Little John, a true Gen Alpha, is making his first C program! Well, it’s just a "brainrot song library", though. Complete with nonsense words such as 'skibidi', 'rizz', and 'mewing'...

Anyways, Little John is using his dad’s computer, and we need you to exploit his program so that it can read a hidden file Little John’s dad hid, even if it’s not listed in the program. We don’t know the file name though, so good luck with that! Author: nabilmuafa

`nc challenges.ctf.compfest.id 9008`

## Files

[`chall`]: `ELF 64-bit LSB executable, x86-64, version 1 (SYSV), dynamically linked, interpreter /lib64/ld-linux-x86-64.so.2, BuildID[sha1]=adc9189d4fe4949af1b6205dca4d43acc5825449, for GNU/Linux 3.2.0, not stripped`

## Solution

```
void readFile(void) {
  int iVar1;
  size_t sVar2;
  long in_FS_OFFSET;
  char local_ae;
  char local_ad;
  int local_ac;
  int local_a8;
  int local_a4;
  FILE *local_a0;
  char local_98 [136];
  long local_10;
  
  local_10 = *(long *)(in_FS_OFFSET + 0x28);
  printf("You\'re about to see the contents of %s. Is that correct? (Y/N) ", file_to_open); // first-time: "never-gonna-rizz-you-up.txt"
  __isoc99_scanf("%c",&local_ae);
  do {
    iVar1 = getchar();
  } while (iVar1 != 10);
  if (local_ae == 'N') {
    printf("Input the song file name you want to see: ");
    fgets(local_98,0x40,stdin);
    // s:\n:\0
    sVar2 = strcspn(local_98,"\n");
    local_98[sVar2] = '\0';
    local_ac = 0;
    for (local_a8 = 0; local_a8 < 5; ++local_a8) {
      iVar1 = strcmp(local_98,*(char **)(songList + (long)local_a8 * 8));
      if (iVar1 == 0) {
        local_ac = 1;
        strcpy(file_to_open,local_98);
        break;
      }
    }
    if (local_ac == 0) {
      printf("The song file ");
      printf(local_98); // HERE! FORMAT STRING VULNERABILITY!!
      puts(" is not found.\n");
      goto LAB_0040186c;
    }
  }
  printf("\nHere are the lyrics for %s: \n\n",file_to_open);
  local_a0 = fopen(file_to_open,"r");
  local_a4 = 0;
  do {
    iVar1 = fgetc(local_a0);
    local_ad = (char)iVar1;
    putchar((int)local_ad);
    local_a4 = local_a4 + 1;
    if (local_ad == -1) break;
  } while (local_a4 != 0x80);
  puts("\n");
LAB_0040186c:
  if (local_10 != *(long *)(in_FS_OFFSET + 0x28)) {
                    // WARNING: Subroutine does not return
    __stack_chk_fail();
  }
  return;
}
```

Up to 3 `%s` can be sent.
`songList` is at `0x404060`