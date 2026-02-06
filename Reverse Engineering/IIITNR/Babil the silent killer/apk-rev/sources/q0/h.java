package q0;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final /* synthetic */ class h {
    public static final j1 a(h0 h0Var, c0.g gVar, j0 j0Var, j0.p<? super h0, ? super c0.d<? super a0.q>, ? extends Object> pVar) {
        c0.g c2 = d0.c(h0Var, gVar);
        a s1Var = j0Var.c() ? new s1(c2, pVar) : new y1(c2, true);
        s1Var.w0(j0Var, s1Var, pVar);
        return s1Var;
    }

    public static /* synthetic */ j1 b(h0 h0Var, c0.g gVar, j0 j0Var, j0.p pVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            gVar = c0.h.f144d;
        }
        if ((i2 & 2) != 0) {
            j0Var = j0.DEFAULT;
        }
        return g.a(h0Var, gVar, j0Var, pVar);
    }
}
