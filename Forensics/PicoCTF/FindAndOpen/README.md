Author: Mubarak Mikail

Someone might have hidden the password in the trace file.
Find the key to unlock [this file](./flag.zip).
[this tracefile](./dump.pcap) might be good to analyze.

## Solution

`flag.zip` is password protected.
So, a .pcap! My fav thing to forensic to! :>
I look around with Wireshark,
and package 48 stands out with its length.
Took its `data.data` to [Cyberchef](https://gchq.github.io/CyberChef/#recipe=From_Base64('A-Za-z0-9%2B/%3D',true,false)&input=VkdocGN5QnBjeUIwYUdVZ2MyVmpjbVYwT2lCd2FXTnZRMVJHZTFJek5FUkpUa2RmVEU5TFpGOD0&oeol=FF),
and found a secret: `picoCTF{R34DING_LOKd_`.
Apparently, that's the password for `flag.zip`.
Extract it and you'll get `flag`!
