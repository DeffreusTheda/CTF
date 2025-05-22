package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public class o<E> {

    /* renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f832a = AtomicReferenceFieldUpdater.newUpdater(o.class, Object.class, "_cur");
    private volatile /* synthetic */ Object _cur;

    public o(boolean z2) {
        this._cur = new p(8, z2);
    }

    public final boolean a(E e2) {
        while (true) {
            p pVar = (p) this._cur;
            int a2 = pVar.a(e2);
            if (a2 == 0) {
                return true;
            }
            if (a2 == 1) {
                c.a(f832a, this, pVar, pVar.i());
            } else if (a2 == 2) {
                return false;
            }
        }
    }

    public final void b() {
        while (true) {
            p pVar = (p) this._cur;
            if (pVar.d()) {
                return;
            } else {
                c.a(f832a, this, pVar, pVar.i());
            }
        }
    }

    public final int c() {
        return ((p) this._cur).f();
    }

    public final E d() {
        while (true) {
            p pVar = (p) this._cur;
            E e2 = (E) pVar.j();
            if (e2 != p.f836h) {
                return e2;
            }
            c.a(f832a, this, pVar, pVar.i());
        }
    }
}
