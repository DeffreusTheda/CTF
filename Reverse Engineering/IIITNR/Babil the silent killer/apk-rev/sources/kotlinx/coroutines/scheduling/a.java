package kotlinx.coroutines.scheduling;

import a0.q;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.LockSupport;
import kotlinx.coroutines.internal.y;
import q0.l0;

/* loaded from: classes.dex */
public final class a implements Executor, Closeable {
    private volatile /* synthetic */ int _isTerminated;
    volatile /* synthetic */ long controlState;

    /* renamed from: d, reason: collision with root package name */
    public final int f861d;

    /* renamed from: e, reason: collision with root package name */
    public final int f862e;

    /* renamed from: f, reason: collision with root package name */
    public final long f863f;

    /* renamed from: g, reason: collision with root package name */
    public final String f864g;

    /* renamed from: h, reason: collision with root package name */
    public final kotlinx.coroutines.scheduling.d f865h;

    /* renamed from: i, reason: collision with root package name */
    public final kotlinx.coroutines.scheduling.d f866i;

    /* renamed from: j, reason: collision with root package name */
    public final AtomicReferenceArray<c> f867j;
    private volatile /* synthetic */ long parkedWorkersStack;

    /* renamed from: k, reason: collision with root package name */
    public static final C0020a f856k = new C0020a(null);

    /* renamed from: o, reason: collision with root package name */
    public static final y f860o = new y("NOT_IN_STACK");

    /* renamed from: l, reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f857l = AtomicLongFieldUpdater.newUpdater(a.class, "parkedWorkersStack");

    /* renamed from: m, reason: collision with root package name */
    static final /* synthetic */ AtomicLongFieldUpdater f858m = AtomicLongFieldUpdater.newUpdater(a.class, "controlState");

    /* renamed from: n, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f859n = AtomicIntegerFieldUpdater.newUpdater(a.class, "_isTerminated");

    /* renamed from: kotlinx.coroutines.scheduling.a$a, reason: collision with other inner class name */
    public static final class C0020a {
        private C0020a() {
        }

        public /* synthetic */ C0020a(kotlin.jvm.internal.e eVar) {
            this();
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f868a;

        static {
            int[] iArr = new int[d.values().length];
            iArr[d.PARKING.ordinal()] = 1;
            iArr[d.BLOCKING.ordinal()] = 2;
            iArr[d.CPU_ACQUIRED.ordinal()] = 3;
            iArr[d.DORMANT.ordinal()] = 4;
            iArr[d.TERMINATED.ordinal()] = 5;
            f868a = iArr;
        }
    }

    public final class c extends Thread {

        /* renamed from: k, reason: collision with root package name */
        static final /* synthetic */ AtomicIntegerFieldUpdater f869k = AtomicIntegerFieldUpdater.newUpdater(c.class, "workerCtl");

        /* renamed from: d, reason: collision with root package name */
        public final m f870d;

        /* renamed from: e, reason: collision with root package name */
        public d f871e;

        /* renamed from: f, reason: collision with root package name */
        private long f872f;

        /* renamed from: g, reason: collision with root package name */
        private long f873g;

        /* renamed from: h, reason: collision with root package name */
        private int f874h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f875i;
        private volatile int indexInArray;
        private volatile Object nextParkedWorker;
        volatile /* synthetic */ int workerCtl;

        private c() {
            setDaemon(true);
            this.f870d = new m();
            this.f871e = d.DORMANT;
            this.workerCtl = 0;
            this.nextParkedWorker = a.f860o;
            this.f874h = k0.c.f771d.b();
        }

        public c(int i2) {
            this();
            n(i2);
        }

        private final void a(int i2) {
            if (i2 == 0) {
                return;
            }
            a.f858m.addAndGet(a.this, -2097152L);
            if (this.f871e != d.TERMINATED) {
                this.f871e = d.DORMANT;
            }
        }

        private final void b(int i2) {
            if (i2 != 0 && r(d.BLOCKING)) {
                a.this.o();
            }
        }

        private final void c(i iVar) {
            int e2 = iVar.f900e.e();
            h(e2);
            b(e2);
            a.this.l(iVar);
            a(e2);
        }

