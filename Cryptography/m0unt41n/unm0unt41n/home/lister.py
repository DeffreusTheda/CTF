from pathlib import Path
import os

path = Path('./')
for p in sorted(path.rglob("*")):
    if os.path.isfile(p):
        print("encrypt", p)
