package q0;

/* loaded from: classes.dex */
public abstract class p1 extends a0 implements s0, e1 {

    /* renamed from: g, reason: collision with root package name */
    public q1 f1037g;

    public final void A(q1 q1Var) {
        this.f1037g = q1Var;
    }

    @Override // q0.e1
    public boolean a() {
        return true;
    }

    @Override // q0.s0
    public void b() {
        z().h0(this);
    }

    @Override // q0.e1
    public u1 c() {
        return null;
    }

    @Override // kotlinx.coroutines.internal.n
    public String toString() {
        return l0.a(this) + '@' + l0.b(this) + "[job@" + l0.b(z()) + ']';
    }

    public final q1 z() {
        q1 q1Var = this.f1037g;
        if (q1Var != null) {
            return q1Var;
        }
        kotlin.jvm.internal.i.o("job");
        return null;
    }
}
