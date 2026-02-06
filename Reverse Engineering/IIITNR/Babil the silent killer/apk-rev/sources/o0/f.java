package o0;

import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends e {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> implements b<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterator f971a;

        public a(Iterator it) {
            this.f971a = it;
        }

        @Override // o0.b
        public Iterator<T> iterator() {
            return this.f971a;
        }
    }

    public static <T> b<T> a(Iterator<? extends T> it) {
        kotlin.jvm.internal.i.e(it, "<this>");
        return b(new a(it));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> b<T> b(b<? extends T> bVar) {
        kotlin.jvm.internal.i.e(bVar, "<this>");
        return bVar instanceof o0.a ? bVar : new o0.a(bVar);
    }
}
