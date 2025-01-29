package t;

import D.u;
import Q.g;
import S.d;
import U.f;
import Z.p;
import h0.r;
import io.flutter.plugin.platform.i;
import k0.c;

/* renamed from: t.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0101a extends f implements p {

    /* renamed from: f, reason: collision with root package name */
    public int f1172f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ c f1173g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ u f1174h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0101a(c cVar, u uVar, d dVar) {
        super(dVar);
        this.f1173g = cVar;
        this.f1174h = uVar;
    }

    @Override // U.b
    public final d b(Object obj, d dVar) {
        return new C0101a(this.f1173g, this.f1174h, dVar);
    }

    @Override // Z.p
    public final Object d(Object obj, Object obj2) {
        return ((C0101a) b((r) obj, (d) obj2)).e(g.f327a);
    }

    @Override // U.b
    public final Object e(Object obj) {
        T.a aVar = T.a.f344b;
        int i2 = this.f1172f;
        if (i2 == 0) {
            a.a.x(obj);
            i iVar = new i(3, this.f1174h);
            this.f1172f = 1;
            if (this.f1173g.a(iVar, this) == aVar) {
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
