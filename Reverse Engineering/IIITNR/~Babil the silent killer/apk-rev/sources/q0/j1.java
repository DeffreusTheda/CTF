package q0;

import c0.g;
import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public interface j1 extends g.b {

    /* renamed from: c, reason: collision with root package name */
    public static final b f1021c = b.f1022d;

    public static final class a {
        public static /* synthetic */ void a(j1 j1Var, CancellationException cancellationException, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i2 & 1) != 0) {
                cancellationException = null;
            }
            j1Var.b(cancellationException);
        }

        public static <R> R b(j1 j1Var, R r2, j0.p<? super R, ? super g.b, ? extends R> pVar) {
            return (R) g.b.a.a(j1Var, r2, pVar);
        }

        public static <E extends g.b> E c(j1 j1Var, g.c<E> cVar) {
            return (E) g.b.a.b(j1Var, cVar);
        }

        public static /* synthetic */ s0 d(j1 j1Var, boolean z2, boolean z3, j0.l lVar, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
            }
            if ((i2 & 1) != 0) {
                z2 = false;
            }
            if ((i2 & 2) != 0) {
                z3 = true;
            }
            return j1Var.f(z2, z3, lVar);
        }

        public static c0.g e(j1 j1Var, g.c<?> cVar) {
            return g.b.a.c(j1Var, cVar);
        }

        public static c0.g f(j1 j1Var, c0.g gVar) {
            return g.b.a.d(j1Var, gVar);
        }
    }

    public static final class b implements g.c<j1> {

        /* renamed from: d, reason: collision with root package name */
        static final /* synthetic */ b f1022d = new b();

        private b() {
        }
    }

    boolean a();

    void b(CancellationException cancellationException);

    s0 f(boolean z2, boolean z3, j0.l<? super Throwable, a0.q> lVar);

    CancellationException j();

    boolean m();

    q q(s sVar);
}
