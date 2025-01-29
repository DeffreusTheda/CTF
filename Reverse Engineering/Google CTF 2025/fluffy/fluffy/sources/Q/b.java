package Q;

import a0.h;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class b implements Serializable {

    /* renamed from: b, reason: collision with root package name */
    public final Serializable f320b;

    /* renamed from: c, reason: collision with root package name */
    public final Serializable f321c;

    public b(Serializable serializable, Serializable serializable2) {
        this.f320b = serializable;
        this.f321c = serializable2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return h.a(this.f320b, bVar.f320b) && this.f321c.equals(bVar.f321c);
    }

    public final int hashCode() {
        Serializable serializable = this.f320b;
        return this.f321c.hashCode() + ((serializable == null ? 0 : serializable.hashCode()) * 31);
    }

    public final String toString() {
        return "(" + this.f320b + ", " + this.f321c + ')';
    }
}
