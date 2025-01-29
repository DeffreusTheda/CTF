package a0;

import Z.p;

/* loaded from: classes.dex */
public abstract class n {
    public static void a(int i2, Object obj) {
        if (obj == null || b(i2, obj)) {
            return;
        }
        String name = obj.getClass().getName();
        ClassCastException classCastException = new ClassCastException(name + " cannot be cast to " + ("kotlin.jvm.functions.Function" + i2));
        h.f(classCastException, n.class.getName());
        throw classCastException;
    }

    public static boolean b(int i2, Object obj) {
        if (obj instanceof Q.a) {
            return (obj instanceof f ? ((f) obj).f() : obj instanceof Z.a ? 0 : obj instanceof Z.l ? 1 : obj instanceof p ? 2 : -1) == i2;
        }
        return false;
    }
}
