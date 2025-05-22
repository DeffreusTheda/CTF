package h;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static long f169a;

    /* renamed from: b, reason: collision with root package name */
    private static Method f170b;

    /* renamed from: c, reason: collision with root package name */
    private static Method f171c;

    @SuppressLint({"NewApi"})
    public static void a(String str, int i2) {
        try {
            if (f170b == null) {
                c.a(str, i2);
                return;
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        b(str, i2);
    }

    private static void b(String str, int i2) {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                if (f170b == null) {
                    f170b = Trace.class.getMethod("asyncTraceBegin", Long.TYPE, String.class, Integer.TYPE);
                }
                f170b.invoke(null, Long.valueOf(f169a), str, Integer.valueOf(i2));
            } catch (Exception e2) {
                g("asyncTraceBegin", e2);
            }
        }
    }

    public static void c(String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            b.a(str);
        }
    }

    @SuppressLint({"NewApi"})
    public static void d(String str, int i2) {
        try {
            if (f171c == null) {
                c.b(str, i2);
                return;
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        e(str, i2);
    }

    private static void e(String str, int i2) {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                if (f171c == null) {
                    f171c = Trace.class.getMethod("asyncTraceEnd", Long.TYPE, String.class, Integer.TYPE);
                }
                f171c.invoke(null, Long.valueOf(f169a), str, Integer.valueOf(i2));
            } catch (Exception e2) {
                g("asyncTraceEnd", e2);
            }
        }
    }

    public static void f() {
        if (Build.VERSION.SDK_INT >= 18) {
            b.b();
        }
    }

    private static void g(String str, Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (!(cause instanceof RuntimeException)) {
                throw new RuntimeException(cause);
            }
            throw ((RuntimeException) cause);
        }
        Log.v("Trace", "Unable to call " + str + " via reflection", exc);
    }
}
