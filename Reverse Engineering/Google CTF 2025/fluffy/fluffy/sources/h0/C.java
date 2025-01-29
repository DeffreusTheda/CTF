package h0;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public abstract class C extends D implements InterfaceC0062w {

    /* renamed from: g, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f516g = AtomicReferenceFieldUpdater.newUpdater(C.class, Object.class, "_queue");

    /* renamed from: h, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f517h = AtomicReferenceFieldUpdater.newUpdater(C.class, Object.class, "_delayed");

    /* renamed from: i, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f518i = AtomicIntegerFieldUpdater.newUpdater(C.class, "_isCompleted");
    private volatile Object _delayed;
    private volatile int _isCompleted = 0;
    private volatile Object _queue;

    @Override // h0.AbstractC0056p
    public final void c(S.i iVar, Runnable runnable) {
        n(runnable);
    }

    @Override // h0.D
    public void m() {
        a0.f546a.set(null);
        f518i.set(this, 1);
        loop0: while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f516g;
            Object obj = atomicReferenceFieldUpdater.get(this);
            io.flutter.plugin.platform.i iVar = AbstractC0059t.f577b;
            if (obj != null) {
                if (!(obj instanceof m0.o)) {
                    if (obj != iVar) {
                        m0.o oVar = new m0.o(8, true);
                        oVar.a((Runnable) obj);
                        while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, oVar)) {
                            if (atomicReferenceFieldUpdater.get(this) != obj) {
                                break;
                            }
                        }
                        break loop0;
                    }
                    break;
                }
                ((m0.o) obj).b();
                break;
            }
            while (!atomicReferenceFieldUpdater.compareAndSet(this, null, iVar)) {
                if (atomicReferenceFieldUpdater.get(this) != null) {
                    break;
                }
            }
            break loop0;
        }
        while (q() <= 0) {
        }
        System.nanoTime();
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0066, code lost:
    
        r6 = j();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006e, code lost:
    
        if (java.lang.Thread.currentThread() == r6) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0070, code lost:
    
        java.util.concurrent.locks.LockSupport.unpark(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0073, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void n(java.lang.Runnable r6) {
        /*
            r5 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = h0.C.f516g
            java.lang.Object r1 = r0.get(r5)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r2 = h0.C.f518i
            int r2 = r2.get(r5)
            if (r2 == 0) goto Lf
            goto L4a
        Lf:
            if (r1 != 0) goto L20
        L11:
            r1 = 0
            boolean r1 = r0.compareAndSet(r5, r1, r6)
            if (r1 == 0) goto L19
            goto L66
        L19:
            java.lang.Object r1 = r0.get(r5)
            if (r1 == 0) goto L11
            goto L0
        L20:
            boolean r2 = r1 instanceof m0.o
            r3 = 1
            if (r2 == 0) goto L46
            r2 = r1
            m0.o r2 = (m0.o) r2
            int r4 = r2.a(r6)
            if (r4 == 0) goto L66
            if (r4 == r3) goto L34
            r0 = 2
            if (r4 == r0) goto L4a
            goto L0
        L34:
            m0.o r2 = r2.c()
        L38:
            boolean r3 = r0.compareAndSet(r5, r1, r2)
            if (r3 == 0) goto L3f
            goto L0
        L3f:
            java.lang.Object r3 = r0.get(r5)
            if (r3 == r1) goto L38
            goto L0
        L46:
            io.flutter.plugin.platform.i r2 = h0.AbstractC0059t.f577b
            if (r1 != r2) goto L50
        L4a:
            h0.u r0 = h0.RunnableC0060u.f585j
            r0.n(r6)
            goto L73
        L50:
            m0.o r2 = new m0.o
            r4 = 8
            r2.<init>(r4, r3)
            r3 = r1
            java.lang.Runnable r3 = (java.lang.Runnable) r3
            r2.a(r3)
            r2.a(r6)
        L60:
            boolean r3 = r0.compareAndSet(r5, r1, r2)
            if (r3 == 0) goto L74
        L66:
            java.lang.Thread r6 = r5.j()
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            if (r0 == r6) goto L73
            java.util.concurrent.locks.LockSupport.unpark(r6)
        L73:
            return
        L74:
            java.lang.Object r3 = r0.get(r5)
            if (r3 == r1) goto L60
            goto L0
        */
        throw new UnsupportedOperationException("Method not decompiled: h0.C.n(java.lang.Runnable):void");
    }

    public final long o() {
        R.c cVar = this.f521f;
        if (((cVar == null || cVar.isEmpty()) ? Long.MAX_VALUE : 0L) == 0) {
            return 0L;
        }
        Object obj = f516g.get(this);
        if (obj != null) {
            if (!(obj instanceof m0.o)) {
                return obj == AbstractC0059t.f577b ? Long.MAX_VALUE : 0L;
            }
            long j2 = m0.o.f1021f.get((m0.o) obj);
            if (((int) (1073741823 & j2)) != ((int) ((j2 & 1152921503533105152L) >> 30))) {
                return 0L;
            }
        }
        return Long.MAX_VALUE;
    }

    public final boolean p() {
        R.c cVar = this.f521f;
        if (!(cVar != null ? cVar.isEmpty() : true)) {
            return false;
        }
        Object obj = f516g.get(this);
        if (obj == null) {
            return true;
        }
        if (obj instanceof m0.o) {
            long j2 = m0.o.f1021f.get((m0.o) obj);
            if (((int) (1073741823 & j2)) == ((int) ((j2 & 1152921503533105152L) >> 30))) {
                return true;
            }
        } else if (obj == AbstractC0059t.f577b) {
            return true;
        }
        return false;
    }

    public final long q() {
        Runnable runnable;
        if (l()) {
            return 0L;
        }
        loop0: while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f516g;
            Object obj = atomicReferenceFieldUpdater.get(this);
            runnable = null;
            if (obj == null) {
                break;
            }
            if (!(obj instanceof m0.o)) {
                if (obj != AbstractC0059t.f577b) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, null)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj) {
                            break;
                        }
                    }
                    runnable = (Runnable) obj;
                    break loop0;
                }
                break;
            }
            m0.o oVar = (m0.o) obj;
            Object d2 = oVar.d();
            if (d2 != m0.o.f1022g) {
                runnable = (Runnable) d2;
                break;
            }
            m0.o c2 = oVar.c();
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, c2) && atomicReferenceFieldUpdater.get(this) == obj) {
            }
        }
        if (runnable == null) {
            return o();
        }
        runnable.run();
        return 0L;
    }
}
