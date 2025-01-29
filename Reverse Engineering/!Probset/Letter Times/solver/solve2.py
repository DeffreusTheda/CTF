from sympy import symbols, solve

o, n, e, t, w, h, f, u, r, i, v, s, x, g, y = symbols('o n e t w h f u r i v s x g y')

equations = [
o * n * e - 1,
t * w * o - 2,
t * h * r * e**2 - 3,
f * o * u * r - 4,
f * i * v * e - 5,
s * i * x - 6,
s * e**2 * v * n - 7,
e * i * g * h * t - 8,
n**2 * i * e - 9,
t * e * n - 10,
t**2 * w * e * n * y - 20,
t**2 * h * i * r * y - 30,
f * o * r * t * y - 40,
f**2 * i * t * y - 50,
s * i * x * t * y - 60,
]

sol = solve(equations, [o, n, e, t, w, h, f, u, r, i, v, s, x, g, y])
print(sol)
