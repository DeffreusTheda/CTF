package androidx.core.content;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f36a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static final Object f37b = new Object();

    /* renamed from: androidx.core.content.a$a, reason: collision with other inner class name */
    static class C0001a {
        static Executor a(Context context) {
            return context.getMainExecutor();
        }
    }

    public static Executor a(Context context) {
        return Build.VERSION.SDK_INT >= 28 ? C0001a.a(context) : d.a.a(new Handler(context.getMainLooper()));
    }
}
