package kotlinx.coroutines.internal;

import q0.t1;

/* loaded from: classes.dex */
final class s extends t1 {

    /* renamed from: e, reason: collision with root package name */
    private final Throwable f846e;

    /* renamed from: f, reason: collision with root package name */
    private final String f847f;

    public s(Throwable th, String str) {
        this.f846e = th;
        this.f847f = str;
    }

    private final Void t() {
        String j2;
        if (this.f846e == null) {
            r.c();
            throw new a0.d();
        }
        String str = this.f847f;
        String str2 = "";
        if (str != null && (j2 = kotlin.jvm.internal.i.j(". ", str)) != null) {
            str2 = j2;
        }
        throw new IllegalStateException(kotlin.jvm.internal.i.j("Module with the Main dispatcher had failed to initialize", str2), this.f846e);
    }

    @Override // q0.e0
    public boolean l(c0.g gVar) {
        t();
        throw new a0.d();
    }

    @Override // q0.t1
    public t1 p() {
        return this;
    }

    @Override // q0.e0
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public Void k(c0.g gVar, Runnable runnable) {
        t();
        throw new a0.d();
    }

    @Override // q0.t1, q0.e0
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Dispatchers.Main[missing");
        Throwable th = this.f846e;
        sb.append(th != null ? kotlin.jvm.internal.i.j(", cause=", th) : "");
        sb.append(']');
        return sb.toString();
    }
}
