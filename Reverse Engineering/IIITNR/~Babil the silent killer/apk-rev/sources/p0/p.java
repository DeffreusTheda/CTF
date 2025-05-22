package p0;

/* loaded from: classes.dex */
class p extends o {
    public static final String b0(String str, int i2) {
        int c2;
        kotlin.jvm.internal.i.e(str, "<this>");
        if (i2 >= 0) {
            c2 = m0.f.c(i2, str.length());
            String substring = str.substring(c2);
            kotlin.jvm.internal.i.d(substring, "this as java.lang.String).substring(startIndex)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i2 + " is less than zero.").toString());
    }
}
