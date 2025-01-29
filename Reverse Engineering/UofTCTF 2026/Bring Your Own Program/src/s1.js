'use strict'
const fs = require('fs'),
  t = require('path'),
  j = require('readline'),
  s = '/data/public',
  Z = 4096,
  h = {}
h.r = 64
h.c = 128
h.b = 16384
h.s = 600000
h.sl = 512
h.ln = 250000
h.a = 8
h.ic = 4
const a = h,
  e = new Set(['caps']),
  n = {}
n.a = 1
n.b = 2
n.c = 3
n.d = 4
n.e = 10
n.f = 11
const y = n,
  A = new Set([y.a, y.b, y.c, y.d, y.e, y.f]),
  p = {}
p.a = 1
p.b = 2
p.c = 32
p.d = 33
p.e = 48
p.f = 49
p.g = 50
p.h = 96
p.i = 97
p.j = 64
p.k = 112
const u = p
function Y(b) {
  const N = b.trim()
  if (N.length === 0) {
    throw 0
  }
  if (N.length > a.ln) {
    throw 0
  }
  if (!/^[0-9a-fA-F]+$/.test(N) || N.length & 1) {
    throw 0
  }
  const FN = new Uint8Array(N.length >> 1)
  for (let Fi = 0; Fi < FN.length; Fi++) {
    FN[Fi] = parseInt(N.slice(Fi << 1, (Fi << 1) + 2), 16)
  }
  return FN
}
function k(N, FN) {
  return N[FN] | (N[FN + 1] << 8)
}
function E(N, FN) {
  const Fi = k(N, FN)
  return Fi & 32768 ? Fi - 65536 : Fi
}
function m(N, FN) {
  const Fi = new DataView(N.buffer, N.byteOffset, N.byteLength)
  return Fi.getFloat64(FN, true)
}
function c(b) {
  const N = fs.statSync(b)
  if (!N.isFile()) {
    return ''
  }
  const FN = fs.openSync(b, fs.constants.O_RDONLY)
  try {
    const Fi = Math.min(N.size, Z),
      Fq = Buffer.alloc(Fi),
      Ft = fs.readSync(FN, Fq, 0, Fi, 0)
    return Fq.subarray(0, Ft).toString('utf8')
  } finally {
    fs.closeSync(FN)
  }
}
function z(N) {
  let FN = 0
  const Fi = (Fs) => {
    if (FN + Fs > N.length) {
      throw 0
    }
  }
  Fi(2)
  const Fq = N[FN++],
    Ft = N[FN++],
    FH = []
  for (let Fs = 0; Fs < Ft; Fs++) {
    Fi(1)
    const FZ = N[FN++]
    if (FZ === 1) {
      Fi(8)
      const Fh = m(N, FN)
      FN += 8
      FH.push(Fh)
    } else {
      if (FZ === 2) {
        Fi(2)
        const Fa = k(N, FN)
        FN += 2
        if (Fa > a.sl) {
          throw 0
        }
        Fi(Fa)
        const Fe = Buffer.from(N.slice(FN, FN + Fa)).toString('utf8')
        FN += Fa
        FH.push(Fe)
      } else {
        throw 0
      }
    }
  }
  const Fj = N.slice(FN)
  if (Fj.length > a.b) {
    throw 0
  }
  const FG = {}
  return (FG.nr = Fq), (FG.cs = FH), (FG.code = Fj), FG
}
function U(b) {
  if (b.nr < 1 || b.nr > a.r) {
    throw 0
  }
  if (b.cs.length > a.c) {
    throw 0
  }
  let N = 0
  const FN = b.code,
    Fi = (Fq) => {
      if (N + Fq > FN.length) {
        throw 0
      }
    }
  while (N < FN.length) {
    const Fq = FN[N++]
    switch (Fq) {
      case u.a:
        Fi(2)
        {
          const Ft = FN[N++],
            FH = FN[N++]
          if (Ft >= b.nr) {
            throw 0
          }
          if (FH >= b.cs.length) {
            throw 0
          }
          break
        }
      case u.b:
        Fi(2)
        {
          const Fj = FN[N++],
            FG = FN[N++]
          if (Fj >= b.nr) {
            throw 0
          }
          const Fs = b.cs[FG]
          if (typeof Fs !== 'string') {
            throw 0
          }
          if (!e.has(Fs)) {
            throw 0
          }
          break
        }
      case u.c:
        Fi(3)
        {
          const FZ = FN[N++],
            Fh = FN[N++],
            Fa = FN[N++]
          if (FZ >= b.nr || Fh >= b.nr) {
            throw 0
          }
          if (!A.has(Fa)) {
            throw 0
          }
          break
        }
      case u.d:
        Fi(4)
        {
          const Fe = FN[N++],
            Fn = FN[N++],
            Fy = FN[N++],
            FB = FN[N++]
          if (Fe >= b.nr || Fn >= b.nr || Fy >= b.nr) {
            throw 0
          }
          if (!A.has(FB)) {
            throw 0
          }
          break
        }
      case u.k:
        Fi(2)
        {
          const FA = FN[N++],
            Fp = FN[N++]
          if (FA >= b.nr) {
            throw 0
          }
          if (!A.has(Fp)) {
            throw 0
          }
          break
        }
      case u.e:
        Fi(4)
        {
          const FI = FN[N++],
            Fu = FN[N++],
            FY = FN[N++],
            FX = FN[N++]
          if (FX > a.a) {
            throw 0
          }
          Fi(FX)
          for (let Fk = 0; Fk < FX; Fk++) {
            const FQ = FN[N++]
            if (FQ >= b.nr) {
              throw 0
            }
          }
          if (FI >= b.nr || Fu >= b.nr || FY >= b.nr) {
            throw 0
          }
          break
        }
      case u.h:
        Fi(2), (N += 2)
        break
      case u.i:
        Fi(3)
        {
          const FE = FN[N++]
          if (FE >= b.nr) {
            throw 0
          }
          N += 2
          break
        }
      case u.j:
        Fi(3)
        {
          const Fm = FN[N++],
            FS = FN[N++],
            Fc = FN[N++]
          if (Fm >= b.nr || FS >= b.nr || Fc >= b.nr) {
            throw 0
          }
          break
        }
      case u.f:
        Fi(1)
        {
          const Fz = FN[N++]
          if (Fz >= b.nr) {
            throw 0
          }
          break
        }
      case u.g:
        break
      default:
        throw 0
    }
  }
}
let x = 1
function f() {
  x = (x + 1) | 0
  if (x === 0) {
    x = 1
  }
}
class o {
  constructor(b) {
    this.id = ++o['_i']
    this.m = b
  }
}
o['_i'] = 0
function J(b) {
  const N = new Map()
  for (const [FN, Fi] of b.entries()) N.set(FN, Fi)
  return N
}
function l(b, N) {
  const FN = J(b.m)
  if (!FN.has(N)) {
    FN.set(N, FN.size)
  }
  return new o(FN)
}
class v {
  constructor(b = null) {
    this.p = b
    this.sh = new o(new Map())
    this.sl = []
    this.dm = false
    this.d = null
    this.h = false
    this.z = false
  }
  ['t']() {
    this.h = true
  }
  ['x']() {
    this.z = true
  }
  ['o'](b, N) {
    if (this.z) {
      throw 0
    }
    if (this.dm) {
      if (!this.d) {
        this.d = new Map()
      }
      this.d.set(b, N)
      return
    }
    if (!this.sh.m.has(b)) {
      this.sh = l(this.sh, b)
    }
    const FN = this.sh.m.get(b)
    this.sl[FN] = N
  }
  ['y'](b) {
    if (this.dm) {
      return this.d ? this.d.has(b) : false
    }
    return this.sh.m.has(b)
  }
  ['g'](b) {
    if (this.dm) {
      return this.d ? this.d.get(b) : undefined
    }
    if (!this.sh.m.has(b)) {
      return undefined
    }
    return this.sl[this.sh.m.get(b)]
  }
}
class g {
  constructor(b) {
    this.f = b
  }
  ['c'](b, N) {
    return this.f.apply(b, N)
  }
}
class d {
  constructor() {
    this.c = []
    this.m = false
  }
}
function F0(b) {
  const N = String(b)
  if (!t.isAbsolute(N)) {
    return ''
  }
  try {
    return c(N)
  } catch {
    return ''
  }
}
function F1(b) {
  const N = String(b)
  if (t.isAbsolute(N)) {
    return ''
  }
  const FN = t.resolve(s, N)
  if (!FN.startsWith(s + t.sep)) {
    return ''
  }
  try {
    return c(FN)
  } catch {
    return ''
  }
}
function F2(b) {
  return String(b)
}
function F3(N, FN) {
  return Math.pow(Number(N), Number(FN))
}
const F4 = 0,
  F5 = new v(null)
