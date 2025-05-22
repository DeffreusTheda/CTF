package q0;

import a0.k;

/* loaded from: classes.dex */
public final class l0 {
    public static final String a(Object obj) {
        return obj.getClass().getSimpleName();
    }

    public static final String b(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final String c(c0.d<?> dVar) {
        Object a2;
        if (dVar instanceof kotlinx.coroutines.internal.g) {
            return dVar.toString();
        }
        try {
            k.a aVar = a0.k.f16d;
            a2 = a0.k.a(dVar + '@' + b(dVar));
        } catch (Throwable th) {
            k.a aVar2 = a0.k.f16d;
            a2 = a0.k.a(a0.l.a(th));
        }
        if (a0.k.b(a2) != null) {
            a2 = ((Object) dVar.getClass().getName()) + '@' + b(dVar);
        }
        return (String) a2;
    }
}
