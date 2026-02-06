keke adalah admin suatu website, namun di suatu hari ia tidak bisa login, hal itu terjadi karena keke tidak memeriksa aturan edit profile
.
Tolong bantu keke menemukan nama usernamenya

    Format flag: FGTE{username}

## Solution

```
 $ rg -u username
README.md
3:Tolong bantu keke menemukan nama usernamenya
5:    Format flag: FGTE{username}

Mistakez.pcap: binary file matches (found "\0" byte around offset 5)
```

Use `strings` and search for `username`, there'll be a lot of `=admin`, and the flag is the one with `=InfokanCaraMembantaiETS`
