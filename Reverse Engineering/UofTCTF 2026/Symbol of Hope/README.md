Like a beacon in the dark, Go Go Squid! stands as a symbol of hope to those who seek to be healed.

Author: SteakEnthusiast

## Solution

Looking at IDA, there is a "linear" functions chain, around 4200 of them.
There is some branching too, but they're all just branch to two other function.
Thankfully, only one success path exists, on `f_4200`:
```c
int __fastcall f_4200(const void *a1)
{
  if ( !memcmp(a1, &expected, 0x2Au) )
    return puts("Yes");
  else
    return puts("No");
}
```

Every other failure message is the same, just `"No"`.
I just used angr here...

```py
an = angr
an.p = an.Project

binary_path = 'checker'
pro = an.p(binary_path, auto_load_libs=False)
will_run_main = True

si = None
st = None

_print = print
def error(s, *v, **o):
    _print('[\033[31m!\033[0m] ' + s, *v, **o)
def print(s, *v, **o):
    _print(f'[\033[34m*\033[0m] ' + s, *v, **o)

pro.f = pro.factory
pro.f.si = pro.factory.simgr

pro.a = pro.analyses

pro.l = pro.loader

if pro.l:
    print(f'{pro.l.shared_objects}')
    from subprocess import run
    run(['checksec', pro.filename])
else:
    error('CLE loader failed.')

print(f'{pro.l.all_objects}')
print(f'>> {pro.l.main_object} <<')

from claripy import Solver, BVV, BVS, true, false, And, If
import claripy as cl
def init(*v):
    global si, st
    if len(v) > 1: st = pro.f.entry_state(stdin=angr.SimFileStream(name='stdin', content=v[0], has_end=v[1]), add_options={angr.options.SYMBOL_FILL_UNCONSTRAINED_MEMORY})
    else: st = pro.f.entry_state(add_options={angr.options.SYMBOL_FILL_UNCONSTRAINED_MEMORY})
    si = pro.f.si(st)
    si.ac = si.active
def question(q, **hellna):
    is_opt = True
    while is_opt:
        is_opt = False
        if 'tf' in hellna: print(f'{q} [{hellna['tf']}] >', end='')
        else: print(f'{q} [Y/n] >', end='')
        opt = input()
        if 'tf' in hellna: return hellna['tf'](q)
        match opt:
            case 'y' | 'Y':
                return True
            case 'n' | 'N':
                return False
            case _:
                is_opt = True
                error('Invalid option.')
def solve(target, n):
    flag = BVS('flag', 8*n)
    if question('Does it use STDIN?'):
        if question('Constraint [Y] full STDIN or [n] only known beginning?'):
            init(flag, True)
        else:
            init(flag, False)
    else: init(False)
    if question('Is input null terminated?'): st.solver.add(flag.get_byte(n - 1) == 0)

    if isinstance(target, str): target = target.encode()
    if si.ac: print(f'Simulation Manager ready!!')
    else:
        error(f'Simulation Manager broke down T-T')
        return
    for i in range(n):
        byte = flag.get_byte(i)
        st.solver.add(And(byte >= 0x20, byte <= 0x7E))
    def constr_stdin():
        global st
        st.posix.stdin.content = [[flag, st.posix.stdin.pos]]
        st.posix.stdin.size = n
        return
    si.explore(find=lambda state: target in state.posix.dumps(1))
    print(si.found[0].posix.dumps(0))

s = Solver()
s.a = s.add
_s__eval = s.eval
def myeval(*s):
    if len(s) == 1: return _s__eval(s[0], 0x100)
    return _s__eval(*s)
s.eval = myeval
```

Then I get to interactive:
```py
In [1]: solve('Yes', 46)
[*] Does it use STDIN? [Y/n] >y
[*] Constraint [Y] full STDIN or [n] only known beginning? [Y/n] >y
[*] Is input null terminated? [Y/n] >n
[*] Simulation Manager ready!!
---------------------------------------------------------------------------
TypeError                                 Traceback (most recent call last)
Cell In[1], line 1
----> 1 solve('Yes', 46)

File ~/.ipython/profile_default/startup/100-angr_shortcuts.py:90, in solve(target, n)
     88     return
     89 si.explore(find=lambda state: target in state.posix.dumps(1))
---> 90 print(si.found[0].posix.dumps(0))

File ~/.ipython/profile_default/startup/100-angr_shortcuts.py:23, in print(s, *v, **o)
     22 def print(s, *v, **o):
---> 23     _print(f'[\033[34m*\033[0m] ' + s, *v, **o)

TypeError: can only concatenate str (not "bytes") to str

In [2]: si
Out[2]: <SimulationManager with 1 active, 1 deadended, 1 found>

In [3]: si.found[0]
Out[3]: <SimState @ 0x440e7e>

In [4]: si.found[0].posix
Out[4]: <angr.state_plugins.posix.SimSystemPosix at 0x1616d9ba0>

In [5]: si.found[0].posix.dumps(0)
Out[5]: b'uoftctf{5ymb0l1c_3x3cu710n_15_v3ry_u53ful}????'
```
