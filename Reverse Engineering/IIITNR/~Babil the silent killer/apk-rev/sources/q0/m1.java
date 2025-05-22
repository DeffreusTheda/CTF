package q0;

/* loaded from: classes.dex */
public class m1 extends q1 implements w {

    /* renamed from: e, reason: collision with root package name */
    private final boolean f1032e;

    public m1(j1 j1Var) {
        super(true);
        S(j1Var);
        this.f1032e = t0();
    }

    private final boolean t0() {
        q O = O();
        r rVar = O instanceof r ? (r) O : null;
        if (rVar == null) {
            return false;
        }
        do {
            q1 z2 = rVar.z();
            if (z2.L()) {
                return true;
            }
            q O2 = z2.O();
            rVar = O2 instanceof r ? (r) O2 : null;
        } while (rVar != null);
        return false;
    }

    @Override // q0.q1
    public boolean L() {
        return this.f1032e;
    }

    @Override // q0.q1
    public boolean M() {
        return true;
    }
}
