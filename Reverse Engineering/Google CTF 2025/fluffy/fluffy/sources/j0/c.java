package j0;

import h0.C0045e;
import h0.InterfaceC0044d;
import h0.d0;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import m0.AbstractC0081a;
import m0.v;

/* loaded from: classes.dex */
public class c implements g {

    /* renamed from: d, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f874d = AtomicLongFieldUpdater.newUpdater(c.class, "sendersAndCloseStatus");

    /* renamed from: e, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f875e = AtomicLongFieldUpdater.newUpdater(c.class, "receivers");

    /* renamed from: f, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f876f = AtomicLongFieldUpdater.newUpdater(c.class, "bufferEnd");

    /* renamed from: g, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f877g = AtomicLongFieldUpdater.newUpdater(c.class, "completedExpandBuffersAndPauseFlag");

    /* renamed from: h, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f878h = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "sendSegment");

    /* renamed from: i, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f879i = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "receiveSegment");

    /* renamed from: j, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f880j = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "bufferEndSegment");

    /* renamed from: k, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f881k = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_closeCause");

    /* renamed from: l, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f882l = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "closeHandler");
    private volatile Object _closeCause;

    /* renamed from: b, reason: collision with root package name */
    public final int f883b;
    private volatile long bufferEnd;
    private volatile Object bufferEndSegment;

    /* renamed from: c, reason: collision with root package name */
    public final Z.l f884c;
    private volatile Object closeHandler;
    private volatile long completedExpandBuffersAndPauseFlag;
    private volatile Object receiveSegment;
    private volatile long receivers;
    private volatile Object sendSegment;
    private volatile long sendersAndCloseStatus;

    public c(int i2, Z.l lVar) {
        this.f883b = i2;
        this.f884c = lVar;
        if (i2 < 0) {
            throw new IllegalArgumentException(("Invalid channel capacity: " + i2 + ", should be >=0").toString());
        }
        k kVar = e.f886a;
        this.bufferEnd = i2 != 0 ? i2 != Integer.MAX_VALUE ? i2 : Long.MAX_VALUE : 0L;
        this.completedExpandBuffersAndPauseFlag = f876f.get(this);
        k kVar2 = new k(0L, null, this, 3);
        this.sendSegment = kVar2;
        this.receiveSegment = kVar2;
        if (r()) {
            kVar2 = e.f886a;
            a0.h.c(kVar2, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
        }
        this.bufferEndSegment = kVar2;
        this._closeCause = e.f903s;
    }

    public static final k b(c cVar, long j2, k kVar) {
        Object c2;
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j3;
        long j4;
        cVar.getClass();
        k kVar2 = e.f886a;
        d dVar = d.f885j;
        loop0: while (true) {
            c2 = AbstractC0081a.c(j2, kVar);
            if (!AbstractC0081a.f(c2)) {
                v d2 = AbstractC0081a.d(c2);
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f878h;
                    v vVar = (v) atomicReferenceFieldUpdater.get(cVar);
                    if (vVar.f1034c >= d2.f1034c) {
                        break loop0;
                    }
                    if (!d2.i()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(cVar, vVar, d2)) {
                        if (atomicReferenceFieldUpdater.get(cVar) != vVar) {
                            if (d2.e()) {
                                d2.d();
                            }
                        }
                    }
                    if (vVar.e()) {
                        vVar.d();
                    }
                }
            } else {
                break;
            }
        }
        boolean f2 = AbstractC0081a.f(c2);
        AtomicLongFieldUpdater atomicLongFieldUpdater2 = f875e;
        if (f2) {
            cVar.p();
            if (kVar.f1034c * e.f887b >= atomicLongFieldUpdater2.get(cVar)) {
                return null;
            }
            kVar.a();
            return null;
        }
        k kVar3 = (k) AbstractC0081a.d(c2);
        long j5 = kVar3.f1034c;
        if (j5 <= j2) {
            return kVar3;
        }
        long j6 = e.f887b * j5;
        do {
            atomicLongFieldUpdater = f874d;
            j3 = atomicLongFieldUpdater.get(cVar);
            j4 = 1152921504606846975L & j3;
            if (j4 >= j6) {
                break;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(cVar, j3, j4 + (((int) (j3 >> 60)) << 60)));
        if (j5 * e.f887b >= atomicLongFieldUpdater2.get(cVar)) {
            return null;
        }
        kVar3.a();
        return null;
    }

    public static final int c(c cVar, k kVar, int i2, Object obj, long j2, Object obj2, boolean z2) {
        cVar.getClass();
        kVar.m(i2, obj);
        if (z2) {
            return cVar.x(kVar, i2, obj, j2, obj2, z2);
        }
        Object k2 = kVar.k(i2);
        if (k2 == null) {
            if (cVar.d(j2)) {
                if (kVar.j(i2, null, e.f889d)) {
                    return 1;
                }
            } else {
                if (obj2 == null) {
                    return 3;
                }
                if (kVar.j(i2, null, obj2)) {
                    return 2;
                }
            }
        } else if (k2 instanceof d0) {
            kVar.m(i2, null);
            if (cVar.u(k2, obj)) {
                kVar.n(i2, e.f894i);
                return 0;
            }
            io.flutter.plugin.platform.i iVar = e.f896k;
            if (kVar.f910f.getAndSet((i2 * 2) + 1, iVar) != iVar) {
                kVar.l(i2, true);
            }
            return 5;
        }
        return cVar.x(kVar, i2, obj, j2, obj2, z2);
    }

    public static void n(c cVar) {
        cVar.getClass();
        AtomicLongFieldUpdater atomicLongFieldUpdater = f877g;
        if ((atomicLongFieldUpdater.addAndGet(cVar, 1L) & 4611686018427387904L) != 0) {
            while ((atomicLongFieldUpdater.get(cVar) & 4611686018427387904L) != 0) {
            }
        }
    }

    public static boolean v(Object obj) {
        if (obj instanceof InterfaceC0044d) {
            a0.h.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            return e.a((InterfaceC0044d) obj, Q.g.f327a, null);
        }
        throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
    }

    @Override // j0.s
    public final void a(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new CancellationException("Channel was cancelled");
        }
        e(cancellationException, true);
    }

