package z;

import a0.h;
import android.content.Context;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import l.s;

/* renamed from: z.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0105a {

    /* renamed from: a, reason: collision with root package name */
    public static final C0105a f1243a = new C0105a();

    public final s a(Context context) {
        Object systemService;
        WindowMetrics currentWindowMetrics;
        WindowInsets windowInsets;
        h.e(context, "context");
        systemService = context.getSystemService((Class<Object>) WindowManager.class);
        currentWindowMetrics = ((WindowManager) systemService).getCurrentWindowMetrics();
        windowInsets = currentWindowMetrics.getWindowInsets();
        h.d(windowInsets, "context.getSystemService…indowMetrics.windowInsets");
        return s.a(windowInsets, null);
    }
}
