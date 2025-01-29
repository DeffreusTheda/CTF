package c;

import java.util.concurrent.Executors;

/* renamed from: c.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0019a extends a.a {

    /* renamed from: f, reason: collision with root package name */
    public static volatile C0019a f441f;

    /* renamed from: e, reason: collision with root package name */
    public final Object f442e;

    public C0019a(int i2) {
        switch (i2) {
            case 1:
                this.f442e = new Object();
                Executors.newFixedThreadPool(4, new b());
                break;
            default:
                this.f442e = new C0019a(1);
                break;
        }
    }
}
