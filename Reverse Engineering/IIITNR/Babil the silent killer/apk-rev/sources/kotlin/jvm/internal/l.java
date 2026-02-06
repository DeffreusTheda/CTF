package kotlin.jvm.internal;

/* loaded from: classes.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private static final m f791a;

    /* renamed from: b, reason: collision with root package name */
    private static final n0.c[] f792b;

    static {
        m mVar = null;
        try {
            mVar = (m) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (mVar == null) {
            mVar = new m();
        }
        f791a = mVar;
        f792b = new n0.c[0];
    }

    public static n0.e a(g gVar) {
        return f791a.a(gVar);
    }

    public static n0.c b(Class cls) {
        return f791a.b(cls);
    }

    public static n0.d c(Class cls) {
        return f791a.c(cls, "");
    }

    public static String d(f fVar) {
        return f791a.d(fVar);
    }

    public static String e(j jVar) {
        return f791a.e(jVar);
    }
}
