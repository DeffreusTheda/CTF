#!/usr/bin/env python3
import sys
import binascii

def pbm_to_input(pbm_path):
    a = open(pbm_path, 'r').read()[9:]
    data = []
    for i in range(0,6480,648):
        l = ""
        for j in range(0, 80, 8):
            l+=a[i+j]
        data.append(l[1:1+8])
    # print(data)

    rows = []
    for line in data:
        abcde = line.strip()[:5]
        reversed_bits = abcde[::-1]
        rows.append(reversed_bits)
    
    # Concatenate row7->row0 (reverse order)
    binary = ''.join(reversed(rows[1:9]))
    
    # Convert to hex and decode as ASCII
    G = int(binary, 2)
    hex_str = f"{G:010x}"
    # print(hex_str)
    ascii_result = binascii.unhexlify(hex_str).decode('ascii')
    
    return hex_str, ascii_result

if __name__ == "__main__":
    if len(sys.argv) < 2:
        # print("Usage: python decoder.py <pbm_file>")
        sys.exit(1)
    
    hex_val, ascii_val = pbm_to_input(sys.argv[1])
    # print(f"Hex: 0x{hex_val}")
    # print(f"ASCII: {ascii_val}")
    print(end=ascii_val)