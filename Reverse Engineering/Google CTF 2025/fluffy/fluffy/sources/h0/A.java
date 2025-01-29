package h0;

/* loaded from: classes.dex */
public final class A implements H {

    /* renamed from: b, reason: collision with root package name */
    public final boolean f515b;

    public A(boolean z2) {
        this.f515b = z2;
    }

    @Override // h0.H
    public final boolean b() {
        return this.f515b;
    }

    @Override // h0.H
    public final U c() {
        return null;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Empty{");
        sb.append(this.f515b ? "Active" : "New");
        sb.append('}');
        return sb.toString();
    }
}
