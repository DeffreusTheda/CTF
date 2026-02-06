package q0;

/* loaded from: classes.dex */
public interface k<T> extends c0.d<T> {

    public static final class a {
        public static /* synthetic */ Object a(k kVar, Object obj, Object obj2, int i2, Object obj3) {
            if (obj3 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryResume");
            }
            if ((i2 & 2) != 0) {
                obj2 = null;
            }
            return kVar.g(obj, obj2);
        }
    }

    void e(j0.l<? super Throwable, a0.q> lVar);

    Object g(T t2, Object obj);

    Object k(T t2, Object obj, j0.l<? super Throwable, a0.q> lVar);

    void l(T t2, j0.l<? super Throwable, a0.q> lVar);

    Object p(Throwable th);

    void r(Object obj);
}
