package kotlinx.coroutines.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final /* synthetic */ class b0 {
    public static final int a(String str, int i2, int i3, int i4) {
        return (int) z.c(str, i2, i3, i4);
    }

    public static final long b(String str, long j2, long j3, long j4) {
        Long h2;
        String d2 = z.d(str);
        if (d2 == null) {
            return j2;
        }
        h2 = p0.l.h(d2);
        if (h2 == null) {
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + d2 + '\'').toString());
        }
        long longValue = h2.longValue();
        boolean z2 = false;
        if (j3 <= longValue && longValue <= j4) {
            z2 = true;
        }
        if (z2) {
            return longValue;
        }
        throw new IllegalStateException(("System property '" + str + "' should be in range " + j3 + ".." + j4 + ", but is '" + longValue + '\'').toString());
    }

    public static final boolean c(String str, boolean z2) {
        String d2 = z.d(str);
        return d2 == null ? z2 : Boolean.parseBoolean(d2);
    }

    public static /* synthetic */ int d(String str, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            i3 = 1;
        }
        if ((i5 & 8) != 0) {
            i4 = Integer.MAX_VALUE;
        }
        return z.b(str, i2, i3, i4);
    }

    public static /* synthetic */ long e(String str, long j2, long j3, long j4, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            j3 = 1;
        }
        long j5 = j3;
        if ((i2 & 8) != 0) {
            j4 = Long.MAX_VALUE;
        }
        return z.c(str, j2, j5, j4);
    }
}
