package q0;

/* loaded from: classes.dex */
public abstract class t1 extends e0 {
    public abstract t1 p();

    protected final String r() {
        t1 t1Var;
        t1 c2 = r0.c();
        if (this == c2) {
            return "Dispatchers.Main";
        }
        try {
            t1Var = c2.p();
        } catch (UnsupportedOperationException unused) {
            t1Var = null;
        }
        if (this == t1Var) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }

    @Override // q0.e0
    public String toString() {
        String r2 = r();
        if (r2 != null) {
            return r2;
        }
        return l0.a(this) + '@' + l0.b(this);
    }
}
