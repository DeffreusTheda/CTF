import itertools

def get(num, ref):
    return sum([(1 if a == b else 0) for a,b in zip(str(num),ref)])

for s in list(itertools.permutations("123456789")):
    s = ''.join(s)
    # print(s)
    if get(s, "123456789") == 1 and get(s, "987654321") == 0 and get(s, "135792468") == 3 and get(s, "194637285") == 5:
        print(f'FOUND: {s}')


