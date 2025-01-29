package m0;

/* loaded from: classes.dex */
public final class g extends RuntimeException {

    /* renamed from: b, reason: collision with root package name */
    public final transient S.i f1001b;

    public g(S.i iVar) {
        this.f1001b = iVar;
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @Override // java.lang.Throwable
    public final String getLocalizedMessage() {
        return this.f1001b.toString();
    }
}
