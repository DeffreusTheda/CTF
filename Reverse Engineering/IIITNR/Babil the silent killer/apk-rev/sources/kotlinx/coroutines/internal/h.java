package kotlinx.coroutines.internal;

import a0.k;
import java.util.concurrent.CancellationException;
import q0.a2;
import q0.c2;
import q0.j1;
import q0.u0;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    private static final y f821a = new y("UNDEFINED");

    /* renamed from: b, reason: collision with root package name */
    public static final y f822b = new y("REUSABLE_CLAIMED");

    /* JADX WARN: Finally extract failed */
    public static final <T> void b(c0.d<? super T> dVar, Object obj, j0.l<? super Throwable, a0.q> lVar) {
        boolean z2;
        if (!(dVar instanceof g)) {
            dVar.resumeWith(obj);
            return;
        }
        g gVar = (g) dVar;
        Object b2 = q0.c0.b(obj, lVar);
        if (gVar.f817g.l(gVar.getContext())) {
            gVar.f819i = b2;
            gVar.f1035f = 1;
            gVar.f817g.k(gVar.getContext(), gVar);
            return;
        }
        u0 a2 = a2.f994a.a();
        if (a2.w()) {
            gVar.f819i = b2;
            gVar.f1035f = 1;
            a2.s(gVar);
            return;
        }
        a2.u(true);
        try {
            j1 j1Var = (j1) gVar.getContext().get(j1.f1021c);
            if (j1Var == null || j1Var.a()) {
                z2 = false;
            } else {
                CancellationException j2 = j1Var.j();
                gVar.a(b2, j2);
                k.a aVar = a0.k.f16d;
                gVar.resumeWith(a0.k.a(a0.l.a(j2)));
                z2 = true;
            }
            if (!z2) {
                c0.d<T> dVar2 = gVar.f818h;
                Object obj2 = gVar.f820j;
                c0.g context = dVar2.getContext();
                Object c2 = c0.c(context, obj2);
                c2<?> e2 = c2 != c0.f801a ? q0.d0.e(dVar2, context, c2) : null;
                try {
                    gVar.f818h.resumeWith(obj);
                    a0.q qVar = a0.q.f22a;
                    if (e2 == null || e2.y0()) {
                        c0.a(context, c2);
                    }
                } catch (Throwable th) {
                    if (e2 == null || e2.y0()) {
                        c0.a(context, c2);
                    }
                    throw th;
                }
            }
            while (a2.y()) {
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public static /* synthetic */ void c(c0.d dVar, Object obj, j0.l lVar, int i2, Object obj2) {
        if ((i2 & 2) != 0) {
            lVar = null;
        }
        b(dVar, obj, lVar);
    }
}
