package h0;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* renamed from: h0.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0051k {

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f563b = AtomicIntegerFieldUpdater.newUpdater(C0051k.class, "_handled");
    private volatile int _handled;

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f564a;

    public C0051k(Throwable th, boolean z2) {
        this.f564a = th;
        this._handled = z2 ? 1 : 0;
    }

    public final String toString() {
        return getClass().getSimpleName() + '[' + this.f564a + ']';
    }
}
