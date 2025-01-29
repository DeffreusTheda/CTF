package D;

/* loaded from: classes.dex */
public final class x implements io.flutter.embedding.engine.renderer.k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ io.flutter.embedding.engine.renderer.j f97a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ H.c f98b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ y f99c;

    public x(y yVar, io.flutter.embedding.engine.renderer.j jVar, H.c cVar) {
        this.f99c = yVar;
        this.f97a = jVar;
        this.f98b = cVar;
    }

    @Override // io.flutter.embedding.engine.renderer.k
    public final void a() {
        C0012m c0012m;
        this.f97a.f627a.removeIsDisplayingFlutterUiListener(this);
        this.f98b.run();
        y yVar = this.f99c;
        if ((yVar.f103d instanceof C0012m) || (c0012m = yVar.f102c) == null) {
            return;
        }
        c0012m.d();
        C0012m c0012m2 = yVar.f102c;
        if (c0012m2 != null) {
            c0012m2.f75a.close();
            yVar.removeView(yVar.f102c);
            yVar.f102c = null;
        }
    }

    @Override // io.flutter.embedding.engine.renderer.k
    public final void b() {
    }
}
