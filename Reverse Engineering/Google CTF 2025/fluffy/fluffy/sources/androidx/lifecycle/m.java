package androidx.lifecycle;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public g f408a;

    /* renamed from: b, reason: collision with root package name */
    public b f409b;

    public final void a(l lVar, f fVar) {
        g a2 = fVar.a();
        g gVar = this.f408a;
        a0.h.e(gVar, "state1");
        if (a2.compareTo(gVar) < 0) {
            gVar = a2;
        }
        this.f408a = gVar;
        this.f409b.a(lVar, fVar);
        this.f408a = a2;
    }
}
