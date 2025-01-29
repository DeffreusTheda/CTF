package i0;

import a0.h;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;

/* loaded from: classes.dex */
public abstract class d {
    private static volatile Choreographer choreographer;

    static {
        Object f2;
        try {
            f2 = new c(a(Looper.getMainLooper()));
        } catch (Throwable th) {
            f2 = a.a.f(th);
        }
        if (f2 instanceof Q.c) {
            f2 = null;
        }
    }

    public static final Handler a(Looper looper) {
        if (Build.VERSION.SDK_INT < 28) {
            try {
                return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
            } catch (NoSuchMethodException unused) {
                return new Handler(looper);
            }
        }
        Object invoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
        h.c(invoke, "null cannot be cast to non-null type android.os.Handler");
        return (Handler) invoke;
    }
}
