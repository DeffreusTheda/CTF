package c0;

import c0.g;
import j0.p;
import java.io.Serializable;
import kotlin.jvm.internal.i;

/* loaded from: classes.dex */
public final class h implements g, Serializable {

    /* renamed from: d, reason: collision with root package name */
    public static final h f144d = new h();

    private h() {
    }

    @Override // c0.g
    public <R> R fold(R r2, p<? super R, ? super g.b, ? extends R> operation) {
        i.e(operation, "operation");
        return r2;
    }

    @Override // c0.g
    public <E extends g.b> E get(g.c<E> key) {
        i.e(key, "key");
        return null;
    }

    public int hashCode() {
        return 0;
    }

    @Override // c0.g
    public g minusKey(g.c<?> key) {
        i.e(key, "key");
        return this;
    }

    @Override // c0.g
    public g plus(g context) {
        i.e(context, "context");
        return context;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }
}
