package m0;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f1018a = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "_cur");
    private volatile Object _cur = new o(8, false);

    public final boolean a(Runnable runnable) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1018a;
            o oVar = (o) atomicReferenceFieldUpdater.get(this);
            int a2 = oVar.a(runnable);
            if (a2 == 0) {
                return true;
            }
            if (a2 == 1) {
                o c2 = oVar.c();
                while (!atomicReferenceFieldUpdater.compareAndSet(this, oVar, c2) && atomicReferenceFieldUpdater.get(this) == oVar) {
                }
            } else if (a2 == 2) {
                return false;
            }
        }
    }

    public final void b() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1018a;
            o oVar = (o) atomicReferenceFieldUpdater.get(this);
            if (oVar.b()) {
                return;
            }
            o c2 = oVar.c();
            while (!atomicReferenceFieldUpdater.compareAndSet(this, oVar, c2) && atomicReferenceFieldUpdater.get(this) == oVar) {
            }
        }
    }

    public final int c() {
        o oVar = (o) f1018a.get(this);
        oVar.getClass();
        long j2 = o.f1021f.get(oVar);
        return 1073741823 & (((int) ((j2 & 1152921503533105152L) >> 30)) - ((int) (1073741823 & j2)));
    }

    public final Object d() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1018a;
            o oVar = (o) atomicReferenceFieldUpdater.get(this);
            Object d2 = oVar.d();
            if (d2 != o.f1022g) {
                return d2;
            }
            o c2 = oVar.c();
            while (!atomicReferenceFieldUpdater.compareAndSet(this, oVar, c2) && atomicReferenceFieldUpdater.get(this) == oVar) {
            }
        }
    }
}
