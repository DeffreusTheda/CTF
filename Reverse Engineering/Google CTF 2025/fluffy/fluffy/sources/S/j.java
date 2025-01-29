package S;

import Z.p;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class j implements i, Serializable {

    /* renamed from: b, reason: collision with root package name */
    public static final j f343b = new j();

    @Override // S.i
    public final i d(h hVar) {
        a0.h.e(hVar, "key");
        return this;
    }

    @Override // S.i
    public final i e(i iVar) {
        a0.h.e(iVar, "context");
        return iVar;
    }

    @Override // S.i
    public final g f(h hVar) {
        a0.h.e(hVar, "key");
        return null;
    }

    public final int hashCode() {
        return 0;
    }

    public final String toString() {
        return "EmptyCoroutineContext";
    }

    @Override // S.i
    public final Object h(Object obj, p pVar) {
        return obj;
    }
}
