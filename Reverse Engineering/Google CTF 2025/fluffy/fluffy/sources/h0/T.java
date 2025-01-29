package h0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public class T implements K, X {

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f542b = AtomicReferenceFieldUpdater.newUpdater(T.class, Object.class, "_state");

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f543c = AtomicReferenceFieldUpdater.newUpdater(T.class, Object.class, "_parentHandle");
    private volatile Object _parentHandle;
    private volatile Object _state;

    public T(boolean z2) {
        this._state = z2 ? AbstractC0059t.f584i : AbstractC0059t.f583h;
    }

    public static C0049i D(m0.l lVar) {
        while (lVar.m()) {
            m0.l i2 = lVar.i();
            if (i2 == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = m0.l.f1016c;
                Object obj = atomicReferenceFieldUpdater.get(lVar);
                while (true) {
                    lVar = (m0.l) obj;
                    if (!lVar.m()) {
                        break;
                    }
                    obj = atomicReferenceFieldUpdater.get(lVar);
                }
            } else {
                lVar = i2;
            }
        }
        while (true) {
            lVar = lVar.l();
            if (!lVar.m()) {
                if (lVar instanceof C0049i) {
                    return (C0049i) lVar;
                }
                if (lVar instanceof U) {
                    return null;
                }
            }
        }
    }

    public static String I(Object obj) {
        if (!(obj instanceof Q)) {
            return obj instanceof H ? ((H) obj).b() ? "Active" : "New" : obj instanceof C0051k ? "Cancelled" : "Completed";
        }
        Q q2 = (Q) obj;
        return q2.e() ? "Cancelling" : q2.f() ? "Completing" : "Active";
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0052 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0055 A[EDGE_INSN: B:31:0x0055->B:25:0x0055 BREAK  A[LOOP:0: B:7:0x000c->B:30:?], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void B(h0.K r9) {
        /*
            r8 = this;
            h0.V r0 = h0.V.f544b
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = h0.T.f543c
            if (r9 != 0) goto La
            r1.set(r8, r0)
            return
        La:
            h0.T r9 = (h0.T) r9
        Lc:
            java.lang.Object r2 = r9.y()
            boolean r3 = r2 instanceof h0.A
            r4 = 1
            r5 = 0
            r6 = -1
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r7 = h0.T.f542b
            if (r3 == 0) goto L36
            r3 = r2
            h0.A r3 = (h0.A) r3
            boolean r3 = r3.f515b
            if (r3 == 0) goto L21
            goto L50
        L21:
            h0.A r3 = h0.AbstractC0059t.f584i
        L23:
            boolean r5 = r7.compareAndSet(r9, r2, r3)
            if (r5 == 0) goto L2e
            r9.getClass()
        L2c:
            r5 = 1
            goto L50
        L2e:
            java.lang.Object r5 = r7.get(r9)
            if (r5 == r2) goto L23
        L34:
            r5 = -1
            goto L50
        L36:
            boolean r3 = r2 instanceof h0.G
            if (r3 == 0) goto L50
            r3 = r2
            h0.G r3 = (h0.G) r3
            h0.U r3 = r3.f523b
        L3f:
            boolean r5 = r7.compareAndSet(r9, r2, r3)
            if (r5 == 0) goto L49
            r9.getClass()
            goto L2c
        L49:
            java.lang.Object r5 = r7.get(r9)
            if (r5 == r2) goto L3f
            goto L34
        L50:
            if (r5 == 0) goto L55
            if (r5 == r4) goto L55
            goto Lc
        L55:
            h0.i r2 = new h0.i
            r2.<init>(r8)
            r3 = 2
            h0.z r9 = h0.AbstractC0059t.d(r9, r4, r2, r3)
            h0.h r9 = (h0.InterfaceC0048h) r9
            r1.set(r8, r9)
            java.lang.Object r2 = r8.y()
            boolean r2 = r2 instanceof h0.H
            if (r2 != 0) goto L72
            r9.e()
            r1.set(r8, r0)
        L72:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: h0.T.B(h0.K):void");
    }

    public final Object C(Object obj) {
        Object J;
        do {
            J = J(y(), obj);
            if (J == AbstractC0059t.f578c) {
                String str = "Job " + this + " is already complete or completing, but is being completed with " + obj;
                C0051k c0051k = obj instanceof C0051k ? (C0051k) obj : null;
                throw new IllegalStateException(str, c0051k != null ? c0051k.f564a : null);
            }
        } while (J == AbstractC0059t.f580e);
        return J;
    }

    public final void E(U u, Throwable th) {
        Object k2 = u.k();
        a0.h.c(k2, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        B.c cVar = null;
        for (m0.l lVar = (m0.l) k2; !lVar.equals(u); lVar = lVar.l()) {
            if (lVar instanceof M) {
                O o2 = (O) lVar;
                try {
                    o2.o(th);
                } catch (Throwable th2) {
                    if (cVar != null) {
                        a.a.a(cVar, th2);
                    } else {
                        cVar = new B.c("Exception in completion handler " + o2 + " for " + this, th2);
                    }
                }
            }
        }
        if (cVar != null) {
            A(cVar);
        }
        q(th);
    }

    public final void H(O o2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        U u = new U();
        o2.getClass();
        m0.l.f1016c.lazySet(u, o2);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = m0.l.f1015b;
        atomicReferenceFieldUpdater2.lazySet(u, o2);
        loop0: while (true) {
            if (o2.k() == o2) {
                while (!atomicReferenceFieldUpdater2.compareAndSet(o2, o2, u)) {
                    if (atomicReferenceFieldUpdater2.get(o2) != o2) {
                        break;
                    }
                }
                u.j(o2);
                break loop0;
            }
            break;
        }
        m0.l l2 = o2.l();
        do {
            atomicReferenceFieldUpdater = f542b;
            if (atomicReferenceFieldUpdater.compareAndSet(this, o2, l2)) {
                return;
            }
        } while (atomicReferenceFieldUpdater.get(this) == o2);
    }

    public final Object J(Object obj, Object obj2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        if (!(obj instanceof H)) {
            return AbstractC0059t.f578c;
        }
        if (((obj instanceof A) || (obj instanceof O)) && !(obj instanceof C0049i) && !(obj2 instanceof C0051k)) {
            H h2 = (H) obj;
            Object i2 = obj2 instanceof H ? new I((H) obj2) : obj2;
            do {
                atomicReferenceFieldUpdater = f542b;
                if (atomicReferenceFieldUpdater.compareAndSet(this, h2, i2)) {
                    F(obj2);
                    s(h2, obj2);
                    return obj2;
                }
            } while (atomicReferenceFieldUpdater.get(this) == h2);
            return AbstractC0059t.f580e;
        }
        H h3 = (H) obj;
        U x2 = x(h3);
        if (x2 == null) {
            return AbstractC0059t.f580e;
        }
        C0049i c0049i = null;
        Q q2 = h3 instanceof Q ? (Q) h3 : null;
        if (q2 == null) {
            q2 = new Q(x2, null);
        }
        synchronized (q2) {
            if (q2.f()) {
                return AbstractC0059t.f578c;
            }
            Q.f534c.set(q2, 1);
            if (q2 != h3) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f542b;
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, h3, q2)) {
                    if (atomicReferenceFieldUpdater2.get(this) != h3) {
                        return AbstractC0059t.f580e;
                    }
                }
            }
            boolean e2 = q2.e();
            C0051k c0051k = obj2 instanceof C0051k ? (C0051k) obj2 : null;
            if (c0051k != null) {
                q2.a(c0051k.f564a);
            }
            Throwable d2 = q2.d();
            if (e2) {
                d2 = null;
            }
            if (d2 != null) {
                E(x2, d2);
            }
            C0049i c0049i2 = h3 instanceof C0049i ? (C0049i) h3 : null;
            if (c0049i2 == null) {
                U c2 = h3.c();
                if (c2 != null) {
                    c0049i = D(c2);
                }
            } else {
                c0049i = c0049i2;
            }
            if (c0049i != null) {
                while (AbstractC0059t.d(c0049i.f558f, false, new P(this, q2, c0049i, obj2), 1) == V.f544b) {
                    c0049i = D(c0049i);
                    if (c0049i == null) {
                    }
                }
                return AbstractC0059t.f579d;
            }
            return u(q2, obj2);
        }
    }

    @Override // h0.K
    public void a(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new L(r(), null, this);
        }
        p(cancellationException);
    }

    @Override // h0.K
    public boolean b() {
        Object y2 = y();
        return (y2 instanceof H) && ((H) y2).b();
    }

    @Override // S.i
    public final S.i d(S.h hVar) {
        return a.a.p(this, hVar);
    }

    @Override // S.i
    public final S.i e(S.i iVar) {
        return a.a.q(this, iVar);
    }

    @Override // S.i
    public final S.g f(S.h hVar) {
        return a.a.h(this, hVar);
    }

    @Override // S.g
    public final S.h getKey() {
        return C0057q.f575c;
    }

    @Override // S.i
    public final Object h(Object obj, Z.p pVar) {
        return pVar.d(obj, this);
    }

    public final boolean l(H h2, U u, O o2) {
        char c2;
        S s2 = new S(o2, this, h2);
        do {
            m0.l i2 = u.i();
            if (i2 == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = m0.l.f1016c;
                Object obj = atomicReferenceFieldUpdater.get(u);
                while (true) {
                    i2 = (m0.l) obj;
                    if (!i2.m()) {
                        break;
                    }
                    obj = atomicReferenceFieldUpdater.get(i2);
                }
            }
            m0.l.f1016c.lazySet(o2, i2);
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = m0.l.f1015b;
            atomicReferenceFieldUpdater2.lazySet(o2, u);
            s2.f539c = u;
            while (true) {
                if (atomicReferenceFieldUpdater2.compareAndSet(i2, u, s2)) {
                    c2 = s2.a(i2) == null ? (char) 1 : (char) 2;
                } else if (atomicReferenceFieldUpdater2.get(i2) != u) {
                    c2 = 0;
                    break;
                }
            }
            if (c2 == 1) {
                return true;
            }
        } while (c2 != 2);
        return false;
    }

    public void n(Object obj) {
        m(obj);
    }

    public final boolean o(Object obj) {
        io.flutter.plugin.platform.i iVar;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Object obj2 = AbstractC0059t.f578c;
        if (this instanceof N) {
            do {
                Object y2 = y();
                if (!(y2 instanceof H) || ((y2 instanceof Q) && ((Q) y2).f())) {
                    obj2 = AbstractC0059t.f578c;
                    break;
                }
                obj2 = J(y2, new C0051k(t(obj), false));
            } while (obj2 == AbstractC0059t.f580e);
            if (obj2 == AbstractC0059t.f579d) {
                return true;
            }
        }
        if (obj2 == AbstractC0059t.f578c) {
            Throwable th = null;
            loop1: while (true) {
                Object y3 = y();
                if (!(y3 instanceof Q)) {
                    if (!(y3 instanceof H)) {
                        iVar = AbstractC0059t.f581f;
                        break;
                    }
                    if (th == null) {
                        th = t(obj);
                    }
                    H h2 = (H) y3;
                    if (h2.b()) {
                        U x2 = x(h2);
                        if (x2 == null) {
                            continue;
                        } else {
                            Q q2 = new Q(x2, th);
                            do {
                                atomicReferenceFieldUpdater = f542b;
                                if (atomicReferenceFieldUpdater.compareAndSet(this, h2, q2)) {
                                    E(x2, th);
                                    iVar = AbstractC0059t.f578c;
                                    break loop1;
                                }
                            } while (atomicReferenceFieldUpdater.get(this) == h2);
                        }
                    } else {
                        Object J = J(y3, new C0051k(th, false));
                        if (J == AbstractC0059t.f578c) {
                            throw new IllegalStateException(("Cannot happen in " + y3).toString());
                        }
                        if (J != AbstractC0059t.f580e) {
                            obj2 = J;
                            break;
                        }
                    }
                } else {
                    synchronized (y3) {
                        try {
                            Q q3 = (Q) y3;
                            q3.getClass();
                            if (Q.f536e.get(q3) == AbstractC0059t.f582g) {
                                iVar = AbstractC0059t.f581f;
                            } else {
                                boolean e2 = ((Q) y3).e();
                                if (th == null) {
                                    th = t(obj);
                                }
                                ((Q) y3).a(th);
                                Throwable d2 = e2 ? null : ((Q) y3).d();
                                if (d2 != null) {
                                    E(((Q) y3).f537b, d2);
                                }
                                iVar = AbstractC0059t.f578c;
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                }
            }
            obj2 = iVar;
        }
        if (obj2 == AbstractC0059t.f578c || obj2 == AbstractC0059t.f579d) {
            return true;
        }
        if (obj2 == AbstractC0059t.f581f) {
            return false;
        }
        m(obj2);
        return true;
    }

    public void p(CancellationException cancellationException) {
        o(cancellationException);
    }

    public final boolean q(Throwable th) {
        if (this instanceof m0.u) {
            return true;
        }
        boolean z2 = th instanceof CancellationException;
        InterfaceC0048h interfaceC0048h = (InterfaceC0048h) f543c.get(this);
        return (interfaceC0048h == null || interfaceC0048h == V.f544b) ? z2 : interfaceC0048h.g(th) || z2;
    }

    public String r() {
        return "Job was cancelled";
    }

    public final void s(H h2, Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f543c;
        InterfaceC0048h interfaceC0048h = (InterfaceC0048h) atomicReferenceFieldUpdater.get(this);
        if (interfaceC0048h != null) {
            interfaceC0048h.e();
            atomicReferenceFieldUpdater.set(this, V.f544b);
        }
        B.c cVar = null;
        C0051k c0051k = obj instanceof C0051k ? (C0051k) obj : null;
        Throwable th = c0051k != null ? c0051k.f564a : null;
        if (h2 instanceof O) {
            try {
                ((O) h2).o(th);
                return;
            } catch (Throwable th2) {
                A(new B.c("Exception in completion handler " + h2 + " for " + this, th2));
                return;
            }
        }
        U c2 = h2.c();
        if (c2 != null) {
            Object k2 = c2.k();
            a0.h.c(k2, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
            for (m0.l lVar = (m0.l) k2; !lVar.equals(c2); lVar = lVar.l()) {
                if (lVar instanceof O) {
                    O o2 = (O) lVar;
                    try {
                        o2.o(th);
                    } catch (Throwable th3) {
                        if (cVar != null) {
                            a.a.a(cVar, th3);
                        } else {
                            cVar = new B.c("Exception in completion handler " + o2 + " for " + this, th3);
                        }
                    }
                }
            }
            if (cVar != null) {
                A(cVar);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Throwable] */
    public final Throwable t(Object obj) {
        CancellationException cancellationException;
        if (obj instanceof Throwable) {
            return (Throwable) obj;
        }
        T t2 = (T) ((X) obj);
        Object y2 = t2.y();
        if (y2 instanceof Q) {
            cancellationException = ((Q) y2).d();
        } else if (y2 instanceof C0051k) {
            cancellationException = ((C0051k) y2).f564a;
        } else {
            if (y2 instanceof H) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + y2).toString());
            }
            cancellationException = null;
        }
        CancellationException cancellationException2 = cancellationException instanceof CancellationException ? cancellationException : null;
        if (cancellationException2 == null) {
            cancellationException2 = new L("Parent job is ".concat(I(y2)), cancellationException, t2);
        }
        return cancellationException2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName() + '{' + I(y()) + '}');
        sb.append('@');
        sb.append(AbstractC0059t.a(this));
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object u(Q q2, Object obj) {
        Throwable th = null;
        C0051k c0051k = obj instanceof C0051k ? (C0051k) obj : null;
        Throwable th2 = c0051k != null ? c0051k.f564a : null;
        synchronized (q2) {
            q2.e();
            ArrayList<Throwable> g2 = q2.g(th2);
            if (!g2.isEmpty()) {
                Iterator it = g2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (!(((Throwable) next) instanceof CancellationException)) {
                        th = next;
                        break;
                    }
                }
                th = th;
                if (th == null) {
                    th = (Throwable) g2.get(0);
                }
            } else if (q2.e()) {
                th = new L(r(), null, this);
            }
            if (th != null && g2.size() > 1) {
                Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap(g2.size()));
                for (Throwable th3 : g2) {
                    if (th3 != th && th3 != th && !(th3 instanceof CancellationException) && newSetFromMap.add(th3)) {
                        a.a.a(th, th3);
                    }
                }
            }
        }
        if (th != null && th != th2) {
            obj = new C0051k(th, false);
        }
        if (th != null && (q(th) || z(th))) {
            a0.h.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
            C0051k.f563b.compareAndSet((C0051k) obj, 0, 1);
        }
        F(obj);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f542b;
        Object i2 = obj instanceof H ? new I((H) obj) : obj;
        while (!atomicReferenceFieldUpdater.compareAndSet(this, q2, i2) && atomicReferenceFieldUpdater.get(this) == q2) {
        }
        s(q2, obj);
        return obj;
    }

    public final CancellationException v() {
        CancellationException cancellationException;
        Object y2 = y();
        if (!(y2 instanceof Q)) {
            if (y2 instanceof H) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
            if (!(y2 instanceof C0051k)) {
                return new L(getClass().getSimpleName().concat(" has completed normally"), null, this);
            }
            Throwable th = ((C0051k) y2).f564a;
            cancellationException = th instanceof CancellationException ? (CancellationException) th : null;
            return cancellationException == null ? new L(r(), th, this) : cancellationException;
        }
        Throwable d2 = ((Q) y2).d();
        if (d2 == null) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        String concat = getClass().getSimpleName().concat(" is cancelling");
        cancellationException = d2 instanceof CancellationException ? (CancellationException) d2 : null;
        if (cancellationException != null) {
            return cancellationException;
        }
        if (concat == null) {
            concat = r();
        }
        return new L(concat, d2, this);
    }

    public boolean w() {
        return true;
    }

    public final U x(H h2) {
        U c2 = h2.c();
        if (c2 != null) {
            return c2;
        }
        if (h2 instanceof A) {
            return new U();
        }
        if (h2 instanceof O) {
            H((O) h2);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + h2).toString());
    }

    public final Object y() {
        while (true) {
            Object obj = f542b.get(this);
            if (!(obj instanceof m0.r)) {
                return obj;
            }
            ((m0.r) obj).a(this);
        }
    }

    public boolean z(Throwable th) {
        return false;
    }

    public void G() {
    }

    public void A(B.c cVar) {
        throw cVar;
    }

    public void F(Object obj) {
    }

    public void m(Object obj) {
    }
}