    public final boolean d(long j2) {
        return j2 < f876f.get(this) || j2 < f875e.get(this) + ((long) this.f883b);
    }

    public final boolean e(Throwable th, boolean z2) {
        boolean z3;
        long j2;
        long j3;
        long j4;
        Object obj;
        long j5;
        long j6;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f874d;
        if (z2) {
            do {
                j6 = atomicLongFieldUpdater.get(this);
                if (((int) (j6 >> 60)) != 0) {
                    break;
                }
                k kVar = e.f886a;
            } while (!atomicLongFieldUpdater.compareAndSet(this, j6, (1 << 60) + (j6 & 1152921504606846975L)));
        }
        io.flutter.plugin.platform.i iVar = e.f903s;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f881k;
            if (atomicReferenceFieldUpdater.compareAndSet(this, iVar, th)) {
                z3 = true;
                break;
            }
            if (atomicReferenceFieldUpdater.get(this) != iVar) {
                z3 = false;
                break;
            }
        }
        if (z2) {
            do {
                j5 = atomicLongFieldUpdater.get(this);
            } while (!atomicLongFieldUpdater.compareAndSet(this, j5, (3 << 60) + (j5 & 1152921504606846975L)));
        } else {
            do {
                j2 = atomicLongFieldUpdater.get(this);
                int i2 = (int) (j2 >> 60);
                if (i2 == 0) {
                    j3 = j2 & 1152921504606846975L;
                    j4 = 2;
                } else {
                    if (i2 != 1) {
                        break;
                    }
                    j3 = j2 & 1152921504606846975L;
                    j4 = 3;
                }
            } while (!atomicLongFieldUpdater.compareAndSet(this, j2, (j4 << 60) + j3));
        }
        p();
        if (z3) {
            loop3: while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f882l;
                obj = atomicReferenceFieldUpdater2.get(this);
                io.flutter.plugin.platform.i iVar2 = obj == null ? e.f901q : e.f902r;
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, obj, iVar2)) {
                    if (atomicReferenceFieldUpdater2.get(this) != obj) {
                        break;
                    }
                }
            }
            if (obj != null) {
                a0.n.a(1, obj);
                ((Z.l) obj).h(k());
            }
        }
        return z3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x0090, code lost:
    
        r1 = (j0.k) ((m0.d) m0.d.f998b.get(r1));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final j0.k f(long r14) {
        /*
            Method dump skipped, instructions count: 310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j0.c.f(long):j0.k");
    }

    public final void g(long j2) {
        B.c b2;
        k kVar = (k) f879i.get(this);
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f875e;
            long j3 = atomicLongFieldUpdater.get(this);
            if (j2 < Math.max(this.f883b + j3, f876f.get(this))) {
                return;
            }
            if (atomicLongFieldUpdater.compareAndSet(this, j3, j3 + 1)) {
                long j4 = e.f887b;
                long j5 = j3 / j4;
                int i2 = (int) (j3 % j4);
                if (kVar.f1034c != j5) {
                    k i3 = i(j5, kVar);
                    if (i3 == null) {
                        continue;
                    } else {
                        kVar = i3;
                    }
                }
                Object w2 = w(kVar, i2, j3, null);
                if (w2 != e.f899o) {
                    kVar.a();
                    Z.l lVar = this.f884c;
                    if (lVar != null && (b2 = AbstractC0081a.b(lVar, w2, null)) != null) {
                        throw b2;
                    }
                } else if (j3 < m()) {
                    kVar.a();
                }
            }
        }
    }

    public final void h() {
        Object c2;
        if (r()) {
            return;
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f880j;
        k kVar = (k) atomicReferenceFieldUpdater.get(this);
        loop0: while (true) {
            long andIncrement = f876f.getAndIncrement(this);
            long j2 = andIncrement / e.f887b;
            if (m() <= andIncrement) {
                if (kVar.f1034c < j2 && kVar.b() != null) {
                    s(j2, kVar);
                }
                n(this);
                return;
            }
            if (kVar.f1034c != j2) {
                d dVar = d.f885j;
                while (true) {
                    c2 = AbstractC0081a.c(j2, kVar);
                    if (!AbstractC0081a.f(c2)) {
                        v d2 = AbstractC0081a.d(c2);
                        while (true) {
                            v vVar = (v) atomicReferenceFieldUpdater.get(this);
                            if (vVar.f1034c >= d2.f1034c) {
                                break;
                            }
                            if (!d2.i()) {
                                break;
                            }
                            while (!atomicReferenceFieldUpdater.compareAndSet(this, vVar, d2)) {
                                if (atomicReferenceFieldUpdater.get(this) != vVar) {
                                    if (d2.e()) {
                                        d2.d();
                                    }
                                }
                            }
                            if (vVar.e()) {
                                vVar.d();
                            }
                        }
                    } else {
                        break;
                    }
                }
                k kVar2 = null;
                if (AbstractC0081a.f(c2)) {
                    p();
                    s(j2, kVar);
                    n(this);
                } else {
                    k kVar3 = (k) AbstractC0081a.d(c2);
                    long j3 = kVar3.f1034c;
                    if (j3 > j2) {
                        long j4 = j3 * e.f887b;
                        if (f876f.compareAndSet(this, andIncrement + 1, j4)) {
                            AtomicLongFieldUpdater atomicLongFieldUpdater = f877g;
                            if ((atomicLongFieldUpdater.addAndGet(this, j4 - andIncrement) & 4611686018427387904L) != 0) {
                                while ((atomicLongFieldUpdater.get(this) & 4611686018427387904L) != 0) {
                                }
                            }
                        } else {
                            n(this);
                        }
                    } else {
                        kVar2 = kVar3;
                    }
                }
                if (kVar2 == null) {
                    continue;
                } else {
                    kVar = kVar2;
                }
            }
            int i2 = (int) (andIncrement % e.f887b);
            Object k2 = kVar.k(i2);
            boolean z2 = k2 instanceof d0;
            AtomicLongFieldUpdater atomicLongFieldUpdater2 = f875e;
            if (!z2 || andIncrement < atomicLongFieldUpdater2.get(this) || !kVar.j(i2, k2, e.f892g)) {
                while (true) {
                    Object k3 = kVar.k(i2);
                    if (!(k3 instanceof d0)) {
                        if (k3 != e.f895j) {
                            if (k3 != null) {
                                if (k3 == e.f889d || k3 == e.f893h || k3 == e.f894i || k3 == e.f896k || k3 == e.f897l) {
                                    break loop0;
                                }
                                if (k3 != e.f891f) {
                                    throw new IllegalStateException(("Unexpected cell state: " + k3).toString());
                                }
                            } else if (kVar.j(i2, k3, e.f890e)) {
                                break loop0;
                            }
                        } else {
                            break;
                        }
                    } else if (andIncrement < atomicLongFieldUpdater2.get(this)) {
                        if (kVar.j(i2, k3, new u((d0) k3))) {
                            break loop0;
                        }
                    } else if (kVar.j(i2, k3, e.f892g)) {
                        if (v(k3)) {
                            kVar.n(i2, e.f889d);
                            break;
                        } else {
                            kVar.n(i2, e.f895j);
                            kVar.h();
                        }
                    }
                }
            } else if (v(k2)) {
                kVar.n(i2, e.f889d);
                break;
            } else {
                kVar.n(i2, e.f895j);
                kVar.h();
                n(this);
            }
        }
        n(this);
    }

    public final k i(long j2, k kVar) {
        Object c2;
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j3;
        k kVar2 = e.f886a;
        d dVar = d.f885j;
        loop0: while (true) {
            c2 = AbstractC0081a.c(j2, kVar);
            if (!AbstractC0081a.f(c2)) {
                v d2 = AbstractC0081a.d(c2);
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f879i;
                    v vVar = (v) atomicReferenceFieldUpdater.get(this);
                    if (vVar.f1034c >= d2.f1034c) {
                        break loop0;
                    }
                    if (!d2.i()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, vVar, d2)) {
                        if (atomicReferenceFieldUpdater.get(this) != vVar) {
                            if (d2.e()) {
                                d2.d();
                            }
                        }
                    }
                    if (vVar.e()) {
                        vVar.d();
                    }
                }
            } else {
                break;
            }
        }
        if (AbstractC0081a.f(c2)) {
            p();
            if (kVar.f1034c * e.f887b >= m()) {
                return null;
            }
            kVar.a();
            return null;
        }
        k kVar3 = (k) AbstractC0081a.d(c2);
        boolean r2 = r();
        long j4 = kVar3.f1034c;
        if (!r2 && j2 <= f876f.get(this) / e.f887b) {
            while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f880j;
                v vVar2 = (v) atomicReferenceFieldUpdater2.get(this);
                if (vVar2.f1034c >= j4 || !kVar3.i()) {
                    break;
                }
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, vVar2, kVar3)) {
                    if (atomicReferenceFieldUpdater2.get(this) != vVar2) {
                        if (kVar3.e()) {
                            kVar3.d();
                        }
                    }
                }
                if (vVar2.e()) {
                    vVar2.d();
                }
            }
        }
        if (j4 <= j2) {
            return kVar3;
        }
        long j5 = e.f887b * j4;
        do {
            atomicLongFieldUpdater = f875e;
            j3 = atomicLongFieldUpdater.get(this);
            if (j3 >= j5) {
                break;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j3, j5));
        if (j4 * e.f887b >= m()) {
            return null;
        }
        kVar3.a();
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:?, code lost:
    
        return r1;
     */
    @Override // j0.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object j(java.lang.Object r23) {
        /*
            Method dump skipped, instructions count: 215
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j0.c.j(java.lang.Object):java.lang.Object");
    }

    public final Throwable k() {
        return (Throwable) f881k.get(this);
    }

    public final Throwable l() {
        Throwable k2 = k();
        return k2 == null ? new m("Channel was closed") : k2;
    }

    public final long m() {
        return f874d.get(this) & 1152921504606846975L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:89:0x00c7, code lost:
    
        r0 = (j0.k) ((m0.d) m0.d.f998b.get(r0));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean o(long r19, boolean r21) {
        /*
            Method dump skipped, instructions count: 419
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j0.c.o(long, boolean):boolean");
    }

    public final boolean p() {
        return o(f874d.get(this), false);
    }

    public boolean q() {
        return false;
    }

    public final boolean r() {
        long j2 = f876f.get(this);
        return j2 == 0 || j2 == Long.MAX_VALUE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0011, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void s(long r6, j0.k r8) {
        /*
            r5 = this;
        L0:
            long r0 = r8.f1034c
            int r2 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r2 >= 0) goto L11
            m0.d r0 = r8.b()
            j0.k r0 = (j0.k) r0
            if (r0 != 0) goto Lf
            goto L11
        Lf:
            r8 = r0
            goto L0
        L11:
            boolean r6 = r8.c()
            if (r6 == 0) goto L22
            m0.d r6 = r8.b()
            j0.k r6 = (j0.k) r6
            if (r6 != 0) goto L20
            goto L22
        L20:
            r8 = r6
            goto L11
        L22:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = j0.c.f880j
            java.lang.Object r7 = r6.get(r5)
            m0.v r7 = (m0.v) r7
            long r0 = r7.f1034c
            long r2 = r8.f1034c
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 < 0) goto L33
            goto L49
        L33:
            boolean r0 = r8.i()
            if (r0 != 0) goto L3a
            goto L11
        L3a:
            boolean r0 = r6.compareAndSet(r5, r7, r8)
            if (r0 == 0) goto L4a
            boolean r6 = r7.e()
            if (r6 == 0) goto L49
            r7.d()
        L49:
            return
        L4a:
            java.lang.Object r0 = r6.get(r5)
            if (r0 == r7) goto L3a
            boolean r6 = r8.e()
            if (r6 == 0) goto L22
            r8.d()
            goto L22
        */
        throw new UnsupportedOperationException("Method not decompiled: j0.c.s(long, j0.k):void");
    }

    public final void t(d0 d0Var, boolean z2) {
        Throwable l2;
        if (d0Var instanceof InterfaceC0044d) {
            S.d dVar = (S.d) d0Var;
            if (z2) {
                l2 = k();
                if (l2 == null) {
                    l2 = new l("Channel was closed");
                }
            } else {
                l2 = l();
            }
            dVar.c(a.a.f(l2));
            return;
        }
        if (!(d0Var instanceof a)) {
            throw new IllegalStateException(("Unexpected waiter: " + d0Var).toString());
        }
        a aVar = (a) d0Var;
        C0045e c0045e = aVar.f872c;
        a0.h.b(c0045e);
        aVar.f872c = null;
        aVar.f871b = e.f897l;
        Throwable k2 = aVar.f873d.k();
        if (k2 == null) {
            c0045e.c(Boolean.FALSE);
        } else {
            c0045e.c(a.a.f(k2));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:93:0x01a0, code lost:
    
        r3 = (j0.k) r3.b();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String toString() {
        /*
            Method dump skipped, instructions count: 484
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j0.c.toString():java.lang.String");
    }

    public final boolean u(Object obj, Object obj2) {
        if (!(obj instanceof a)) {
            if (!(obj instanceof InterfaceC0044d)) {
                throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
            }
            a0.h.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
            InterfaceC0044d interfaceC0044d = (InterfaceC0044d) obj;
            Z.l lVar = this.f884c;
            return e.a(interfaceC0044d, obj2, lVar != null ? new m0.q(lVar, obj2, ((C0045e) interfaceC0044d).f555f) : null);
        }
        a0.h.c(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
        a aVar = (a) obj;
        C0045e c0045e = aVar.f872c;
        a0.h.b(c0045e);
        aVar.f872c = null;
        aVar.f871b = obj2;
        Boolean bool = Boolean.TRUE;
        Z.l lVar2 = aVar.f873d.f884c;
        return e.a(c0045e, bool, lVar2 != null ? new m0.q(lVar2, obj2, c0045e.f555f) : null);
    }

    public final Object w(k kVar, int i2, long j2, a aVar) {
        Object k2 = kVar.k(i2);
        AtomicReferenceArray atomicReferenceArray = kVar.f910f;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f874d;
        if (k2 == null) {
            if (j2 >= (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                if (aVar == null) {
                    return e.f898n;
                }
                if (kVar.j(i2, k2, aVar)) {
                    h();
                    return e.m;
                }
            }
        } else if (k2 == e.f889d && kVar.j(i2, k2, e.f894i)) {
            h();
            Object obj = atomicReferenceArray.get(i2 * 2);
            kVar.m(i2, null);
            return obj;
        }
        while (true) {
            Object k3 = kVar.k(i2);
            if (k3 == null || k3 == e.f890e) {
                if (j2 < (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                    if (kVar.j(i2, k3, e.f893h)) {
                        h();
                        return e.f899o;
                    }
                } else {
                    if (aVar == null) {
                        return e.f898n;
                    }
                    if (kVar.j(i2, k3, aVar)) {
                        h();
                        return e.m;
                    }
                }
            } else if (k3 != e.f889d) {
                io.flutter.plugin.platform.i iVar = e.f895j;
                if (k3 == iVar) {
                    return e.f899o;
                }
                if (k3 == e.f893h) {
                    return e.f899o;
                }
                if (k3 == e.f897l) {
                    h();
                    return e.f899o;
                }
                if (k3 != e.f892g && kVar.j(i2, k3, e.f891f)) {
                    boolean z2 = k3 instanceof u;
                    if (z2) {
                        k3 = ((u) k3).f916a;
                    }
                    if (v(k3)) {
                        kVar.n(i2, e.f894i);
                        h();
                        Object obj2 = atomicReferenceArray.get(i2 * 2);
                        kVar.m(i2, null);
                        return obj2;
                    }
                    kVar.n(i2, iVar);
                    kVar.h();
                    if (z2) {
                        h();
                    }
                    return e.f899o;
                }
            } else if (kVar.j(i2, k3, e.f894i)) {
                h();
                Object obj3 = atomicReferenceArray.get(i2 * 2);
                kVar.m(i2, null);
                return obj3;
            }
        }
    }

    public final int x(k kVar, int i2, Object obj, long j2, Object obj2, boolean z2) {
        while (true) {
            Object k2 = kVar.k(i2);
            if (k2 == null) {
                if (!d(j2) || z2) {
                    if (z2) {
                        if (kVar.j(i2, null, e.f895j)) {
                            kVar.h();
                            return 4;
                        }
                    } else {
                        if (obj2 == null) {
                            return 3;
                        }
                        if (kVar.j(i2, null, obj2)) {
                            return 2;
                        }
                    }
                } else if (kVar.j(i2, null, e.f889d)) {
                    return 1;
                }
            } else {
                if (k2 != e.f890e) {
                    io.flutter.plugin.platform.i iVar = e.f896k;
                    if (k2 == iVar) {
                        kVar.m(i2, null);
                        return 5;
                    }
                    if (k2 == e.f893h) {
                        kVar.m(i2, null);
                        return 5;
                    }
                    if (k2 == e.f897l) {
                        kVar.m(i2, null);
                        p();
                        return 4;
                    }
                    kVar.m(i2, null);
                    if (k2 instanceof u) {
                        k2 = ((u) k2).f916a;
                    }
                    if (u(k2, obj)) {
                        kVar.n(i2, e.f894i);
                        return 0;
                    }
                    if (kVar.f910f.getAndSet((i2 * 2) + 1, iVar) == iVar) {
                        return 5;
                    }
                    kVar.l(i2, true);
                    return 5;
                }
                if (kVar.j(i2, k2, e.f889d)) {
                    return 1;
                }
            }
        }
    }
}
