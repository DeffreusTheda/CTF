package h0;

import java.util.concurrent.CancellationException;

/* renamed from: h0.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0049i extends M implements InterfaceC0048h {

    /* renamed from: f, reason: collision with root package name */
    public final T f558f;

    public C0049i(T t2) {
        this.f558f = t2;
    }

    @Override // h0.InterfaceC0048h
    public final boolean g(Throwable th) {
        T n2 = n();
        if (th instanceof CancellationException) {
            return true;
        }
        return n2.o(th) && n2.w();
    }

    @Override // Z.l
    public final /* bridge */ /* synthetic */ Object h(Object obj) {
        o((Throwable) obj);
        return Q.g.f327a;
    }

    @Override // h0.O
    public final void o(Throwable th) {
        this.f558f.o(n());
    }
}
