Author: madStacks

I've hidden a flag in this file.
Can you find it?
[Forensics is fun.pptm](./Forensics is fun.pptm)

## Solution

`binwalk -e Forensics is fun.pptm`

Traverse the extracted zip,
found `hidden`.
Then [Cyberchef](https://gchq.github.io/CyberChef/#recipe=Find_/_Replace(%7B'option':'Regex','string':'%20'%7D,'',true,false,true,false)From_Base64('A-Za-z0-9-_',true,false)&input=WiBtIHggaCBaIHogbyBnIGMgRyBsIGogYiAwIE4gVSBSIG4gdCBFIE0gVyBSIGYgZCBWIDkgciBiIGogQiAzIFggMyBCIHcgZCBIIE4gZiBjIGwgOSA2IE0gWCBBIDEgZiBR)
