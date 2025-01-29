package m0;

import h0.W;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: classes.dex */
public abstract class v extends d implements W {

    /* renamed from: d, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f1033d = AtomicIntegerFieldUpdater.newUpdater(v.class, "cleanedAndPointers");

    /* renamed from: c, reason: collision with root package name */
    public final long f1034c;
    private volatile int cleanedAndPointers;

    public v(long j2, j0.k kVar, int i2) {
        super(kVar);
        this.f1034c = j2;
        this.cleanedAndPointers = i2 << 16;
    }

    @Override // m0.d
    public final boolean c() {
        return f1033d.get(this) == f() && b() != null;
    }

    public final boolean e() {
        return f1033d.addAndGet(this, -65536) == f() && b() != null;
    }

    public abstract int f();

    public abstract void g(int i2, S.i iVar);

    public final void h() {
        if (f1033d.incrementAndGet(this) == j0.e.f887b) {
            d();
        }
    }

    public final boolean i() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i2;
        do {
            atomicIntegerFieldUpdater = f1033d;
            i2 = atomicIntegerFieldUpdater.get(this);
            if (i2 == f() && b() != null) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i2, 65536 + i2));
        return true;
    }
}
