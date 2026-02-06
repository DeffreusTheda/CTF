package q0;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import q0.j1;

/* loaded from: classes.dex */
public class l<T> extends o0<T> implements k<T>, kotlin.coroutines.jvm.internal.e {

    /* renamed from: j, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f1024j = AtomicIntegerFieldUpdater.newUpdater(l.class, "_decision");

    /* renamed from: k, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f1025k = AtomicReferenceFieldUpdater.newUpdater(l.class, Object.class, "_state");
    private volatile /* synthetic */ int _decision;
    private volatile /* synthetic */ Object _state;

    /* renamed from: g, reason: collision with root package name */
    private final c0.d<T> f1026g;

    /* renamed from: h, reason: collision with root package name */
    private final c0.g f1027h;

    /* renamed from: i, reason: collision with root package name */
    private s0 f1028i;

    /* JADX WARN: Multi-variable type inference failed */
    public l(c0.d<? super T> dVar, int i2) {
        super(i2);
        this.f1026g = dVar;
        this.f1027h = dVar.getContext();
        this._decision = 0;
        this._state = d.f1000d;
    }

    private final boolean A() {
        return p0.c(this.f1035f) && ((kotlinx.coroutines.internal.g) this.f1026g).n();
    }

    private final i B(j0.l<? super Throwable, a0.q> lVar) {
        return lVar instanceof i ? (i) lVar : new g1(lVar);
    }

