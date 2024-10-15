#include "out.h"

undefined8 * FUN_14000532c(undefined8 *param_1,ulonglong param_2) {
  *param_1 = type_info::vftable;
  if ((param_2 & 1) != 0) {
    delete(param_1);
  }
  return param_1;
}

undefined8 * FUN_140005370(undefined8 *param_1,longlong param_2) {
  *param_1 = std::exception::vftable;
  param_1[1] = 0;
  param_1[2] = 0;
  __std_exception_copy(param_2 + 8);
  *param_1 = std::bad_alloc::vftable;
  return param_1;
}

undefined8 * FUN_1400053ac(undefined8 *param_1) {
  param_1[2] = 0;
  param_1[1] = "bad allocation";
  *param_1 = std::bad_alloc::vftable;
  return param_1;
}

undefined8 * FUN_1400053cc(undefined8 *param_1,longlong param_2) {
  *param_1 = std::exception::vftable;
  param_1[1] = 0;
  param_1[2] = 0;
  __std_exception_copy(param_2 + 8);
  *param_1 = std::bad_array_new_length::vftable;
  return param_1;
}

undefined8 * FUN_140005408(undefined8 *param_1) {
  param_1[2] = 0;
  param_1[1] = "bad array new length";
  *param_1 = std::bad_array_new_length::vftable;
  return param_1;
}

// Library Function - Single Match
//  public: __cdecl std::exception::exception(class std::exception const & __ptr64) __ptr64
// 
// Library: Visual Studio 2019 Release

exception * __thiscall std::exception::exception(exception *this,exception *param_1) {
  *(undefined ***)this = vftable;
  *(undefined8 *)(this + 8) = 0;
  *(undefined8 *)(this + 0x10) = 0;
  __std_exception_copy(param_1 + 8);
  return this;
}

void FUN_14000557c(void) {
  undefined8 local_28 [5];
  
  FUN_1400053ac(local_28);
                    // WARNING: Subroutine does not return
  _CxxThrowException(local_28,(ThrowInfo *)&DAT_140029288);
}

void FUN_14000559c(void) {
  undefined8 local_28 [5];
  
  FUN_140005408(local_28);
                    // WARNING: Subroutine does not return
  _CxxThrowException(local_28,(ThrowInfo *)&DAT_140029268);
}

char * FUN_1400055bc(longlong param_1) {
  char *pcVar1;
  
  pcVar1 = "Unknown exception";
  if (*(longlong *)(param_1 + 8) != 0) {
    pcVar1 = *(char **)(param_1 + 8);
  }
  return pcVar1;
}

void FUN_1400055d0(void) {
  code *pcVar1;
  bool bVar2;
  char cVar3;
  int iVar4;
  undefined8 uVar5;
  undefined4 *puVar6;
  ulonglong uVar7;
  undefined7 extraout_var;
  
  _set_app_type(2);
  uVar5 = FUN_140005e1c();
  _set_fmode((int)uVar5);
  uVar5 = FUN_140005e18();
  puVar6 = (undefined4 *)__p__commode();
  *puVar6 = (int)uVar5;
  uVar5 = __scrt_initialize_onexit_tables(1);
  if ((char)uVar5 != '\0') {
    FUN_1400060f8();
    atexit((_func_5014 *)&LAB_140006134);
    uVar7 = FUN_140005e10();
    iVar4 = _configure_narrow_argv(uVar7 & 0xffffffff);
    if (iVar4 == 0) {
      FUN_140005e2c();
      bVar2 = FUN_140005e80();
      if ((int)CONCAT71(extraout_var,bVar2) != 0) {
        __setusermatherr(&LAB_140005e0c);
      }
      FUN_140005e4c();
      FUN_140005e50();
      uVar5 = FUN_140005e28();
      _configthreadlocale((int)uVar5);
      cVar3 = FUN_140005e48();
      if (cVar3 != '\0') {
        _initialize_narrow_environment();
      }
      FUN_140006030();
      uVar5 = thunk_FUN_140006098();
      if ((int)uVar5 == 0) {
        return;
      }
    }
  }
  FUN_140005ea4(7);
  pcVar1 = (code *)swi(3);
  (*pcVar1)();
  return;
}

undefined8 FUN_140005688(void) {
  FUN_140005e64();
  return 0;
}

void FUN_1400056b4(void) {
  __security_init_cookie();
  FUN_1400056c8();
  return;
}

// WARNING: Function: _guard_dispatch_icall replaced with injection: guard_dispatch_icall

int FUN_1400056c8(void) {
  bool bVar1;
  int iVar2;
  undefined8 uVar3;
  longlong *plVar4;
  ulonglong uVar5;
  IMAGE_DOS_HEADER *pIVar6;
  undefined8 unaff_RBX;
  
  iVar2 = (int)unaff_RBX;
  uVar3 = FUN_140005ad0(1);
  if ((char)uVar3 == '\0') {
    FUN_140005ea4(7);
  }
  else {
    bVar1 = false;
    uVar3 = __scrt_acquire_startup_lock();
    iVar2 = (int)CONCAT71((int7)((ulonglong)unaff_RBX >> 8),(char)uVar3);
    if (DAT_14002bd18 != 1) {
      if (DAT_14002bd18 == 0) {
        DAT_14002bd18 = 1;
        iVar2 = _initterm_e(&DAT_14000a288,&DAT_14000a2a0);
        if (iVar2 != 0) {
          return 0xff;
        }
        _initterm(&DAT_14000a270);
        DAT_14002bd18 = 2;
      }
      else {
        bVar1 = true;
      }
      __scrt_release_startup_lock((char)uVar3);
      plVar4 = (longlong *)FUN_140005e8c();
      if ((*plVar4 != 0) && (uVar5 = FUN_140005b98((longlong)plVar4), (char)uVar5 != '\0')) {
        (*(code *)*plVar4)(0);
      }
      plVar4 = (longlong *)FUN_140005e94();
      if ((*plVar4 != 0) && (uVar5 = FUN_140005b98((longlong)plVar4), (char)uVar5 != '\0')) {
        _register_thread_local_exe_atexit_callback(*plVar4);
      }
      __scrt_get_show_window_mode();
      _get_narrow_winmain_command_line();
      pIVar6 = &IMAGE_DOS_HEADER_140000000;
      iVar2 = thunk_FUN_14000818a();
      uVar5 = FUN_140006034();
      if ((char)uVar5 != '\0') {
        if (!bVar1) {
          _cexit();
        }
        __scrt_uninitialize_crt(CONCAT71((int7)((ulonglong)pIVar6 >> 8),1),'\0');
        return iVar2;
      }
      goto LAB_140005829;
    }
  }
  FUN_140005ea4(7);
LAB_140005829:
                    // WARNING: Subroutine does not return
  exit(iVar2);
}

