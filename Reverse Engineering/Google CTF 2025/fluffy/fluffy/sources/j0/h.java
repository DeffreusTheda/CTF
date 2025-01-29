package j0;

/* loaded from: classes.dex */
public final class h extends i {

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f907a;

    public h(Throwable th) {
        this.f907a = th;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof h) {
            if (a0.h.a(this.f907a, ((h) obj).f907a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        Throwable th = this.f907a;
        if (th != null) {
            return th.hashCode();
        }
        return 0;
    }

    @Override // j0.i
    public final String toString() {
        return "Closed(" + this.f907a + ')';
    }
}
