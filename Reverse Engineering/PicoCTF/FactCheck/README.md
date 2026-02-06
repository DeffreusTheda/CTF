# FactCheck Writeup by Deffreus - PicoCTF 2024

```$ file bin
bin: ELF 64-bit LSB pie executable, x86-64, version 1 (SYSV), dynamically linked, interpreter /lib64/ld-linux-x86-64.so.2, BuildID[sha1]=ed9d01aa375e575eb2cd16506aa83d6951841f87, for GNU/Linux 3.2.0, not stripped
```

It's actually kinda refreshing to see non-stripped binary after a while.
Let's see what the (prettier) [decompiled](https://dogbolt.org/?id=b9c5b872-7e76-4b95-bc92-8eb9596e1510#Hex-Rays=409) code looks like:

```bin.c
int main(int argc, const char **argv, const char **envp) {
  long long v3; // rdx
  long long v4; // rdx
  long long v5; // rdx
  long long v6; // rdx
  long long v7; // rdx
  long long v8; // rdx
  long long v9; // rdx
  long long v10; // rdx
  long long v11; // rdx
  long long v12; // rdx
  long long v13; // rdx
  long long v14; // rdx
  long long v15; // rdx
  long long v16; // rdx
  long long v17; // rdx
  long long v18; // rdx
  int v19; // ebx
  char v21; // [rsp+Fh] [rbp-241h] BYREF
  char v22[32]; // [rsp+10h] [rbp-240h] BYREF
  char v23[32]; // [rsp+30h] [rbp-220h] BYREF
  char v24[32]; // [rsp+50h] [rbp-200h] BYREF
  char v25[32]; // [rsp+70h] [rbp-1E0h] BYREF
  char v26[32]; // [rsp+90h] [rbp-1C0h] BYREF
  char v27[32]; // [rsp+B0h] [rbp-1A0h] BYREF
  char v28[32]; // [rsp+D0h] [rbp-180h] BYREF
  char v29[32]; // [rsp+F0h] [rbp-160h] BYREF
  char v30[32]; // [rsp+110h] [rbp-140h] BYREF
  char v31[32]; // [rsp+130h] [rbp-120h] BYREF
  char v32[32]; // [rsp+150h] [rbp-100h] BYREF
  char v33[32]; // [rsp+170h] [rbp-E0h] BYREF
  char v34[32]; // [rsp+190h] [rbp-C0h] BYREF
  char v35[32]; // [rsp+1B0h] [rbp-A0h] BYREF
  char v36[32]; // [rsp+1D0h] [rbp-80h] BYREF
  char v37[32]; // [rsp+1F0h] [rbp-60h] BYREF
  char v38[40]; // [rsp+210h] [rbp-40h] BYREF

  std::allocator<char>::allocator(&v21, argv, envp);
  std::string::basic_string(v22, "picoCTF{wELF_d0N3_mate_", &v21);
  std::allocator<char>::~allocator(&v21);
  std::allocator<char>::allocator(&v21, "picoCTF{wELF_d0N3_mate_", v3);
  std::string::basic_string(v23, "7", &v21);
  std::allocator<char>::~allocator(&v21);
  std::allocator<char>::allocator(&v21, "7", v4);
  std::string::basic_string(v24, "5", &v21);
  std::allocator<char>::~allocator(&v21);
  std::allocator<char>::allocator(&v21, "5", v5);
  std::string::basic_string(v25, "4", &v21);
  std::allocator<char>::~allocator(&v21);
  std::allocator<char>::allocator(&v21, "4", v6);
  std::string::basic_string(v26, "3", &v21);
  std::allocator<char>::~allocator(&v21);
  std::allocator<char>::allocator(&v21, "3", v7);
  std::string::basic_string(v27, "6", &v21);
  std::allocator<char>::~allocator(&v21);
  std::allocator<char>::allocator(&v21, "6", v8);
  std::string::basic_string(v28, "9", &v21);
  std::allocator<char>::~allocator(&v21);
  std::allocator<char>::allocator(&v21, "9", v9);
  std::string::basic_string(v29, "a", &v21);
  std::allocator<char>::~allocator(&v21);
  std::allocator<char>::allocator(&v21, "a", v10);
  std::string::basic_string(v30, "e", &v21);
  std::allocator<char>::~allocator(&v21);
  std::allocator<char>::allocator(&v21, "e", v11);
  std::string::basic_string(v31, "3", &v21);
  std::allocator<char>::~allocator(&v21);
  std::allocator<char>::allocator(&v21, "3", v12);
  std::string::basic_string(v32, "d", &v21);
  std::allocator<char>::~allocator(&v21);
  std::allocator<char>::allocator(&v21, "d", v13);
  std::string::basic_string(v33, "b", &v21);
  std::allocator<char>::~allocator(&v21);
  std::allocator<char>::allocator(&v21, "b", v14);
  std::string::basic_string(v34, "1", &v21);
  std::allocator<char>::~allocator(&v21);
  std::allocator<char>::allocator(&v21, "1", v15);
  std::string::basic_string(v35, "6", &v21);
  std::allocator<char>::~allocator(&v21);
  std::allocator<char>::allocator(&v21, "6", v16);
  std::string::basic_string(v36, "e", &v21);
  std::allocator<char>::~allocator(&v21);
  std::allocator<char>::allocator(&v21, "e", v17);
  std::string::basic_string(v37, "c", &v21);
  std::allocator<char>::~allocator(&v21);
  std::allocator<char>::allocator(&v21, "c", v18);
  std::string::basic_string(v38, "8", &v21);
  std::allocator<char>::~allocator(&v21);
  if ( *(char *)std::string::operator[](v24, 0LL) <= 65 )
    std::string::operator+=(v22, v34);
  if ( *(_BYTE *)std::string::operator[](v35, 0LL) != 65 )
    std::string::operator+=(v22, v37);
  if ( "Hello" == "World" )
    std::string::operator+=(v22, v25);
  v19 = *(char *)std::string::operator[](v26, 0LL);
  if ( v19 - *(char *)std::string::operator[](v30, 0LL) == 3 )
    std::string::operator+=(v22, v26);
  std::string::operator+=(v22, v25);
  std::string::operator+=(v22, v28);
  if ( *(_BYTE *)std::string::operator[](v29, 0LL) == 71 )
    std::string::operator+=(v22, v29);
  std::string::operator+=(v22, v27);
  std::string::operator+=(v22, v36);
  std::string::operator+=(v22, v23);
  std::string::operator+=(v22, v31);
  std::string::operator+=(v22, 125LL);
  std::string::~string(v38);
  std::string::~string(v37);
  std::string::~string(v36);
  std::string::~string(v35);
  std::string::~string(v34);
  std::string::~string(v33);
  std::string::~string(v32);
  std::string::~string(v31);
  std::string::~string(v30);
  std::string::~string(v29);
  std::string::~string(v28);
  std::string::~string(v27);
  std::string::~string(v26);
  std::string::~string(v25);
  std::string::~string(v24);
  std::string::~string(v23);
  std::string::~string(v22);
  return 0;
}
```

