package q0;

/* loaded from: classes.dex */
public final class r extends l1 implements q {

    /* renamed from: h, reason: collision with root package name */
    public final s f1048h;

    public r(s sVar) {
        this.f1048h = sVar;
    }

    @Override // q0.q
    public boolean g(Throwable th) {
        return z().D(th);
    }

    @Override // q0.q
    public j1 getParent() {
        return z();
    }

    @Override // j0.l
    public /* bridge */ /* synthetic */ a0.q invoke(Throwable th) {
        y(th);
        return a0.q.f22a;
    }

    @Override // q0.a0
    public void y(Throwable th) {
        this.f1048h.o(z());
    }
}
