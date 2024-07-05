# Goose Chase Writeup by Deffreus - UIUCTF 2024

Huh, who's knocking??<br>
\**peek*<br>
mfw 
```$ du -h Goose.dmp 
233M	Goose.dmp
```

Oh lord, that's a HUGE goose.

## Introduct yourself!

## .dmp

```$ file Goose.dmp 
Goose.dmp: Mini DuMP crash report, 18 streams, Sat Jun 15 20:19:10 2024, 0x621826 type
```

A crash... that's kinda scary >_<

"A .dmp file is a type of file extension that contains data that has been “dumped” from the memory space of a computer program. These files are often created when an error occurs, or a program crashes. A DMP file can be used by technical professionals or advanced computer users to troubleshoot system errors and other application issues."

I guess that's what reverse engineering is for!<br>

2,310,626 lines of strings.
It's scary, I see a lot C functions, which you know,<br>
C is hell let loose when talking about memory access.

but, the other file...

## .pcapng

```$ file evidence.pcapng 
evidence.pcapng: pcapng capture file - version 1.0
```

"A .pcapng file is a packet capture file format used to record network traffic. It is designed to be a more efficient and extensible format than the traditional PCAP format. PCAPNG files use a binary format and can store multiple streams of data, including packets, metadata, and annotations."

Wireshark seems promising for this.
I mean like it's made for this, LOL XD

## What to do?

Obviously, `Goose.dmp` is the main thing here (I think?).
So, how do I analyze the .dmp file?

From what I've been digging, this .dmp is produced from a Windows machine (ew).
APPARENTLY, I need this `windbg` program to analyze this file!

You know, I'm on an Apple Mac M1 right now.
There's way to run Windows on it but:

1. I'm lazy (and tired)
2. Windows? No, thanks
3. No more storage (cuz dual boot)
4. Windows? No, thanks

So, I guess I'll pass this chall... :(