omg it's so big.
Seems like it's a C++ code.
I can see the first part of the flag as `picoCTF{wELF_d0N3_mate_`.
You know what,
these `allocator` and `basic_string` bs is just an 'obfuscation' method!
These `allocator` serve no practical runtime purpose!
Not to mention these constructors and destructors!
If you look at it long enough,
you'll figure it out that it's just a verbose code for a small operation.
You can say that the first argument of these constructor are the variable name,
and the second argument as the value!
(Ignore the third argument)
If you assume that,
then the program would actually makes sense.
Here's what it looked like in its simplest form:

```bin.py
v22 = "picoCTF{wELF_d0N3_mate_"
v23 = "7"
v24 = "5"
v25 = "4"
v26 = "3"
v27 = "6"
v28 = "9"
v29 = "a"
v30 = "e"
v31 = "3"
v32 = "d"
v33 = "b"
v34 = "1"
v35 = "6"
v36 = "e"
v37 = "c"
v38 = "8"

if ord(v24[0]) <= 65:
    v22 += v34;
if ord(v35[0]) != 65:
    v22 += v37;
if "Hello" == "World":
  v22 += v25;
if ord(v26[0]) - ord(v30[0]) == 3:
    v22 += v26;
v22 += v25;
v22 += v28;
if ord(v29[0]) == 71:
    v22 += v29;
v22 += v27;
v22 += v36;
v22 += v23;
v22 += v31;
v22 += chr(125);
```

It's hella simple right?
Now let's just add `print(v22)` at the end of the code and run it!

```$ python3 bin.py
picoCTF{wELF_d0N3_mate_1c496e73}
```

Yup!
That's the flag!
As it said,
Well done!
