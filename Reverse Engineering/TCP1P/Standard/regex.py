import re

with open('main.cpp.bak', 'r') as file:
    for line in file:
        # line = re.sub(r'main::{lambda\(std::string &\)#(\d+)}::operator\(\)\s*const\s*\(std::string &\)::{lambda\(char\)#(\d+)}::operator\(\)',
        #               r'lambdaFunc\1_\2', line)
        # line = re.sub(r'main\:\:\{lambda\(char\)#(\d+)\}\:\:operator\(\)',
        #               r'lambdaChar\1', line)
        # line = re.sub(r'main\:\:\{lambda\(std\:\:string &\)#(\d+)\}\:\:operator\(\)',
        #               r'lambdaString\1', line)
        # line = re.sub(r'std::string::operator\+=\(([^,]+),\s*(.*)\)\s*;',
        #               r'\1 += \2;', line)
        print(line, end='')
