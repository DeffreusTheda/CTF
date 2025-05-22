package q0;

/* loaded from: classes.dex */
final class g1 extends i {

    /* renamed from: d, reason: collision with root package name */
    private final j0.l<Throwable, a0.q> f1011d;

    /* JADX WARN: Multi-variable type inference failed */
    public g1(j0.l<? super Throwable, a0.q> lVar) {
        this.f1011d = lVar;
    }

    @Override // q0.j
    public void a(Throwable th) {
        this.f1011d.invoke(th);
    }

    @Override // j0.l
    public /* bridge */ /* synthetic */ a0.q invoke(Throwable th) {
        a(th);
        return a0.q.f22a;
    }

    public String toString() {
        return "InvokeOnCancel[" + l0.a(this.f1011d) + '@' + l0.b(this) + ']';
    }
}