        private final i d(boolean z2) {
            i l2;
            i l3;
            if (z2) {
                boolean z3 = j(a.this.f861d * 2) == 0;
                if (z3 && (l3 = l()) != null) {
                    return l3;
                }
                i h2 = this.f870d.h();
                if (h2 != null) {
                    return h2;
                }
                if (!z3 && (l2 = l()) != null) {
                    return l2;
                }
            } else {
                i l4 = l();
                if (l4 != null) {
                    return l4;
                }
            }
            return s(false);
        }

        private final void h(int i2) {
            this.f872f = 0L;
            if (this.f871e == d.PARKING) {
                this.f871e = d.BLOCKING;
            }
        }

        private final boolean i() {
            return this.nextParkedWorker != a.f860o;
        }

        private final void k() {
            if (this.f872f == 0) {
                this.f872f = System.nanoTime() + a.this.f863f;
            }
            LockSupport.parkNanos(a.this.f863f);
            if (System.nanoTime() - this.f872f >= 0) {
                this.f872f = 0L;
                t();
            }
        }

        private final i l() {
            kotlinx.coroutines.scheduling.d dVar;
            if (j(2) == 0) {
                i d2 = a.this.f865h.d();
                if (d2 != null) {
                    return d2;
                }
                dVar = a.this.f866i;
            } else {
                i d3 = a.this.f866i.d();
                if (d3 != null) {
                    return d3;
                }
                dVar = a.this.f865h;
            }
            return dVar.d();
        }

        private final void m() {
            loop0: while (true) {
                boolean z2 = false;
                while (!a.this.g() && this.f871e != d.TERMINATED) {
                    i e2 = e(this.f875i);
                    if (e2 != null) {
                        this.f873g = 0L;
                        c(e2);
                    } else {
                        this.f875i = false;
                        if (this.f873g == 0) {
                            q();
                        } else if (z2) {
                            r(d.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.f873g);
                            this.f873g = 0L;
                        } else {
                            z2 = true;
                        }
                    }
                }
            }
            r(d.TERMINATED);
        }

        private final boolean p() {
            boolean z2;
            if (this.f871e != d.CPU_ACQUIRED) {
                a aVar = a.this;
                while (true) {
                    long j2 = aVar.controlState;
                    if (((int) ((9223367638808264704L & j2) >> 42)) == 0) {
                        z2 = false;
                        break;
                    }
                    if (a.f858m.compareAndSet(aVar, j2, j2 - 4398046511104L)) {
                        z2 = true;
                        break;
                    }
                }
                if (!z2) {
                    return false;
                }
                this.f871e = d.CPU_ACQUIRED;
            }
            return true;
        }

        private final void q() {
            if (!i()) {
                a.this.j(this);
                return;
            }
            this.workerCtl = -1;
            while (i() && this.workerCtl == -1 && !a.this.g() && this.f871e != d.TERMINATED) {
                r(d.PARKING);
                Thread.interrupted();
                k();
            }
        }

        private final i s(boolean z2) {
            int i2 = (int) (a.this.controlState & 2097151);
            if (i2 < 2) {
                return null;
            }
            int j2 = j(i2);
            a aVar = a.this;
            long j3 = Long.MAX_VALUE;
            for (int i3 = 0; i3 < i2; i3++) {
                j2++;
                if (j2 > i2) {
                    j2 = 1;
                }
                c cVar = aVar.f867j.get(j2);
                if (cVar != null && cVar != this) {
                    m mVar = this.f870d;
                    m mVar2 = cVar.f870d;
                    long k2 = z2 ? mVar.k(mVar2) : mVar.l(mVar2);
                    if (k2 == -1) {
                        return this.f870d.h();
                    }
                    if (k2 > 0) {
                        j3 = Math.min(j3, k2);
                    }
                }
            }
            if (j3 == Long.MAX_VALUE) {
                j3 = 0;
            }
            this.f873g = j3;
            return null;
        }

