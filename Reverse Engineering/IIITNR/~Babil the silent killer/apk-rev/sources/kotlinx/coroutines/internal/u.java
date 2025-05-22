package kotlinx.coroutines.internal;

import q0.l0;

/* loaded from: classes.dex */
public abstract class u {
    public abstract d<?> a();

    public final boolean b(u uVar) {
        d<?> a2;
        d<?> a3 = a();
        return (a3 == null || (a2 = uVar.a()) == null || a3.f() >= a2.f()) ? false : true;
    }

    public abstract Object c(Object obj);

    public String toString() {
        return l0.a(this) + '@' + l0.b(this);
    }
}
