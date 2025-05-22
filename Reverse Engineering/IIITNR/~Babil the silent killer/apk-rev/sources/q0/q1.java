package q0;

import c0.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.internal.n;
import q0.j1;

/* loaded from: classes.dex */
public class q1 implements j1, s, x1 {

    /* renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f1039d = AtomicReferenceFieldUpdater.newUpdater(q1.class, Object.class, "_state");
    private volatile /* synthetic */ Object _parentHandle;
    private volatile /* synthetic */ Object _state;

    private static final class a extends p1 {

        /* renamed from: h, reason: collision with root package name */
        private final q1 f1040h;

        /* renamed from: i, reason: collision with root package name */
        private final b f1041i;

        /* renamed from: j, reason: collision with root package name */
        private final r f1042j;

        /* renamed from: k, reason: collision with root package name */
        private final Object f1043k;

        public a(q1 q1Var, b bVar, r rVar, Object obj) {
            this.f1040h = q1Var;
            this.f1041i = bVar;
            this.f1042j = rVar;
            this.f1043k = obj;
        }

        @Override // j0.l
        public /* bridge */ /* synthetic */ a0.q invoke(Throwable th) {
            y(th);
            return a0.q.f22a;
        }

        @Override // q0.a0
        public void y(Throwable th) {
            this.f1040h.F(this.f1041i, this.f1042j, this.f1043k);
        }
    }

    private static final class b implements e1 {
        private volatile /* synthetic */ Object _exceptionsHolder = null;
        private volatile /* synthetic */ int _isCompleting;
        private volatile /* synthetic */ Object _rootCause;

        /* renamed from: d, reason: collision with root package name */
        private final u1 f1044d;

        public b(u1 u1Var, boolean z2, Throwable th) {
            this.f1044d = u1Var;
            this._isCompleting = z2 ? 1 : 0;
            this._rootCause = th;
        }

        private final ArrayList<Throwable> d() {
            return new ArrayList<>(4);
        }

        private final Object e() {
            return this._exceptionsHolder;
        }

        private final void l(Object obj) {
            this._exceptionsHolder = obj;
        }

        @Override // q0.e1
        public boolean a() {
            return f() == null;
        }

        public final void b(Throwable th) {
            Throwable f2 = f();
            if (f2 == null) {
                m(th);
                return;
            }
            if (th == f2) {
                return;
            }
            Object e2 = e();
            if (e2 == null) {
                l(th);
                return;
            }
            if (!(e2 instanceof Throwable)) {
                if (!(e2 instanceof ArrayList)) {
                    throw new IllegalStateException(kotlin.jvm.internal.i.j("State is ", e2).toString());
                }
                ((ArrayList) e2).add(th);
            } else {
                if (th == e2) {
                    return;
                }
                ArrayList<Throwable> d2 = d();
                d2.add(e2);
                d2.add(th);
                a0.q qVar = a0.q.f22a;
                l(d2);
            }
        }

        @Override // q0.e1
        public u1 c() {
            return this.f1044d;
        }

        public final Throwable f() {
            return (Throwable) this._rootCause;
        }

        public final boolean g() {
            return f() != null;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
        public final boolean h() {
            return this._isCompleting;
        }

        public final boolean i() {
            kotlinx.coroutines.internal.y yVar;
            Object e2 = e();
            yVar = r1.f1057e;
            return e2 == yVar;
        }

        public final List<Throwable> j(Throwable th) {
            ArrayList<Throwable> arrayList;
            kotlinx.coroutines.internal.y yVar;
            Object e2 = e();
            if (e2 == null) {
                arrayList = d();
            } else if (e2 instanceof Throwable) {
                ArrayList<Throwable> d2 = d();
                d2.add(e2);
                arrayList = d2;
            } else {
                if (!(e2 instanceof ArrayList)) {
                    throw new IllegalStateException(kotlin.jvm.internal.i.j("State is ", e2).toString());
                }
                arrayList = (ArrayList) e2;
            }
            Throwable f2 = f();
            if (f2 != null) {
                arrayList.add(0, f2);
            }
            if (th != null && !kotlin.jvm.internal.i.a(th, f2)) {
                arrayList.add(th);
            }
            yVar = r1.f1057e;
            l(yVar);
            return arrayList;
        }

        public final void k(boolean z2) {
            this._isCompleting = z2 ? 1 : 0;
        }

        public final void m(Throwable th) {
            this._rootCause = th;
        }

        public String toString() {
            return "Finishing[cancelling=" + g() + ", completing=" + h() + ", rootCause=" + f() + ", exceptions=" + e() + ", list=" + c() + ']';
        }
    }