        private final void t() {
            a aVar = a.this;
            synchronized (aVar.f867j) {
                if (aVar.g()) {
                    return;
                }
                if (((int) (aVar.controlState & 2097151)) <= aVar.f861d) {
                    return;
                }
                if (f869k.compareAndSet(this, -1, 1)) {
                    int f2 = f();
                    n(0);
                    aVar.k(this, f2, 0);
                    int andDecrement = (int) (2097151 & a.f858m.getAndDecrement(aVar));
                    if (andDecrement != f2) {
                        c cVar = aVar.f867j.get(andDecrement);
                        kotlin.jvm.internal.i.b(cVar);
                        c cVar2 = cVar;
                        aVar.f867j.set(f2, cVar2);
                        cVar2.n(f2);
                        aVar.k(cVar2, andDecrement, f2);
                    }
                    aVar.f867j.set(andDecrement, null);
                    q qVar = q.f22a;
                    this.f871e = d.TERMINATED;
                }
            }
        }

        public final i e(boolean z2) {
            i d2;
            if (p()) {
                return d(z2);
            }
            if (!z2 || (d2 = this.f870d.h()) == null) {
                d2 = a.this.f866i.d();
            }
            return d2 == null ? s(true) : d2;
        }

        public final int f() {
            return this.indexInArray;
        }

        public final Object g() {
            return this.nextParkedWorker;
        }

        public final int j(int i2) {
            int i3 = this.f874h;
            int i4 = i3 ^ (i3 << 13);
            int i5 = i4 ^ (i4 >> 17);
            int i6 = i5 ^ (i5 << 5);
            this.f874h = i6;
            int i7 = i2 - 1;
            return (i7 & i2) == 0 ? i6 & i7 : (i6 & Integer.MAX_VALUE) % i2;
        }

        public final void n(int i2) {
            StringBuilder sb = new StringBuilder();
            sb.append(a.this.f864g);
            sb.append("-worker-");
            sb.append(i2 == 0 ? "TERMINATED" : String.valueOf(i2));
            setName(sb.toString());
            this.indexInArray = i2;
        }

        public final void o(Object obj) {
            this.nextParkedWorker = obj;
        }

        public final boolean r(d dVar) {
            d dVar2 = this.f871e;
            boolean z2 = dVar2 == d.CPU_ACQUIRED;
            if (z2) {
                a.f858m.addAndGet(a.this, 4398046511104L);
            }
            if (dVar2 != dVar) {
                this.f871e = dVar;
            }
            return z2;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            m();
        }
    }

    public enum d {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    public a(int i2, int i3, long j2, String str) {
        this.f861d = i2;
        this.f862e = i3;
        this.f863f = j2;
        this.f864g = str;
        if (!(i2 >= 1)) {
            throw new IllegalArgumentException(("Core pool size " + i2 + " should be at least 1").toString());
        }
        if (!(i3 >= i2)) {
            throw new IllegalArgumentException(("Max pool size " + i3 + " should be greater than or equals to core pool size " + i2).toString());
        }
        if (!(i3 <= 2097150)) {
            throw new IllegalArgumentException(("Max pool size " + i3 + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (!(j2 > 0)) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j2 + " must be positive").toString());
        }
        this.f865h = new kotlinx.coroutines.scheduling.d();
        this.f866i = new kotlinx.coroutines.scheduling.d();
        this.parkedWorkersStack = 0L;
        this.f867j = new AtomicReferenceArray<>(i3 + 1);
        this.controlState = i2 << 42;
        this._isTerminated = 0;
    }

    private final boolean a(i iVar) {
        return (iVar.f900e.e() == 1 ? this.f866i : this.f865h).a(iVar);
    }

    private final int b() {
        int a2;
        int i2;
        synchronized (this.f867j) {
            if (g()) {
                i2 = -1;
            } else {
                long j2 = this.controlState;
                int i3 = (int) (j2 & 2097151);
                a2 = m0.f.a(i3 - ((int) ((j2 & 4398044413952L) >> 21)), 0);
                if (a2 >= this.f861d) {
                    return 0;
                }
                if (i3 >= this.f862e) {
                    return 0;
                }
                int i4 = ((int) (this.controlState & 2097151)) + 1;
                if (!(i4 > 0 && this.f867j.get(i4) == null)) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                c cVar = new c(i4);
                this.f867j.set(i4, cVar);
                if (!(i4 == ((int) (2097151 & f858m.incrementAndGet(this))))) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                cVar.start();
                i2 = a2 + 1;
            }
            return i2;
        }
    }

