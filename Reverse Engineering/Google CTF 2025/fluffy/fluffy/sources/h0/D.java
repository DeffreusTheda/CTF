package h0;

/* loaded from: classes.dex */
public abstract class D extends AbstractC0056p {

    /* renamed from: d, reason: collision with root package name */
    public long f519d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f520e;

    /* renamed from: f, reason: collision with root package name */
    public R.c f521f;

    public final void i() {
        long j2 = this.f519d - 4294967296L;
        this.f519d = j2;
        if (j2 <= 0 && this.f520e) {
            m();
        }
    }

    public abstract Thread j();

    public final void k(boolean z2) {
        this.f519d = (z2 ? 4294967296L : 1L) + this.f519d;
        if (z2) {
            return;
        }
        this.f520e = true;
    }

    public final boolean l() {
        R.c cVar = this.f521f;
        if (cVar == null) {
            return false;
        }
        AbstractC0063x abstractC0063x = (AbstractC0063x) (cVar.isEmpty() ? null : cVar.removeFirst());
        if (abstractC0063x == null) {
            return false;
        }
        abstractC0063x.run();
        return true;
    }

    public abstract void m();
}
