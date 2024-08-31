# Evil Jarkom Writeup by Deffreus - CompfestCTF 16

###### Author: k3ng

## Description

i am currently taking jarkom this semester and working on an assignment but the capture result is weird, a lot of random characters.

[traffic.pcapng](https://ctf.compfest.id/files/f422e391b4e27e5c67950faf5b58b85c/traffic.pcapng?token=eyJ1c2VyX2lkIjo3MiwidGVhbV9pZCI6MzA3LCJmaWxlX2lkIjo1OX0.ZrlrsQ.X5moBOo8YQTQwJJRJ7Pog4NbtpM)

## Files

```
$ file traffic.pcapng 
traffic.pcapng: pcap capture file, microsecond ts (little-endian) - version 2.4 (Ethernet, capture length 65535)
```

## Solution

Let's open it up with Wireshark...

43 `[4 bytes missing in capture file]`

Seems like 10.0.2.15 is the receiver,
all it does is just responding with ACK packets...

It's talking with 2 addresses, `146.190.202.4` and `91.189.91.42`.

### `91.189.91.42`

This address has literally no error package...
This address sends packages with SSLv2, so the data are encrypted.
No way...

### `146.190.202.4`

On quick overview,
the only notable things here is that there's quite a handful of "TCP ACKed unseed segment" packet,
around 10% of total packers.

[A guy](https://osqa-ask.wireshark.org/questions/46134/tcp-acked-unseen-segment/) said,

"TCP ACKed unseen segment" means that this packet acknowledges data that wasn't captured. It was transferred okay, and the receiver acknowledges it, but Wireshark can't find the packet in the capture. This usually happens when the capture device wasn't fast enough.

I thought this might be what the description is referring to,
but this is 'missing', not 'random'.

Most of the packets only sent a byte of data,
which might corresponding to one character...
There's almost 500 packets that we have here.

I tried to extract them with `tshark -r traffic.pcapng -Y 'ip.src == 146.190.202.4' -T fields -e data.data >data146`,
and strip some unwanted bytes at start and end of `data146`.
I tried seeing what it'll looks like with ASCII and here's what I got:

```py
>>> with open('data146') as file:
...    while line := file.readline():
...        print( chr(int(line[:2], 16)), end='' )
...
%[Yd$L+RT^{B2%P\q(RCnOL6czL&^oFpcjuHZOcdK*`'hMueDP#gZ1)F?P|~EST1-~6wdA;l:K5Vw{"`rspy3Tufi"cL^&$eNnk_3iq]i{+51L1|Os/43tChiss&_l8+IwM?cD~sex2:ke.?BNq(D!c!xgou$=<r^%Y3\v-N@rA1nGw{5u)8*+QVjMFiOtQvg!?BmQh$Dv'8tf8n&{:`v|??y`*"%eN_biU%Wt,_fPJqSH!o1Uxcv"v,46F#Q_G5SFA{dV1Y5R?bI?\]<eef,BnUHCJ6w&>F~T98bb_94Hx624p;4HJ9{dI8R(oc}
```
We know that the flag prefix is `COMPFEST16{`.
For each character, their position in that output is 20, 22, 46, 50, 56, 61, 62, 63, 64, 67, and 78, respectively.
The things I noticed with these 11 packets is that the length of them is 56, opposed to others, 60.

Let's extract them again: `tshark -r traffic.pcapng -Y 'ip.src == 146.190.202.4 && frame.len == 56' -T fields -e data.data >datalen56`

```solve.py
with open('datalen56') as file:
    while line := file.readline():
        print( chr(int(line[:2], 16)), end='' )
```

```
$ python3 solve.py
COMPFEST16{rfc_3514_security_bit_145eef449d}
```

THAT'S IT!

FLAG: `COMPFEST16{rfc_3514_security_bit_145eef449d}`
