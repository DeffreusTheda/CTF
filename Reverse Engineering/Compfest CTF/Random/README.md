# Random Writeup by Deffreus - CompfestCTF 16

###### Author: Zanark

## Description

With this random, I could create a script to mess up everything.

[script.py](https://ctf.compfest.id/files/f4b5df8636cb5b269e16915795a069cb/script.py?token=eyJ1c2VyX2lkIjo3MiwidGVhbV9pZCI6MzA3LCJmaWxlX2lkIjo0MX0.Zq7XMA.iUM9jk4pnUkpY4al4ZYv7HgA3Ik)

## Files

```script.py
import random

flag = "" # REDACTED

random.seed(int(flag[8:10]))
for c in flag[:8]:
    random.seed(random.randint(1, 0xCF) + ord(c))

destroyed = ""

for char in flag:
    offset = random.randint(1, 10)
    MyFriend = random.randint(1, 127)
    result = (ord(char) - offset) ^ MyFriend

    if random.randint(0, 1):
        result += 0x16
    
    destroyed += chr(result)

print(destroyed.encode("utf-8"))
# b'!vP3\xc2\x91\xc2\x89\x11\x1f\x06C\x17_\x19t)\xc2\x929\x06li\x1d\x1f\xc2\x88*\x19E+4E\x16\x07v1S$\x1a c\x1flcr4> 3vlt\xc2\x85Yj-$0 '
```

## Solution

We know that the first 11 byte of the flag is `COMPFEST16{`.
We now have this:

```script.py
import random

flag = "COMPFEST16{" # PRUNED

random.seed(int(flag[8:10]))
for c in flag[:8]:
    random.seed(random.randint(1, 0xCF) + ord(c))

destroyed = ""

for char in flag:
    offset = random.randint(1, 10)
    MyFriend = random.randint(1, 127)
    result = (ord(char) - offset) ^ MyFriend

    if random.randint(0, 1):
        result += 0x16
    
    destroyed += chr(result)

print(destroyed.encode("utf-8"))
# b'!vP3\xc2\x91\xc2\x89\x11\x1f\x06C\x17_\x19t)\xc2\x929\x06li\x1d\x1f\xc2\x88*\x19E+4E\x16\x07v1S$\x1a c\x1flcr4> 3vlt\xc2\x85Yj-$0 '
```

Now, just simply reverse each operation, and we would have our `solve.py`:

```solve.py
import random

encoded = b'!vP3\xc2\x91\xc2\x89\x11\x1f\x06C\x17_\x19t)\xc2\x929\x06li\x1d\x1f\xc2\x88*\x19E+4E\x16\x07v1S$\x1a c\x1flcr4> 3vlt\xc2\x85Yj-$0 '
decoded = encoded.decode("utf-8")

flag = "COMPFEST16{"
random.seed(int(flag[8:10]))
for c in flag[:8]:
    random.seed(random.randint(1, 0xCF) + ord(c))

for char in decoded:
    result = ord(char)
    offset = random.randint(1, 10)
    MyFriend = random.randint(1, 127)
    if random.randint(0, 1):
        result -= 0x16
    result = (result ^ MyFriend) + offset
    print(chr(result), end='')
```

```
$ python3 solve.py
COMPFEST16{C0mpu73r_c0uld_n0t_m4k3_Tru3_R4nd_0be49a7429}
```

There's the flag!

Flag: `COMPFEST16{C0mpu73r_c0uld_n0t_m4k3_Tru3_R4nd_0be49a7429}`
