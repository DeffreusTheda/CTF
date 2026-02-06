Lonely Squirrel Blues.

Haven't heard of this?

## Solution

I split the `.gif` frames into `.png`,
first I upload it to [this gif splitter](https://ezgif.com/split),
then downloaded the zip file.
It's a bunch of one frame gifs, and I just converted each into `.png`.
Then, do `zsteg` (my trusty stego tools :>) on each of them.
I do all of that in this command:

```
for F in frame_*; do ffmpeg -i "$F" "${F%gif}png" ; rm "$F"; zsteg "${F%gif}png"; done 
```

What I get is that each output of `b1,r,lsb,xy` for each respective frame gives:

```
part1:M5ZG6ZDON55US3S7ORUGKX3GNFSWYZC7N5TF62L:
part2:OMZXXE3LBORUW63S7ONSWG5LSNF2HSLC7JRSWC4:
part3:3UL5JWSZ3ONFTGSY3BNZ2F6QTJORZV6KCMKNBCS:
part4:X3BNRTW64TJORUG2X3JONPWC3S7NFWXA33SORQW:
part5:45C7ORXXA2LDL5XWMX3ENFZWG5LTONUW63T5:
```

I concatenated this all into [cyberchef](https://gchq.github.io/CyberChef/#recipe=From_Base32('A-Z2-7%3D',false)&input=TTVaRzZaRE9ONTVVUzNTN09SVUdLWDNHTkZTV1laQzdONVRGNjJMT01aWFhFM0xCT1JVVzYzUzdPTlNXRzVMU05GMkhTTEM3SlJTV0M0M1VMNUpXU1ozT05GVEdTWTNCTloyRjZRVEpPUlpWNktDTUtOQkNTWDNCTlJUVzY0VEpPUlVHMlgzSk9OUFdDM1M3TkZXWEEzM1NPUlFXNDVDN09SWFhBMkxETDVYV01YM0VORlpXRzVMVE9OVVc2M1Q1), and decoded it from Base32!
Got the flag!
