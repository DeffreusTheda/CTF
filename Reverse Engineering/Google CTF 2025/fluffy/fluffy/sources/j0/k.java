package j0;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import m0.v;

/* loaded from: classes.dex */
public final class k extends v {

    /* renamed from: e, reason: collision with root package name */
    public final c f909e;

    /* renamed from: f, reason: collision with root package name */
    public final AtomicReferenceArray f910f;

    public k(long j2, k kVar, c cVar, int i2) {
        super(j2, kVar, i2);
        this.f909e = cVar;
        this.f910f = new AtomicReferenceArray(e.f887b * 2);
    }

    @Override // m0.v
    public final int f() {
        return e.f887b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x005b, code lost:
    
        m(r7, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x005e, code lost:
    
        if (r1 == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0060, code lost:
    
        a0.h.b(r4);
        r7 = r4.f884c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0065, code lost:
    
        if (r7 == null) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0067, code lost:
    
        m0.AbstractC0081a.a(r7, r0, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x006a, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:?, code lost:
    
        return;
     */
    @Override // m0.v
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(int r7, S.i r8) {
        /*
            r6 = this;
            int r0 = j0.e.f887b
            if (r7 < r0) goto L6
            r1 = 1
            goto L7
        L6:
            r1 = 0
        L7:
            if (r1 == 0) goto La
            int r7 = r7 - r0
        La:
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r6.f910f
            int r2 = r7 * 2
            java.lang.Object r0 = r0.get(r2)
        L12:
            java.lang.Object r2 = r6.k(r7)
            boolean r3 = r2 instanceof h0.d0
            j0.c r4 = r6.f909e
            r5 = 0
            if (r3 != 0) goto L6b
            boolean r3 = r2 instanceof j0.u
            if (r3 == 0) goto L22
            goto L6b
        L22:
            io.flutter.plugin.platform.i r3 = j0.e.f895j
            if (r2 == r3) goto L5b
            io.flutter.plugin.platform.i r3 = j0.e.f896k
            if (r2 != r3) goto L2b
            goto L5b
        L2b:
            io.flutter.plugin.platform.i r3 = j0.e.f892g
            if (r2 == r3) goto L12
            io.flutter.plugin.platform.i r3 = j0.e.f891f
            if (r2 != r3) goto L34
            goto L12
        L34:
            io.flutter.plugin.platform.i r7 = j0.e.f894i
            if (r2 == r7) goto L5a
            io.flutter.plugin.platform.i r7 = j0.e.f889d
            if (r2 != r7) goto L3d
            goto L5a
        L3d:
            io.flutter.plugin.platform.i r7 = j0.e.f897l
            if (r2 != r7) goto L42
            return
        L42:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r0 = "unexpected state: "
            r8.<init>(r0)
            r8.append(r2)
            java.lang.String r8 = r8.toString()
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        L5a:
            return
        L5b:
            r6.m(r7, r5)
            if (r1 == 0) goto L6a
            a0.h.b(r4)
            Z.l r7 = r4.f884c
            if (r7 == 0) goto L6a
            m0.AbstractC0081a.a(r7, r0, r8)
        L6a:
            return
        L6b:
            if (r1 == 0) goto L70
            io.flutter.plugin.platform.i r3 = j0.e.f895j
            goto L72
        L70:
            io.flutter.plugin.platform.i r3 = j0.e.f896k
        L72:
            boolean r2 = r6.j(r7, r2, r3)
            if (r2 == 0) goto L12
            r6.m(r7, r5)
            r2 = r1 ^ 1
            r6.l(r7, r2)
            if (r1 == 0) goto L8c
            a0.h.b(r4)
            Z.l r7 = r4.f884c
            if (r7 == 0) goto L8c
            m0.AbstractC0081a.a(r7, r0, r8)
        L8c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j0.k.g(int, S.i):void");
    }

    public final boolean j(int i2, Object obj, Object obj2) {
        AtomicReferenceArray atomicReferenceArray = this.f910f;
        int i3 = (i2 * 2) + 1;
        while (!atomicReferenceArray.compareAndSet(i3, obj, obj2)) {
            if (atomicReferenceArray.get(i3) != obj) {
                return false;
            }
        }
        return true;
    }

    public final Object k(int i2) {
        return this.f910f.get((i2 * 2) + 1);
    }

    public final void l(int i2, boolean z2) {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j2;
        AtomicLongFieldUpdater atomicLongFieldUpdater2;
        long j3;
        if (z2) {
            c cVar = this.f909e;
            a0.h.b(cVar);
            long j4 = (this.f1034c * e.f887b) + i2;
            if (!cVar.r()) {
                do {
                    atomicLongFieldUpdater = c.f876f;
                } while (atomicLongFieldUpdater.get(cVar) <= j4);
                int i3 = e.f888c;
                int i4 = 0;
                while (true) {
                    AtomicLongFieldUpdater atomicLongFieldUpdater3 = c.f877g;
                    if (i4 < i3) {
                        long j5 = atomicLongFieldUpdater.get(cVar);
                        if (j5 == (atomicLongFieldUpdater3.get(cVar) & 4611686018427387903L) && j5 == atomicLongFieldUpdater.get(cVar)) {
                            break;
                        } else {
                            i4++;
                        }
                    } else {
                        do {
                            j2 = atomicLongFieldUpdater3.get(cVar);
                        } while (!atomicLongFieldUpdater3.compareAndSet(cVar, j2, 4611686018427387904L + (j2 & 4611686018427387903L)));
                        while (true) {
                            long j6 = atomicLongFieldUpdater.get(cVar);
                            atomicLongFieldUpdater2 = c.f877g;
                            long j7 = atomicLongFieldUpdater2.get(cVar);
                            long j8 = j7 & 4611686018427387903L;
                            boolean z3 = (j7 & 4611686018427387904L) != 0;
                            if (j6 == j8 && j6 == atomicLongFieldUpdater.get(cVar)) {
                                break;
                            } else if (!z3) {
                                atomicLongFieldUpdater2.compareAndSet(cVar, j7, j8 + 4611686018427387904L);
                            }
                        }
                        do {
                            j3 = atomicLongFieldUpdater2.get(cVar);
                        } while (!atomicLongFieldUpdater2.compareAndSet(cVar, j3, j3 & 4611686018427387903L));
                    }
                }
            }
        }
        h();
    }

    public final void m(int i2, Object obj) {
        this.f910f.lazySet(i2 * 2, obj);
    }

    public final void n(int i2, io.flutter.plugin.platform.i iVar) {
        this.f910f.set((i2 * 2) + 1, iVar);
    }
}
