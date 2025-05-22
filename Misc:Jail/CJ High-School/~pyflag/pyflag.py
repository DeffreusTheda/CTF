#!/usr/local/bin/python3 -S

flag = "CJ{REDACTED}"

expression = input()

if len(expression) <= 10 and 'flag' not in expression:
    try:
        result = eval(expression)
        print(result)
    except Exception as e:
        print("Invalid")