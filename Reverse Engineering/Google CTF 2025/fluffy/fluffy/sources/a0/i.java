package a0;

import java.io.Serializable;

/* loaded from: classes.dex */
public abstract class i implements f, Serializable {

    /* renamed from: b, reason: collision with root package name */
    public final int f376b;

    public i(int i2) {
        this.f376b = i2;
    }

    @Override // a0.f
    public final int f() {
        return this.f376b;
    }

    public final String toString() {
        l.f379a.getClass();
        String obj = getClass().getGenericInterfaces()[0].toString();
        if (obj.startsWith("kotlin.jvm.functions.")) {
            obj = obj.substring(21);
        }
        h.d(obj, "renderLambdaToString(...)");
        return obj;
    }
}
