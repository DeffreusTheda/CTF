package kotlinx.coroutines.internal;

import q0.z1;

/* loaded from: classes.dex */
final class f0 {

    /* renamed from: a, reason: collision with root package name */
    public final c0.g f812a;

    /* renamed from: b, reason: collision with root package name */
    private final Object[] f813b;

    /* renamed from: c, reason: collision with root package name */
    private final z1<Object>[] f814c;

    /* renamed from: d, reason: collision with root package name */
    private int f815d;

    public f0(c0.g gVar, int i2) {
        this.f812a = gVar;
        this.f813b = new Object[i2];
        this.f814c = new z1[i2];
    }

    public final void a(z1<?> z1Var, Object obj) {
        Object[] objArr = this.f813b;
        int i2 = this.f815d;
        objArr[i2] = obj;
        z1<Object>[] z1VarArr = this.f814c;
        this.f815d = i2 + 1;
        z1VarArr[i2] = z1Var;
    }

    public final void b(c0.g gVar) {
        int length = this.f814c.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i2 = length - 1;
            z1<Object> z1Var = this.f814c[length];
            kotlin.jvm.internal.i.b(z1Var);
            z1Var.h(gVar, this.f813b[length]);
            if (i2 < 0) {
                return;
            } else {
                length = i2;
            }
        }
    }
}
