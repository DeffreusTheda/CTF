## Solution

$ python3 ~/bin/pyinstxtractor.py chall

upload extracted chall.pyc to PyLingual.io.

```
# Decompiled with PyLingual (https://pylingual.io)
# Internal filename: chall.py
# Bytecode version: 3.11a7e (3495)
# Source timestamp: 1970-01-01 00:00:00 UTC (0)

from Crypto.Util.number import *
flag = input('Input your flag >> ')
assert len(flag) == 33
flag = flag.encode()
x = bytes_to_long(flag[:19])
y = bytes_to_long(flag[19:26])
z = bytes_to_long(flag[26:])
if (2 5 4 4 | 3 | y) == 3402836797343125315216436061172783970695516266 and 3 5 == y or (2 5 4 4 | 5 5) == 5104255196014687972824654091829719426080829736 and (z == 3402836797343125315216436061196372081915006560) and (x, 2, y) == 3 | z:
    print('Correct!')
else:  # inserted
    print('False!')
```

The operator on the if statement is wrong.
Check bytecode representation.
Here's first check.

```
98 LOAD_CONST 7 (2)
100 LOAD_NAME 6 (x)
102 BINARY_OP 5
104 LOAD_CONST 8 (3)
106 LOAD_NAME 7 (y)
108 BINARY_OP 5
110 BINARY_OP 0
112 LOAD_CONST 9 (5)
114 LOAD_NAME 8 (z)
116 BINARY_OP 5
118 BINARY_OP 10
120 LOAD_CONST 10 (3402836797343125315216436061172783970695516266)
122 COMPARE_OP 2 (==)
124 POP_JUMP_FORWARD_IF_FALSE 70 (to 216)
```

This is postfix notation.
The other two is similar.
BINARY_OP takes two element on the stack and does the corresponding operation based on its operand.
e.g. @ line 102, 2 * 5.
There's little documentation for BINARY_OP so I grep my Python packages for BINARY_OP.
I got the followings:

```
BINARY_OP  0 (+)
BINARY_OP  5 (*)
BINARY_OP 10 (-)
```

