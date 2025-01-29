package v;

import s.C0092b;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final C0092b f1185a;

    /* renamed from: b, reason: collision with root package name */
    public final b f1186b;

    /* renamed from: c, reason: collision with root package name */
    public final b f1187c;

    public c(C0092b c0092b, b bVar, b bVar2) {
        this.f1185a = c0092b;
        this.f1186b = bVar;
        this.f1187c = bVar2;
        if (c0092b.b() == 0 && c0092b.a() == 0) {
            throw new IllegalArgumentException("Bounds must be non zero");
        }
        if (c0092b.f1150a != 0 && c0092b.f1151b != 0) {
            throw new IllegalArgumentException("Bounding rectangle must start at the top or left window edge for folding features");
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!c.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        a0.h.c(obj, "null cannot be cast to non-null type androidx.window.layout.HardwareFoldingFeature");
        c cVar = (c) obj;
        return a0.h.a(this.f1185a, cVar.f1185a) && a0.h.a(this.f1186b, cVar.f1186b) && a0.h.a(this.f1187c, cVar.f1187c);
    }

    public final int hashCode() {
        return this.f1187c.hashCode() + ((this.f1186b.hashCode() + (this.f1185a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return c.class.getSimpleName() + " { " + this.f1185a + ", type=" + this.f1186b + ", state=" + this.f1187c + " }";
    }
}
