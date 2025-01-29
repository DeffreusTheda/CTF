package k0;

import j0.r;

/* loaded from: classes.dex */
public final class a extends U.b {

    /* renamed from: e, reason: collision with root package name */
    public r f917e;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f918f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ b f919g;

    /* renamed from: h, reason: collision with root package name */
    public int f920h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(b bVar, U.b bVar2) {
        super(bVar2);
        this.f919g = bVar;
    }

    @Override // U.b
    public final Object e(Object obj) {
        this.f918f = obj;
        this.f920h |= Integer.MIN_VALUE;
        return this.f919g.b(null, this);
    }
}
