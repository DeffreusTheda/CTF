#!/usr/bin/env python3

def secret():
    blacklist = [' ', '\t', '\n', '\r', '\x0b', '\x0c', '()', '""', "''", '[]', '{}', '_']

    masukan = input('> ')
    if not masukan.isascii() or not masukan.isprintable() or any([c for c in blacklist if c in masukan]):
        print('I smell something fishy...')
        exit()
    eval(masukan, {'__builtins__': {'blacklist': blacklist}})

    masukan = input('> ')
    if not masukan.isascii() or not masukan.isprintable() or any([c for c in blacklist if c in masukan]):
        print('I smell something fishy...')
        exit()
    print(eval(masukan, {'__builtins__': {}}))

masukan = input('> ')

if not masukan.isascii() or not masukan.isprintable() or any([c for c in masukan if c in ' \t\n\r\x0b\x0c_']) or '()' in masukan:
    print('I smell something fishy...')
    exit()

eval(masukan, {'__builtins__': {'secret': secret}}, {'__builtins__': {'secret': secret}})
