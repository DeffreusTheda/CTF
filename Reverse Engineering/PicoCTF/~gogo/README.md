# gogo Writeup by Deffreus - PicoCTF 2021

###### Author: thelshell

## Description

Hmmm this is a weird file... [enter_password](https://mercury.picoctf.net/static/665fdde4cd52e11e3a6abee4381b462c/enter_password).
There is a instance of the service running at mercury.picoctf.net:20140.

<details><summary>Hint 1</summary>
use go tool objdump or ghidra
</details>

## Files

```
$ file enter_password 
enter_password: ELF 32-bit LSB executable, Intel 80386, version 1 (SYSV), statically linked, Go BuildID=30b-B1qI__G6z32QWdo0/JdccY5PIeZWtnVrxiWVz/UxFYZaWNHoqQUT-bTToh/mzu0tEtAAYtYWQsOaLRK, with debug_info, not stripped
$ dust -b enter_password 
1.9M ┌── enter_password
$ checksec enter_password 
    Arch:       i386-32-little
    RELRO:      No RELRO
    Stack:      No canary found
    NX:         NX enabled
    PIE:        No PIE (0x8048000)
    Stripped:   No
    Debuginfo:  Yes
```

## Solution

Decompile it with Ghidra! or online [here](https://dogbolt.org/?id=e9535358-b208-4cfa-9e0e-f6412d21e225#Hex-Rays=6&Ghidra=8)

Ghidra auto-analyze it, and once it's done it jumps to `main.main()`:

```
     1	
     2	/* WARNING: Unknown calling convention -- yet parameter storage is locked */
     3	
     4	void main.main(void)
     5	
     6	{
     7	  []interface_{} a;
     8	  []interface_{} a_00;
     9	  []interface_{} a_01;
    10	  []interface_{} a_02;
    11	  []interface_{} a_03;
    12	  []interface_{} a_04;
    13	  error err;
    14	  error err_00;
    15	  error err_01;
    16	  error err_02;
    17	  undefined **ppuVar1;
    18	  int *in_GS_OFFSET;
    19	  undefined **ppuVar2;
    20	  string *in_stack_ffffffac;
    21	  string *~r1;
    22	  char ~r1_00;
    23	  int n;
    24	  runtime.itab *prVar3;
    25	  void *in_stack_ffffffbc;
    26	  error in_stack_ffffffc0;
    27	  string *&k;
    28	  string *&currPasswd;
    29	  undefined *local_30;
    30	  string *local_2c;
    31	  undefined *local_28;
    32	  string *local_24;
    33	  undefined *local_20;
    34	  string *local_1c;
    35	  undefined *local_18 [2];
    36	  undefined *local_10;
    37	  string *local_c;
    38	  undefined *local_8;
    39	  string *local_4;
    40	  
    41	  while (&stack0x00000000 <= *(undefined **)(*(int *)(*in_GS_OFFSET + -4) + 8)) {
    42	    local_4 = (string *)0x80d4a7b;
    43	    runtime.morestack_noctxt();
    44	  }
    45	  runtime.newobject((runtime._type *)&DAT_080e8860,in_stack_ffffffac);
    46	  fmt.Printf(([]interface_{})ZEXT812(0),in_stack_ffffffc0,(string)0x10080fea50,
    47	             (int)in_stack_ffffffbc);
    48	  local_18[0] = &DAT_080e1300;
    49	  ppuVar2 = local_18;
    50	  n = 1;
    51	  prVar3 = (runtime.itab *)0x1;
    52	  a_03.len = 1;
    53	  a_03.array = (interface_{} *)ppuVar2;
    54	  a_03.cap = 1;
    55	  fmt.Scanf(a_03,in_stack_ffffffc0,(string)0x3080fd1b6,(int)in_stack_ffffffbc);
    56	  ~r1_00 = (char)ppuVar2;
    57	  main.checkPassword(*in_stack_ffffffac,(bool)~r1_00);
    58	  if (~r1_00 == '\0') {
    59	    local_10 = &DAT_080e8860;
    60	    local_c = &main.statictmp_3;
    61	    ppuVar2 = &local_10;
    62	    a_02.len = 1;
    63	    a_02.array = (interface_{} *)ppuVar2;
    64	    a_02.cap = 1;
    65	    err_02.data = in_stack_ffffffbc;
    66	    err_02.tab = prVar3;
    67	    fmt.Println(a_02,err_02,n);
    68	  }
    69	  else {
    70	    local_20 = &DAT_080e8860;
    71	    local_1c = &main.statictmp_0;
    72	    a.len = 1;
    73	    a.array = (interface_{} *)&local_20;
    74	    a.cap = 1;
    75	    err.data = in_stack_ffffffbc;
    76	    err.tab = prVar3;
    77	    fmt.Println(a,err,n);
    78	    local_28 = &DAT_080e8860;
    79	    local_24 = &main.statictmp_1;
    80	    a_00.len = 1;
    81	    a_00.array = (interface_{} *)&local_28;
    82	    a_00.cap = 1;
    83	    err_00.data = in_stack_ffffffbc;
    84	    err_00.tab = prVar3;
    85	    fmt.Println(a_00,err_00,n);
    86	    local_30 = &DAT_080e8860;
    87	    local_2c = &main.statictmp_2;
    88	    ~r1 = (string *)0x1;
    89	    a_01.len = 1;
    90	    a_01.array = (interface_{} *)&local_30;
    91	    a_01.cap = 1;
    92	    err_01.data = in_stack_ffffffbc;
    93	    err_01.tab = prVar3;
    94	    fmt.Println(a_01,err_01,n);
    95	    runtime.newobject((runtime._type *)&DAT_080e8860,~r1);
    96	    local_8 = &DAT_080e1300;
    97	    a_04.len = 1;
    98	    a_04.array = (interface_{} *)&local_8;
    99	    a_04.cap = 1;
   100	    local_4 = ~r1;
   101	    fmt.Scanf(a_04,in_stack_ffffffc0,(string)0x3080fd1b6,(int)in_stack_ffffffbc);
   102	    main.ambush(*~r1);
   103	    ppuVar2 = (undefined **)0x0;
   104	    ppuVar1 = &PTR_main.get_flag_081046a0;
   105	    runtime.deferproc((runtime.funcval *)&PTR_main.get_flag_081046a0,0);
   106	    if (ppuVar1 != (undefined **)0x0) {
   107	      runtime.deferreturn((uintptr)ppuVar2);
   108	      return;
   109	    }
   110	  }
   111	  runtime.deferreturn((uintptr)ppuVar2);
   112	  return;
   113	}
   114	
```

These is ugly, yeah, I agree. f Go.
So now, we only care about what function(s) is called here, and there's some notable, probably custom defined functions:

- `main.checkPassword`
- `main.ambush` if `main.checkPassword` return `true`

Let's look at `main.checkPassword` first. It checks our input from `fmt.Scanf`:

```
     1	
     2	/* WARNING: Unknown calling convention */
     3	
     4	void main.checkPassword(string input,bool ~r1)
     5	
     6	{
     7	  code *pcVar1;
     8	  uint uVar2;
     9	  int iVar3;
    10	  int *in_GS_OFFSET;
    11	  uint8 key [32];
    12	  byte local_20 [28];
    13	  undefined4 uStack_4;
    14	  
    15	  while (&stack0x00000000 <= *(undefined **)(*(int *)(*in_GS_OFFSET + -4) + 8)) {
    16	    uStack_4 = 0x80d4b72;
    17	    runtime.morestack_noctxt();
    18	  }
    19	  if (input.len < 0x20) {
    20	    os.Exit(0);
    21	  }
    22	  FUN_08090b18(0);
    23	  key[0] = 0x38;
    24	  key[1] = 0x36;
    25	  key[2] = 0x31;
    26	  key[3] = 0x38;
    27	  key[4] = 0x33;
    28	  key[5] = 0x36;
    29	  key[6] = 0x66;
    30	  key[7] = 0x31;
    31	  key[8] = 0x33;
    32	  key[9] = 0x65;
    33	  key[10] = 0x33;
    34	  key[0xb] = 100;
    35	  key[0xc] = 0x36;
    36	  key[0xd] = 0x32;
    37	  key[0xe] = 0x37;
    38	  key[0xf] = 100;
    39	  key[0x10] = 0x66;
    40	  key[0x11] = 0x61;
    41	  key[0x12] = 0x33;
    42	  key[0x13] = 0x37;
    43	  key[0x14] = 0x35;
    44	  key[0x15] = 0x62;
    45	  key[0x16] = 100;
    46	  key[0x17] = 0x62;
    47	  key[0x18] = 0x38;
    48	  key[0x19] = 0x33;
    49	  key[0x1a] = 0x38;
    50	  key[0x1b] = 0x39;
    51	  key[0x1c] = 0x32;
    52	  key[0x1d] = 0x31;
    53	  key[0x1e] = 0x34;
    54	  key[0x1f] = 0x65;
    55	  FUN_08090fe0();
    56	  uVar2 = 0;
    57	  iVar3 = 0;
    58	  while( true ) {
    59	    if (0x1f < (int)uVar2) {
    60	      if (iVar3 == 0x20) {
    61	        return;
    62	      }
    63	      return;
    64	    }
    65	    if (((uint)input.len <= uVar2) || (0x1f < uVar2)) break;
    66	    if ((input.str[uVar2] ^ key[uVar2]) == local_20[uVar2]) {
    67	      iVar3 = iVar3 + 1;
    68	    }
    69	    uVar2 = uVar2 + 1;
    70	  }
    71	  runtime.panicindex();
    72	                    /* WARNING: Does not return */
    73	  pcVar1 = (code *)invalidInstructionException();
    74	  (*pcVar1)();
    75	}
```

Notable things here:
- Line 19-21: Our input length must be 20 or more.
- Line 22: call `FUN_08090b18(0)`.
- Line 23-54: Set `key` bytes one by one, from index `0` to `0x1f`.
- Line 55: call `FUN_08090fe0()`.
- The `while` at line 58:
	- increment `iVar3` if XOR of each corresponding input and key bytes is equal to corresponding byte in `local_20`.
- Weird `if` at line 60, the `return` keyword below it might be missing it's return value. This should be due to the unknown calling convention warning. I think it's logical to assume if `iVar3 == 0x20` then it would `return true`. 

The value of `local_20` is only assigned in line 11665 at `enter_password.c`: `local_20 = n + 0x1fff & 0xffffe000;`, where `n` is an `uintptr` passed as an argument to `runtime___mheap__sysAlloc`.

> Months later...

Flag: `picoCTF{p1kap1ka_p1c001b3038b}`