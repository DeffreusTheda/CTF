#!/usr/bin/env python3
code = '''
__import__('sys').modules.clear()
__builtins__ = __import__('sys')._getframe(0).f_builtins

for _ in unsafe_builtins:
    del __builtins__[_]
unsafe_builtins.clear()
'''

unsafe_builtins = []
unsafe_chars = '!"#$%&\'()*+-,/;<=>?@\\^`{|}~0123456789\t '

for _ in __builtins__.__dict__:
    if not isinstance(__builtins__.__dict__[_], type):
        unsafe_builtins.append(_)
    elif _.startswith('_'):
        unsafe_builtins.append(_)

print(f'{unsafe_builtins=}')

user_input = input('Enter code: ').strip()
for c in set(user_input):
    if c in unsafe_chars:
        print(f'{c} detected!')

# No file descriptor for you
# __import__('sys').stdin = None
# __import__('sys').stderr = None
# __import__('sys').stdout = None

print(eval(user_input))
exec(code + user_input, {'unsafe_builtins': unsafe_builtins}, {})
