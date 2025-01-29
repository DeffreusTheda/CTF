package l;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import h.C0040b;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/* renamed from: l.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0079m extends r {

    /* renamed from: f, reason: collision with root package name */
    public static boolean f960f = false;

    /* renamed from: g, reason: collision with root package name */
    public static Method f961g;

    /* renamed from: h, reason: collision with root package name */
    public static Class f962h;

    /* renamed from: i, reason: collision with root package name */
    public static Field f963i;

    /* renamed from: j, reason: collision with root package name */
    public static Field f964j;

    /* renamed from: c, reason: collision with root package name */
    public final WindowInsets f965c;

    /* renamed from: d, reason: collision with root package name */
    public C0040b f966d;

    /* renamed from: e, reason: collision with root package name */
    public C0040b f967e;

    public AbstractC0079m(s sVar, WindowInsets windowInsets) {
        super(sVar);
        this.f966d = null;
        this.f965c = windowInsets;
    }

    private C0040b m(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }
        if (!f960f) {
            n();
        }
        Method method = f961g;
        if (method != null && f962h != null && f963i != null) {
            try {
                Object invoke = method.invoke(view, null);
                if (invoke == null) {
                    Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                    return null;
                }
                Rect rect = (Rect) f963i.get(f964j.get(invoke));
                if (rect != null) {
                    return C0040b.a(rect.left, rect.top, rect.right, rect.bottom);
                }
                return null;
            } catch (ReflectiveOperationException e2) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e2.getMessage(), e2);
            }
        }
        return null;
    }

    private static void n() {
        try {
            f961g = View.class.getDeclaredMethod("getViewRootImpl", null);
            Class<?> cls = Class.forName("android.view.View$AttachInfo");
            f962h = cls;
            f963i = cls.getDeclaredField("mVisibleInsets");
            f964j = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
            f963i.setAccessible(true);
            f964j.setAccessible(true);
        } catch (ReflectiveOperationException e2) {
            Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e2.getMessage(), e2);
        }
        f960f = true;
    }

    @Override // l.r
    public void d(View view) {
        C0040b m = m(view);
        if (m == null) {
            m = C0040b.f510e;
        }
        o(m);
    }

    @Override // l.r
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return Objects.equals(this.f967e, ((AbstractC0079m) obj).f967e);
        }
        return false;
    }

    @Override // l.r
    public final C0040b g() {
        if (this.f966d == null) {
            WindowInsets windowInsets = this.f965c;
            this.f966d = C0040b.a(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
        }
        return this.f966d;
    }

    @Override // l.r
    public boolean i() {
        return this.f965c.isRound();
    }

    public void o(C0040b c0040b) {
        this.f967e = c0040b;
    }

    @Override // l.r
    public void j(C0040b[] c0040bArr) {
    }

    @Override // l.r
    public void k(s sVar) {
    }
}
