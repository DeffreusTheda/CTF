# APT-0-First Writeup by Deffreus - APT-0

###### Author: APT-0

## Description

The FBI seized a hacker's laptop and found these pictures of his cats on his desktop. They submitted them all as evidence. What is the flag and what did they find? 

Difficulty 2 / 5

Hint 1 - What is the practice of hiding a message, image, or file within another message, image, or file to conceal its existence called?

Hint 2 - https://stylesuxx.github.io/steganography/

Hint 3 - echo “text” | base64 -d” https://www.webatic.com/encoding-explorer

Hint 4 - https://8gwifi.org/pgpencdec.jsp 

## Files

```
$ file Kodiak.png Nero.png Virgil.png
Kodiak.png: PNG image data, 4153 x 5191, 8-bit/color RGBA, non-interlaced
Nero.png:   PNG image data, 4672 x 5840, 8-bit/color RGBA, non-interlaced
Virgil.png: PNG image data, 2723 x 3404, 8-bit/color RGBA, non-interlaced
```

## Solution

The hint just want us to use https://stylesuxx.github.io/steganography/

This challenge is very simple:

```
>be me
>15 minutes before lunch break
>decode each image with https://stylesuxx.github.io/steganography/
>"qwertyuiop", a PGP private key, a PGP message
>$ gpg --import pgp-priv-key
gpg: /home/effie/.gnupg/trustdb.gpg: trustdb created
gpg: key 4C10108D6B69183F: public key "Crazy Hacker <mentalproblem@gmail.com>" imported
gpg: key 4C10108D6B69183F: secret key imported
gpg: Total number processed: 1
gpg:               imported: 1
gpg:       secret keys read: 1
gpg:   secret keys imported: 1
>$ gpg -d pgp-message
gpg: encrypted with rsa1024 key, ID 4C10108D6B69183F, created 2024-08-03
      "Crazy Hacker <mentalproblem@gmail.com>"
gpg: WARNING: cipher algorithm CAST5 not found in recipient preferences
gpg: pgp-message: unknown suffix
Enter new filename [5867e4b6-2959-4f0f-81d8-67b8ce786e11]: decrypted
>$ cat decrypted   
Finally got some idiot at the hospital down the street to open my phishing link. It was just a word doc with a macro on it that opened up powershell and downloaded my ransomware LOL. I got access to their DC and encrypted their entire network. I'm demanding 2,500,000 million in BTC from them now. They said they would pay 1,000,000 and that really pissed me off so now im raising their price to 3,000,000.

FLAG: APT0-6w$SP6g&GwCwDF#B
```

Flag: APT0-6w$SP6g&GwCwDF#B
