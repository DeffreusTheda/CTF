package n0;

import D.H;
import h0.AbstractC0059t;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import m0.t;

/* loaded from: classes.dex */
public final class b implements Executor, Closeable {

    /* renamed from: i, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f1097i = AtomicLongFieldUpdater.newUpdater(b.class, "parkedWorkersStack");

    /* renamed from: j, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f1098j = AtomicLongFieldUpdater.newUpdater(b.class, "controlState");

    /* renamed from: k, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f1099k = AtomicIntegerFieldUpdater.newUpdater(b.class, "_isTerminated");

    /* renamed from: l, reason: collision with root package name */
    public static final io.flutter.plugin.platform.i f1100l = new io.flutter.plugin.platform.i(1, "NOT_IN_STACK");
    private volatile int _isTerminated;

    /* renamed from: b, reason: collision with root package name */
    public final int f1101b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1102c;
    private volatile long controlState;

    /* renamed from: d, reason: collision with root package name */
    public final long f1103d;

    /* renamed from: e, reason: collision with root package name */
    public final String f1104e;

    /* renamed from: f, reason: collision with root package name */
    public final e f1105f;

    /* renamed from: g, reason: collision with root package name */
    public final e f1106g;

    /* renamed from: h, reason: collision with root package name */
    public final t f1107h;
    private volatile long parkedWorkersStack;

    public b(int i2, int i3, long j2, String str) {
        this.f1101b = i2;
        this.f1102c = i3;
        this.f1103d = j2;
        this.f1104e = str;
        if (i2 < 1) {
            throw new IllegalArgumentException(("Core pool size " + i2 + " should be at least 1").toString());
        }
        if (i3 < i2) {
            throw new IllegalArgumentException(("Max pool size " + i3 + " should be greater than or equals to core pool size " + i2).toString());
        }
        if (i3 > 2097150) {
            throw new IllegalArgumentException(("Max pool size " + i3 + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (j2 <= 0) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j2 + " must be positive").toString());
        }
        this.f1105f = new e();
        this.f1106g = new e();
        this.f1107h = new t((i2 + 1) * 2);
        this.controlState = i2 << 42;
        this._isTerminated = 0;
    }

    public final int a() {
        synchronized (this.f1107h) {
            try {
                if (f1099k.get(this) != 0) {
                    return -1;
                }
                AtomicLongFieldUpdater atomicLongFieldUpdater = f1098j;
                long j2 = atomicLongFieldUpdater.get(this);
                int i2 = (int) (j2 & 2097151);
                int i3 = i2 - ((int) ((j2 & 4398044413952L) >> 21));
                if (i3 < 0) {
                    i3 = 0;
                }
                if (i3 >= this.f1101b) {
                    return 0;
                }
                if (i2 >= this.f1102c) {
                    return 0;
                }
                int i4 = ((int) (atomicLongFieldUpdater.get(this) & 2097151)) + 1;
                if (i4 <= 0 || this.f1107h.b(i4) != null) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                a aVar = new a(this, i4);
                this.f1107h.c(i4, aVar);
                if (i4 != ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this)))) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                int i5 = i3 + 1;
                aVar.start();
                return i5;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(Runnable runnable, H h2, boolean z2) {
        h iVar;
        int i2;
        j.f1121f.getClass();
        long nanoTime = System.nanoTime();
        if (runnable instanceof h) {
            iVar = (h) runnable;
            iVar.f1113b = nanoTime;
            iVar.f1114c = h2;
        } else {
            iVar = new i(runnable, nanoTime, h2);
        }
        boolean z3 = false;
        boolean z4 = iVar.f1114c.f30a == 1;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f1098j;
        long addAndGet = z4 ? atomicLongFieldUpdater.addAndGet(this, 2097152L) : 0L;
        Thread currentThread = Thread.currentThread();
        a aVar = currentThread instanceof a ? (a) currentThread : null;
        if (aVar == null || !a0.h.a(aVar.f1096i, this)) {
            aVar = null;
        }
        if (aVar != null && (i2 = aVar.f1091d) != 5 && (iVar.f1114c.f30a != 0 || i2 != 2)) {
            aVar.f1095h = true;
            l lVar = aVar.f1089b;
            if (z2) {
                iVar = lVar.a(iVar);
            } else {
                lVar.getClass();
                h hVar = (h) l.f1125b.getAndSet(lVar, iVar);
                iVar = hVar == null ? null : lVar.a(hVar);
            }
        }
        if (iVar != null) {
            if (!(iVar.f1114c.f30a == 1 ? this.f1106g.a(iVar) : this.f1105f.a(iVar))) {
                throw new RejectedExecutionException(this.f1104e + " was terminated");
            }
        }
        if (z2 && aVar != null) {
            z3 = true;
        }
        if (z4) {
            if (z3 || e() || d(addAndGet)) {
                return;
            }
            e();
            return;
        }
        if (z3 || e() || d(atomicLongFieldUpdater.get(this))) {
            return;
        }
        e();
    }

