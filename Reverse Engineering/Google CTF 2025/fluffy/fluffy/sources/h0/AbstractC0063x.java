package h0;

import java.util.concurrent.CancellationException;
import m0.AbstractC0081a;

/* renamed from: h0.x, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0063x extends n0.h {

    /* renamed from: d, reason: collision with root package name */
    public int f588d;

    public AbstractC0063x(int i2) {
        super(0L, n0.j.f1122g);
        this.f588d = i2;
    }

    public abstract void b(Object obj, CancellationException cancellationException);

    public abstract S.d d();

    public Throwable e(Object obj) {
        C0051k c0051k = obj instanceof C0051k ? (C0051k) obj : null;
        if (c0051k != null) {
            return c0051k.f564a;
        }
        return null;
    }

    public final void h(Throwable th, Throwable th2) {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            a.a.a(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        a0.h.b(th);
        AbstractC0059t.c(d().i(), new C0058s("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    public abstract Object j();

    @Override // java.lang.Runnable
    public final void run() {
        Object obj = Q.g.f327a;
        D.H h2 = this.f1114c;
        try {
            S.d d2 = d();
            a0.h.c(d2, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>");
            m0.h hVar = (m0.h) d2;
            U.b bVar = hVar.f1004f;
            Object obj2 = hVar.f1006h;
            S.i iVar = bVar.f348c;
            a0.h.b(iVar);
            Object m = AbstractC0081a.m(iVar, obj2);
            if (m != AbstractC0081a.f994f) {
                AbstractC0059t.i(bVar, iVar);
            }
            try {
                S.i iVar2 = bVar.f348c;
                a0.h.b(iVar2);
                Object j2 = j();
                Throwable e2 = e(j2);
                K k2 = (e2 == null && AbstractC0059t.e(this.f588d)) ? (K) iVar2.f(C0057q.f575c) : null;
                if (k2 != null && !k2.b()) {
                    CancellationException v2 = ((T) k2).v();
                    b(j2, v2);
                    bVar.c(a.a.f(v2));
                } else if (e2 != null) {
                    bVar.c(a.a.f(e2));
                } else {
                    bVar.c(f(j2));
                }
                AbstractC0081a.h(iVar, m);
                try {
                    h2.getClass();
                } catch (Throwable th) {
                    obj = a.a.f(th);
                }
                h(null, Q.d.a(obj));
            } catch (Throwable th2) {
                AbstractC0081a.h(iVar, m);
                throw th2;
            }
        } catch (Throwable th3) {
            try {
                h2.getClass();
            } catch (Throwable th4) {
                obj = a.a.f(th4);
            }
            h(th3, Q.d.a(obj));
        }
    }

    public Object f(Object obj) {
        return obj;
    }
}
