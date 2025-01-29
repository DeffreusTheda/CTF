package j0;

import h0.AbstractC0041a;
import h0.AbstractC0059t;
import h0.C0051k;
import h0.L;
import h0.Q;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public final class q extends AbstractC0041a implements r, g {

    /* renamed from: e, reason: collision with root package name */
    public final c f915e;

    public q(S.i iVar, c cVar) {
        super(iVar, true);
        this.f915e = cVar;
    }

    @Override // h0.AbstractC0041a
    public final void K(Throwable th, boolean z2) {
        if (this.f915e.e(th, false) || z2) {
            return;
        }
        AbstractC0059t.c(this.f545d, th);
    }

    @Override // h0.AbstractC0041a
    public final void L(Object obj) {
        this.f915e.e(null, false);
    }

    public final void N(p pVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        c cVar = this.f915e;
        cVar.getClass();
        do {
            atomicReferenceFieldUpdater = c.f882l;
            if (atomicReferenceFieldUpdater.compareAndSet(cVar, null, pVar)) {
                return;
            }
        } while (atomicReferenceFieldUpdater.get(cVar) == null);
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(cVar);
            io.flutter.plugin.platform.i iVar = e.f901q;
            if (obj != iVar) {
                if (obj == e.f902r) {
                    throw new IllegalStateException("Another handler was already registered and successfully invoked");
                }
                throw new IllegalStateException(("Another handler is already registered: " + obj).toString());
            }
            io.flutter.plugin.platform.i iVar2 = e.f902r;
            while (!atomicReferenceFieldUpdater.compareAndSet(cVar, iVar, iVar2)) {
                if (atomicReferenceFieldUpdater.get(cVar) != iVar) {
                    break;
                }
            }
            pVar.h(cVar.k());
            return;
        }
    }

    @Override // h0.T, h0.K
    public final void a(CancellationException cancellationException) {
        Object y2 = y();
        if (y2 instanceof C0051k) {
            return;
        }
        if ((y2 instanceof Q) && ((Q) y2).e()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new L(r(), null, this);
        }
        p(cancellationException);
    }

    @Override // j0.t
    public final Object j(Object obj) {
        return this.f915e.j(obj);
    }

    @Override // h0.T
    public final void p(CancellationException cancellationException) {
        this.f915e.e(cancellationException, true);
        o(cancellationException);
    }
}
