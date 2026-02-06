package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public class n {

    /* renamed from: d, reason: collision with root package name */
    static final /* synthetic */ AtomicReferenceFieldUpdater f827d = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "_next");

    /* renamed from: e, reason: collision with root package name */
    static final /* synthetic */ AtomicReferenceFieldUpdater f828e = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "_prev");

    /* renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f829f = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "_removedRef");
    volatile /* synthetic */ Object _next = this;
    volatile /* synthetic */ Object _prev = this;
    private volatile /* synthetic */ Object _removedRef = null;

    public static abstract class a extends d<n> {

        /* renamed from: b, reason: collision with root package name */
        public final n f830b;

        /* renamed from: c, reason: collision with root package name */
        public n f831c;

        public a(n nVar) {
            this.f830b = nVar;
        }

        @Override // kotlinx.coroutines.internal.d
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void d(n nVar, Object obj) {
            boolean z2 = obj == null;
            n nVar2 = z2 ? this.f830b : this.f831c;
            if (nVar2 != null && c.a(n.f827d, nVar, this, nVar2) && z2) {
                n nVar3 = this.f830b;
                n nVar4 = this.f831c;
                kotlin.jvm.internal.i.b(nVar4);
                nVar3.n(nVar4);
            }
        }
    }

    public static final class b extends u {
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0048, code lost:
    
        if (kotlinx.coroutines.internal.c.a(kotlinx.coroutines.internal.n.f827d, r3, r2, ((kotlinx.coroutines.internal.v) r4).f851a) != false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final kotlinx.coroutines.internal.n l(kotlinx.coroutines.internal.u r8) {
        /*
            r7 = this;
        L0:
            java.lang.Object r0 = r7._prev
            kotlinx.coroutines.internal.n r0 = (kotlinx.coroutines.internal.n) r0
            r1 = 0
            r2 = r0
        L6:
            r3 = r1
        L7:
            java.lang.Object r4 = r2._next
            if (r4 != r7) goto L18
            if (r0 != r2) goto Le
            return r2
        Le:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = kotlinx.coroutines.internal.n.f828e
            boolean r0 = kotlinx.coroutines.internal.c.a(r1, r7, r0, r2)
            if (r0 != 0) goto L17
            goto L0
        L17:
            return r2
        L18:
            boolean r5 = r7.t()
            if (r5 == 0) goto L1f
            return r1
        L1f:
            if (r4 != r8) goto L22
            return r2
        L22:
            boolean r5 = r4 instanceof kotlinx.coroutines.internal.u
            if (r5 == 0) goto L38
            if (r8 == 0) goto L32
            r0 = r4
            kotlinx.coroutines.internal.u r0 = (kotlinx.coroutines.internal.u) r0
            boolean r0 = r8.b(r0)
            if (r0 == 0) goto L32
            return r1
        L32:
            kotlinx.coroutines.internal.u r4 = (kotlinx.coroutines.internal.u) r4
            r4.c(r2)
            goto L0
        L38:
            boolean r5 = r4 instanceof kotlinx.coroutines.internal.v
            if (r5 == 0) goto L52
            if (r3 == 0) goto L4d
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = kotlinx.coroutines.internal.n.f827d
            kotlinx.coroutines.internal.v r4 = (kotlinx.coroutines.internal.v) r4
            kotlinx.coroutines.internal.n r4 = r4.f851a
            boolean r2 = kotlinx.coroutines.internal.c.a(r5, r3, r2, r4)
            if (r2 != 0) goto L4b
            goto L0
        L4b:
            r2 = r3
            goto L6
        L4d:
            java.lang.Object r2 = r2._prev
            kotlinx.coroutines.internal.n r2 = (kotlinx.coroutines.internal.n) r2
            goto L7
        L52:
            r3 = r4
            kotlinx.coroutines.internal.n r3 = (kotlinx.coroutines.internal.n) r3
            r6 = r3
            r3 = r2
            r2 = r6
            goto L7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.n.l(kotlinx.coroutines.internal.u):kotlinx.coroutines.internal.n");
    }

    private final n m(n nVar) {
        while (nVar.t()) {
            nVar = (n) nVar._prev;
        }
        return nVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(n nVar) {
        n nVar2;
        do {
            nVar2 = (n) nVar._prev;
            if (o() != nVar) {
                return;
            }
        } while (!c.a(f828e, nVar, nVar2, this));
        if (t()) {
            nVar.l(null);
        }
    }

    private final v w() {
        v vVar = (v) this._removedRef;
        if (vVar != null) {
            return vVar;
        }
        v vVar2 = new v(this);
        f829f.lazySet(this, vVar2);
        return vVar2;
    }

    public final boolean j(n nVar, n nVar2) {
        f828e.lazySet(nVar, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f827d;
        atomicReferenceFieldUpdater.lazySet(nVar, nVar2);
        if (!c.a(atomicReferenceFieldUpdater, this, nVar2, nVar)) {
            return false;
        }
        nVar.n(nVar2);
        return true;
    }

    public final boolean k(n nVar) {
        f828e.lazySet(nVar, this);
        f827d.lazySet(nVar, this);
        while (o() == this) {
            if (c.a(f827d, this, this, nVar)) {
                nVar.n(this);
                return true;
            }
        }
        return false;
    }

    public final Object o() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof u)) {
                return obj;
            }
            ((u) obj).c(this);
        }
    }

    public final n p() {
        return m.b(o());
    }

    public final n q() {
        n l2 = l(null);
        return l2 == null ? m((n) this._prev) : l2;
    }

    public final void r() {
        ((v) o()).f851a.s();
    }

    public final void s() {
        n nVar = this;
        while (true) {
            Object o2 = nVar.o();
            if (!(o2 instanceof v)) {
                nVar.l(null);
                return;
            }
            nVar = ((v) o2).f851a;
        }
    }

    public boolean t() {
        return o() instanceof v;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append((Object) getClass().getSimpleName());
        sb.append('@');
        sb.append((Object) Integer.toHexString(System.identityHashCode(this)));
        return sb.toString();
    }

    public boolean u() {
        return v() == null;
    }

    public final n v() {
        Object o2;
        n nVar;
        do {
            o2 = o();
            if (o2 instanceof v) {
                return ((v) o2).f851a;
            }
            if (o2 == this) {
                return (n) o2;
            }
            nVar = (n) o2;
        } while (!c.a(f827d, this, o2, nVar.w()));
        nVar.l(null);
        return null;
    }

    public final int x(n nVar, n nVar2, a aVar) {
        f828e.lazySet(nVar, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f827d;
        atomicReferenceFieldUpdater.lazySet(nVar, nVar2);
        aVar.f831c = nVar2;
        if (c.a(atomicReferenceFieldUpdater, this, nVar2, aVar)) {
            return aVar.c(this) == null ? 1 : 2;
        }
        return 0;
    }
}
