package m0;

/* loaded from: classes.dex */
public final class c extends m0.a {

    /* renamed from: h, reason: collision with root package name */
    public static final a f946h = new a(null);

    /* renamed from: i, reason: collision with root package name */
    private static final c f947i = new c(1, 0);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.e eVar) {
            this();
        }

        public final c a() {
            return c.f947i;
        }
    }

    public c(int i2, int i3) {
        super(i2, i3, 1);
    }

    @Override // m0.a
    public boolean equals(Object obj) {
        if (obj instanceof c) {
            if (!isEmpty() || !((c) obj).isEmpty()) {
                c cVar = (c) obj;
                if (a() != cVar.a() || b() != cVar.b()) {
                }
            }
            return true;
        }
        return false;
    }

    public boolean f(int i2) {
        return a() <= i2 && i2 <= b();
    }

    public Integer g() {
        return Integer.valueOf(b());
    }

    public Integer h() {
        return Integer.valueOf(a());
    }

    @Override // m0.a
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (a() * 31) + b();
    }

    @Override // m0.a
    public boolean isEmpty() {
        return a() > b();
    }

    @Override // m0.a
    public String toString() {
        return a() + ".." + b();
    }
}
