#include <string.h>
#include <bits/stdlib.h>

long long alloc::raw_vec::RawVec<T,A>::reserve_for_push(long long *a1, long long a2)
{
  unsigned long long v2; // rax
  long long v3; // rcx
  long long v4; // r14
  long long v5; // rsi
  long long v6; // rax
  long long result; // rax
  long long v8; // [rsp+8h] [rbp-40h] BYREF
  long long v9; // [rsp+10h] [rbp-38h]
  long long v10; // [rsp+18h] [rbp-30h]
  long long v11[5]; // [rsp+20h] [rbp-28h] BYREF

  v2 = a2 + 1;
  if ( a2 == -1 )
    goto LABEL_12;
  v3 = *a1;
  if ( 2 * *a1 > v2 )
    v2 = 2 * *a1;
  v4 = 4LL;
  if ( v2 >= 5 )
    v4 = v2;
  v5 = 8 * (unsigned int)(v2 >> 60 == 0);
  if ( v3 )
  {
    v11[0] = a1[1];
    v11[2] = 8 * v3;
    v6 = 8LL;
  }
  else
  {
    v6 = 0LL;
  }
  v11[1] = v6;
  alloc::raw_vec::finish_grow(&v8, v5, 8 * v4, v11);
  if ( v8 )
  {
    if ( v9 )
      alloc::alloc::handle_alloc_error(v9, v10);
    LABEL_12:
        alloc::raw_vec::capacity_overflow();
  }
  result = v9;
  a1[1] = v9;
  *a1 = v4;
  return result;
}

