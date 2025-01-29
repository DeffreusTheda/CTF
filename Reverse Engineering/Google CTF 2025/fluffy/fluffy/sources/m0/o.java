package m0;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: e, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f1020e = AtomicReferenceFieldUpdater.newUpdater(o.class, Object.class, "_next");

    /* renamed from: f, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f1021f = AtomicLongFieldUpdater.newUpdater(o.class, "_state");

    /* renamed from: g, reason: collision with root package name */
    public static final io.flutter.plugin.platform.i f1022g = new io.flutter.plugin.platform.i(1, "REMOVE_FROZEN");
    private volatile Object _next;
    private volatile long _state;

    /* renamed from: a, reason: collision with root package name */
    public final int f1023a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f1024b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1025c;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicReferenceArray f1026d;

    public o(int i2, boolean z2) {
        this.f1023a = i2;
        this.f1024b = z2;
        int i3 = i2 - 1;
        this.f1025c = i3;
        this.f1026d = new AtomicReferenceArray(i2);
        if (i3 > 1073741823) {
            throw new IllegalStateException("Check failed.");
        }
        if ((i2 & i3) != 0) {
            throw new IllegalStateException("Check failed.");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0050, code lost:
    
        return 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(java.lang.Runnable r15) {
        /*
            r14 = this;
        L0:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r6 = m0.o.f1021f
            long r2 = r6.get(r14)
            r0 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r0 = r0 & r2
            r4 = 1
            r7 = 0
            int r5 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r5 == 0) goto L19
            r0 = 2305843009213693952(0x2000000000000000, double:1.4916681462400413E-154)
            long r0 = r0 & r2
            int r15 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r15 == 0) goto L18
            r4 = 2
        L18:
            return r4
        L19:
            r0 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r0 = r0 & r2
            int r1 = (int) r0
            r9 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r9 = r9 & r2
            r0 = 30
            long r9 = r9 >> r0
            int r10 = (int) r9
            int r5 = r10 + 2
            int r9 = r14.f1025c
            r5 = r5 & r9
            r11 = r1 & r9
            if (r5 != r11) goto L32
            return r4
        L32:
            java.util.concurrent.atomic.AtomicReferenceArray r11 = r14.f1026d
            boolean r5 = r14.f1024b
            r12 = 1073741823(0x3fffffff, float:1.9999999)
            if (r5 != 0) goto L51
            r5 = r10 & r9
            java.lang.Object r5 = r11.get(r5)
            if (r5 == 0) goto L51
            r0 = 1024(0x400, float:1.435E-42)
            int r2 = r14.f1023a
            if (r2 < r0) goto L50
            int r10 = r10 - r1
            r0 = r10 & r12
            int r1 = r2 >> 1
            if (r0 <= r1) goto L0
        L50:
            return r4
        L51:
            int r1 = r10 + 1
            r1 = r1 & r12
            r4 = -1152921503533105153(0xf00000003fffffff, double:-3.1050369248997324E231)
            long r4 = r4 & r2
            long r12 = (long) r1
            long r0 = r12 << r0
            long r4 = r4 | r0
            r0 = r6
            r1 = r14
            boolean r0 = r0.compareAndSet(r1, r2, r4)
            if (r0 == 0) goto L0
            r0 = r10 & r9
            r11.set(r0, r15)
            r0 = r14
        L6c:
            long r1 = r6.get(r0)
            r3 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r1 = r1 & r3
            int r3 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r3 == 0) goto L95
            m0.o r0 = r0.c()
            java.util.concurrent.atomic.AtomicReferenceArray r1 = r0.f1026d
            int r2 = r0.f1025c
            r2 = r2 & r10
            java.lang.Object r3 = r1.get(r2)
            boolean r4 = r3 instanceof m0.n
            if (r4 == 0) goto L92
            m0.n r3 = (m0.n) r3
            int r3 = r3.f1019a
            if (r3 != r10) goto L92
            r1.set(r2, r15)
            goto L93
        L92:
            r0 = 0
        L93:
            if (r0 != 0) goto L6c
        L95:
            r15 = 0
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: m0.o.a(java.lang.Runnable):int");
    }

    public final boolean b() {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j2;
        do {
            atomicLongFieldUpdater = f1021f;
            j2 = atomicLongFieldUpdater.get(this);
            if ((j2 & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j2) != 0) {
                return false;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j2, 2305843009213693952L | j2));
        return true;
    }

    public final o c() {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j2;
        while (true) {
            atomicLongFieldUpdater = f1021f;
            j2 = atomicLongFieldUpdater.get(this);
            if ((j2 & 1152921504606846976L) != 0) {
                break;
            }
            long j3 = j2 | 1152921504606846976L;
            if (atomicLongFieldUpdater.compareAndSet(this, j2, j3)) {
                j2 = j3;
                break;
            }
        }
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1020e;
            o oVar = (o) atomicReferenceFieldUpdater.get(this);
            if (oVar != null) {
                return oVar;
            }
            o oVar2 = new o(this.f1023a * 2, this.f1024b);
            int i2 = (int) (1073741823 & j2);
            int i3 = (int) ((1152921503533105152L & j2) >> 30);
            while (true) {
                int i4 = this.f1025c;
                int i5 = i2 & i4;
                if (i5 == (i4 & i3)) {
                    break;
                }
                Object obj = this.f1026d.get(i5);
                if (obj == null) {
                    obj = new n(i2);
                }
                oVar2.f1026d.set(oVar2.f1025c & i2, obj);
                i2++;
            }
            atomicLongFieldUpdater.set(oVar2, (-1152921504606846977L) & j2);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, null, oVar2) && atomicReferenceFieldUpdater.get(this) == null) {
            }
        }
    }

    public final Object d() {
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f1021f;
            long j2 = atomicLongFieldUpdater.get(this);
            if ((j2 & 1152921504606846976L) != 0) {
                return f1022g;
            }
            int i2 = (int) (j2 & 1073741823);
            int i3 = (int) ((1152921503533105152L & j2) >> 30);
            int i4 = this.f1025c;
            int i5 = i2 & i4;
            if ((i3 & i4) == i5) {
                return null;
            }
            AtomicReferenceArray atomicReferenceArray = this.f1026d;
            Object obj = atomicReferenceArray.get(i5);
            boolean z2 = this.f1024b;
            if (obj == null) {
                if (z2) {
                    return null;
                }
            } else {
                if (obj instanceof n) {
                    return null;
                }
                long j3 = (i2 + 1) & 1073741823;
                if (atomicLongFieldUpdater.compareAndSet(this, j2, (j2 & (-1073741824)) | j3)) {
                    atomicReferenceArray.set(i5, null);
                    return obj;
                }
                if (z2) {
                    o oVar = this;
                    while (true) {
                        AtomicLongFieldUpdater atomicLongFieldUpdater2 = f1021f;
                        long j4 = atomicLongFieldUpdater2.get(oVar);
                        int i6 = (int) (j4 & 1073741823);
                        if ((j4 & 1152921504606846976L) != 0) {
                            oVar = oVar.c();
                        } else {
                            if (atomicLongFieldUpdater2.compareAndSet(oVar, j4, (j4 & (-1073741824)) | j3)) {
                                oVar.f1026d.set(oVar.f1025c & i6, null);
                                oVar = null;
                            } else {
                                continue;
                            }
                        }
                        if (oVar == null) {
                            return obj;
                        }
                    }
                }
            }
        }
    }
}
