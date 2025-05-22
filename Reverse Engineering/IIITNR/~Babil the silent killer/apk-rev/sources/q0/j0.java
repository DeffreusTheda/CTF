package q0;

/* loaded from: classes.dex */
public enum j0 {
    DEFAULT,
    LAZY,
    ATOMIC,
    UNDISPATCHED;

    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1020a;

        static {
            int[] iArr = new int[j0.values().length];
            iArr[j0.DEFAULT.ordinal()] = 1;
            iArr[j0.ATOMIC.ordinal()] = 2;
            iArr[j0.UNDISPATCHED.ordinal()] = 3;
            iArr[j0.LAZY.ordinal()] = 4;
            f1020a = iArr;
        }
    }

    public final <R, T> void b(j0.p<? super R, ? super c0.d<? super T>, ? extends Object> pVar, R r2, c0.d<? super T> dVar) {
        int i2 = a.f1020a[ordinal()];
        if (i2 == 1) {
            v0.a.e(pVar, r2, dVar, null, 4, null);
            return;
        }
        if (i2 == 2) {
            c0.f.a(pVar, r2, dVar);
        } else if (i2 == 3) {
            v0.b.a(pVar, r2, dVar);
        } else if (i2 != 4) {
            throw new a0.i();
        }
    }

    public final boolean c() {
        return this == LAZY;
    }
}
