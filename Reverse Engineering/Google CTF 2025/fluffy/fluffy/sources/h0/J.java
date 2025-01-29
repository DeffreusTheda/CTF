package h0;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: classes.dex */
public final class J extends M {

    /* renamed from: g, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f525g = AtomicIntegerFieldUpdater.newUpdater(J.class, "_invoked");
    private volatile int _invoked;

    /* renamed from: f, reason: collision with root package name */
    public final Z.l f526f;

    public J(Z.l lVar) {
        this.f526f = lVar;
    }

    @Override // Z.l
    public final /* bridge */ /* synthetic */ Object h(Object obj) {
        o((Throwable) obj);
        return Q.g.f327a;
    }

    @Override // h0.O
    public final void o(Throwable th) {
        if (f525g.compareAndSet(this, 0, 1)) {
            this.f526f.h(th);
        }
    }
}
