package kotlin.jvm.internal;

/* loaded from: classes.dex */
public final class k implements b {

    /* renamed from: d, reason: collision with root package name */
    private final Class<?> f789d;

    /* renamed from: e, reason: collision with root package name */
    private final String f790e;

    public k(Class<?> jClass, String moduleName) {
        i.e(jClass, "jClass");
        i.e(moduleName, "moduleName");
        this.f789d = jClass;
        this.f790e = moduleName;
    }

    @Override // kotlin.jvm.internal.b
    public Class<?> b() {
        return this.f789d;
    }

    public boolean equals(Object obj) {
        return (obj instanceof k) && i.a(b(), ((k) obj).b());
    }

    public int hashCode() {
        return b().hashCode();
    }

    public String toString() {
        return b().toString() + " (Kotlin reflection is not available)";
    }
}
