from fractions import Fraction

points = [
    (1, 878710809143871219205814038229886536811055846873999560492777438153775580121618061075526646555067087818585396121817261094231894658443845102899388657690138197025),
    (2, 1757445341777673197575104364788505551460418776216285556205726131271865181832100587199431656214979373236740933147317338764165663850387251521139694524686438537537),
    (3, 2636203597901405935107870979675857043948088788026857987138846079354268805131447588012884394153071213154764961920887503198060922550450089432470612752595949996509)
]

"""
Fit a quadratic polynomial y = ax^2 + bx + c through three points exactly.
Uses arbitrary precision arithmetic with Python's Fraction class.

Args:
    points: List of 3 tuples [(x1, y1), (x2, y2), (x3, y3)]

Returns:
    tuple: (a, b, c) coefficients as Fraction objects for exact representation
"""

x1, y1 = Fraction(points[0][0]), Fraction(points[0][1])
x2, y2 = Fraction(points[1][0]), Fraction(points[1][1])
x3, y3 = Fraction(points[2][0]), Fraction(points[2][1])

# Set up system of linear equations:
# y1 = a*x1^2 + b*x1 + c
# y2 = a*x2^2 + b*x2 + c  
# y3 = a*x3^2 + b*x3 + c

# Matrix form: [x^2  x  1] * [a b c]^T = [y]
# We'll solve using Cramer's rule for exact results

# Calculate determinant of coefficient matrix
det = (x1*x1*(x2 - x3) + x2*x2*(x3 - x1) + x3*x3*(x1 - x2))

if det == 0:
    print('detonated...')
    exit(1)

# Calculate coefficients using Cramer's rule
# For coefficient 'a':
# det_a = y1*(x2 - x3) + y2*(x3 - x1) + y3*(x1 - x2)
# a = det_a / det

# For coefficient 'b':
# det_b = (x1*x1*(y2 - y3) + x2*x2*(y3 - y1) + x3*x3*(y1 - y2))
# b = det_b / det

# For coefficient 'c':
det_c = (x1*x1*(x2*y3 - x3*y2) + x2*x2*(x3*y1 - x1*y3) + x3*x3*(x1*y2 - x2*y1))
c = det_c / det

print(f'{c.denominator=}')
c = hex(c.numerator)[2:]
print('flag: '+ ''.join([chr(int(c[i:i+2], 16)) for i in range(0, len(c), 2)]))
