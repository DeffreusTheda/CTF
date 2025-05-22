package b0;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends y {
    public static final <K, V> Map<K, V> d() {
        t tVar = t.f131d;
        kotlin.jvm.internal.i.c(tVar, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return tVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> e(Map<K, ? extends V> map) {
        kotlin.jvm.internal.i.e(map, "<this>");
        int size = map.size();
        return size != 0 ? size != 1 ? map : y.c(map) : d();
    }

    public static final <K, V> void f(Map<? super K, ? super V> map, Iterable<? extends a0.j<? extends K, ? extends V>> pairs) {
        kotlin.jvm.internal.i.e(map, "<this>");
        kotlin.jvm.internal.i.e(pairs, "pairs");
        for (a0.j<? extends K, ? extends V> jVar : pairs) {
            map.put(jVar.a(), jVar.b());
        }
    }

    public static <K, V> Map<K, V> g(Iterable<? extends a0.j<? extends K, ? extends V>> iterable) {
        int a2;
        kotlin.jvm.internal.i.e(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return e(h(iterable, new LinkedHashMap()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return d();
        }
        if (size == 1) {
            return y.b(iterable instanceof List ? (a0.j<? extends K, ? extends V>) ((List) iterable).get(0) : iterable.iterator().next());
        }
        a2 = y.a(collection.size());
        return h(iterable, new LinkedHashMap(a2));
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M h(Iterable<? extends a0.j<? extends K, ? extends V>> iterable, M destination) {
        kotlin.jvm.internal.i.e(iterable, "<this>");
        kotlin.jvm.internal.i.e(destination, "destination");
        f(destination, iterable);
        return destination;
    }
}
