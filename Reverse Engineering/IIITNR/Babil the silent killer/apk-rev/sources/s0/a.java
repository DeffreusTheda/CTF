package s0;

import a0.k;
import kotlinx.coroutines.internal.n;
import kotlinx.coroutines.internal.x;
import kotlinx.coroutines.internal.y;
import q0.k;
import q0.l0;

/* loaded from: classes.dex */
public abstract class a<E> extends s0.c<E> implements f<E> {

    /* renamed from: s0.a$a, reason: collision with other inner class name */
    private static final class C0026a<E> implements g<E> {

        /* renamed from: a, reason: collision with root package name */
        public final a<E> f1093a;

        /* renamed from: b, reason: collision with root package name */
        private Object f1094b = s0.b.f1104d;

        public C0026a(a<E> aVar) {
            this.f1093a = aVar;
        }

        private final boolean c(Object obj) {
            if (!(obj instanceof j)) {
                return true;
            }
            j jVar = (j) obj;
            if (jVar.f1127g == null) {
                return false;
            }
            throw x.a(jVar.E());
        }

        private final Object d(c0.d<? super Boolean> dVar) {
            c0.d b2;
            Object c2;
            Object a2;
            b2 = d0.c.b(dVar);
            q0.l a3 = q0.n.a(b2);
            b bVar = new b(this, a3);
            while (true) {
                if (this.f1093a.p(bVar)) {
                    this.f1093a.w(a3, bVar);
                    break;
                }
                Object v2 = this.f1093a.v();
                e(v2);
                if (v2 instanceof j) {
                    j jVar = (j) v2;
                    if (jVar.f1127g == null) {
                        a2 = kotlin.coroutines.jvm.internal.b.a(false);
                        k.a aVar = a0.k.f16d;
                    } else {
                        Throwable E = jVar.E();
                        k.a aVar2 = a0.k.f16d;
                        a2 = a0.l.a(E);
                    }
                    a3.resumeWith(a0.k.a(a2));
                } else if (v2 != s0.b.f1104d) {
                    Boolean a4 = kotlin.coroutines.jvm.internal.b.a(true);
                    j0.l<E, a0.q> lVar = this.f1093a.f1108b;
                    a3.l(a4, lVar == null ? null : kotlinx.coroutines.internal.t.a(lVar, v2, a3.getContext()));
                }
            }
            Object w2 = a3.w();
            c2 = d0.d.c();
            if (w2 == c2) {
                kotlin.coroutines.jvm.internal.h.c(dVar);
            }
            return w2;
        }

        @Override // s0.g
        public Object a(c0.d<? super Boolean> dVar) {
            Object b2 = b();
            y yVar = s0.b.f1104d;
            if (b2 == yVar) {
                e(this.f1093a.v());
                if (b() == yVar) {
                    return d(dVar);
                }
            }
            return kotlin.coroutines.jvm.internal.b.a(c(b()));
        }

        public final Object b() {
            return this.f1094b;
        }

        public final void e(Object obj) {
            this.f1094b = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // s0.g
        public E next() {
            E e2 = (E) this.f1094b;
            if (e2 instanceof j) {
                throw x.a(((j) e2).E());
            }
            y yVar = s0.b.f1104d;
            if (e2 == yVar) {
                throw new IllegalStateException("'hasNext' should be called prior to 'next' invocation");
            }
            this.f1094b = yVar;
            return e2;
        }
    }

    private static class b<E> extends o<E> {

        /* renamed from: g, reason: collision with root package name */
        public final C0026a<E> f1095g;

        /* renamed from: h, reason: collision with root package name */
        public final q0.k<Boolean> f1096h;

        /* JADX WARN: Multi-variable type inference failed */
        public b(C0026a<E> c0026a, q0.k<? super Boolean> kVar) {
            this.f1095g = c0026a;
            this.f1096h = kVar;
        }

