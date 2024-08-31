# weirdSnake Writeup by Deffreus - PicoCTF 2024

`snake` is just an ASCII text, and it's a python bytecode.
It's funny how even the bytecode of python is readable,
just to show how much easy python is to read.
I'll just write the decompiled code here:

```snake.py
input_list = [4, 54, 41, 0, 112, 32, 25, 49, 33, 3, 0, 0, 57, 32, 108, 23, 48, 4, 9, 70, 7, 110, 36, 8, 108, 7, 49, 10, 4, 86, 43, 102, 126, 92, 0, 16, 58, 41, 89, 78]
key_str = 'J'
key_str = '_' + key_str
key_str = key_str + 'o'
key_str = key_str + '3'
key_str = 't' + key_str
key_list = [ord(char) for char in key_str]
while len(key_list) < len(input_list):
  key_list.extend(key_list)
result = [a ^ b for a, b in zip(input_list, key_list)]
result_text = ''.join(map(chr, result))
```

Now, just add `print(result_text)` at the end and run the source code!
Here's the freaking flag: `picoCTF{N0t_sO_coNfus1ng_sn@ke_9433dec6}`.
