package a0;

/* loaded from: classes.dex */
public abstract class g extends c implements f, e0.a, Q.a {

    /* renamed from: h, reason: collision with root package name */
    public final int f373h;

    /* renamed from: i, reason: collision with root package name */
    public final int f374i;

    public g(int i2, Object obj, Class cls, String str, String str2, int i3) {
        super(obj, cls, str, str2, (i3 & 1) == 1);
        this.f373h = i2;
        this.f374i = 0;
    }

    public final e0.a c() {
        l.f379a.getClass();
        return this;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            return this.f366e.equals(gVar.f366e) && this.f367f.equals(gVar.f367f) && this.f374i == gVar.f374i && this.f373h == gVar.f373h && this.f364c.equals(gVar.f364c) && b().equals(gVar.b());
        }
        if (!(obj instanceof g)) {
            return false;
        }
        e0.a aVar = this.f363b;
        if (aVar == null) {
            c();
            this.f363b = this;
            aVar = this;
        }
        return obj.equals(aVar);
    }

    @Override // a0.f
    public final int f() {
        return this.f373h;
    }

    public final int hashCode() {
        b();
        return this.f367f.hashCode() + ((this.f366e.hashCode() + (b().hashCode() * 31)) * 31);
    }

    public final String toString() {
        e0.a aVar = this.f363b;
        if (aVar == null) {
            c();
            this.f363b = this;
            aVar = this;
        }
        if (aVar != this) {
            return aVar.toString();
        }
        String str = this.f366e;
        if ("<init>".equals(str)) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + str + " (Kotlin reflection is not available)";
    }
}
