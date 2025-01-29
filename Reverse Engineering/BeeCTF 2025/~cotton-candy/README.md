from the not-a-malware.exe, we know the encryption is a repeating 8-byte xor key.
Looking at store.txt hex view confirm this behaviour.
I just did frequency analysis, and xor it with the most common character, space (` `).
It's my fault to assume that it will all be ASCII,
and I probably going to feel bad about this for quite a whle.
