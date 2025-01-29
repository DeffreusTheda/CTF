package k0;

import a0.n;
import h0.AbstractC0059t;
import h0.C0051k;
import h0.H;
import h0.I;
import java.util.ArrayList;
import m0.u;
import v.j;

/* loaded from: classes.dex */
public final class b implements c {

    /* renamed from: b, reason: collision with root package name */
    public final S.i f921b;

    /* renamed from: c, reason: collision with root package name */
    public final int f922c;

    /* renamed from: d, reason: collision with root package name */
    public final int f923d;

    /* renamed from: e, reason: collision with root package name */
    public final j f924e;

    /* renamed from: f, reason: collision with root package name */
    public final j f925f;

    public b(j jVar, S.i iVar, int i2, int i3) {
        this.f921b = iVar;
        this.f922c = i2;
        this.f923d = i3;
        this.f924e = jVar;
        this.f925f = jVar;
    }

    @Override // k0.c
    public Object a(d dVar, S.d dVar2) {
        Object c0051k;
        Object C2;
        H h2;
        l0.c cVar = new l0.c(dVar, this, null);
        S.i iVar = ((U.b) dVar2).f348c;
        a0.h.b(iVar);
        u uVar = new u(iVar, (U.f) dVar2);
        try {
            n.a(2, cVar);
            c0051k = cVar.d(uVar, uVar);
        } catch (Throwable th) {
            c0051k = new C0051k(th, false);
        }
        T.a aVar = T.a.f344b;
        if (c0051k == aVar || (C2 = uVar.C(c0051k)) == AbstractC0059t.f579d) {
            C2 = aVar;
        } else {
            if (C2 instanceof C0051k) {
                throw ((C0051k) C2).f564a;
            }
            I i2 = C2 instanceof I ? (I) C2 : null;
            if (i2 != null && (h2 = i2.f524a) != null) {
                C2 = h2;
            }
        }
        return C2 == aVar ? C2 : Q.g.f327a;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0053 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(j0.r r6, S.d r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof k0.a
            if (r0 == 0) goto L13
            r0 = r7
            k0.a r0 = (k0.a) r0
            int r1 = r0.f920h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f920h = r1
            goto L1a
        L13:
            k0.a r0 = new k0.a
            U.b r7 = (U.b) r7
            r0.<init>(r5, r7)
        L1a:
            java.lang.Object r7 = r0.f918f
            T.a r1 = T.a.f344b
            int r2 = r0.f920h
            Q.g r3 = Q.g.f327a
            r4 = 1
            if (r2 == 0) goto L35
            if (r2 != r4) goto L2d
            j0.r r6 = r0.f917e
            a.a.x(r7)
            goto L49
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            a.a.x(r7)
            r0.f917e = r6
            r0.f920h = r4
            v.j r7 = r5.f924e
            java.lang.Object r7 = r7.d(r6, r0)
            if (r7 != r1) goto L45
            goto L46
        L45:
            r7 = r3
        L46:
            if (r7 != r1) goto L49
            return r1
        L49:
            j0.q r6 = (j0.q) r6
            j0.c r6 = r6.f915e
            boolean r6 = r6.p()
            if (r6 == 0) goto L54
            return r3
        L54:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details."
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: k0.b.b(j0.r, S.d):java.lang.Object");
    }

    public final String c() {
        ArrayList arrayList = new ArrayList(4);
        S.j jVar = S.j.f343b;
        S.i iVar = this.f921b;
        if (iVar != jVar) {
            arrayList.add("context=" + iVar);
        }
        int i2 = this.f922c;
        if (i2 != -3) {
            arrayList.add("capacity=" + i2);
        }
        int i3 = this.f923d;
        if (i3 != 1) {
            arrayList.add("onBufferOverflow=".concat(i3 != 1 ? i3 != 2 ? i3 != 3 ? "null" : "DROP_LATEST" : "DROP_OLDEST" : "SUSPEND"));
        }
        return getClass().getSimpleName() + '[' + R.e.B(arrayList, null, null, null, 62) + ']';
    }

    public final String toString() {
        return "block[" + this.f924e + "] -> " + c();
    }
}
