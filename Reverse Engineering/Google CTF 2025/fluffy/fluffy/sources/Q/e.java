package Q;

import a0.h;
import a0.i;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class e implements Serializable {

    /* renamed from: b, reason: collision with root package name */
    public i f323b;

    /* renamed from: c, reason: collision with root package name */
    public volatile Object f324c = f.f326a;

    /* renamed from: d, reason: collision with root package name */
    public final Object f325d = this;

    /* JADX WARN: Multi-variable type inference failed */
    public e(Z.a aVar) {
        this.f323b = (i) aVar;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [Z.a, a0.i, java.lang.Object] */
    public final Object a() {
        Object obj;
        Object obj2 = this.f324c;
        f fVar = f.f326a;
        if (obj2 != fVar) {
            return obj2;
        }
        synchronized (this.f325d) {
            obj = this.f324c;
            if (obj == fVar) {
                ?? r1 = this.f323b;
                h.b(r1);
                obj = r1.a();
                this.f324c = obj;
                this.f323b = null;
            }
        }
        return obj;
    }

    public final String toString() {
        return this.f324c != f.f326a ? String.valueOf(a()) : "Lazy value not initialized yet.";
    }
}
