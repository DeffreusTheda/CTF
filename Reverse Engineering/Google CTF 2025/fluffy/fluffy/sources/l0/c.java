package l0;

import Q.g;
import U.f;
import Z.p;
import h0.r;

/* loaded from: classes.dex */
public final class c extends f implements p {

    /* renamed from: f, reason: collision with root package name */
    public int f979f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f980g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ k0.d f981h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ k0.b f982i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(k0.d dVar, k0.b bVar, S.d dVar2) {
        super(dVar2);
        this.f981h = dVar;
        this.f982i = bVar;
    }

    @Override // U.b
    public final S.d b(Object obj, S.d dVar) {
        c cVar = new c(this.f981h, this.f982i, dVar);
        cVar.f980g = obj;
        return cVar;
    }

    @Override // Z.p
    public final Object d(Object obj, Object obj2) {
        return ((c) b((r) obj, (S.d) obj2)).e(g.f327a);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a3 A[RETURN] */
    @Override // U.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(java.lang.Object r10) {
        /*
            r9 = this;
            T.a r0 = T.a.f344b
            int r1 = r9.f979f
            Q.g r2 = Q.g.f327a
            r3 = 1
            if (r1 == 0) goto L18
            if (r1 != r3) goto L10
            a.a.x(r10)
            goto La4
        L10:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L18:
            a.a.x(r10)
            java.lang.Object r10 = r9.f980g
            h0.r r10 = (h0.r) r10
            k0.b r1 = r9.f982i
            int r4 = r1.f922c
            r5 = -3
            r6 = -2
            if (r4 != r5) goto L28
            r4 = -2
        L28:
            l0.d r5 = new l0.d
            r7 = 0
            r5.<init>(r1, r7)
            int r8 = r1.f923d
            if (r4 == r6) goto L71
            r6 = -1
            if (r4 == r6) goto L60
            if (r4 == 0) goto L51
            r6 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r6) goto L4a
            if (r8 != r3) goto L44
            j0.c r6 = new j0.c
            r6.<init>(r4, r7)
            goto L86
        L44:
            j0.n r6 = new j0.n
            r6.<init>(r4, r8, r7)
            goto L86
        L4a:
            j0.c r4 = new j0.c
            r4.<init>(r6, r7)
        L4f:
            r6 = r4
            goto L86
        L51:
            if (r8 != r3) goto L5a
            j0.c r4 = new j0.c
            r6 = 0
            r4.<init>(r6, r7)
            goto L4f
        L5a:
            j0.n r4 = new j0.n
            r4.<init>(r3, r8, r7)
            goto L4f
        L60:
            if (r8 != r3) goto L69
            j0.n r6 = new j0.n
            r4 = 2
            r6.<init>(r3, r4, r7)
            goto L86
        L69:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "CONFLATED capacity cannot be used with non-default onBufferOverflow"
            r10.<init>(r0)
            throw r10
        L71:
            if (r8 != r3) goto L80
            j0.c r4 = new j0.c
            j0.f r6 = j0.g.f906a
            r6.getClass()
            int r6 = j0.f.f905b
            r4.<init>(r6, r7)
            goto L4f
        L80:
            j0.n r4 = new j0.n
            r4.<init>(r3, r8, r7)
            goto L4f
        L86:
            S.i r1 = r1.f921b
            S.i r10 = h0.AbstractC0059t.f(r10, r1)
            j0.q r1 = new j0.q
            r1.<init>(r10, r6)
            r10 = 3
            r1.M(r10, r1, r5)
            r9.f979f = r3
            k0.d r10 = r9.f981h
            java.lang.Object r10 = k0.h.a(r10, r1, r3, r9)
            if (r10 != r0) goto La0
            goto La1
        La0:
            r10 = r2
        La1:
            if (r10 != r0) goto La4
            return r0
        La4:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: l0.c.e(java.lang.Object):java.lang.Object");
    }
}
