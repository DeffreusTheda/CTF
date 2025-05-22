#include "out.h"
int _init(EVP_PKEY_CTX *ctx) {
  int iVar1;
  
  iVar1 = __gmon_start__();
  return iVar1;
}
void FUN_00401020(void) {
  (*(code *)(undefined *)0x0)();
  return;
}
int printf(char *__format,...) {
  int iVar1;
  
  iVar1 = printf(__format);
  return iVar1;
}
int setvbuf(FILE *__stream,char *__buf,int __modes,size_t __n) {
  int iVar1;
  
  iVar1 = setvbuf(__stream,__buf,__modes,__n);
  return iVar1;
}
void FUN_00401080(void) {
  __isoc99_scanf();
  return;
}
void processEntry _start(undefined8 param_1,undefined8 param_2) {
  undefined1 auStack_8 [8];
  
  __libc_start_main(main,param_2,&stack0x00000008,0,0,param_1,auStack_8);
  do {
  } while( true );
}
void _dl_relocate_static_pie(void) {
  return;
}
void deregister_tm_clones(void) {
  return;
}
void register_tm_clones(void) {
  return;
}
void __do_global_dtors_aux(void) {
  if (completed_0 == '\0') {
    deregister_tm_clones();
    completed_0 = 1;
    return;
  }
  return;
}
void frame_dummy(void) {
  register_tm_clones();
  return;
}
void vuln(void) {
  undefined1 local_108 [256];
  
  printf("Good luck!\n>> ");
  FUN_00401080("%256s",local_108);
  printf("Goodbye!\n");
  return;
}
undefined8 main(void) {
  setvbuf(stdin,(char *)0x0,2,0); // _IONBF 2
  setvbuf(stdout,(char *)0x0,2,0);
  setvbuf(stderr,(char *)0x0,2,0);
  vuln();
  return 0;
}
void _fini(void) {
  return;
}
