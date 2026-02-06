package q0;

/* loaded from: classes.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    public final Object f1086a;

    /* renamed from: b, reason: collision with root package name */
    public final j0.l<Throwable, a0.q> f1087b;

    /* JADX WARN: Multi-variable type inference failed */
    public z(Object obj, j0.l<? super Throwable, a0.q> lVar) {
        this.f1086a = obj;
        this.f1087b = lVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        return kotlin.jvm.internal.i.a(this.f1086a, zVar.f1086a) && kotlin.jvm.internal.i.a(this.f1087b, zVar.f1087b);
    }

    public int hashCode() {
        Object obj = this.f1086a;
        return ((obj == null ? 0 : obj.hashCode()) * 31) + this.f1087b.hashCode();
    }

    public String toString() {
        return "CompletedWithCancellation(result=" + this.f1086a + ", onCancellation=" + this.f1087b + ')';
    }
}
