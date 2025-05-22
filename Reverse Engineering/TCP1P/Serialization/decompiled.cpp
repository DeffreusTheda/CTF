#include <defs.h>

int main(int argc, const char **argv, const char **envp)
{
  unsigned int random_device; // eax
  __int64 output; // rax
  __int64 v5; // rbx
  __int64 v6; // rax
  __int64 v7; // rax
  double v8; // xmm0_8
  int v9; // ebx
  __int64 v10; // rax
  __int64 v11; // rax
  __int64 v13; // rax
  __int64 v15; // rax
  __int64 v17; // rax
  __int64 v19; // rax
  __int64 v20; // rax
  int v21; // eax
  int v22; // eax
  __int64 v23; // rax
  __int64 v24; // rbx
  __int64 v25; // rax
  __int64 v26; // rax
  __int64 v27; // rax
  int *v28; // rax
  __int64 v29; // rbx
  __int64 v30; // rax
  __int64 v31; // rax
  __int64 v32; // rax
  unsigned int v33; // eax
  __int64 v34; // rbx
  unsigned int v35; // eax
  __int64 v36; // rax
  __int64 v37; // rbx
  __int64 v38; // rax
  unsigned int *v39; // rax
  __int64 v40; // rbx
  unsigned int v41; // eax
  __int64 v42; // rbx
  unsigned int v43; // eax
  __int64 v44; // rax
  __int64 v45; // rbx
  __int64 v46; // rax
  __int64 v47; // rax
  __int64 v48; // rbx
  unsigned int v49; // eax
  __int64 v50; // rbx
  unsigned int v51; // eax
  __int64 v52; // rax
  __int64 v53; // rbx
  __int64 vi_1; // rax
  unsigned int *v55; // rax
  __int64 output_2; // rax
  __int64 v58; // [rsp+8h] [rbp-2AD8h] BYREF
  __int64 v59; // [rsp+10h] [rbp-2AD0h] BYREF
  __int64 vvi_end; // [rsp+18h] [rbp-2AC8h] BYREF
  __int64 vvi_iter; // [rsp+20h] [rbp-2AC0h] BYREF
  int k; // [rsp+28h] [rbp-2AB8h] BYREF
  int j; // [rsp+2Ch] [rbp-2AB4h] BYREF
  _BYTE stringstream[16]; // [rsp+30h] [rbp-2AB0h] BYREF
  _BYTE v65[384]; // [rsp+40h] [rbp-2AA0h] BYREF
  _BYTE vvi_1[32]; // [rsp+1C0h] [rbp-2920h] BYREF
  _BYTE vvpii[32]; // [rsp+1E0h] [rbp-2900h] BYREF
  _BYTE vvi[32]; // [rsp+200h] [rbp-28E0h] BYREF
  _BYTE vi[32]; // [rsp+220h] [rbp-28C0h] BYREF
  _BYTE v70[40]; // [rsp+240h] [rbp-28A0h] BYREF
  _BYTE v71[8]; // [rsp+268h] [rbp-2878h] BYREF
  _BYTE v72[5008]; // [rsp+270h] [rbp-2870h] BYREF
  _BYTE random_device_constructor[5015]; // [rsp+1600h] [rbp-14E0h] BYREF
  char v74; // [rsp+2997h] [rbp-149h] BYREF
  int v75; // [rsp+2998h] [rbp-148h] BYREF
  char v76; // [rsp+299Fh] [rbp-141h] BYREF
  _BYTE v77[39]; // [rsp+29A0h] [rbp-140h] BYREF
  char v78; // [rsp+29C7h] [rbp-119h] BYREF
  int v79; // [rsp+29C8h] [rbp-118h] BYREF
  char v80; // [rsp+29CFh] [rbp-111h] BYREF
  _BYTE v81[35]; // [rsp+29D0h] [rbp-110h] BYREF
  char v82; // [rsp+29F3h] [rbp-EDh] BYREF
  _BYTE v83[11]; // [rsp+29F4h] [rbp-ECh] BYREF
  char v84; // [rsp+29FFh] [rbp-E1h] BYREF
  _BYTE v85[31]; // [rsp+2A00h] [rbp-E0h] BYREF
  char v86; // [rsp+2A1Fh] [rbp-C1h] BYREF
  _BYTE v87[32]; // [rsp+2A20h] [rbp-C0h] BYREF
  char *v88; // [rsp+2A40h] [rbp-A0h]
  char *v89; // [rsp+2A48h] [rbp-98h]
  char *v90; // [rsp+2A50h] [rbp-90h]
  char *v91; // [rsp+2A58h] [rbp-88h]
  char *v92; // [rsp+2A60h] [rbp-80h]
  char *v93; // [rsp+2A68h] [rbp-78h]
  char *v94; // [rsp+2A70h] [rbp-70h]
  int v95; // [rsp+2A78h] [rbp-68h]
  int v96; // [rsp+2A7Ch] [rbp-64h]
  _DWORD *v97; // [rsp+2A80h] [rbp-60h]
  __int64 v98; // [rsp+2A88h] [rbp-58h]
  __int64 v99; // [rsp+2A90h] [rbp-50h]
  _BYTE *vvi_1_cp; // [rsp+2A98h] [rbp-48h]
  int v101; // [rsp+2AA4h] [rbp-3Ch]
  int v102; // [rsp+2AA8h] [rbp-38h]
  int kk; // [rsp+2AACh] [rbp-34h]
  int jj; // [rsp+2AB0h] [rbp-30h]
  int ii; // [rsp+2AB4h] [rbp-2Ch]
  int n; // [rsp+2AB8h] [rbp-28h]
  int m; // [rsp+2ABCh] [rbp-24h]
  int i; // [rsp+2AC0h] [rbp-20h]
  int v109; // [rsp+2AC4h] [rbp-1Ch]
  int v110; // [rsp+2AC8h] [rbp-18h]
  int v111; // [rsp+2ACCh] [rbp-14h]

  std::random_device::random_device((std::random_device *)random_device_constructor);
  random_device = std::random_device::operator()(random_device_constructor, argv);
  std::mersenne_twister_engine<unsigned long,32ul,624ul,397ul,31ul,2567483615ul,11ul,4294967295ul,7ul,2636928640ul,15ul,4022730752ul,18ul,1812433253ul>::mersenne_twister_engine(
    v72,
    random_device);
  std::random_device::~random_device((std::random_device *)random_device_constructor);
  std::uniform_int_distribution<int>::uniform_int_distribution(v71, 0LL, 255LL);
  std::string::basic_string(v70);
  std::operator>><char>(&std::cin, v70);
  if ( (unsigned __int64)std::string::length(v70) > 3 )
  {
    v94 = &v74;
    v5 = std::string::end(v70);
    v6 = std::string::begin(v70);
    std::vector<int>::vector<__gnu_cxx::__normal_iterator<char *,std::string>,void>(vi, v6, v5, &v74);
    std::__new_allocator<int>::~__new_allocator(&v74);
    v7 = std::vector<int>::size(vi);
    v8 = std::sqrt<unsigned long>(v7);
    v102 = (int)ceil(v8);
    v101 = v102 * v102;
    v75 = std::uniform_int_distribution<int>::operator()<std::mersenne_twister_engine<unsigned long,32ul,624ul,397ul,31ul,2567483615ul,11ul,4294967295ul,7ul,2636928640ul,15ul,4022730752ul,18ul,1812433253ul>>(
            v71,
            v72);
    std::vector<int>::resize(vi, v101, &v75);
    v92 = &v76;
    v93 = &v78;
    v79 = 0;
    std::vector<int>::vector(v77, v102, &v79, &v78);
    std::vector<std::vector<int>>::vector(vvi, v102, v77, &v76);
    std::vector<int>::~vector(v77);
    std::__new_allocator<int>::~__new_allocator(&v78);
    std::__new_allocator<std::vector<int>>::~__new_allocator(&v76);
    v111 = 0;
    v110 = 0;
    v109 = 0;
    for ( i = 0; i < v101; ++i )
    {
      v9 = *(_DWORD *)std::vector<int>::operator[](vi, i);
      v10 = std::vector<std::vector<int>>::operator[](vvi, v111);
      *(_DWORD *)std::vector<int>::operator[](v10, v110) = v9;
      if ( !v109
        && (v102 == v110 + 1
         || (v11 = std::vector<std::vector<int>>::operator[](vvi, v111),
             *(_DWORD *)std::vector<int>::operator[](v11, v110 + 1))) )
      {
        v109 = 1;
      }
      else if ( v109 == 1
             && (v102 == v111 + 1
              || (v13 = std::vector<std::vector<int>>::operator[](vvi, v111 + 1),
                  *(_DWORD *)std::vector<int>::operator[](v13, v110))) )
      {
        v109 = 2;
      }
      else if ( v109 == 2
             && (!v110
              || (v15 = std::vector<std::vector<int>>::operator[](vvi, v111),
                  *(_DWORD *)std::vector<int>::operator[](v15, v110 - 1))) )
      {
        v109 = 3;
      }
      else if ( v109 == 3 )
      {
        if ( !v111
          || (v17 = std::vector<std::vector<int>>::operator[](vvi, v111 - 1),
              *(_DWORD *)std::vector<int>::operator[](v17, v110)) )
        {
          v109 = 0;
        }
      }
      if ( v109 == 3 )
      {
        --v111;
      }
      else if ( v109 <= 3 )
      {
        if ( v109 == 2 )
        {
          --v110;
        }
        else if ( v109 )
        {
          if ( v109 == 1 )
            ++v111;
        }
        else
        {
          ++v110;
        }
      }
    }
    v90 = &v80;
    v91 = &v82;
    std::vector<std::pair<int,int>>::vector(v81, v102, &v82);
    std::vector<std::vector<std::pair<int,int>>>::vector(vvpii, v102, v81, &v80);
    std::vector<std::pair<int,int>>::~vector(v81);
    std::__new_allocator<std::pair<int,int>>::~__new_allocator(&v82);
    std::__new_allocator<std::vector<std::pair<int,int>>>::~__new_allocator(&v80);
    for ( j = 0; v102 > j; ++j )
    {
      for ( k = 0; v102 > k; ++k )
      {
        std::pair<int,int>::pair<int &,int &,true>(v83, &j, &k);
        v19 = std::vector<std::vector<std::pair<int,int>>>::operator[](vvpii, j);
        v20 = std::vector<std::pair<int,int>>::operator[](v19, k);
        std::pair<int,int>::operator=(v20, v83);
      }
    }
    for ( m = 0; m < v102 * v102; ++m )
    {
      v21 = std::uniform_int_distribution<int>::operator()<std::mersenne_twister_engine<unsigned long,32ul,624ul,397ul,31ul,2567483615ul,11ul,4294967295ul,7ul,2636928640ul,15ul,4022730752ul,18ul,1812433253ul>>(
              v71,
              v72);
      v96 = v21 % v102;
      v22 = std::uniform_int_distribution<int>::operator()<std::mersenne_twister_engine<unsigned long,32ul,624ul,397ul,31ul,2567483615ul,11ul,4294967295ul,7ul,2636928640ul,15ul,4022730752ul,18ul,1812433253ul>>(
              v71,
              v72);
      v95 = v22 % v102;
      v23 = std::vector<std::vector<std::pair<int,int>>>::operator[](vvpii, v96);
      v24 = std::vector<std::pair<int,int>>::operator[](v23, v95);
      v25 = std::vector<std::vector<std::pair<int,int>>>::operator[](vvpii, m / v102);
      v26 = std::vector<std::pair<int,int>>::operator[](v25, m % v102);
      std::swap<int,int>(v26, v24);
    }
    v88 = &v84;
    v89 = &v86;
    std::vector<int>::vector(v85, v102, &v86);
    std::vector<std::vector<int>>::vector(vvi_1, v102, v85, &v84);
    std::vector<int>::~vector(v85);
    std::__new_allocator<int>::~__new_allocator(&v86);
    std::__new_allocator<std::vector<int>>::~__new_allocator(&v84);
    for ( n = 0; n < v102; ++n )
    {
      for ( ii = 0; ii < v102; ++ii )
      {
        v27 = std::vector<std::vector<std::pair<int,int>>>::operator[](vvpii, n);
        v28 = (int *)std::vector<std::pair<int,int>>::operator[](v27, ii);
        v29 = std::vector<std::vector<int>>::operator[](vvi, *v28);
        v30 = std::vector<std::vector<std::pair<int,int>>>::operator[](vvpii, n);
        v31 = std::vector<std::pair<int,int>>::operator[](v30, ii);
        LODWORD(v29) = *(_DWORD *)std::vector<int>::operator[](v29, *(int *)(v31 + 4));
        v32 = std::vector<std::vector<int>>::operator[](vvi_1, n);
        *(_DWORD *)std::vector<int>::operator[](v32, ii) = v29;
      }
    }
    vvi_1_cp = vvi_1;
    vvi_iter = std::vector<std::vector<int>>::begin(vvi_1);
    vvi_end = std::vector<std::vector<int>>::end(vvi_1_cp);
    while ( (unsigned __int8)__gnu_cxx::operator!=<std::vector<int> *,std::vector<std::vector<int>>>(
                               &vvi_iter,
                               &vvi_end) )
    {
      v99 = __gnu_cxx::__normal_iterator<std::vector<int> *,std::vector<std::vector<int>>>::operator*(&vvi_iter);
      v98 = v99;
      v59 = std::vector<int>::begin(v99);
      v58 = std::vector<int>::end(v98);
      while ( (unsigned __int8)__gnu_cxx::operator!=<int *,std::vector<int>>(&v59, &v58) )
      {
        v97 = (_DWORD *)__gnu_cxx::__normal_iterator<int *,std::vector<int>>::operator*(&v59);
        *v97 *= 8;
        __gnu_cxx::__normal_iterator<int *,std::vector<int>>::operator++(&v59);
      }
      __gnu_cxx::__normal_iterator<std::vector<int> *,std::vector<std::vector<int>>>::operator++(&vvi_iter);
    }
    std::basic_stringstream<char,std::char_traits<char>,std::allocator<char>>::basic_stringstream(stringstream);
    for ( jj = 0; jj < v102; ++jj )
    {
      for ( kk = 0; kk < v102; ++kk )
      {
        if ( jj || kk )
          std::operator<<<std::char_traits<char>>(v65, "-");
        v33 = std::setfill<char>(48LL);
        v34 = std::operator<<<char,std::char_traits<char>>(v65, v33);
        v35 = std::setw(2);
        v36 = std::operator<<<char,std::char_traits<char>>(v34, v35);
        v37 = std::ostream::operator<<(v36, std::hex);
        v38 = std::vector<std::vector<std::pair<int,int>>>::operator[](vvpii, jj);
        v39 = (unsigned int *)std::vector<std::pair<int,int>>::operator[](v38, kk);
        v40 = std::ostream::operator<<(v37, *v39);
        v41 = std::setfill<char>(48LL);
        v42 = std::operator<<<char,std::char_traits<char>>(v40, v41);
        v43 = std::setw(2);
        v44 = std::operator<<<char,std::char_traits<char>>(v42, v43);
        v45 = std::ostream::operator<<(v44, std::hex);
        v46 = std::vector<std::vector<std::pair<int,int>>>::operator[](vvpii, jj);
        v47 = std::vector<std::pair<int,int>>::operator[](v46, kk);
        v48 = std::ostream::operator<<(v45, *(unsigned int *)(v47 + 4));
        v49 = std::setfill<char>(48LL);
        v50 = std::operator<<<char,std::char_traits<char>>(v48, v49);
        v51 = std::setw(4);
        v52 = std::operator<<<char,std::char_traits<char>>(v50, v51);
        v53 = std::ostream::operator<<(v52, std::hex);
        vi_1 = std::vector<std::vector<int>>::operator[](vvi_1, jj);
        v55 = (unsigned int *)std::vector<int>::operator[](vi_1, kk);
        std::ostream::operator<<(v53, *v55);
      }
    }
    std::basic_stringstream<char,std::char_traits<char>,std::allocator<char>>::str(v87, stringstream);
    output_2 = std::operator<<<char>(&std::cout, v87);
    std::ostream::operator<<(output_2, &std::endl<char,std::char_traits<char>>);
    std::string::~string(v87);
    std::basic_stringstream<char,std::char_traits<char>,std::allocator<char>>::~basic_stringstream(stringstream);
    std::vector<std::vector<int>>::~vector(vvi_1);
    std::vector<std::vector<std::pair<int,int>>>::~vector(vvpii);
    std::vector<std::vector<int>>::~vector(vvi);
    std::vector<int>::~vector(vi);
  }
  else
  {
    output = std::operator<<<std::char_traits<char>>(&std::cout, "Input is too short!");
    std::ostream::operator<<(output, &std::endl<char,std::char_traits<char>>);
  }
  std::string::~string(v70);
  return 0;
}
