package h0;

/* renamed from: h0.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0053m extends a0.i implements Z.p {

    /* renamed from: d, reason: collision with root package name */
    public static final C0053m f567d = new C0053m(2, 0);

    /* renamed from: e, reason: collision with root package name */
    public static final C0053m f568e = new C0053m(2, 1);

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f569c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0053m(int i2, int i3) {
        super(i2);
        this.f569c = i3;
    }

    @Override // Z.p
    public final Object d(Object obj, Object obj2) {
        switch (this.f569c) {
            case 0:
                return ((S.i) obj).e((S.g) obj2);
            case 1:
                Boolean bool = (Boolean) obj;
                bool.getClass();
                return bool;
            default:
                return ((S.i) obj).e((S.g) obj2);
        }
    }
}