void FUN_14000583c(void) {
  ulonglong uVar1;
  
  uVar1 = FUN_140005e10();
  _configure_narrow_argv(uVar1 & 0xffffffff);
  return;
}

void FUN_140005858(void) {
  __scrt_get_show_window_mode();
  _get_narrow_winmain_command_line();
  thunk_FUN_14000818a();
  return;
}

void FUN_140005890(void) {
  undefined8 uVar1;
  undefined4 *puVar2;
  
  uVar1 = FUN_140005e18();
  puVar2 = (undefined4 *)__p__commode();
  *puVar2 = (int)uVar1;
  return;
}

uint WinMainCRTStartup(void) {
  uint uVar1;
  
  __security_init_cookie();
  uVar1 = FUN_1400056c8();
  return uVar1;
}

void delete(void *_to_object) {
                    // WARNING: Could not recover jumptable at 0x000140007cb9. Too many branches
                    // WARNING: Treating indirect jump as call
  free(_to_object);
  return;
}

// Library Function - Single Match
//  __scrt_acquire_startup_lock
// 
// Libraries: Visual Studio 2015 Release, Visual Studio 2017 Release, Visual Studio 2019 Release

ulonglong __scrt_acquire_startup_lock(void) {
  void *pvVar1;
  bool bVar2;
  undefined7 extraout_var;
  ulonglong uVar4;
  void *pvVar3;
  
  bVar2 = __scrt_is_ucrt_dll_in_use();
  pvVar3 = (void *)CONCAT71(extraout_var,bVar2);
  if ((int)pvVar3 == 0) {
LAB_140005992:
    uVar4 = (ulonglong)pvVar3 & 0xffffffffffffff00;
  }
  else {
    do {
      pvVar3 = (void *)0x0;
      LOCK();
      bVar2 = DAT_14002bd20 == (void *)0x0;
      pvVar1 = StackBase;
      if (!bVar2) {
        pvVar3 = DAT_14002bd20;
        pvVar1 = DAT_14002bd20;
      }
      DAT_14002bd20 = pvVar1;
      UNLOCK();
      if (bVar2) goto LAB_140005992;
    } while (StackBase != pvVar3);
    uVar4 = CONCAT71((int7)((ulonglong)pvVar3 >> 8),1);
  }
  return uVar4;
}

// Library Function - Single Match
//  __scrt_dllmain_after_initialize_c
// 
// Libraries: Visual Studio 2015 Release, Visual Studio 2017 Release, Visual Studio 2019 Release

undefined8 __scrt_dllmain_after_initialize_c(void) {
  bool bVar1;
  undefined7 extraout_var;
  undefined8 uVar2;
  ulonglong uVar3;
  
  bVar1 = __scrt_is_ucrt_dll_in_use();
  if ((int)CONCAT71(extraout_var,bVar1) == 0) {
    uVar3 = FUN_140005e10();
    uVar3 = _configure_narrow_argv(uVar3 & 0xffffffff);
    if ((int)uVar3 != 0) {
      return uVar3 & 0xffffffffffffff00;
    }
    uVar2 = _initialize_narrow_environment();
  }
  else {
    uVar2 = FUN_1400063dc();
  }
  return CONCAT71((int7)((ulonglong)uVar2 >> 8),1);
}

undefined FUN_1400059ec(void) {
  char cVar1;
  
  cVar1 = FUN_140007cc4();
  if (cVar1 != '\0') {
    cVar1 = FUN_140007cc4();
    if (cVar1 != '\0') {
      return 1;
    }
    FUN_140007cc8();
  }
  return 0;
}

// WARNING: Function: _guard_dispatch_icall replaced with injection: guard_dispatch_icall
// Library Function - Single Match
//  __scrt_dllmain_exception_filter
// 
// Libraries: Visual Studio 2017 Release, Visual Studio 2019 Release

void __scrt_dllmain_exception_filter
               (undefined8 param_1,int param_2,undefined8 param_3,undefined *param_4,
               undefined4 param_5,undefined8 param_6) {
  bool bVar1;
  undefined7 extraout_var;
  
  bVar1 = __scrt_is_ucrt_dll_in_use();
  if (((int)CONCAT71(extraout_var,bVar1) == 0) && (param_2 == 1)) {
    (*(code *)param_4)(param_1,0,param_3);
  }
  _seh_filter_dll(param_5,param_6);
  return;
}

ulonglong FUN_140005ad0(int param_1) {
  ulonglong uVar1;
  undefined8 uVar2;
  
  if (param_1 == 0) {
    DAT_14002bd28 = 1;
  }
  FUN_1400063dc();
  uVar1 = FUN_140007cc0();
  if ((char)uVar1 != '\0') {
    uVar2 = FUN_140007cc0();
    if ((char)uVar2 != '\0') {
      return CONCAT71((int7)((ulonglong)uVar2 >> 8),1);
    }
    uVar1 = FUN_140007ccc();
  }
  return uVar1 & 0xffffffffffffff00;
}

// WARNING: Globals starting with '_' overlap smaller symbols at the same address
// Library Function - Single Match
//  __scrt_initialize_onexit_tables
// 
// Library: Visual Studio 2019 Release

