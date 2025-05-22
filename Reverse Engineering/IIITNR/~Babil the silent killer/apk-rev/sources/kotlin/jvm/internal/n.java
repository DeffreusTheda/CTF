package kotlin.jvm.internal;

import j0.o;
import j0.p;
import j0.q;
import j0.r;
import j0.s;
import j0.t;
import j0.u;
import j0.v;
import j0.w;

/* loaded from: classes.dex */
public class n {
    public static Object a(Object obj, int i2) {
        if (obj != null && !c(obj, i2)) {
            f(obj, "kotlin.jvm.functions.Function" + i2);
        }
        return obj;
    }

    public static int b(Object obj) {
        if (obj instanceof f) {
            return ((f) obj).getArity();
        }
        if (obj instanceof j0.a) {
            return 0;
        }
        if (obj instanceof j0.l) {
            return 1;
        }
        if (obj instanceof p) {
            return 2;
        }
        if (obj instanceof q) {
            return 3;
        }
        if (obj instanceof r) {
            return 4;
        }
        if (obj instanceof s) {
            return 5;
        }
        if (obj instanceof t) {
            return 6;
        }
        if (obj instanceof u) {
            return 7;
        }
        if (obj instanceof v) {
            return 8;
        }
        if (obj instanceof w) {
            return 9;
        }
        if (obj instanceof j0.b) {
            return 10;
        }
        if (obj instanceof j0.c) {
            return 11;
        }
        if (obj instanceof j0.d) {
            return 12;
        }
        if (obj instanceof j0.e) {
            return 13;
        }
        if (obj instanceof j0.f) {
            return 14;
        }
        if (obj instanceof j0.g) {
            return 15;
        }
        if (obj instanceof j0.h) {
            return 16;
        }
        if (obj instanceof j0.i) {
            return 17;
        }
        if (obj instanceof j0.j) {
            return 18;
        }
        if (obj instanceof j0.k) {
            return 19;
        }
        if (obj instanceof j0.m) {
            return 20;
        }
        if (obj instanceof j0.n) {
            return 21;
        }
        return obj instanceof o ? 22 : -1;
    }

    public static boolean c(Object obj, int i2) {
        return (obj instanceof a0.c) && b(obj) == i2;
    }

    private static <T extends Throwable> T d(T t2) {
        return (T) i.i(t2, n.class.getName());
    }

    public static ClassCastException e(ClassCastException classCastException) {
        throw ((ClassCastException) d(classCastException));
    }

    public static void f(Object obj, String str) {
        g((obj == null ? "null" : obj.getClass().getName()) + " cannot be cast to " + str);
    }

    public static void g(String str) {
        throw e(new ClassCastException(str));
    }
}
