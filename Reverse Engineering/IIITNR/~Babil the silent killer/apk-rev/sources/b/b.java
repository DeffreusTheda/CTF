package b;

/* loaded from: classes.dex */
class b {

    /* renamed from: a, reason: collision with root package name */
    static final int[] f104a = new int[0];

    /* renamed from: b, reason: collision with root package name */
    static final long[] f105b = new long[0];

    /* renamed from: c, reason: collision with root package name */
    static final Object[] f106c = new Object[0];

    static int a(int[] iArr, int i2, int i3) {
        int i4 = i2 - 1;
        int i5 = 0;
        while (i5 <= i4) {
            int i6 = (i5 + i4) >>> 1;
            int i7 = iArr[i6];
            if (i7 < i3) {
                i5 = i6 + 1;
            } else {
                if (i7 <= i3) {
                    return i6;
                }
                i4 = i6 - 1;
            }
        }
        return i5 ^ (-1);
    }

    public static boolean b(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
