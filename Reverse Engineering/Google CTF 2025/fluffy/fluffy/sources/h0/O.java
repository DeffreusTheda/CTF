package h0;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public abstract class O extends m0.l implements InterfaceC0065z, H, Z.l {

    /* renamed from: e, reason: collision with root package name */
    public T f529e;

    @Override // h0.H
    public final boolean b() {
        return true;
    }

    @Override // h0.H
    public final U c() {
        return null;
    }

    @Override // h0.InterfaceC0065z
    public final void e() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2;
        T n2 = n();
        while (true) {
            Object y2 = n2.y();
            if (y2 instanceof O) {
                if (y2 != this) {
                    return;
                }
                A a2 = AbstractC0059t.f584i;
                do {
                    atomicReferenceFieldUpdater2 = T.f542b;
                    if (atomicReferenceFieldUpdater2.compareAndSet(n2, y2, a2)) {
                        return;
                    }
                } while (atomicReferenceFieldUpdater2.get(n2) == y2);
            } else {
                if (!(y2 instanceof H) || ((H) y2).c() == null) {
                    return;
                }
                while (true) {
                    Object k2 = k();
                    if (k2 instanceof m0.s) {
                        m0.l lVar = ((m0.s) k2).f1031a;
                        return;
                    }
                    if (k2 == this) {
                        return;
                    }
                    a0.h.c(k2, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
                    m0.l lVar2 = (m0.l) k2;
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3 = m0.l.f1017d;
                    m0.s sVar = (m0.s) atomicReferenceFieldUpdater3.get(lVar2);
                    if (sVar == null) {
                        sVar = new m0.s(lVar2);
                        atomicReferenceFieldUpdater3.lazySet(lVar2, sVar);
                    }
                    do {
                        atomicReferenceFieldUpdater = m0.l.f1015b;
                        if (atomicReferenceFieldUpdater.compareAndSet(this, k2, sVar)) {
                            lVar2.i();
                            return;
                        }
                    } while (atomicReferenceFieldUpdater.get(this) == k2);
                }
            }
        }
    }

    public final T n() {
        T t2 = this.f529e;
        if (t2 != null) {
            return t2;
        }
        B.c cVar = new B.c("lateinit property job has not been initialized");
        a0.h.f(cVar, a0.h.class.getName());
        throw cVar;
    }

    public abstract void o(Throwable th);

    @Override // m0.l
    public final String toString() {
        return getClass().getSimpleName() + '@' + AbstractC0059t.a(this) + "[job@" + AbstractC0059t.a(n()) + ']';
    }
}
