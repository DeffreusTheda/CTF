package h0;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public final class N extends T {

    /* renamed from: d, reason: collision with root package name */
    public final boolean f528d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public N(K k2) {
        super(true);
        boolean z2 = true;
        B(k2);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = T.f543c;
        InterfaceC0048h interfaceC0048h = (InterfaceC0048h) atomicReferenceFieldUpdater.get(this);
        C0049i c0049i = interfaceC0048h instanceof C0049i ? (C0049i) interfaceC0048h : null;
        if (c0049i != null) {
            T n2 = c0049i.n();
            while (!n2.w()) {
                InterfaceC0048h interfaceC0048h2 = (InterfaceC0048h) atomicReferenceFieldUpdater.get(n2);
                C0049i c0049i2 = interfaceC0048h2 instanceof C0049i ? (C0049i) interfaceC0048h2 : null;
                if (c0049i2 != null) {
                    n2 = c0049i2.n();
                }
            }
            this.f528d = z2;
        }
        z2 = false;
        this.f528d = z2;
    }

    @Override // h0.T
    public final boolean w() {
        return this.f528d;
    }
}
