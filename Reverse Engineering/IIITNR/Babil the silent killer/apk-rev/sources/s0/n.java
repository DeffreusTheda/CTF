package s0;

import kotlinx.coroutines.internal.y;

/* loaded from: classes.dex */
public class n<E> extends a<E> {
    public n(j0.l<? super E, a0.q> lVar) {
        super(lVar);
    }

    @Override // s0.c
    protected Object i(E e2) {
        q<?> k2;
        do {
            Object i2 = super.i(e2);
            y yVar = b.f1102b;
            if (i2 == yVar) {
                return yVar;
            }
            if (i2 != b.f1103c) {
                if (i2 instanceof j) {
                    return i2;
                }
                throw new IllegalStateException(kotlin.jvm.internal.i.j("Invalid offerInternal result ", i2).toString());
            }
            k2 = k(e2);
            if (k2 == null) {
                return yVar;
            }
        } while (!(k2 instanceof j));
        return k2;
    }

    @Override // s0.a
    protected final boolean r() {
        return true;
    }

    @Override // s0.a
    protected final boolean s() {
        return true;
    }
}
