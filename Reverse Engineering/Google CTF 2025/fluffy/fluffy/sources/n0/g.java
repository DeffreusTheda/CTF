package n0;

import h0.E;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* loaded from: classes.dex */
public abstract class g extends E {

    /* renamed from: d, reason: collision with root package name */
    public b f1112d;

    @Override // h0.AbstractC0056p
    public final void c(S.i iVar, Runnable runnable) {
        b bVar = this.f1112d;
        AtomicLongFieldUpdater atomicLongFieldUpdater = b.f1097i;
        bVar.b(runnable, j.f1122g, false);
    }
}
