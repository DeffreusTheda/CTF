package s0;

/* loaded from: classes.dex */
public final class i<T> {

    /* renamed from: a, reason: collision with root package name */
    public static final b f1124a = new b(null);

    /* renamed from: b, reason: collision with root package name */
    private static final c f1125b = new c();

    public static final class a extends c {

        /* renamed from: a, reason: collision with root package name */
        public final Throwable f1126a;

        public a(Throwable th) {
            this.f1126a = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && kotlin.jvm.internal.i.a(this.f1126a, ((a) obj).f1126a);
        }

        public int hashCode() {
            Throwable th = this.f1126a;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        @Override // s0.i.c
        public String toString() {
            return "Closed(" + this.f1126a + ')';
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.e eVar) {
            this();
        }

        public final <E> Object a(Throwable th) {
            return i.b(new a(th));
        }

        public final <E> Object b() {
            return i.b(i.f1125b);
        }

        public final <E> Object c(E e2) {
            return i.b(e2);
        }
    }

    public static class c {
        public String toString() {
            return "Failed";
        }
    }

    public static <T> Object b(Object obj) {
        return obj;
    }
}
