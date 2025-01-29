import sys, os

def xor(data: bytes, key: bytes):
    output = bytearray()
    for i, data_byte in enumerate(data):
        output.append(data_byte ^ key[i % len(key)])
    return output

def hexlify(data: bytes):
    hexes = [f"{b:02X}" for b in data]
    return ' '.join(hexes)

if len(sys.argv) != 3:
    print(f"Usage: {sys.orig_argv[:2]} [file] [dest]", file=sys.stderr)
    exit(1)

input_file = sys.argv[1]
dest_file = sys.argv[2]

with open(input_file, 'rb') as f:
    input_data = f.read()
    
password = os.urandom(8)

print("Encrypting file...")
encrypted_data = xor(input_data, password)

print(f"Writing encrypted file to {dest_file}...")

with open(dest_file, 'wb') as f:
    f.write(encrypted_data)

password_file = dest_file + '.pw'
print(f"Saving password to {password_file}...")
with open(password_file, 'w') as f:
    f.write(hexlify(password))
    
print(f"Successfully encrypted {input_file}! Don't forget to delete {password_file} after you saved it!")