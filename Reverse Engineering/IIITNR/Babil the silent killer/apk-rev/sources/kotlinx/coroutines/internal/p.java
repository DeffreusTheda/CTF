package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public final class p<E> {
    private volatile /* synthetic */ Object _next = null;
    private volatile /* synthetic */ long _state = 0;

    /* renamed from: a, reason: collision with root package name */
    private final int f837a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f838b;

    /* renamed from: c, reason: collision with root package name */
    private final int f839c;

    /* renamed from: d, reason: collision with root package name */
    private /* synthetic */ AtomicReferenceArray f840d;

    /* renamed from: e, reason: collision with root package name */
    public static final a f833e = new a(null);

    /* renamed from: h, reason: collision with root package name */
    public static final y f836h = new y("REMOVE_FROZEN");

    /* renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f834f = AtomicReferenceFieldUpdater.newUpdater(p.class, Object.class, "_next");

    /* renamed from: g, reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f835g = AtomicLongFieldUpdater.newUpdater(p.class, "_state");

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.e eVar) {
            this();
        }

        public final int a(long j2) {
            return (j2 & 2305843009213693952L) != 0 ? 2 : 1;
        }

        public final long b(long j2, int i2) {
            return d(j2, 1073741823L) | (i2 << 0);
        }

        public final long c(long j2, int i2) {
            return d(j2, 1152921503533105152L) | (i2 << 30);
        }

        public final long d(long j2, long j3) {
            return j2 & (j3 ^ (-1));
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f841a;

        public b(int i2) {
            this.f841a = i2;
        }
    }

    public p(int i2, boolean z2) {
        this.f837a = i2;
        this.f838b = z2;
        int i3 = i2 - 1;
        this.f839c = i3;
        this.f840d = new AtomicReferenceArray(i2);
        if (!(i3 <= 1073741823)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!((i2 & i3) == 0)) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final p<E> b(long j2) {
        p<E> pVar = new p<>(this.f837a * 2, this.f838b);
        int i2 = (int) ((1073741823 & j2) >> 0);
        int i3 = (int) ((1152921503533105152L & j2) >> 30);
        while (true) {
            int i4 = this.f839c;
            if ((i2 & i4) == (i3 & i4)) {
                pVar._state = f833e.d(j2, 1152921504606846976L);
                return pVar;
            }
            Object obj = this.f840d.get(i4 & i2);
            if (obj == null) {
                obj = new b(i2);
            }
            pVar.f840d.set(pVar.f839c & i2, obj);
            i2++;
        }
    }

    private final p<E> c(long j2) {
        while (true) {
            p<E> pVar = (p) this._next;
            if (pVar != null) {
                return pVar;
            }
            c.a(f834f, this, null, b(j2));
        }
    }

    private final p<E> e(int i2, E e2) {
        Object obj = this.f840d.get(this.f839c & i2);
        if (!(obj instanceof b) || ((b) obj).f841a != i2) {
            return null;
        }
        this.f840d.set(i2 & this.f839c, e2);
        return this;
    }

    private final long h() {
        long j2;
        long j3;
        do {
            j2 = this._state;
            if ((j2 & 1152921504606846976L) != 0) {
                return j2;
            }
            j3 = j2 | 1152921504606846976L;
        } while (!f835g.compareAndSet(this, j2, j3));
        return j3;
    }

    private final p<E> k(int i2, int i3) {
        long j2;
        a aVar;
        int i4;
        do {
            j2 = this._state;
            aVar = f833e;
            i4 = (int) ((1073741823 & j2) >> 0);
            if ((1152921504606846976L & j2) != 0) {
                return i();
            }
        } while (!f835g.compareAndSet(this, j2, aVar.b(j2, i3)));
        this.f840d.set(this.f839c & i4, null);
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x004e, code lost:
    
        return 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(E r14) {
        /*
            r13 = this;
        L0:
            long r2 = r13._state
            r0 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r0 = r0 & r2
            r6 = 0
            int r4 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r4 == 0) goto L12
            kotlinx.coroutines.internal.p$a r14 = kotlinx.coroutines.internal.p.f833e
            int r14 = r14.a(r2)
            return r14
        L12:
            kotlinx.coroutines.internal.p$a r0 = kotlinx.coroutines.internal.p.f833e
            r4 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r4 = r4 & r2
            r8 = 0
            long r4 = r4 >> r8
            int r1 = (int) r4
            r4 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r4 = r4 & r2
            r9 = 30
            long r4 = r4 >> r9
            int r9 = (int) r4
            int r10 = r13.f839c
            int r4 = r9 + 2
            r4 = r4 & r10
            r5 = r1 & r10
            r11 = 1
            if (r4 != r5) goto L30
            return r11
        L30:
            boolean r4 = r13.f838b
            r5 = 1073741823(0x3fffffff, float:1.9999999)
            if (r4 != 0) goto L4f
            java.util.concurrent.atomic.AtomicReferenceArray r4 = r13.f840d
            r12 = r9 & r10
            java.lang.Object r4 = r4.get(r12)
            if (r4 == 0) goto L4f
            int r0 = r13.f837a
            r2 = 1024(0x400, float:1.435E-42)
            if (r0 < r2) goto L4e
            int r9 = r9 - r1
            r1 = r9 & r5
            int r0 = r0 >> 1
            if (r1 <= r0) goto L0
        L4e:
            return r11
        L4f:
            int r1 = r9 + 1
            r1 = r1 & r5
            java.util.concurrent.atomic.AtomicLongFieldUpdater r4 = kotlinx.coroutines.internal.p.f835g
            long r11 = r0.c(r2, r1)
            r0 = r4
            r1 = r13
            r4 = r11
            boolean r0 = r0.compareAndSet(r1, r2, r4)
            if (r0 == 0) goto L0
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r13.f840d
            r1 = r9 & r10
            r0.set(r1, r14)
            r0 = r13
        L69:
            long r1 = r0._state
            r3 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r1 = r1 & r3
            int r3 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r3 != 0) goto L73
            goto L7d
        L73:
            kotlinx.coroutines.internal.p r0 = r0.i()
            kotlinx.coroutines.internal.p r0 = r0.e(r9, r14)
            if (r0 != 0) goto L69
        L7d:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.p.a(java.lang.Object):int");
    }

    public final boolean d() {
        long j2;
        do {
            j2 = this._state;
            if ((j2 & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j2) != 0) {
                return false;
            }
        } while (!f835g.compareAndSet(this, j2, j2 | 2305843009213693952L));
        return true;
    }

    public final int f() {
        long j2 = this._state;
        return 1073741823 & (((int) ((j2 & 1152921503533105152L) >> 30)) - ((int) ((1073741823 & j2) >> 0)));
    }

    public final boolean g() {
        long j2 = this._state;
        return ((int) ((1073741823 & j2) >> 0)) == ((int) ((j2 & 1152921503533105152L) >> 30));
    }

    public final p<E> i() {
        return c(h());
    }

    public final Object j() {
        while (true) {
            long j2 = this._state;
            if ((1152921504606846976L & j2) != 0) {
                return f836h;
            }
            a aVar = f833e;
            int i2 = (int) ((1073741823 & j2) >> 0);
            int i3 = (int) ((1152921503533105152L & j2) >> 30);
            int i4 = this.f839c;
            if ((i3 & i4) == (i2 & i4)) {
                return null;
            }
            Object obj = this.f840d.get(i4 & i2);
            if (obj == null) {
                if (this.f838b) {
                    return null;
                }
            } else {
                if (obj instanceof b) {
                    return null;
                }
                int i5 = (i2 + 1) & 1073741823;
                if (f835g.compareAndSet(this, j2, aVar.b(j2, i5))) {
                    this.f840d.set(this.f839c & i2, null);
                    return obj;
                }
                if (this.f838b) {
                    p<E> pVar = this;
                    do {
                        pVar = pVar.k(i2, i5);
                    } while (pVar != null);
                    return obj;
                }
            }
        }
    }
}
