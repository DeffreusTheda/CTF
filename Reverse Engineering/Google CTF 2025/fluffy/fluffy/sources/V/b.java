package v;

import w.InterfaceC0103a;

/* loaded from: classes.dex */
public final class b implements h {

    /* renamed from: d, reason: collision with root package name */
    public static final b f1177d;

    /* renamed from: e, reason: collision with root package name */
    public static final b f1178e;

    /* renamed from: f, reason: collision with root package name */
    public static final b f1179f;

    /* renamed from: g, reason: collision with root package name */
    public static final b f1180g;

    /* renamed from: h, reason: collision with root package name */
    public static final b f1181h;

    /* renamed from: i, reason: collision with root package name */
    public static final b f1182i;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f1183b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f1184c;

    static {
        int i2 = 0;
        f1177d = new b("NONE", i2);
        f1178e = new b("FULL", i2);
        int i3 = 1;
        f1179f = new b("FLAT", i3);
        f1180g = new b("HALF_OPENED", i3);
        int i4 = 2;
        f1181h = new b("FOLD", i4);
        f1182i = new b("HINGE", i4);
    }

    public /* synthetic */ b(String str, int i2) {
        this.f1183b = i2;
        this.f1184c = str;
    }

    public String toString() {
        switch (this.f1183b) {
            case 0:
                return (String) this.f1184c;
            case 1:
                return (String) this.f1184c;
            case 2:
                return (String) this.f1184c;
            default:
                return super.toString();
        }
    }

    public b(InterfaceC0103a interfaceC0103a) {
        this.f1183b = 3;
        int i2 = o.f1209b;
        this.f1184c = interfaceC0103a;
    }
}
