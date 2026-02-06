package q0;

import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
final /* synthetic */ class o1 {
    public static final w a(j1 j1Var) {
        return new m1(j1Var);
    }

    public static /* synthetic */ w b(j1 j1Var, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j1Var = null;
        }
        return n1.a(j1Var);
    }

    public static final void c(c0.g gVar, CancellationException cancellationException) {
        j1 j1Var = (j1) gVar.get(j1.f1021c);
        if (j1Var == null) {
            return;
        }
        j1Var.b(cancellationException);
    }

    public static final void d(c0.g gVar) {
        j1 j1Var = (j1) gVar.get(j1.f1021c);
        if (j1Var == null) {
            return;
        }
        n1.e(j1Var);
    }

    public static final void e(j1 j1Var) {
        if (!j1Var.a()) {
            throw j1Var.j();
        }
    }
}
