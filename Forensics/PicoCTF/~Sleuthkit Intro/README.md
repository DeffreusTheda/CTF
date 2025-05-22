# Sleuthkit Intro Writeup by Deffreus - PicoCTF 2022

###### Author: LT 'syreal' Jones

## Description

Download the disk image and use `mmls` on it to find the size of the Linux partition.<br>
Connect to the remote checker service to check your answer and get the flag.<br>
Note: if you are using the webshell, download and extract the disk image into `/tmp` not your home directory.<br>
[Download disk image](https://artifacts.picoctf.net/c/164/disk.img.gz)<br>
Access checker program: `nc saturn.picoctf.net 57365`

## Files 

```
$ file disk.img.gz 
disk.img.gz: gzip compressed data, was "disk.img", last modified: Tue Sep 21 19:34:53 2021, from Unix, original size modulo 2^32 104857600
$ gunzip disk.img.gz
$ file disk.img 
disk.img: DOS/MBR boot sector; partition 1 : ID=0x83, active, start-CHS (0x0,32,33), end-CHS (0xc,190,50), startsector 2048, 202752 sectors
```

## Solution

For Fedora, the utility `mmls` is provided in the package `sleuthkit`.

```
$ sudo dnf install sleuthkit -y
$ mmls disk.img 
DOS Partition Table
Offset Sector: 0
Units are in 512-byte sectors

      Slot      Start        End          Length       Description
000:  Meta      0000000000   0000000000   0000000001   Primary Table (#0)
001:  -------   0000000000   0000002047   0000002048   Unallocated
002:  000:000   0000002048   0000204799   0000202752   Linux (0x83)
```

There, we can see the Linux partition with length `202752`!
Seems like that's all we need,
so let's do it on the access checker program!

```
$ nc saturn.picoctf.net 58044                                
What is the size of the Linux partition in the given disk image?
Length in sectors: 202752
202752
Great work!
picoCTF{mm15_f7w!}
```

To be honest,
just using `file` was enough :p

FLAG: `picoCTF{mm15_f7w!}`
