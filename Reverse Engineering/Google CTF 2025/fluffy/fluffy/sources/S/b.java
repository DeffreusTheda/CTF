package S;

import Z.p;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements p {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f339b;

    public /* synthetic */ b(int i2) {
        this.f339b = i2;
    }

    @Override // Z.p
    public final Object d(Object obj, Object obj2) {
        c cVar;
        switch (this.f339b) {
            case 0:
                String str = (String) obj;
                g gVar = (g) obj2;
                a0.h.e(str, "acc");
                if (str.length() == 0) {
                    return gVar.toString();
                }
                return str + ", " + gVar;
            default:
                i iVar = (i) obj;
                g gVar2 = (g) obj2;
                a0.h.e(iVar, "acc");
                i d2 = iVar.d(gVar2.getKey());
                j jVar = j.f343b;
                if (d2 == jVar) {
                    return gVar2;
                }
                e eVar = e.f342b;
                f fVar = (f) d2.f(eVar);
                if (fVar == null) {
                    cVar = new c(gVar2, d2);
                } else {
                    i d3 = d2.d(eVar);
                    if (d3 == jVar) {
                        return new c(fVar, gVar2);
                    }
                    cVar = new c(fVar, new c(gVar2, d3));
                }
                return cVar;
        }
    }
}
