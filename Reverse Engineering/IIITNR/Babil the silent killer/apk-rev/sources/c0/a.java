package c0;

import c0.g;
import j0.p;
import kotlin.jvm.internal.i;

/* loaded from: classes.dex */
public abstract class a implements g.b {
    private final g.c<?> key;

    public a(g.c<?> key) {
        i.e(key, "key");
        this.key = key;
    }

    @Override // c0.g
    public <R> R fold(R r2, p<? super R, ? super g.b, ? extends R> pVar) {
        return (R) g.b.a.a(this, r2, pVar);
    }

    @Override // c0.g.b, c0.g
    public <E extends g.b> E get(g.c<E> cVar) {
        return (E) g.b.a.b(this, cVar);
    }

    @Override // c0.g.b
    public g.c<?> getKey() {
        return this.key;
    }

    @Override // c0.g
    public g minusKey(g.c<?> cVar) {
        return g.b.a.c(this, cVar);
    }

    @Override // c0.g
    public g plus(g gVar) {
        return g.b.a.d(this, gVar);
    }
}
