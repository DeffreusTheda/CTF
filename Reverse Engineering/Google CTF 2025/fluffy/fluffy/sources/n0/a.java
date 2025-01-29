package n0;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public final class a extends Thread {

    /* renamed from: j, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f1088j = AtomicIntegerFieldUpdater.newUpdater(a.class, "workerCtl");

    /* renamed from: b, reason: collision with root package name */
    public final l f1089b;

    /* renamed from: c, reason: collision with root package name */
    public final a0.k f1090c;

    /* renamed from: d, reason: collision with root package name */
    public int f1091d;

    /* renamed from: e, reason: collision with root package name */
    public long f1092e;

    /* renamed from: f, reason: collision with root package name */
    public long f1093f;

    /* renamed from: g, reason: collision with root package name */
    public int f1094g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f1095h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ b f1096i;
    private volatile int indexInArray;
    private volatile Object nextParkedWorker;
    private volatile int workerCtl;

    public a(b bVar, int i2) {
        this.f1096i = bVar;
        setDaemon(true);
        this.f1089b = new l();
        this.f1090c = new a0.k();
        this.f1091d = 4;
        this.nextParkedWorker = b.f1100l;
        b0.e.f439b.getClass();
        this.f1094g = b0.e.f440c.a().nextInt();
        f(i2);
    }

    public final h a(boolean z2) {
        h e2;
        h e3;
        b bVar;
        long j2;
        int i2 = this.f1091d;
        h hVar = null;
        l lVar = this.f1089b;
        b bVar2 = this.f1096i;
        if (i2 != 1) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = b.f1098j;
            do {
                bVar = this.f1096i;
                j2 = atomicLongFieldUpdater.get(bVar);
                if (((int) ((9223367638808264704L & j2) >> 42)) == 0) {
                    lVar.getClass();
                    loop1: while (true) {
                        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = l.f1125b;
                        h hVar2 = (h) atomicReferenceFieldUpdater.get(lVar);
                        if (hVar2 != null && hVar2.f1114c.f30a == 1) {
                            while (!atomicReferenceFieldUpdater.compareAndSet(lVar, hVar2, null)) {
                                if (atomicReferenceFieldUpdater.get(lVar) != hVar2) {
                                    break;
                                }
                            }
                            hVar = hVar2;
                            break loop1;
                        }
                    }
                    int i3 = l.f1127d.get(lVar);
                    int i4 = l.f1126c.get(lVar);
                    while (true) {
                        if (i3 == i4 || l.f1128e.get(lVar) == 0) {
                            break;
                        }
                        i4--;
                        h c2 = lVar.c(i4, true);
                        if (c2 != null) {
                            hVar = c2;
                            break;
                        }
                    }
                    if (hVar != null) {
                        return hVar;
                    }
                    h hVar3 = (h) bVar2.f1106g.d();
                    return hVar3 == null ? i(1) : hVar3;
                }
            } while (!b.f1098j.compareAndSet(bVar, j2, j2 - 4398046511104L));
            this.f1091d = 1;
        }
        if (z2) {
            boolean z3 = d(bVar2.f1101b * 2) == 0;
            if (z3 && (e3 = e()) != null) {
                return e3;
            }
            lVar.getClass();
            h hVar4 = (h) l.f1125b.getAndSet(lVar, null);
            if (hVar4 == null) {
                hVar4 = lVar.b();
            }
            if (hVar4 != null) {
                return hVar4;
            }
            if (!z3 && (e2 = e()) != null) {
                return e2;
            }
        } else {
            h e4 = e();
            if (e4 != null) {
                return e4;
            }
        }
        return i(3);
    }

    public final int b() {
        return this.indexInArray;
    }

    public final Object c() {
        return this.nextParkedWorker;
    }

    public final int d(int i2) {
        int i3 = this.f1094g;
        int i4 = i3 ^ (i3 << 13);
        int i5 = i4 ^ (i4 >> 17);
        int i6 = i5 ^ (i5 << 5);
        this.f1094g = i6;
        int i7 = i2 - 1;
        return (i7 & i2) == 0 ? i6 & i7 : (i6 & Integer.MAX_VALUE) % i2;
    }

    public final h e() {
        int d2 = d(2);
        b bVar = this.f1096i;
        if (d2 == 0) {
            h hVar = (h) bVar.f1105f.d();
            return hVar != null ? hVar : (h) bVar.f1106g.d();
        }
        h hVar2 = (h) bVar.f1106g.d();
        return hVar2 != null ? hVar2 : (h) bVar.f1105f.d();
    }

    public final void f(int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1096i.f1104e);
        sb.append("-worker-");
        sb.append(i2 == 0 ? "TERMINATED" : String.valueOf(i2));
        setName(sb.toString());
        this.indexInArray = i2;
    }

    public final void g(Object obj) {
        this.nextParkedWorker = obj;
    }

    public final boolean h(int i2) {
        int i3 = this.f1091d;
        boolean z2 = i3 == 1;
        if (z2) {
            b.f1098j.addAndGet(this.f1096i, 4398046511104L);
        }
        if (i3 != i2) {
            this.f1091d = i2;
        }
        return z2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x0082, code lost:
    
        r19 = r6;
        r6 = -2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final n0.h i(int r24) {
        /*
            Method dump skipped, instructions count: 249
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n0.a.i(int):n0.h");
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x0004, code lost:
    
        continue;
     */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 401
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n0.a.run():void");
    }
}
