package kotlinx.coroutines.internal;

import a0.k;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f824a;

    static {
        Object a2;
        try {
            k.a aVar = a0.k.f16d;
            a2 = a0.k.a(Class.forName("android.os.Build"));
        } catch (Throwable th) {
            k.a aVar2 = a0.k.f16d;
            a2 = a0.k.a(a0.l.a(th));
        }
        f824a = a0.k.d(a2);
    }

    public static final boolean a() {
        return f824a;
    }
}
