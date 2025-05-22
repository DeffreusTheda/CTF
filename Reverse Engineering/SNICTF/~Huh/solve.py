import string

def nyaa(param_1, param_2):
  local_20 = param_2
  local_1c = param_1
  while (local_20 != 0):
    bVar1 = local_1c & local_20
    local_1c = local_1c ^ local_20
    local_20 = bVar1 * 2
  return local_1c

guess = [chr(i) for i in range(256)]
with open('target', 'r') as f:
    for line in f:
        target, key = line.split(' ')
        target = int(target, 16)
        key = int(key, 16)
        for c in guess:
            if (nyaa(ord(c), key) == target):
                print(f'{c}', end=' ')
        print()

