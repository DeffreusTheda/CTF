package q0;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: classes.dex */
public final class n0<T> extends kotlinx.coroutines.internal.w<T> {

    /* renamed from: g, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f1033g = AtomicIntegerFieldUpdater.newUpdater(n0.class, "_decision");
    private volatile /* synthetic */ int _decision;

    private final boolean y0() {
        do {
            int i2 = this._decision;
            if (i2 != 0) {
                if (i2 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f1033g.compareAndSet(this, 0, 2));
        return true;
    }

    @Override // kotlinx.coroutines.internal.w, q0.a
    protected void t0(Object obj) {
        c0.d b2;
        if (y0()) {
            return;
        }
        b2 = d0.c.b(this.f852f);
        kotlinx.coroutines.internal.h.c(b2, c0.a(obj, this.f852f), null, 2, null);
    }

    @Override // kotlinx.coroutines.internal.w, q0.q1
    protected void x(Object obj) {
        t0(obj);
    }
}
