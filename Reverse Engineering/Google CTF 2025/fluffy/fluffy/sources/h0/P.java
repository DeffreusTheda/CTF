package h0;

/* loaded from: classes.dex */
public final class P extends O {

    /* renamed from: f, reason: collision with root package name */
    public final T f530f;

    /* renamed from: g, reason: collision with root package name */
    public final Q f531g;

    /* renamed from: h, reason: collision with root package name */
    public final C0049i f532h;

    /* renamed from: i, reason: collision with root package name */
    public final Object f533i;

    public P(T t2, Q q2, C0049i c0049i, Object obj) {
        this.f530f = t2;
        this.f531g = q2;
        this.f532h = c0049i;
        this.f533i = obj;
    }

    @Override // Z.l
    public final /* bridge */ /* synthetic */ Object h(Object obj) {
        o((Throwable) obj);
        return Q.g.f327a;
    }

    @Override // h0.O
    public final void o(Throwable th) {
        C0049i c0049i = this.f532h;
        T t2 = this.f530f;
        t2.getClass();
        C0049i D2 = T.D(c0049i);
        Q q2 = this.f531g;
        Object obj = this.f533i;
        if (D2 != null) {
            while (AbstractC0059t.d(D2.f558f, false, new P(t2, q2, D2, obj), 1) == V.f544b) {
                D2 = T.D(D2);
                if (D2 == null) {
                }
            }
            return;
        }
        t2.m(t2.u(q2, obj));
    }
}