    public static final class c extends n.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.internal.n f1045d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ q1 f1046e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Object f1047f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(kotlinx.coroutines.internal.n nVar, q1 q1Var, Object obj) {
            super(nVar);
            this.f1045d = nVar;
            this.f1046e = q1Var;
            this.f1047f = obj;
        }

        @Override // kotlinx.coroutines.internal.d
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Object g(kotlinx.coroutines.internal.n nVar) {
            if (this.f1046e.P() == this.f1047f) {
                return null;
            }
            return kotlinx.coroutines.internal.m.a();
        }
    }

    public q1(boolean z2) {
        this._state = z2 ? r1.f1059g : r1.f1058f;
        this._parentHandle = null;
    }

    private final Object A(Object obj) {
        kotlinx.coroutines.internal.y yVar;
        Object q02;
        kotlinx.coroutines.internal.y yVar2;
        do {
            Object P = P();
            if (!(P instanceof e1) || ((P instanceof b) && ((b) P).h())) {
                yVar = r1.f1053a;
                return yVar;
            }
            q02 = q0(P, new y(G(obj), false, 2, null));
            yVar2 = r1.f1055c;
        } while (q02 == yVar2);
        return q02;
    }

    private final boolean B(Throwable th) {
        if (U()) {
            return true;
        }
        boolean z2 = th instanceof CancellationException;
        q O = O();
        return (O == null || O == v1.f1076d) ? z2 : O.g(th) || z2;
    }

