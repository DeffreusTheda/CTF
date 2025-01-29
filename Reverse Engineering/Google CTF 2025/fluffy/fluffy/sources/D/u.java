package D;

import k.InterfaceC0066a;

/* loaded from: classes.dex */
public final /* synthetic */ class u implements InterfaceC0066a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f91a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f92b;

    public /* synthetic */ u(int i2, Object obj) {
        this.f91a = i2;
        this.f92b = obj;
    }

    @Override // k.InterfaceC0066a
    public final void accept(Object obj) {
        switch (this.f91a) {
            case 0:
                ((y) this.f92b).setWindowInfoListenerDisplayFeatures((v.k) obj);
                break;
            default:
                ((j0.q) ((j0.r) this.f92b)).j((v.k) obj);
                break;
        }
    }
}
