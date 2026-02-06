package o0;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class a<T> implements b<T> {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicReference<b<T>> f970a;

    public a(b<? extends T> sequence) {
        kotlin.jvm.internal.i.e(sequence, "sequence");
        this.f970a = new AtomicReference<>(sequence);
    }

    @Override // o0.b
    public Iterator<T> iterator() {
        b<T> andSet = this.f970a.getAndSet(null);
        if (andSet != null) {
            return andSet.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
