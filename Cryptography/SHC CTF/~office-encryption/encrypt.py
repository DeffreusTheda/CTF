from random import shuffle
from collections import Counter


def generate_substitution_cipher(text):
    alphabet = "abcdefghijklmnopqrstuvwxyz"
    shuffled_alphabet = list(alphabet)
    shuffle(shuffled_alphabet)
    cipher_map = {
        original: substituted
        for original, substituted in zip(alphabet, shuffled_alphabet)
    }

    encrypted_text = ""
    for char in text:
        if char.lower() in cipher_map:
            encrypted_char = cipher_map[char.lower()]
            if char.isupper():
                encrypted_char = encrypted_char.upper()
            encrypted_text += encrypted_char
        else:
            encrypted_text += char

    return encrypted_text, cipher_map


text = "shc2024{fake_flag}"

encrypted_text, cipher_map = generate_substitution_cipher(text)

print(encrypted_text, cipher_map)