undefined8 __scrt_initialize_onexit_tables(uint param_1) {
  code *pcVar1;
  bool bVar2;
  ulonglong in_RAX;
  undefined7 extraout_var;
  undefined8 uVar3;
  
  if (DAT_14002bd29 == '\0') {
    if (1 < param_1) {
      FUN_140005ea4(5);
      pcVar1 = (code *)swi(3);
      uVar3 = (*pcVar1)();
      return uVar3;
    }
    bVar2 = __scrt_is_ucrt_dll_in_use();
    if (((int)CONCAT71(extraout_var,bVar2) == 0) || (param_1 != 0)) {
      in_RAX = 0xffffffffffffffff;
      DAT_14002bd30 = 0xffffffffffffffff;
      uRam000000014002bd38 = 0xffffffffffffffff;
      _DAT_14002bd40 = 0xffffffffffffffff;
      _DAT_14002bd48 = 0xffffffffffffffff;
      uRam000000014002bd50 = 0xffffffffffffffff;
      _DAT_14002bd58 = 0xffffffffffffffff;
    }
    else {
      in_RAX = _initialize_onexit_table(&DAT_14002bd30);
      if (((int)in_RAX != 0) ||
         (in_RAX = _initialize_onexit_table(&DAT_14002bd48), (int)in_RAX != 0)) {
        return in_RAX & 0xffffffffffffff00;
      }
    }
    DAT_14002bd29 = '\x01';
  }
  return CONCAT71((int7)(in_RAX >> 8),1);
}

// WARNING: Removing unreachable block (ram,0x000140005c25)

ulonglong FUN_140005b98(longlong param_1) {
  ulonglong uVar1;
  uint7 uVar2;
  IMAGE_SECTION_HEADER *pIVar3;
  
  uVar1 = 0;
  for (pIVar3 = &IMAGE_SECTION_HEADER_140000208; pIVar3 != (IMAGE_SECTION_HEADER *)&DAT_140000320;
      pIVar3 = pIVar3 + 1) {
    if (((ulonglong)(uint)pIVar3->VirtualAddress <= param_1 - 0x140000000U) &&
       (uVar1 = (ulonglong)((pIVar3->Misc).PhysicalAddress + pIVar3->VirtualAddress),
       param_1 - 0x140000000U < uVar1)) goto LAB_140005c0e;
  }
  pIVar3 = (IMAGE_SECTION_HEADER *)0x0;
LAB_140005c0e:
  if (pIVar3 == (IMAGE_SECTION_HEADER *)0x0) {
    uVar1 = uVar1 & 0xffffffffffffff00;
  }
  else {
    uVar2 = (uint7)(uVar1 >> 8);
    if ((int)pIVar3->Characteristics < 0) {
      uVar1 = (ulonglong)uVar2 << 8;
    }
    else {
      uVar1 = CONCAT71(uVar2,1);
    }
  }
  return uVar1;
}

// Library Function - Single Match
//  __scrt_release_startup_lock
// 
// Libraries: Visual Studio 2015 Release, Visual Studio 2017 Release, Visual Studio 2019 Release

void __scrt_release_startup_lock(char param_1) {
  bool bVar1;
  undefined3 extraout_var;
  
  bVar1 = __scrt_is_ucrt_dll_in_use();
  if ((CONCAT31(extraout_var,bVar1) != 0) && (param_1 == '\0')) {
    LOCK();
    DAT_14002bd20 = 0;
    UNLOCK();
  }
  return;
}

// Library Function - Single Match
//  __scrt_uninitialize_crt
// 
// Library: Visual Studio 2019 Release

undefined __scrt_uninitialize_crt(undefined8 param_1,char param_2) {
  if ((DAT_14002bd28 == '\0') || (param_2 == '\0')) {
    FUN_140007ccc();
    FUN_140007ccc();
  }
  return 1;
}

// Library Function - Single Match
//  _onexit
// 
// Library: Visual Studio 2019 Release

_onexit_t __cdecl _onexit(_onexit_t _Func) {
  int iVar1;
  _onexit_t p_Var2;
  
  if (DAT_14002bd30 == -1) {
    iVar1 = _crt_atexit();
  }
  else {
    iVar1 = _register_onexit_function(&DAT_14002bd30);
  }
  p_Var2 = (_onexit_t)0x0;
  if (iVar1 == 0) {
    p_Var2 = _Func;
  }
  return p_Var2;
}

// Library Function - Single Match
//  atexit
// 
// Library: Visual Studio 2019 Release

int __cdecl atexit(_func_5014 *param_1) {
  _onexit_t p_Var1;
  
  p_Var1 = _onexit((_onexit_t)param_1);
  return (p_Var1 != (_onexit_t)0x0) - 1;
}

// WARNING: Globals starting with '_' overlap smaller symbols at the same address

void __cdecl __security_init_cookie(void) {
  DWORD DVar1;
  _FILETIME _StackX_8;
  LARGE_INTEGER LStackX_10;
  _FILETIME a_Stack_18 [2];
  
  if (DAT_14002af00 == 0x2b992ddfa232) {
    _StackX_8.dwLowDateTime = 0;
    _StackX_8.dwHighDateTime = 0;
    GetSystemTimeAsFileTime(&_StackX_8);
    a_Stack_18[0] = _StackX_8;
    DVar1 = GetCurrentThreadId();
    a_Stack_18[0] = (_FILETIME)((ulonglong)a_Stack_18[0] ^ (ulonglong)DVar1);
    DVar1 = GetCurrentProcessId();
    a_Stack_18[0] = (_FILETIME)((ulonglong)a_Stack_18[0] ^ (ulonglong)DVar1);
    QueryPerformanceCounter(&LStackX_10);
    DAT_14002af00 =
         ((ulonglong)LStackX_10.s.LowPart << 0x20 ^
          CONCAT44(LStackX_10.s.HighPart,LStackX_10.s.LowPart) ^ (ulonglong)a_Stack_18[0] ^
         (ulonglong)a_Stack_18) & 0xffffffffffff;
    if (DAT_14002af00 == 0x2b992ddfa232) {
      DAT_14002af00 = 0x2b992ddfa233;
    }
  }
  _DAT_14002af40 = ~DAT_14002af00;
  return;
}

undefined8 FUN_140005e10(void) {
  return 1;
}

undefined8 FUN_140005e18(void) {
  return 0;
}

undefined8 FUN_140005e1c(void) {
  return 0x4000;
}

undefined8 FUN_140005e24(void) {
  return 0;
}

