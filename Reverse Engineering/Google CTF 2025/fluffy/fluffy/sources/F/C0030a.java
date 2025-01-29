package f;

import java.util.concurrent.CancellationException;

/* renamed from: f.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0030a {

    /* renamed from: b, reason: collision with root package name */
    public static final C0030a f488b;

    /* renamed from: c, reason: collision with root package name */
    public static final C0030a f489c;

    /* renamed from: a, reason: collision with root package name */
    public final CancellationException f490a;

    static {
        if (AbstractFutureC0036g.f501d) {
            f489c = null;
            f488b = null;
        } else {
            f489c = new C0030a(false, null);
            f488b = new C0030a(true, null);
        }
    }

    public C0030a(boolean z2, CancellationException cancellationException) {
        this.f490a = cancellationException;
    }
}
