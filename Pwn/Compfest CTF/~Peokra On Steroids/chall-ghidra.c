void main(void) {
  setvbuf(stdout, (char *)0x0, 2, 0);
  setvbuf(stdin,  (char *)0x0, 2, 0);
  setvbuf(stderr, (char *)0x0, 2, 0);
  vuln(); // WARNING: Subroutine does not return
  exit(1);
}

int win(void) {
  int iVar1;
  char s[264];
  long local_10 = *(long *)(in_FS_OFFSET + 0x28);
  
  puts("Semoga masih gampang banged yh");
  FILE *__stream = fopen("flag.txt","r");
  if ( __stream == (FILE *)0x0 ) {
    printf("File flag.txt does not exist! >:(");
    iVar1 = 0x45;
  } else {
    fgets(s, 0x100, __stream);
    iVar1 = puts(s);
  }
  if ( local_10 != *(long *)(in_FS_OFFSET + 0x28) ) {
    __stack_chk_fail(); // WARNING: Subroutine does not return
  }
  return iVar1;
}

int vuln(void) {
  int iVar1;
  long in_FS_OFFSET;
  char buf[24];
  long local_10 = *(long *)(in_FS_OFFSET + 0x28);
  
  char *v4 = buf;
  int v1 = 0;
  puts("Halo, aku Peokra!! Aku bikin program yang bisa nerima input dari kalian.");
  printf("Pertama, masukkan umur kalian untuk disesuaikan sama input (");
  __isoc99_scanf("%d", &v1);
  v4 = v4 + (long)v1 * 4;
  puts("Sekarang input, tapi kalian gak boleh masukin huruf 'n' ya:");
  ssize_t sVar2 = read(0, buf, 0x10);
  v1 = (int)sVar2;
  int v2 = 1;
  int i = 0;
  do {
    if ( v1 - 1 <= i ) { // read() does not return error
LAB_0010144e:
      if ( v2 == 0 ) {
        puts(&DAT_00102138);
        iVar1 = 0;
      } else {
        printf("Kamu menginput: ");
        iVar1 = printf(buf);
      }
      if ( local_10 == *(long *)(in_FS_OFFSET + 0x28) ) {
        return iVar1;
      }
      __stack_chk_fail(); // WARNING: Subroutine does not return
    }
    if ( buf[i] == 'n' ) {
      v2 = 0;
      goto LAB_0010144e;
    }
    ++i;
  } while( true );
}
