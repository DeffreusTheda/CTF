package e0;

/* loaded from: classes.dex */
public final class c {
    private static final int a(int i2, int i3, int i4) {
        return c(c(i2, i4) - c(i3, i4), i4);
    }

    public static final int b(int i2, int i3, int i4) {
        if (i4 > 0) {
            return i2 >= i3 ? i3 : i3 - a(i3, i2, i4);
        }
        if (i4 < 0) {
            return i2 <= i3 ? i3 : i3 + a(i2, i3, -i4);
        }
        throw new IllegalArgumentException("Step is zero.");
    }

    private static final int c(int i2, int i3) {
        int i4 = i2 % i3;
        return i4 >= 0 ? i4 : i4 + i3;
    }
}
