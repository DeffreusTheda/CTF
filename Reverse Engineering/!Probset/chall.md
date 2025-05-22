BoyFriend:
srand((time)`now`) but `now` is get mod smth
encrypt each bytes with rand()

Vigenere++:
from encrypted vigenere cipher but each iteration is xored with it's iteration index (istg)
key = {len: 8; val: "h0u53k3y"}
flag is really long :>
chain bytes by bytes, cuz dependencies

Xorry:
xor two encrypted thing with the same key?
wow (you know)

con-cat:
```
char a = 'a';
char b = 'b';
char c = 'c';
char d = 'd';
long long i = (a << 24) | (b << 16) | (c << 8) | ((long long)'d' << 56); 
printf("%llx", i);
```

OBS:
an interactive deobfuscator contest, with polymorphic js obfuscation quizzes.
not a good idea.

(not) XOR:
desc: something is weird about the encrypted numbers...
XNOR encryption, overload ^ operator with XNOR
this overload should be obfuscated/hidden somehow

di-PHP in:
metamorphic PHP. i could just add some flag checker lines here. also obfuscate the labels so you can't just sort it :>
```
<?php goto l01;
l01: $filename = __FILE__;                       goto l02;
l02: $contents = file_get_contents($filename);   goto l03;
l03: $lines = explode("\n",$contents);           goto l04;
l04: $collection = array();                      goto l05;
l05: $pattern = '%^[^:]+:.*goto [^;]+;$%';       goto l06;
l06: $i = 0;                                     goto l07;
l07: /*while*/if ($i < count($lines))            goto l08; else goto l23;
l08:   $line = $lines[$i];                       goto l09;
l09:   $line = trim($line);                      goto l10;
l10:   if (substr($line,0,2) != '//')            goto l11; else goto l22;
l11:     if (preg_match($pattern, $line) === 1)  goto l12; else goto l13;
l12:       $collection[] = $line;                goto l22;
l13:       shuffle($collection);                 goto l14;
l14:       $j = 0;                               goto l15;
l15:       /*while*/if ($j < count($collection)) goto l16; else goto l19;
l16:         echo $collection[$j];               goto l17;
l17:         echo "\n";                          goto l18;
l18:         $j++;                               goto l15;
l19:       $collection = array();                goto l20;
l20:       echo $line;                           goto l21;
l21:       echo "\n";                            goto l22;
l22:   $i++;                                     goto l07;
l23: exit(0);                                    goto l23;
?>
```

Escape Code:
desc: can you escape?
using ANSII escape codes for printing flags, idk.
ANSII can del, move cursors, and suchs, interesting.
the program have rows of chars, and input can influence the coloring.
correct flag input creates a rainbow! :>

valentine gift:
desc: """this was my valentine gift for–
him."""
zsh script trickeries and shell wackeries for multiple prompts questions,
like an interactive story about me and him...
MUST be run to get the flag.
expand my IRLY.sm

shuffle:
https://www.youtube.com/watch?v=dr-jUCelobk
flag: `{bu7_wh47_d035_h3_kn0w?_1_f33l_50_4l0n3_4nd_m0m_4nd_d4d_w0uld_73ll_m3_1_4m_4lr16h7_b3c4u53_7h3_d0c70r_541d_1_4m_f1n3}`
algo:
- c + i//2 * (-1 if i & 1 == 1 else 1) for i, c in enumerate(flag)
- define poset that only have one possible result
- topological sort (selection sort)
  - pick the max of a set first
- output