void __noreturn safe::main() {
  long long base2; // rcx
  long long inc_size_flag; // rsi
  long long rawVec1; // rax
  long long dinc_size_flag; // rsi
  long long inc3_size_flag; // rsi
  long long rawVec2; // rax
  long long v7; // rcx
  long long inc4_size_flag; // rsi
  long long inc5_size_flag; // rsi
  char **v10; // rdx
  long long v11; // r12
  long long v12; // rsi
  long long v13; // r12
  long long v14; // rax
  long long v15; // r12
  long long v16; // rax
  long long v17; // r12
  long long v18; // rax
  long long v19; // rcx
  long long v20; // r12
  long long v21; // r12
  long long v22; // r12
  char **v23; // [rsp+0h] [rbp-128h] BYREF
  long long v24; // [rsp+8h] [rbp-120h]
  char **v25; // [rsp+10h] [rbp-118h]
  __int128 v26; // [rsp+18h] [rbp-110h]
  long long v27; // [rsp+28h] [rbp-100h]
  char v28; // [rsp+30h] [rbp-F8h]
  char v29[7]; // [rsp+31h] [rbp-F7h]
  long long rawVec; // [rsp+38h] [rbp-F0h] BYREF
  long long base; // [rsp+40h] [rbp-E8h]
  long long size_flag; // [rsp+48h] [rbp-E0h]
  char **v33; // [rsp+50h] [rbp-D8h] BYREF
  long long v34; // [rsp+58h] [rbp-D0h]
  char **v35; // [rsp+60h] [rbp-C8h]
  long long v36; // [rsp+68h] [rbp-C0h]
  char ***v37; // [rsp+70h] [rbp-B8h]
  long long v38; // [rsp+78h] [rbp-B0h]
  char *v39; // [rsp+80h] [rbp-A8h] BYREF
  void *v40; // [rsp+88h] [rbp-A0h]
  int fd[2]; // [rsp+90h] [rbp-98h] BYREF
  char v42[64]; // [rsp+98h] [rbp-90h] BYREF
  char flag[16]; // [rsp+D8h] [rbp-50h] BYREF
  char real_flag[16]; // [rsp+E8h] [rbp-40h] BYREF

  strcpy(v42, "never gonna giveyou up never gonna let you down secret.txt");
  rawVec = 0LL;
  base = 8LL;
  size_flag = 0LL;
  strcpy(flag, "flag.txt");
  strcpy(real_flag, "real_flag.txt");
  alloc::raw_vec::RawVec<T,A>::reserve_for_push(&rawVec, 0LL);
  base2 = base;
  *(_QWORD *)(base + 8 * size_flag) = real_flag;
  inc_size_flag = size_flag + 1;
  size_flag = inc_size_flag;
  rawVec1 = rawVec;
  if ( inc_size_flag == rawVec )
  {
    alloc::raw_vec::RawVec<T,A>::reserve_for_push(&rawVec, inc_size_flag);
    inc_size_flag = size_flag;
    rawVec1 = rawVec;
    base2 = base;
  }
  *(_QWORD *)(base2 + 8 * inc_size_flag) = flag;
  dinc_size_flag = inc_size_flag + 1;
  size_flag = dinc_size_flag;
  if ( dinc_size_flag == rawVec1 )
  {
    alloc::raw_vec::RawVec<T,A>::reserve_for_push(&rawVec, rawVec1);
    base2 = base;
    dinc_size_flag = size_flag;
  }
  *(_QWORD *)(base2 + 8 * dinc_size_flag) = "isthistherightone.txt";
  inc3_size_flag = dinc_size_flag + 1;
  size_flag = inc3_size_flag;
  rawVec2 = rawVec;
  if ( inc3_size_flag == rawVec )
  {
    alloc::raw_vec::RawVec<T,A>::reserve_for_push(&rawVec, inc3_size_flag);
    rawVec2 = rawVec;
    inc3_size_flag = size_flag;
  }
  v7 = base;
  *(_QWORD *)(base + 8 * inc3_size_flag) = &v42[48];
  inc4_size_flag = inc3_size_flag + 1;
  size_flag = inc4_size_flag;
  if ( inc4_size_flag == rawVec2 )
  {
    alloc::raw_vec::RawVec<T,A>::reserve_for_push(&rawVec, rawVec2);
    inc4_size_flag = size_flag;
    rawVec2 = rawVec;
    v7 = base;
  }
  *(_QWORD *)(v7 + 8 * inc4_size_flag) = 0x674E316874306ELL;
  inc5_size_flag = inc4_size_flag + 1;
  size_flag = inc5_size_flag;
  if ( inc5_size_flag == rawVec2 )
  {
    alloc::raw_vec::RawVec<T,A>::reserve_for_push(&rawVec, rawVec2);
    v7 = base;
    inc5_size_flag = size_flag;
  }
  *(_QWORD *)(v7 + 8 * inc5_size_flag) = &unk_47099;
  size_flag = inc5_size_flag + 1;
  while ( 1 )
  {
    while ( 1 )
    {
      safe::get_input_num((long long)&v33, (long long)aHiSelect1OfThe, 110LL);
      if ( !(_BYTE)v33 )
        break;
      v23 = &off_58110;
      v24 = 1LL;
      v25 = (char **)"called `Result::unwrap()` on an `Err` valueisthistherightone.txt";
      v26 = 0LL;
      std::io::stdio::_print(&v23);
    }
    switch ( v34 )
    {
      case 0LL:
        v23 = (char **)0x1B600000000LL;
        WORD2(v24) = 0;
        LODWORD(v24) = 1;
        std::fs::OpenOptions::_open((long long)&v33, (long long)&v23, aSecretTxt, 0xAuLL);
        if ( (_DWORD)v33 )
        {
          v23 = (char **)v34;
          core::result::unwrap_failed(
            (long long)"called `Result::unwrap()` on an `Err` valueisthistherightone.txt",
            43LL,
            (long long)&v23,
            (long long)&off_580D0,
            (long long)&off_58210);
        }
        fd[0] = HIDWORD(v33);
        v33 = 0LL;
        v34 = 1LL;
        v35 = 0LL;
        if ( <std::fs::File as std::io::Read>::read_to_string(fd, (long long *)&v33) )
        {
          v23 = v10;
          core::result::unwrap_failed(
            (long long)"called `Result::unwrap()` on an `Err` valueisthistherightone.txt",
            43LL,
            (long long)&v23,
            (long long)&off_580D0,
            (long long)&off_58228);
        }
        v39 = (char *)&v33;
        v40 = <alloc::string::String as core::fmt::Display>::fmt;
        v23 = &off_58240;
        v24 = 2LL;
        v25 = &v39;
        v26 = 1uLL;
        std::io::stdio::_print(&v23);
        if ( v33 )
          _rust_dealloc(v34, v33, 1LL);
        close(fd[0]);
        break;
      case 1LL:
        while ( 1 )
        {
          safe::get_input_num((long long)&v33, (long long)aSelectSource1R, 49LL);
          if ( !(_BYTE)v33 && (unsigned long long)(v34 - 3) >= 0xFFFFFFFFFFFFFFFELL )
            break;
          v23 = &off_58110;
          v24 = 1LL;
          v25 = (char **)"called `Result::unwrap()` on an `Err` valueisthistherightone.txt";
          v26 = 0LL;
          std::io::stdio::_print(&v23);
        }
        if ( v34 == 1 )
        {
          while ( 1 )
          {
            safe::get_src_reg((long long)&v33);
            if ( !(_BYTE)v33 )
            {
              v17 = v34;
              if ( (unsigned long long)(v34 - 7) >= 0xFFFFFFFFFFFFFFFALL )
                break;
            }
            v23 = &off_58110;
            v24 = 1LL;
            v25 = (char **)"called `Result::unwrap()` on an `Err` valueisthistherightone.txt";
            v26 = 0LL;
            std::io::stdio::_print(&v23);
          }
          while ( 1 )
          {
            safe::get_dst_reg((long long)&v33);
            if ( !(_BYTE)v33 )
            {
              v18 = v34;
              if ( (unsigned long long)(v34 - 7) >= 0xFFFFFFFFFFFFFFFALL )
                break;
            }
            v23 = &off_58110;
            v24 = 1LL;
            v25 = (char **)"called `Result::unwrap()` on an `Err` valueisthistherightone.txt";
            v26 = 0LL;
            std::io::stdio::_print(&v23);
          }
          v22 = *(_QWORD *)&fd[2 * v17];
        }
        else
        {
          while ( 1 )
          {
            safe::get_src_imm((long long)&v33);
            if ( !(_BYTE)v33 )
              break;
            v23 = &off_58130;
            v24 = 1LL;
            v25 = (char **)"called `Result::unwrap()` on an `Err` valueisthistherightone.txt";
            v26 = 0LL;
            std::io::stdio::_print(&v23);
          }
          v22 = v34;
          while ( 1 )
          {
            safe::get_dst_reg((long long)&v33);
            if ( !(_BYTE)v33 )
            {
              v18 = v34;
              if ( (unsigned long long)(v34 - 7) >= 0xFFFFFFFFFFFFFFFALL )
                break;
            }
            v23 = &off_58110;
            v24 = 1LL;
            v25 = (char **)"called `Result::unwrap()` on an `Err` valueisthistherightone.txt";
            v26 = 0LL;
            std::io::stdio::_print(&v23);
          }
        }
        *(_QWORD *)&fd[2 * v18] += v22;
        break;
      case 2LL:
        while ( 1 )
        {
          safe::get_input_num((long long)&v33, (long long)aSelectSource1R, 49LL);
          if ( !(_BYTE)v33 && (unsigned long long)(v34 - 3) >= 0xFFFFFFFFFFFFFFFELL )
            break;
          v23 = &off_58110;
          v24 = 1LL;
          v25 = (char **)"called `Result::unwrap()` on an `Err` valueisthistherightone.txt";
          v26 = 0LL;
          std::io::stdio::_print(&v23);
        }
        if ( v34 == 1 )
        {
          while ( 1 )
          {
            safe::get_src_reg((long long)&v33);
            if ( !(_BYTE)v33 )
            {
              v13 = v34;
              if ( (unsigned long long)(v34 - 7) >= 0xFFFFFFFFFFFFFFFALL )
                break;
            }
            v23 = &off_58110;
            v24 = 1LL;
            v25 = (char **)"called `Result::unwrap()` on an `Err` valueisthistherightone.txt";
            v26 = 0LL;
            std::io::stdio::_print(&v23);
          }
          while ( 1 )
          {
            safe::get_dst_reg((long long)&v33);
            if ( !(_BYTE)v33 )
            {
              v14 = v34;
              if ( (unsigned long long)(v34 - 7) >= 0xFFFFFFFFFFFFFFFALL )
                break;
            }
            v23 = &off_58110;
            v24 = 1LL;
            v25 = (char **)"called `Result::unwrap()` on an `Err` valueisthistherightone.txt";
            v26 = 0LL;
            std::io::stdio::_print(&v23);
          }
          v20 = *(_QWORD *)&fd[2 * v13];
        }
        else
        {
          while ( 1 )
          {
            safe::get_src_imm((long long)&v33);
            if ( !(_BYTE)v33 )
              break;
            v23 = &off_58130;
            v24 = 1LL;
            v25 = (char **)"called `Result::unwrap()` on an `Err` valueisthistherightone.txt";
            v26 = 0LL;
            std::io::stdio::_print(&v23);
          }
          v20 = v34;
          while ( 1 )
          {
            safe::get_dst_reg((long long)&v33);
            if ( !(_BYTE)v33 )
            {
              v14 = v34;
              if ( (unsigned long long)(v34 - 7) >= 0xFFFFFFFFFFFFFFFALL )
                break;
            }
            v23 = &off_58110;
            v24 = 1LL;
            v25 = (char **)"called `Result::unwrap()` on an `Err` valueisthistherightone.txt";
            v26 = 0LL;
            std::io::stdio::_print(&v23);
          }
        }
        *(_QWORD *)&fd[2 * v14] &= v20;
        break;
      case 3LL:
        while ( 1 )
        {
          safe::get_input_num((long long)&v33, (long long)aSelectSource1R, 49LL);
          if ( !(_BYTE)v33 && (unsigned long long)(v34 - 3) >= 0xFFFFFFFFFFFFFFFELL )
            break;
          v23 = &off_58110;
          v24 = 1LL;
          v25 = (char **)"called `Result::unwrap()` on an `Err` valueisthistherightone.txt";
          v26 = 0LL;
          std::io::stdio::_print(&v23);
        }
        if ( v34 == 1 )
        {
          while ( 1 )
          {
            safe::get_src_reg((long long)&v33);
            if ( !(_BYTE)v33 )
            {
              v15 = v34;
              if ( (unsigned long long)(v34 - 7) >= 0xFFFFFFFFFFFFFFFALL )
                break;
            }
            v23 = &off_58110;
            v24 = 1LL;
            v25 = (char **)"called `Result::unwrap()` on an `Err` valueisthistherightone.txt";
            v26 = 0LL;
            std::io::stdio::_print(&v23);
          }
          while ( 1 )
          {
            safe::get_dst_reg((long long)&v33);
            if ( !(_BYTE)v33 )
            {
              v16 = v34;
              if ( (unsigned long long)(v34 - 7) >= 0xFFFFFFFFFFFFFFFALL )
                break;
            }
            v23 = &off_58110;
            v24 = 1LL;
            v25 = (char **)"called `Result::unwrap()` on an `Err` valueisthistherightone.txt";
            v26 = 0LL;
            std::io::stdio::_print(&v23);
          }
          v21 = *(_QWORD *)&fd[2 * v15];
        }
        else
        {
          while ( 1 )
          {
            safe::get_src_imm((long long)&v33);
            if ( !(_BYTE)v33 )
              break;
            v23 = &off_58130;
            v24 = 1LL;
            v25 = (char **)"called `Result::unwrap()` on an `Err` valueisthistherightone.txt";
            v26 = 0LL;
            std::io::stdio::_print(&v23);
          }
          v21 = v34;
          while ( 1 )
          {
            safe::get_dst_reg((long long)&v33);
            if ( !(_BYTE)v33 )
            {
              v16 = v34;
              if ( (unsigned long long)(v34 - 7) >= 0xFFFFFFFFFFFFFFFALL )
                break;
            }
            v23 = &off_58110;
            v24 = 1LL;
            v25 = (char **)"called `Result::unwrap()` on an `Err` valueisthistherightone.txt";
            v26 = 0LL;
            std::io::stdio::_print(&v23);
          }
        }
        *(_QWORD *)&fd[2 * v16] ^= v21;
        break;
      case 4LL:
        while ( 1 )
        {
          safe::get_register((long long)&v33);
          if ( !(_BYTE)v33 && (unsigned long long)(v34 - 7) >= 0xFFFFFFFFFFFFFFFALL )
            break;
          v23 = &off_58110;
          v24 = 1LL;
          v25 = (char **)"called `Result::unwrap()` on an `Err` valueisthistherightone.txt";
          v26 = 0LL;
          std::io::stdio::_print(&v23);
        }
        v11 = *(_QWORD *)&fd[2 * v34];
        v12 = size_flag;
        if ( size_flag == rawVec )
        {
          alloc::raw_vec::RawVec<T,A>::reserve_for_push(&rawVec, size_flag);
          v12 = size_flag;
        }
        *(_QWORD *)(base + 8 * v12) = v11;
        size_flag = v12 + 1;
        break;
      case 5LL:
        while ( 1 )
        {
          safe::get_register((long long)&v33);
          if ( !(_BYTE)v33 && (unsigned long long)(v34 - 7) >= 0xFFFFFFFFFFFFFFFALL )
            break;
          v23 = &off_58110;
          v24 = 1LL;
          v25 = (char **)"called `Result::unwrap()` on an `Err` valueisthistherightone.txt";
          v26 = 0LL;
          std::io::stdio::_print(&v23);
        }
        v19 = size_flag;
        if ( size_flag )
        {
          --size_flag;
          *(_QWORD *)&fd[2 * v34] = *(_QWORD *)(base + 8 * v19 - 8);
        }
        else
        {
          v23 = &off_58120;
          v24 = 1LL;
          v25 = (char **)"called `Result::unwrap()` on an `Err` valueisthistherightone.txt";
          v26 = 0LL;
          std::io::stdio::_print(&v23);
        }
        break;
      case 6LL:
        __asm { syscall; LINUX - }
        break;
      case 7LL:
        v23 = &off_58140;
        v24 = 1LL;
        v25 = (char **)"called `Result::unwrap()` on an `Err` valueisthistherightone.txt";
        v26 = 0LL;
        std::io::stdio::_print(&v23);
        v39 = v42;
        v40 = core::fmt::num::<impl core::fmt::LowerHex for usize>::fmt;
        v23 = (char **)(&dword_0 + 2);
        v25 = 0LL;
        v26 = 0x12uLL;
        v27 = 0xC00000020LL;
        v28 = 3;
        v33 = &off_58150;
        v34 = 2LL;
        v37 = &v23;
        v38 = 1LL;
        v35 = &v39;
        v36 = 1LL;
        std::io::stdio::_print(&v33);
        v39 = &v42[8];
        v40 = core::fmt::num::<impl core::fmt::LowerHex for usize>::fmt;
        v23 = (char **)(&dword_0 + 2);
        v25 = 0LL;
        v26 = 0x12uLL;
        v27 = 0xC00000020LL;
        v28 = 3;
        v33 = &off_58170;
        v34 = 2LL;
        v37 = &v23;
        v38 = 1LL;
        v35 = &v39;
        v36 = 1LL;
        std::io::stdio::_print(&v33);
        v39 = &v42[16];
        v40 = core::fmt::num::<impl core::fmt::LowerHex for usize>::fmt;
        v23 = (char **)(&dword_0 + 2);
        v25 = 0LL;
        v26 = 0x12uLL;
        v27 = 0xC00000020LL;
        v28 = 3;
        v33 = &off_58190;
        v34 = 2LL;
        v37 = &v23;
        v38 = 1LL;
        v35 = &v39;
        v36 = 1LL;
        std::io::stdio::_print(&v33);
        v39 = &v42[24];
        v40 = core::fmt::num::<impl core::fmt::LowerHex for usize>::fmt;
        v23 = (char **)(&dword_0 + 2);
        v25 = 0LL;
        v26 = 0x12uLL;
        v27 = 0xC00000020LL;
        v28 = 3;
        v33 = &off_581B0;
        v34 = 2LL;
        v37 = &v23;
        v38 = 1LL;
        v35 = &v39;
        v36 = 1LL;
        std::io::stdio::_print(&v33);
        v39 = &v42[32];
        v40 = core::fmt::num::<impl core::fmt::LowerHex for usize>::fmt;
        v23 = (char **)(&dword_0 + 2);
        v25 = 0LL;
        v26 = 0x12uLL;
        v27 = 0xC00000020LL;
        v28 = 3;
        *(_DWORD *)&v29[3] = *(int *)((char *)fd + 3);
        *(_DWORD *)v29 = fd[0];
        v33 = &off_581D0;
        v34 = 2LL;
        v37 = &v23;
        v38 = 1LL;
        v35 = &v39;
        v36 = 1LL;
        std::io::stdio::_print(&v33);
        v39 = &v42[40];
        v40 = core::fmt::num::<impl core::fmt::LowerHex for usize>::fmt;
        v23 = (char **)(&dword_0 + 2);
        v25 = 0LL;
        v26 = 0x12uLL;
        v27 = 0xC00000020LL;
        v28 = 3;
        *(_DWORD *)&v29[3] = *(int *)((char *)fd + 3);
        *(_DWORD *)v29 = fd[0];
        v33 = &off_581F0;
        v34 = 2LL;
        v37 = &v23;
        v38 = 1LL;
        v35 = &v39;
        v36 = 1LL;
        std::io::stdio::_print(&v33);
        break;
      case 8LL:
        v23 = &off_58260;
        v24 = 1LL;
        v25 = (char **)"called `Result::unwrap()` on an `Err` valueisthistherightone.txt";
        v26 = 0LL;
        std::io::stdio::_print(&v23);
        std::process::exit(0);
      default:
        v23 = &off_580F0;
        v24 = 1LL;
        v25 = (char **)"called `Result::unwrap()` on an `Err` valueisthistherightone.txt";
        v26 = 0LL;
        std::io::stdio::_print(&v23);
        break;
    }
    v23 = (char **)&off_58100;
    v24 = 1LL;
    v25 = (char **)"called `Result::unwrap()` on an `Err` valueisthistherightone.txt";
    v26 = 0LL;
    std::io::stdio::_print(&v23);
  }
}
