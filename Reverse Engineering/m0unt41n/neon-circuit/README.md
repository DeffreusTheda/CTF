In the sprawling digital metropolis of NEXUS-42, a mysterious app called Neon Circuit has surfaced, claiming to provide untraceable access to the dark net. Your mission: infiltrate its native add-in, uncover the secrets hidden in its code, and expose the shadowy figure behind the chaos. 

## Solution

Call the .appimage with the flag `--appimage-extract` to extract the squashfs root.
Looking at the binary `neon-circuit`, there is nothing interesting, it's presumably just a library/engine.
I looked around and stumbled upon `./resources/app.asar`, which upon inspection, contains HTML code and JS scripts.
An interestingly-named function I found was 'checkPassword', called from an `nativeAddon` object of some sort.
At the end of `app.asar`, there is an ELF binary. I extracted it with ImHex, starting from the ELF magic header `\x7FELF` to EOF.
I then analyzed the native `CheckPassword` function in the binary.
https://claude.ai/chat/0d305261-9fe7-4701-8ca3-21633b4ba669.
```
*(__m128i *)buf = _mm_load_si128((const __m128i *)&A0CC8D9EA0CC8884CACDCFCD979C9E9Bh); // say this is A
*(_QWORD *)&s[16] = buf + 30;
*(_QWORD *)&s[8] = buf + 30;
*(__m128i *)(buf + 14) = _mm_load_si128((const __m128i *)&82CBCCCCCEA0CDCBA0ACAAA7CCB1A0CCh); // last two bytes of A is overwritten
```
If it's full 32 bytes, I got `dach2025{w3_ar3_3_N3XUS_42_1334}`, and removing `3_` makes the most sense.

Flag: `dach2025{w3_ar3_3_N3XUS_42_1334}`
