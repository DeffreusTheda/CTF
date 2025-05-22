# WinAntiDbg0x100 Writeup by Deffreus - PicoCTF 2024

###### Author: Nandan Desai

## Description

This challenge will introduce you to 'Anti-Debugging.' Malware developers don't like it when you attempt to debug their executable files because debugging these files reveals many of their secrets! That's why, they include a lot of code logic specifically designed to interfere with your debugging process. Now that you've understood the context, go ahead and debug this Windows executable! This challenge binary file is a Windows console application and you can start with running it using cmd on Windows. Challenge can be downloaded here. Unzip the archive with the password picoctf

## Solution

All of the program output is into the detected debugger,
but it will only print "welcome" if you debug it,
and not the flag.
Since this is a 32-bit .exe,
I used x32Dbg, put a breakpoint at isDebuggerPresent,
modify its return value,
and run!
It prints the flag!
