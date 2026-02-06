package s0;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.internal.n;
import kotlinx.coroutines.internal.y;
import q0.l0;
import s0.i;

/* loaded from: classes.dex */
public abstract class c<E> implements t<E> {

    /* renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f1107d = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "onCloseHandler");

    /* renamed from: b, reason: collision with root package name */
    protected final j0.l<E, a0.q> f1108b;

    /* renamed from: c, reason: collision with root package name */
    private final kotlinx.coroutines.internal.l f1109c = new kotlinx.coroutines.internal.l();
    private volatile /* synthetic */ Object onCloseHandler = null;

    public static final class a<E> extends s {

        /* renamed from: g, reason: collision with root package name */
        public final E f1110g;

        public a(E e2) {
            this.f1110g = e2;
        }

        @Override // s0.s
        public y A(n.b bVar) {
            return q0.m.f1029a;
        }

        @Override // kotlinx.coroutines.internal.n
        public String toString() {
            return "SendBuffered@" + l0.b(this) + '(' + this.f1110g + ')';
        }

        @Override // s0.s
        public void y() {
        }

        @Override // s0.s
        public Object z() {
            return this.f1110g;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(j0.l<? super E, a0.q> lVar) {
        this.f1108b = lVar;
    }

    private final int b() {
        kotlinx.coroutines.internal.l lVar = this.f1109c;
        int i2 = 0;
        for (kotlinx.coroutines.internal.n nVar = (kotlinx.coroutines.internal.n) lVar.o(); !kotlin.jvm.internal.i.a(nVar, lVar); nVar = nVar.p()) {
            if (nVar instanceof kotlinx.coroutines.internal.n) {
                i2++;
            }
        }
        return i2;
    }

    private final String f() {
        kotlinx.coroutines.internal.n p2 = this.f1109c.p();
        if (p2 == this.f1109c) {
            return "EmptyQueue";
        }
        String nVar = p2 instanceof j ? p2.toString() : p2 instanceof o ? "ReceiveQueued" : p2 instanceof s ? "SendQueued" : kotlin.jvm.internal.i.j("UNEXPECTED:", p2);
        kotlinx.coroutines.internal.n q2 = this.f1109c.q();
        if (q2 == p2) {
            return nVar;
        }
        String str = nVar + ",queueSize=" + b();
        if (!(q2 instanceof j)) {
            return str;
        }
        return str + ",closedForSend=" + q2;
    }

    private final void g(j<?> jVar) {
        Object b2 = kotlinx.coroutines.internal.k.b(null, 1, null);
        while (true) {
            kotlinx.coroutines.internal.n q2 = jVar.q();
            o oVar = q2 instanceof o ? (o) q2 : null;
            if (oVar == null) {
                break;
            } else if (oVar.u()) {
                b2 = kotlinx.coroutines.internal.k.c(b2, oVar);
            } else {
                oVar.r();
            }
        }
        if (b2 != null) {
            if (b2 instanceof ArrayList) {
                ArrayList arrayList = (ArrayList) b2;
                int size = arrayList.size() - 1;
                if (size >= 0) {
                    while (true) {
                        int i2 = size - 1;
                        ((o) arrayList.get(size)).z(jVar);
                        if (i2 < 0) {
                            break;
                        } else {
                            size = i2;
                        }
                    }
                }
            } else {
                ((o) b2).z(jVar);
            }
        }
        j(jVar);
    }

    private final Throwable h(j<?> jVar) {
        g(jVar);
        return jVar.F();
    }

    @Override // s0.t
    public final Object a(E e2) {
        i.b bVar;
        j<?> jVar;
        Object i2 = i(e2);
        if (i2 == b.f1102b) {
            return i.f1124a.c(a0.q.f22a);
        }
        if (i2 == b.f1103c) {
            jVar = d();
            if (jVar == null) {
                return i.f1124a.b();
            }
            bVar = i.f1124a;
        } else {
            if (!(i2 instanceof j)) {
                throw new IllegalStateException(kotlin.jvm.internal.i.j("trySend returned ", i2).toString());
            }
            bVar = i.f1124a;
            jVar = (j) i2;
        }
        return bVar.a(h(jVar));
    }

    protected String c() {
        return "";
    }

    protected final j<?> d() {
        kotlinx.coroutines.internal.n q2 = this.f1109c.q();
        j<?> jVar = q2 instanceof j ? (j) q2 : null;
        if (jVar == null) {
            return null;
        }
        g(jVar);
        return jVar;
    }

    protected final kotlinx.coroutines.internal.l e() {
        return this.f1109c;
    }

    protected Object i(E e2) {
        q<E> l2;
        do {
            l2 = l();
            if (l2 == null) {
                return b.f1103c;
            }
        } while (l2.h(e2, null) == null);
        l2.d(e2);
        return l2.e();
    }

    protected void j(kotlinx.coroutines.internal.n nVar) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected final q<?> k(E e2) {
        kotlinx.coroutines.internal.n q2;
        kotlinx.coroutines.internal.l lVar = this.f1109c;
        a aVar = new a(e2);
        do {
            q2 = lVar.q();
            if (q2 instanceof q) {
                return (q) q2;
            }
        } while (!q2.j(aVar, lVar));
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [kotlinx.coroutines.internal.n] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    protected q<E> l() {
        ?? r1;
        kotlinx.coroutines.internal.n v2;
        kotlinx.coroutines.internal.l lVar = this.f1109c;
        while (true) {
            r1 = (kotlinx.coroutines.internal.n) lVar.o();
            if (r1 != lVar && (r1 instanceof q)) {
                if (((((q) r1) instanceof j) && !r1.t()) || (v2 = r1.v()) == null) {
                    break;
                }
                v2.s();
            }
        }
        r1 = 0;
        return (q) r1;
    }

    protected final s m() {
        kotlinx.coroutines.internal.n nVar;
        kotlinx.coroutines.internal.n v2;
        kotlinx.coroutines.internal.l lVar = this.f1109c;
        while (true) {
            nVar = (kotlinx.coroutines.internal.n) lVar.o();
            if (nVar != lVar && (nVar instanceof s)) {
                if (((((s) nVar) instanceof j) && !nVar.t()) || (v2 = nVar.v()) == null) {
                    break;
                }
                v2.s();
            }
        }
        nVar = null;
        return (s) nVar;
    }

    public String toString() {
        return l0.a(this) + '@' + l0.b(this) + '{' + f() + '}' + c();
    }
}
