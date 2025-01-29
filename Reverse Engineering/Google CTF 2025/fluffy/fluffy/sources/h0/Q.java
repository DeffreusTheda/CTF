package h0;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public final class Q implements H {

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f534c = AtomicIntegerFieldUpdater.newUpdater(Q.class, "_isCompleting");

    /* renamed from: d, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f535d = AtomicReferenceFieldUpdater.newUpdater(Q.class, Object.class, "_rootCause");

    /* renamed from: e, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f536e = AtomicReferenceFieldUpdater.newUpdater(Q.class, Object.class, "_exceptionsHolder");
    private volatile Object _exceptionsHolder;
    private volatile int _isCompleting = 0;
    private volatile Object _rootCause;

    /* renamed from: b, reason: collision with root package name */
    public final U f537b;

    public Q(U u, Throwable th) {
        this.f537b = u;
        this._rootCause = th;
    }

    public final void a(Throwable th) {
        Throwable d2 = d();
        if (d2 == null) {
            f535d.set(this, th);
            return;
        }
        if (th == d2) {
            return;
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f536e;
        Object obj = atomicReferenceFieldUpdater.get(this);
        if (obj == null) {
            atomicReferenceFieldUpdater.set(this, th);
            return;
        }
        if (!(obj instanceof Throwable)) {
            if (obj instanceof ArrayList) {
                ((ArrayList) obj).add(th);
                return;
            } else {
                throw new IllegalStateException(("State is " + obj).toString());
            }
        }
        if (th == obj) {
            return;
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(th);
        atomicReferenceFieldUpdater.set(this, arrayList);
    }

    @Override // h0.H
    public final boolean b() {
        return d() == null;
    }

    @Override // h0.H
    public final U c() {
        return this.f537b;
    }

    public final Throwable d() {
        return (Throwable) f535d.get(this);
    }

    public final boolean e() {
        return d() != null;
    }

    public final boolean f() {
        return f534c.get(this) != 0;
    }

    public final ArrayList g(Throwable th) {
        ArrayList arrayList;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f536e;
        Object obj = atomicReferenceFieldUpdater.get(this);
        if (obj == null) {
            arrayList = new ArrayList(4);
        } else if (obj instanceof Throwable) {
            ArrayList arrayList2 = new ArrayList(4);
            arrayList2.add(obj);
            arrayList = arrayList2;
        } else {
            if (!(obj instanceof ArrayList)) {
                throw new IllegalStateException(("State is " + obj).toString());
            }
            arrayList = (ArrayList) obj;
        }
        Throwable d2 = d();
        if (d2 != null) {
            arrayList.add(0, d2);
        }
        if (th != null && !th.equals(d2)) {
            arrayList.add(th);
        }
        atomicReferenceFieldUpdater.set(this, AbstractC0059t.f582g);
        return arrayList;
    }

    public final String toString() {
        return "Finishing[cancelling=" + e() + ", completing=" + f() + ", rootCause=" + d() + ", exceptions=" + f536e.get(this) + ", list=" + this.f537b + ']';
    }
}