    public final void c(a aVar, int i2, int i3) {
        while (true) {
            long j2 = f1097i.get(this);
            int i4 = (int) (2097151 & j2);
            long j3 = (2097152 + j2) & (-2097152);
            if (i4 == i2) {
                if (i3 == 0) {
                    Object c2 = aVar.c();
                    while (true) {
                        if (c2 == f1100l) {
                            i4 = -1;
                            break;
                        }
                        if (c2 == null) {
                            i4 = 0;
                            break;
                        }
                        a aVar2 = (a) c2;
                        i4 = aVar2.b();
                        if (i4 != 0) {
                            break;
                        } else {
                            c2 = aVar2.c();
                        }
                    }
                } else {
                    i4 = i3;
                }
            }
            if (i4 >= 0) {
                if (f1097i.compareAndSet(this, j2, j3 | i4)) {
                    return;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0087, code lost:
    
        if (r1 == null) goto L39;
     */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void close() {
        /*
            r8 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = n0.b.f1099k
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r8, r1, r2)
            if (r0 != 0) goto Lc
            goto Laf
        Lc:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            boolean r1 = r0 instanceof n0.a
            r3 = 0
            if (r1 == 0) goto L18
            n0.a r0 = (n0.a) r0
            goto L19
        L18:
            r0 = r3
        L19:
            if (r0 == 0) goto L24
            n0.b r1 = r0.f1096i
            boolean r1 = a0.h.a(r1, r8)
            if (r1 == 0) goto L24
            goto L25
        L24:
            r0 = r3
        L25:
            m0.t r1 = r8.f1107h
            monitor-enter(r1)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r4 = n0.b.f1098j     // Catch: java.lang.Throwable -> Lc1
            long r4 = r4.get(r8)     // Catch: java.lang.Throwable -> Lc1
            r6 = 2097151(0x1fffff, double:1.0361303E-317)
            long r4 = r4 & r6
            int r5 = (int) r4
            monitor-exit(r1)
            if (r2 > r5) goto L77
            r1 = 1
        L37:
            m0.t r4 = r8.f1107h
            java.lang.Object r4 = r4.b(r1)
            a0.h.b(r4)
            n0.a r4 = (n0.a) r4
            if (r4 == r0) goto L72
        L44:
            boolean r6 = r4.isAlive()
            if (r6 == 0) goto L53
            java.util.concurrent.locks.LockSupport.unpark(r4)
            r6 = 10000(0x2710, double:4.9407E-320)
            r4.join(r6)
            goto L44
        L53:
            n0.l r4 = r4.f1089b
            n0.e r6 = r8.f1106g
            r4.getClass()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r7 = n0.l.f1125b
            java.lang.Object r7 = r7.getAndSet(r4, r3)
            n0.h r7 = (n0.h) r7
            if (r7 == 0) goto L67
            r6.a(r7)
        L67:
            n0.h r7 = r4.b()
            if (r7 != 0) goto L6e
            goto L72
        L6e:
            r6.a(r7)
            goto L67
        L72:
            if (r1 == r5) goto L77
            int r1 = r1 + 1
            goto L37
        L77:
            n0.e r1 = r8.f1106g
            r1.b()
            n0.e r1 = r8.f1105f
            r1.b()
        L81:
            if (r0 == 0) goto L89
            n0.h r1 = r0.a(r2)
            if (r1 != 0) goto Lb0
        L89:
            n0.e r1 = r8.f1105f
            java.lang.Object r1 = r1.d()
            n0.h r1 = (n0.h) r1
            if (r1 != 0) goto Lb0
            n0.e r1 = r8.f1106g
            java.lang.Object r1 = r1.d()
            n0.h r1 = (n0.h) r1
            if (r1 != 0) goto Lb0
            if (r0 == 0) goto La3
            r1 = 5
            r0.h(r1)
        La3:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = n0.b.f1097i
            r1 = 0
            r0.set(r8, r1)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = n0.b.f1098j
            r0.set(r8, r1)
        Laf:
            return
        Lb0:
            r1.run()     // Catch: java.lang.Throwable -> Lb4
            goto L81
        Lb4:
            r1 = move-exception
            java.lang.Thread r3 = java.lang.Thread.currentThread()
            java.lang.Thread$UncaughtExceptionHandler r4 = r3.getUncaughtExceptionHandler()
            r4.uncaughtException(r3, r1)
            goto L81
        Lc1:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: n0.b.close():void");
    }

    public final boolean d(long j2) {
        int i2 = ((int) (2097151 & j2)) - ((int) ((j2 & 4398044413952L) >> 21));
        if (i2 < 0) {
            i2 = 0;
        }
        int i3 = this.f1101b;
        if (i2 < i3) {
            int a2 = a();
            if (a2 == 1 && i3 > 1) {
                a();
            }
            if (a2 > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean e() {
        io.flutter.plugin.platform.i iVar;
        int i2;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f1097i;
            long j2 = atomicLongFieldUpdater.get(this);
            a aVar = (a) this.f1107h.b((int) (2097151 & j2));
            if (aVar == null) {
                aVar = null;
            } else {
                long j3 = (2097152 + j2) & (-2097152);
                Object c2 = aVar.c();
                while (true) {
                    iVar = f1100l;
                    if (c2 == iVar) {
                        i2 = -1;
                        break;
                    }
                    if (c2 == null) {
                        i2 = 0;
                        break;
                    }
                    a aVar2 = (a) c2;
                    i2 = aVar2.b();
                    if (i2 != 0) {
                        break;
                    }
                    c2 = aVar2.c();
                }
                if (i2 >= 0 && atomicLongFieldUpdater.compareAndSet(this, j2, j3 | i2)) {
                    aVar.g(iVar);
                }
            }
            if (aVar == null) {
                return false;
            }
            if (a.f1088j.compareAndSet(aVar, -1, 0)) {
                LockSupport.unpark(aVar);
                return true;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        b(runnable, j.f1122g, false);
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        t tVar = this.f1107h;
        int a2 = tVar.a();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 1; i7 < a2; i7++) {
            a aVar = (a) tVar.b(i7);
            if (aVar != null) {
                l lVar = aVar.f1089b;
                lVar.getClass();
                int i8 = l.f1125b.get(lVar) != null ? (l.f1126c.get(lVar) - l.f1127d.get(lVar)) + 1 : l.f1126c.get(lVar) - l.f1127d.get(lVar);
                int a3 = n.e.a(aVar.f1091d);
                if (a3 == 0) {
                    i2++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(i8);
                    sb.append('c');
                    arrayList.add(sb.toString());
                } else if (a3 == 1) {
                    i3++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i8);
                    sb2.append('b');
                    arrayList.add(sb2.toString());
                } else if (a3 == 2) {
                    i4++;
                } else if (a3 == 3) {
                    i5++;
                    if (i8 > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(i8);
                        sb3.append('d');
                        arrayList.add(sb3.toString());
                    }
                } else if (a3 == 4) {
                    i6++;
                }
            }
        }
        long j2 = f1098j.get(this);
        StringBuilder sb4 = new StringBuilder();
        sb4.append(this.f1104e);
        sb4.append('@');
        sb4.append(AbstractC0059t.a(this));
        sb4.append("[Pool Size {core = ");
        int i9 = this.f1101b;
        sb4.append(i9);
        sb4.append(", max = ");
        sb4.append(this.f1102c);
        sb4.append("}, Worker States {CPU = ");
        sb4.append(i2);
        sb4.append(", blocking = ");
        sb4.append(i3);
        sb4.append(", parked = ");
        sb4.append(i4);
        sb4.append(", dormant = ");
        sb4.append(i5);
        sb4.append(", terminated = ");
        sb4.append(i6);
        sb4.append("}, running workers queues = ");
        sb4.append(arrayList);
        sb4.append(", global CPU queue size = ");
        sb4.append(this.f1105f.c());
        sb4.append(", global blocking queue size = ");
        sb4.append(this.f1106g.c());
        sb4.append(", Control State {created workers= ");
        sb4.append((int) (2097151 & j2));
        sb4.append(", blocking tasks = ");
        sb4.append((int) ((4398044413952L & j2) >> 21));
        sb4.append(", CPUs acquired = ");
        sb4.append(i9 - ((int) ((j2 & 9223367638808264704L) >> 42)));
        sb4.append("}]");
        return sb4.toString();
    }
}
