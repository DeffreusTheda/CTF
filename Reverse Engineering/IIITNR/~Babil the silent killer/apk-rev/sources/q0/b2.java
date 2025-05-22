package q0;

/* loaded from: classes.dex */
public final class b2 extends e0 {

    /* renamed from: e, reason: collision with root package name */
    public static final b2 f997e = new b2();

    private b2() {
    }

    @Override // q0.e0
    public void k(c0.g gVar, Runnable runnable) {
        e2 e2Var = (e2) gVar.get(e2.f1006e);
        if (e2Var == null) {
            throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
        }
        e2Var.f1007d = true;
    }

    @Override // q0.e0
    public boolean l(c0.g gVar) {
        return false;
    }

    @Override // q0.e0
    public String toString() {
        return "Dispatchers.Unconfined";
    }
}
