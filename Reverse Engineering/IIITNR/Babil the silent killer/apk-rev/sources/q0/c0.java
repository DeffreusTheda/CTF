package q0;

import a0.k;

/* loaded from: classes.dex */
public final class c0 {
    public static final <T> Object a(Object obj, c0.d<? super T> dVar) {
        if (obj instanceof y) {
            k.a aVar = a0.k.f16d;
            obj = a0.l.a(((y) obj).f1083a);
        } else {
            k.a aVar2 = a0.k.f16d;
        }
        return a0.k.a(obj);
    }

    public static final <T> Object b(Object obj, j0.l<? super Throwable, a0.q> lVar) {
        Throwable b2 = a0.k.b(obj);
        return b2 == null ? lVar != null ? new z(obj, lVar) : obj : new y(b2, false, 2, null);
    }

    public static final <T> Object c(Object obj, k<?> kVar) {
        Throwable b2 = a0.k.b(obj);
        return b2 == null ? obj : new y(b2, false, 2, null);
    }

    public static /* synthetic */ Object d(Object obj, j0.l lVar, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            lVar = null;
        }
        return b(obj, lVar);
    }
}
