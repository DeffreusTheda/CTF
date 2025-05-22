package c0;

import c0.g;
import j0.p;
import java.io.Serializable;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public final class c implements g, Serializable {

    /* renamed from: d, reason: collision with root package name */
    private final g f138d;

    /* renamed from: e, reason: collision with root package name */
    private final g.b f139e;

    static final class a extends j implements p<String, g.b, String> {

        /* renamed from: d, reason: collision with root package name */
        public static final a f140d = new a();

        a() {
            super(2);
        }

        @Override // j0.p
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke(String acc, g.b element) {
            i.e(acc, "acc");
            i.e(element, "element");
            if (acc.length() == 0) {
                return element.toString();
            }
            return acc + ", " + element;
        }
    }

    public c(g left, g.b element) {
        i.e(left, "left");
        i.e(element, "element");
        this.f138d = left;
        this.f139e = element;
    }

    private final boolean e(g.b bVar) {
        return i.a(get(bVar.getKey()), bVar);
    }

    private final boolean g(c cVar) {
        while (e(cVar.f139e)) {
            g gVar = cVar.f138d;
            if (!(gVar instanceof c)) {
                i.c(gVar, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                return e((g.b) gVar);
            }
            cVar = (c) gVar;
        }
        return false;
    }

    private final int k() {
        int i2 = 2;
        c cVar = this;
        while (true) {
            g gVar = cVar.f138d;
            cVar = gVar instanceof c ? (c) gVar : null;
            if (cVar == null) {
                return i2;
            }
            i2++;
        }
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                if (cVar.k() != k() || !cVar.g(this)) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // c0.g
    public <R> R fold(R r2, p<? super R, ? super g.b, ? extends R> operation) {
        i.e(operation, "operation");
        return operation.invoke((Object) this.f138d.fold(r2, operation), this.f139e);
    }

    @Override // c0.g
    public <E extends g.b> E get(g.c<E> key) {
        i.e(key, "key");
        c cVar = this;
        while (true) {
            E e2 = (E) cVar.f139e.get(key);
            if (e2 != null) {
                return e2;
            }
            g gVar = cVar.f138d;
            if (!(gVar instanceof c)) {
                return (E) gVar.get(key);
            }
            cVar = (c) gVar;
        }
    }

    public int hashCode() {
        return this.f138d.hashCode() + this.f139e.hashCode();
    }

    @Override // c0.g
    public g minusKey(g.c<?> key) {
        i.e(key, "key");
        if (this.f139e.get(key) != null) {
            return this.f138d;
        }
        g minusKey = this.f138d.minusKey(key);
        return minusKey == this.f138d ? this : minusKey == h.f144d ? this.f139e : new c(minusKey, this.f139e);
    }

    @Override // c0.g
    public g plus(g gVar) {
        return g.a.a(this, gVar);
    }

    public String toString() {
        return '[' + ((String) fold("", a.f140d)) + ']';
    }
}
