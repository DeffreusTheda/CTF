package h0;

/* renamed from: h0.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0052l {

    /* renamed from: a, reason: collision with root package name */
    public final Object f565a;

    /* renamed from: b, reason: collision with root package name */
    public final Z.l f566b;

    public C0052l(Object obj, Z.l lVar) {
        this.f565a = obj;
        this.f566b = lVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0052l)) {
            return false;
        }
        C0052l c0052l = (C0052l) obj;
        return a0.h.a(this.f565a, c0052l.f565a) && a0.h.a(this.f566b, c0052l.f566b);
    }

    public final int hashCode() {
        Object obj = this.f565a;
        return this.f566b.hashCode() + ((obj == null ? 0 : obj.hashCode()) * 31);
    }

    public final String toString() {
        return "CompletedWithCancellation(result=" + this.f565a + ", onCancellation=" + this.f566b + ')';
    }
}
