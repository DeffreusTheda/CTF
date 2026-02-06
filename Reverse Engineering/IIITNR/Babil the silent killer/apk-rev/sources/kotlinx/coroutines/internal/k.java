package kotlinx.coroutines.internal;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class k<E> {
    public static <E> Object a(Object obj) {
        return obj;
    }

    public static /* synthetic */ Object b(Object obj, int i2, kotlin.jvm.internal.e eVar) {
        if ((i2 & 1) != 0) {
            obj = null;
        }
        return a(obj);
    }

    public static final Object c(Object obj, E e2) {
        if (obj == null) {
            return a(e2);
        }
        if (obj instanceof ArrayList) {
            ((ArrayList) obj).add(e2);
            return a(obj);
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(e2);
        return a(arrayList);
    }
}
