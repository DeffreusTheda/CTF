#include <defs.h>

long long xorMessage(long long a1, long long a2, long long a3);
int main(int argc, const char **argv, const char **envp);

const char aV[] = "v\""; // idb
void *_dso_handle = &_dso_handle; // idb
char _bss_start; // weak
_UNKNOWN std::__ioinit; // weak

long long xorMessage(long long a1, long long a2, long long a3) {
  char v3; // bl
  char v4; // bl
  int i; // [rsp+28h] [rbp-18h]
  int v8; // [rsp+2Ch] [rbp-14h]

  std::string::basic_string(a1, a2);
  v8 = std::string::length(a3);
  for ( i = 0; i < (unsigned long long)std::string::length(a2); ++i ) {
    v3 = *(_BYTE *)std::string::operator[](a2, i);
    v4 = *(_BYTE *)std::string::operator[](a3, i % v8) ^ v3;
    *(_BYTE *)std::string::operator[](a1, i) = v4;
  }
  return a1;
}

int main(int argc, const char **argv, const char **envp) {
  const char *v3; // rsi
  long long v4; // rdx
  int v5; // ebx
  long long v6; // rax
  char v8; // [rsp+1Fh] [rbp-281h] BYREF
  char v9[32]; // [rsp+20h] [rbp-280h] BYREF
  char v10[32]; // [rsp+40h] [rbp-260h] BYREF
  char v11[32]; // [rsp+60h] [rbp-240h] BYREF
  char v12[520]; // [rsp+80h] [rbp-220h] BYREF

  std::allocator<char>::allocator(&v8, argv, envp);
  v3 = argv[1];
  std::string::basic_string<std::allocator<char>>((long long)v9, v3, (long long)&v8);
  std::allocator<char>::~allocator(&v8);
  std::allocator<char>::allocator(&v8, v3, v4);
  std::string::basic_string<std::allocator<char>>((long long)v10, aV, (long long)&v8);
  std::allocator<char>::~allocator(&v8);
  xorMessage((long long)v11, (long long)v9, (long long)v10);
  std::ofstream::basic_ofstream(v12, "enc.txt", 16LL);
  if ( (unsigned __int8)std::ofstream::is_open(v12) != 1 ) {
    v5 = 1;
  } else {
    v6 = std::operator<<<char>(v12, v11);
    std::ostream::operator<<(v6, &std::endl<char,std::char_traits<char>>);
    std::ofstream::close(v12);
    v5 = 0;
  }
  std::ofstream::~ofstream(v12);
  std::string::~string(v11);
  std::string::~string(v10);
  std::string::~string(v9);
  return v5;
}
