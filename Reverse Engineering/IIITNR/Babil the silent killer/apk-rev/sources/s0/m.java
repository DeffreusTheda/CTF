package s0;

import java.util.concurrent.locks.ReentrantLock;
import kotlinx.coroutines.internal.g0;
import kotlinx.coroutines.internal.y;

/* loaded from: classes.dex */
public class m<E> extends a<E> {

    /* renamed from: e, reason: collision with root package name */
    private final ReentrantLock f1128e;

    /* renamed from: f, reason: collision with root package name */
    private Object f1129f;

    public m(j0.l<? super E, a0.q> lVar) {
        super(lVar);
        this.f1128e = new ReentrantLock();
        this.f1129f = b.f1101a;
    }

    private final g0 x(Object obj) {
        j0.l<E, a0.q> lVar;
        Object obj2 = this.f1129f;
        g0 g0Var = null;
        if (obj2 != b.f1101a && (lVar = this.f1108b) != null) {
            g0Var = kotlinx.coroutines.internal.t.d(lVar, obj2, null, 2, null);
        }
        this.f1129f = obj;
        return g0Var;
    }

    @Override // s0.c
    protected String c() {
        return "(value=" + this.f1129f + ')';
    }

    @Override // s0.c
    protected Object i(E e2) {
        q<E> l2;
        ReentrantLock reentrantLock = this.f1128e;
        reentrantLock.lock();
        try {
            j<?> d2 = d();
            if (d2 != null) {
                return d2;
            }
            if (this.f1129f == b.f1101a) {
                do {
                    l2 = l();
                    if (l2 != null) {
                        if (l2 instanceof j) {
                            return l2;
                        }
                    }
                } while (l2.h(e2, null) == null);
                a0.q qVar = a0.q.f22a;
                reentrantLock.unlock();
                l2.d(e2);
                return l2.e();
            }
            g0 x2 = x(e2);
            if (x2 == null) {
                return b.f1102b;
            }
            throw x2;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // s0.a
    protected boolean q(o<? super E> oVar) {
        ReentrantLock reentrantLock = this.f1128e;
        reentrantLock.lock();
        try {
            return super.q(oVar);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // s0.a
    protected final boolean r() {
        return false;
    }

    @Override // s0.a
    protected final boolean s() {
        return this.f1129f == b.f1101a;
    }

    @Override // s0.a
    protected Object v() {
        ReentrantLock reentrantLock = this.f1128e;
        reentrantLock.lock();
        try {
            Object obj = this.f1129f;
            y yVar = b.f1101a;
            if (obj != yVar) {
                this.f1129f = yVar;
                a0.q qVar = a0.q.f22a;
                return obj;
            }
            Object d2 = d();
            if (d2 == null) {
                d2 = b.f1104d;
            }
            return d2;
        } finally {
            reentrantLock.unlock();
        }
    }
}
