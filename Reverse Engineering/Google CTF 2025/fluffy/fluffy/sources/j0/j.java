package j0;

/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static final i f908a = new i();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
    /* JADX WARN: Type inference failed for: r5v5, types: [Z.a] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(j0.r r4, v.i r5, U.b r6) {
        /*
            boolean r0 = r6 instanceof j0.o
            if (r0 == 0) goto L13
            r0 = r6
            j0.o r0 = (j0.o) r0
            int r1 = r0.f913g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f913g = r1
            goto L18
        L13:
            j0.o r0 = new j0.o
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f912f
            T.a r1 = T.a.f344b
            int r2 = r0.f913g
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            Z.a r5 = r0.f911e
            a.a.x(r6)     // Catch: java.lang.Throwable -> L29
            goto L64
        L29:
            r4 = move-exception
            goto L6a
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            a.a.x(r6)
            S.i r6 = r0.f348c
            a0.h.b(r6)
            h0.q r2 = h0.C0057q.f575c
            S.g r6 = r6.f(r2)
            if (r6 != r4) goto L6e
            r0.f911e = r5     // Catch: java.lang.Throwable -> L29
            r0.f913g = r3     // Catch: java.lang.Throwable -> L29
            h0.e r6 = new h0.e     // Catch: java.lang.Throwable -> L29
            S.d r0 = a.a.m(r0)     // Catch: java.lang.Throwable -> L29
            r6.<init>(r0, r3)     // Catch: java.lang.Throwable -> L29
            r6.q()     // Catch: java.lang.Throwable -> L29
            j0.p r0 = new j0.p     // Catch: java.lang.Throwable -> L29
            r0.<init>(r6)     // Catch: java.lang.Throwable -> L29
            j0.q r4 = (j0.q) r4     // Catch: java.lang.Throwable -> L29
            r4.N(r0)     // Catch: java.lang.Throwable -> L29
            java.lang.Object r4 = r6.p()     // Catch: java.lang.Throwable -> L29
            if (r4 != r1) goto L64
            return r1
        L64:
            r5.a()
            Q.g r4 = Q.g.f327a
            return r4
        L6a:
            r5.a()
            throw r4
        L6e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "awaitClose() can only be invoked from the producer context"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: j0.j.a(j0.r, v.i, U.b):java.lang.Object");
    }
}