```
$ rg -I 'BINARY_OP\s+5'
85:/System/Volumes/Data/opt/local/Library/Frameworks/Python.framework/Versions/3.12/lib/python3.12/test/test_dis.py:           BINARY_OP                5 (*)
97:/opt/local/Library/Frameworks/Python.framework/Versions/3.12/lib/python3.12/test/test_dis.py:           BINARY_OP                5 (*)
723:/Users/vinnie/CTF/Reverse Engineering/Compfest CTF/~PyASM/README.md:            574 BINARY_OP                5 (*)
732:/Users/vinnie/CTF/Reverse Engineering/Compfest CTF/~PyASM/chall:            574 BINARY_OP                5 (*)
1715:/opt/homebrew/Cellar/python@3.12/3.12.8/Frameworks/Python.framework/Versions/3.12/lib/python3.12/test/test_dis.py:           BINARY_OP                5 (*)
1727:/System/Volumes/Data/opt/homebrew/Cellar/python@3.12/3.12.8/Frameworks/Python.framework/Versions/3.12/lib/python3.12/test/test_dis.py:           BINARY_OP                5 (*)
1938:/System/Volumes/Data/opt/homebrew/Cellar/python@3.13/3.13.1/Frameworks/Python.framework/Versions/3.13/lib/python3.13/test/test_dis.py:              BINARY_OP                5 (*)
1950:/opt/homebrew/Cellar/python@3.13/3.13.1/Frameworks/Python.framework/Versions/3.13/lib/python3.13/test/test_dis.py:              BINARY_OP                5 (*)
2268:/opt/homebrew/Cellar/python@3.13/3.13.0_1/Frameworks/Python.framework/Versions/3.13/lib/python3.13/test/test_dis.py:              BINARY_OP                5 (*)
2280:/System/Volumes/Data/opt/homebrew/Cellar/python@3.13/3.13.0_1/Frameworks/Python.framework/Versions/3.13/lib/python3.13/test/test_dis.py:              BINARY_OP                5 (*)
2669:/System/Volumes/Data/Users/vinnie/CTF/Reverse Engineering/Compfest CTF/~PyASM/README.md:            574 BINARY_OP                5 (*)
2678:/System/Volumes/Data/Users/vinnie/CTF/Reverse Engineering/Compfest CTF/~PyASM/chall:            574 BINARY_OP                5 (*)

$ rg -I 'BINARY_OP\s+10'
715:/Users/vinnie/CTF/Reverse Engineering/Compfest CTF/~PyASM/README.md:            340 BINARY_OP               10 (-)
716:/Users/vinnie/CTF/Reverse Engineering/Compfest CTF/~PyASM/README.md:            346 BINARY_OP               10 (-)
720:/Users/vinnie/CTF/Reverse Engineering/Compfest CTF/~PyASM/README.md:            484 BINARY_OP               10 (-)
724:/Users/vinnie/CTF/Reverse Engineering/Compfest CTF/~PyASM/chall:            340 BINARY_OP               10 (-)
725:/Users/vinnie/CTF/Reverse Engineering/Compfest CTF/~PyASM/chall:            346 BINARY_OP               10 (-)
729:/Users/vinnie/CTF/Reverse Engineering/Compfest CTF/~PyASM/chall:            484 BINARY_OP               10 (-)
2661:/System/Volumes/Data/Users/vinnie/CTF/Reverse Engineering/Compfest CTF/~PyASM/README.md:            340 BINARY_OP               10 (-)
2662:/System/Volumes/Data/Users/vinnie/CTF/Reverse Engineering/Compfest CTF/~PyASM/README.md:            346 BINARY_OP               10 (-)
2666:/System/Volumes/Data/Users/vinnie/CTF/Reverse Engineering/Compfest CTF/~PyASM/README.md:            484 BINARY_OP               10 (-)
2670:/System/Volumes/Data/Users/vinnie/CTF/Reverse Engineering/Compfest CTF/~PyASM/chall:            340 BINARY_OP               10 (-)
2671:/System/Volumes/Data/Users/vinnie/CTF/Reverse Engineering/Compfest CTF/~PyASM/chall:            346 BINARY_OP               10 (-)
2675:/System/Volumes/Data/Users/vinnie/CTF/Reverse Engineering/Compfest CTF/~PyASM/chall:            484 BINARY_OP               10 (-)

$ rg -I 'BINARY_OP\s+0'
79:/System/Volumes/Data/opt/local/Library/Frameworks/Python.framework/Versions/3.12/lib/python3.12/test/test_dis.py:%3d        BINARY_OP                0 (+)
80:/System/Volumes/Data/opt/local/Library/Frameworks/Python.framework/Versions/3.12/lib/python3.12/test/test_dis.py:           BINARY_OP                0 (+)
81:/System/Volumes/Data/opt/local/Library/Frameworks/Python.framework/Versions/3.12/lib/python3.12/test/test_dis.py:           BINARY_OP                0 (+)
84:/System/Volumes/Data/opt/local/Library/Frameworks/Python.framework/Versions/3.12/lib/python3.12/test/test_dis.py:           BINARY_OP                0 (+)
86:/System/Volumes/Data/opt/local/Library/Frameworks/Python.framework/Versions/3.12/lib/python3.12/test/test_dis.py:           %*d BINARY_OP                0 (+)
91:/opt/local/Library/Frameworks/Python.framework/Versions/3.12/lib/python3.12/test/test_dis.py:%3d        BINARY_OP                0 (+)
92:/opt/local/Library/Frameworks/Python.framework/Versions/3.12/lib/python3.12/test/test_dis.py:           BINARY_OP                0 (+)
93:/opt/local/Library/Frameworks/Python.framework/Versions/3.12/lib/python3.12/test/test_dis.py:           BINARY_OP                0 (+)
96:/opt/local/Library/Frameworks/Python.framework/Versions/3.12/lib/python3.12/test/test_dis.py:           BINARY_OP                0 (+)
98:/opt/local/Library/Frameworks/Python.framework/Versions/3.12/lib/python3.12/test/test_dis.py:           %*d BINARY_OP                0 (+)
618:/opt/homebrew/Cellar/python@3.11/3.11.11/Frameworks/Python.framework/Versions/3.11/lib/python3.11/test/test_dis.py:%3d        BINARY_OP                0 (+)
619:/opt/homebrew/Cellar/python@3.11/3.11.11/Frameworks/Python.framework/Versions/3.11/lib/python3.11/test/test_dis.py:           BINARY_OP                0 (+)
620:/opt/homebrew/Cellar/python@3.11/3.11.11/Frameworks/Python.framework/Versions/3.11/lib/python3.11/test/test_dis.py:           BINARY_OP                0 (+)
623:/opt/homebrew/Cellar/python@3.11/3.11.11/Frameworks/Python.framework/Versions/3.11/lib/python3.11/test/test_dis.py:           BINARY_OP                0 (+)
625:/opt/homebrew/Cellar/python@3.11/3.11.11/Frameworks/Python.framework/Versions/3.11/lib/python3.11/test/test_dis.py:           %*d BINARY_OP                0 (+)
630:/System/Volumes/Data/opt/homebrew/Cellar/python@3.11/3.11.11/Frameworks/Python.framework/Versions/3.11/lib/python3.11/test/test_dis.py:%3d        BINARY_OP                0 (+)
631:/System/Volumes/Data/opt/homebrew/Cellar/python@3.11/3.11.11/Frameworks/Python.framework/Versions/3.11/lib/python3.11/test/test_dis.py:           BINARY_OP                0 (+)
632:/System/Volumes/Data/opt/homebrew/Cellar/python@3.11/3.11.11/Frameworks/Python.framework/Versions/3.11/lib/python3.11/test/test_dis.py:           BINARY_OP                0 (+)
635:/System/Volumes/Data/opt/homebrew/Cellar/python@3.11/3.11.11/Frameworks/Python.framework/Versions/3.11/lib/python3.11/test/test_dis.py:           BINARY_OP                0 (+)
637:/System/Volumes/Data/opt/homebrew/Cellar/python@3.11/3.11.11/Frameworks/Python.framework/Versions/3.11/lib/python3.11/test/test_dis.py:           %*d BINARY_OP                0 (+)
717:/Users/vinnie/CTF/Reverse Engineering/Compfest CTF/~PyASM/README.md:            394 BINARY_OP                0 (+)
726:/Users/vinnie/CTF/Reverse Engineering/Compfest CTF/~PyASM/chall:            394 BINARY_OP                0 (+)
750:/Users/vinnie/CTF/Reverse Engineering/NCW/~SDP/old/sdp.pydas.old:                        880     BINARY_OP                       0 (+)
1709:/opt/homebrew/Cellar/python@3.12/3.12.8/Frameworks/Python.framework/Versions/3.12/lib/python3.12/test/test_dis.py:%3d        BINARY_OP                0 (+)
1710:/opt/homebrew/Cellar/python@3.12/3.12.8/Frameworks/Python.framework/Versions/3.12/lib/python3.12/test/test_dis.py:           BINARY_OP                0 (+)
1711:/opt/homebrew/Cellar/python@3.12/3.12.8/Frameworks/Python.framework/Versions/3.12/lib/python3.12/test/test_dis.py:           BINARY_OP                0 (+)
1714:/opt/homebrew/Cellar/python@3.12/3.12.8/Frameworks/Python.framework/Versions/3.12/lib/python3.12/test/test_dis.py:           BINARY_OP                0 (+)
1716:/opt/homebrew/Cellar/python@3.12/3.12.8/Frameworks/Python.framework/Versions/3.12/lib/python3.12/test/test_dis.py:           %*d BINARY_OP                0 (+)
1721:/System/Volumes/Data/opt/homebrew/Cellar/python@3.12/3.12.8/Frameworks/Python.framework/Versions/3.12/lib/python3.12/test/test_dis.py:%3d        BINARY_OP                0 (+)
1722:/System/Volumes/Data/opt/homebrew/Cellar/python@3.12/3.12.8/Frameworks/Python.framework/Versions/3.12/lib/python3.12/test/test_dis.py:           BINARY_OP                0 (+)
1723:/System/Volumes/Data/opt/homebrew/Cellar/python@3.12/3.12.8/Frameworks/Python.framework/Versions/3.12/lib/python3.12/test/test_dis.py:           BINARY_OP                0 (+)
1726:/System/Volumes/Data/opt/homebrew/Cellar/python@3.12/3.12.8/Frameworks/Python.framework/Versions/3.12/lib/python3.12/test/test_dis.py:           BINARY_OP                0 (+)
1728:/System/Volumes/Data/opt/homebrew/Cellar/python@3.12/3.12.8/Frameworks/Python.framework/Versions/3.12/lib/python3.12/test/test_dis.py:           %*d BINARY_OP                0 (+)
1932:/System/Volumes/Data/opt/homebrew/Cellar/python@3.13/3.13.1/Frameworks/Python.framework/Versions/3.13/lib/python3.13/test/test_dis.py:%3d           BINARY_OP                0 (+)
1933:/System/Volumes/Data/opt/homebrew/Cellar/python@3.13/3.13.1/Frameworks/Python.framework/Versions/3.13/lib/python3.13/test/test_dis.py:              BINARY_OP                0 (+)
1934:/System/Volumes/Data/opt/homebrew/Cellar/python@3.13/3.13.1/Frameworks/Python.framework/Versions/3.13/lib/python3.13/test/test_dis.py:              BINARY_OP                0 (+)
1937:/System/Volumes/Data/opt/homebrew/Cellar/python@3.13/3.13.1/Frameworks/Python.framework/Versions/3.13/lib/python3.13/test/test_dis.py:               BINARY_OP                0 (+)
1944:/opt/homebrew/Cellar/python@3.13/3.13.1/Frameworks/Python.framework/Versions/3.13/lib/python3.13/test/test_dis.py:%3d           BINARY_OP                0 (+)
1945:/opt/homebrew/Cellar/python@3.13/3.13.1/Frameworks/Python.framework/Versions/3.13/lib/python3.13/test/test_dis.py:              BINARY_OP                0 (+)
1946:/opt/homebrew/Cellar/python@3.13/3.13.1/Frameworks/Python.framework/Versions/3.13/lib/python3.13/test/test_dis.py:              BINARY_OP                0 (+)
1949:/opt/homebrew/Cellar/python@3.13/3.13.1/Frameworks/Python.framework/Versions/3.13/lib/python3.13/test/test_dis.py:               BINARY_OP                0 (+)
2262:/opt/homebrew/Cellar/python@3.13/3.13.0_1/Frameworks/Python.framework/Versions/3.13/lib/python3.13/test/test_dis.py:%3d           BINARY_OP                0 (+)
2263:/opt/homebrew/Cellar/python@3.13/3.13.0_1/Frameworks/Python.framework/Versions/3.13/lib/python3.13/test/test_dis.py:              BINARY_OP                0 (+)
2264:/opt/homebrew/Cellar/python@3.13/3.13.0_1/Frameworks/Python.framework/Versions/3.13/lib/python3.13/test/test_dis.py:              BINARY_OP                0 (+)
2267:/opt/homebrew/Cellar/python@3.13/3.13.0_1/Frameworks/Python.framework/Versions/3.13/lib/python3.13/test/test_dis.py:               BINARY_OP                0 (+)
2274:/System/Volumes/Data/opt/homebrew/Cellar/python@3.13/3.13.0_1/Frameworks/Python.framework/Versions/3.13/lib/python3.13/test/test_dis.py:%3d           BINARY_OP                0 (+)
2275:/System/Volumes/Data/opt/homebrew/Cellar/python@3.13/3.13.0_1/Frameworks/Python.framework/Versions/3.13/lib/python3.13/test/test_dis.py:              BINARY_OP                0 (+)
2276:/System/Volumes/Data/opt/homebrew/Cellar/python@3.13/3.13.0_1/Frameworks/Python.framework/Versions/3.13/lib/python3.13/test/test_dis.py:              BINARY_OP                0 (+)
2279:/System/Volumes/Data/opt/homebrew/Cellar/python@3.13/3.13.0_1/Frameworks/Python.framework/Versions/3.13/lib/python3.13/test/test_dis.py:               BINARY_OP                0 (+)
2663:/System/Volumes/Data/Users/vinnie/CTF/Reverse Engineering/Compfest CTF/~PyASM/README.md:            394 BINARY_OP                0 (+)
2672:/System/Volumes/Data/Users/vinnie/CTF/Reverse Engineering/Compfest CTF/~PyASM/chall:            394 BINARY_OP                0 (+)
2696:/System/Volumes/Data/Users/vinnie/CTF/Reverse Engineering/NCW/~SDP/old/sdp.pydas.old:                        880     BINARY_OP                       0 (+)
```

Construct python from the bytecode:

```
# Decompiled with PyLingual (https://pylingual.io)
# Internal filename: chall.py
# Bytecode version: 3.11a7e (3495)
# Source timestamp: 1970-01-01 00:00:00 UTC (0)

from Crypto.Util.number import *
flag = input("Input your flag >> ")
assert len(flag) == 33
flag = flag.encode()
x = bytes_to_long(flag[:19])
y = bytes_to_long(flag[19:26])
z = bytes_to_long(flag[26:])
if (2*x + 3*y - 5*z == 3402836797343125315216436061172783970695516266 and 3*x + 4*y - 5**z == 5104255196014687972824654091829719426080829736 and 2*x - 5*y + z == 3402836797343125315216436061196372081915006560 and x + 2*y - 3*z == 1701418398671562657608218030580854833509108390):
    print("Correct!")
else:  # inserted
    print("False!")
```

solve with z3 (solve.py)
convert to ascii
