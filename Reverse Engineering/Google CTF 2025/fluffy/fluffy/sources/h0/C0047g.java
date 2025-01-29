package h0;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import m0.AbstractC0081a;

/* renamed from: h0.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0047g extends M {

    /* renamed from: f, reason: collision with root package name */
    public final C0045e f557f;

    public C0047g(C0045e c0045e) {
        this.f557f = c0045e;
    }

    @Override // Z.l
    public final /* bridge */ /* synthetic */ Object h(Object obj) {
        o((Throwable) obj);
        return Q.g.f327a;
    }

    @Override // h0.O
    public final void o(Throwable th) {
        T n2 = n();
        C0045e c0045e = this.f557f;
        c0045e.getClass();
        CancellationException v2 = n2.v();
        if (c0045e.s()) {
            S.d dVar = c0045e.f554e;
            a0.h.c(dVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
            m0.h hVar = (m0.h) dVar;
            loop0: while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = m0.h.f1002i;
                Object obj = atomicReferenceFieldUpdater.get(hVar);
                io.flutter.plugin.platform.i iVar = AbstractC0081a.f992d;
                if (!a0.h.a(obj, iVar)) {
                    if (!(obj instanceof Throwable)) {
                        while (!atomicReferenceFieldUpdater.compareAndSet(hVar, obj, null)) {
                            if (atomicReferenceFieldUpdater.get(hVar) != obj) {
                                break;
                            }
                        }
                        break loop0;
                    }
                    return;
                }
                while (!atomicReferenceFieldUpdater.compareAndSet(hVar, iVar, v2)) {
                    if (atomicReferenceFieldUpdater.get(hVar) != iVar) {
                        break;
                    }
                }
                return;
            }
        }
        c0045e.m(v2);
        if (c0045e.s()) {
            return;
        }
        c0045e.n();
    }
}
