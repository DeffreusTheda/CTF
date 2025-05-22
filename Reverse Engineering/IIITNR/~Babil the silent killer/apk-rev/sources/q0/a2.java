package q0;

/* loaded from: classes.dex */
public final class a2 {

    /* renamed from: a, reason: collision with root package name */
    public static final a2 f994a = new a2();

    /* renamed from: b, reason: collision with root package name */
    private static final ThreadLocal<u0> f995b = new ThreadLocal<>();

    private a2() {
    }

    public final u0 a() {
        ThreadLocal<u0> threadLocal = f995b;
        u0 u0Var = threadLocal.get();
        if (u0Var != null) {
            return u0Var;
        }
        u0 a2 = x0.a();
        threadLocal.set(a2);
        return a2;
    }

    public final void b() {
        f995b.set(null);
    }

    public final void c(u0 u0Var) {
        f995b.set(u0Var);
    }
}
