package q0;

/* loaded from: classes.dex */
public final class c2<T> extends kotlinx.coroutines.internal.w<T> {

    /* renamed from: g, reason: collision with root package name */
    private c0.g f998g;

    /* renamed from: h, reason: collision with root package name */
    private Object f999h;

    @Override // kotlinx.coroutines.internal.w, q0.a
    protected void t0(Object obj) {
        c0.g gVar = this.f998g;
        if (gVar != null) {
            kotlinx.coroutines.internal.c0.a(gVar, this.f999h);
            this.f998g = null;
            this.f999h = null;
        }
        Object a2 = c0.a(obj, this.f852f);
        c0.d<T> dVar = this.f852f;
        c0.g context = dVar.getContext();
        Object c2 = kotlinx.coroutines.internal.c0.c(context, null);
        c2<?> e2 = c2 != kotlinx.coroutines.internal.c0.f801a ? d0.e(dVar, context, c2) : null;
        try {
            this.f852f.resumeWith(a2);
            a0.q qVar = a0.q.f22a;
        } finally {
            if (e2 == null || e2.y0()) {
                kotlinx.coroutines.internal.c0.a(context, c2);
            }
        }
    }

    public final boolean y0() {
        if (this.f998g == null) {
            return false;
        }
        this.f998g = null;
        this.f999h = null;
        return true;
    }

    public final void z0(c0.g gVar, Object obj) {
        this.f998g = gVar;
        this.f999h = obj;
    }
}
