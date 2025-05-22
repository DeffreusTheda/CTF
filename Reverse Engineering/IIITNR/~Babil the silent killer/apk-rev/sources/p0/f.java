package p0;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends e {

    static final class a extends kotlin.jvm.internal.j implements j0.l<String, String> {

        /* renamed from: d, reason: collision with root package name */
        public static final a f986d = new a();

        a() {
            super(1);
        }

        @Override // j0.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke(String line) {
            kotlin.jvm.internal.i.e(line, "line");
            return line;
        }
    }

    static final class b extends kotlin.jvm.internal.j implements j0.l<String, String> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f987d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str) {
            super(1);
            this.f987d = str;
        }

        @Override // j0.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke(String line) {
            kotlin.jvm.internal.i.e(line, "line");
            return this.f987d + line;
        }
    }

    private static final j0.l<String, String> b(String str) {
        return str.length() == 0 ? a.f986d : new b(str);
    }

    private static final int c(String str) {
        int length = str.length();
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = -1;
                break;
            }
            if (!p0.a.c(str.charAt(i2))) {
                break;
            }
            i2++;
        }
        return i2 == -1 ? str.length() : i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ba A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.String d(java.lang.String r14, java.lang.String r15) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.i.e(r14, r0)
            java.lang.String r0 = "newIndent"
            kotlin.jvm.internal.i.e(r15, r0)
            java.util.List r0 = p0.n.I(r14)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r2 = r0.iterator()
        L17:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L30
            java.lang.Object r3 = r2.next()
            r4 = r3
            java.lang.String r4 = (java.lang.String) r4
            boolean r4 = p0.d.l(r4)
            r4 = r4 ^ 1
            if (r4 == 0) goto L17
            r1.add(r3)
            goto L17
        L30:
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 10
            int r3 = b0.g.g(r1, r3)
            r2.<init>(r3)
            java.util.Iterator r1 = r1.iterator()
        L3f:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L57
            java.lang.Object r3 = r1.next()
            java.lang.String r3 = (java.lang.String) r3
            int r3 = c(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r2.add(r3)
            goto L3f
        L57:
            java.lang.Comparable r1 = b0.g.m(r2)
            java.lang.Integer r1 = (java.lang.Integer) r1
            r2 = 0
            if (r1 == 0) goto L65
            int r1 = r1.intValue()
            goto L66
        L65:
            r1 = 0
        L66:
            int r14 = r14.length()
            int r3 = r15.length()
            int r4 = r0.size()
            int r3 = r3 * r4
            int r14 = r14 + r3
            j0.l r15 = b(r15)
            int r3 = b0.g.c(r0)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Iterator r0 = r0.iterator()
        L86:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto Lbc
            java.lang.Object r5 = r0.next()
            int r6 = r2 + 1
            if (r2 >= 0) goto L97
            b0.g.f()
        L97:
            java.lang.String r5 = (java.lang.String) r5
            if (r2 == 0) goto L9d
            if (r2 != r3) goto La5
        L9d:
            boolean r2 = p0.d.l(r5)
            if (r2 == 0) goto La5
            r5 = 0
            goto Lb5
        La5:
            java.lang.String r2 = p0.p.b0(r5, r1)
            if (r2 == 0) goto Lb5
            java.lang.Object r2 = r15.invoke(r2)
            java.lang.String r2 = (java.lang.String) r2
            if (r2 != 0) goto Lb4
            goto Lb5
        Lb4:
            r5 = r2
        Lb5:
            if (r5 == 0) goto Lba
            r4.add(r5)
        Lba:
            r2 = r6
            goto L86
        Lbc:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r14)
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 124(0x7c, float:1.74E-43)
            r13 = 0
            java.lang.String r6 = "\n"
            java.lang.Appendable r14 = b0.g.j(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            java.lang.StringBuilder r14 = (java.lang.StringBuilder) r14
            java.lang.String r14 = r14.toString()
            java.lang.String r15 = "mapIndexedNotNull { inde…\"\\n\")\n        .toString()"
            kotlin.jvm.internal.i.d(r14, r15)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: p0.f.d(java.lang.String, java.lang.String):java.lang.String");
    }

    public static String e(String str) {
        kotlin.jvm.internal.i.e(str, "<this>");
        return d(str, "");
    }
}
