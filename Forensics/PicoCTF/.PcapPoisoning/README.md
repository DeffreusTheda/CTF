# PcapPoisoning Writeup by Deffreus - PicoCTF 2023

###### Author: Mubarak Mikail

## Description

How about some hide and seek heh?<br>
Download this [file](https://artifacts.picoctf.net/c/376/trace.pcap) and find the flag.

## Files

```
$ file trace.pcap 
trace.pcap: pcap capture file, microsecond ts (little-endian) - version 2.4 (Raw IPv4, capture length 65535)
```

## Solution

Let's open it in Wireshark...

I'm looking by the TCP stream,
at stream 2,
there's this data: `    username root    password toor621fa37}`

That password seems like the last part of the flag...

Stream 3 to 502 all has the same text item (`text`): `gc2VjcmV0OiBwaWNvQ1RGe`,
sending it to port $n + 498$ where $n$ is the stream number.

Ah, I'm just blabbing nonsense.
Packet 507 just has this as its segment data: `picoCTF{P64P_4N4L7S1S_SU55355FUL_f621fa37}`
That's the flag?!

FLAG: `picoCTF{P64P_4N4L7S1S_SU55355FUL_f621fa37}`
