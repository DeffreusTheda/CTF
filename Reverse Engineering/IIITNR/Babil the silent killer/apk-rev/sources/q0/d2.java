package q0;

import c0.g;

/* loaded from: classes.dex */
final class d2 implements g.b, g.c<d2> {

    /* renamed from: d, reason: collision with root package name */
    public static final d2 f1003d = new d2();

    private d2() {
    }

    @Override // c0.g
    public <R> R fold(R r2, j0.p<? super R, ? super g.b, ? extends R> pVar) {
        return (R) g.b.a.a(this, r2, pVar);
    }

    @Override // c0.g.b, c0.g
    public <E extends g.b> E get(g.c<E> cVar) {
        return (E) g.b.a.b(this, cVar);
    }

    @Override // c0.g.b
    public g.c<?> getKey() {
        return this;
    }

    @Override // c0.g
    public c0.g minusKey(g.c<?> cVar) {
        return g.b.a.c(this, cVar);
    }

    @Override // c0.g
    public c0.g plus(c0.g gVar) {
        return g.b.a.d(this, gVar);
    }
}
