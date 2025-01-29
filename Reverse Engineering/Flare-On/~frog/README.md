# frog - Flare-On 11

## Description

Welcome to Flare-On 11! Download this 7zip package, unzip it with the password 'flare', and read the README.txt file for launching instructions. It is written in PyGame so it may be runnable under many architectures, but also includes a pyinstaller created EXE file for easy execution on Windows. Your mission is get the frog to the "11" statue, and the game will display the flag. Enter the flag on this page to advance to the next stage. All flags in this event are formatted as email addresses ending with the @flare-on.com domain.

## Files

```
$ file frog.7z 
frog.7z: 7-zip archive data, version 0.4
$ 7z x frog.7z 

7-Zip [64] 16.02 : Copyright (c) 1999-2016 Igor Pavlov : 2016-05-21
p7zip Version 16.02 (locale=en_US.UTF-8,Utf16=on,HugeFiles=on,64 bits,8 CPUs LE)

Scanning the drive for archives:
1 file, 10653489 bytes (11 MiB)

Extracting archive: frog.7z

Enter password (will not be echoed):
--
Path = frog.7z
Type = 7z
Physical Size = 10653489
Headers Size = 529
Method = LZMA2:24 BCJ 7zAES
Solid = +
Blocks = 2

Everything is Ok  

Folders: 2
Files: 10
Size:       13542963
Compressed: 10653489
$ file frog.exe frog.py   
frog.exe: PE32 executable (console) Intel 80386, for MS Windows, 5 sections
frog.py:  Python script, ASCII text executable, with CRLF line terminators
$ cat README.txt        
This game about a frog is written in PyGame. The source code is provided, as well as a runnable pyinstaller EXE file.

To launch the game run frog.exe on a Windows computer. Otherwise, follow these basic python execution instructions:

1. Install Python 3
2. Install PyGame ("pip install pygame")
3. Run frog: "python frog.py"
```

## Solution

Rather than executing the program, we can look at how the flag will be printed!
Let's see what the victory condition is:

```frog.py
# are they on the victory tile? if so do victory
if player.x == victory_tile.x and player.y == victory_tile.y:
    victory_mode = True
    flag_text = GenerateFlagText(player.x, player.y)
    flag_text_surface = flagfont.render(flag_text, False, pygame.Color('black'))
    print("%s" % flag_text)
```

At line 12, we can see `victory_tile = pygame.Vector2(10, 10)`, thus `10` and `10` would be passed to `GenerateFlagText`.
The main thing here, it will print `flag_text` from the return value of `GenerateFlagText(player.x, player.y)`:

```frog.py
def GenerateFlagText(x, y):
    key = x + y*20
    encoded = "\xa5\xb7\xbe\xb1\xbd\xbf\xb7\x8d\xa6\xbd\x8d\xe3\xe3\x92\xb4\xbe\xb3\xa0\xb7\xff\xbd\xbc\xfc\xb1\xbd\xbf"
    return ''.join([chr(ord(c) ^ key) for c in encoded])
```

```
$ python3
Python 3.12.6 (main, Sep  9 2024, 00:00:00) [GCC 14.2.1 20240801 (Red Hat 14.2.1-1)] on linux
Type "help", "copyright", "credits" or "license" for more information.
>>> x = 10
>>> y = 10
>>> key = x + y*20
>>> encoded = "\xa5\xb7\xbe\xb1\xbd\xbf\xb7\x8d\xa6\xbd\x8d\xe3\xe3\x92\xb4\xbe\xb3\xa0\xb7\xff\xbd\xbc\xfc\xb1\xbd\xbf"
>>> ''.join([chr(ord(c) ^ key) for c in encoded])
'welcome_to_11@flare-on.com'
>>> 
```

FLAG: `welcome_to_11@flare-on.com`
