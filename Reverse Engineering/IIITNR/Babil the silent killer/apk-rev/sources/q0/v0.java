package q0;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public abstract class v0 extends w0 {

    /* renamed from: h, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f1070h = AtomicReferenceFieldUpdater.newUpdater(v0.class, Object.class, "_queue");

    /* renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f1071i = AtomicReferenceFieldUpdater.newUpdater(v0.class, Object.class, "_delayed");
    private volatile /* synthetic */ Object _queue = null;
    private volatile /* synthetic */ Object _delayed = null;
    private volatile /* synthetic */ int _isCompleted = 0;

    public static abstract class a implements Runnable, Comparable<a>, s0, kotlinx.coroutines.internal.e0 {

        /* renamed from: d, reason: collision with root package name */
        public long f1072d;

        /* renamed from: e, reason: collision with root package name */
        private Object f1073e;

        /* renamed from: f, reason: collision with root package name */
        private int f1074f;

        @Override // kotlinx.coroutines.internal.e0
        public kotlinx.coroutines.internal.d0<?> a() {
            Object obj = this.f1073e;
            if (obj instanceof kotlinx.coroutines.internal.d0) {
                return (kotlinx.coroutines.internal.d0) obj;
            }
            return null;
        }

        @Override // q0.s0
        public final synchronized void b() {
            kotlinx.coroutines.internal.y yVar;
            kotlinx.coroutines.internal.y yVar2;
            Object obj = this.f1073e;
            yVar = y0.f1084a;
            if (obj == yVar) {
                return;
            }
            b bVar = obj instanceof b ? (b) obj : null;
            if (bVar != null) {
                bVar.g(this);
            }
            yVar2 = y0.f1084a;
            this.f1073e = yVar2;
        }

        @Override // kotlinx.coroutines.internal.e0
        public void c(int i2) {
            this.f1074f = i2;
        }

        @Override // kotlinx.coroutines.internal.e0
        public void d(kotlinx.coroutines.internal.d0<?> d0Var) {
            kotlinx.coroutines.internal.y yVar;
            Object obj = this.f1073e;
            yVar = y0.f1084a;
            if (!(obj != yVar)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            this.f1073e = d0Var;
        }

        @Override // kotlinx.coroutines.internal.e0
        public int e() {
            return this.f1074f;
        }

        @Override // java.lang.Comparable
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            long j2 = this.f1072d - aVar.f1072d;
            if (j2 > 0) {
                return 1;
            }
            return j2 < 0 ? -1 : 0;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0040 A[Catch: all -> 0x0048, TryCatch #0 {, blocks: (B:11:0x000d, B:19:0x0021, B:20:0x0037, B:22:0x0040, B:23:0x0042, B:27:0x0024, B:30:0x002e), top: B:10:0x000d, outer: #1 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final synchronized int h(long r8, q0.v0.b r10, q0.v0 r11) {
            /*
                r7 = this;
                monitor-enter(r7)
                java.lang.Object r0 = r7.f1073e     // Catch: java.lang.Throwable -> L4b
                kotlinx.coroutines.internal.y r1 = q0.y0.b()     // Catch: java.lang.Throwable -> L4b
                if (r0 != r1) goto Lc
                r8 = 2
            La:
                monitor-exit(r7)
                return r8
            Lc:
                monitor-enter(r10)     // Catch: java.lang.Throwable -> L4b
                kotlinx.coroutines.internal.e0 r0 = r10.b()     // Catch: java.lang.Throwable -> L48
                q0.v0$a r0 = (q0.v0.a) r0     // Catch: java.lang.Throwable -> L48
                boolean r11 = q0.v0.D(r11)     // Catch: java.lang.Throwable -> L48
                if (r11 == 0) goto L1d
                r8 = 1
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L4b
                monitor-exit(r7)
                return r8
            L1d:
                r1 = 0
                if (r0 != 0) goto L24
            L21:
                r10.f1075b = r8     // Catch: java.lang.Throwable -> L48
                goto L37
            L24:
                long r3 = r0.f1072d     // Catch: java.lang.Throwable -> L48
                long r5 = r3 - r8
                int r11 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
                if (r11 < 0) goto L2d
                goto L2e
            L2d:
                r8 = r3
            L2e:
                long r3 = r10.f1075b     // Catch: java.lang.Throwable -> L48
                long r3 = r8 - r3
                int r11 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
                if (r11 <= 0) goto L37
                goto L21
            L37:
                long r8 = r7.f1072d     // Catch: java.lang.Throwable -> L48
                long r3 = r10.f1075b     // Catch: java.lang.Throwable -> L48
                long r8 = r8 - r3
                int r11 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
                if (r11 >= 0) goto L42
                r7.f1072d = r3     // Catch: java.lang.Throwable -> L48
            L42:
                r10.a(r7)     // Catch: java.lang.Throwable -> L48
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L4b
                r8 = 0
                goto La
            L48:
                r8 = move-exception
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L4b
                throw r8     // Catch: java.lang.Throwable -> L4b
            L4b:
                r8 = move-exception
                monitor-exit(r7)
                goto L4f
            L4e:
                throw r8
            L4f:
                goto L4e
            */
            throw new UnsupportedOperationException("Method not decompiled: q0.v0.a.h(long, q0.v0$b, q0.v0):int");
        }

        public final boolean i(long j2) {
            return j2 - this.f1072d >= 0;
        }

        public String toString() {
            return "Delayed[nanos=" + this.f1072d + ']';
        }
    }

    public static final class b extends kotlinx.coroutines.internal.d0<a> {

        /* renamed from: b, reason: collision with root package name */
        public long f1075b;

        public b(long j2) {
            this.f1075b = j2;
        }
    }

    private final void E() {
        kotlinx.coroutines.internal.y yVar;
        kotlinx.coroutines.internal.y yVar2;
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1070h;
                yVar = y0.f1085b;
                if (kotlinx.coroutines.internal.c.a(atomicReferenceFieldUpdater, this, null, yVar)) {
                    return;
                }
            } else {
                if (obj instanceof kotlinx.coroutines.internal.p) {
                    ((kotlinx.coroutines.internal.p) obj).d();
                    return;
                }
                yVar2 = y0.f1085b;
                if (obj == yVar2) {
                    return;
                }
                kotlinx.coroutines.internal.p pVar = new kotlinx.coroutines.internal.p(8, true);
                pVar.a((Runnable) obj);
                if (kotlinx.coroutines.internal.c.a(f1070h, this, obj, pVar)) {
                    return;
                }
            }
        }
    }

    private final Runnable F() {
        kotlinx.coroutines.internal.y yVar;
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                return null;
            }
            if (obj instanceof kotlinx.coroutines.internal.p) {
                kotlinx.coroutines.internal.p pVar = (kotlinx.coroutines.internal.p) obj;
                Object j2 = pVar.j();
                if (j2 != kotlinx.coroutines.internal.p.f836h) {
                    return (Runnable) j2;
                }
                kotlinx.coroutines.internal.c.a(f1070h, this, obj, pVar.i());
            } else {
                yVar = y0.f1085b;
                if (obj == yVar) {
                    return null;
                }
                if (kotlinx.coroutines.internal.c.a(f1070h, this, obj, null)) {
                    return (Runnable) obj;
                }
            }
        }
    }

    private final boolean H(Runnable runnable) {
        kotlinx.coroutines.internal.y yVar;
        while (true) {
            Object obj = this._queue;
            if (I()) {
                return false;
            }
            if (obj == null) {
                if (kotlinx.coroutines.internal.c.a(f1070h, this, null, runnable)) {
                    return true;
                }
            } else if (obj instanceof kotlinx.coroutines.internal.p) {
                kotlinx.coroutines.internal.p pVar = (kotlinx.coroutines.internal.p) obj;
                int a2 = pVar.a(runnable);
                if (a2 == 0) {
                    return true;
                }
                if (a2 == 1) {
                    kotlinx.coroutines.internal.c.a(f1070h, this, obj, pVar.i());
                } else if (a2 == 2) {
                    return false;
                }
            } else {
                yVar = y0.f1085b;
                if (obj == yVar) {
                    return false;
                }
                kotlinx.coroutines.internal.p pVar2 = new kotlinx.coroutines.internal.p(8, true);
                pVar2.a((Runnable) obj);
                pVar2.a(runnable);
                if (kotlinx.coroutines.internal.c.a(f1070h, this, obj, pVar2)) {
                    return true;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean I() {
        return this._isCompleted;
    }

    private final void L() {
        c.a();
        long nanoTime = System.nanoTime();
        while (true) {
            b bVar = (b) this._delayed;
            a i2 = bVar == null ? null : bVar.i();
            if (i2 == null) {
                return;
            } else {
                B(nanoTime, i2);
            }
        }
    }

    private final int O(long j2, a aVar) {
        if (I()) {
            return 1;
        }
        b bVar = (b) this._delayed;
        if (bVar == null) {
            kotlinx.coroutines.internal.c.a(f1071i, this, null, new b(j2));
            Object obj = this._delayed;
            kotlin.jvm.internal.i.b(obj);
            bVar = (b) obj;
        }
        return aVar.h(j2, bVar, this);
    }

    private final void P(boolean z2) {
        this._isCompleted = z2 ? 1 : 0;
    }

    private final boolean Q(a aVar) {
        b bVar = (b) this._delayed;
        return (bVar == null ? null : bVar.e()) == aVar;
    }

    public final void G(Runnable runnable) {
        if (H(runnable)) {
            C();
        } else {
            m0.f1030j.G(runnable);
        }
    }

    protected boolean J() {
        kotlinx.coroutines.internal.y yVar;
        if (!x()) {
            return false;
        }
        b bVar = (b) this._delayed;
        if (bVar != null && !bVar.d()) {
            return false;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (obj instanceof kotlinx.coroutines.internal.p) {
                return ((kotlinx.coroutines.internal.p) obj).g();
            }
            yVar = y0.f1085b;
            if (obj != yVar) {
                return false;
            }
        }
        return true;
    }

    public long K() {
        a aVar;
        if (y()) {
            return 0L;
        }
        b bVar = (b) this._delayed;
        if (bVar != null && !bVar.d()) {
            c.a();
            long nanoTime = System.nanoTime();
            do {
                synchronized (bVar) {
                    a b2 = bVar.b();
                    aVar = null;
                    if (b2 != null) {
                        a aVar2 = b2;
                        if (aVar2.i(nanoTime) ? H(aVar2) : false) {
                            aVar = bVar.h(0);
                        }
                    }
                }
            } while (aVar != null);
        }
        Runnable F = F();
        if (F == null) {
            return t();
        }
        F.run();
        return 0L;
    }

    protected final void M() {
        this._queue = null;
        this._delayed = null;
    }

    public final void N(long j2, a aVar) {
        int O = O(j2, aVar);
        if (O == 0) {
            if (Q(aVar)) {
                C();
            }
        } else if (O == 1) {
            B(j2, aVar);
        } else if (O != 2) {
            throw new IllegalStateException("unexpected result".toString());
        }
    }

    @Override // q0.e0
    public final void k(c0.g gVar, Runnable runnable) {
        G(runnable);
    }

    @Override // q0.u0
    protected long t() {
        long b2;
        kotlinx.coroutines.internal.y yVar;
        if (super.t() == 0) {
            return 0L;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (!(obj instanceof kotlinx.coroutines.internal.p)) {
                yVar = y0.f1085b;
                return obj == yVar ? Long.MAX_VALUE : 0L;
            }
            if (!((kotlinx.coroutines.internal.p) obj).g()) {
                return 0L;
            }
        }
        b bVar = (b) this._delayed;
        a e2 = bVar == null ? null : bVar.e();
        if (e2 == null) {
            return Long.MAX_VALUE;
        }
        long j2 = e2.f1072d;
        c.a();
        b2 = m0.f.b(j2 - System.nanoTime(), 0L);
        return b2;
    }

    @Override // q0.u0
    protected void z() {
        a2.f994a.b();
        P(true);
        E();
        while (K() <= 0) {
        }
        L();
    }
}
