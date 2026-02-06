package kotlinx.coroutines.internal;

import a0.k;

/* loaded from: classes.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    private static final String f853a;

    /* renamed from: b, reason: collision with root package name */
    private static final String f854b;

    static {
        Object a2;
        Object a3;
        try {
            k.a aVar = a0.k.f16d;
            a2 = a0.k.a(Class.forName("kotlin.coroutines.jvm.internal.a").getCanonicalName());
        } catch (Throwable th) {
            k.a aVar2 = a0.k.f16d;
            a2 = a0.k.a(a0.l.a(th));
        }
        if (a0.k.b(a2) != null) {
            a2 = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        f853a = (String) a2;
        try {
            k.a aVar3 = a0.k.f16d;
            a3 = a0.k.a(x.class.getCanonicalName());
        } catch (Throwable th2) {
            k.a aVar4 = a0.k.f16d;
            a3 = a0.k.a(a0.l.a(th2));
        }
        if (a0.k.b(a3) != null) {
            a3 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
        f854b = (String) a3;
    }

    public static final <E extends Throwable> E a(E e2) {
        return e2;
    }
}
