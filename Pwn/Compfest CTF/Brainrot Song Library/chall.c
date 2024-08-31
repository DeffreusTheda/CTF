#include "out.h"



int _init(EVP_PKEY_CTX *ctx)

{
  int iVar1;
  
  iVar1 = __gmon_start__();
  return iVar1;
}



void FUN_00401020(void)

{
  (*(code *)(undefined *)0x0)();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int putchar(int __c)

{
  int iVar1;
  
  iVar1 = putchar(__c);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

char * strcpy(char *__dest,char *__src)

{
  char *pcVar1;
  
  pcVar1 = strcpy(__dest,__src);
  return pcVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int puts(char *__s)

{
  int iVar1;
  
  iVar1 = puts(__s);
  return iVar1;
}



void __stack_chk_fail(void)

{
                    // WARNING: Subroutine does not return
  __stack_chk_fail();
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int printf(char *__format,...)

{
  int iVar1;
  
  iVar1 = printf(__format);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int fgetc(FILE *__stream)

{
  int iVar1;
  
  iVar1 = fgetc(__stream);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

size_t strcspn(char *__s,char *__reject)

{
  size_t sVar1;
  
  sVar1 = strcspn(__s,__reject);
  return sVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

char * fgets(char *__s,int __n,FILE *__stream)

{
  char *pcVar1;
  
  pcVar1 = fgets(__s,__n,__stream);
  return pcVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int strcmp(char *__s1,char *__s2)

{
  int iVar1;
  
  iVar1 = strcmp(__s1,__s2);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int getchar(void)

{
  int iVar1;
  
  iVar1 = getchar();
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

long syscall(long __sysno,...)

{
  long lVar1;
  
  lVar1 = syscall(__sysno);
  return lVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int prctl(int __option,...)

{
  int iVar1;
  
  iVar1 = prctl(__option);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

int setvbuf(FILE *__stream,char *__buf,int __modes,size_t __n)

{
  int iVar1;
  
  iVar1 = setvbuf(__stream,__buf,__modes,__n);
  return iVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

FILE * fopen(char *__filename,char *__modes)

{
  FILE *pFVar1;
  
  pFVar1 = fopen(__filename,__modes);
  return pFVar1;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void perror(char *__s)

{
  perror(__s);
  return;
}



void __isoc99_scanf(void)

{
  __isoc99_scanf();
  return;
}



// WARNING: Unknown calling convention -- yet parameter storage is locked

void exit(int __status)

{
                    // WARNING: Subroutine does not return
  exit(__status);
}



void processEntry _start(undefined8 param_1,undefined8 param_2)

{
  undefined auStack_8 [8];
  
  __libc_start_main(main,param_2,&stack0x00000008,0,0,param_1,auStack_8);
  do {
                    // WARNING: Do nothing block with infinite loop
  } while( true );
}



void _dl_relocate_static_pie(void)

{
  return;
}



// WARNING: Removing unreachable block (ram,0x0040129d)
// WARNING: Removing unreachable block (ram,0x004012a7)

void deregister_tm_clones(void)

{
  return;
}



// WARNING: Removing unreachable block (ram,0x004012df)
// WARNING: Removing unreachable block (ram,0x004012e9)

void register_tm_clones(void)

{
  return;
}



void __do_global_dtors_aux(void)

{
  if (completed_0 == '\0') {
    deregister_tm_clones();
    completed_0 = 1;
    return;
  }
  return;
}



void frame_dummy(void)

{
  register_tm_clones();
  return;
}



void setup(void)

{
  int iVar1;
  long lVar2;
  undefined2 local_c8 [4];
  undefined2 *local_c0;
  undefined2 local_b8;
  undefined local_b6;
  undefined local_b5;
  undefined4 local_b4;
  undefined2 local_b0;
  undefined local_ae;
  undefined local_ad;
  undefined4 local_ac;
  undefined2 local_a8;
  undefined local_a6;
  undefined local_a5;
  undefined4 local_a4;
  undefined2 local_a0;
  undefined local_9e;
  undefined local_9d;
  undefined4 local_9c;
  undefined2 local_98;
  undefined local_96;
  undefined local_95;
  undefined4 local_94;
  undefined2 local_90;
  undefined local_8e;
  undefined local_8d;
  undefined4 local_8c;
  undefined2 local_88;
  undefined local_86;
  undefined local_85;
  undefined4 local_84;
  undefined2 local_80;
  undefined local_7e;
  undefined local_7d;
  undefined4 local_7c;
  undefined2 local_78;
  undefined local_76;
  undefined local_75;
  undefined4 local_74;
  undefined2 local_70;
  undefined local_6e;
  undefined local_6d;
  undefined4 local_6c;
  undefined2 local_68;
  undefined local_66;
  undefined local_65;
  undefined4 local_64;
  undefined2 local_60;
  undefined local_5e;
  undefined local_5d;
  undefined4 local_5c;
  undefined2 local_58;
  undefined local_56;
  undefined local_55;
  undefined4 local_54;
  undefined2 local_50;
  undefined local_4e;
  undefined local_4d;
  undefined4 local_4c;
  undefined2 local_48;
  undefined local_46;
  undefined local_45;
  undefined4 local_44;
  undefined2 local_40;
  undefined local_3e;
  undefined local_3d;
  undefined4 local_3c;
  undefined2 local_38;
  undefined local_36;
  undefined local_35;
  undefined4 local_34;
  undefined2 local_30;
  undefined local_2e;
  undefined local_2d;
  undefined4 local_2c;
  undefined2 local_28;
  undefined local_26;
  undefined local_25;
  undefined4 local_24;
  undefined2 local_20;
  undefined local_1e;
  undefined local_1d;
  undefined4 local_1c;
  undefined2 local_18;
  undefined local_16;
  undefined local_15;
  undefined4 local_14;
  undefined2 local_10;
  undefined local_e;
  undefined local_d;
  undefined4 local_c;
  
  setvbuf(stdin,(char *)0x0,2,0);
  setvbuf(stdout,(char *)0x0,2,0);
  setvbuf(stderr,(char *)0x0,2,0);
  local_b8 = 0x20;
  local_b6 = 0;
  local_b5 = 0;
  local_b4 = 0;
  local_b0 = 0x15;
  local_ae = 0x13;
  local_ad = 0;
  local_ac = 0;
  local_a8 = 0x15;
  local_a6 = 0x12;
  local_a5 = 0;
  local_a4 = 1;
  local_a0 = 0x15;
  local_9e = 0x11;
  local_9d = 0;
  local_9c = 2;
  local_98 = 0x15;
  local_96 = 0x10;
  local_95 = 0;
  local_94 = 3;
  local_90 = 0x15;
  local_8e = 0xf;
  local_8d = 0;
  local_8c = 5;
  local_88 = 0x15;
  local_86 = 0xe;
  local_85 = 0;
  local_84 = 8;
  local_80 = 0x15;
  local_7e = 0xd;
  local_7d = 0;
  local_7c = 9;
  local_78 = 0x15;
  local_76 = 0xc;
  local_75 = 0;
  local_74 = 10;
  local_70 = 0x15;
  local_6e = 0xb;
  local_6d = 0;
  local_6c = 0xb;
  local_68 = 0x15;
  local_66 = 10;
  local_65 = 0;
  local_64 = 0xc;
  local_60 = 0x15;
  local_5e = 9;
  local_5d = 0;
  local_5c = 0x11;
  local_58 = 0x15;
  local_56 = 8;
  local_55 = 0;
  local_54 = 0x12;
  local_50 = 0x15;
  local_4e = 7;
  local_4d = 0;
  local_4c = 0x4e;
  local_48 = 0x15;
  local_46 = 6;
  local_45 = 0;
  local_44 = 0xca;
  local_40 = 0x15;
  local_3e = 5;
  local_3d = 0;
  local_3c = 0xd9;
  local_38 = 0x15;
  local_36 = 4;
  local_35 = 0;
  local_34 = 0xe7;
  local_30 = 0x15;
  local_2e = 3;
  local_2d = 0;
  local_2c = 0x101;
  local_28 = 0x15;
  local_26 = 2;
  local_25 = 0;
  local_24 = 0x106;
  local_20 = 0x15;
  local_1e = 1;
  local_1d = 0;
  local_1c = 0x13e;
  local_18 = 6;
  local_16 = 0;
  local_15 = 0;
  local_14 = 0;
  local_10 = 6;
  local_e = 0;
  local_d = 0;
  local_c = 0x7fff0000;
  local_c8[0] = 0x16;
  local_c0 = &local_b8;
  iVar1 = prctl(0x26,1,0,0,0);
  if (iVar1 != 0) {
    perror("prctl(PR_SET_NO_NEW_PRIVS)");
                    // WARNING: Subroutine does not return
    exit(-1);
  }
  lVar2 = syscall(0x13d,1,0,local_c8);
  if (lVar2 != 0) {
    perror("seccomp");
                    // WARNING: Subroutine does not return
    exit(-1);
  }
  return;
}



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
      printf(local_98);
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



void viewSongList(void) {
  puts("🎵 SONG FILE NAME CATALOGUE 🎵");
  puts("1. never-gonna-rizz-you-up.txt (Rick Astley)");
  puts("2. glimpse-of-sigma.txt (Joji)");
  puts("3. mewing-out-loud.txt (Ed Sheeran)");
  puts("4. call-me-mewing.txt (Carly Rae Jepsen)");
  puts("5. skibidi-out.txt (Twenty One Pilots)\n");
  return;
}



undefined8 main(void) {
  int local_c;
  
  setup();
  while( true ) {
    while( true ) {
      puts( "Welcome to Brainrot Song Library!\nWe have a catalogue of brainrot-ified songs\' lyrics you can read." );
      puts("1) View song file name catalogue");
      puts("2) Read song lyrics");
      puts("3) Exit");
      printf("> ");
      __isoc99_scanf("%d", &local_c);
      putchar(10);
      if (local_c != 1)
        break;
      viewSongList();
    }
    if (local_c != 2)
      break;
    readFile();
  }
  puts("Goodbye!");
  return 0;
}



void _fini(void)

{
  return;
}




