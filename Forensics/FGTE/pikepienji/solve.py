import binascii
import zlib

# https://stackoverflow.com/questions/1413540/showing-an-image-from-console-in-python
from PIL import Image

for i, line in enumerate(open('./dat', 'r')):
    if line[-1] == '\n':
        line = line[:-1]
    line = zlib.decompress(binascii.unhexlify(binascii.unhexlify(line)))
    f = f'/tmp/pil-{str(i).rjust(2, '0')}.png'
    tmp = open(f, 'wb')
    tmp.write(line)
    # img = Image.open(f)
    # img.show()
    # print(line)
