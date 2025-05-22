from typing import List, Union
import ctypes
import sys

def encrypt(data: Union[bytes, bytearray], key: int, key_len: int) -> bytes:
    """
    Encrypt data using the provided key and key length.
    
    Args:
        data: Input bytes to encrypt
        key: Encryption key number
        key_len: Length of the key to use
        
    Returns:
        Encrypted bytes
    """
    if not data:
        return b'\x00'
    
    # Convert input to bytearray for modification
    buffer = bytearray(data)
    data_len = len(buffer)
    
    # First pass: forward encryption
    step = 0x35
    tmp = 0
    
    # Convert key to bytes for consistent indexing
    key_bytes = key
    
    for i in range(data_len):
        tmp = tmp ^ (key_bytes[i % key_len] ^ buffer[i]) * 0x79
        buffer[i] = (tmp + step) & 0xFF  # Ensure byte range
        step = (step + 0x35) & 0xFF

    print(f'{buffer=}')
    
    # Second pass: backward transformation
    tmp = buffer[data_len - 1] - (data_len >> 1)
    
    for i in range(data_len - 1, 0, -1):
        if i < (data_len >> 1):
            tmp = buffer[data_len - 1]
        buffer[i] ^= tmp
    
    buffer[0] ^= tmp
    
    return bytes(buffer)

def decrypt(encrypted_data: Union[bytes, bytearray], key: int, key_len: int) -> bytes:
    """
    Decrypt data that was encrypted using the encrypt function.
    
    Args:
        encrypted_data: Input bytes to decrypt
        key: Encryption key number
        key_len: Length of the key to use
        
    Returns:
        Decrypted bytes
    """
    if not encrypted_data:
        return b'\x00'
    
    buffer = bytearray(encrypted_data)
    data_len = len(buffer)
    
    # First pass: reverse the backward transformation
    tmp = buffer[data_len - 1] - (data_len >> 1)
    
    buffer[0] ^= tmp
    
    for i in range(1, data_len):
        if i < (data_len >> 1):
            tmp = buffer[data_len - 1]
        buffer[i] ^= tmp

    print(f'{buffer=}')
    
    # Second pass: reverse the forward encryption
    step = 0x35
    tmp = 0
    result = bytearray(data_len)
    
    # Convert key to bytes for consistent indexing
    key_bytes = key
    
    for i in range(data_len):
        original_byte = ((buffer[i] - step) & 0xFF)
        tmp = tmp ^ (key_bytes[i % key_len] ^ result[i]) * 0x79
        result[i] = original_byte ^ ((tmp * 0x79) & 0xFF)
        step = (step + 0x35) & 0xFF
        
    return bytes(result)

# Example usage
def test_encryption():
    # Test data
    original_data = bytes(sys.argv[1].encode('utf-8'))
    # key = b'\x23\x42\x12\x3A\xE3\x40\x12\x34\xD3\x02\x10\x0A'
    key = b'\x34\x12\x40\xE3\x3A\x12\x42\x23\x0A\x10\x02\xD3'
    key_len = len(key)
    
    # Encrypt
    encrypted = encrypt(original_data, key, key_len)
    print(f"Encrypted: {encrypted.hex()}")
    
    # Decrypt
    decrypted = decrypt(encrypted, key, key_len)
    print(f"Decrypted: {decrypted}")
    
    # Verify
    assert decrypted == original_data, "Decryption failed!"
    print("Encryption/Decryption test passed!")

if __name__ == "__main__":
    test_encryption()