    private final c d() {
        Thread currentThread = Thread.currentThread();
        c cVar = currentThread instanceof c ? (c) currentThread : null;
        if (cVar != null && kotlin.jvm.internal.i.a(a.this, this)) {
            return cVar;
        }
        return null;
    }

    public static /* synthetic */ void f(a aVar, Runnable runnable, j jVar, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            jVar = g.f897d;
        }
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        aVar.e(runnable, jVar, z2);
    }

    private final int h(c cVar) {
        int f2;
        do {
            Object g2 = cVar.g();
            if (g2 == f860o) {
                return -1;
            }
            if (g2 == null) {
                return 0;
            }
            cVar = (c) g2;
            f2 = cVar.f();
        } while (f2 == 0);
        return f2;
    }

    private final c i() {
        while (true) {
            long j2 = this.parkedWorkersStack;
            c cVar = this.f867j.get((int) (2097151 & j2));
            if (cVar == null) {
                return null;
            }
            long j3 = (2097152 + j2) & (-2097152);
            int h2 = h(cVar);
            if (h2 >= 0 && f857l.compareAndSet(this, j2, h2 | j3)) {
                cVar.o(f860o);
                return cVar;
            }
        }
    }

    private final void n(boolean z2) {
        long addAndGet = f858m.addAndGet(this, 2097152L);
        if (z2 || s() || q(addAndGet)) {
            return;
        }
        s();
    }

    private final i p(c cVar, i iVar, boolean z2) {
        if (cVar == null || cVar.f871e == d.TERMINATED) {
            return iVar;
        }
        if (iVar.f900e.e() == 0 && cVar.f871e == d.BLOCKING) {
            return iVar;
        }
        cVar.f875i = true;
        return cVar.f870d.a(iVar, z2);
    }

