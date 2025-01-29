package m0;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public abstract class b extends r {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f995a = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_consensus");
    private volatile Object _consensus = AbstractC0081a.f989a;

    @Override // m0.r
    public final Object a(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f995a;
        Object obj2 = atomicReferenceFieldUpdater.get(this);
        io.flutter.plugin.platform.i iVar = AbstractC0081a.f989a;
        if (obj2 == iVar) {
            io.flutter.plugin.platform.i c2 = c(obj);
            obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 == iVar) {
                while (true) {
                    if (atomicReferenceFieldUpdater.compareAndSet(this, iVar, c2)) {
                        obj2 = c2;
                        break;
                    }
                    if (atomicReferenceFieldUpdater.get(this) != iVar) {
                        obj2 = atomicReferenceFieldUpdater.get(this);
                        break;
                    }
                }
            }
        }
        b(obj, obj2);
        return obj2;
    }

    public abstract void b(Object obj, Object obj2);

    public abstract io.flutter.plugin.platform.i c(Object obj);
}
