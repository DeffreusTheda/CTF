# Decompiled with PyLingual (https://pylingual.io)
# Internal filename: /home/lurifos/personal/netcomp/2025-Netcomp-UGM/reverse/good-ol-flag-checker/src/main.py
# Bytecode version: 3.12.0rc2 (3531)
# Source timestamp: 2025-01-04 15:02:43 UTC (1736002963)

import marshal
flag = input('please input the flag:')
i = 0
s = open('flagchecker.pyc', 'rb')
# marshal_code = marshal.loads(bytes([c ^ i % 256 for i, c in enumerate(s.read()[676:])]))
open('checker.pyc', "wb").write(bytes([c ^ i % 256 for i, c in enumerate(s.read()[676:])]))
# exec(marshal_code)
