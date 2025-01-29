from Crypto.Cipher import AES
import hashlib
import random

def encrypt_aes(key, plain_text):
	cipher = AES.new(key, AES.MODE_ECB)
	while len(plain_text) % 16 != 0:
		plain_text += ' '
	encrypted = cipher.encrypt(plain_text.encode())
	return encrypted.hex()

obfuscated_data = [107, 56, 78, 32, 255, 173, 245, 219, 13, 4, 192, 58, 209, 85, 113, 67, 162, 143, 90, 186, 0, 48, 36, 17, 73, 52, 115, 194, 23, 10, 119, 230]
# Flag should have length of 32
# print(f'{len(obfuscated_data)}')
random.seed(1234)
key = hashlib.sha256(b'super_secret_key').digest()[:16]
encrypted_flag_part = encrypt_aes(key, 'TechtonicExpoCTF')


def check_flag(user_input):
	shuffled_input = ''.join(random.sample(user_input, len(user_input)))

	# print(f'{shuffled_input = }')
	
	xor_result = [ord(shuffled_input[i % len(shuffled_input)]) ^ obfuscated_data[i % len(obfuscated_data)] for i in range(len(obfuscated_data))]
	
	xor_hash = hashlib.sha256(bytes(xor_result)).hexdigest()
	target_hash = '2f84a7f38e5d472a8a1aef32e9e27f5d01c71bb615b83a01fc2a743c7862fa73'

	print(f'{xor_hash = }')
	print(f'{target_hash = }')
	
	if xor_hash == target_hash and user_input[:len('TechtonicExpoCTF')] == 'TechtonicExpoCTF':
		print("Flag benar!")
	else:
		print("Flag salah, coba lagi!")

if __name__ == "__main__":
	user_input = input("Masukkan flag kamu: ")
	check_flag("TechtonicExpoCTF{"+ user_input + "}")
