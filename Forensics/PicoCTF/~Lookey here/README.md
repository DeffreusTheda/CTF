# Lookey here Writeup by Deffreus - PicoCTF 2022

###### Author: LT 'syreal' Jones / Mubarak Mikail

## Description

Attackers have hidden information in a very large mass of data in the past, maybe they are still doing it.<br>
Download the data [here](https://artifacts.picoctf.net/c/125/anthem.flag.txt).

<details><summary>Hint 1</summary>
	Download the file and search for the flag based on the known prefix.
</details>

## Files

```
$ file anthem.flag.txt 
anthem.flag.txt: Unicode text, UTF-8 text
```

It has 1721 lines...

## Solution

`rg` is better than `grep`!
Download it [here](https://github.com/BurntSushi/ripgrep)!

```
$ rg picoCTF 
anthem.flag.txt
933:      we think that the men of picoCTF{gr3p_15_@w3s0m3_58f5c024}
```

FLAG: `picoCTF{gr3p_15_@w3s0m3_58f5c024}`

No, it's `picoCTF{rg_15_m0r3_@w3s0m3_58f5c024}` (Joke)