undefined8 FUN_140005e28(void) {
  return 0;
}

void FUN_140005e2c(void) {
                    // WARNING: Could not recover jumptable at 0x000140005e33. Too many branches
                    // WARNING: Treating indirect jump as call
  InitializeSListHead(&DAT_14002bd60);
  return;
}

undefined FUN_140005e48(void) {
  return 1;
}

void FUN_140005e4c(void) {
  return;
}

void FUN_140005e50(void) {
  return;
}

undefined * FUN_140005e54(void) {
  return &DAT_14002bd70;
}

undefined * FUN_140005e5c(void) {
  return &DAT_14002bd78;
}

void FUN_140005e64(void) {
  ulonglong *puVar1;
  
  puVar1 = (ulonglong *)FUN_140005e54();
  *puVar1 = *puVar1 | 0x24;
  puVar1 = (ulonglong *)FUN_140005e5c();
  *puVar1 = *puVar1 | 2;
  return;
}

bool FUN_140005e80(void) {
  return DAT_14002aebc == 0;
}

undefined * FUN_140005e8c(void) {
  return &DAT_14002bf28;
}

undefined * FUN_140005e94(void) {
  return &DAT_14002bf20;
}

// WARNING: Globals starting with '_' overlap smaller symbols at the same address

void FUN_140005e9c(void) {
  _DAT_14002bd80 = 0;
  return;
}

void FUN_140005ea4(undefined4 param_1) {
  code *pcVar1;
  BOOL BVar2;
  LONG LVar3;
  PRUNTIME_FUNCTION FunctionEntry;
  undefined *puVar4;
  undefined8 unaff_retaddr;
  DWORD64 local_res10;
  undefined local_res18 [8];
  undefined local_res20 [8];
  undefined auStack_5c8 [8];
  undefined auStack_5c0 [232];
  undefined local_4d8 [152];
  undefined *local_440;
  DWORD64 local_3e0;
  
  puVar4 = auStack_5c8;
  BVar2 = IsProcessorFeaturePresent(0x17);
  if (BVar2 != 0) {
    pcVar1 = (code *)swi(0x29);
    (*pcVar1)(param_1);
    puVar4 = auStack_5c0;
  }
  *(undefined8 *)(puVar4 + -8) = 0x140005ed8;
  FUN_140005e9c();
  *(undefined8 *)(puVar4 + -8) = 0x140005ee9;
  memset(local_4d8,0,0x4d0);
  *(undefined8 *)(puVar4 + -8) = 0x140005ef3;
  RtlCaptureContext(local_4d8);
  *(undefined8 *)(puVar4 + -8) = 0x140005f0d;
  FunctionEntry = RtlLookupFunctionEntry(local_3e0,&local_res10,(PUNWIND_HISTORY_TABLE)0x0);
  if (FunctionEntry != (PRUNTIME_FUNCTION)0x0) {
    *(undefined8 *)(puVar4 + 0x38) = 0;
    *(undefined **)(puVar4 + 0x30) = local_res18;
    *(undefined **)(puVar4 + 0x28) = local_res20;
    *(undefined **)(puVar4 + 0x20) = local_4d8;
    *(undefined8 *)(puVar4 + -8) = 0x140005f4e;
    RtlVirtualUnwind(0,local_res10,local_3e0,FunctionEntry,*(PCONTEXT *)(puVar4 + 0x20),
                     *(PVOID **)(puVar4 + 0x28),*(PDWORD64 *)(puVar4 + 0x30),
                     *(PKNONVOLATILE_CONTEXT_POINTERS *)(puVar4 + 0x38));
  }
  local_440 = &stack0x00000008;
  *(undefined8 *)(puVar4 + -8) = 0x140005f80;
  memset(puVar4 + 0x50,0,0x98);
  *(undefined8 *)(puVar4 + 0x60) = unaff_retaddr;
  *(undefined4 *)(puVar4 + 0x50) = 0x40000015;
  *(undefined4 *)(puVar4 + 0x54) = 1;
  *(undefined8 *)(puVar4 + -8) = 0x140005fa2;
  BVar2 = IsDebuggerPresent();
  *(undefined **)(puVar4 + 0x40) = puVar4 + 0x50;
  *(undefined **)(puVar4 + 0x48) = local_4d8;
  *(undefined8 *)(puVar4 + -8) = 0x140005fbf;
  SetUnhandledExceptionFilter((LPTOP_LEVEL_EXCEPTION_FILTER)0x0);
  *(undefined8 *)(puVar4 + -8) = 0x140005fca;
  LVar3 = UnhandledExceptionFilter((_EXCEPTION_POINTERS *)(puVar4 + 0x40));
  if ((LVar3 == 0) && (BVar2 != 1)) {
    *(undefined8 *)(puVar4 + -8) = 0x140005fdb;
    FUN_140005e9c();
  }
  return;
}

// Library Function - Single Match
//  __scrt_get_show_window_mode
// 
// Libraries: Visual Studio 2017 Release, Visual Studio 2019 Release

WORD __scrt_get_show_window_mode(void) {
  WORD WVar1;
  _STARTUPINFOW local_78;
  
  memset(&local_78,0,0x68);
  GetStartupInfoW(&local_78);
  WVar1 = 10;
  if (((byte)local_78.dwFlags & 1) != 0) {
    WVar1 = local_78.wShowWindow;
  }
  return WVar1;
}

undefined8 thunk_FUN_140006098(void) {
  return 0;
}

undefined8 FUN_140006030(void) {
  return 0;
}

ulonglong FUN_140006034(void) {
  HMODULE pHVar1;
  ulonglong uVar2;
  int *piVar3;
  
  pHVar1 = GetModuleHandleW((LPCWSTR)0x0);
  if ((((pHVar1 == (HMODULE)0x0) || (*(short *)&pHVar1->unused != 0x5a4d)) ||
      (piVar3 = (int *)((longlong)&pHVar1->unused + (longlong)pHVar1[0xf].unused), *piVar3 != 0x4550
      )) || ((pHVar1 = (HMODULE)0x20b, *(short *)(piVar3 + 6) != 0x20b || ((uint)piVar3[0x21] < 0xf) ))) { uVar2 = (ulonglong)pHVar1 & 0xffffffffffffff00;
  }
  else {
    uVar2 = CONCAT71(2,piVar3[0x3e] != 0);
  }
  return uVar2;
}

