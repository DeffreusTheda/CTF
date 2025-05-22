package kotlinx.coroutines.scheduling;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import q0.a1;

/* loaded from: classes.dex */
final class e extends a1 implements j, Executor {

    /* renamed from: k, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f890k = AtomicIntegerFieldUpdater.newUpdater(e.class, "inFlightTasks");

    /* renamed from: f, reason: collision with root package name */
    private final c f891f;

    /* renamed from: g, reason: collision with root package name */
    private final int f892g;

    /* renamed from: h, reason: collision with root package name */
    private final String f893h;

    /* renamed from: i, reason: collision with root package name */
    private final int f894i;

    /* renamed from: j, reason: collision with root package name */
    private final ConcurrentLinkedQueue<Runnable> f895j = new ConcurrentLinkedQueue<>();
    private volatile /* synthetic */ int inFlightTasks = 0;

    public e(c cVar, int i2, String str, int i3) {
        this.f891f = cVar;
        this.f892g = i2;
        this.f893h = str;
        this.f894i = i3;
    }

    private final void p(Runnable runnable, boolean z2) {
        do {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f890k;
            if (atomicIntegerFieldUpdater.incrementAndGet(this) <= this.f892g) {
                this.f891f.r(runnable, this, z2);
                return;
            }
            this.f895j.add(runnable);
            if (atomicIntegerFieldUpdater.decrementAndGet(this) >= this.f892g) {
                return;
            } else {
                runnable = this.f895j.poll();
            }
        } while (runnable != null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Close cannot be invoked on LimitingBlockingDispatcher".toString());
    }

    @Override // kotlinx.coroutines.scheduling.j
    public int e() {
        return this.f894i;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        p(runnable, false);
    }

    @Override // kotlinx.coroutines.scheduling.j
    public void g() {
        Runnable poll = this.f895j.poll();
        if (poll != null) {
            this.f891f.r(poll, this, true);
            return;
        }
        f890k.decrementAndGet(this);
        Runnable poll2 = this.f895j.poll();
        if (poll2 == null) {
            return;
        }
        p(poll2, true);
    }

    @Override // q0.e0
    public void k(c0.g gVar, Runnable runnable) {
        p(runnable, false);
    }

    @Override // q0.e0
    public String toString() {
        String str = this.f893h;
        if (str != null) {
            return str;
        }
        return super.toString() + "[dispatcher = " + this.f891f + ']';
    }
}
