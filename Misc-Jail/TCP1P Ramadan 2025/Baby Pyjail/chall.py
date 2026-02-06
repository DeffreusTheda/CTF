inp = input("Input pls")

if any(c in inp for c in "abcdefghijklmnopqrstuvwxyz0123456789_\"'."):
    print("Invalid input!")
else:
    print(eval(inp))