void FUN_140006088(void) {
                    // WARNING: Could not recover jumptable at 0x00014000608f. Too many branches
                    // WARNING: Treating indirect jump as call
  SetUnhandledExceptionFilter((LPTOP_LEVEL_EXCEPTION_FILTER)&LAB_14000609c);
  return;
}

undefined8 FUN_140006098(void) {
  return 0;
}

// WARNING: Function: _guard_dispatch_icall replaced with injection: guard_dispatch_icall

void FUN_1400060f8(void) {
  undefined8 *puVar1;
  
  for (puVar1 = &DAT_140028f80; puVar1 < &DAT_140028f80; puVar1 = puVar1 + 1) {
    if ((code *)*puVar1 != (code *)0x0) {
      (*(code *)*puVar1)();
    }
  }
  return;
}

void _guard_check_icall(void) {
  return;
}

void __cdecl free(void *_Memory) {
                    // WARNING: Could not recover jumptable at 0x000140007cb9. Too many branches
                    // WARNING: Treating indirect jump as call
  free(_Memory);
  return;
}

// WARNING: Removing unreachable block (ram,0x0001400064a6)
// WARNING: Removing unreachable block (ram,0x000140006416)
// WARNING: Removing unreachable block (ram,0x0001400063ef)
// WARNING: Globals starting with '_' overlap smaller symbols at the same address

undefined8 FUN_1400063dc(void) {
  int *piVar1;
  uint *puVar2;
  longlong lVar3;
  uint uVar4;
  uint uVar5;
  uint uVar6;
  byte in_XCR0;
  
  piVar1 = (int *)cpuid_basic_info(0);
  uVar6 = 0;
  puVar2 = (uint *)cpuid_Version_info(1);
  uVar4 = puVar2[3];
  if ((piVar1[2] == 0x49656e69 && piVar1[3] == 0x6c65746e) && piVar1[1] == 0x756e6547) {
    _DAT_14002aed0 = 0xffffffffffffffff;
    uVar5 = *puVar2 & 0xfff3ff0;
    _DAT_14002aec8 = 0x8000;
    if ((((uVar5 == 0x106c0) || (uVar5 == 0x20660)) || (uVar5 == 0x20670)) ||
       ((uVar5 - 0x30650 < 0x21 &&
        ((0x100010001U >> ((ulonglong)(uVar5 - 0x30650) & 0x3f) & 1) != 0)))) {
      DAT_14002bd90 = DAT_14002bd90 | 1;
    }
  }
  if (6 < *piVar1) {
    lVar3 = cpuid_Extended_Feature_Enumeration_info(7);
    uVar6 = *(uint *)(lVar3 + 4);
    if ((uVar6 >> 9 & 1) != 0) {
      DAT_14002bd90 = DAT_14002bd90 | 2;
    }
  }
  _DAT_14002aec0 = 1;
  DAT_14002aec4 = 2;
  if ((uVar4 >> 0x14 & 1) != 0) {
    _DAT_14002aec0 = 2;
    DAT_14002aec4 = 6;
    if ((((uVar4 >> 0x1b & 1) != 0) && ((uVar4 >> 0x1c & 1) != 0)) && ((in_XCR0 & 6) == 6)) {
      DAT_14002aec4 = 0xe;
      _DAT_14002aec0 = 3;
      if ((uVar6 & 0x20) != 0) {
        _DAT_14002aec0 = 5;
        DAT_14002aec4 = 0x2e;
        if (((uVar6 & 0xd0030000) == 0xd0030000) && ((in_XCR0 & 0xe0) == 0xe0)) {
          DAT_14002aec4 = 0x6e;
          _DAT_14002aec0 = 6;
        }
      }
    }
  }
  return 0;
}

// Library Function - Single Match
//  __scrt_is_ucrt_dll_in_use
// 
// Library: Visual Studio 2019 Release

bool __scrt_is_ucrt_dll_in_use(void) {
  return DAT_14002b400 != 0;
}

void * _getFiberPtrId(void) {
  return StackBase;
}

void __std_exception_copy(void) {
                    // WARNING: Could not recover jumptable at 0x000140007bf9. Too many branches
                    // WARNING: Treating indirect jump as call
  __std_exception_copy();
  return;
}

void __std_exception_destroy(void) {
                    // WARNING: Could not recover jumptable at 0x000140007bff. Too many branches
                    // WARNING: Treating indirect jump as call
  __std_exception_destroy();
  return;
}

void __stdcall _CxxThrowException(void *pExceptionObject,ThrowInfo *pThrowInfo) {
                    // WARNING: Could not recover jumptable at 0x000140007c05. Too many branches
                    // WARNING: Subroutine does not return
                    // WARNING: Treating indirect jump as call
  _CxxThrowException(pExceptionObject,pThrowInfo);
  return;
}

void __current_exception(void) {
                    // WARNING: Could not recover jumptable at 0x000140007c17. Too many branches
                    // WARNING: Treating indirect jump as call
  __current_exception();
  return;
}

void __current_exception_context(void) {
                    // WARNING: Could not recover jumptable at 0x000140007c1d. Too many branches
                    // WARNING: Treating indirect jump as call
  __current_exception_context();
  return;
}

void * __cdecl memset(void *_Dst,int _Val,size_t _Size) {
  void *pvVar1;
  
                    // WARNING: Could not recover jumptable at 0x000140007c23. Too many branches
                    // WARNING: Treating indirect jump as call
  pvVar1 = memset(_Dst,_Val,_Size);
  return pvVar1;
}

void _seh_filter_exe(void) {
                    // WARNING: Could not recover jumptable at 0x000140007c29. Too many branches
                    // WARNING: Treating indirect jump as call
  _seh_filter_exe();
  return;
}

void _set_app_type(void) {
                    // WARNING: Could not recover jumptable at 0x000140007c2f. Too many branches
                    // WARNING: Treating indirect jump as call
  _set_app_type();
  return;
}

