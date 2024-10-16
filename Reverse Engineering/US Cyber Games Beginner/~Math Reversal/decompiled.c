/* This file was generated by the Hex-Rays decompiler version 8.4.0.240320.
   Copyright (c) 2007-2021 Hex-Rays <info@hex-rays.com>

   Detected compiler: GNU C++
*/

#include <defs.h>


//-------------------------------------------------------------------------
// Function declarations

__int64 (**init_proc())(void);
void sub_1020();
// int puts(const char *s);
// size_t strlen(const char *s);
// int printf(const char *format, ...);
// int __fastcall _cxa_finalize(void *);
void __fastcall __noreturn start(__int64 a1, __int64 a2, void (*a3)(void));
void *deregister_tm_clones();
__int64 register_tm_clones();
void *_do_global_dtors_aux();
__int64 frame_dummy(); // weak
_BOOL8 __fastcall checkflag(const char *a1);
int __fastcall main(int argc, const char **argv, const char **envp);
void term_proc();
// int __fastcall _libc_start_main(int (__fastcall *main)(int, char **, char **), int argc, char **ubp_av, void (*init)(void), void (*fini)(void), void (*rtld_fini)(void), void *stack_end);
// int __fastcall __cxa_finalize(void *);
// __int64 _gmon_start__(void); weak

//-------------------------------------------------------------------------
// Data declarations

void *_dso_handle = &_dso_handle; // idb
_DWORD flagCheck[31] = { 45, 55, 42, 62, 57, 46, 5, 10, 77, 14, 7, 33, 28, 79, 26, 26, 79, 29, 11, 20, 12, 33, 16, 31, 13, 13, 9, 80, 14, 28, 3 }; // weak
char _bss_start; // weak
_UNKNOWN end; // weak


//----- (0000000000001000) ----------------------------------------------------
__int64 (**init_proc())(void)
{
  __int64 (**result)(void); // rax

  result = &_gmon_start__;
  if ( &_gmon_start__ )
    return (__int64 (**)(void))_gmon_start__();
  return result;
}
// 4118: using guessed type __int64 _gmon_start__(void);

//----- (0000000000001020) ----------------------------------------------------
void sub_1020()
{
  JUMPOUT(0LL);
}
// 1026: control flows out of bounds to 0

//----- (0000000000001070) ----------------------------------------------------
// positive sp value has been detected, the output may be wrong!
void __fastcall __noreturn start(__int64 a1, __int64 a2, void (*a3)(void))
{
  __int64 v3; // rax
  int v4; // esi
  __int64 v5; // [rsp-8h] [rbp-8h] BYREF
  char *retaddr; // [rsp+0h] [rbp+0h] BYREF

  v4 = v5;
  v5 = v3;
  _libc_start_main((int (__fastcall *)(int, char **, char **))main, v4, &retaddr, 0LL, 0LL, a3, &v5);
  __halt();
}
// 1076: positive sp value 8 has been found
// 107D: variable 'v3' is possibly undefined

//----- (00000000000010A0) ----------------------------------------------------
void *deregister_tm_clones()
{
  return &end;
}

//----- (00000000000010D0) ----------------------------------------------------
__int64 register_tm_clones()
{
  return 0LL;
}

//----- (0000000000001110) ----------------------------------------------------
void *_do_global_dtors_aux()
{
  void *result; // rax

  if ( !_bss_start )
  {
    if ( &__cxa_finalize )
      _cxa_finalize(_dso_handle);
    result = deregister_tm_clones();
    _bss_start = 1;
  }
  return result;
}
// 40DC: using guessed type char _bss_start;

//----- (0000000000001150) ----------------------------------------------------
__int64 frame_dummy()
{
  return register_tm_clones();
}
// 1150: using guessed type __int64 frame_dummy();

//----- (0000000000001159) ----------------------------------------------------
_BOOL8 __fastcall checkflag(const char *a1)
{
  int i; // [rsp+1Ch] [rbp-14h]

  for ( i = 0; i < strlen(a1) && i <= 30; ++i )
  {
    if ( a1[i] + flagCheck[i] != 128 )
      return 0LL;
  }
  return strlen(a1) == 31;
}
// 4060: using guessed type _DWORD flagCheck[31];

//----- (00000000000011EE) ----------------------------------------------------
int __fastcall main(int argc, const char **argv, const char **envp)
{
  if ( argc == 2 )
  {
    if ( checkflag(argv[1]) )
      printf("%s was the correct flag\n", argv[1]);
    else
      puts("nope!");
    return 0;
  }
  else
  {
    puts("put in a flag guess");
    return 1;
  }
}

//----- (000000000000126C) ----------------------------------------------------
void term_proc()
{
  ;
}

// nfuncs=20 queued=10 decompiled=10 lumina nreq=0 worse=0 better=0
// ALL OK, 10 function(s) have been successfully decompiled