    private final boolean q(long j2) {
        int a2;
        a2 = m0.f.a(((int) (2097151 & j2)) - ((int) ((j2 & 4398044413952L) >> 21)), 0);
        if (a2 < this.f861d) {
            int b2 = b();
            if (b2 == 1 && this.f861d > 1) {
                b();
            }
            if (b2 > 0) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ boolean r(a aVar, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = aVar.controlState;
        }
        return aVar.q(j2);
    }

    private final boolean s() {
        c i2;
        do {
            i2 = i();
            if (i2 == null) {
                return false;
            }
        } while (!c.f869k.compareAndSet(i2, -1, 0));
        LockSupport.unpark(i2);
        return true;
    }

    public final i c(Runnable runnable, j jVar) {
        long a2 = l.f907f.a();
        if (!(runnable instanceof i)) {
            return new k(runnable, a2, jVar);
        }
        i iVar = (i) runnable;
        iVar.f899d = a2;
        iVar.f900e = jVar;
        return iVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        m(10000L);
    }

    public final void e(Runnable runnable, j jVar, boolean z2) {
        q0.c.a();
        i c2 = c(runnable, jVar);
        c d2 = d();
        i p2 = p(d2, c2, z2);
        if (p2 != null && !a(p2)) {
            throw new RejectedExecutionException(kotlin.jvm.internal.i.j(this.f864g, " was terminated"));
        }
        boolean z3 = z2 && d2 != null;
        if (c2.f900e.e() != 0) {
            n(z3);
        } else {
            if (z3) {
                return;
            }
            o();
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        f(this, runnable, null, false, 6, null);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean g() {
        return this._isTerminated;
    }

    public final boolean j(c cVar) {
        long j2;
        int f2;
        if (cVar.g() != f860o) {
            return false;
        }
        do {
            j2 = this.parkedWorkersStack;
            f2 = cVar.f();
            cVar.o(this.f867j.get((int) (2097151 & j2)));
        } while (!f857l.compareAndSet(this, j2, ((2097152 + j2) & (-2097152)) | f2));
        return true;
    }

    public final void k(c cVar, int i2, int i3) {
        while (true) {
            long j2 = this.parkedWorkersStack;
            int i4 = (int) (2097151 & j2);
            long j3 = (2097152 + j2) & (-2097152);
            if (i4 == i2) {
                i4 = i3 == 0 ? h(cVar) : i3;
            }
            if (i4 >= 0 && f857l.compareAndSet(this, j2, j3 | i4)) {
                return;
            }
        }
    }

    public final void l(i iVar) {
        try {
            iVar.run();
        } finally {
            try {
            } finally {
            }
        }
    }

    public final void m(long j2) {
        int i2;
        if (f859n.compareAndSet(this, 0, 1)) {
            c d2 = d();
            synchronized (this.f867j) {
                i2 = (int) (this.controlState & 2097151);
            }
            if (1 <= i2) {
                int i3 = 1;
                while (true) {
                    int i4 = i3 + 1;
                    c cVar = this.f867j.get(i3);
                    kotlin.jvm.internal.i.b(cVar);
                    c cVar2 = cVar;
                    if (cVar2 != d2) {
                        while (cVar2.isAlive()) {
                            LockSupport.unpark(cVar2);
                            cVar2.join(j2);
                        }
                        cVar2.f870d.g(this.f866i);
                    }
                    if (i3 == i2) {
                        break;
                    } else {
                        i3 = i4;
                    }
                }
            }
            this.f866i.b();
            this.f865h.b();
            while (true) {
                i e2 = d2 == null ? null : d2.e(true);
                if (e2 == null && (e2 = this.f865h.d()) == null && (e2 = this.f866i.d()) == null) {
                    break;
                } else {
                    l(e2);
                }
            }
            if (d2 != null) {
                d2.r(d.TERMINATED);
            }
            this.parkedWorkersStack = 0L;
            this.controlState = 0L;
        }
    }

    public final void o() {
        if (s() || r(this, 0L, 1, null)) {
            return;
        }
        s();
    }

    public String toString() {
        int i2;
        int i3;
        int i4;
        int i5;
        StringBuilder sb;
        char c2;
        ArrayList arrayList = new ArrayList();
        int length = this.f867j.length();
        int i6 = 0;
        if (1 < length) {
            i3 = 0;
            int i7 = 0;
            i4 = 0;
            i5 = 0;
            int i8 = 1;
            while (true) {
                int i9 = i8 + 1;
                c cVar = this.f867j.get(i8);
                if (cVar != null) {
                    int f2 = cVar.f870d.f();
                    int i10 = b.f868a[cVar.f871e.ordinal()];
                    if (i10 != 1) {
                        if (i10 == 2) {
                            i3++;
                            sb = new StringBuilder();
                            sb.append(f2);
                            c2 = 'b';
                        } else if (i10 == 3) {
                            i7++;
                            sb = new StringBuilder();
                            sb.append(f2);
                            c2 = 'c';
                        } else if (i10 == 4) {
                            i4++;
                            if (f2 > 0) {
                                sb = new StringBuilder();
                                sb.append(f2);
                                c2 = 'd';
                            }
                        } else if (i10 == 5) {
                            i5++;
                        }
                        sb.append(c2);
                        arrayList.add(sb.toString());
                    } else {
                        i6++;
                    }
                }
                if (i9 >= length) {
                    break;
                }
                i8 = i9;
            }
            i2 = i6;
            i6 = i7;
        } else {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
        }
        long j2 = this.controlState;
        return this.f864g + '@' + l0.b(this) + "[Pool Size {core = " + this.f861d + ", max = " + this.f862e + "}, Worker States {CPU = " + i6 + ", blocking = " + i3 + ", parked = " + i2 + ", dormant = " + i4 + ", terminated = " + i5 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.f865h.c() + ", global blocking queue size = " + this.f866i.c() + ", Control State {created workers= " + ((int) (2097151 & j2)) + ", blocking tasks = " + ((int) ((4398044413952L & j2) >> 21)) + ", CPUs acquired = " + (this.f861d - ((int) ((9223367638808264704L & j2) >> 42))) + "}]";
    }
}