    private final void C(j0.l<? super Throwable, a0.q> lVar, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + lVar + ", already has " + obj).toString());
    }

    private final void F() {
        c0.d<T> dVar = this.f1026g;
        kotlinx.coroutines.internal.g gVar = dVar instanceof kotlinx.coroutines.internal.g ? (kotlinx.coroutines.internal.g) dVar : null;
        Throwable s2 = gVar != null ? gVar.s(this) : null;
        if (s2 == null) {
            return;
        }
        s();
        o(s2);
    }

    private final void H(Object obj, int i2, j0.l<? super Throwable, a0.q> lVar) {
        Object obj2;
        do {
            obj2 = this._state;
            if (!(obj2 instanceof w1)) {
                if (obj2 instanceof o) {
                    o oVar = (o) obj2;
                    if (oVar.c()) {
                        if (lVar == null) {
                            return;
                        }
                        n(lVar, oVar.f1083a);
                        return;
                    }
                }
                i(obj);
                throw new a0.d();
            }
        } while (!kotlinx.coroutines.internal.c.a(f1025k, this, obj2, J((w1) obj2, obj, i2, lVar, null)));
        t();
        u(i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void I(l lVar, Object obj, int i2, j0.l lVar2, int i3, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
        }
        if ((i3 & 4) != 0) {
            lVar2 = null;
        }
        lVar.H(obj, i2, lVar2);
    }

    private final Object J(w1 w1Var, Object obj, int i2, j0.l<? super Throwable, a0.q> lVar, Object obj2) {
        if (obj instanceof y) {
            return obj;
        }
        if (!p0.b(i2) && obj2 == null) {
            return obj;
        }
        if (lVar != null || (((w1Var instanceof i) && !(w1Var instanceof e)) || obj2 != null)) {
            return new x(obj, w1Var instanceof i ? (i) w1Var : null, lVar, obj2, null, 16, null);
        }
        return obj;
    }

    private final boolean K() {
        do {
            int i2 = this._decision;
            if (i2 != 0) {
                if (i2 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f1024j.compareAndSet(this, 0, 2));
        return true;
    }

    private final kotlinx.coroutines.internal.y L(Object obj, Object obj2, j0.l<? super Throwable, a0.q> lVar) {
        Object obj3;
        do {
            obj3 = this._state;
            if (!(obj3 instanceof w1)) {
                if ((obj3 instanceof x) && obj2 != null && ((x) obj3).f1080d == obj2) {
                    return m.f1029a;
                }
                return null;
            }
        } while (!kotlinx.coroutines.internal.c.a(f1025k, this, obj3, J((w1) obj3, obj, this.f1035f, lVar, obj2)));
        t();
        return m.f1029a;
    }

    private final boolean M() {
        do {
            int i2 = this._decision;
            if (i2 != 0) {
                if (i2 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!f1024j.compareAndSet(this, 0, 1));
        return true;
    }

    private final Void i(Object obj) {
        throw new IllegalStateException(kotlin.jvm.internal.i.j("Already resumed, but proposed with update ", obj).toString());
    }

    private final void j(j0.l<? super Throwable, a0.q> lVar, Throwable th) {
        try {
            lVar.invoke(th);
        } catch (Throwable th2) {
            g0.a(getContext(), new b0(kotlin.jvm.internal.i.j("Exception in invokeOnCancellation handler for ", this), th2));
        }
    }

    private final boolean q(Throwable th) {
        if (A()) {
            return ((kotlinx.coroutines.internal.g) this.f1026g).o(th);
        }
        return false;
    }

    private final void t() {
        if (A()) {
            return;
        }
        s();
    }

    private final void u(int i2) {
        if (K()) {
            return;
        }
        p0.a(this, i2);
    }

    private final String y() {
        Object x2 = x();
        return x2 instanceof w1 ? "Active" : x2 instanceof o ? "Cancelled" : "Completed";
    }

    private final s0 z() {
        j1 j1Var = (j1) getContext().get(j1.f1021c);
        if (j1Var == null) {
            return null;
        }
        s0 d2 = j1.a.d(j1Var, true, false, new p(this), 2, null);
        this.f1028i = d2;
        return d2;
    }

    protected String D() {
        return "CancellableContinuation";
    }

    public final void E(Throwable th) {
        if (q(th)) {
            return;
        }
        o(th);
        t();
    }

    public final boolean G() {
        Object obj = this._state;
        if ((obj instanceof x) && ((x) obj).f1080d != null) {
            s();
            return false;
        }
        this._decision = 0;
        this._state = d.f1000d;
        return true;
    }

    @Override // q0.o0
    public void a(Object obj, Throwable th) {
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof w1) {
                throw new IllegalStateException("Not completed".toString());
            }
            if (obj2 instanceof y) {
                return;
            }
            if (obj2 instanceof x) {
                x xVar = (x) obj2;
                if (!(!xVar.c())) {
                    throw new IllegalStateException("Must be called at most once".toString());
                }
                if (kotlinx.coroutines.internal.c.a(f1025k, this, obj2, x.b(xVar, null, null, null, null, th, 15, null))) {
                    xVar.d(this, th);
                    return;
                }
            } else if (kotlinx.coroutines.internal.c.a(f1025k, this, obj2, new x(obj2, null, null, null, th, 14, null))) {
                return;
            }
        }
    }

    @Override // q0.o0
    public final c0.d<T> b() {
        return this.f1026g;
    }

    @Override // q0.o0
    public Throwable c(Object obj) {
        Throwable c2 = super.c(obj);
        if (c2 == null) {
            return null;
        }
        b();
        return c2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // q0.o0
    public <T> T d(Object obj) {
        return obj instanceof x ? (T) ((x) obj).f1077a : obj;
    }

    @Override // q0.k
    public void e(j0.l<? super Throwable, a0.q> lVar) {
        i B = B(lVar);
        while (true) {
            Object obj = this._state;
            if (obj instanceof d) {
                if (kotlinx.coroutines.internal.c.a(f1025k, this, obj, B)) {
                    return;
                }
            } else if (obj instanceof i) {
                C(lVar, obj);
            } else {
                boolean z2 = obj instanceof y;
                if (z2) {
                    y yVar = (y) obj;
                    if (!yVar.b()) {
                        C(lVar, obj);
                    }
                    if (obj instanceof o) {
                        if (!z2) {
                            yVar = null;
                        }
                        j(lVar, yVar != null ? yVar.f1083a : null);
                        return;
                    }
                    return;
                }
                if (obj instanceof x) {
                    x xVar = (x) obj;
                    if (xVar.f1078b != null) {
                        C(lVar, obj);
                    }
                    if (B instanceof e) {
                        return;
                    }
                    if (xVar.c()) {
                        j(lVar, xVar.f1081e);
                        return;
                    } else {
                        if (kotlinx.coroutines.internal.c.a(f1025k, this, obj, x.b(xVar, null, B, null, null, null, 29, null))) {
                            return;
                        }
                    }
                } else {
                    if (B instanceof e) {
                        return;
                    }
                    if (kotlinx.coroutines.internal.c.a(f1025k, this, obj, new x(obj, B, null, null, null, 28, null))) {
                        return;
                    }
                }
            }
        }
    }

    @Override // q0.k
    public Object g(T t2, Object obj) {
        return L(t2, obj, null);
    }

    @Override // kotlin.coroutines.jvm.internal.e
    public kotlin.coroutines.jvm.internal.e getCallerFrame() {
        c0.d<T> dVar = this.f1026g;
        if (dVar instanceof kotlin.coroutines.jvm.internal.e) {
            return (kotlin.coroutines.jvm.internal.e) dVar;
        }
        return null;
    }

    @Override // c0.d
    public c0.g getContext() {
        return this.f1027h;
    }

    @Override // q0.o0
    public Object h() {
        return x();
    }

    @Override // q0.k
    public Object k(T t2, Object obj, j0.l<? super Throwable, a0.q> lVar) {
        return L(t2, obj, lVar);
    }

    @Override // q0.k
    public void l(T t2, j0.l<? super Throwable, a0.q> lVar) {
        H(t2, this.f1035f, lVar);
    }

    public final void m(i iVar, Throwable th) {
        try {
            iVar.a(th);
        } catch (Throwable th2) {
            g0.a(getContext(), new b0(kotlin.jvm.internal.i.j("Exception in invokeOnCancellation handler for ", this), th2));
        }
    }

    public final void n(j0.l<? super Throwable, a0.q> lVar, Throwable th) {
        try {
            lVar.invoke(th);
        } catch (Throwable th2) {
            g0.a(getContext(), new b0(kotlin.jvm.internal.i.j("Exception in resume onCancellation handler for ", this), th2));
        }
    }

    public boolean o(Throwable th) {
        Object obj;
        boolean z2;
        do {
            obj = this._state;
            if (!(obj instanceof w1)) {
                return false;
            }
            z2 = obj instanceof i;
        } while (!kotlinx.coroutines.internal.c.a(f1025k, this, obj, new o(this, th, z2)));
        i iVar = z2 ? (i) obj : null;
        if (iVar != null) {
            m(iVar, th);
        }
        t();
        u(this.f1035f);
        return true;
    }

    @Override // q0.k
    public Object p(Throwable th) {
        return L(new y(th, false, 2, null), null, null);
    }

    @Override // q0.k
    public void r(Object obj) {
        u(this.f1035f);
    }

    @Override // c0.d
    public void resumeWith(Object obj) {
        I(this, c0.c(obj, this), this.f1035f, null, 4, null);
    }

    public final void s() {
        s0 s0Var = this.f1028i;
        if (s0Var == null) {
            return;
        }
        s0Var.b();
        this.f1028i = v1.f1076d;
    }

    public String toString() {
        return D() + '(' + l0.c(this.f1026g) + "){" + y() + "}@" + l0.b(this);
    }

    public Throwable v(j1 j1Var) {
        return j1Var.j();
    }

    public final Object w() {
        j1 j1Var;
        Object c2;
        boolean A = A();
        if (M()) {
            if (this.f1028i == null) {
                z();
            }
            if (A) {
                F();
            }
            c2 = d0.d.c();
            return c2;
        }
        if (A) {
            F();
        }
        Object x2 = x();
        if (x2 instanceof y) {
            throw ((y) x2).f1083a;
        }
        if (!p0.b(this.f1035f) || (j1Var = (j1) getContext().get(j1.f1021c)) == null || j1Var.a()) {
            return d(x2);
        }
        CancellationException j2 = j1Var.j();
        a(x2, j2);
        throw j2;
    }

    public final Object x() {
        return this._state;
    }
}
