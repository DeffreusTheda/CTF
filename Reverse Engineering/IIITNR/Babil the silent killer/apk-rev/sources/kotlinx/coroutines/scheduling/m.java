package kotlinx.coroutines.scheduling;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f908b = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "lastScheduledTask");

    /* renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f909c = AtomicIntegerFieldUpdater.newUpdater(m.class, "producerIndex");

    /* renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f910d = AtomicIntegerFieldUpdater.newUpdater(m.class, "consumerIndex");

    /* renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f911e = AtomicIntegerFieldUpdater.newUpdater(m.class, "blockingTasksInBuffer");

    /* renamed from: a, reason: collision with root package name */
    private final AtomicReferenceArray<i> f912a = new AtomicReferenceArray<>(128);
    private volatile /* synthetic */ Object lastScheduledTask = null;
    private volatile /* synthetic */ int producerIndex = 0;
    private volatile /* synthetic */ int consumerIndex = 0;
    private volatile /* synthetic */ int blockingTasksInBuffer = 0;

    public static /* synthetic */ i b(m mVar, i iVar, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        return mVar.a(iVar, z2);
    }

    private final i c(i iVar) {
        if (iVar.f900e.e() == 1) {
            f911e.incrementAndGet(this);
        }
        if (e() == 127) {
            return iVar;
        }
        int i2 = this.producerIndex & 127;
        while (this.f912a.get(i2) != null) {
            Thread.yield();
        }
        this.f912a.lazySet(i2, iVar);
        f909c.incrementAndGet(this);
        return null;
    }

    private final void d(i iVar) {
        if (iVar != null) {
            if (iVar.f900e.e() == 1) {
                f911e.decrementAndGet(this);
            }
        }
    }

    private final i i() {
        i andSet;
        while (true) {
            int i2 = this.consumerIndex;
            if (i2 - this.producerIndex == 0) {
                return null;
            }
            int i3 = i2 & 127;
            if (f910d.compareAndSet(this, i2, i2 + 1) && (andSet = this.f912a.getAndSet(i3, null)) != null) {
                d(andSet);
                return andSet;
            }
        }
    }

    private final boolean j(d dVar) {
        i i2 = i();
        if (i2 == null) {
            return false;
        }
        dVar.a(i2);
        return true;
    }

    private final long m(m mVar, boolean z2) {
        i iVar;
        do {
            iVar = (i) mVar.lastScheduledTask;
            if (iVar == null) {
                return -2L;
            }
            if (z2) {
                if (!(iVar.f900e.e() == 1)) {
                    return -2L;
                }
            }
            long a2 = l.f907f.a() - iVar.f899d;
            long j2 = l.f902a;
            if (a2 < j2) {
                return j2 - a2;
            }
        } while (!kotlinx.coroutines.internal.c.a(f908b, mVar, iVar, null));
        b(this, iVar, false, 2, null);
        return -1L;
    }

    public final i a(i iVar, boolean z2) {
        if (z2) {
            return c(iVar);
        }
        i iVar2 = (i) f908b.getAndSet(this, iVar);
        if (iVar2 == null) {
            return null;
        }
        return c(iVar2);
    }

    public final int e() {
        return this.producerIndex - this.consumerIndex;
    }

    public final int f() {
        return this.lastScheduledTask != null ? e() + 1 : e();
    }

    public final void g(d dVar) {
        i iVar = (i) f908b.getAndSet(this, null);
        if (iVar != null) {
            dVar.a(iVar);
        }
        while (j(dVar)) {
        }
    }

    public final i h() {
        i iVar = (i) f908b.getAndSet(this, null);
        return iVar == null ? i() : iVar;
    }

    public final long k(m mVar) {
        int i2 = mVar.consumerIndex;
        int i3 = mVar.producerIndex;
        AtomicReferenceArray<i> atomicReferenceArray = mVar.f912a;
        while (true) {
            if (i2 == i3) {
                break;
            }
            int i4 = i2 & 127;
            if (mVar.blockingTasksInBuffer == 0) {
                break;
            }
            i iVar = atomicReferenceArray.get(i4);
            if (iVar != null) {
                if ((iVar.f900e.e() == 1) && atomicReferenceArray.compareAndSet(i4, iVar, null)) {
                    f911e.decrementAndGet(mVar);
                    b(this, iVar, false, 2, null);
                    return -1L;
                }
            }
            i2++;
        }
        return m(mVar, true);
    }

    public final long l(m mVar) {
        i i2 = mVar.i();
        if (i2 == null) {
            return m(mVar, false);
        }
        b(this, i2, false, 2, null);
        return -1L;
    }
}
