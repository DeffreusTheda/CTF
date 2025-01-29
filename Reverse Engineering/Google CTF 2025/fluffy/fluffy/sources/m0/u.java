package m0;

import h0.AbstractC0041a;
import h0.C0051k;

/* loaded from: classes.dex */
public class u extends AbstractC0041a implements U.c {

    /* renamed from: e, reason: collision with root package name */
    public final U.f f1032e;

    public u(S.i iVar, U.f fVar) {
        super(iVar, true);
        this.f1032e = fVar;
    }

    @Override // U.c
    public final U.c g() {
        U.f fVar = this.f1032e;
        if (fVar instanceof U.c) {
            return fVar;
        }
        return null;
    }

    @Override // h0.T
    public final void m(Object obj) {
        S.d m = a.a.m(this.f1032e);
        if (obj instanceof C0051k) {
            obj = a.a.f(((C0051k) obj).f564a);
        }
        AbstractC0081a.i(m, obj, null);
    }

    @Override // h0.T
    public final void n(Object obj) {
        U.f fVar = this.f1032e;
        if (obj instanceof C0051k) {
            obj = a.a.f(((C0051k) obj).f564a);
        }
        fVar.c(obj);
    }
}
