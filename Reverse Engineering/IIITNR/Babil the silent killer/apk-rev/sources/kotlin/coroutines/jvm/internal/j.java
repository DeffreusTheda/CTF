package kotlin.coroutines.jvm.internal;

/* loaded from: classes.dex */
public abstract class j extends a {
    public j(c0.d<Object> dVar) {
        super(dVar);
        if (dVar != null) {
            if (!(dVar.getContext() == c0.h.f144d)) {
                throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString());
            }
        }
    }

    @Override // c0.d
    public c0.g getContext() {
        return c0.h.f144d;
    }
}
