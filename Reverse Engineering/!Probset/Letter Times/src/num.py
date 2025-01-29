from z3 import *
import string
from numpy import round

let = [Real(c) for c in string.ascii_lowercase]
def _(a):
    return let[ord(a)-ord('a')]

# s = Solver()
s = SolverFor("QF_LRA")

for c in 'onetwhfurivsxghy':
    s.add(_(c) >= 0)
    
s.add(_('o')*_('n')*_('e') == 1)
s.add(_('t')*_('w')*_('o') == 2)
s.add(_('t')*_('h')*_('r')*_('e')*_('e') == 3)
s.add(_('f')*_('o')*_('u')*_('r') == 4)
s.add(_('f')*_('i')*_('v')*_('e') == 5)
s.add(_('s')*_('i')*_('x') == 6)
s.add(_('s')*_('e')*_('v')*_('e')*_('n') == 7)
s.add(_('e')*_('i')*_('g')*_('h')*_('t') == 8)
s.add(_('n')*_('i')*_('n')*_('e') == 9)
s.add(_('t')*_('e')*_('n') == 10)
s.add(_('t')*_('w')*_('e')*_('n')*_('t')*_('y') == 20)
s.add(_('t')*_('h')*_('i')*_('r')*_('t')*_('y') == 30)
s.add(_('f')*_('o')*_('r')*_('t')*_('y') == 40)
s.add(_('f')*_('i')*_('f')*_('t')*_('y') == 50)
s.add(_('s')*_('i')*_('x')*_('t')*_('y') == 60)
s.add(_('i') == 81)
# s.add(_('h')*_('u')*_('n')*_('d')*_('r')*_('e')*_('d') == 100)
# s.add(_('n') * _('e') * _('g') * _('a') * _('t') * _('i') * _('v') * _('e') == -1)
# s.add(_('e') * _('l') * _('e') * _('v') * _('e') * _('n') == 11)
# s.add(_('t') * _('w') * _('e') * _('l') * _('v') * _('e') == 12)

# def _(z, tolerance=1e-10):
#     real = round(z.real) if abs(z.real - round(z.real)) < tolerance else z.real
#     imag = round(z.imag) if abs(z.imag - round(z.imag)) < tolerance else z.imag
#     if imag == 0: return real
#     return complex(real, imag)

# o = 2**-8.5    * 3**-0.5 * 5**-9
# n = 2**17.625            * 5**18.875  * 7**-0.125 * 1j**-0.25
# e = 2**-9.125  * 3**0.5  * 5**-9.875  * 7**0.125  # * 1j**0.25

# t = 2**9.125   * 3**-0.5 * 5**9.875   * 7**-0.125 * 1j**-0.25
# w = 2**0.375   * 3       * 5**-0.875  * 7**0.125  * 1j**0.25

# h = 2**0.125   * 3**0.5  * 5**0.875   * 7**-0.125 * 1j**-0.25
# r = 2**9                 * 5**9

# f = 2**48.625  * 3**-1.5 * 5**50.875  * 7**-0.625 * 1j**-1.25
# u = 2**-47.125 * 3**2    * 5**-50.375 * 7**0.625  # * 1j**1.25

# i = 2**18.5    * 3**-1   * 5**19.5
# v = 2**-13.375 * 3**-0.5 * 5**-11.625 * 7**0.375  # * 1j**0.75

# print(_(o*n*e))
# print(_(t*w*o))
# print(_(t*h*r*e*e))
# print(_(f*o*u*r))
# print(_(f*i*v*e))

# s.add(z3('f')*o*u*r == 4)
# s.add(z3('f')*i*v*e == 5)

print(f"solving!")
max = 2
while s.check() == sat and max > 0:
    max -= 1
    print("found!")
    
    m = s.model()
    print(m)
# a yousofitsothinsostar
# a wesawhowfreehourscross
# c wesawhowfreehourscross
# d twostrongivyvinesgrowwide
# a fewshyfrosthuesgiveaswift
# l thinshylighttousinside
# d thinshylighttousinside
# a whohasthisveryhugehouse
# c oursongistrueourvoicehigh
# l thewhitegooseflewtothesky
# k thewhitegooseflewtothesky
# m itsformissoftitstouchnice
# c itsformissoftitstouchnice
# c itsformissoftitstouchnice
    for c in ['tinge', 'The rough fox run further', 'Our one wish grew high how few', 'Show us this tough furry view', 'You so fit so thin so star', 'Why this fight why the fury', 'How youth threw its own six toss', 'We saw how free hours cross', 'Go forth swift now hurry hurry', 'Two strong ivy vines grow wide', 'We trust us we use this gift', 'Few shy frost hues give a swift', 'Thin shy light to us inside', 'Who has this very huge house', 'Our song is true our voice high', 'The white goose flew to the sky', 'Its form is soft its touch nice' ]:
    # for c in ['tinge']:
        c = c.replace(' ', '').lower()
        sum = 1
        for cc in c:
            try: sum *= m[_(cc)].as_fraction()
            # sum *= m[_(cc)].as_fraction()
            except AttributeError:
                try: sum *= float(m[_(cc)].as_decimal(10)[:-1])
                except: print(cc, c)
        print(sum, int(round(sum)), hex(int(round(sum))))
    
    block_clause = []
    for var in m.decls():
        block_clause.append(var() != m[var])
    s.add(Or(block_clause))

print('done.')
