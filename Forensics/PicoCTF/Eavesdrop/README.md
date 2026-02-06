Author: LT 'syreal' Jones
Description
Download this packet capture and find the flag.

[Download packet capture](./capture.flag.pcap)

## Solution

.pcap!  
I opened it with Wireshark and look at the packets,
and there's seems like a chat here.
It can all be seen with Follow >> TCP Stream(Stream=0):
```
Hey, how do you decrypt this file again?

You're serious?

Yeah, I'm serious

*sigh* openssl des3 -d -salt -in file.des3 -out file.txt -k supersecretpassword123

Ok, great, thanks.

Let's use Discord next time, it's more secure.

C'mon, no one knows we use this program like this!

Whatever.

Hey.

Yeah?

Could you transfer the file to me again?

Oh great. Ok, over 9002?

Yeah, listening.

Sent it

Got it.

You're unbelievable
```

Welp, I see that there's another file here,
I just look around and found a packet that
contains `Salted` string, belonging to `openssl`.
I extracted it (Copy >> ...as a Base64 String >> `echo <>|base64 -d>file.des3`),
and used the command in the chat to decrypt it:
`openssl des3 -d -salt -in file.des3 -out file.txt -k supersecretpassword123`
There we have it!
