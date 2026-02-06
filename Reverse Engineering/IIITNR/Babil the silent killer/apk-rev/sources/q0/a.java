package q0;

/* loaded from: classes.dex */
public abstract class a<T> extends q1 implements c0.d<T>, h0 {

    /* renamed from: e, reason: collision with root package name */
    private final c0.g f991e;

    public a(c0.g gVar, boolean z2, boolean z3) {
        super(z3);
        if (z2) {
            S((j1) gVar.get(j1.f1021c));
        }
        this.f991e = gVar.plus(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // q0.q1
    public String C() {
        return kotlin.jvm.internal.i.j(l0.a(this), " was cancelled");
    }

    @Override // q0.q1
    public final void R(Throwable th) {
        g0.a(this.f991e, th);
    }

    @Override // q0.q1
    public String Y() {
        String b2 = d0.b(this.f991e);
        if (b2 == null) {
            return super.Y();
        }
        return '\"' + b2 + "\":" + super.Y();
    }

    @Override // q0.q1, q0.j1
    public boolean a() {
        return super.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // q0.q1
    protected final void d0(Object obj) {
        if (!(obj instanceof y)) {
            v0(obj);
        } else {
            y yVar = (y) obj;
            u0(yVar.f1083a, yVar.a());
        }
    }

    @Override // c0.d
    public final c0.g getContext() {
        return this.f991e;
    }

    @Override // c0.d
    public final void resumeWith(Object obj) {
        Object W = W(c0.d(obj, null, 1, null));
        if (W == r1.f1054b) {
            return;
        }
        t0(W);
    }

    @Override // q0.h0
    public c0.g s() {
        return this.f991e;
    }

    protected void t0(Object obj) {
        x(obj);
    }

    protected void u0(Throwable th, boolean z2) {
    }

    protected void v0(T t2) {
    }

    public final <R> void w0(j0 j0Var, R r2, j0.p<? super R, ? super c0.d<? super T>, ? extends Object> pVar) {
        j0Var.b(pVar, r2, this);
    }
}
