package v0;

import a0.k;
import a0.l;
import c0.d;
import c0.g;
import j0.p;
import kotlin.coroutines.jvm.internal.h;
import kotlin.jvm.internal.n;
import kotlinx.coroutines.internal.c0;

/* loaded from: classes.dex */
public final class b {
    public static final <R, T> void a(p<? super R, ? super d<? super T>, ? extends Object> pVar, R r2, d<? super T> dVar) {
        Object a2;
        Object c2;
        d a3 = h.a(dVar);
        try {
            g context = dVar.getContext();
            Object c3 = c0.c(context, null);
            try {
            } finally {
                c0.a(context, c3);
            }
        } catch (Throwable th) {
            k.a aVar = k.f16d;
            a2 = l.a(th);
        }
        if (pVar == null) {
            throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        }
        a2 = ((p) n.a(pVar, 2)).invoke(r2, a3);
        c2 = d0.d.c();
        if (a2 != c2) {
            k.a aVar2 = k.f16d;
            a3.resumeWith(k.a(a2));
        }
    }
}
