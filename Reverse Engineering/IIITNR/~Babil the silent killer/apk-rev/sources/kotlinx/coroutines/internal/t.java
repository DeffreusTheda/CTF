package kotlinx.coroutines.internal;

/* loaded from: classes.dex */
public final class t {

    static final class a extends kotlin.jvm.internal.j implements j0.l<Throwable, a0.q> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ j0.l<E, a0.q> f848d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ E f849e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ c0.g f850f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(j0.l<? super E, a0.q> lVar, E e2, c0.g gVar) {
            super(1);
            this.f848d = lVar;
            this.f849e = e2;
            this.f850f = gVar;
        }

        public final void a(Throwable th) {
            t.b(this.f848d, this.f849e, this.f850f);
        }

        @Override // j0.l
        public /* bridge */ /* synthetic */ a0.q invoke(Throwable th) {
            a(th);
            return a0.q.f22a;
        }
    }

    public static final <E> j0.l<Throwable, a0.q> a(j0.l<? super E, a0.q> lVar, E e2, c0.g gVar) {
        return new a(lVar, e2, gVar);
    }

    public static final <E> void b(j0.l<? super E, a0.q> lVar, E e2, c0.g gVar) {
        g0 c2 = c(lVar, e2, null);
        if (c2 == null) {
            return;
        }
        q0.g0.a(gVar, c2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E> g0 c(j0.l<? super E, a0.q> lVar, E e2, g0 g0Var) {
        try {
            lVar.invoke(e2);
        } catch (Throwable th) {
            if (g0Var == null || g0Var.getCause() == th) {
                return new g0(kotlin.jvm.internal.i.j("Exception in undelivered element handler for ", e2), th);
            }
            a0.b.a(g0Var, th);
        }
        return g0Var;
    }

    public static /* synthetic */ g0 d(j0.l lVar, Object obj, g0 g0Var, int i2, Object obj2) {
        if ((i2 & 2) != 0) {
            g0Var = null;
        }
        return c(lVar, obj, g0Var);
    }
}
