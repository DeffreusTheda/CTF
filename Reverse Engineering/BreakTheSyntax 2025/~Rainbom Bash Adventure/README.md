## Description

let her smash cloudz Art by bberni and me, but the better ones are by bberni

## Solution

Wow, a renpy challenge! I thought of making one and this guy already did it!
So i 'rg BtSCTF' the directory and I found `game/script.rpy` to be of interest.
Looking at the bottom of the file shows that it checks if the decrypted flag is correct.

```py
label ending:
    python:
        import hashlib


        flag = b""

        
        def xor(target, key):
            out = [c ^ key[i % len(key)] for i, c in enumerate(target)]
            return bytearray(out)


        def key_from_path(path):
            return hashlib.sha256(str(path).encode()).digest()


        def check_path(path, enc_flag):
            global flag
            flag1 = xor(enc_flag, key_from_path(path))
            flag2 = xor(enc_flag, key_from_path(list(reversed(path))))
            if flag1.startswith(b"BtSCTF"):
                flag = flag1
                print(flag)
                flag = bytes(flag).replace(b"{", b"{{").decode('ascii')
                return True
            if flag2.startswith(b"BtSCTF"):
                flag = flag2
                print(flag)
                flag = bytes(flag).replace(b"{", b"{{").decode('ascii')
                return True
            return False


        is_correct = check_path(nodes, bytearray(b'\xc2\x92\xf9\xf66\xe8\xa5\xa6\x17\xb6mGE\xcfQ\x90Mk:\x9a\xbb\x905&\x19\x8e\xc4\x9a\x0b\x1f\xf8C\xf4\xb9\xc9\x85R\xc2\xbb\x8d\x07\x94[R_\xf5z\x9fAl\x11\x9c\xbb\x9255\x08\x8e\xf6\xd6\x04'))
    if is_correct:
        rb "all cloudz smashed im the queen"
        rb "i got 100% swag"
        "[flag]"
    else:
        "Sadly, Rainbom Bash was too slow and wasn't able to smash all clouds."
    return
```

The way it decrypt it is using a stringified array `nodes`, hashlib it, and uses that as a key for simple xor decryption.
Now, we just need to find the right `nodes`.
Above are menus for choosing path to any 'cloud' from a certain 'cloud', apparently.
In each options are the cloud destination and it's distance.
Jumping to the top I found this prompt after some in-game dialogue script:

```
"Help Rainbom Bash smash all the clouds in the fastest possible way and return to the origin.
I heard it's a well known problem..."
```

This is...
the Travelling Salesman Problem!!
Just search it up.
It's funny how I've been taught of this in my Math class ehehe.
The distance between the clouds are the edges and of course, the clouds are the vertices.
So, it's clear what to do, except there's 20 nodes, and that's quite a lot! No way this can be done manually!
I gotta say the hardest part of this challenge for me is just finding a working TSP problem solver XD
I prompted Claude 3.7 Sonnet to solve this (took some prompts) and then he made `held_karp2.py`!
It solved it and here's the output:

```
Using provided custom matrix of shape (20, 20)
Solving TSP for 20x20 matrix...

Matrix preview (top-left corner):
[ 0 , 27207933 , 29257191 , 30767375 , 33358061 ]
[ 27207933 , 0 , 18723267 , 27461140 , 27706598 ]
[ 29257191 , 18723267 , 0 , 26971581 , 30094007 ]
[ 30767375 , 27461140 , 26971581 , 0 , 31156816 ]
[ 33358061 , 27706598 , 30094007 , 31156816 , 0 ]
Attempting exact solution with time limit of 3600 seconds...
Processing subsets of size 2/19...
Processing subsets of size 3/19...
Processing subsets of size 4/19...
Processing subsets of size 5/19...
Processing subsets of size 6/19...
Processing subsets of size 7/19...
Processing subsets of size 8/19...
Processing subsets of size 9/19...
Processing subsets of size 10/19...
Processing subsets of size 11/19...
Processing subsets of size 12/19...
Processing subsets of size 13/19...
Processing subsets of size 14/19...
Processing subsets of size 15/19...
Processing subsets of size 16/19...
Processing subsets of size 17/19...
Processing subsets of size 18/19...
Processing subsets of size 19/19...

Computation time: 19.25 seconds
Optimal tour cost: 358712694.0
Optimal tour: [0, 6, 4, 18, 16, 8, 3, 10, 9, 13, 19, 7, 17, 14, 11, 5, 1, 2, 15, 12, 0]

Verification:
Calculated tour cost: 1310334457
Reported tour cost: 358712694.0
Solution verification failed!
```

Yup! That's the path we need to take!
As I said before, we can just use this as `nodes` and that's it, got the flag! (See `solve.py`)

Flag: `BtSCTF{YOU_are_getting_20_percent_c00ler_with_this_one_!!_B)}`
