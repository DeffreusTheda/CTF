package q0;

/* loaded from: classes.dex */
public final class n {
    public static final <T> l<T> a(c0.d<? super T> dVar) {
        if (!(dVar instanceof kotlinx.coroutines.internal.g)) {
            return new l<>(dVar, 1);
        }
        l<T> j2 = ((kotlinx.coroutines.internal.g) dVar).j();
        if (j2 == null || !j2.G()) {
            j2 = null;
        }
        return j2 == null ? new l<>(dVar, 2) : j2;
    }
}
