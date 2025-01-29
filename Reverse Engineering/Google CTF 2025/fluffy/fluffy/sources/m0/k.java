package m0;

import h0.AbstractC0059t;

/* loaded from: classes.dex */
public final /* synthetic */ class k extends a0.c implements Z.a, e0.a {

    /* renamed from: h, reason: collision with root package name */
    public final boolean f1014h;

    public k(l lVar) {
        super(lVar, AbstractC0059t.class, "classSimpleName", "getClassSimpleName(Ljava/lang/Object;)Ljava/lang/String;", true);
        this.f1014h = false;
    }

    @Override // Z.a
    public final Object a() {
        return this.f364c.getClass().getSimpleName();
    }

    public final e0.a c() {
        if (!this.f1014h) {
            e0.a aVar = this.f363b;
            if (aVar != null) {
                return aVar;
            }
            a0.l.f379a.getClass();
            this.f363b = this;
        }
        return this;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof k) {
            k kVar = (k) obj;
            return b().equals(kVar.b()) && this.f366e.equals(kVar.f366e) && this.f367f.equals(kVar.f367f) && this.f364c.equals(kVar.f364c);
        }
        if (obj instanceof k) {
            return obj.equals(c());
        }
        return false;
    }

    public final int hashCode() {
        return this.f367f.hashCode() + ((this.f366e.hashCode() + (b().hashCode() * 31)) * 31);
    }

    public final String toString() {
        e0.a c2 = c();
        if (c2 != this) {
            return c2.toString();
        }
        return "property " + this.f366e + " (Kotlin reflection is not available)";
    }
}
