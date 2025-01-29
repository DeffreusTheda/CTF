package a0;

/* loaded from: classes.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    public static final m f379a;

    static {
        m mVar = null;
        try {
            mVar = (m) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (mVar == null) {
            mVar = new m();
        }
        f379a = mVar;
    }

    public static e a(Class cls) {
        f379a.getClass();
        return new e(cls);
    }
}
