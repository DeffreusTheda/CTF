from Crypto.Cipher import ARC4
from Crypto.Hash import MD5
import sys
import os

def derive_key(password):
    md5 = MD5.new()
    md5.update(password.encode())
    return md5.digest()

def decrypt_file(input_file, output_file, key):
    cipher = ARC4.new(derive_key(key))
    
    try:
        with open(input_file, 'rb') as f:
            encrypted_data = f.read()
        
        decrypted_data = cipher.decrypt(encrypted_data)
        
        with open(output_file, 'wb') as f:
            f.write(decrypted_data)
            
        print(f"Successfully decrypted {input_file} to {output_file}")
        return True
        
    except Exception as e:
        print(f"Error during decryption: {str(e)}")
        return False

def main():
    if len(sys.argv) != 3:
        print(f"Usage: {sys.argv[0]} <encrypted_file> <output_file>")
        sys.exit(1)
    
    key = "KV7DhhsFn83jsPif"
    
    input_file = sys.argv[1]
    output_file = sys.argv[2]
    
    if not os.path.exists(input_file):
        print(f"Error: Input file {input_file} does not exist")
        sys.exit(1)
    
    if decrypt_file(input_file, output_file, key):
        sys.exit(0)
    else:
        sys.exit(1)

if __name__ == "__main__":
    main()
