package h0;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import m0.AbstractC0081a;

/* loaded from: classes.dex */
public final class S extends m0.b {

    /* renamed from: b, reason: collision with root package name */
    public final O f538b;

    /* renamed from: c, reason: collision with root package name */
    public U f539c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ T f540d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ H f541e;

    public S(O o2, T t2, H h2) {
        this.f540d = t2;
        this.f541e = h2;
        this.f538b = o2;
    }

    @Override // m0.b
    public final void b(Object obj, Object obj2) {
        m0.l lVar = (m0.l) obj;
        boolean z2 = obj2 == null;
        O o2 = this.f538b;
        H h2 = z2 ? o2 : this.f539c;
        if (h2 != null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = m0.l.f1015b;
            while (!atomicReferenceFieldUpdater.compareAndSet(lVar, this, h2)) {
                if (atomicReferenceFieldUpdater.get(lVar) != this) {
                    return;
                }
            }
            if (z2) {
                U u = this.f539c;
                a0.h.b(u);
                o2.j(u);
            }
        }
    }

    @Override // m0.b
    public final io.flutter.plugin.platform.i c(Object obj) {
        if (this.f540d.y() == this.f541e) {
            return null;
        }
        return AbstractC0081a.f993e;
    }
}
