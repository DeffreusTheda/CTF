package l;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import com.google.ctf.fluffy.R;
import h.C0040b;

/* renamed from: l.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0070d {
    public static void a(WindowInsets windowInsets, View view) {
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback);
        if (onApplyWindowInsetsListener != null) {
            onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
        }
    }

    public static s b(View view, s sVar, Rect rect) {
        r rVar = sVar.f972a;
        WindowInsets windowInsets = rVar instanceof AbstractC0079m ? ((AbstractC0079m) rVar).f965c : null;
        if (windowInsets != null) {
            return s.a(view.computeSystemWindowInsets(windowInsets, rect), view);
        }
        rect.setEmpty();
        return sVar;
    }

    public static boolean c(View view, float f2, float f3, boolean z2) {
        return view.dispatchNestedFling(f2, f3, z2);
    }

    public static boolean d(View view, float f2, float f3) {
        return view.dispatchNestedPreFling(f2, f3);
    }

    public static boolean e(View view, int i2, int i3, int[] iArr, int[] iArr2) {
        return view.dispatchNestedPreScroll(i2, i3, iArr, iArr2);
    }

    public static boolean f(View view, int i2, int i3, int i4, int i5, int[] iArr) {
        return view.dispatchNestedScroll(i2, i3, i4, i5, iArr);
    }

    public static ColorStateList g(View view) {
        return view.getBackgroundTintList();
    }

    public static PorterDuff.Mode h(View view) {
        return view.getBackgroundTintMode();
    }

    public static float i(View view) {
        return view.getElevation();
    }

    public static s j(View view) {
        if (!AbstractC0073g.f952d || !view.isAttachedToWindow()) {
            return null;
        }
        try {
            Object obj = AbstractC0073g.f949a.get(view.getRootView());
            if (obj == null) {
                return null;
            }
            Rect rect = (Rect) AbstractC0073g.f950b.get(obj);
            Rect rect2 = (Rect) AbstractC0073g.f951c.get(obj);
            if (rect == null || rect2 == null) {
                return null;
            }
            int i2 = Build.VERSION.SDK_INT;
            AbstractC0078l c0077k = i2 >= 30 ? new C0077k() : i2 >= 29 ? new C0076j() : new C0074h();
            c0077k.c(C0040b.a(rect.left, rect.top, rect.right, rect.bottom));
            c0077k.d(C0040b.a(rect2.left, rect2.top, rect2.right, rect2.bottom));
            s b2 = c0077k.b();
            b2.f972a.k(b2);
            b2.f972a.d(view.getRootView());
            return b2;
        } catch (IllegalAccessException e2) {
            Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e2.getMessage(), e2);
            return null;
        }
    }

    public static String k(View view) {
        return view.getTransitionName();
    }

    public static float l(View view) {
        return view.getTranslationZ();
    }

    public static float m(View view) {
        return view.getZ();
    }

    public static boolean n(View view) {
        return view.hasNestedScrollingParent();
    }

    public static boolean o(View view) {
        return view.isImportantForAccessibility();
    }

    public static boolean p(View view) {
        return view.isNestedScrollingEnabled();
    }

    public static void q(View view, ColorStateList colorStateList) {
        view.setBackgroundTintList(colorStateList);
    }

    public static void r(View view, PorterDuff.Mode mode) {
        view.setBackgroundTintMode(mode);
    }

    public static void s(View view, float f2) {
        view.setElevation(f2);
    }

    public static void t(View view, boolean z2) {
        view.setNestedScrollingEnabled(z2);
    }

    public static void u(View view, InterfaceC0068b interfaceC0068b) {
        if (Build.VERSION.SDK_INT < 30) {
            view.setTag(R.id.tag_on_apply_window_listener, interfaceC0068b);
        }
        if (interfaceC0068b == null) {
            view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback));
        } else {
            view.setOnApplyWindowInsetsListener(new ViewOnApplyWindowInsetsListenerC0069c(view, interfaceC0068b));
        }
    }

    public static void v(View view, String str) {
        view.setTransitionName(str);
    }

    public static void w(View view, float f2) {
        view.setTranslationZ(f2);
    }

    public static void x(View view, float f2) {
        view.setZ(f2);
    }

    public static boolean y(View view, int i2) {
        return view.startNestedScroll(i2);
    }

    public static void z(View view) {
        view.stopNestedScroll();
    }
}
