package h0;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import m0.AbstractC0081a;

/* renamed from: h0.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0059t {

    /* renamed from: a, reason: collision with root package name */
    public static final io.flutter.plugin.platform.i f576a = new io.flutter.plugin.platform.i(1, "RESUME_TOKEN");

    /* renamed from: b, reason: collision with root package name */
    public static final io.flutter.plugin.platform.i f577b = new io.flutter.plugin.platform.i(1, "CLOSED_EMPTY");

    /* renamed from: c, reason: collision with root package name */
    public static final io.flutter.plugin.platform.i f578c = new io.flutter.plugin.platform.i(1, "COMPLETING_ALREADY");

    /* renamed from: d, reason: collision with root package name */
    public static final io.flutter.plugin.platform.i f579d = new io.flutter.plugin.platform.i(1, "COMPLETING_WAITING_CHILDREN");

    /* renamed from: e, reason: collision with root package name */
    public static final io.flutter.plugin.platform.i f580e = new io.flutter.plugin.platform.i(1, "COMPLETING_RETRY");

    /* renamed from: f, reason: collision with root package name */
    public static final io.flutter.plugin.platform.i f581f = new io.flutter.plugin.platform.i(1, "TOO_LATE_TO_CANCEL");

    /* renamed from: g, reason: collision with root package name */
    public static final io.flutter.plugin.platform.i f582g = new io.flutter.plugin.platform.i(1, "SEALED");

    /* renamed from: h, reason: collision with root package name */
    public static final A f583h = new A(false);

    /* renamed from: i, reason: collision with root package name */
    public static final A f584i = new A(true);

    public static final String a(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final C0045e b(S.d dVar) {
        C0045e c0045e;
        C0045e c0045e2;
        if (!(dVar instanceof m0.h)) {
            return new C0045e(dVar, 1);
        }
        m0.h hVar = (m0.h) dVar;
        loop0: while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = m0.h.f1002i;
            Object obj = atomicReferenceFieldUpdater.get(hVar);
            io.flutter.plugin.platform.i iVar = AbstractC0081a.f992d;
            c0045e = null;
            if (obj == null) {
                atomicReferenceFieldUpdater.set(hVar, iVar);
                c0045e2 = null;
                break;
            }
            if (obj instanceof C0045e) {
                while (!atomicReferenceFieldUpdater.compareAndSet(hVar, obj, iVar)) {
                    if (atomicReferenceFieldUpdater.get(hVar) != obj) {
                        break;
                    }
                }
                c0045e2 = (C0045e) obj;
                break loop0;
            }
            if (obj != iVar && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
        if (c0045e2 != null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = C0045e.f552h;
            Object obj2 = atomicReferenceFieldUpdater2.get(c0045e2);
            if (!(obj2 instanceof C0050j) || ((C0050j) obj2).f561c == null) {
                C0045e.f551g.set(c0045e2, 536870911);
                atomicReferenceFieldUpdater2.set(c0045e2, C0042b.f547a);
                c0045e = c0045e2;
            } else {
                c0045e2.n();
            }
            if (c0045e != null) {
                return c0045e;
            }
        }
        return new C0045e(dVar, 2);
    }

    public static final void c(S.i iVar, Throwable th) {
        try {
            i0.b bVar = (i0.b) iVar.f(C0057q.f574b);
            if (bVar != null) {
                bVar.c(iVar, th);
            } else {
                AbstractC0081a.e(iVar, th);
            }
        } catch (Throwable th2) {
            if (th != th2) {
                RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                a.a.a(runtimeException, th);
                th = runtimeException;
            }
            AbstractC0081a.e(iVar, th);
        }
    }

    public static InterfaceC0065z d(K k2, boolean z2, O o2, int i2) {
        O o3;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Throwable th;
        if ((i2 & 1) != 0) {
            z2 = false;
        }
        boolean z3 = (i2 & 2) != 0;
        T t2 = (T) k2;
        t2.getClass();
        if (z2) {
            o3 = o2 instanceof M ? (M) o2 : null;
            if (o3 == null) {
                o3 = new J(o2);
            }
        } else {
            o3 = o2;
        }
        o3.f529e = t2;
        while (true) {
            Object y2 = t2.y();
            if (y2 instanceof A) {
                A a2 = (A) y2;
                if (a2.f515b) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = T.f542b;
                    while (!atomicReferenceFieldUpdater2.compareAndSet(t2, y2, o3)) {
                        if (atomicReferenceFieldUpdater2.get(t2) != y2) {
                            break;
                        }
                    }
                    return o3;
                }
                U u = new U();
                H g2 = a2.f515b ? u : new G(u);
                do {
                    atomicReferenceFieldUpdater = T.f542b;
                    if (atomicReferenceFieldUpdater.compareAndSet(t2, a2, g2)) {
                        break;
                    }
                } while (atomicReferenceFieldUpdater.get(t2) == a2);
            } else {
                if (!(y2 instanceof H)) {
                    if (z3) {
                        C0051k c0051k = y2 instanceof C0051k ? (C0051k) y2 : null;
                        o2.h(c0051k != null ? c0051k.f564a : null);
                    }
                    return V.f544b;
                }
                U c2 = ((H) y2).c();
                if (c2 == null) {
                    a0.h.c(y2, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    t2.H((O) y2);
                } else {
                    InterfaceC0065z interfaceC0065z = V.f544b;
                    if (z2 && (y2 instanceof Q)) {
                        synchronized (y2) {
                            try {
                                th = ((Q) y2).d();
                                if (th != null) {
                                    if ((o2 instanceof C0049i) && !((Q) y2).f()) {
                                    }
                                }
                                if (t2.l((H) y2, c2, o3)) {
                                    if (th == null) {
                                        return o3;
                                    }
                                    interfaceC0065z = o3;
                                }
                            } catch (Throwable th2) {
                                throw th2;
                            }
                        }
                    } else {
                        th = null;
                    }
                    if (th != null) {
                        if (z3) {
                            o2.h(th);
                        }
                        return interfaceC0065z;
                    }
                    if (t2.l((H) y2, c2, o3)) {
                        return o3;
                    }
                }
            }
        }
    }

    public static final boolean e(int i2) {
        return i2 == 1 || i2 == 2;
    }

    public static final S.i f(r rVar, S.i iVar) {
        S.i e2;
        S.i k2 = rVar.k();
        Boolean bool = Boolean.FALSE;
        C0053m c0053m = C0053m.f568e;
        boolean booleanValue = ((Boolean) k2.h(bool, c0053m)).booleanValue();
        boolean booleanValue2 = ((Boolean) iVar.h(bool, c0053m)).booleanValue();
        if (booleanValue || booleanValue2) {
            S.j jVar = S.j.f343b;
            S.i iVar2 = (S.i) k2.h(jVar, new C0053m(2, 2));
            Object obj = iVar;
            if (booleanValue2) {
                obj = iVar.h(jVar, C0053m.f567d);
            }
            e2 = iVar2.e((S.i) obj);
        } else {
            e2 = k2.e(iVar);
        }
        n0.d dVar = AbstractC0064y.f589a;
        return (e2 == dVar || e2.f(S.e.f342b) != null) ? e2 : e2.e(dVar);
    }

    public static final void g(C0045e c0045e, S.d dVar, boolean z2) {
        Object obj = C0045e.f552h.get(c0045e);
        Throwable e2 = c0045e.e(obj);
        Object f2 = e2 != null ? a.a.f(e2) : c0045e.f(obj);
        if (!z2) {
            dVar.c(f2);
            return;
        }
        a0.h.c(dVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
        m0.h hVar = (m0.h) dVar;
        U.b bVar = hVar.f1004f;
        S.i iVar = bVar.f348c;
        a0.h.b(iVar);
        Object m = AbstractC0081a.m(iVar, hVar.f1006h);
        if (m != AbstractC0081a.f994f) {
            i(bVar, iVar);
        }
        try {
            bVar.c(f2);
        } finally {
            AbstractC0081a.h(iVar, m);
        }
    }

    public static final String h(S.d dVar) {
        Object f2;
        if (dVar instanceof m0.h) {
            return dVar.toString();
        }
        try {
            f2 = dVar + '@' + a(dVar);
        } catch (Throwable th) {
            f2 = a.a.f(th);
        }
        if (Q.d.a(f2) != null) {
            f2 = dVar.getClass().getName() + '@' + a(dVar);
        }
        return (String) f2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [U.b] */
    /* JADX WARN: Type inference failed for: r1v1, types: [U.c] */
    /* JADX WARN: Type inference failed for: r1v2, types: [U.c] */
    public static final void i(U.b bVar, S.i iVar) {
        if ((bVar instanceof U.c) && iVar.f(c0.f550b) != null) {
            do {
                bVar = bVar.g();
            } while (bVar != 0);
        }
    }
}
