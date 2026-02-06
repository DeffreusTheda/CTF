import marshal

MAGIC_NUMBER = b'\xe3\x0c\x0d\x0a'  # Python 3.12 magic number
TIMESTAMP = b'\x00\x00\x00\x00'  # Placeholder for timestamp (4 bytes)

with open('checker.pyc', 'rb') as f:  # Replace 'bytecode.raw' with your file
    bytecode = f.read()

# Write the new .pyc file
with open('fix.pyc', 'wb') as f:
    f.write(MAGIC_NUMBER)
    f.write(TIMESTAMP)
    f.write(bytecode)

# i = 0
# while i < 1639:
#     try:
#         # Read the bytecode after 676 bytes
#         with open('flagchecker.pyc', 'rb') as f:  # Replace 'bytecode.raw' with your file
#             bytecode = bytes(c ^ i % 256 for i, c in enumerate(f.read()[i:]))

#         # Write the new .pyc file
#         with open('fix.pyc', 'wb') as f:
#             f.write(MAGIC_NUMBER)
#             f.write(TIMESTAMP)
#             f.write(bytecode)

#         with open('fix.pyc', 'rb') as f:
#             print(f.read())
#             exec(marshal.load(f))
#     except:
#         print(f"{i} ", end='')
#         i += 1
