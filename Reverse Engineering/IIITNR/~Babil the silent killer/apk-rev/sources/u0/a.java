package u0;

import c0.g;
import j0.p;

/* loaded from: classes.dex */
public final class a implements g.b {

    /* renamed from: f, reason: collision with root package name */
    public static final C0030a f1186f = new C0030a(null);

    /* renamed from: d, reason: collision with root package name */
    public final Throwable f1187d;

    /* renamed from: e, reason: collision with root package name */
    private final g.c<?> f1188e = f1186f;

    /* renamed from: u0.a$a, reason: collision with other inner class name */
    public static final class C0030a implements g.c<a> {
        private C0030a() {
        }

        public /* synthetic */ C0030a(kotlin.jvm.internal.e eVar) {
            this();
        }
    }

    public a(Throwable th) {
        this.f1187d = th;
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
        return this.f1188e;
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
