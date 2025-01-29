package h0;

/* loaded from: classes.dex */
public abstract class a0 {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f546a = new ThreadLocal();

    public static D a() {
        ThreadLocal threadLocal = f546a;
        D d2 = (D) threadLocal.get();
        if (d2 != null) {
            return d2;
        }
        C0043c c0043c = new C0043c(Thread.currentThread());
        threadLocal.set(c0043c);
        return c0043c;
    }
}
