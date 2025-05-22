package s0;

import kotlinx.coroutines.internal.n;
import kotlinx.coroutines.internal.y;
import q0.l0;

/* loaded from: classes.dex */
public final class j<E> extends s implements q<E> {

    /* renamed from: g, reason: collision with root package name */
    public final Throwable f1127g;

    @Override // s0.s
    public y A(n.b bVar) {
        return q0.m.f1029a;
    }

    @Override // s0.q
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public j<E> e() {
        return this;
    }

    @Override // s0.s
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public j<E> z() {
        return this;
    }

    public final Throwable E() {
        Throwable th = this.f1127g;
        return th == null ? new k("Channel was closed") : th;
    }

    public final Throwable F() {
        Throwable th = this.f1127g;
        return th == null ? new l("Channel was closed") : th;
    }

    @Override // s0.q
    public void d(E e2) {
    }

    @Override // s0.q
    public y h(E e2, n.b bVar) {
        return q0.m.f1029a;
    }

    @Override // kotlinx.coroutines.internal.n
    public String toString() {
        return "Closed@" + l0.b(this) + '[' + this.f1127g + ']';
    }

    @Override // s0.s
    public void y() {
    }
}