void __setusermatherr(void) {
                    // WARNING: Could not recover jumptable at 0x000140007c35. Too many branches
                    // WARNING: Treating indirect jump as call
  __setusermatherr();
  return;
}

void _configure_narrow_argv(void) {
                    // WARNING: Could not recover jumptable at 0x000140007c3b. Too many branches
                    // WARNING: Treating indirect jump as call
  _configure_narrow_argv();
  return;
}

void _initialize_narrow_environment(void) {
                    // WARNING: Could not recover jumptable at 0x000140007c41. Too many branches
                    // WARNING: Treating indirect jump as call
  _initialize_narrow_environment();
  return;
}

void _get_narrow_winmain_command_line(void) {
                    // WARNING: Could not recover jumptable at 0x000140007c47. Too many branches
                    // WARNING: Treating indirect jump as call
  _get_narrow_winmain_command_line();
  return;
}

void _initterm(void) {
                    // WARNING: Could not recover jumptable at 0x000140007c4d. Too many branches
                    // WARNING: Treating indirect jump as call
  _initterm();
  return;
}

void _initterm_e(void) {
                    // WARNING: Could not recover jumptable at 0x000140007c53. Too many branches
                    // WARNING: Treating indirect jump as call
  _initterm_e();
  return;
}

void __cdecl exit(int _Code) {
                    // WARNING: Could not recover jumptable at 0x000140007c59. Too many branches
                    // WARNING: Subroutine does not return
                    // WARNING: Treating indirect jump as call
  exit(_Code);
  return;
}

void __cdecl _exit(int _Code) {
                    // WARNING: Could not recover jumptable at 0x000140007c5f. Too many branches
                    // WARNING: Subroutine does not return
                    // WARNING: Treating indirect jump as call
  _exit(_Code);
  return;
}

errno_t __cdecl _set_fmode(int _Mode) {
  errno_t eVar1;
  
                    // WARNING: Could not recover jumptable at 0x000140007c65. Too many branches
                    // WARNING: Treating indirect jump as call
  eVar1 = _set_fmode(_Mode);
  return eVar1;
}

void __cdecl _cexit(void) {
                    // WARNING: Could not recover jumptable at 0x000140007c6b. Too many branches
                    // WARNING: Treating indirect jump as call
  _cexit();
  return;
}

void _register_thread_local_exe_atexit_callback(void) {
                    // WARNING: Could not recover jumptable at 0x000140007c77. Too many branches
                    // WARNING: Treating indirect jump as call
  _register_thread_local_exe_atexit_callback();
  return;
}

int __cdecl _configthreadlocale(int _Flag) {
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x000140007c7d. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = _configthreadlocale(_Flag);
  return iVar1;
}

void __p__commode(void) {
                    // WARNING: Could not recover jumptable at 0x000140007c89. Too many branches
                    // WARNING: Treating indirect jump as call
  __p__commode();
  return;
}

void _seh_filter_dll(void) {
                    // WARNING: Could not recover jumptable at 0x000140007c8f. Too many branches
                    // WARNING: Treating indirect jump as call
  _seh_filter_dll();
  return;
}

void _initialize_onexit_table(void) {
                    // WARNING: Could not recover jumptable at 0x000140007c95. Too many branches
                    // WARNING: Treating indirect jump as call
  _initialize_onexit_table();
  return;
}

void _register_onexit_function(void) {
                    // WARNING: Could not recover jumptable at 0x000140007c9b. Too many branches
                    // WARNING: Treating indirect jump as call
  _register_onexit_function();
  return;
}

void _crt_atexit(void) {
                    // WARNING: Could not recover jumptable at 0x000140007ca7. Too many branches
                    // WARNING: Treating indirect jump as call
  _crt_atexit();
  return;
}

void terminate(void) {
                    // WARNING: Could not recover jumptable at 0x000140007cb3. Too many branches
                    // WARNING: Subroutine does not return
                    // WARNING: Treating indirect jump as call
  terminate();
  return;
}

void __cdecl free(void *_Memory) {
                    // WARNING: Could not recover jumptable at 0x000140007cb9. Too many branches
                    // WARNING: Treating indirect jump as call
  free(_Memory);
  return;
}

undefined FUN_140007cc0(void) {
  return 1;
}

undefined FUN_140007cc4(void) {
  return 1;
}

undefined FUN_140007cc8(void) {
  return 1;
}

undefined FUN_140007ccc(void) {
  return 1;
}

undefined FUN_140007cd0(void) {
  return 1;
}

undefined8 FUN_140007cd4(void) {
  return 0;
}

void __cdecl __ExceptionPtrDestroy(void *param_1) {
                    // WARNING: Could not recover jumptable at 0x000140007cd7. Too many branches
                    // WARNING: Treating indirect jump as call
  __ExceptionPtrDestroy(param_1);
  return;
}

void __cdecl __ExceptionPtrCopy(void *param_1,void *param_2) {
                    // WARNING: Could not recover jumptable at 0x000140007cdd. Too many branches
                    // WARNING: Treating indirect jump as call
  __ExceptionPtrCopy(param_1,param_2);
  return;
}

void __cdecl std::std__Xlength_error(char *param_1) {
                    // WARNING: Could not recover jumptable at 0x000140007ce3. Too many branches
                    // WARNING: Treating indirect jump as call
  _Xlength_error(param_1);
  return;
}

undefined * new(size_t A_0) {
  code *pcVar1;
  int iVar2;
  undefined *puVar3;
  
  do {
    puVar3 = (undefined *)malloc(A_0);
    if (puVar3 != (undefined *)0x0) {
      return puVar3;
    }
    iVar2 = _callnewh(A_0);
  } while (iVar2 != 0);
  if (A_0 == 0xffffffffffffffff) {
    FUN_14000559c();
    pcVar1 = (code *)swi(3);
    puVar3 = (undefined *)(*pcVar1)();
    return puVar3;
  }
  FUN_14000557c();
  pcVar1 = (code *)swi(3);
  puVar3 = (undefined *)(*pcVar1)();
  return puVar3;
}

