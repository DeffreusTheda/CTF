import dis
import marshal

with open('checker.pyc', 'rb') as f:
    g = True
    i = 0
    while g:
        try:
            code = marshal.load(f.read()[i:])
            dis.dis(code)  # Disassemble and print the bytecode
            g = False
        except:
            print(f'{i}: fail')
            i += 1


