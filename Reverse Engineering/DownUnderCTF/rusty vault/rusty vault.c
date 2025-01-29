// data
__int128 xmmword_4A000 = 0x65E74F390F161629CD3071C33256A6FALL; // weak
__int128 xmmword_4A010 = 0xADF63090ED7FF4C81247EACCDB05FA2ELL; // weak
__int128 xmmword_4A020 = 0x8EA036FE9AB32E3BD1B5CFA2A750B1ABLL; // weak

__int64 rusty_vault::main()
{
  __int64 v0; // rax
  const void *v1; // rbx
  __int64 v2; // rdx
  unsigned __int32 v3; // ebp
  int v4; // ebp
  __int64 v5; // rdx
  __int64 v6; // r14
  const void *v7; // rsi
  void *v8; // r15
  __int64 v9; // rcx
  char v10; // dl
  char v11; // dl
  __int64 v12; // r14
  unsigned int v13; // edx
  char v14; // di
  char v15; // r8
  int v16; // r8d
  int v17; // edi
  unsigned int v18; // edi
  __int64 v19; // r14
  __int64 v20; // rbp
  __int64 v21; // r12
  __int64 v22; // rax
  __int64 v23; // r14
  __int64 v24; // r15
  __m128i v26; // [rsp+8h] [rbp-D90h] BYREF
  __int64 v27; // [rsp+18h] [rbp-D80h]
  __m128i src[60]; // [rsp+20h] [rbp-D78h] BYREF
  __m128i v29[60]; // [rsp+3E0h] [rbp-9B8h] BYREF
  _OWORD dest[30]; // [rsp+7A0h] [rbp-5F8h] BYREF
  __m128 v31[65]; // [rsp+980h] [rbp-418h] BYREF

  v0 = _rust_alloc(60LL, 1LL);
  if ( !v0 )
    alloc::alloc::handle_alloc_error(1LL, 60LL);
  v1 = (const void *)v0;
  *(_OWORD *)v0 = xmmword_4A000;
  *(_OWORD *)(v0 + 16) = xmmword_4A010;
  *(_OWORD *)(v0 + 32) = xmmword_4A020;
  *(_QWORD *)(v0 + 48) = 0x6179CBE7049F1890LL;
  *(_DWORD *)(v0 + 56) = 945543516;
  if ( aes::autodetect::aes_intrinsics::STORAGE == 0xFF )
  {
    aes::autodetect::aes_intrinsics::init_get::cpuid(v29, 1u);
    aes::autodetect::aes_intrinsics::init_get::cpuid_count(src, 7u);
    v3 = v29[0].m128i_u32[2];
    if ( (~v29[0].m128i_i32[2] & 0xC000000) != 0 )
    {
      aes::autodetect::aes_intrinsics::STORAGE = 0;
    }
    else
    {
      v4 = ((unsigned __int8)(core::core_arch::x86::xsave::_xgetbv((__int64)src, 7LL, v2) & 2) >> 1) & (v3 >> 25);
      aes::autodetect::aes_intrinsics::STORAGE = v4;
      if ( v4 )
        goto LABEL_7;
    }
LABEL_9:
    aes::soft::fixslice::aes256_key_schedule(src, (unsigned __int8 *)xmmword_4A074);
    goto LABEL_10;
  }
  if ( aes::autodetect::aes_intrinsics::STORAGE != 1 )
    goto LABEL_9;
LABEL_7:
  <aes::ni::Aes256Enc as crypto_common::KeyInit>::new(src, xmmword_4A074);
  aes::ni::aes256::inv_expanded_keys(&dest[15], src);
  memcpy(dest, src, 0xF0uLL);
  memcpy(src, dest, 0x1E0uLL);
LABEL_10:
  memcpy(v29, src, sizeof(v29));
  <aes_gcm::AesGcm<Aes,NonceSize,TagSize> as core::convert::From<Aes>>::from(v31, v29);
  v29[0].m128i_i64[0] = 0LL;
  v29[0].m128i_i64[1] = 1LL;
  v29[1].m128i_i64[0] = 0LL;
  src[0].m128i_i64[0] = (__int64)&off_5A118;
  src[0].m128i_i64[1] = 1LL;
  src[1].m128i_i64[0] = 8LL;
  *(__m128i *)((char *)&src[1] + 8) = 0LL;
  std::io::stdio::_print(src);
  src[0].m128i_i64[0] = (__int64)std::io::stdio::stdin();
  if ( std::io::stdio::Stdin::read_line((volatile signed __int32 **)src, v29[0].m128i_i64) )
  {
    v6 = v5;
    if ( v29[0].m128i_i64[0] )
      _rust_dealloc(v29[0].m128i_i64[1], v29[0].m128i_i64[0], 1LL);
    goto LABEL_56;
  }
  v7 = (const void *)v29[0].m128i_i64[1];
  v8 = &dword_0 + 1;
  if ( !v29[1].m128i_i64[0] )
    goto LABEL_44;
  v9 = v29[0].m128i_i64[1] + v29[1].m128i_i64[0];
  while ( 1 )
  {
    v12 = v9;
    v13 = *(unsigned __int8 *)(v9 - 1);
    if ( (v13 & 0x80u) != 0 )
    {
      v14 = *(_BYTE *)(v9 - 2);
      if ( v14 >= -64 )
      {
        v9 -= 2LL;
        v17 = v14 & 0x1F;
      }
      else
      {
        v15 = *(_BYTE *)(v9 - 3);
        if ( v15 > -65 )
        {
          v9 -= 3LL;
          v16 = v15 & 0xF;
        }
        else
        {
          v9 -= 4LL;
          v16 = ((*(_BYTE *)(v12 - 4) & 7) << 6) | v15 & 0x3F;
        }
        v17 = (v16 << 6) | v14 & 0x3F;
      }
      v13 = (v17 << 6) | v13 & 0x3F;
      if ( v13 == 1114112 )
        goto LABEL_44;
    }
    else
    {
      --v9;
    }
    if ( v13 - 9 >= 5 && v13 != 32 )
      break;
LABEL_19:
    if ( v9 == v29[0].m128i_i64[1] )
      goto LABEL_44;
  }
  if ( v13 < 0x80 )
    goto LABEL_40;
  v18 = v13 >> 8;
  if ( v13 >> 8 <= 0x1F )
  {
    if ( v18 )
    {
      if ( v18 != 22 )
        goto LABEL_40;
      v11 = v13 == 5760;
      goto LABEL_18;
    }
    v10 = core::unicode::unicode_data::white_space::WHITESPACE_MAP[(unsigned __int8)v13];
    goto LABEL_17;
  }
  if ( v18 == 32 )
  {
    v10 = core::unicode::unicode_data::white_space::WHITESPACE_MAP[(unsigned __int8)v13] >> 1;
LABEL_17:
    v11 = v10 & 1;
    goto LABEL_18;
  }
  if ( v18 == 48 )
  {
    v11 = v13 == 12288;
LABEL_18:
    if ( !v11 )
      goto LABEL_40;
    goto LABEL_19;
  }
LABEL_40:
  v19 = v12 - v29[0].m128i_i64[1];
  if ( v19 )
  {
    if ( v19 < 0 )
    {
      v21 = 0LL;
    }
    else
    {
      v20 = v29[0].m128i_i64[1];
      v21 = 1LL;
      v22 = _rust_alloc(v19, 1LL);
      if ( v22 )
      {
        v8 = (void *)v22;
        v7 = (const void *)v20;
        goto LABEL_45;
      }
    }
    alloc::raw_vec::handle_error(v21, v19);
  }
LABEL_44:
  v19 = 0LL;
LABEL_45:
  memcpy(v8, v7, v19);
  if ( v29[0].m128i_i64[0] )
    _rust_dealloc(v29[0].m128i_i64[1], v29[0].m128i_i64[0], 1LL);
  v29[0].m128i_i64[0] = v19;
  v29[0].m128i_i64[1] = (__int64)v8;
  v29[1].m128i_i64[0] = v19;
  <Alg as aead::Aead>::encrypt(&v26, v31, dword_4A068, v8, v19);
  v23 = v26.m128i_i64[0];
  if ( v26.m128i_i64[0] == 0x8000000000000000LL )
    core::result::unwrap_failed((__int64)aCalledResultUn, 43LL, (__int64)src, (__int64)&off_5A0D8, (__int64)&off_5A128);
  v24 = v26.m128i_i64[1];
  if ( v27 == 60 && !bcmp(v1, (const void *)v26.m128i_i64[1], 0x3CuLL) )
  {
    if ( v23 )
      _rust_dealloc(v24, v23, 1LL);
    src[0].m128i_i64[0] = (__int64)&off_5A150;
    src[0].m128i_i64[1] = 1LL;
    src[1].m128i_i64[0] = 8LL;
    *(__m128i *)((char *)&src[1] + 8) = 0LL;
    std::io::stdio::_print(src);
  }
  else
  {
    if ( v23 )
      _rust_dealloc(v24, v23, 1LL);
    src[0].m128i_i64[0] = (__int64)&off_5A140;
    src[0].m128i_i64[1] = 1LL;
    src[1].m128i_i64[0] = 8LL;
    *(__m128i *)((char *)&src[1] + 8) = 0LL;
    std::io::stdio::_print(src);
  }
  if ( v29[0].m128i_i64[0] )
    _rust_dealloc(v29[0].m128i_i64[1], v29[0].m128i_i64[0], 1LL);
  v6 = 0LL;
LABEL_56:
  _rust_dealloc(v1, 60LL, 1LL);
  return v6;
}
