package p0;

import b0.v;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends m {

    static final class a extends kotlin.jvm.internal.j implements j0.p<CharSequence, Integer, a0.j<? extends Integer, ? extends Integer>> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List<String> f988d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f989e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(List<String> list, boolean z2) {
            super(2);
            this.f988d = list;
            this.f989e = z2;
        }

        public final a0.j<Integer, Integer> a(CharSequence $receiver, int i2) {
            kotlin.jvm.internal.i.e($receiver, "$this$$receiver");
            a0.j s2 = n.s($receiver, this.f988d, i2, this.f989e, false);
            if (s2 != null) {
                return a0.n.a(s2.c(), Integer.valueOf(((String) s2.d()).length()));
            }
            return null;
        }

        @Override // j0.p
        public /* bridge */ /* synthetic */ a0.j<? extends Integer, ? extends Integer> invoke(CharSequence charSequence, Integer num) {
            return a(charSequence, num.intValue());
        }
    }

    static final class b extends kotlin.jvm.internal.j implements j0.l<m0.c, String> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CharSequence f990d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(CharSequence charSequence) {
            super(1);
            this.f990d = charSequence;
        }

        @Override // j0.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke(m0.c it) {
            kotlin.jvm.internal.i.e(it, "it");
            return n.P(this.f990d, it);
        }
    }

    public static /* synthetic */ int A(CharSequence charSequence, String str, int i2, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z2 = false;
        }
        return w(charSequence, str, i2, z2);
    }

    public static final int B(CharSequence charSequence, char[] chars, int i2, boolean z2) {
        int a2;
        boolean z3;
        kotlin.jvm.internal.i.e(charSequence, "<this>");
        kotlin.jvm.internal.i.e(chars, "chars");
        if (!z2 && chars.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(b0.e.f(chars), i2);
        }
        a2 = m0.f.a(i2, 0);
        v it = new m0.c(a2, u(charSequence)).iterator();
        while (it.hasNext()) {
            int a3 = it.a();
            char charAt = charSequence.charAt(a3);
            int length = chars.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    z3 = false;
                    break;
                }
                if (p0.b.d(chars[i3], charAt, z2)) {
                    z3 = true;
                    break;
                }
                i3++;
            }
            if (z3) {
                return a3;
            }
        }
        return -1;
    }

    public static final int C(CharSequence charSequence, char c2, int i2, boolean z2) {
        kotlin.jvm.internal.i.e(charSequence, "<this>");
        return (z2 || !(charSequence instanceof String)) ? G(charSequence, new char[]{c2}, i2, z2) : ((String) charSequence).lastIndexOf(c2, i2);
    }

    public static final int D(CharSequence charSequence, String string, int i2, boolean z2) {
        kotlin.jvm.internal.i.e(charSequence, "<this>");
        kotlin.jvm.internal.i.e(string, "string");
        return (z2 || !(charSequence instanceof String)) ? x(charSequence, string, i2, 0, z2, true) : ((String) charSequence).lastIndexOf(string, i2);
    }

    public static /* synthetic */ int E(CharSequence charSequence, char c2, int i2, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = u(charSequence);
        }
        if ((i3 & 4) != 0) {
            z2 = false;
        }
        return C(charSequence, c2, i2, z2);
    }

    public static /* synthetic */ int F(CharSequence charSequence, String str, int i2, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = u(charSequence);
        }
        if ((i3 & 4) != 0) {
            z2 = false;
        }
        return D(charSequence, str, i2, z2);
    }

    public static final int G(CharSequence charSequence, char[] chars, int i2, boolean z2) {
        int c2;
        kotlin.jvm.internal.i.e(charSequence, "<this>");
        kotlin.jvm.internal.i.e(chars, "chars");
        if (!z2 && chars.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(b0.e.f(chars), i2);
        }
        for (c2 = m0.f.c(i2, u(charSequence)); -1 < c2; c2--) {
            char charAt = charSequence.charAt(c2);
            int length = chars.length;
            boolean z3 = false;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                if (p0.b.d(chars[i3], charAt, z2)) {
                    z3 = true;
                    break;
                }
                i3++;
            }
            if (z3) {
                return c2;
            }
        }
        return -1;
    }

    public static final o0.b<String> H(CharSequence charSequence) {
        kotlin.jvm.internal.i.e(charSequence, "<this>");
        return O(charSequence, new String[]{"\r\n", "\n", "\r"}, false, 0, 6, null);
    }

    public static final List<String> I(CharSequence charSequence) {
        List<String> e2;
        kotlin.jvm.internal.i.e(charSequence, "<this>");
        e2 = o0.h.e(H(charSequence));
        return e2;
    }

    private static final o0.b<m0.c> J(CharSequence charSequence, String[] strArr, int i2, boolean z2, int i3) {
        List a2;
        M(i3);
        a2 = b0.d.a(strArr);
        return new c(charSequence, i2, i3, new a(a2, z2));
    }

    static /* synthetic */ o0.b K(CharSequence charSequence, String[] strArr, int i2, boolean z2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            z2 = false;
        }
        if ((i4 & 8) != 0) {
            i3 = 0;
        }
        return J(charSequence, strArr, i2, z2, i3);
    }

    public static final boolean L(CharSequence charSequence, int i2, CharSequence other, int i3, int i4, boolean z2) {
        kotlin.jvm.internal.i.e(charSequence, "<this>");
        kotlin.jvm.internal.i.e(other, "other");
        if (i3 < 0 || i2 < 0 || i2 > charSequence.length() - i4 || i3 > other.length() - i4) {
            return false;
        }
        for (int i5 = 0; i5 < i4; i5++) {
            if (!p0.b.d(charSequence.charAt(i2 + i5), other.charAt(i3 + i5), z2)) {
                return false;
            }
        }
        return true;
    }

    public static final void M(int i2) {
        if (i2 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2).toString());
    }

    public static final o0.b<String> N(CharSequence charSequence, String[] delimiters, boolean z2, int i2) {
        o0.b<String> c2;
        kotlin.jvm.internal.i.e(charSequence, "<this>");
        kotlin.jvm.internal.i.e(delimiters, "delimiters");
        c2 = o0.h.c(K(charSequence, delimiters, 0, z2, i2, 2, null), new b(charSequence));
        return c2;
    }

    public static /* synthetic */ o0.b O(CharSequence charSequence, String[] strArr, boolean z2, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return N(charSequence, strArr, z2, i2);
    }

    public static final String P(CharSequence charSequence, m0.c range) {
        kotlin.jvm.internal.i.e(charSequence, "<this>");
        kotlin.jvm.internal.i.e(range, "range");
        return charSequence.subSequence(range.h().intValue(), range.g().intValue() + 1).toString();
    }

    public static final String Q(String str, char c2, String missingDelimiterValue) {
        kotlin.jvm.internal.i.e(str, "<this>");
        kotlin.jvm.internal.i.e(missingDelimiterValue, "missingDelimiterValue");
        int z2 = z(str, c2, 0, false, 6, null);
        if (z2 == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(z2 + 1, str.length());
        kotlin.jvm.internal.i.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static final String R(String str, String delimiter, String missingDelimiterValue) {
        kotlin.jvm.internal.i.e(str, "<this>");
        kotlin.jvm.internal.i.e(delimiter, "delimiter");
        kotlin.jvm.internal.i.e(missingDelimiterValue, "missingDelimiterValue");
        int A = A(str, delimiter, 0, false, 6, null);
        if (A == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(A + delimiter.length(), str.length());
        kotlin.jvm.internal.i.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String S(String str, char c2, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = str;
        }
        return Q(str, c2, str2);
    }

    public static /* synthetic */ String T(String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str3 = str;
        }
        return R(str, str2, str3);
    }

    public static final String U(String str, char c2, String missingDelimiterValue) {
        kotlin.jvm.internal.i.e(str, "<this>");
        kotlin.jvm.internal.i.e(missingDelimiterValue, "missingDelimiterValue");
        int E = E(str, c2, 0, false, 6, null);
        if (E == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(E + 1, str.length());
        kotlin.jvm.internal.i.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String V(String str, char c2, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = str;
        }
        return U(str, c2, str2);
    }

    public static final String W(String str, char c2, String missingDelimiterValue) {
        kotlin.jvm.internal.i.e(str, "<this>");
        kotlin.jvm.internal.i.e(missingDelimiterValue, "missingDelimiterValue");
        int z2 = z(str, c2, 0, false, 6, null);
        if (z2 == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(0, z2);
        kotlin.jvm.internal.i.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static final String X(String str, String delimiter, String missingDelimiterValue) {
        kotlin.jvm.internal.i.e(str, "<this>");
        kotlin.jvm.internal.i.e(delimiter, "delimiter");
        kotlin.jvm.internal.i.e(missingDelimiterValue, "missingDelimiterValue");
        int A = A(str, delimiter, 0, false, 6, null);
        if (A == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(0, A);
        kotlin.jvm.internal.i.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String Y(String str, char c2, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = str;
        }
        return W(str, c2, str2);
    }

    public static /* synthetic */ String Z(String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str3 = str;
        }
        return X(str, str2, str3);
    }

    public static CharSequence a0(CharSequence charSequence) {
        kotlin.jvm.internal.i.e(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i2 = 0;
        boolean z2 = false;
        while (i2 <= length) {
            boolean c2 = p0.a.c(charSequence.charAt(!z2 ? i2 : length));
            if (z2) {
                if (!c2) {
                    break;
                }
                length--;
            } else if (c2) {
                i2++;
            } else {
                z2 = true;
            }
        }
        return charSequence.subSequence(i2, length + 1);
    }

    public static final boolean q(CharSequence charSequence, CharSequence other, boolean z2) {
        kotlin.jvm.internal.i.e(charSequence, "<this>");
        kotlin.jvm.internal.i.e(other, "other");
        if (other instanceof String) {
            if (A(charSequence, (String) other, 0, z2, 2, null) >= 0) {
                return true;
            }
        } else if (y(charSequence, other, 0, charSequence.length(), z2, false, 16, null) >= 0) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean r(CharSequence charSequence, CharSequence charSequence2, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        return q(charSequence, charSequence2, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0091, code lost:
    
        return a0.n.a(java.lang.Integer.valueOf(r12), r9);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final a0.j<java.lang.Integer, java.lang.String> s(java.lang.CharSequence r10, java.util.Collection<java.lang.String> r11, int r12, boolean r13, boolean r14) {
        /*
            r0 = 0
            if (r13 != 0) goto L2d
            int r1 = r11.size()
            r2 = 1
            if (r1 != r2) goto L2d
            java.lang.Object r11 = b0.g.n(r11)
            java.lang.String r11 = (java.lang.String) r11
            r4 = 0
            r5 = 4
            r6 = 0
            r1 = r10
            r2 = r11
            r3 = r12
            if (r14 != 0) goto L1d
            int r10 = p0.d.A(r1, r2, r3, r4, r5, r6)
            goto L21
        L1d:
            int r10 = p0.d.F(r1, r2, r3, r4, r5, r6)
        L21:
            if (r10 >= 0) goto L24
            goto L2c
        L24:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            a0.j r0 = a0.n.a(r10, r11)
        L2c:
            return r0
        L2d:
            r1 = 0
            if (r14 != 0) goto L3e
            m0.c r14 = new m0.c
            int r12 = m0.d.a(r12, r1)
            int r1 = r10.length()
            r14.<init>(r12, r1)
            goto L4a
        L3e:
            int r14 = u(r10)
            int r12 = m0.d.c(r12, r14)
            m0.a r14 = m0.d.f(r12, r1)
        L4a:
            boolean r12 = r10 instanceof java.lang.String
            if (r12 == 0) goto L96
            int r12 = r14.a()
            int r1 = r14.b()
            int r14 = r14.c()
            if (r14 <= 0) goto L5e
            if (r12 <= r1) goto L62
        L5e:
            if (r14 >= 0) goto Ld4
            if (r1 > r12) goto Ld4
        L62:
            java.util.Iterator r8 = r11.iterator()
        L66:
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto L84
            java.lang.Object r9 = r8.next()
            r2 = r9
            java.lang.String r2 = (java.lang.String) r2
            r3 = 0
            r4 = r10
            java.lang.String r4 = (java.lang.String) r4
            int r6 = r2.length()
            r5 = r12
            r7 = r13
            boolean r2 = p0.m.m(r2, r3, r4, r5, r6, r7)
            if (r2 == 0) goto L66
            goto L85
        L84:
            r9 = r0
        L85:
            java.lang.String r9 = (java.lang.String) r9
            if (r9 == 0) goto L92
        L89:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r12)
            a0.j r10 = a0.n.a(r10, r9)
            return r10
        L92:
            if (r12 == r1) goto Ld4
            int r12 = r12 + r14
            goto L62
        L96:
            int r12 = r14.a()
            int r1 = r14.b()
            int r14 = r14.c()
            if (r14 <= 0) goto La6
            if (r12 <= r1) goto Laa
        La6:
            if (r14 >= 0) goto Ld4
            if (r1 > r12) goto Ld4
        Laa:
            java.util.Iterator r8 = r11.iterator()
        Lae:
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto Lca
            java.lang.Object r9 = r8.next()
            r2 = r9
            java.lang.String r2 = (java.lang.String) r2
            r3 = 0
            int r6 = r2.length()
            r4 = r10
            r5 = r12
            r7 = r13
            boolean r2 = L(r2, r3, r4, r5, r6, r7)
            if (r2 == 0) goto Lae
            goto Lcb
        Lca:
            r9 = r0
        Lcb:
            java.lang.String r9 = (java.lang.String) r9
            if (r9 == 0) goto Ld0
            goto L89
        Ld0:
            if (r12 == r1) goto Ld4
            int r12 = r12 + r14
            goto Laa
        Ld4:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p0.n.s(java.lang.CharSequence, java.util.Collection, int, boolean, boolean):a0.j");
    }

    public static final m0.c t(CharSequence charSequence) {
        kotlin.jvm.internal.i.e(charSequence, "<this>");
        return new m0.c(0, charSequence.length() - 1);
    }

    public static final int u(CharSequence charSequence) {
        kotlin.jvm.internal.i.e(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int v(CharSequence charSequence, char c2, int i2, boolean z2) {
        kotlin.jvm.internal.i.e(charSequence, "<this>");
        return (z2 || !(charSequence instanceof String)) ? B(charSequence, new char[]{c2}, i2, z2) : ((String) charSequence).indexOf(c2, i2);
    }

    public static final int w(CharSequence charSequence, String string, int i2, boolean z2) {
        kotlin.jvm.internal.i.e(charSequence, "<this>");
        kotlin.jvm.internal.i.e(string, "string");
        return (z2 || !(charSequence instanceof String)) ? y(charSequence, string, i2, charSequence.length(), z2, false, 16, null) : ((String) charSequence).indexOf(string, i2);
    }

    private static final int x(CharSequence charSequence, CharSequence charSequence2, int i2, int i3, boolean z2, boolean z3) {
        int c2;
        int a2;
        m0.a f2;
        int a3;
        int c3;
        if (z3) {
            c2 = m0.f.c(i2, u(charSequence));
            a2 = m0.f.a(i3, 0);
            f2 = m0.f.f(c2, a2);
        } else {
            a3 = m0.f.a(i2, 0);
            c3 = m0.f.c(i3, charSequence.length());
            f2 = new m0.c(a3, c3);
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int a4 = f2.a();
            int b2 = f2.b();
            int c4 = f2.c();
            if ((c4 <= 0 || a4 > b2) && (c4 >= 0 || b2 > a4)) {
                return -1;
            }
            while (!m.m((String) charSequence2, 0, (String) charSequence, a4, charSequence2.length(), z2)) {
                if (a4 == b2) {
                    return -1;
                }
                a4 += c4;
            }
            return a4;
        }
        int a5 = f2.a();
        int b3 = f2.b();
        int c5 = f2.c();
        if ((c5 <= 0 || a5 > b3) && (c5 >= 0 || b3 > a5)) {
            return -1;
        }
        while (!L(charSequence2, 0, charSequence, a5, charSequence2.length(), z2)) {
            if (a5 == b3) {
                return -1;
            }
            a5 += c5;
        }
        return a5;
    }

    static /* synthetic */ int y(CharSequence charSequence, CharSequence charSequence2, int i2, int i3, boolean z2, boolean z3, int i4, Object obj) {
        return x(charSequence, charSequence2, i2, i3, z2, (i4 & 16) != 0 ? false : z3);
    }

    public static /* synthetic */ int z(CharSequence charSequence, char c2, int i2, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z2 = false;
        }
        return v(charSequence, c2, i2, z2);
    }
}
