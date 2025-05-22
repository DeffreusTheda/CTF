# EOCD (skipped)

f = open('challenge.zip', 'rb').read()

print('\nCENTRAL DIRECTORY') 
i = 0; cd = f[0x7c:0x7c+108]
print(f'Signature : {cd[i:4]}' ); i += 4
print(f'Version made by : {cd[i:i+2]}'); i += 2
print(f'Minimum version needed to extract : {cd[i:i+2]}'); i += 2
print(f'Bit flag : {cd[i:i+2]}'); i += 2
print(f'Compression method : {cd[i:i+2]}'); i += 2
print(f'File last modification time (MS-DOS format) : {cd[i:i+2]}'); i += 2
print(f'File last modification date (MS-DOS format) : {cd[i:i+2]}'); i += 2
print(f'CRC-32 of uncompressed cd : {cd[i:i+4]}'); i += 4
print(f'Compressed size : {cd[i:i+4]}'); i += 4
print(f'Uncompressed size : {cd[i:i+4]}'); i += 4
n = int.from_bytes(cd[i:i+2], byteorder='little')
print(f'File name length (n) : {cd[i:i+2]} = {n}'); i += 2
m = int.from_bytes(cd[i:i+2], byteorder='little')
print(f'Extra field length (m) : {cd[i:i+2]} = {m}'); i += 2
k = int.from_bytes(cd[i:i+2], byteorder='little')
print(f'File comment length (k) : {cd[i:i+2]} = {k}'); i += 2
print(f'Disk number where file starts : {cd[i:i+2]}'); i += 2
print(f'Internal file attributes : {cd[i:i+2]}'); i += 2
print(f'External file attributes : {cd[i:i+4]}'); i += 4
print(f'Offset of local file header (from start of disk) : {cd[i:i+4]}'); i += 4
print(f'File name : {cd[i:i+n]}'); i += n
print(f'Extra field : {cd[i:i+m]}'); i += m
print(f'File comment  : {cd[i:i+k]}'); i += k

print('\nLOCAL FILE HEADER') 
i = 0; lfh = f[0:124]
print(f'Signature : {lfh[i:i+4]}'); i += 4
print(f'Minimum version needed to extract : {lfh[i:i+2]}'); i += 2
print(f'Bit flag : {lfh[i:i+2]}'); i += 2
print(f'Compression method : {lfh[i:i+2]}'); i += 2
print(f'File last modification time (MS-DOS format) : {lfh[i:i+2]}'); i += 2
print(f'File last modification date (MS-DOS format) : {lfh[i:i+2]}'); i += 2
print(f'CRC-32 of uncompressed data : {lfh[i:i+4]}'); i += 4
print(f'Compressed size : {lfh[i:i+4]} ({int.from_bytes(lfh[i:i+4], byteorder='little')})'); i += 4
print(f'Uncompressed size : {lfh[i:i+4]} ({int.from_bytes(lfh[i:i+4], byteorder='little')})'); i += 4
n = int.from_bytes(lfh[i:i+2], byteorder='little')
print(f'File name length (n) : {lfh[i:i+2]} ({n})'); i += 2
m = int.from_bytes(lfh[i:i+2], byteorder='little')
print(f'Extra field length (m) : {lfh[i:i+2]} ({m})'); i += 2
print(f'File name : {lfh[i:i+n]}'); i += n
print(f'Extra field  : {lfh[i:i+m]}'); i += m

from Crypto.Cipher import AES
from hashlib import pbkdf2_hmac

with open("encrypted_data.bin", "rb") as f:
    raw_data = f.read()

# Extract salt (first 16 bytes) and encrypted content
salt, enc_data = raw_data[:16], raw_data[18:]

# Derive key using PBKDF2 (WinZip AES standard)
key = pbkdf2_hmac("sha1", b"12345", salt, 1000, 32)

# AES-256-CTR decryption (IV = 16 null bytes)
cipher = AES.new(key, AES.MODE_CTR, nonce=0)
decrypted = cipher.decrypt(enc_data)

print(decrypted)

