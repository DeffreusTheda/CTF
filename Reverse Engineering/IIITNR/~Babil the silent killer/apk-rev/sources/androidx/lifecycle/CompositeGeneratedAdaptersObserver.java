package androidx.lifecycle;

import androidx.lifecycle.c;

/* loaded from: classes.dex */
class CompositeGeneratedAdaptersObserver implements d {

    /* renamed from: a, reason: collision with root package name */
    private final b[] f49a;

    @Override // androidx.lifecycle.d
    public void g(f fVar, c.a aVar) {
        i iVar = new i();
        for (b bVar : this.f49a) {
            bVar.a(fVar, aVar, false, iVar);
        }
        for (b bVar2 : this.f49a) {
            bVar2.a(fVar, aVar, true, iVar);
        }
    }
}
