from Crypto.Cipher import AES
import hashlib
import random
import itertools

def encrypt_aes(key, plain_text):
	cipher = AES.new(key, AES.MODE_ECB)
	while len(plain_text) % 16 != 0:
		plain_text += ' '
	encrypted = cipher.encrypt(plain_text.encode())
	return encrypted.hex()

def decrypt_aes(key, encrypted):
	cipher = AES.new(key, AES.MODE_ECB)
	plain_text = cipher.decrypt(encrypted.encode())
	idx = len(plain_text) - 1
	while plain_text[idx] == ' ':
		plain_text = plain_text[:-1]
	return plain_text

obfuscated_data = [107, 56, 78, 32, 255, 173, 245, 219, 13, 4, 192, 58, 209, 85, 113, 67, 162, 143, 90, 186, 0, 48, 36, 17, 73, 52, 115, 194, 23, 10, 119, 230] # len: 32

def check_flag(user_input):
	# key = hashlib.sha256(b'super_secret_key').digest()[:16]
	# encrypted_flag_part = encrypt_aes(key, 'TechtonicExpoCTF')

	# print(f'{decrypt_aes(key, encrypted_flag_part) = }')

	random.seed(1234)
	shuffled_input = ''.join(random.sample(user_input, len(user_input)))

	# print(f'{user_input = }')
	# print(f'{shuffled_input = }')
	
	xor_result = [ord(shuffled_input[i % len(shuffled_input)]) ^ obfuscated_data[i % len(obfuscated_data)] for i in range(len(obfuscated_data))]
	
	xor_hash = hashlib.sha256(bytes(xor_result)).hexdigest()
	target_hash = '2f84a7f38e5d472a8a1aef32e9e27f5d01c71bb615b83a01fc2a743c7862fa73'

	# print(f'{xor_hash = }')
	# print(f'{target_hash = }')
	
	if xor_hash == target_hash and user_input[:len('TechtonicExpoCTF')] == 'TechtonicExpoCTF':
		print("Flag benar!")
		exit(1)
	# else:
		# print("Flag salah, coba lagi!")
		# pass

def init_sbox():
	sbox = {}
	sbox[0] = 2
	sbox[1] = 24
	sbox[2] = 4
	sbox[3] = 28
	sbox[4] = 20
	sbox[5] = 3
	sbox[6] = 6
	sbox[7] = 1
	sbox[8] = 26
	sbox[9] = 36
	sbox[10] = 30
	sbox[11] = 8
	sbox[12] = 31
	sbox[13] = 29
	sbox[14] = 19
	sbox[15] = 17
	sbox[16] = 37
	sbox[17] = 32
	sbox[18] = 35
	sbox[19] = 16
	sbox[20] = 15
	sbox[21] = 18
	sbox[22] = 34
	sbox[23] = 23
	sbox[24] = 7
	sbox[25] = 12
	sbox[26] = 13
	sbox[27] = 11
	sbox[28] = 0
	sbox[29] = 14
	sbox[30] = 25
	sbox[31] = 33
	sbox[32] = 22
	sbox[33] = 21
	sbox[34] = 5
	sbox[35] = 10
	sbox[36] = 9
	sbox[37] = 27
	return sbox

if __name__ == "__main__":
	# guess = "1234567890qwertyuiopasdfghjklzxcvbnm#$"
	# check_flag(guess)

	# xor_res = "" # wait
	# ordered = [-1 for i in range(len(xor_res))]
	# for i in range(len(xor_res)):
	# 	ordered[i] = xor_res[sbox[i]]
	# print(f'{ordered = }')

	# #: Print flag!
	# for c in ordered:
	# 	print(chr(c), end='')
	# print()

	# man i hate this
	# farthest I got is `user_input = ('3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '1', '0', '0', 'l', 'm', 'h', 'j', '_', '_')`
	chars = "34r107n5lcudpmh9bfywkvxzjq_"
	for user_input in itertools.combinations_with_replacement(chars, 38 - len('TechtonicExpoCTF{}')):
		# print(f'{user_input = }')
		check_flag(user_input)

	exit(0)
	sbox = init_sbox()

	#: Searching sbox
	# shuf = "l8163n7gw#mkhjzapyst5bvf2x9$4rqeicdo0u"
	# orig = guess
	# for i in range(len(orig)):
	# 	print(f'sbox[{i}] = {shuf.find(orig[i])}')
	
	# string = ''
	# for i in range(len(guess)):
	# 	# print(ord(guess[i]) ^ ordered[i], end=' ')
	# 	string += chr(ord(guess[i]) ^ ordered[i])
	# print('\n' + string)

	# xor_res = []
	# string = ''
	# for i in range(len(obfuscated_data)):
	# 	print(xor_res[i] ^ obfuscated_data[i], end=' ')
	# 	string += chr(xor_res[i] ^ obfuscated_data[i])
	# print(f'{string = }')
		

	# for i in range(len(ordered)):
		# print(ord(guess[i]) ^ )

