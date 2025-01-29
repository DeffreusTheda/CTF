package v;

import D.u;
import Z.p;
import android.app.Activity;
import j0.r;
import w.InterfaceC0103a;

/* loaded from: classes.dex */
public final class j extends U.f implements p {

    /* renamed from: f, reason: collision with root package name */
    public int f1200f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f1201g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ b f1202h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Activity f1203i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(b bVar, Activity activity, S.d dVar) {
        super(dVar);
        this.f1202h = bVar;
        this.f1203i = activity;
    }

    @Override // U.b
    public final S.d b(Object obj, S.d dVar) {
        j jVar = new j(this.f1202h, this.f1203i, dVar);
        jVar.f1201g = obj;
        return jVar;
    }

    @Override // Z.p
    public final Object d(Object obj, Object obj2) {
        return ((j) b((r) obj, (S.d) obj2)).e(Q.g.f327a);
    }

    @Override // U.b
    public final Object e(Object obj) {
        T.a aVar = T.a.f344b;
        int i2 = this.f1200f;
        if (i2 == 0) {
            a.a.x(obj);
            r rVar = (r) this.f1201g;
            u uVar = new u(1, rVar);
            b bVar = this.f1202h;
            ((InterfaceC0103a) bVar.f1184c).a(this.f1203i, new n.f(), uVar);
            i iVar = new i(bVar, uVar);
            this.f1200f = 1;
            if (j0.j.a(rVar, iVar, this) == aVar) {
                return aVar;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            a.a.x(obj);
        }
        return Q.g.f327a;
    }
}
