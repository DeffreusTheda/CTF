package q0;

/* loaded from: classes.dex */
final class t0 implements e1 {

    /* renamed from: d, reason: collision with root package name */
    private final boolean f1062d;

    public t0(boolean z2) {
        this.f1062d = z2;
    }

    @Override // q0.e1
    public boolean a() {
        return this.f1062d;
    }

    @Override // q0.e1
    public u1 c() {
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empty{");
        sb.append(a() ? "Active" : "New");
        sb.append('}');
        return sb.toString();
    }
}
