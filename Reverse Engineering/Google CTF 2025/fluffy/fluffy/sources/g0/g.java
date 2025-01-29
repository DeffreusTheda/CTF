package g0;

import a0.h;

/* loaded from: classes.dex */
public abstract class g extends f {
    public static final int B(CharSequence charSequence) {
        h.e(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static String C(String str, String str2) {
        h.e(str2, "delimiter");
        h.e(str2, "string");
        int indexOf = str.indexOf(str2, 0);
        if (indexOf == -1) {
            return str;
        }
        String substring = str.substring(str2.length() + indexOf, str.length());
        h.d(substring, "substring(...)");
        return substring;
    }

    public static String D(String str) {
        int lastIndexOf = str.lastIndexOf(46, B(str));
        if (lastIndexOf == -1) {
            return str;
        }
        String substring = str.substring(lastIndexOf + 1, str.length());
        h.d(substring, "substring(...)");
        return substring;
    }
}
