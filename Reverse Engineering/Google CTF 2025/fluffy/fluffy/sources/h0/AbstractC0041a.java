package h0;

import m0.AbstractC0081a;

/* renamed from: h0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0041a extends T implements S.d, r {

    /* renamed from: d, reason: collision with root package name */
    public final S.i f545d;

    public AbstractC0041a(S.i iVar, boolean z2) {
        super(z2);
        B((K) iVar.f(C0057q.f575c));
        this.f545d = iVar.e(this);
    }

    @Override // h0.T
    public final void A(B.c cVar) {
        AbstractC0059t.c(this.f545d, cVar);
    }

    @Override // h0.T
    public final void F(Object obj) {
        if (!(obj instanceof C0051k)) {
            L(obj);
        } else {
            C0051k c0051k = (C0051k) obj;
            K(c0051k.f564a, C0051k.f563b.get(c0051k) != 0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void M(int i2, AbstractC0041a abstractC0041a, Z.p pVar) {
        int a2 = n.e.a(i2);
        Q.g gVar = Q.g.f327a;
        if (a2 == 0) {
            try {
                AbstractC0081a.i(a.a.m(((U.b) pVar).b(abstractC0041a, this)), gVar, null);
                return;
            } finally {
                c(a.a.f(th));
            }
        }
        if (a2 != 1) {
            if (a2 == 2) {
                a.a.m(((U.b) pVar).b(abstractC0041a, this)).c(gVar);
                return;
            }
            if (a2 != 3) {
                throw new B.c();
            }
            try {
                S.i iVar = this.f545d;
                Object m = AbstractC0081a.m(iVar, null);
                try {
                    a0.n.a(2, pVar);
                    Object d2 = pVar.d(abstractC0041a, this);
                    if (d2 != T.a.f344b) {
                        c(d2);
                    }
                } finally {
                    AbstractC0081a.h(iVar, m);
                }
            } catch (Throwable th) {
            }
        }
    }

    @Override // S.d
    public final void c(Object obj) {
        Throwable a2 = Q.d.a(obj);
        if (a2 != null) {
            obj = new C0051k(a2, false);
        }
        Object C2 = C(obj);
        if (C2 == AbstractC0059t.f579d) {
            return;
        }
        n(C2);
    }

    @Override // S.d
    public final S.i i() {
        return this.f545d;
    }

    @Override // h0.r
    public final S.i k() {
        return this.f545d;
    }

    @Override // h0.T
    public final String r() {
        return getClass().getSimpleName().concat(" was cancelled");
    }

    public void L(Object obj) {
    }

    public void K(Throwable th, boolean z2) {
    }
}
