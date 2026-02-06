package kotlinx.coroutines.internal;

import q0.j1;

/* loaded from: classes.dex */
public class w<T> extends q0.a<T> implements kotlin.coroutines.jvm.internal.e {

    /* renamed from: f, reason: collision with root package name */
    public final c0.d<T> f852f;

    @Override // q0.q1
    protected final boolean U() {
        return true;
    }

    @Override // kotlin.coroutines.jvm.internal.e
    public final kotlin.coroutines.jvm.internal.e getCallerFrame() {
        c0.d<T> dVar = this.f852f;
        if (dVar instanceof kotlin.coroutines.jvm.internal.e) {
            return (kotlin.coroutines.jvm.internal.e) dVar;
        }
        return null;
    }

    @Override // q0.a
    protected void t0(Object obj) {
        c0.d<T> dVar = this.f852f;
        dVar.resumeWith(q0.c0.a(obj, dVar));
    }

    @Override // q0.q1
    protected void x(Object obj) {
        c0.d b2;
        b2 = d0.c.b(this.f852f);
        h.c(b2, q0.c0.a(obj, this.f852f), null, 2, null);
    }

    public final j1 x0() {
        q0.q O = O();
        if (O == null) {
            return null;
        }
        return O.getParent();
    }
}
