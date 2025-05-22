package kotlinx.coroutines.internal;

import c0.g;
import q0.z1;

/* loaded from: classes.dex */
public final class c0 {

    /* renamed from: a, reason: collision with root package name */
    public static final y f801a = new y("NO_THREAD_ELEMENTS");

    /* renamed from: b, reason: collision with root package name */
    private static final j0.p<Object, g.b, Object> f802b = a.f805d;

    /* renamed from: c, reason: collision with root package name */
    private static final j0.p<z1<?>, g.b, z1<?>> f803c = b.f806d;

    /* renamed from: d, reason: collision with root package name */
    private static final j0.p<f0, g.b, f0> f804d = c.f807d;

    static final class a extends kotlin.jvm.internal.j implements j0.p<Object, g.b, Object> {

        /* renamed from: d, reason: collision with root package name */
        public static final a f805d = new a();

        a() {
            super(2);
        }

        @Override // j0.p
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Object obj, g.b bVar) {
            if (!(bVar instanceof z1)) {
                return obj;
            }
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            int intValue = num == null ? 1 : num.intValue();
            return intValue == 0 ? bVar : Integer.valueOf(intValue + 1);
        }
    }

    static final class b extends kotlin.jvm.internal.j implements j0.p<z1<?>, g.b, z1<?>> {

        /* renamed from: d, reason: collision with root package name */
        public static final b f806d = new b();

        b() {
            super(2);
        }

        @Override // j0.p
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final z1<?> invoke(z1<?> z1Var, g.b bVar) {
            if (z1Var != null) {
                return z1Var;
            }
            if (bVar instanceof z1) {
                return (z1) bVar;
            }
            return null;
        }
    }

    static final class c extends kotlin.jvm.internal.j implements j0.p<f0, g.b, f0> {

        /* renamed from: d, reason: collision with root package name */
        public static final c f807d = new c();

        c() {
            super(2);
        }

        @Override // j0.p
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final f0 invoke(f0 f0Var, g.b bVar) {
            if (bVar instanceof z1) {
                z1<?> z1Var = (z1) bVar;
                f0Var.a(z1Var, z1Var.n(f0Var.f812a));
            }
            return f0Var;
        }
    }

    public static final void a(c0.g gVar, Object obj) {
        if (obj == f801a) {
            return;
        }
        if (obj instanceof f0) {
            ((f0) obj).b(gVar);
            return;
        }
        Object fold = gVar.fold(null, f803c);
        if (fold == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        }
        ((z1) fold).h(gVar, obj);
    }

    public static final Object b(c0.g gVar) {
        Object fold = gVar.fold(0, f802b);
        kotlin.jvm.internal.i.b(fold);
        return fold;
    }

    public static final Object c(c0.g gVar, Object obj) {
        if (obj == null) {
            obj = b(gVar);
        }
        return obj == 0 ? f801a : obj instanceof Integer ? gVar.fold(new f0(gVar, ((Number) obj).intValue()), f804d) : ((z1) obj).n(gVar);
    }
}
