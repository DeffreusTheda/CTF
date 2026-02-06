package androidx.activity;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.c;
import androidx.lifecycle.d;
import androidx.lifecycle.f;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
final class ImmLeaksCleaner implements d {

    /* renamed from: b, reason: collision with root package name */
    private static int f23b;

    /* renamed from: c, reason: collision with root package name */
    private static Field f24c;

    /* renamed from: d, reason: collision with root package name */
    private static Field f25d;

    /* renamed from: e, reason: collision with root package name */
    private static Field f26e;

    /* renamed from: a, reason: collision with root package name */
    private Activity f27a;

    private static void h() {
        try {
            f23b = 2;
            Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
            f25d = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
            f26e = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
            f24c = declaredField3;
            declaredField3.setAccessible(true);
            f23b = 1;
        } catch (NoSuchFieldException unused) {
        }
    }

    @Override // androidx.lifecycle.d
    public void g(f fVar, c.a aVar) {
        if (aVar != c.a.ON_DESTROY) {
            return;
        }
        if (f23b == 0) {
            h();
        }
        if (f23b == 1) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f27a.getSystemService("input_method");
            try {
                Object obj = f24c.get(inputMethodManager);
                if (obj == null) {
                    return;
                }
                synchronized (obj) {
                    try {
                        try {
                            View view = (View) f25d.get(inputMethodManager);
                            if (view == null) {
                                return;
                            }
                            if (view.isAttachedToWindow()) {
                                return;
                            }
                            try {
                                f26e.set(inputMethodManager, null);
                                inputMethodManager.isActive();
                            } catch (IllegalAccessException unused) {
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    } catch (ClassCastException unused2) {
                    } catch (IllegalAccessException unused3) {
                    }
                }
            } catch (IllegalAccessException unused4) {
            }
        }
    }
}
