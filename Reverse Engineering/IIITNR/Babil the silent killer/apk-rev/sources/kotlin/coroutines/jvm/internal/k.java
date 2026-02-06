package kotlin.coroutines.jvm.internal;

import kotlin.jvm.internal.l;

/* loaded from: classes.dex */
public abstract class k extends d implements kotlin.jvm.internal.f<Object> {
    private final int arity;

    public k(int i2) {
        this(i2, null);
    }

    public k(int i2, c0.d<Object> dVar) {
        super(dVar);
        this.arity = i2;
    }

    @Override // kotlin.jvm.internal.f
    public int getArity() {
        return this.arity;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        String d2 = l.d(this);
        kotlin.jvm.internal.i.d(d2, "renderLambdaToString(this)");
        return d2;
    }
}
