package b0;

import java.util.Set;

/* loaded from: classes.dex */
class e0 extends d0 {
    public static <T> Set<T> b() {
        return u.f132d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Set<T> c(Set<? extends T> set) {
        Set<T> b2;
        kotlin.jvm.internal.i.e(set, "<this>");
        int size = set.size();
        if (size != 0) {
            return size != 1 ? set : d0.a(set.iterator().next());
        }
        b2 = b();
        return b2;
    }
}
