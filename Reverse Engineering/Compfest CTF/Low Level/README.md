# Low Level Writeup by Deffreus - CompfestCTF 16

###### Author: Zanark

## Description

I recently took a course in low level programming and made a program to simulate what you can do there. Can you find the flag? 

`nc challenges.ctf.compfest.id 9003
Attachments`

## Files

[chall](https://ctf.compfest.id/files/108148ea7925093540aa7edef2973751/chal?token=eyJ1c2VyX2lkIjo3MiwidGVhbV9pZCI6MzA3LCJmaWxlX2lkIjo3MX0.ZtKf5A.pimDUyALxr8IjWrmi5uRtKKtNdw)

It's another binary...
but it's HUGE, 60k lines?!
It's mostly just classes of some sort of a library,
something to do with `fmt`...
Noo, I don't think this is reversible without running it...

## Solution

[Dogbol](https://dogbolt.org/?id=f526f202-de37-4b07-8c95-db1701b3766f#Hex-Rays=61678)

## Notes

- RawVec reserve_for_push: https://github.com/rust-lang/rust/pull/91352
  - Just normal push, but with optimization.

1. filter ip.dest=.1
2. It has pattern, and it seems like the password is `changeme`, cuz it stopped there.
3. see from table, check what hash it's, and crack it.
4. see from the sql, the only non-`SELECT` query
5. employee_id=6 -> see on the table

FLAG: `COMPFEST16{h3lla_ez_DF1R_t4sK_f0r_4n_1nt3rN_b96818fd79}`
