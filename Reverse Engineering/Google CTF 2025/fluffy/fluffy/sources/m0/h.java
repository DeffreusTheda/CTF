package m0;

import h0.AbstractC0056p;
import h0.AbstractC0059t;
import h0.AbstractC0063x;
import h0.C0051k;
import h0.C0052l;
import h0.D;
import h0.a0;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public final class h extends AbstractC0063x implements U.c, S.d {

    /* renamed from: i, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f1002i = AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, "_reusableCancellableContinuation");
    private volatile Object _reusableCancellableContinuation;

    /* renamed from: e, reason: collision with root package name */
    public final AbstractC0056p f1003e;

    /* renamed from: f, reason: collision with root package name */
    public final U.b f1004f;

    /* renamed from: g, reason: collision with root package name */
    public Object f1005g;

    /* renamed from: h, reason: collision with root package name */
    public final Object f1006h;

    public h(AbstractC0056p abstractC0056p, U.b bVar) {
        super(-1);
        this.f1003e = abstractC0056p;
        this.f1004f = bVar;
        this.f1005g = AbstractC0081a.f991c;
        S.i iVar = bVar.f348c;
        a0.h.b(iVar);
        this.f1006h = AbstractC0081a.l(iVar);
    }

    @Override // h0.AbstractC0063x
    public final void b(Object obj, CancellationException cancellationException) {
        if (obj instanceof C0052l) {
            ((C0052l) obj).f566b.h(cancellationException);
        }
    }

    @Override // S.d
    public final void c(Object obj) {
        U.b bVar = this.f1004f;
        S.i iVar = bVar.f348c;
        a0.h.b(iVar);
        Throwable a2 = Q.d.a(obj);
        Object c0051k = a2 == null ? obj : new C0051k(a2, false);
        AbstractC0056p abstractC0056p = this.f1003e;
        if (abstractC0056p.g()) {
            this.f1005g = c0051k;
            this.f588d = 0;
            abstractC0056p.c(iVar, this);
            return;
        }
        D a3 = a0.a();
        if (a3.f519d >= 4294967296L) {
            this.f1005g = c0051k;
            this.f588d = 0;
            R.c cVar = a3.f521f;
            if (cVar == null) {
                cVar = new R.c();
                a3.f521f = cVar;
            }
            cVar.addLast(this);
            return;
        }
        a3.k(true);
        try {
            S.i iVar2 = bVar.f348c;
            a0.h.b(iVar2);
            Object m = AbstractC0081a.m(iVar2, this.f1006h);
            try {
                bVar.c(obj);
                while (a3.l()) {
                }
            } finally {
                AbstractC0081a.h(iVar2, m);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    @Override // U.c
    public final U.c g() {
        U.b bVar = this.f1004f;
        if (bVar instanceof U.c) {
            return bVar;
        }
        return null;
    }

    @Override // S.d
    public final S.i i() {
        S.i iVar = this.f1004f.f348c;
        a0.h.b(iVar);
        return iVar;
    }

    @Override // h0.AbstractC0063x
    public final Object j() {
        Object obj = this.f1005g;
        this.f1005g = AbstractC0081a.f991c;
        return obj;
    }

    public final String toString() {
        return "DispatchedContinuation[" + this.f1003e + ", " + AbstractC0059t.h(this.f1004f) + ']';
    }

    @Override // h0.AbstractC0063x
    public final S.d d() {
        return this;
    }
}
