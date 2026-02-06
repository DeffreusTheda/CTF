package kotlinx.coroutines.internal;

/* loaded from: classes.dex */
final /* synthetic */ class a0 {

    /* renamed from: a, reason: collision with root package name */
    private static final int f798a = Runtime.getRuntime().availableProcessors();

    public static final int a() {
        return f798a;
    }

    public static final String b(String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }
}
