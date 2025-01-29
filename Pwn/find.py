import sys

def hex_dump(data):
    return data.hex()

# CORRECTED NONCE (12 bytes from offset 4)
nonce_hex = "e4d8d0cf9198bc6b9577c815"
nonce = bytes.fromhex(nonce_hex)

print(f"[*] Searching for Real Nonce: {nonce_hex} in core dump...")

with open("core.5936", "rb") as f:
    core_data = f.read()
    
    # Find all occurrences of the nonce
    offset = -1
    found_count = 0
    
    while True:
        offset = core_data.find(nonce, offset + 1)
        if offset == -1:
            break
            
        found_count += 1
        print(f"\n[+] FOUND Nonce instance #{found_count}")
        print(f"    Offset: {hex(offset)}")
        
        # In Go's 'seal' implementation, the key is usually separate from the nonce buffer.
        # BUT, the key is 32 bytes of entropy.
        # We will dump the surrounding 256 bytes to look for the key manually.
        
        start = max(0, offset - 128)
        end = min(len(core_data), offset + 128)
        
        context = core_data[start:end]
        print(f"    Context Dump (Hex):")
        print(context.hex())
        print("-" * 60)

    if found_count == 0:
        print("[-] Nonce STILL not found. It might have been generated, used, and wiped/GC'd.")