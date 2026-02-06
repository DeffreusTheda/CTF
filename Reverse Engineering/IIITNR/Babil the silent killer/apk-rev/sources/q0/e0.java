package q0;

import c0.e;
import c0.g;

/* loaded from: classes.dex */
public abstract class e0 extends c0.a implements c0.e {

    /* renamed from: d, reason: collision with root package name */
    public static final a f1004d = new a(null);

    public static final class a extends c0.b<c0.e, e0> {

        /* renamed from: q0.e0$a$a, reason: collision with other inner class name */
        static final class C0025a extends kotlin.jvm.internal.j implements j0.l<g.b, e0> {

            /* renamed from: d, reason: collision with root package name */
            public static final C0025a f1005d = new C0025a();

            C0025a() {
                super(1);
            }

            @Override // j0.l
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final e0 invoke(g.b bVar) {
                if (bVar instanceof e0) {
                    return (e0) bVar;
                }
                return null;
            }
        }

        private a() {
            super(c0.e.f141a, C0025a.f1005d);
        }

        public /* synthetic */ a(kotlin.jvm.internal.e eVar) {
            this();
        }
    }

    public e0() {
        super(c0.e.f141a);
    }

    @Override // c0.e
    public final void d(c0.d<?> dVar) {
        ((kotlinx.coroutines.internal.g) dVar).q();
    }

    @Override // c0.a, c0.g.b, c0.g
    public <E extends g.b> E get(g.c<E> cVar) {
        return (E) e.a.a(this, cVar);
    }

    @Override // c0.e
    public final <T> c0.d<T> i(c0.d<? super T> dVar) {
        return new kotlinx.coroutines.internal.g(this, dVar);
    }

    public abstract void k(c0.g gVar, Runnable runnable);

    public boolean l(c0.g gVar) {
        return true;
    }

    @Override // c0.a, c0.g
    public c0.g minusKey(g.c<?> cVar) {
        return e.a.b(this, cVar);
    }

    public String toString() {
        return l0.a(this) + '@' + l0.b(this);
    }
}
