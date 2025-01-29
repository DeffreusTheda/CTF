package x;

import a0.h;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Point;
import android.graphics.Rect;
import android.inputmethodservice.InputMethodService;
import android.os.Build;
import android.view.Display;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import androidx.window.extensions.layout.FoldingFeature;
import androidx.window.extensions.layout.WindowLayoutInfo;
import java.util.ArrayList;
import java.util.List;
import l.C0074h;
import l.C0076j;
import l.C0077k;
import l.s;
import s.C0092b;
import v.k;
import v.l;
import v.o;

/* loaded from: classes.dex */
public abstract class e {
    public static v.c a(l lVar, FoldingFeature foldingFeature) {
        v.b bVar;
        v.b bVar2;
        int type = foldingFeature.getType();
        if (type == 1) {
            bVar = v.b.f1181h;
        } else {
            if (type != 2) {
                return null;
            }
            bVar = v.b.f1182i;
        }
        int state = foldingFeature.getState();
        if (state == 1) {
            bVar2 = v.b.f1179f;
        } else {
            if (state != 2) {
                return null;
            }
            bVar2 = v.b.f1180g;
        }
        Rect bounds = foldingFeature.getBounds();
        h.d(bounds, "oemFeature.bounds");
        C0092b c0092b = new C0092b(bounds);
        Rect c2 = lVar.f1205a.c();
        if (c0092b.a() == 0 && c0092b.b() == 0) {
            return null;
        }
        if (c0092b.b() != c2.width() && c0092b.a() != c2.height()) {
            return null;
        }
        if (c0092b.b() < c2.width() && c0092b.a() < c2.height()) {
            return null;
        }
        if (c0092b.b() == c2.width() && c0092b.a() == c2.height()) {
            return null;
        }
        Rect bounds2 = foldingFeature.getBounds();
        h.d(bounds2, "oemFeature.bounds");
        return new v.c(new C0092b(bounds2), bVar, bVar2);
    }

    public static k b(Context context, WindowLayoutInfo windowLayoutInfo) {
        l lVar;
        Object systemService;
        WindowMetrics currentWindowMetrics;
        WindowInsets windowInsets;
        WindowMetrics currentWindowMetrics2;
        Rect bounds;
        h.e(windowLayoutInfo, "info");
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 30) {
            if (i2 < 29 || !(context instanceof Activity)) {
                throw new UnsupportedOperationException("Display Features are only supported after Q. Display features for non-Activity contexts are not expected to be reported on devices running Q.");
            }
            int i3 = o.f1209b;
            return c(o.a((Activity) context), windowLayoutInfo);
        }
        int i4 = o.f1209b;
        if (i2 < 30) {
            Context context2 = context;
            while (context2 instanceof ContextWrapper) {
                boolean z2 = context2 instanceof Activity;
                if (!z2 && !(context2 instanceof InputMethodService)) {
                    ContextWrapper contextWrapper = (ContextWrapper) context2;
                    if (contextWrapper.getBaseContext() != null) {
                        context2 = contextWrapper.getBaseContext();
                        h.d(context2, "iterator.baseContext");
                    }
                }
                if (z2) {
                    lVar = o.a((Activity) context);
                } else {
                    if (!(context2 instanceof InputMethodService)) {
                        throw new IllegalArgumentException(context + " is not a UiContext");
                    }
                    Object systemService2 = context.getSystemService("window");
                    h.c(systemService2, "null cannot be cast to non-null type android.view.WindowManager");
                    Display defaultDisplay = ((WindowManager) systemService2).getDefaultDisplay();
                    h.d(defaultDisplay, "wm.defaultDisplay");
                    Point point = new Point();
                    defaultDisplay.getRealSize(point);
                    Rect rect = new Rect(0, 0, point.x, point.y);
                    int i5 = Build.VERSION.SDK_INT;
                    s b2 = (i5 >= 30 ? new C0077k() : i5 >= 29 ? new C0076j() : new C0074h()).b();
                    h.d(b2, "Builder().build()");
                    lVar = new l(rect, b2);
                }
            }
            throw new IllegalArgumentException("Context " + context + " is not a UiContext");
        }
        systemService = context.getSystemService((Class<Object>) WindowManager.class);
        WindowManager windowManager = (WindowManager) systemService;
        currentWindowMetrics = windowManager.getCurrentWindowMetrics();
        windowInsets = currentWindowMetrics.getWindowInsets();
        s a2 = s.a(windowInsets, null);
        currentWindowMetrics2 = windowManager.getCurrentWindowMetrics();
        bounds = currentWindowMetrics2.getBounds();
        h.d(bounds, "wm.currentWindowMetrics.bounds");
        lVar = new l(bounds, a2);
        return c(lVar, windowLayoutInfo);
    }

    public static k c(l lVar, WindowLayoutInfo windowLayoutInfo) {
        v.c cVar;
        h.e(windowLayoutInfo, "info");
        List<FoldingFeature> displayFeatures = windowLayoutInfo.getDisplayFeatures();
        h.d(displayFeatures, "info.displayFeatures");
        ArrayList arrayList = new ArrayList();
        for (FoldingFeature foldingFeature : displayFeatures) {
            if (foldingFeature instanceof FoldingFeature) {
                h.d(foldingFeature, "feature");
                cVar = a(lVar, foldingFeature);
            } else {
                cVar = null;
            }
            if (cVar != null) {
                arrayList.add(cVar);
            }
        }
        return new k(arrayList);
    }
}
