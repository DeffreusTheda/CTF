package U;

import a0.h;
import a0.l;

/* loaded from: classes.dex */
public abstract class f extends b implements a0.f {

    /* renamed from: e, reason: collision with root package name */
    public final int f352e;

    public f(S.d dVar) {
        super(dVar);
        this.f352e = 2;
    }

    @Override // a0.f
    public final int f() {
        return this.f352e;
    }

    @Override // U.b
    public final String toString() {
        if (this.f347b != null) {
            return super.toString();
        }
        l.f379a.getClass();
        String obj = getClass().getGenericInterfaces()[0].toString();
        if (obj.startsWith("kotlin.jvm.functions.")) {
            obj = obj.substring(21);
        }
        h.d(obj, "renderLambdaToString(...)");
        return obj;
    }
}
