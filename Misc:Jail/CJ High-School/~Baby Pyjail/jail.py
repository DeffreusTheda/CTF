#!/usr/local/bin/python3 -S

def run_code(code):
    print(code)
    e(code, {'__builtins__': None, 'i': i})

i, e = input, exec
user_input = i('>>> ')

try:
    run_code(user_input)
    print('ran')
except:
    print('except')
    pass
