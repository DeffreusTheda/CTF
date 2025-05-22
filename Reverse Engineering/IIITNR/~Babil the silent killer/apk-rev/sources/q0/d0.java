package q0;

/* loaded from: classes.dex */
public final class d0 {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f1001a;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0027, code lost:
    
        if (r0.equals("on") != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0030, code lost:
    
        if (r0.equals("") != false) goto L21;
     */
    static {
        /*
            java.lang.String r0 = "kotlinx.coroutines.scheduler"
            java.lang.String r0 = kotlinx.coroutines.internal.z.d(r0)
            if (r0 == 0) goto L53
            int r1 = r0.hashCode()
            if (r1 == 0) goto L2a
            r2 = 3551(0xddf, float:4.976E-42)
            if (r1 == r2) goto L21
            r2 = 109935(0x1ad6f, float:1.54052E-40)
            if (r1 != r2) goto L33
            java.lang.String r1 = "off"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L33
            r0 = 0
            goto L54
        L21:
            java.lang.String r1 = "on"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L33
            goto L53
        L2a:
            java.lang.String r1 = ""
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L33
            goto L53
        L33:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "System property 'kotlinx.coroutines.scheduler' has unrecognized value '"
            r1.append(r2)
            r1.append(r0)
            r0 = 39
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L53:
            r0 = 1
        L54:
            q0.d0.f1001a = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: q0.d0.<clinit>():void");
    }

    public static final e0 a() {
        return f1001a ? kotlinx.coroutines.scheduling.b.f883k : v.f1067f;
    }

    public static final String b(c0.g gVar) {
        return null;
    }

    public static final c0.g c(h0 h0Var, c0.g gVar) {
        c0.g plus = h0Var.s().plus(gVar);
        return (plus == r0.a() || plus.get(c0.e.f141a) != null) ? plus : plus.plus(r0.a());
    }

    public static final c2<?> d(kotlin.coroutines.jvm.internal.e eVar) {
        while (!(eVar instanceof n0) && (eVar = eVar.getCallerFrame()) != null) {
            if (eVar instanceof c2) {
                return (c2) eVar;
            }
        }
        return null;
    }

    public static final c2<?> e(c0.d<?> dVar, c0.g gVar, Object obj) {
        if (!(dVar instanceof kotlin.coroutines.jvm.internal.e)) {
            return null;
        }
        if (!(gVar.get(d2.f1003d) != null)) {
            return null;
        }
        c2<?> d2 = d((kotlin.coroutines.jvm.internal.e) dVar);
        if (d2 != null) {
            d2.z0(gVar, obj);
        }
        return d2;
    }
}
