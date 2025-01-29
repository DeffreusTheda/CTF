package l;

import android.view.View;
import android.view.WindowInsets;

/* renamed from: l.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0071e {
    public static s a(View view) {
        WindowInsets rootWindowInsets = view.getRootWindowInsets();
        if (rootWindowInsets == null) {
            return null;
        }
        s a2 = s.a(rootWindowInsets, null);
        r rVar = a2.f972a;
        rVar.k(a2);
        rVar.d(view.getRootView());
        return a2;
    }

    public static int b(View view) {
        return view.getScrollIndicators();
    }

    public static void c(View view, int i2) {
        view.setScrollIndicators(i2);
    }

    public static void d(View view, int i2, int i3) {
        view.setScrollIndicators(i2, i3);
    }
}
