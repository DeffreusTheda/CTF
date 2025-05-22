Author: Orch4th

Budi is a vocational school student and a famous hacker in his class and has the mindset that things that exist in the real world can actually also be created in the digital world. Therefore, Budi tried to make a digital dinosaur called Cracknosaurus in the hope that the digital dinosaur he made could rule the world like the ancient dinosaurs of ancient times.

Cracknosaurus may look like an ordinary file, but you wouldn't know what Budi is hiding in this really extraordinary cracknosaurus image.

Hints
Cracknosaurus actually have a digital friend, namely rockyousaurus, which when combined can solve everything.

## Solution

`file` shows it's protected with AES.  
`zip2john flag.zip > flag.zip.txt`  
`john flag.zip.txt --wordlist=/usr/share/wordlists/rockyou.txt`
found pass: `tcpip`  
unzip -> `flag.jpeg`
`stegseek flag.jpeg /usr/share/wordlists/rockyou.txt`
