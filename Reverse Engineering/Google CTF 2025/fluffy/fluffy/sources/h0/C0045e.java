package h0;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import m0.AbstractC0081a;

/* renamed from: h0.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0045e extends AbstractC0063x implements InterfaceC0044d, U.c, d0 {

    /* renamed from: g, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f551g = AtomicIntegerFieldUpdater.newUpdater(C0045e.class, "_decisionAndIndex");

    /* renamed from: h, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f552h = AtomicReferenceFieldUpdater.newUpdater(C0045e.class, Object.class, "_state");

    /* renamed from: i, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f553i = AtomicReferenceFieldUpdater.newUpdater(C0045e.class, Object.class, "_parentHandle");
    private volatile int _decisionAndIndex;
    private volatile Object _parentHandle;
    private volatile Object _state;

    /* renamed from: e, reason: collision with root package name */
    public final S.d f554e;

    /* renamed from: f, reason: collision with root package name */
    public final S.i f555f;

    public C0045e(S.d dVar, int i2) {
        super(i2);
        this.f554e = dVar;
        this.f555f = dVar.i();
        this._decisionAndIndex = 536870911;
        this._state = C0042b.f547a;
    }

    public static void t(m0.v vVar, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + vVar + ", already has " + obj).toString());
    }

    public static Object w(Object obj, int i2, Z.l lVar) {
        return ((obj instanceof C0051k) || !AbstractC0059t.e(i2) || lVar == null) ? obj : new C0050j(obj, lVar, (CancellationException) null, 16);
    }

    @Override // h0.d0
    public final void a(j0.k kVar, int i2) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i3;
        do {
            atomicIntegerFieldUpdater = f551g;
            i3 = atomicIntegerFieldUpdater.get(this);
            if ((i3 & 536870911) != 536870911) {
                throw new IllegalStateException("invokeOnCancellation should be called at most once");
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i3, ((i3 >> 29) << 29) + i2));
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f552h;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof C0042b) {
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, kVar)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        break;
                    }
                }
                return;
            }
            if (obj instanceof m0.v) {
                t(kVar, obj);
                throw null;
            }
            if (!(obj instanceof C0051k)) {
                if (obj instanceof C0050j) {
                    ((C0050j) obj).getClass();
                    return;
                }
                return;
            }
            C0051k c0051k = (C0051k) obj;
            c0051k.getClass();
            if (!C0051k.f563b.compareAndSet(c0051k, 0, 1)) {
                t(kVar, obj);
                throw null;
            }
            if (obj instanceof C0046f) {
                if (!(obj instanceof C0051k)) {
                    c0051k = null;
                }
                l(kVar, c0051k != null ? c0051k.f564a : null);
                return;
            }
            return;
        }
    }

    @Override // h0.AbstractC0063x
    public final void b(Object obj, CancellationException cancellationException) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f552h;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof W) {
                throw new IllegalStateException("Not completed");
            }
            if (obj2 instanceof C0051k) {
                return;
            }
            if (!(obj2 instanceof C0050j)) {
                C0050j c0050j = new C0050j(obj2, (Z.l) null, cancellationException, 14);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, c0050j)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj2) {
                        break;
                    }
                }
                return;
            }
            C0050j c0050j2 = (C0050j) obj2;
            if (c0050j2.f562d != null) {
                throw new IllegalStateException("Must be called at most once");
            }
            Object obj3 = c0050j2.f559a;
            if ((15 & 2) != 0) {
                c0050j2.getClass();
            }
            Z.l lVar = c0050j2.f560b;
            Object obj4 = c0050j2.f561c;
            Throwable th = (15 & 16) != 0 ? c0050j2.f562d : cancellationException;
            c0050j2.getClass();
            C0050j c0050j3 = new C0050j(obj3, lVar, obj4, th);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, c0050j3)) {
                if (atomicReferenceFieldUpdater.get(this) != obj2) {
                    break;
                }
            }
            Z.l lVar2 = c0050j2.f560b;
            if (lVar2 != null) {
                k(lVar2, cancellationException);
                return;
            }
            return;
        }
    }

    @Override // S.d
    public final void c(Object obj) {
        Throwable a2 = Q.d.a(obj);
        if (a2 != null) {
            obj = new C0051k(a2, false);
        }
        v(obj, this.f588d, null);
    }

    @Override // h0.AbstractC0063x
    public final S.d d() {
        return this.f554e;
    }

    @Override // h0.AbstractC0063x
    public final Throwable e(Object obj) {
        Throwable e2 = super.e(obj);
        if (e2 != null) {
            return e2;
        }
        return null;
    }

    @Override // h0.AbstractC0063x
    public final Object f(Object obj) {
        return obj instanceof C0050j ? ((C0050j) obj).f559a : obj;
    }

    @Override // U.c
    public final U.c g() {
        S.d dVar = this.f554e;
        if (dVar instanceof U.c) {
            return (U.c) dVar;
        }
        return null;
    }

    @Override // S.d
    public final S.i i() {
        return this.f555f;
    }

    @Override // h0.AbstractC0063x
    public final Object j() {
        return f552h.get(this);
    }

    public final void k(Z.l lVar, Throwable th) {
        try {
            lVar.h(th);
        } catch (Throwable th2) {
            AbstractC0059t.c(this.f555f, new B.c("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    public final void l(m0.v vVar, Throwable th) {
        S.i iVar = this.f555f;
        int i2 = f551g.get(this) & 536870911;
        if (i2 == 536870911) {
            throw new IllegalStateException("The index for Segment.onCancellation(..) is broken");
        }
        try {
            vVar.g(i2, iVar);
        } catch (Throwable th2) {
            AbstractC0059t.c(iVar, new B.c("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void m(Throwable th) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f552h;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj instanceof W) {
                C0046f c0046f = new C0046f(this, th, obj instanceof m0.v);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, c0046f)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj) {
                        break;
                    }
                }
                if (((W) obj) instanceof m0.v) {
                    l((m0.v) obj, th);
                }
                if (!s()) {
                    n();
                }
                o(this.f588d);
                return;
            }
            return;
        }
    }

    public final void n() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f553i;
        InterfaceC0065z interfaceC0065z = (InterfaceC0065z) atomicReferenceFieldUpdater.get(this);
        if (interfaceC0065z == null) {
            return;
        }
        interfaceC0065z.e();
        atomicReferenceFieldUpdater.set(this, V.f544b);
    }

    public final void o(int i2) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i3;
        do {
            atomicIntegerFieldUpdater = f551g;
            i3 = atomicIntegerFieldUpdater.get(this);
            int i4 = i3 >> 29;
            if (i4 != 0) {
                if (i4 != 1) {
                    throw new IllegalStateException("Already resumed");
                }
                boolean z2 = i2 == 4;
                S.d dVar = this.f554e;
                if (z2 || !(dVar instanceof m0.h) || AbstractC0059t.e(i2) != AbstractC0059t.e(this.f588d)) {
                    AbstractC0059t.g(this, dVar, z2);
                    return;
                }
                AbstractC0056p abstractC0056p = ((m0.h) dVar).f1003e;
                S.i iVar = ((m0.h) dVar).f1004f.f348c;
                a0.h.b(iVar);
                if (abstractC0056p.g()) {
                    abstractC0056p.c(iVar, this);
                    return;
                }
                D a2 = a0.a();
                if (a2.f519d >= 4294967296L) {
                    R.c cVar = a2.f521f;
                    if (cVar == null) {
                        cVar = new R.c();
                        a2.f521f = cVar;
                    }
                    cVar.addLast(this);
                    return;
                }
                a2.k(true);
                try {
                    AbstractC0059t.g(this, dVar, true);
                    do {
                    } while (a2.l());
                } finally {
                    try {
                        return;
                    } finally {
                    }
                }
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i3, 1073741824 + (536870911 & i3)));
    }

    public final Object p() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i2;
        boolean s2 = s();
        do {
            atomicIntegerFieldUpdater = f551g;
            i2 = atomicIntegerFieldUpdater.get(this);
            int i3 = i2 >> 29;
            if (i3 != 0) {
                if (i3 != 2) {
                    throw new IllegalStateException("Already suspended");
                }
                if (s2) {
                    u();
                }
                Object obj = f552h.get(this);
                if (obj instanceof C0051k) {
                    throw ((C0051k) obj).f564a;
                }
                if (AbstractC0059t.e(this.f588d)) {
                    K k2 = (K) this.f555f.f(C0057q.f575c);
                    if (k2 != null && !k2.b()) {
                        CancellationException v2 = ((T) k2).v();
                        b(obj, v2);
                        throw v2;
                    }
                }
                return f(obj);
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i2, 536870912 + (536870911 & i2)));
        if (((InterfaceC0065z) f553i.get(this)) == null) {
            r();
        }
        if (s2) {
            u();
        }
        return T.a.f344b;
    }

    public final void q() {
        InterfaceC0065z r2 = r();
        if (r2 == null || (f552h.get(this) instanceof W)) {
            return;
        }
        r2.e();
        f553i.set(this, V.f544b);
    }

    public final InterfaceC0065z r() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        K k2 = (K) this.f555f.f(C0057q.f575c);
        if (k2 == null) {
            return null;
        }
        InterfaceC0065z d2 = AbstractC0059t.d(k2, true, new C0047g(this), 2);
        do {
            atomicReferenceFieldUpdater = f553i;
            if (atomicReferenceFieldUpdater.compareAndSet(this, null, d2)) {
                break;
            }
        } while (atomicReferenceFieldUpdater.get(this) == null);
        return d2;
    }

    public final boolean s() {
        if (this.f588d == 2) {
            S.d dVar = this.f554e;
            a0.h.c(dVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
            if (m0.h.f1002i.get((m0.h) dVar) != null) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("CancellableContinuation(");
        sb.append(AbstractC0059t.h(this.f554e));
        sb.append("){");
        Object obj = f552h.get(this);
        sb.append(obj instanceof W ? "Active" : obj instanceof C0046f ? "Cancelled" : "Completed");
        sb.append("}@");
        sb.append(AbstractC0059t.a(this));
        return sb.toString();
    }

    public final void u() {
        S.d dVar = this.f554e;
        Throwable th = null;
        m0.h hVar = dVar instanceof m0.h ? (m0.h) dVar : null;
        if (hVar != null) {
            loop0: while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = m0.h.f1002i;
                Object obj = atomicReferenceFieldUpdater.get(hVar);
                io.flutter.plugin.platform.i iVar = AbstractC0081a.f992d;
                if (obj == iVar) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(hVar, iVar, this)) {
                        if (atomicReferenceFieldUpdater.get(hVar) != iVar) {
                            break;
                        }
                    }
                    break loop0;
                } else {
                    if (!(obj instanceof Throwable)) {
                        throw new IllegalStateException(("Inconsistent state " + obj).toString());
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(hVar, obj, null)) {
                        if (atomicReferenceFieldUpdater.get(hVar) != obj) {
                            throw new IllegalArgumentException("Failed requirement.");
                        }
                    }
                    th = (Throwable) obj;
                }
            }
            if (th == null) {
                return;
            }
            n();
            m(th);
        }
    }

    public final void v(Object obj, int i2, Z.l lVar) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f552h;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 instanceof W) {
                Object w2 = w(obj, i2, lVar);
                while (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, w2)) {
                    if (atomicReferenceFieldUpdater.get(this) != obj2) {
                        break;
                    }
                }
                if (!s()) {
                    n();
                }
                o(i2);
                return;
            }
            if (obj2 instanceof C0046f) {
                C0046f c0046f = (C0046f) obj2;
                c0046f.getClass();
                if (C0046f.f556c.compareAndSet(c0046f, 0, 1)) {
                    if (lVar != null) {
                        k(lVar, c0046f.f564a);
                        return;
                    }
                    return;
                }
            }
            throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
        }
    }
}
