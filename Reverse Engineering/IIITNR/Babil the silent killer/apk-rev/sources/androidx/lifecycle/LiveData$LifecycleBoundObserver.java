package androidx.lifecycle;

import androidx.lifecycle.c;

/* loaded from: classes.dex */
class LiveData$LifecycleBoundObserver extends h implements d {

    /* renamed from: b, reason: collision with root package name */
    final f f54b;

    @Override // androidx.lifecycle.d
    public void g(f fVar, c.a aVar) {
        if (this.f54b.d().a() == c.b.DESTROYED) {
            throw null;
        }
        h(i());
    }

    boolean i() {
        return this.f54b.d().a().a(c.b.STARTED);
    }
}
