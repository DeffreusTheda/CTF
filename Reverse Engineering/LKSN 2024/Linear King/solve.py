from z3 import *
from Crypto.Util.number import *

s = Solver()

# Create symbolic integers
x = Int('x')
y = Int('y')
z = Int('z')

# Add equations
# s.add(2*x + 3*y + 5*z == 3402836797343125315216436061172783970695516266)
# s.add(3*x + 4*y + 5*z == 5104255196014687972824654091829719426080829736)
# s.add(2*x + 5*y + z == 3402836797343125315216436061196372081915006560)
# s.add(x + 2*y + 3*z == 1701418398671562657608218030580854833509108390)

s.add(2 * x + 3 * y - 5 * z == 3402836797343125315216436061172783970695516266)
s.add(3 * x + 4 * y - 5 * z == 5104255196014687972824654091829719426080829736)
s.add(2 * x - 5 * y + z == 3402836797343125315216436061196372081915006560)
s.add(x + 2 * y - 3 * z == 1701418398671562657608218030580854833509108390)

if s.check() == sat:
    m = s.model()
    x = m[x].as_long()
    y = m[y].as_long()
    z = m[z].as_long()

    import binascii
    print(binascii.unhexlify(hex(x)[2:] + hex(y)[2:] + hex(z)[2:]).decode())
    
else:
    print("No solution found")