void delete__(void *A_0) {
                    // WARNING: Could not recover jumptable at 0x000140007cb9. Too many branches
                    // WARNING: Treating indirect jump as call
  free(A_0);
  return;
}

undefined * new__(size_t A_0) {
  code *pcVar1;
  int iVar2;
  undefined *puVar3;
  
  do {
    puVar3 = (undefined *)malloc(A_0);
    if (puVar3 != (undefined *)0x0) {
      return puVar3;
    }
    iVar2 = _callnewh(A_0);
  } while (iVar2 != 0);
  if (A_0 == 0xffffffffffffffff) {
    FUN_14000559c();
    pcVar1 = (code *)swi(3);
    puVar3 = (undefined *)(*pcVar1)();
    return puVar3;
  }
  FUN_14000557c();
  pcVar1 = (code *)swi(3);
  puVar3 = (undefined *)(*pcVar1)();
  return puVar3;
}

int __stdcall
WideCharToMultiByte(UINT CodePage,DWORD dwFlags,LPCWSTR lpWideCharStr,int cchWideChar,
                   LPSTR lpMultiByteStr,int cbMultiByte,LPCSTR lpDefaultChar,
                   LPBOOL lpUsedDefaultChar) {
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x000140007d3d. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = WideCharToMultiByte(CodePage,dwFlags,lpWideCharStr,cchWideChar,lpMultiByteStr,cbMultiByte,
                              lpDefaultChar,lpUsedDefaultChar);
  return iVar1;
}

void __stdcall Sleep(DWORD dwMilliseconds) {
                    // WARNING: Could not recover jumptable at 0x000140007d43. Too many branches
                    // WARNING: Treating indirect jump as call
  Sleep(dwMilliseconds);
  return;
}

void * __cdecl memmove(void *_Dst,void *_Src,size_t _Size) {
  void *pvVar1;
  
                    // WARNING: Could not recover jumptable at 0x000140007d49. Too many branches
                    // WARNING: Treating indirect jump as call
  pvVar1 = memmove(_Dst,_Src,_Size);
  return pvVar1;
}

void __FrameUnwindFilter(void) {
                    // WARNING: Could not recover jumptable at 0x000140007d4f. Too many branches
                    // WARNING: Treating indirect jump as call
  __FrameUnwindFilter();
  return;
}

void __cdecl _invalid_parameter_noinfo_noreturn(void) {
  // WARNING: Could not recover jumptable at 0x000140007d55. Too many branches
  // WARNING: Subroutine does not return
  // WARNING: Treating indirect jump as call
  _invalid_parameter_noinfo_noreturn();
  return;
}

int __cdecl toupper(int _C) {
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x000140007d5b. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = toupper(_C);
  return iVar1;
}

void __cdecl abort(void) {
                    // WARNING: Could not recover jumptable at 0x000140007d61. Too many branches
                    // WARNING: Subroutine does not return
                    // WARNING: Treating indirect jump as call
  abort();
  return;
}

int __cdecl _callnewh(size_t _Size) {
  int iVar1;
  
                    // WARNING: Could not recover jumptable at 0x000140007d67. Too many branches
                    // WARNING: Treating indirect jump as call
  iVar1 = _callnewh(_Size);
  return iVar1;
}

void * __cdecl malloc(size_t _Size) {
  void *pvVar1;
  
                    // WARNING: Could not recover jumptable at 0x000140007d6d. Too many branches
                    // WARNING: Treating indirect jump as call
  pvVar1 = malloc(_Size);
  return pvVar1;
}

void entry(void) {
                    // WARNING: Could not recover jumptable at 0x000140007d73. Too many branches
                    // WARNING: Treating indirect jump as call
  _CorExeMain();
  return;
}

// WARNING: This is an inlined function

void _guard_dispatch_icall(void) {
  code *UNRECOVERED_JUMPTABLE;
  
                    // WARNING: Could not recover jumptable at 0x000140007d90. Too many branches
                    // WARNING: Treating indirect jump as call
  (*UNRECOVERED_JUMPTABLE)();
  return;
}

// WARNING: Globals starting with '_' overlap smaller symbols at the same address

void thunk_FUN_14000818a(void) {
                    // WARNING: Could not recover jumptable at 0x00014000818a. Too many branches
                    // WARNING: Treating indirect jump as call
  (*_DAT_14002a290)();
  return;
}

// WARNING: Globals starting with '_' overlap smaller symbols at the same address

void FUN_14000818a(void) {
                    // WARNING: Could not recover jumptable at 0x00014000818a. Too many branches
                    // WARNING: Treating indirect jump as call
  (*_DAT_14002a290)();
  return;
}

// WARNING: Globals starting with '_' overlap smaller symbols at the same address

void thunk_FUN_1400081da(void) {
                    // WARNING: Could not recover jumptable at 0x0001400081da. Too many branches
                    // WARNING: Treating indirect jump as call
  (*_DAT_14002a2e0)();
  return;
}

// WARNING: Globals starting with '_' overlap smaller symbols at the same address

void FUN_1400081da(void) {
                    // WARNING: Could not recover jumptable at 0x0001400081da. Too many branches
                    // WARNING: Treating indirect jump as call
  (*_DAT_14002a2e0)();
  return;
}

// WARNING: Globals starting with '_' overlap smaller symbols at the same address

void thunk_FUN_14000821a(void) {
                    // WARNING: Could not recover jumptable at 0x00014000821a. Too many branches
                    // WARNING: Treating indirect jump as call
  (*_DAT_14002a320)();
  return;
}

// WARNING: Globals starting with '_' overlap smaller symbols at the same address

void FUN_14000821a(void) {
                    // WARNING: Could not recover jumptable at 0x00014000821a. Too many branches
                    // WARNING: Treating indirect jump as call
  (*_DAT_14002a320)();
  return;
}

// WARNING: Globals starting with '_' overlap smaller symbols at the same address

void thunk_FUN_14000824a(void) {
                    // WARNING: Could not recover jumptable at 0x00014000824a. Too many branches
                    // WARNING: Treating indirect jump as call
  (*_DAT_14002a350)();
  return;
}

// WARNING: Globals starting with '_' overlap smaller symbols at the same address

