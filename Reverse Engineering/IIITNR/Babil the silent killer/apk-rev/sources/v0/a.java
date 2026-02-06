package v0;

import a0.k;
import a0.l;
import a0.q;
import c0.d;
import d0.c;
import j0.p;
import kotlinx.coroutines.internal.h;

/* loaded from: classes.dex */
public final class a {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(d<?> dVar, Throwable th) {
        k.a aVar = k.f16d;
        dVar.resumeWith(k.a(l.a(th)));
        throw th;
    }

    public static final void c(d<? super q> dVar, d<?> dVar2) {
        d b2;
        try {
            b2 = c.b(dVar);
            k.a aVar = k.f16d;
            h.c(b2, k.a(q.f22a), null, 2, null);
        } catch (Throwable th) {
            b(dVar2, th);
        }
    }

    public static final <R, T> void d(p<? super R, ? super d<? super T>, ? extends Object> pVar, R r2, d<? super T> dVar, j0.l<? super Throwable, q> lVar) {
        d a2;
        d b2;
        try {
            a2 = c.a(pVar, r2, dVar);
            b2 = c.b(a2);
            k.a aVar = k.f16d;
            h.b(b2, k.a(q.f22a), lVar);
        } catch (Throwable th) {
            b(dVar, th);
        }
    }

    public static /* synthetic */ void e(p pVar, Object obj, d dVar, j0.l lVar, int i2, Object obj2) {
        if ((i2 & 4) != 0) {
            lVar = null;
        }
        d(pVar, obj, dVar, lVar);
    }
}
