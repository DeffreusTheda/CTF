# Wizardlike

###### Author: LT 'syreal' Jones

Do you seek your destiny in these deplorable dungeons?
If so, you may want to look elsewhere.
Many have gone before you and honestly, they've cleared out the place of all monsters, ne'erdowells, bandits and every other sort of evil foe.
The dungeons themselves have seen better days too.
There's a lot of missing floors and key passages blocked off.
You'd have to be a real wizard to make any progress in this sorry excuse for a dungeon!

Download the [game](https://artifacts.picoctf.net/c/206/game).

'`w`', '`a`', '`s`', '`d`' moves your character and '`Q`' quits.
You'll need to improvise some wizardly abilities to find the flag in this dungeon crawl.
'`.`' is floor, '`#`' are walls, '`<`' are stairs up to previous level, and '`>`' are stairs down to next level.

<details><summary>Hint 1</summary>
Different tools are better at different things.
Ghidra is awesome at static analysis, but radare2 is amazing at debugging.
</details>

<details><summary>Hint 2</summary>
With the right focus and preparation, you can teleport to anywhere on the map.
</details>

## Files

```sh
> file game  
game: ELF 64-bit LSB executable, x86-64, version 1 (GNU/Linux), statically linked, BuildID[sha1]=bf803af3e88b9fe61730fd601c91dd1be539feab, for GNU/Linux 3.2.0, stripped
```

## Solution

Just static analysis.
The map is on the read-only data!
The letters of the flag are spread on the map,
so just see each one of them and construct the flag!

To be honest the logic of the game is overwhelming.
Glad that's irrelevant,
otherwise I'll be having headache...

Flag: `picoCTF{ur_4_w1z4rd_8f4b04ae}`