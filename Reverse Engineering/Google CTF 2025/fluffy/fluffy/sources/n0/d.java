package n0;

/* loaded from: classes.dex */
public final class d extends g {

    /* renamed from: e, reason: collision with root package name */
    public static final d f1110e;

    static {
        int i2 = j.f1118c;
        int i3 = j.f1119d;
        long j2 = j.f1120e;
        String str = j.f1116a;
        d dVar = new d();
        dVar.f1112d = new b(i2, i3, j2, str);
        f1110e = dVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // h0.AbstractC0056p
    public final String toString() {
        return "Dispatchers.Default";
    }
}
