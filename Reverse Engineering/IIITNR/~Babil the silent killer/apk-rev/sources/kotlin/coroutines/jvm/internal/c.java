package kotlin.coroutines.jvm.internal;

/* loaded from: classes.dex */
public final class c implements c0.d<Object> {

    /* renamed from: d, reason: collision with root package name */
    public static final c f773d = new c();

    private c() {
    }

    @Override // c0.d
    public c0.g getContext() {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    @Override // c0.d
    public void resumeWith(Object obj) {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    public String toString() {
        return "This continuation is already complete";
    }
}
