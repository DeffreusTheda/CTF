package Q;

import a0.h;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class c implements Serializable {

    /* renamed from: b, reason: collision with root package name */
    public final Throwable f322b;

    public c(Throwable th) {
        h.e(th, "exception");
        this.f322b = th;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof c) {
            if (h.a(this.f322b, ((c) obj).f322b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f322b.hashCode();
    }

    public final String toString() {
        return "Failure(" + this.f322b + ')';
    }
}
