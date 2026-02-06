package c0;

import c0.e;
import j0.p;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public interface g {

    public static final class a {

        /* renamed from: c0.g$a$a, reason: collision with other inner class name */
        static final class C0004a extends j implements p<g, b, g> {

            /* renamed from: d, reason: collision with root package name */
            public static final C0004a f143d = new C0004a();

            C0004a() {
                super(2);
            }

            @Override // j0.p
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final g invoke(g acc, b element) {
                c0.c cVar;
                i.e(acc, "acc");
                i.e(element, "element");
                g minusKey = acc.minusKey(element.getKey());
                h hVar = h.f144d;
                if (minusKey == hVar) {
                    return element;
                }
                e.b bVar = e.f141a;
                e eVar = (e) minusKey.get(bVar);
                if (eVar == null) {
                    cVar = new c0.c(minusKey, element);
                } else {
                    g minusKey2 = minusKey.minusKey(bVar);
                    if (minusKey2 == hVar) {
                        return new c0.c(element, eVar);
                    }
                    cVar = new c0.c(new c0.c(minusKey2, element), eVar);
                }
                return cVar;
            }
        }

        public static g a(g gVar, g context) {
            i.e(context, "context");
            return context == h.f144d ? gVar : (g) context.fold(gVar, C0004a.f143d);
        }
    }

    public interface b extends g {

        public static final class a {
            public static <R> R a(b bVar, R r2, p<? super R, ? super b, ? extends R> operation) {
                i.e(operation, "operation");
                return operation.invoke(r2, bVar);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static <E extends b> E b(b bVar, c<E> key) {
                i.e(key, "key");
                if (!i.a(bVar.getKey(), key)) {
                    return null;
                }
                i.c(bVar, "null cannot be cast to non-null type E of kotlin.coroutines.CoroutineContext.Element.get");
                return bVar;
            }

            public static g c(b bVar, c<?> key) {
                i.e(key, "key");
                return i.a(bVar.getKey(), key) ? h.f144d : bVar;
            }

            public static g d(b bVar, g context) {
                i.e(context, "context");
                return a.a(bVar, context);
            }
        }

        @Override // c0.g
        <E extends b> E get(c<E> cVar);

        c<?> getKey();
    }

    public interface c<E extends b> {
    }

    <R> R fold(R r2, p<? super R, ? super b, ? extends R> pVar);

    <E extends b> E get(c<E> cVar);

    g minusKey(c<?> cVar);

    g plus(g gVar);
}
