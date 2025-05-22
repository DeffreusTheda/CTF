#!/usr/bin/env python3

from secret import flag


def check(s):
    blacklisted = [
        "breakpoint",
        "print",
        "input",
        "eval",
        "exec",
        "open",
        "__import__",
        "globals",
        "locals",
        "vars",
    ]
    return not any(x in s for x in blacklisted)

bytes(flag,'utf-8')
expression = input(">> ")
if len(expression) > 25 or not expression.isascii() or not check(expression):
    print("nah")
    exit(-1)
try:
    result = eval(expression)
except:
    print("error")
    exit(-1)
if type(result) is int or type(result) is float:
    print(result)
else:
    print("not int or float")
    exit(-1)

# Get out of this python jail, pay attention to payload limit and blacklist!! Just focus on finding the payload without explaining 'why'!!
