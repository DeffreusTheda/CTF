package m0;

import h0.AbstractC0056p;
import h0.AbstractC0061v;
import h0.InterfaceC0062w;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: classes.dex */
public final class j extends AbstractC0056p implements InterfaceC0062w {

    /* renamed from: h, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f1009h = AtomicIntegerFieldUpdater.newUpdater(j.class, "runningWorkers");

    /* renamed from: d, reason: collision with root package name */
    public final n0.k f1010d;

    /* renamed from: e, reason: collision with root package name */
    public final int f1011e;

    /* renamed from: f, reason: collision with root package name */
    public final m f1012f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f1013g;
    private volatile int runningWorkers;

    /* JADX WARN: Multi-variable type inference failed */
    public j(n0.k kVar, int i2) {
        this.f1010d = kVar;
        this.f1011e = i2;
        if ((kVar instanceof InterfaceC0062w ? (InterfaceC0062w) kVar : null) == null) {
            int i3 = AbstractC0061v.f587a;
        }
        this.f1012f = new m();
        this.f1013g = new Object();
    }

    @Override // h0.AbstractC0056p
    public final void c(S.i iVar, Runnable runnable) {
        this.f1012f.a(runnable);
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f1009h;
        if (atomicIntegerFieldUpdater.get(this) < this.f1011e) {
            synchronized (this.f1013g) {
                if (atomicIntegerFieldUpdater.get(this) >= this.f1011e) {
                    return;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
                Runnable i2 = i();
                if (i2 == null) {
                    return;
                }
                this.f1010d.c(this, new i(this, i2));
            }
        }
    }

    public final Runnable i() {
        while (true) {
            Runnable runnable = (Runnable) this.f1012f.d();
            if (runnable != null) {
                return runnable;
            }
            synchronized (this.f1013g) {
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f1009h;
                atomicIntegerFieldUpdater.decrementAndGet(this);
                if (this.f1012f.c() == 0) {
                    return null;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
            }
        }
    }
}
