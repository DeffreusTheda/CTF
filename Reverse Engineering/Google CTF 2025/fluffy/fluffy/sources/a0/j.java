package a0;

/* loaded from: classes.dex */
public final class j implements d {

    /* renamed from: a, reason: collision with root package name */
    public final Class f377a;

    public j(Class cls) {
        this.f377a = cls;
    }

    @Override // a0.d
    public final Class a() {
        return this.f377a;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof j) {
            if (h.a(this.f377a, ((j) obj).f377a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f377a.hashCode();
    }

    public final String toString() {
        return this.f377a + " (Kotlin reflection is not available)";
    }
}