F5.o(y.e, new g(F1))
F5.o(F4, new g(F0))
F5.x()
const F6 = new v(F5)
F6.o(y.f, 'io/3.0.0')
F6.x()
const F7 = new v(F6)
F7.x()
const F8 = new v(null)
F8.o(y.d, new g(F3))
F8.x()
const F9 = new v(null)
F9.o(y.a, new g(F2))
F9.o(y.b, F8)
F9.o(y.c, F7)
F9.x()
const FF = {}
FF.caps = F9
const Fr = FF
class FT {
  constructor(b) {
    this.g = b
    this.ic = new Map()
  }
  ['run'](b) {
    const N = new Array(b.nr).fill(undefined),
      FN = b.code,
      Fi = b.cs
    let Fq = 0,
      Ft = 0
    const FH = () => FN[Fq++],
      Fj = (Fa) => {
        if (Fq + Fa > FN.length) {
          throw 0
        }
      },
      FG = (Fa, Fe) => {
        let Fn = 0,
          Fy = Fa
        while (Fy !== null) {
          if (!(Fy instanceof v)) {
            break
          }
          if (Fy.y(Fe)) {
            Fa.t()
            const FA = Fy.g(Fe)
            let Fp = -1
            if (!Fy.dm && Fy.sh.m.has(Fe)) {
              Fp = Fy.sh.m.get(Fe)
            }
            const FI = {}
            return (
              (FI.ok = true),
              (FI.d = Fn),
              (FI.h = Fy),
              (FI.si = Fp),
              (FI.fn = FA),
              FI
            )
          }
          Fy = Fy.p
          Fn++
        }
        const FB = {
          c: [],
          m: true,
        }
        return (
          (FB.ok = false),
          (FB.d = -1),
          (FB.h = null),
          (FB.si = -1),
          (FB.fn = undefined),
          FB
        )
      },
      Fs = (Fa, Fe, Fn) => {
        const Fy = this.ic.get(Fa)
        if (!Fy || Fy.m) {
          return null
        }
        const FB = x
        for (const FA of Fy.c) {
          if (FA.rs !== Fe.sh.id) {
            continue
          }
          if (FA.k !== Fn) {
            continue
          }
          if (FA.v !== FB) {
            continue
          }
          let Fp = Fe
          for (let FY = 0; FY < FA.d; FY++) {
            Fp = Fp.p
            if (!(Fp instanceof v)) {
              return null
            }
          }
          const FI = Fp.sl[FA.si],
            Fu = {}
          return (Fu.fn = FI), (Fu.th = Fe), Fu
        }
        return null
      },
      FZ = (Fa, Fe, Fn, Fy) => {
        if (!Fy.ok) {
          return
        }
        if (Fy.h.dm) {
          return
        }
        let FB = this.ic.get(Fa)
        !FB && ((FB = new d()), this.ic.set(Fa, FB))
        if (FB.m) {
          return
        }
        if (FB.c.length >= a.ic) {
          return
        }
        const FA = {
          rs: Fe.sh.id,
          k: Fn,
          v: x,
          d: Fy.d,
          si: Fy.si,
        }
        FB.c.push(FA)
      },
      Fh = (Fa, Fe) => {
        const Fn = FG(Fa, Fe)
        if (!Fn.ok) {
          return
        }
        const Fy = Fn.h
        if (!Fy.z) {
          return
        }
        if (!Fy.dm) {
          Fy.dm = true
          Fy.d = new Map()
          const FB = []
          for (const [FA, Fp] of Fy.sh.m.entries()) {
            const FI = Fy.sl[Fp]
            Fy.d.set(FA, FI)
            FB.push([FA, FI])
          }
          FB.sort((Fu, FY) => Fu[0] - FY[0])
          Fy.sl = FB.map((Fu) => Fu[1])
          if (Fy.h) {
            f()
          }
        }
      }
    while (Fq < FN.length) {
      if (++Ft > a.s) {
        throw 0
      }
      const Fa = Fq,
        Fe = FH()
      switch (Fe) {
        case u.a:
          Fj(2)
          {
            const Fn = FH(),
              Fy = FH()
            N[Fn] = Fi[Fy]
            break
          }
        case u.b:
          Fj(2)
          {
            const FB = FH(),
              FA = FH(),
              Fp = Fi[FA]
            if (typeof Fp !== 'string') {
              throw 0
            }
            N[FB] = this.g[Fp]
            break
          }
        case u.c:
          Fj(3)
          {
            const FI = FH(),
              Fu = FH(),
              FY = FH(),
              FX = N[Fu]
            if (!(FX instanceof v)) {
              throw 0
            }
            N[FI] = FX.g(FY)
            FX.t()
            break
          }
        case u.d:
          Fj(4)
          {
            const Fk = FH(),
              FQ = FH(),
              FE = FH(),
              Fm = FH(),
              FS = N[FE]
            if (!(FS instanceof v)) {
              throw 0
            }
            const Fc = Fs(Fa, FS, Fm)
            if (Fc) {
              N[Fk] = Fc.fn
              N[FQ] = Fc.th
              break
            }
            const Fz = FG(FS, Fm)
            N[Fk] = Fz.fn
            N[FQ] = FS
            FZ(Fa, FS, Fm, Fz)
            break
          }
        case u.k:
          Fj(2)
          {
            const FL = FH(),
              FU = FH(),
              Fx = N[FL]
            if (!(Fx instanceof v)) {
              throw 0
            }
            Fh(Fx, FU)
            break
          }
        case u.e:
          Fj(4)
          {
            const FM = FH(),
              Ff = FH(),
              FK = FH(),
              Fo = FH()
            if (Fo > a.a) {
              throw 0
            }
            Fj(Fo)
            const FJ = N[Ff],
              Fl = N[FK],
              Fv = []
            for (let FW = 0; FW < Fo; FW++) {
              Fv.push(N[FH()])
            }
            if (!(FJ instanceof g)) {
              throw 0
            }
            N[FM] = FJ.c(Fl, Fv)
            break
          }
        case u.j:
          Fj(3)
          {
            const FP = FH(),
              FV = FH(),
              FD = FH()
            N[FP] = Number(N[FV]) + Number(N[FD])
            break
          }
        case u.h:
          Fj(2)
          {
            const FO = E(FN, Fq)
            Fq += 2
            const Fg = Fq + FO
            if (Fg < 0 || Fg > FN.length) {
              throw 0
            }
            Fq = Fg
            break
          }
        case u.i:
          Fj(3)
          {
            const Fd = FH(),
              r0 = E(FN, Fq)
            Fq += 2
            if (N[Fd]) {
              const r1 = Fq + r0
              if (r1 < 0 || r1 > FN.length) {
                throw 0
              }
              Fq = r1
            }
            break
          }
        case u.f:
          Fj(1)
          {
            const r2 = FH()
            return N[r2]
          }
        case u.g:
          return undefined
        default:
          throw 0
      }
    }
    return undefined
  }
}
const FC = {}
FC.input = process.stdin
FC.output = process.stdout
FC.terminal = false
const FR = j.createInterface(FC),
  Fb = new FT(Fr)
let Fw = false
FR.on('line', (b) => {
  if (Fw) {
    return
  }
  const N = b.trim()
  if (!N) {
    return
  }
  Fw = true
  try {
    const FN = Y(N),
      Fi = z(FN)
    U(Fi)
    const Fq = Fb.run(Fi)
    process.stdout.write(String(Fq ?? '') + '\n')
    FR.close()
    process.exit(0)
  } catch {
    process.stdout.write('ERR\n')
    FR.close()
    process.exit(1)
  }
})
FR.on('close', () => {
  !Fw && (process.stdout.write('ERR\n'), process.exit(1))
})

