package c0;

import c0.g;
import kotlin.jvm.internal.i;

/* loaded from: classes.dex */
public interface e extends g.b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f141a = b.f142d;

    public static final class a {
        public static <E extends g.b> E a(e eVar, g.c<E> key) {
            i.e(key, "key");
            if (!(key instanceof c0.b)) {
                if (e.f141a != key) {
                    return null;
                }
                i.c(eVar, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
                return eVar;
            }
            c0.b bVar = (c0.b) key;
            if (!bVar.a(eVar.getKey())) {
                return null;
            }
            E e2 = (E) bVar.b(eVar);
            if (e2 instanceof g.b) {
                return e2;
            }
            return null;
        }

        public static g b(e eVar, g.c<?> key) {
            i.e(key, "key");
            if (!(key instanceof c0.b)) {
                return e.f141a == key ? h.f144d : eVar;
            }
            c0.b bVar = (c0.b) key;
            return (!bVar.a(eVar.getKey()) || bVar.b(eVar) == null) ? eVar : h.f144d;
        }
    }

    public static final class b implements g.c<e> {

        /* renamed from: d, reason: collision with root package name */
        static final /* synthetic */ b f142d = new b();

        private b() {
        }
    }

    void d(d<?> dVar);

    <T> d<T> i(d<? super T> dVar);
}
