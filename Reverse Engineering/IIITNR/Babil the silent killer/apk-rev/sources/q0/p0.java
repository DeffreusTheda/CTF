package q0;

import a0.k;

/* loaded from: classes.dex */
public final class p0 {
    public static final <T> void a(o0<? super T> o0Var, int i2) {
        c0.d<? super T> b2 = o0Var.b();
        boolean z2 = i2 == 4;
        if (z2 || !(b2 instanceof kotlinx.coroutines.internal.g) || b(i2) != b(o0Var.f1035f)) {
            d(o0Var, b2, z2);
            return;
        }
        e0 e0Var = ((kotlinx.coroutines.internal.g) b2).f817g;
        c0.g context = b2.getContext();
        if (e0Var.l(context)) {
            e0Var.k(context, o0Var);
        } else {
            e(o0Var);
        }
    }

    public static final boolean b(int i2) {
        return i2 == 1 || i2 == 2;
    }

    public static final boolean c(int i2) {
        return i2 == 2;
    }

    public static final <T> void d(o0<? super T> o0Var, c0.d<? super T> dVar, boolean z2) {
        Object d2;
        Object h2 = o0Var.h();
        Throwable c2 = o0Var.c(h2);
        if (c2 != null) {
            k.a aVar = a0.k.f16d;
            d2 = a0.l.a(c2);
        } else {
            k.a aVar2 = a0.k.f16d;
            d2 = o0Var.d(h2);
        }
        Object a2 = a0.k.a(d2);
        if (!z2) {
            dVar.resumeWith(a2);
            return;
        }
        kotlinx.coroutines.internal.g gVar = (kotlinx.coroutines.internal.g) dVar;
        c0.d<T> dVar2 = gVar.f818h;
        Object obj = gVar.f820j;
        c0.g context = dVar2.getContext();
        Object c3 = kotlinx.coroutines.internal.c0.c(context, obj);
        c2<?> e2 = c3 != kotlinx.coroutines.internal.c0.f801a ? d0.e(dVar2, context, c3) : null;
        try {
            gVar.f818h.resumeWith(a2);
            a0.q qVar = a0.q.f22a;
        } finally {
            if (e2 == null || e2.y0()) {
                kotlinx.coroutines.internal.c0.a(context, c3);
            }
        }
    }

    private static final void e(o0<?> o0Var) {
        u0 a2 = a2.f994a.a();
        if (a2.w()) {
            a2.s(o0Var);
            return;
        }
        a2.u(true);
        try {
            d(o0Var, o0Var.b(), true);
            do {
            } while (a2.y());
        } finally {
            try {
            } finally {
            }
        }
    }
}
