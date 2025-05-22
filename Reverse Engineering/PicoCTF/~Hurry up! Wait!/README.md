# Hurry up! Wait! Writeup by Deffreus - PicoCTF 2021

```$ file svchost.exe 
svchost.exe: ELF 64-bit LSB pie executable, x86-64, version 1 (SYSV), dynamically linked, interpreter /lib64/ld-linux-x86-64.so.2, for GNU/Linux 3.2.0, BuildID[sha1]=0fb3d2b7a4d900676962a927b8181c15a8efbf0c, stripped
```
```$ du -h svchost.exe 
20K	svchost.exe
```

"20K? Quite small, it won't be that hard to Rev."

I used [Hex-Rays](https://dogbolt.org/?id=e0f44759-3086-44db-b30f-9fb0dbf901c0#Hex-Rays=822) to decompile the .exe.

```svchost.c
__int64 __fastcall main(int a1, char **a2, char **a3) {
  char v4[8]; // [rsp+28h] [rbp-8h] BYREF

  gnat_argc = a1;
  gnat_argv = (__int64)a2;
  gnat_envp = (__int64)a3;
  __gnat_initialize(v4);
  sub_1D7C();
  sub_298A();
  sub_1D52();
  __gnat_finalize();
  return (unsigned int)gnat_exit_status;
}
```

"Three custom functions... more that usual"

`__gnat_initialize` and `__gnat_finalize` isn't initialized, just declared.

The `sub_1D7C` initialize A LOT of variables, around 55 of them.

The `sub_298A`... it calls 28 other functions X_X
There's a lot of functions initialization above this functions, and all has a one-liner body: `return ada__text_io__put__4((_ptr *)&unk_XXXX);`.
There are other functions above those with different string parameter for the `ada__text_io__put__X` function, but they are never called.

The `sub_1D52` is the most sane looking of the three:
```svchost.c
__int64 sub_1D52()
{
  __int64 result; // rax

  result = (unsigned __int8)byte_204012 ^ 1u;
  if ( byte_204012 == 1 )
  {
    byte_204012 = 0;
    __gyat_runtime_finalize();
    return system__standard_library__adafinal();
  }
  return result;
}
```

From inspecting the decompiled codes, it seems certain to me, it's NOT meant to be reversed this way.
Maybe, it's intended to be run on Windows, the OS that most people use.
It may open an Ada doppelganger.
It also has string building things, either for hint or whatever else.

It is here, that I, Deffrues, surrender upon this challenge.
It's a disgrace to knight honor to use Windows.
I will protect my honor.
uwuwuwuwuwuw

> Some months later...

Dang, I feel like my writing style definitely changes now...
This is just similar to SNICTF's Huh challenge.
If you wanna see that writeup, 

Flag: `picoCTF{d15a5m_ftw_87e5ab1}`