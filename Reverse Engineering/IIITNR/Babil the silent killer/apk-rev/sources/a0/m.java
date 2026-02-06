package a0;

import java.io.Serializable;

/* loaded from: classes.dex */
final class m<T> implements e<T>, Serializable {

    /* renamed from: d, reason: collision with root package name */
    private j0.a<? extends T> f18d;

    /* renamed from: e, reason: collision with root package name */
    private volatile Object f19e;

    /* renamed from: f, reason: collision with root package name */
    private final Object f20f;

    public m(j0.a<? extends T> initializer, Object obj) {
        kotlin.jvm.internal.i.e(initializer, "initializer");
        this.f18d = initializer;
        this.f19e = o.f21a;
        this.f20f = obj == null ? this : obj;
    }

    public /* synthetic */ m(j0.a aVar, Object obj, int i2, kotlin.jvm.internal.e eVar) {
        this(aVar, (i2 & 2) != 0 ? null : obj);
    }

    public boolean a() {
        return this.f19e != o.f21a;
    }

    @Override // a0.e
    public T getValue() {
        T t2;
        T t3 = (T) this.f19e;
        o oVar = o.f21a;
        if (t3 != oVar) {
            return t3;
        }
        synchronized (this.f20f) {
            t2 = (T) this.f19e;
            if (t2 == oVar) {
                j0.a<? extends T> aVar = this.f18d;
                kotlin.jvm.internal.i.b(aVar);
                t2 = aVar.invoke();
                this.f19e = t2;
                this.f18d = null;
            }
        }
        return t2;
    }

    public String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
