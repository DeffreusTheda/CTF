# rusty vault Writeup by Deffreus - DownUnderCTF 2024

```$ file rusty\ vault 
rusty vault: ELF 64-bit LSB pie executable, x86-64, version 1 (SYSV), dynamically linked, interpreter /lib64/ld-linux-x86-64.so.2, BuildID[sha1]=38425d269f3b1fb2903a2d76c477a3182676fd31, for GNU/Linux 3.2.0, not stripped
```
```$ du -h rusty\ vault 
444K	rusty vault
```

[Decompiler Explorer](https://dogbolt.org/?id=a2477b36-b1d9-4fa2-a4bc-f2b06ffd5cc7)

A 228 line `main` function...
I see AES256, I've never done something like this before...
So. Many. Arrays. And. Labels.