        public j0.l<Throwable, a0.q> A(E e2) {
            j0.l<E, a0.q> lVar = this.f1095g.f1093a.f1108b;
            if (lVar == null) {
                return null;
            }
            return kotlinx.coroutines.internal.t.a(lVar, e2, this.f1096h.getContext());
        }

        @Override // s0.q
        public void d(E e2) {
            this.f1095g.e(e2);
            this.f1096h.r(q0.m.f1029a);
        }

        @Override // s0.q
        public y h(E e2, n.b bVar) {
            if (this.f1096h.k(Boolean.TRUE, null, A(e2)) == null) {
                return null;
            }
            return q0.m.f1029a;
        }

        @Override // kotlinx.coroutines.internal.n
        public String toString() {
            return kotlin.jvm.internal.i.j("ReceiveHasNext@", l0.b(this));
        }

        @Override // s0.o
        public void z(j<?> jVar) {
            Object a2 = jVar.f1127g == null ? k.a.a(this.f1096h, Boolean.FALSE, null, 2, null) : this.f1096h.p(jVar.E());
            if (a2 != null) {
                this.f1095g.e(jVar);
                this.f1096h.r(a2);
            }
        }
    }

    private final class c extends q0.e {

        /* renamed from: d, reason: collision with root package name */
        private final o<?> f1097d;

        public c(o<?> oVar) {
            this.f1097d = oVar;
        }

        @Override // q0.j
        public void a(Throwable th) {
            if (this.f1097d.u()) {
                a.this.t();
            }
        }

        @Override // j0.l
        public /* bridge */ /* synthetic */ a0.q invoke(Throwable th) {
            a(th);
            return a0.q.f22a;
        }

        public String toString() {
            return "RemoveReceiveOnCancel[" + this.f1097d + ']';
        }
    }

    public static final class d extends n.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.internal.n f1099d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f1100e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(kotlinx.coroutines.internal.n nVar, a aVar) {
            super(nVar);
            this.f1099d = nVar;
            this.f1100e = aVar;
        }

        @Override // kotlinx.coroutines.internal.d
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Object g(kotlinx.coroutines.internal.n nVar) {
            if (this.f1100e.s()) {
                return null;
            }
            return kotlinx.coroutines.internal.m.a();
        }
    }

    public a(j0.l<? super E, a0.q> lVar) {
        super(lVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean p(o<? super E> oVar) {
        boolean q2 = q(oVar);
        if (q2) {
            u();
        }
        return q2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(q0.k<?> kVar, o<?> oVar) {
        kVar.e(new c(oVar));
    }

    @Override // s0.p
    public final g<E> iterator() {
        return new C0026a(this);
    }

    @Override // s0.c
    protected q<E> l() {
        q<E> l2 = super.l();
        if (l2 != null && !(l2 instanceof j)) {
            t();
        }
        return l2;
    }

    protected boolean q(o<? super E> oVar) {
        int x2;
        kotlinx.coroutines.internal.n q2;
        if (!r()) {
            kotlinx.coroutines.internal.n e2 = e();
            d dVar = new d(oVar, this);
            do {
                kotlinx.coroutines.internal.n q3 = e2.q();
                if (!(!(q3 instanceof s))) {
                    return false;
                }
                x2 = q3.x(oVar, e2, dVar);
                if (x2 != 1) {
                }
            } while (x2 != 2);
            return false;
        }
        kotlinx.coroutines.internal.n e3 = e();
        do {
            q2 = e3.q();
            if (!(!(q2 instanceof s))) {
                return false;
            }
        } while (!q2.j(oVar, e3));
        return true;
    }

    protected abstract boolean r();

    protected abstract boolean s();

    protected void t() {
    }

    protected void u() {
    }

    protected Object v() {
        while (true) {
            s m2 = m();
            if (m2 == null) {
                return s0.b.f1104d;
            }
            if (m2.A(null) != null) {
                m2.y();
                return m2.z();
            }
            m2.B();
        }
    }
}
