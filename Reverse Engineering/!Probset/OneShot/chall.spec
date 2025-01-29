# -*- mode: python ; coding: utf-8 -*-


a = Analysis(
    ['chall.py'],
    pathex=[],
    binaries=[],
    datas=[],
    hiddenimports=[],
    hookspath=[],
    hooksconfig={},
    runtime_hooks=[],
    excludes=[],
    noarchive=False,
    optimize=0,
)

import marshal
import os

from PyInstaller.compat import base_prefix, EXTENSION_SUFFIXES
from sys import prefix, exec_prefix
from fnmatch import fnmatch

exlist = set([base_prefix, prefix, exec_prefix])
expats = [os.path.join(os.path.normpath(x), '*') for x in exlist]

src = 'Z:\\CTF\\Reverse Engineering\\!Probset\\OneShot'
resfile = 'Z:\\CTF\\Reverse Engineering\\!Probset\\OneShot\\.pyarmor\\pack\\resources.list'
hookscript = 'Z:\\CTF\\Reverse Engineering\\!Probset\\OneShot\\.pyarmor\\pack\\hook-pyarmor_runtime_000000.py'

nsrc = len(src) + 1
rsrc = os.path.relpath(src)
rsrc = '' if rsrc == '.' else rsrc
psrc = os.path.join(src, '*')

hiddenimports = set([])
plist = set([])
mlist = []

for name, path, kind in a.pure:
    if name.startswith('pyi_rth'):
        continue
    hiddenimports.add(name)
    if fnmatch(path, psrc) and not any([fnmatch(path, x) for x in expats]):
        if name.find('.') == -1 and os.path.basename(path) != '__init__.py':
            mlist.append(os.path.join(rsrc, path[nsrc:]))
        else:
            pkgname = os.path.dirname(path[nsrc:]).split(os.sep)[0]
            plist.add(os.path.join(rsrc, pkgname))

for name, path, kind in a.binaries:
    if kind == 'EXTENSION':
        for x in EXTENSION_SUFFIXES:
            if fnmatch(name, '*' + x):
                name = name[:-len(x)]
                break
        hiddenimports.add(name.replace(os.sep, '.'))

with open(resfile, 'wb') as f:
    marshal.dump(mlist + list(plist), f)
with open(hookscript, 'w', encoding='utf-8') as f:
    f.write("hiddenimports=[%s]" % ", ".join([repr(x) for x in hiddenimports]))
