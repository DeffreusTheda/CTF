package b0;

import java.util.Collections;
import java.util.Set;

/* loaded from: classes.dex */
class d0 {
    public static final <T> Set<T> a(T t2) {
        Set<T> singleton = Collections.singleton(t2);
        kotlin.jvm.internal.i.d(singleton, "singleton(element)");
        return singleton;
    }
}