    private final void E(e1 e1Var, Object obj) {
        q O = O();
        if (O != null) {
            O.b();
            i0(v1.f1076d);
        }
        y yVar = obj instanceof y ? (y) obj : null;
        Throwable th = yVar != null ? yVar.f1083a : null;
        if (!(e1Var instanceof p1)) {
            u1 c2 = e1Var.c();
            if (c2 == null) {
                return;
            }
            b0(c2, th);
            return;
        }
        try {
            ((p1) e1Var).y(th);
        } catch (Throwable th2) {
            R(new b0("Exception in completion handler " + e1Var + " for " + this, th2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F(b bVar, r rVar, Object obj) {
        r Z = Z(rVar);
        if (Z == null || !s0(bVar, Z, obj)) {
            x(H(bVar, obj));
        }
    }

    private final Throwable G(Object obj) {
        if (obj == null ? true : obj instanceof Throwable) {
            Throwable th = (Throwable) obj;
            return th == null ? new k1(C(), null, this) : th;
        }
        if (obj != null) {
            return ((x1) obj).c();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
    }

    private final Object H(b bVar, Object obj) {
        boolean g2;
        Throwable K;
        y yVar = obj instanceof y ? (y) obj : null;
        Throwable th = yVar == null ? null : yVar.f1083a;
        synchronized (bVar) {
            g2 = bVar.g();
            List<Throwable> j2 = bVar.j(th);
            K = K(bVar, j2);
            if (K != null) {
                w(K, j2);
            }
        }
        if (K != null && K != th) {
            obj = new y(K, false, 2, null);
        }
        if (K != null) {
            if (B(K) || Q(K)) {
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                }
                ((y) obj).b();
            }
        }
        if (!g2) {
            c0(K);
        }
        d0(obj);
        kotlinx.coroutines.internal.c.a(f1039d, this, bVar, r1.g(obj));
        E(bVar, obj);
        return obj;
    }

    private final r I(e1 e1Var) {
        r rVar = e1Var instanceof r ? (r) e1Var : null;
        if (rVar != null) {
            return rVar;
        }
        u1 c2 = e1Var.c();
        if (c2 == null) {
            return null;
        }
        return Z(c2);
    }

    private final Throwable J(Object obj) {
        y yVar = obj instanceof y ? (y) obj : null;
        if (yVar == null) {
            return null;
        }
        return yVar.f1083a;
    }

    private final Throwable K(b bVar, List<? extends Throwable> list) {
        Object obj = null;
        if (list.isEmpty()) {
            if (bVar.g()) {
                return new k1(C(), null, this);
            }
            return null;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (!(((Throwable) next) instanceof CancellationException)) {
                obj = next;
                break;
            }
        }
        Throwable th = (Throwable) obj;
        return th != null ? th : list.get(0);
    }

    private final u1 N(e1 e1Var) {
        u1 c2 = e1Var.c();
        if (c2 != null) {
            return c2;
        }
        if (e1Var instanceof t0) {
            return new u1();
        }
        if (!(e1Var instanceof p1)) {
            throw new IllegalStateException(kotlin.jvm.internal.i.j("State should have list: ", e1Var).toString());
        }
        g0((p1) e1Var);
        return null;
    }

    private final Object V(Object obj) {
        kotlinx.coroutines.internal.y yVar;
        kotlinx.coroutines.internal.y yVar2;
        kotlinx.coroutines.internal.y yVar3;
        kotlinx.coroutines.internal.y yVar4;
        kotlinx.coroutines.internal.y yVar5;
        kotlinx.coroutines.internal.y yVar6;
        Throwable th = null;
        while (true) {
            Object P = P();
            if (P instanceof b) {
                synchronized (P) {
                    if (((b) P).i()) {
                        yVar2 = r1.f1056d;
                        return yVar2;
                    }
                    boolean g2 = ((b) P).g();
                    if (obj != null || !g2) {
                        if (th == null) {
                            th = G(obj);
                        }
                        ((b) P).b(th);
                    }
                    Throwable f2 = g2 ^ true ? ((b) P).f() : null;
                    if (f2 != null) {
                        a0(((b) P).c(), f2);
                    }
                    yVar = r1.f1053a;
                    return yVar;
                }
            }
            if (!(P instanceof e1)) {
                yVar3 = r1.f1056d;
                return yVar3;
            }
            if (th == null) {
                th = G(obj);
            }
            e1 e1Var = (e1) P;
            if (!e1Var.a()) {
                Object q02 = q0(P, new y(th, false, 2, null));
                yVar5 = r1.f1053a;
                if (q02 == yVar5) {
                    throw new IllegalStateException(kotlin.jvm.internal.i.j("Cannot happen in ", P).toString());
                }
                yVar6 = r1.f1055c;
                if (q02 != yVar6) {
                    return q02;
                }
            } else if (p0(e1Var, th)) {
                yVar4 = r1.f1053a;
                return yVar4;
            }
        }
    }

    private final p1 X(j0.l<? super Throwable, a0.q> lVar, boolean z2) {
        p1 p1Var;
        if (z2) {
            p1Var = lVar instanceof l1 ? (l1) lVar : null;
            if (p1Var == null) {
                p1Var = new h1(lVar);
            }
        } else {
            p1 p1Var2 = lVar instanceof p1 ? (p1) lVar : null;
            p1Var = p1Var2 != null ? p1Var2 : null;
            if (p1Var == null) {
                p1Var = new i1(lVar);
            }
        }
        p1Var.A(this);
        return p1Var;
    }

    private final r Z(kotlinx.coroutines.internal.n nVar) {
        while (nVar.t()) {
            nVar = nVar.q();
        }
        while (true) {
            nVar = nVar.p();
            if (!nVar.t()) {
                if (nVar instanceof r) {
                    return (r) nVar;
                }
                if (nVar instanceof u1) {
                    return null;
                }
            }
        }
    }

    private final void a0(u1 u1Var, Throwable th) {
        b0 b0Var;
        c0(th);
        b0 b0Var2 = null;
        for (kotlinx.coroutines.internal.n nVar = (kotlinx.coroutines.internal.n) u1Var.o(); !kotlin.jvm.internal.i.a(nVar, u1Var); nVar = nVar.p()) {
            if (nVar instanceof l1) {
                p1 p1Var = (p1) nVar;
                try {
                    p1Var.y(th);
                } catch (Throwable th2) {
                    if (b0Var2 == null) {
                        b0Var = null;
                    } else {
                        a0.b.a(b0Var2, th2);
                        b0Var = b0Var2;
                    }
                    if (b0Var == null) {
                        b0Var2 = new b0("Exception in completion handler " + p1Var + " for " + this, th2);
                    }
                }
            }
        }
        if (b0Var2 != null) {
            R(b0Var2);
        }
        B(th);
    }

    private final void b0(u1 u1Var, Throwable th) {
        b0 b0Var;
        b0 b0Var2 = null;
        for (kotlinx.coroutines.internal.n nVar = (kotlinx.coroutines.internal.n) u1Var.o(); !kotlin.jvm.internal.i.a(nVar, u1Var); nVar = nVar.p()) {
            if (nVar instanceof p1) {
                p1 p1Var = (p1) nVar;
                try {
                    p1Var.y(th);
                } catch (Throwable th2) {
                    if (b0Var2 == null) {
                        b0Var = null;
                    } else {
                        a0.b.a(b0Var2, th2);
                        b0Var = b0Var2;
                    }
                    if (b0Var == null) {
                        b0Var2 = new b0("Exception in completion handler " + p1Var + " for " + this, th2);
                    }
                }
            }
        }
        if (b0Var2 == null) {
            return;
        }
        R(b0Var2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [q0.d1] */
    private final void f0(t0 t0Var) {
        u1 u1Var = new u1();
        if (!t0Var.a()) {
            u1Var = new d1(u1Var);
        }
        kotlinx.coroutines.internal.c.a(f1039d, this, t0Var, u1Var);
    }

    private final void g0(p1 p1Var) {
        p1Var.k(new u1());
        kotlinx.coroutines.internal.c.a(f1039d, this, p1Var, p1Var.p());
    }

    private final int j0(Object obj) {
        t0 t0Var;
        if (!(obj instanceof t0)) {
            if (!(obj instanceof d1)) {
                return 0;
            }
            if (!kotlinx.coroutines.internal.c.a(f1039d, this, obj, ((d1) obj).c())) {
                return -1;
            }
            e0();
            return 1;
        }
        if (((t0) obj).a()) {
            return 0;
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1039d;
        t0Var = r1.f1059g;
        if (!kotlinx.coroutines.internal.c.a(atomicReferenceFieldUpdater, this, obj, t0Var)) {
            return -1;
        }
        e0();
        return 1;
    }

    private final String k0(Object obj) {
        if (!(obj instanceof b)) {
            return obj instanceof e1 ? ((e1) obj).a() ? "Active" : "New" : obj instanceof y ? "Cancelled" : "Completed";
        }
        b bVar = (b) obj;
        return bVar.g() ? "Cancelling" : bVar.h() ? "Completing" : "Active";
    }

    public static /* synthetic */ CancellationException m0(q1 q1Var, Throwable th, String str, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
        }
        if ((i2 & 1) != 0) {
            str = null;
        }
        return q1Var.l0(th, str);
    }

    private final boolean o0(e1 e1Var, Object obj) {
        if (!kotlinx.coroutines.internal.c.a(f1039d, this, e1Var, r1.g(obj))) {
            return false;
        }
        c0(null);
        d0(obj);
        E(e1Var, obj);
        return true;
    }

    private final boolean p0(e1 e1Var, Throwable th) {
        u1 N = N(e1Var);
        if (N == null) {
            return false;
        }
        if (!kotlinx.coroutines.internal.c.a(f1039d, this, e1Var, new b(N, false, th))) {
            return false;
        }
        a0(N, th);
        return true;
    }

    private final Object q0(Object obj, Object obj2) {
        kotlinx.coroutines.internal.y yVar;
        kotlinx.coroutines.internal.y yVar2;
        if (!(obj instanceof e1)) {
            yVar2 = r1.f1053a;
            return yVar2;
        }
        if ((!(obj instanceof t0) && !(obj instanceof p1)) || (obj instanceof r) || (obj2 instanceof y)) {
            return r0((e1) obj, obj2);
        }
        if (o0((e1) obj, obj2)) {
            return obj2;
        }
        yVar = r1.f1055c;
        return yVar;
    }

    private final Object r0(e1 e1Var, Object obj) {
        kotlinx.coroutines.internal.y yVar;
        kotlinx.coroutines.internal.y yVar2;
        kotlinx.coroutines.internal.y yVar3;
        u1 N = N(e1Var);
        if (N == null) {
            yVar3 = r1.f1055c;
            return yVar3;
        }
        b bVar = e1Var instanceof b ? (b) e1Var : null;
        if (bVar == null) {
            bVar = new b(N, false, null);
        }
        synchronized (bVar) {
            if (bVar.h()) {
                yVar2 = r1.f1053a;
                return yVar2;
            }
            bVar.k(true);
            if (bVar != e1Var && !kotlinx.coroutines.internal.c.a(f1039d, this, e1Var, bVar)) {
                yVar = r1.f1055c;
                return yVar;
            }
            boolean g2 = bVar.g();
            y yVar4 = obj instanceof y ? (y) obj : null;
            if (yVar4 != null) {
                bVar.b(yVar4.f1083a);
            }
            Throwable f2 = true ^ g2 ? bVar.f() : null;
            a0.q qVar = a0.q.f22a;
            if (f2 != null) {
                a0(N, f2);
            }
            r I = I(e1Var);
            return (I == null || !s0(bVar, I, obj)) ? H(bVar, obj) : r1.f1054b;
        }
    }

    private final boolean s0(b bVar, r rVar, Object obj) {
        while (j1.a.d(rVar.f1048h, false, false, new a(this, bVar, rVar, obj), 1, null) == v1.f1076d) {
            rVar = Z(rVar);
            if (rVar == null) {
                return false;
            }
        }
        return true;
    }

    private final boolean v(Object obj, u1 u1Var, p1 p1Var) {
        int x2;
        c cVar = new c(p1Var, this, obj);
        do {
            x2 = u1Var.q().x(p1Var, u1Var, cVar);
            if (x2 == 1) {
                return true;
            }
        } while (x2 != 2);
        return false;
    }

    private final void w(Throwable th, List<? extends Throwable> list) {
        if (list.size() <= 1) {
            return;
        }
        Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
        for (Throwable th2 : list) {
            if (th2 != th && th2 != th && !(th2 instanceof CancellationException) && newSetFromMap.add(th2)) {
                a0.b.a(th, th2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String C() {
        return "Job was cancelled";
    }

    public boolean D(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return y(th) && L();
    }

    public boolean L() {
        return true;
    }

    public boolean M() {
        return false;
    }

    public final q O() {
        return (q) this._parentHandle;
    }

    public final Object P() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof kotlinx.coroutines.internal.u)) {
                return obj;
            }
            ((kotlinx.coroutines.internal.u) obj).c(this);
        }
    }

    protected boolean Q(Throwable th) {
        return false;
    }

    public void R(Throwable th) {
        throw th;
    }

    protected final void S(j1 j1Var) {
        if (j1Var == null) {
            i0(v1.f1076d);
            return;
        }
        j1Var.m();
        q q2 = j1Var.q(this);
        i0(q2);
        if (T()) {
            q2.b();
            i0(v1.f1076d);
        }
    }

    public final boolean T() {
        return !(P() instanceof e1);
    }

    protected boolean U() {
        return false;
    }

    public final Object W(Object obj) {
        Object q02;
        kotlinx.coroutines.internal.y yVar;
        kotlinx.coroutines.internal.y yVar2;
        do {
            q02 = q0(P(), obj);
            yVar = r1.f1053a;
            if (q02 == yVar) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, J(obj));
            }
            yVar2 = r1.f1055c;
        } while (q02 == yVar2);
        return q02;
    }

    public String Y() {
        return l0.a(this);
    }

    @Override // q0.j1
    public boolean a() {
        Object P = P();
        return (P instanceof e1) && ((e1) P).a();
    }

    @Override // q0.j1
    public void b(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new k1(C(), null, this);
        }
        z(cancellationException);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.lang.Throwable] */
    @Override // q0.x1
    public CancellationException c() {
        CancellationException cancellationException;
        Object P = P();
        if (P instanceof b) {
            cancellationException = ((b) P).f();
        } else if (P instanceof y) {
            cancellationException = ((y) P).f1083a;
        } else {
            if (P instanceof e1) {
                throw new IllegalStateException(kotlin.jvm.internal.i.j("Cannot be cancelling child in this state: ", P).toString());
            }
            cancellationException = null;
        }
        CancellationException cancellationException2 = cancellationException instanceof CancellationException ? cancellationException : null;
        return cancellationException2 == null ? new k1(kotlin.jvm.internal.i.j("Parent job is ", k0(P)), cancellationException, this) : cancellationException2;
    }

    protected void c0(Throwable th) {
    }

    protected void d0(Object obj) {
    }

    protected void e0() {
    }

    @Override // q0.j1
    public final s0 f(boolean z2, boolean z3, j0.l<? super Throwable, a0.q> lVar) {
        p1 X = X(lVar, z2);
        while (true) {
            Object P = P();
            if (P instanceof t0) {
                t0 t0Var = (t0) P;
                if (!t0Var.a()) {
                    f0(t0Var);
                } else if (kotlinx.coroutines.internal.c.a(f1039d, this, P, X)) {
                    return X;
                }
            } else {
                if (!(P instanceof e1)) {
                    if (z3) {
                        y yVar = P instanceof y ? (y) P : null;
                        lVar.invoke(yVar != null ? yVar.f1083a : null);
                    }
                    return v1.f1076d;
                }
                u1 c2 = ((e1) P).c();
                if (c2 != null) {
                    s0 s0Var = v1.f1076d;
                    if (z2 && (P instanceof b)) {
                        synchronized (P) {
                            r3 = ((b) P).f();
                            if (r3 == null || ((lVar instanceof r) && !((b) P).h())) {
                                if (v(P, c2, X)) {
                                    if (r3 == null) {
                                        return X;
                                    }
                                    s0Var = X;
                                }
                            }
                            a0.q qVar = a0.q.f22a;
                        }
                    }
                    if (r3 != null) {
                        if (z3) {
                            lVar.invoke(r3);
                        }
                        return s0Var;
                    }
                    if (v(P, c2, X)) {
                        return X;
                    }
                } else {
                    if (P == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    }
                    g0((p1) P);
                }
            }
        }
    }

    @Override // c0.g
    public <R> R fold(R r2, j0.p<? super R, ? super g.b, ? extends R> pVar) {
        return (R) j1.a.b(this, r2, pVar);
    }

    @Override // c0.g.b, c0.g
    public <E extends g.b> E get(g.c<E> cVar) {
        return (E) j1.a.c(this, cVar);
    }

    @Override // c0.g.b
    public final g.c<?> getKey() {
        return j1.f1021c;
    }

    public final void h0(p1 p1Var) {
        Object P;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        t0 t0Var;
        do {
            P = P();
            if (!(P instanceof p1)) {
                if (!(P instanceof e1) || ((e1) P).c() == null) {
                    return;
                }
                p1Var.u();
                return;
            }
            if (P != p1Var) {
                return;
            }
            atomicReferenceFieldUpdater = f1039d;
            t0Var = r1.f1059g;
        } while (!kotlinx.coroutines.internal.c.a(atomicReferenceFieldUpdater, this, P, t0Var));
    }

    public final void i0(q qVar) {
        this._parentHandle = qVar;
    }

    @Override // q0.j1
    public final CancellationException j() {
        Object P = P();
        if (!(P instanceof b)) {
            if (P instanceof e1) {
                throw new IllegalStateException(kotlin.jvm.internal.i.j("Job is still new or active: ", this).toString());
            }
            return P instanceof y ? m0(this, ((y) P).f1083a, null, 1, null) : new k1(kotlin.jvm.internal.i.j(l0.a(this), " has completed normally"), null, this);
        }
        Throwable f2 = ((b) P).f();
        if (f2 != null) {
            return l0(f2, kotlin.jvm.internal.i.j(l0.a(this), " is cancelling"));
        }
        throw new IllegalStateException(kotlin.jvm.internal.i.j("Job is still new or active: ", this).toString());
    }

    protected final CancellationException l0(Throwable th, String str) {
        CancellationException cancellationException = th instanceof CancellationException ? (CancellationException) th : null;
        if (cancellationException == null) {
            if (str == null) {
                str = C();
            }
            cancellationException = new k1(str, th, this);
        }
        return cancellationException;
    }

    @Override // q0.j1
    public final boolean m() {
        int j02;
        do {
            j02 = j0(P());
            if (j02 == 0) {
                return false;
            }
        } while (j02 != 1);
        return true;
    }

    @Override // c0.g
    public c0.g minusKey(g.c<?> cVar) {
        return j1.a.e(this, cVar);
    }

    public final String n0() {
        return Y() + '{' + k0(P()) + '}';
    }

    @Override // q0.s
    public final void o(x1 x1Var) {
        y(x1Var);
    }

    @Override // c0.g
    public c0.g plus(c0.g gVar) {
        return j1.a.f(this, gVar);
    }

    @Override // q0.j1
    public final q q(s sVar) {
        return (q) j1.a.d(this, true, false, new r(sVar), 2, null);
    }

    public String toString() {
        return n0() + '@' + l0.b(this);
    }

    protected void x(Object obj) {
    }

    public final boolean y(Object obj) {
        Object obj2;
        kotlinx.coroutines.internal.y yVar;
        kotlinx.coroutines.internal.y yVar2;
        kotlinx.coroutines.internal.y yVar3;
        obj2 = r1.f1053a;
        if (M() && (obj2 = A(obj)) == r1.f1054b) {
            return true;
        }
        yVar = r1.f1053a;
        if (obj2 == yVar) {
            obj2 = V(obj);
        }
        yVar2 = r1.f1053a;
        if (obj2 == yVar2 || obj2 == r1.f1054b) {
            return true;
        }
        yVar3 = r1.f1056d;
        if (obj2 == yVar3) {
            return false;
        }
        x(obj2);
        return true;
    }

    public void z(Throwable th) {
        y(th);
    }
}
