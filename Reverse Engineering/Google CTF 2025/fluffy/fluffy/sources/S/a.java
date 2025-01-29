package S;

import Z.p;

/* loaded from: classes.dex */
public abstract class a implements g {

    /* renamed from: b, reason: collision with root package name */
    public final h f338b;

    public a(h hVar) {
        this.f338b = hVar;
    }

    @Override // S.i
    public i d(h hVar) {
        return a.a.p(this, hVar);
    }

    @Override // S.i
    public final i e(i iVar) {
        return a.a.q(this, iVar);
    }

    @Override // S.i
    public g f(h hVar) {
        return a.a.h(this, hVar);
    }

    @Override // S.g
    public final h getKey() {
        return this.f338b;
    }

    @Override // S.i
    public final Object h(Object obj, p pVar) {
        return pVar.d(obj, this);
    }
}
