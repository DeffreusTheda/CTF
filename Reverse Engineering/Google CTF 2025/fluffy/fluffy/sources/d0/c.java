package d0;

/* loaded from: classes.dex */
public final class c extends a {
    static {
        new c(1, 0, 1);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof c) {
            if (!isEmpty() || !((c) obj).isEmpty()) {
                c cVar = (c) obj;
                if (this.f459b == cVar.f459b) {
                    if (this.f460c == cVar.f460c) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.f459b * 31) + this.f460c;
    }

    public final boolean isEmpty() {
        return this.f459b > this.f460c;
    }

    public final String toString() {
        return this.f459b + ".." + this.f460c;
    }
}
