package h0;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* renamed from: h0.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0046f extends C0051k {

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f556c = AtomicIntegerFieldUpdater.newUpdater(C0046f.class, "_resumed");
    private volatile int _resumed;

    public C0046f(C0045e c0045e, Throwable th, boolean z2) {
        super(th, z2);
        this._resumed = 0;
    }
}
