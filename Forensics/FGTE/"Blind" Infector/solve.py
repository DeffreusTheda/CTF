import zlib

x = zlib.decompress(open('b', 'rb').read())
print(x)
