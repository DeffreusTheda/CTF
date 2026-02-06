package q0;

import a0.k;
import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public abstract class o0<T> extends kotlinx.coroutines.scheduling.i {

    /* renamed from: f, reason: collision with root package name */
    public int f1035f;

    public o0(int i2) {
        this.f1035f = i2;
    }

    public void a(Object obj, Throwable th) {
    }

    public abstract c0.d<T> b();

    public Throwable c(Object obj) {
        y yVar = obj instanceof y ? (y) obj : null;
        if (yVar == null) {
            return null;
        }
        return yVar.f1083a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T d(Object obj) {
        return obj;
    }

    public final void f(Throwable th, Throwable th2) {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            a0.b.a(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        kotlin.jvm.internal.i.b(th);
        g0.a(b().getContext(), new k0("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    public abstract Object h();

    @Override // java.lang.Runnable
    public final void run() {
        Object a2;
        Object a3;
        Object a4;
        kotlinx.coroutines.scheduling.j jVar = this.f900e;
        try {
            kotlinx.coroutines.internal.g gVar = (kotlinx.coroutines.internal.g) b();
            c0.d<T> dVar = gVar.f818h;
            Object obj = gVar.f820j;
            c0.g context = dVar.getContext();
            Object c2 = kotlinx.coroutines.internal.c0.c(context, obj);
            c2<?> e2 = c2 != kotlinx.coroutines.internal.c0.f801a ? d0.e(dVar, context, c2) : null;
            try {
                c0.g context2 = dVar.getContext();
                Object h2 = h();
                Throwable c3 = c(h2);
                j1 j1Var = (c3 == null && p0.b(this.f1035f)) ? (j1) context2.get(j1.f1021c) : null;
                if (j1Var != null && !j1Var.a()) {
                    CancellationException j2 = j1Var.j();
                    a(h2, j2);
                    k.a aVar = a0.k.f16d;
                    a3 = a0.k.a(a0.l.a(j2));
                } else if (c3 != null) {
                    k.a aVar2 = a0.k.f16d;
                    a3 = a0.k.a(a0.l.a(c3));
                } else {
                    T d2 = d(h2);
                    k.a aVar3 = a0.k.f16d;
                    a3 = a0.k.a(d2);
                }
                dVar.resumeWith(a3);
                a0.q qVar = a0.q.f22a;
                try {
                    k.a aVar4 = a0.k.f16d;
                    jVar.g();
                    a4 = a0.k.a(qVar);
                } catch (Throwable th) {
                    k.a aVar5 = a0.k.f16d;
                    a4 = a0.k.a(a0.l.a(th));
                }
                f(null, a0.k.b(a4));
            } finally {
                if (e2 == null || e2.y0()) {
                    kotlinx.coroutines.internal.c0.a(context, c2);
                }
            }
        } catch (Throwable th2) {
            try {
                k.a aVar6 = a0.k.f16d;
                jVar.g();
                a2 = a0.k.a(a0.q.f22a);
            } catch (Throwable th3) {
                k.a aVar7 = a0.k.f16d;
                a2 = a0.k.a(a0.l.a(th3));
            }
            f(th2, a0.k.b(a2));
        }
    }
}
