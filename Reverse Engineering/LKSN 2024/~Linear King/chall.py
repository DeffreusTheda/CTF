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
if (2*x + 3*y - 5**z == 3402836797343125315216436061172783970695516266 and 3*x + 4*y - 5**z == 5104255196014687972824654091829719426080829736 and 2*x - 5*y + z == 3402836797343125315216436061196372081915006560 and x + 2*y - 3*z == 1701418398671562657608218030580854833509108390):
    print("Correct!")
else: # inserted
    print("False!")
