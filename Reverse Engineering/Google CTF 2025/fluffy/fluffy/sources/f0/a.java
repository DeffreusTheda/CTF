package f0;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class a implements b {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference f508a;

    public a(e eVar) {
        this.f508a = new AtomicReference(eVar);
    }

    @Override // f0.b
    public final Iterator iterator() {
        b bVar = (b) this.f508a.getAndSet(null);
        if (bVar != null) {
            return bVar.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
