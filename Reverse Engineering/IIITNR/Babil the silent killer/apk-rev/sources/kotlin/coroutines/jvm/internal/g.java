package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Field;

/* loaded from: classes.dex */
public final class g {
    private static final void a(int i2, int i3) {
        if (i3 <= i2) {
            return;
        }
        throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + i2 + ", got " + i3 + ". Please update the Kotlin standard library.").toString());
    }

    private static final f b(a aVar) {
        return (f) aVar.getClass().getAnnotation(f.class);
    }

    private static final int c(a aVar) {
        try {
            Field declaredField = aVar.getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(aVar);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static final StackTraceElement d(a aVar) {
        String str;
        kotlin.jvm.internal.i.e(aVar, "<this>");
        f b2 = b(aVar);
        if (b2 == null) {
            return null;
        }
        a(1, b2.v());
        int c2 = c(aVar);
        int i2 = c2 < 0 ? -1 : b2.l()[c2];
        String b3 = i.f774a.b(aVar);
        if (b3 == null) {
            str = b2.c();
        } else {
            str = b3 + '/' + b2.c();
        }
        return new StackTraceElement(str, b2.m(), b2.f(), i2);
    }
}