void FUN_14000824a(void) {
                    // WARNING: Could not recover jumptable at 0x00014000824a. Too many branches
                    // WARNING: Treating indirect jump as call
  (*_DAT_14002a350)();
  return;
}

// WARNING: Globals starting with '_' overlap smaller symbols at the same address

void thunk_FUN_14000826a(void) {
                    // WARNING: Could not recover jumptable at 0x00014000826a. Too many branches
                    // WARNING: Treating indirect jump as call
  (*_DAT_14002a370)();
  return;
}

// WARNING: Globals starting with '_' overlap smaller symbols at the same address

void FUN_14000826a(void) {
                    // WARNING: Could not recover jumptable at 0x00014000826a. Too many branches
                    // WARNING: Treating indirect jump as call
  (*_DAT_14002a370)();
  return;
}

// WARNING: Globals starting with '_' overlap smaller symbols at the same address

void thunk_FUN_14000827a(void) {
                    // WARNING: Could not recover jumptable at 0x00014000827a. Too many branches
                    // WARNING: Treating indirect jump as call
  (*_DAT_14002a380)();
  return;
}

// WARNING: Globals starting with '_' overlap smaller symbols at the same address

void FUN_14000827a(void) {
                    // WARNING: Could not recover jumptable at 0x00014000827a. Too many branches
                    // WARNING: Treating indirect jump as call
  (*_DAT_14002a380)();
  return;
}

// WARNING: Globals starting with '_' overlap smaller symbols at the same address

void thunk_FUN_14000834a(void) {
                    // WARNING: Could not recover jumptable at 0x00014000834a. Too many branches
                    // WARNING: Treating indirect jump as call
  (*_DAT_14002a450)();
  return;
}

// WARNING: Globals starting with '_' overlap smaller symbols at the same address

void FUN_14000834a(void) {
                    // WARNING: Could not recover jumptable at 0x00014000834a. Too many branches
                    // WARNING: Treating indirect jump as call
  (*_DAT_14002a450)();
  return;
}

// WARNING: Globals starting with '_' overlap smaller symbols at the same address

void thunk_FUN_14000835a(void) {
                    // WARNING: Could not recover jumptable at 0x00014000835a. Too many branches
                    // WARNING: Treating indirect jump as call
  (*_DAT_14002a460)();
  return;
}

// WARNING: Globals starting with '_' overlap smaller symbols at the same address

void FUN_14000835a(void) {
                    // WARNING: Could not recover jumptable at 0x00014000835a. Too many branches
                    // WARNING: Treating indirect jump as call
  (*_DAT_14002a460)();
  return;
}

// WARNING: Globals starting with '_' overlap smaller symbols at the same address

void thunk_FUN_14000838a(void) {
                    // WARNING: Could not recover jumptable at 0x00014000838a. Too many branches
                    // WARNING: Treating indirect jump as call
  (*_DAT_14002a490)();
  return;
}

// WARNING: Globals starting with '_' overlap smaller symbols at the same address

void FUN_14000838a(void) {
                    // WARNING: Could not recover jumptable at 0x00014000838a. Too many branches
                    // WARNING: Treating indirect jump as call
  (*_DAT_14002a490)();
  return;
}

// WARNING: Globals starting with '_' overlap smaller symbols at the same address

void thunk_FUN_14000839a(void) {
                    // WARNING: Could not recover jumptable at 0x00014000839a. Too many branches
                    // WARNING: Treating indirect jump as call
  (*_DAT_14002a4a0)();
  return;
}

// WARNING: Globals starting with '_' overlap smaller symbols at the same address

void FUN_14000839a(void) {
                    // WARNING: Could not recover jumptable at 0x00014000839a. Too many branches
                    // WARNING: Treating indirect jump as call
  (*_DAT_14002a4a0)();
  return;
}

// WARNING: Globals starting with '_' overlap smaller symbols at the same address

void thunk_FUN_1400083aa(void) {
                    // WARNING: Could not recover jumptable at 0x0001400083aa. Too many branches
                    // WARNING: Treating indirect jump as call
  (*_DAT_14002a4b0)();
  return;
}

// WARNING: Globals starting with '_' overlap smaller symbols at the same address

void FUN_1400083aa(void) {
                    // WARNING: Could not recover jumptable at 0x0001400083aa. Too many branches
                    // WARNING: Treating indirect jump as call
  (*_DAT_14002a4b0)();
  return;
}

// WARNING: Globals starting with '_' overlap smaller symbols at the same address

void thunk_FUN_1400083ba(void) {
                    // WARNING: Could not recover jumptable at 0x0001400083ba. Too many branches
                    // WARNING: Treating indirect jump as call
  (*_DAT_14002a4c0)();
  return;
}

// WARNING: Globals starting with '_' overlap smaller symbols at the same address

void FUN_1400083ba(void) {
                    // WARNING: Could not recover jumptable at 0x0001400083ba. Too many branches
                    // WARNING: Treating indirect jump as call
  (*_DAT_14002a4c0)();
  return;
}

// WARNING: Globals starting with '_' overlap smaller symbols at the same address

void thunk_FUN_1400083ca(void) {
                    // WARNING: Could not recover jumptable at 0x0001400083ca. Too many branches
                    // WARNING: Treating indirect jump as call
  (*_DAT_14002a4d0)();
  return;
}

// WARNING: Globals starting with '_' overlap smaller symbols at the same address

void FUN_1400083ca(void) {
                    // WARNING: Could not recover jumptable at 0x0001400083ca. Too many branches
                    // WARNING: Treating indirect jump as call
  (*_DAT_14002a4d0)();
  return;
}

// WARNING: Globals starting with '_' overlap smaller symbols at the same address

void thunk_FUN_1400083da(void) {
                    // WARNING: Could not recover jumptable at 0x0001400083da. Too many branches
                    // WARNING: Treating indirect jump as call
  (*_DAT_14002a4e0)();
  return;
}

// WARNING: Globals starting with '_' overlap smaller symbols at the same address

void FUN_1400083da(void) {
                    // WARNING: Could not recover jumptable at 0x0001400083da. Too many branches
                    // WARNING: Treating indirect jump as call
  (*_DAT_14002a4e0)();
  return;
}