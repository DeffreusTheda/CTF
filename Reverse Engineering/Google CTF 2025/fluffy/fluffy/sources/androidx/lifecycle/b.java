package androidx.lifecycle;

/* loaded from: classes.dex */
public final class b implements k {

    /* renamed from: a, reason: collision with root package name */
    public final io.flutter.embedding.engine.renderer.b f398a;

    /* renamed from: b, reason: collision with root package name */
    public final b f399b;

    public b(io.flutter.embedding.engine.renderer.b bVar, b bVar2) {
        this.f398a = bVar;
        this.f399b = bVar2;
    }

    public final void a(l lVar, f fVar) {
        int i2 = a.f397a[fVar.ordinal()];
        io.flutter.embedding.engine.renderer.b bVar = this.f398a;
        if (i2 == 3) {
            bVar.a();
        } else if (i2 == 7) {
            throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        b bVar2 = this.f399b;
        if (bVar2 != null) {
            bVar2.a(lVar, fVar);
        }
    }
}
