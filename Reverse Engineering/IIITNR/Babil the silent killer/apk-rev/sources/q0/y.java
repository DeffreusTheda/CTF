package q0;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: classes.dex */
public class y {

    /* renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f1082b = AtomicIntegerFieldUpdater.newUpdater(y.class, "_handled");
    private volatile /* synthetic */ int _handled;

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f1083a;

    public y(Throwable th, boolean z2) {
        this.f1083a = th;
        this._handled = z2 ? 1 : 0;
    }

    public /* synthetic */ y(Throwable th, boolean z2, int i2, kotlin.jvm.internal.e eVar) {
        this(th, (i2 & 2) != 0 ? false : z2);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean a() {
        return this._handled;
    }

    public final boolean b() {
        return f1082b.compareAndSet(this, 0, 1);
    }

    public String toString() {
        return l0.a(this) + '[' + this.f1083a + ']';
    }
}
