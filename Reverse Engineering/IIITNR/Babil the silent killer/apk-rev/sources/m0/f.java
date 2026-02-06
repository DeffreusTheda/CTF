package m0;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends e {
    public static int a(int i2, int i3) {
        return i2 < i3 ? i3 : i2;
    }

    public static long b(long j2, long j3) {
        return j2 < j3 ? j3 : j2;
    }

    public static int c(int i2, int i3) {
        return i2 > i3 ? i3 : i2;
    }

    public static long d(long j2, long j3) {
        return j2 > j3 ? j3 : j2;
    }

    public static int e(int i2, int i3, int i4) {
        if (i3 <= i4) {
            return i2 < i3 ? i3 : i2 > i4 ? i4 : i2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i4 + " is less than minimum " + i3 + '.');
    }

    public static a f(int i2, int i3) {
        return a.f938g.a(i2, i3, -1);
    }

    public static c g(int i2, int i3) {
        return i3 <= Integer.MIN_VALUE ? c.f946h.a() : new c(i2, i3 - 1);
    }
}
