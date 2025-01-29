package F;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f170a;

    /* renamed from: b, reason: collision with root package name */
    public final String f171b;

    /* renamed from: c, reason: collision with root package name */
    public final String f172c;

    public a(String str, String str2) {
        this.f170a = str;
        this.f171b = null;
        this.f172c = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f170a.equals(aVar.f170a)) {
            return this.f172c.equals(aVar.f172c);
        }
        return false;
    }

    public final int hashCode() {
        return this.f172c.hashCode() + (this.f170a.hashCode() * 31);
    }

    public final String toString() {
        return "DartEntrypoint( bundle path: " + this.f170a + ", function: " + this.f172c + " )";
    }

    public a(String str, String str2, String str3) {
        this.f170a = str;
        this.f171b = str2;
        this.f172c = str3;
    }
}
