import random

"so, about it earlier, what is it?"

mes = "I actually like someone, and it've been bothering my mind a lot."
exp = []
val = []

print(end='typeset -A matrix_wannabe=( ')
for i in range(len(mes)):
    sum = 0
    for j in range(len(mes)):
        r = random.randbytes(1)
        sum += ord(r) * ord(mes[j])
        val.append(f'[{i},{j}]={ord(r)}')
    exp.append(sum)
while len(val) > 0:
    v = random.choice(val)
    print(v, end=' ')
    val.remove(v)
print(')')
print()
print(end='hurtful=( ')
for x in exp:
    print(end=f'{x} ')
print(')')

print(f'{len(mes)=}')
