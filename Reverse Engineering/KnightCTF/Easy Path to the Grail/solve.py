c = b'\xD2\xC2\x2A\x62\xDE\xA6\x2C\xCE\x9E\xFA\x0E\xCC\x86\xCE\x9A\xFA\x4E\xCC\x6E\xFA\xC6\x16\x2C\x36\x36\xCC\x76\xE6\xA6\xBE'
def re(byte):
    """
    Reverses the bits in a byte.
    Args:
        byte (int): Input byte (0-255)
    Returns:
        int: Byte with reversed bits
    """
    return int(format(byte, '08b')[::-1], 2)

for cc in c:
    print(chr(re(cc)), end='')