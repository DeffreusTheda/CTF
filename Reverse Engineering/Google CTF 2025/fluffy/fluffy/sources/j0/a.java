package j0;

import h0.AbstractC0059t;
import h0.C0045e;
import h0.d0;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import m0.w;

/* loaded from: classes.dex */
public final class a implements d0 {

    /* renamed from: b, reason: collision with root package name */
    public Object f871b = e.f900p;

    /* renamed from: c, reason: collision with root package name */
    public C0045e f872c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ c f873d;

    public a(c cVar) {
        this.f873d = cVar;
    }

    @Override // h0.d0
    public final void a(k kVar, int i2) {
        C0045e c0045e = this.f872c;
        if (c0045e != null) {
            c0045e.a(kVar, i2);
        }
    }

    public final Object b(k0.e eVar) {
        C0045e c0045e;
        m0.q qVar;
        Boolean bool;
        int i2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = c.f879i;
        c cVar = this.f873d;
        k kVar = (k) atomicReferenceFieldUpdater.get(cVar);
        while (true) {
            cVar.getClass();
            if (cVar.o(c.f874d.get(cVar), true)) {
                this.f871b = e.f897l;
                Throwable k2 = cVar.k();
                if (k2 == null) {
                    return Boolean.FALSE;
                }
                int i3 = w.f1035a;
                throw k2;
            }
            long andIncrement = c.f875e.getAndIncrement(cVar);
            long j2 = e.f887b;
            long j3 = andIncrement / j2;
            int i4 = (int) (andIncrement % j2);
            if (kVar.f1034c != j3) {
                k i5 = cVar.i(j3, kVar);
                if (i5 == null) {
                    continue;
                } else {
                    kVar = i5;
                }
            }
            Object w2 = cVar.w(kVar, i4, andIncrement, null);
            io.flutter.plugin.platform.i iVar = e.m;
            if (w2 == iVar) {
                throw new IllegalStateException("unreachable");
            }
            io.flutter.plugin.platform.i iVar2 = e.f899o;
            if (w2 != iVar2) {
                if (w2 != e.f898n) {
                    kVar.a();
                    this.f871b = w2;
                    return Boolean.TRUE;
                }
                c cVar2 = this.f873d;
                C0045e b2 = AbstractC0059t.b(a.a.m(eVar));
                try {
                    this.f872c = b2;
                    c0045e = b2;
                } catch (Throwable th) {
                    th = th;
                    c0045e = b2;
                }
                try {
                    Object w3 = cVar2.w(kVar, i4, andIncrement, this);
                    if (w3 == iVar) {
                        a(kVar, i4);
                    } else {
                        S.i iVar3 = c0045e.f555f;
                        Z.l lVar = cVar2.f884c;
                        if (w3 == iVar2) {
                            if (andIncrement < cVar2.m()) {
                                kVar.a();
                            }
                            k kVar2 = (k) c.f879i.get(cVar2);
                            while (true) {
                                if (cVar2.o(c.f874d.get(cVar2), true)) {
                                    C0045e c0045e2 = this.f872c;
                                    a0.h.b(c0045e2);
                                    this.f872c = null;
                                    this.f871b = e.f897l;
                                    Throwable k3 = cVar.k();
                                    if (k3 == null) {
                                        c0045e2.c(Boolean.FALSE);
                                    } else {
                                        c0045e2.c(a.a.f(k3));
                                    }
                                } else {
                                    long andIncrement2 = c.f875e.getAndIncrement(cVar2);
                                    long j4 = e.f887b;
                                    long j5 = andIncrement2 / j4;
                                    int i6 = (int) (andIncrement2 % j4);
                                    if (kVar2.f1034c != j5) {
                                        k i7 = cVar2.i(j5, kVar2);
                                        if (i7 != null) {
                                            kVar2 = i7;
                                        }
                                    }
                                    Z.l lVar2 = lVar;
                                    Object w4 = cVar2.w(kVar2, i6, andIncrement2, this);
                                    if (w4 == e.m) {
                                        a(kVar2, i6);
                                        break;
                                    }
                                    if (w4 == e.f899o) {
                                        if (andIncrement2 < cVar2.m()) {
                                            kVar2.a();
                                        }
                                        lVar = lVar2;
                                    } else {
                                        if (w4 == e.f898n) {
                                            throw new IllegalStateException("unexpected");
                                        }
                                        kVar2.a();
                                        this.f871b = w4;
                                        this.f872c = null;
                                        qVar = lVar2 != null ? new m0.q(lVar2, w4, iVar3) : null;
                                        bool = Boolean.TRUE;
                                        i2 = c0045e.f588d;
                                    }
                                }
                            }
                        } else {
                            kVar.a();
                            this.f871b = w3;
                            this.f872c = null;
                            qVar = lVar != null ? new m0.q(lVar, w3, iVar3) : null;
                            bool = Boolean.TRUE;
                            i2 = c0045e.f588d;
                        }
                        c0045e.v(bool, i2, qVar);
                    }
                    return c0045e.p();
                } catch (Throwable th2) {
                    th = th2;
                    c0045e.u();
                    throw th;
                }
            }
            if (andIncrement < cVar.m()) {
                kVar.a();
            }
        }
    }
}
