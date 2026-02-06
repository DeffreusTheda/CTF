package o0;

import j0.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends g {
    public static <T, R> b<R> c(b<? extends T> bVar, l<? super T, ? extends R> transform) {
        kotlin.jvm.internal.i.e(bVar, "<this>");
        kotlin.jvm.internal.i.e(transform, "transform");
        return new i(bVar, transform);
    }

    public static final <T, C extends Collection<? super T>> C d(b<? extends T> bVar, C destination) {
        kotlin.jvm.internal.i.e(bVar, "<this>");
        kotlin.jvm.internal.i.e(destination, "destination");
        Iterator<? extends T> it = bVar.iterator();
        while (it.hasNext()) {
            destination.add(it.next());
        }
        return destination;
    }

    public static <T> List<T> e(b<? extends T> bVar) {
        kotlin.jvm.internal.i.e(bVar, "<this>");
        return b0.i.e(f(bVar));
    }

    public static final <T> List<T> f(b<? extends T> bVar) {
        kotlin.jvm.internal.i.e(bVar, "<this>");
        return (List) d(bVar, new ArrayList());
    }
}
