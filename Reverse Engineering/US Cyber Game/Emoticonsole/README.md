# Emoticonsole - US Cyber Game Season IV 2024

## Recon

```$ file program.emo 
program.emo: Unicode text, UTF-8 text, with very long lines (617), with no line terminators
```
```$ file runtime.pyc 
runtime.pyc: Byte-compiled Python module for CPython 3.11, timestamp-based, .py timestamp: Sun Jun  2 06:03:02 2024 UTC, .py size: 5053 bytes
```

## Initial Researh

The .pyc file is compiled in Python 3.11, which lacks support by most decompiler. Through my testing, uncompyle6, dis.py and decompyle3 encounter errors with unhelpful error messages.

`pycdc` almost able to decompile the binary, albeit with 5 decompilation failure from unknown opcodes.

## Solution


## Conclusion


