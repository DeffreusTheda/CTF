package kotlinx.coroutines.internal;

import q0.h0;

/* loaded from: classes.dex */
public final class f implements h0 {

    /* renamed from: d, reason: collision with root package name */
    private final c0.g f811d;

    public f(c0.g gVar) {
        this.f811d = gVar;
    }

    @Override // q0.h0
    public c0.g s() {
        return this.f811d;
    }

    public String toString() {
        return "CoroutineScope(coroutineContext=" + s() + ')';
    }
}
