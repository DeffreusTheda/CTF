#!/usr/bin/env python3

apa_ini = input('> ')

blacklist = ['breakpoint', 'print', 'input', 'eval', 'exec', 'open', 'import', 'globals', 'locals', 'builtins', 'dir', 'os', 'sys', 'attr', '_', '"', "'", 'system', 'subprocess']
if not apa_ini.isascii() or not apa_ini.isprintable() or any([c for c in blacklist if c in apa_ini]):
    print('gaboleh begitu bang hekel')
    exit()

eval(apa_ini)
