Author: Darkraicg492

## Description

Can you find the flag in this disk image?
Download the disk image [here](https://artifacts.picoctf.net/c/536/disko-1.dd.gz).

## Solution

```
> strings disko-1.dd | rg pico
:/icons/appicon
# $Id: piconv,v 2.8 2016/08/04 03:15:58 dankogai Exp $
piconv -- iconv(1), reinvented in perl
  piconv [-f from_encoding] [-t to_encoding]
  piconv -l
  piconv -r encoding_alias
  piconv -h
B<piconv> is perl version of B<iconv>, a character encoding converter
a technology demonstrator for Perl 5.8.0, but you can use piconv in the
piconv converts the character encoding of either STDIN or files
Therefore, when both -f and -t are omitted, B<piconv> just acts
picoCTF{1t5_ju5t_4_5tr1n9_c63b02ef}
```

Flag: `picoCTF{1t5_ju5t_4_5tr1n9_c63b02ef}`
