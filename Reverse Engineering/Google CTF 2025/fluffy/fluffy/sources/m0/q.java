package m0;

/* loaded from: classes.dex */
public final class q extends a0.i implements Z.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Z.l f1028c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f1029d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ S.i f1030e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(Z.l lVar, Object obj, S.i iVar) {
        super(1);
        this.f1028c = lVar;
        this.f1029d = obj;
        this.f1030e = iVar;
    }

    @Override // Z.l
    public final Object h(Object obj) {
        AbstractC0081a.a(this.f1028c, this.f1029d, this.f1030e);
        return Q.g.f327a;
    }
}
