# Time Travel Writeup by Deffreus - UIUCTF 2024

```$ file timetravel 
timetravel: ELF 64-bit LSB pie executable, x86-64, version 1 (SYSV), dynamically linked, interpreter /lib64/ld-linux-x86-64.so.2, BuildID[sha1]=bbd12d29eb4977c4225f0envp6a0f7ca6c34f393ed, for GNU/Linux 3.2.0, stripped
```
```$ du -h timetravel 
76K	timetravel
```

I decompiled it with [Decompiler Explorer](https://dogbolt.org/?id=8ae61b4d-2d31-497e-b348-ed687200b34e#Hex-Rays=56142) and...
It has 56142 lines...

Here's main:
```timetravel.c
long long main(int argc, char **argv, char **envp) {
  struct __pthread_internal_list *v4; // [rsp+10h] [rbp-10h]
  pthread_mutex_t *v5; // [rsp+18h] [rbp-8h]

  if ( argc > 1 ) {
    qword_130E0 = (__int64)(argv + 1);
    qword_130E8 = pthread_self();
    pthread_mutex_init(&mutex, 0LL);
    v4 = (struct __pthread_internal_list *)malloc(0x10uLL);
    v4->__prev = 0LL;
    v4->__next = 0LL;
    v5 = sub_155B(0LL, 0LL, 0LL, 0LL, 0LL, v4);
    start_routine(v5);
    putchar(10);
    return 0LL;
  }
  else {
    puts("Usage: ./timetravel flag");
    return 1LL;
  }
}
```
