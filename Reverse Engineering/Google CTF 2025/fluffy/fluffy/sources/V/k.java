package v;

import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final Object f1204a;

    public k(List list) {
        this.f1204a = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !k.class.equals(obj.getClass())) {
            return false;
        }
        return this.f1204a.equals(((k) obj).f1204a);
    }

    public final int hashCode() {
        return this.f1204a.hashCode();
    }

    public final String toString() {
        return R.e.B((Collection) this.f1204a, "WindowLayoutInfo{ DisplayFeatures[", "] }", null, 56);
    }
}
