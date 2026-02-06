package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import q0.a2;
import q0.l0;
import q0.o0;
import q0.u0;

/* loaded from: classes.dex */
public final class g<T> extends o0<T> implements kotlin.coroutines.jvm.internal.e, c0.d<T> {

    /* renamed from: k, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f816k = AtomicReferenceFieldUpdater.newUpdater(g.class, Object.class, "_reusableCancellableContinuation");
    private volatile /* synthetic */ Object _reusableCancellableContinuation;

    /* renamed from: g, reason: collision with root package name */
    public final q0.e0 f817g;

    /* renamed from: h, reason: collision with root package name */
    public final c0.d<T> f818h;

    /* renamed from: i, reason: collision with root package name */
    public Object f819i;

    /* renamed from: j, reason: collision with root package name */
    public final Object f820j;

    /* JADX WARN: Multi-variable type inference failed */
    public g(q0.e0 e0Var, c0.d<? super T> dVar) {
        super(-1);
        y yVar;
        this.f817g = e0Var;
        this.f818h = dVar;
        yVar = h.f821a;
        this.f819i = yVar;
        this.f820j = c0.b(getContext());
        this._reusableCancellableContinuation = null;
    }

    private final q0.l<?> m() {
        Object obj = this._reusableCancellableContinuation;
        if (obj instanceof q0.l) {
            return (q0.l) obj;
        }
        return null;
    }

    @Override // q0.o0
    public void a(Object obj, Throwable th) {
        if (obj instanceof q0.z) {
            ((q0.z) obj).f1087b.invoke(th);
        }
    }

    @Override // q0.o0
    public c0.d<T> b() {
        return this;
    }

    @Override // kotlin.coroutines.jvm.internal.e
    public kotlin.coroutines.jvm.internal.e getCallerFrame() {
        c0.d<T> dVar = this.f818h;
        if (dVar instanceof kotlin.coroutines.jvm.internal.e) {
            return (kotlin.coroutines.jvm.internal.e) dVar;
        }
        return null;
    }

    @Override // c0.d
    public c0.g getContext() {
        return this.f818h.getContext();
    }

    @Override // q0.o0
    public Object h() {
        y yVar;
        Object obj = this.f819i;
        yVar = h.f821a;
        this.f819i = yVar;
        return obj;
    }

    public final void i() {
        while (this._reusableCancellableContinuation == h.f822b) {
        }
    }

    public final q0.l<T> j() {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            if (obj == null) {
                this._reusableCancellableContinuation = h.f822b;
                return null;
            }
            if (obj instanceof q0.l) {
                if (c.a(f816k, this, obj, h.f822b)) {
                    return (q0.l) obj;
                }
            } else if (obj != h.f822b && !(obj instanceof Throwable)) {
                throw new IllegalStateException(kotlin.jvm.internal.i.j("Inconsistent state ", obj).toString());
            }
        }
    }

    public final boolean n() {
        return this._reusableCancellableContinuation != null;
    }

    public final boolean o(Throwable th) {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            y yVar = h.f822b;
            if (kotlin.jvm.internal.i.a(obj, yVar)) {
                if (c.a(f816k, this, yVar, th)) {
                    return true;
                }
            } else {
                if (obj instanceof Throwable) {
                    return true;
                }
                if (c.a(f816k, this, obj, null)) {
                    return false;
                }
            }
        }
    }

    public final void q() {
        i();
        q0.l<?> m2 = m();
        if (m2 == null) {
            return;
        }
        m2.s();
    }

    @Override // c0.d
    public void resumeWith(Object obj) {
        c0.g context = this.f818h.getContext();
        Object d2 = q0.c0.d(obj, null, 1, null);
        if (this.f817g.l(context)) {
            this.f819i = d2;
            this.f1035f = 0;
            this.f817g.k(context, this);
            return;
        }
        u0 a2 = a2.f994a.a();
        if (a2.w()) {
            this.f819i = d2;
            this.f1035f = 0;
            a2.s(this);
            return;
        }
        a2.u(true);
        try {
            c0.g context2 = getContext();
            Object c2 = c0.c(context2, this.f820j);
            try {
                this.f818h.resumeWith(obj);
                a0.q qVar = a0.q.f22a;
                while (a2.y()) {
                }
            } finally {
                c0.a(context2, c2);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public final Throwable s(q0.k<?> kVar) {
        y yVar;
        do {
            Object obj = this._reusableCancellableContinuation;
            yVar = h.f822b;
            if (obj != yVar) {
                if (!(obj instanceof Throwable)) {
                    throw new IllegalStateException(kotlin.jvm.internal.i.j("Inconsistent state ", obj).toString());
                }
                if (c.a(f816k, this, obj, null)) {
                    return (Throwable) obj;
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        } while (!c.a(f816k, this, yVar, kVar));
        return null;
    }

    public String toString() {
        return "DispatchedContinuation[" + this.f817g + ", " + l0.c(this.f818h) + ']';
    }
}
