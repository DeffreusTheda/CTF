# Sleuthkit Apprentice Writeup by Deffreus - PicoCTF 2022

###### Author: LT 'syreal' Jones

## Description

Download this disk image and find the flag.<br>
Note: if you are using the webshell, download and extract the disk image into `/tmp` not your home directory.

- [Download compressed disk image](https://artifacts.picoctf.net/c/138/disk.flag.img.gz)

## Files

```
$ file disk.flag.img.gz 
disk.flag.img.gz: gzip compressed data, was "disk.flag.img", last modified: Thu Mar 16 01:46:43 2023, from Unix, original size modulo 2^32 314572800
$ gunzip disk.flag.img.gz 
$ file disk.flag.img 
disk.flag.img: DOS/MBR boot sector; partition 1 : ID=0x83, active, start-CHS (0x0,32,33), end-CHS (0xc,223,19), startsector 2048, 204800 sectors; partition 2 : ID=0x82, start-CHS (0xc,223,20), end-CHS (0x16,111,25), startsector 206848, 153600 sectors; partition 3 : ID=0x83, start-CHS (0x16,111,26), end-CHS (0x26,62,24), startsector 360448, 253952 sectors
```

## Solution

As we learned in previous Sleuthkit challenge, we can use `mmls` to display the partition layout of a volume system (partition tables):

```
$ mmls disk.flag.img 
DOS Partition Table
Offset Sector: 0
Units are in 512-byte sectors

      Slot      Start        End          Length       Description
000:  Meta      0000000000   0000000000   0000000001   Primary Table (#0)
001:  -------   0000000000   0000002047   0000002048   Unallocated
002:  000:000   0000002048   0000206847   0000204800   Linux (0x83)
003:  000:001   0000206848   0000360447   0000153600   Linux Swap / Solaris x86 (0x82)
004:  000:002   0000360448   0000614399   0000253952   Linux (0x83)
```

We can just ignore the Linux Swap partition,
no way the flag would be there!
So, we have two partition to work on from here.
We know the start point,
so we can use `fsstat` to display general details of a file system.
We use the `-o` option to specify the partition start position,
and this option also present in various utility provided by Sleuthkit.
Let's see:

```
$ fsstat -o 2048 disk.flag.img
FILE SYSTEM INFORMATION
--------------------------------------------
File System Type: Ext4
Volume Name: 
Volume ID: 8e023955b4e7dab7e04b7643076ccf0f

Last Written at: 2021-09-30 01:10:02 (WIB)
Last Checked at: 2021-09-29 22:57:16 (WIB)

Last Mounted at: 2021-09-30 01:06:00 (WIB)
Unmounted properly
Last mounted on: /mnt/boot

Source OS: Linux
Dynamic Structure
Compat Features: Journal, Ext Attributes, Resize Inode, Dir Index
InCompat Features: Filetype, Extents, Flexible Block Groups, 
Read Only Compat Features: Sparse Super, Large File, Huge File, Extra Inode Size
<---snip--->
$ fsstat -o 360448 disk.flag.img    
FILE SYSTEM INFORMATION
--------------------------------------------
File System Type: Ext4
Volume Name: 
Volume ID: 3c054136f02898b3224bd632cbd6c255

Last Written at: 2021-09-29 22:57:31 (WIB)
Last Checked at: 2021-09-29 22:57:16 (WIB)

Last Mounted at: 2021-09-30 01:06:00 (WIB)
Unmounted properly
Last mounted on: /

Source OS: Linux
Dynamic Structure
Compat Features: Journal, Ext Attributes, Resize Inode, Dir Index
InCompat Features: Filetype, Extents, 64bit, Flexible Block Groups, 
Read Only Compat Features: Sparse Super, Large File, Huge File, Extra Inode Size
<---snip--->
```

Here, we can see that the first Linux partition was last mounted on `/mnt/boot`,
which means it's most likely a boot partition...
I don't think that's where the flag would be.

I guess we'll inspect the second Linux partition then,
the root partition.
Let's see what each files the root partition has.
We can use the command `fls` to list file and directory names in a disk image:

```
$ fls -o 360448 disk.flag.img 
d/d 451:	home
d/d 11:	lost+found
d/d 12:	boot
d/d 1985:	etc
d/d 1986:	proc
d/d 1987:	dev
d/d 1988:	tmp
d/d 1989:	lib
d/d 1990:	var
d/d 3969:	usr
d/d 3970:	bin
d/d 1991:	sbin
d/d 1992:	media
d/d 1993:	mnt
d/d 1994:	opt
d/d 1995:	root
d/d 1996:	run
d/d 1997:	srv
d/d 1998:	sys
d/d 2358:	swap
V/V 31745:	$OrphanFiles
```

I then tried every folder in root partition,
and there's something interesting in `/root`:

```
fls -r -o 360448 disk.flag.img 1995     
r/r 2363:	.ash_history
d/d 3981:	my_folder
+ r/r * 2082(realloc):	flag.txt
+ r/r 2371:	flag.uni.txt
```

The `-r` option let's us recursively list files.

Aight,
now we can use the command `icat` to output the contents of a file based on its inode number.

```
$ icat -o 360448 disk.flag.img 2082
            3.449677            13.056403
$ icat -o 360448 disk.flag.img 2371
picoCTF{by73_5urf3r_2f22df38}
```

OMG FEELS GOOD MAN

FLAG: `picoCTF{by73_5urf3r_2f22df38}`
