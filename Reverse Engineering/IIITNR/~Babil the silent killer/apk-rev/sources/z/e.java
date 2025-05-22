package z;

/* loaded from: classes.dex */
public final class e {
    public static void a(String str) {
        h.a.c(c(str));
    }

    public static void b(String str, int i2) {
        h.a.a(c(str), i2);
    }

    private static String c(String str) {
        if (str.length() < 124) {
            return str;
        }
        return str.substring(0, 124) + "...";
    }

    public static void d() {
        h.a.f();
    }

    public static void e(String str, int i2) {
        h.a.d(c(str), i2);
    }
}
