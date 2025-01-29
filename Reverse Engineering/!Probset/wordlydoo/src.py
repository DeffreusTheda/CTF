def to_base3(n):
    if n == 0:
        return "0"
    
    result = []
    negative = n < 0
    n = abs(n)
    
    while n > 0:
        result.append(str(n % 3))
        n //= 3
    
    return ("-" if negative else "") + "".join(reversed(result))

def from_base3(s):
    if not s or s == "0":
        return 0
    
    negative = s[0] == "-"
    s = s[1:] if negative else s
    
    result = 0
    for digit in s:
        result = result * 3 + int(digit)
    
    return -result if negative else result
