# checksum - Flare-On 11

## Description

We recently came across a silly executable that appears benign. It just asks us to do some math... From the strings found in the sample, we suspect there are more to the sample than what we are seeing. Please investigate and let us know what you find!<br>
7zip archive password: flare

## Files

```
$ file checksum.7z 
checksum.7z: 7-zip archive data, version 0.4
$ 7z x checksum.7z 

7-Zip [64] 16.02 : Copyright (c) 1999-2016 Igor Pavlov : 2016-05-21
p7zip Version 16.02 (locale=en_US.UTF-8,Utf16=on,HugeFiles=on,64 bits,8 CPUs LE)

Scanning the drive for archives:
1 file, 1392978 bytes (1361 KiB)

Extracting archive: checksum.7z

Enter password (will not be echoed):
--
Path = checksum.7z
Type = 7z
Physical Size = 1392978
Headers Size = 242
Method = LZMA2:3m BCJ 7zAES
Solid = -
Blocks = 1

Everything is Ok

Size:       2490368
Compressed: 1392978
$ file checksum.exe
checksum.exe: PE32+ executable (console) x86-64, for MS Windows, 15 sections
```

## Solution

Using Ghidra,
I'm able to get the decompiled .exe into the file `checksum.exe.c` in this challenge directory.
There's a lot of functions found:

```
_rt0_amd64
_rt0_amd64_windows
aeshashbody
callRet
cmpbody
debugCall1024
debugCall128
debugCall16384
debugCall2048
debugCall256
debugCall32
debugCall32768
debugCall4096
debugCall512
debugCall64
debugCall65536
debugCall8192
FUN_0047e21f
gcWriteBarrier
gogo
gosave_systemstack_switch
indexbytebody
memeqbody
polyHashADInternal
setg_gcc
sigtramp
type:.eq.struct_{_runtime.gList;_runtime.n_int32_}
```

All but `_rt0_amd64` and `_rt0_amd64_windows` seems to be dev made.
The two functions mentioned above should be the entry point of the program.

One interesting function is `aeshashbody`,
which seems to use AES encryption algorithm to encrypt a data.
It takes three parameters:

- `param_1`: A pointer to a 16-byte array of data to be hashed.
- `param_2`: An undefined 8-byte value.
- `param_3`: A 32-bit integer that specifies the number of rounds to be used in the hashing algorithm.

The function first initializes a 16-byte array `auVar2` with the `param_2` and `param_3` values.
It then performs an AES encryption operation on `auVar2` using the first 16 bytes of the AES key schedule `runtime.aeskeysched`.

Next, the function checks the value of `param_3`:

- If `param_3` is 0, it performs two more AES encryption operations on `auVar2` and returns the result.
- If `param_3` is less than 16, it performs a single AES encryption operation on `auVar2` and returns the result.
- If `param_3` is greater than 16, it performs multiple AES encryption operations on `auVar2` and returns the result.
- The specific operations performed depend on the value of `param_3`. For example, if `param_3` is greater than 64, the function performs 8 rounds of AES encryption.

Overall, the `aeshashbody` function appears to be a relatively simple hashing algorithm that uses AES encryption to compute a hash value for a given input.
