package m0;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f997a = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "_next");

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f998b = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "_prev");
    private volatile Object _next;
    private volatile Object _prev;

    public d(v vVar) {
        this._prev = vVar;
    }

    public final void a() {
        f998b.lazySet(this, null);
    }

    public final d b() {
        Object obj = f997a.get(this);
        if (obj == AbstractC0081a.f990b) {
            return null;
        }
        return (d) obj;
    }

    public abstract boolean c();

    public final void d() {
        d b2;
        if (b() == null) {
            return;
        }
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f998b;
            d dVar = (d) atomicReferenceFieldUpdater.get(this);
            while (dVar != null && dVar.c()) {
                dVar = (d) atomicReferenceFieldUpdater.get(dVar);
            }
            d b3 = b();
            a0.h.b(b3);
            while (b3.c() && (b2 = b3.b()) != null) {
                b3 = b2;
            }
            while (true) {
                Object obj = atomicReferenceFieldUpdater.get(b3);
                d dVar2 = ((d) obj) == null ? null : dVar;
                while (!atomicReferenceFieldUpdater.compareAndSet(b3, obj, dVar2)) {
                    if (atomicReferenceFieldUpdater.get(b3) != obj) {
                        break;
                    }
                }
            }
            if (dVar != null) {
                f997a.set(dVar, b3);
            }
            if (!b3.c() || b3.b() == null) {
                if (dVar == null || !dVar.c()) {
                    return;
                }
            }
        }
    }
}
