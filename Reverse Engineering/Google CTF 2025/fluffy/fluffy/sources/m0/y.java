package m0;

import D.AbstractC0009j;

/* loaded from: classes.dex */
public final class y extends a0.i implements Z.p {

    /* renamed from: d, reason: collision with root package name */
    public static final y f1037d = new y(2, 0);

    /* renamed from: e, reason: collision with root package name */
    public static final y f1038e = new y(2, 1);

    /* renamed from: f, reason: collision with root package name */
    public static final y f1039f = new y(2, 2);

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1040c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ y(int i2, int i3) {
        super(i2);
        this.f1040c = i3;
    }

    @Override // Z.p
    public final Object d(Object obj, Object obj2) {
        switch (this.f1040c) {
            case 0:
                return obj;
            case 1:
                AbstractC0009j.e(obj);
                return null;
            default:
                return (A) obj;
        }
    }
}
