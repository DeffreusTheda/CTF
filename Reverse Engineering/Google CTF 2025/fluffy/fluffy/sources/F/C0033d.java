package f;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: f.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0033d extends a.a {

    /* renamed from: e, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f493e;

    /* renamed from: f, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f494f;

    /* renamed from: g, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f495g;

    /* renamed from: h, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f496h;

    /* renamed from: i, reason: collision with root package name */
    public final AtomicReferenceFieldUpdater f497i;

    public C0033d(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
        this.f493e = atomicReferenceFieldUpdater;
        this.f494f = atomicReferenceFieldUpdater2;
        this.f495g = atomicReferenceFieldUpdater3;
        this.f496h = atomicReferenceFieldUpdater4;
        this.f497i = atomicReferenceFieldUpdater5;
    }

    @Override // a.a
    public final boolean c(AbstractFutureC0036g abstractFutureC0036g, C0032c c0032c) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        C0032c c0032c2 = C0032c.f491b;
        do {
            atomicReferenceFieldUpdater = this.f496h;
            if (atomicReferenceFieldUpdater.compareAndSet(abstractFutureC0036g, c0032c, c0032c2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(abstractFutureC0036g) == c0032c);
        return false;
    }

    @Override // a.a
    public final boolean d(AbstractFutureC0036g abstractFutureC0036g, Object obj, Object obj2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.f497i;
            if (atomicReferenceFieldUpdater.compareAndSet(abstractFutureC0036g, obj, obj2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(abstractFutureC0036g) == obj);
        return false;
    }

    @Override // a.a
    public final boolean e(AbstractFutureC0036g abstractFutureC0036g, C0035f c0035f, C0035f c0035f2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.f495g;
            if (atomicReferenceFieldUpdater.compareAndSet(abstractFutureC0036g, c0035f, c0035f2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(abstractFutureC0036g) == c0035f);
        return false;
    }

    @Override // a.a
    public final void s(C0035f c0035f, C0035f c0035f2) {
        this.f494f.lazySet(c0035f, c0035f2);
    }

    @Override // a.a
    public final void t(C0035f c0035f, Thread thread) {
        this.f493e.lazySet(c0035f, thread);
    }
}
