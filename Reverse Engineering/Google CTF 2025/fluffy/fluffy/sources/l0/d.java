package l0;

import Q.g;
import U.f;
import Z.p;
import j0.r;

/* loaded from: classes.dex */
public final class d extends f implements p {

    /* renamed from: f, reason: collision with root package name */
    public int f983f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f984g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ k0.b f985h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(k0.b bVar, S.d dVar) {
        super(dVar);
        this.f985h = bVar;
    }

    @Override // U.b
    public final S.d b(Object obj, S.d dVar) {
        d dVar2 = new d(this.f985h, dVar);
        dVar2.f984g = obj;
        return dVar2;
    }

    @Override // Z.p
    public final Object d(Object obj, Object obj2) {
        return ((d) b((r) obj, (S.d) obj2)).e(g.f327a);
    }

    @Override // U.b
    public final Object e(Object obj) {
        T.a aVar = T.a.f344b;
        int i2 = this.f983f;
        if (i2 == 0) {
            a.a.x(obj);
            r rVar = (r) this.f984g;
            this.f983f = 1;
            if (this.f985h.b(rVar, this) == aVar) {
                return aVar;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            a.a.x(obj);
        }
        return g.f327a;
    }
}
