package c0;

import c0.g;
import c0.g.b;
import j0.l;
import kotlin.jvm.internal.i;

/* loaded from: classes.dex */
public abstract class b<B extends g.b, E extends B> implements g.c<E> {

    /* renamed from: d, reason: collision with root package name */
    private final l<g.b, E> f136d;

    /* renamed from: e, reason: collision with root package name */
    private final g.c<?> f137e;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [c0.g$c<?>] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r3v0, types: [j0.l<? super c0.g$b, ? extends E extends B>, j0.l<c0.g$b, E extends B>, java.lang.Object] */
    public b(g.c<B> baseKey, l<? super g.b, ? extends E> safeCast) {
        i.e(baseKey, "baseKey");
        i.e(safeCast, "safeCast");
        this.f136d = safeCast;
        this.f137e = baseKey instanceof b ? (g.c<B>) ((b) baseKey).f137e : baseKey;
    }

    public final boolean a(g.c<?> key) {
        i.e(key, "key");
        return key == this || this.f137e == key;
    }

    /* JADX WARN: Incorrect return type in method signature: (Lc0/g$b;)TE; */
    public final g.b b(g.b element) {
        i.e(element, "element");
        return (g.b) this.f136d.invoke(element);
    }
}
