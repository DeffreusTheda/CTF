package q0;

/* loaded from: classes.dex */
public abstract class u0 extends e0 {

    /* renamed from: e, reason: collision with root package name */
    private long f1064e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f1065f;

    /* renamed from: g, reason: collision with root package name */
    private kotlinx.coroutines.internal.a<o0<?>> f1066g;

    private final long r(boolean z2) {
        return z2 ? 4294967296L : 1L;
    }

    public static /* synthetic */ void v(u0 u0Var, boolean z2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
        }
        if ((i2 & 1) != 0) {
            z2 = false;
        }
        u0Var.u(z2);
    }

    public final void p(boolean z2) {
        long r2 = this.f1064e - r(z2);
        this.f1064e = r2;
        if (r2 <= 0 && this.f1065f) {
            z();
        }
    }

    public final void s(o0<?> o0Var) {
        kotlinx.coroutines.internal.a<o0<?>> aVar = this.f1066g;
        if (aVar == null) {
            aVar = new kotlinx.coroutines.internal.a<>();
            this.f1066g = aVar;
        }
        aVar.a(o0Var);
    }

    protected long t() {
        kotlinx.coroutines.internal.a<o0<?>> aVar = this.f1066g;
        return (aVar == null || aVar.c()) ? Long.MAX_VALUE : 0L;
    }

    public final void u(boolean z2) {
        this.f1064e += r(z2);
        if (z2) {
            return;
        }
        this.f1065f = true;
    }

    public final boolean w() {
        return this.f1064e >= r(true);
    }

    public final boolean x() {
        kotlinx.coroutines.internal.a<o0<?>> aVar = this.f1066g;
        if (aVar == null) {
            return true;
        }
        return aVar.c();
    }

    public final boolean y() {
        o0<?> d2;
        kotlinx.coroutines.internal.a<o0<?>> aVar = this.f1066g;
        if (aVar == null || (d2 = aVar.d()) == null) {
            return false;
        }
        d2.run();
        return true;
    }

    protected void z() {
    }
}
