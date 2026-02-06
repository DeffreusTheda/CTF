package q0;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: classes.dex */
final class h1 extends l1 {

    /* renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f1012i = AtomicIntegerFieldUpdater.newUpdater(h1.class, "_invoked");
    private volatile /* synthetic */ int _invoked = 0;

    /* renamed from: h, reason: collision with root package name */
    private final j0.l<Throwable, a0.q> f1013h;

    /* JADX WARN: Multi-variable type inference failed */
    public h1(j0.l<? super Throwable, a0.q> lVar) {
        this.f1013h = lVar;
    }

    @Override // j0.l
    public /* bridge */ /* synthetic */ a0.q invoke(Throwable th) {
        y(th);
        return a0.q.f22a;
    }

    @Override // q0.a0
    public void y(Throwable th) {
        if (f1012i.compareAndSet(this, 0, 1)) {
            this.f1013h.invoke(th);
        }
    }
}
