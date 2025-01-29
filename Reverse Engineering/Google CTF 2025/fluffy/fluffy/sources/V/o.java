package v;

import D.AbstractC0011l;
import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.WindowManager;
import android.view.WindowMetrics;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import l.C0074h;
import l.C0076j;
import l.C0077k;
import l.s;
import s.C0092b;
import z.C0105a;

/* loaded from: classes.dex */
public final class o implements n {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f1209b = 0;

    static {
        new ArrayList(new R.b(new Integer[]{1, 2, 4, 8, 16, 32, 64, 128}, true));
    }

    public static l a(Activity activity) {
        Rect rect;
        int i2;
        boolean isInMultiWindowMode;
        s b2;
        Object systemService;
        WindowMetrics currentWindowMetrics;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 30) {
            systemService = activity.getSystemService((Class<Object>) WindowManager.class);
            currentWindowMetrics = ((WindowManager) systemService).getCurrentWindowMetrics();
            rect = currentWindowMetrics.getBounds();
            a0.h.d(rect, "wm.currentWindowMetrics.bounds");
        } else if (i3 >= 29) {
            Configuration configuration = activity.getResources().getConfiguration();
            try {
                Field declaredField = Configuration.class.getDeclaredField("windowConfiguration");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(configuration);
                Object invoke = obj.getClass().getDeclaredMethod("getBounds", null).invoke(obj, null);
                a0.h.c(invoke, "null cannot be cast to non-null type android.graphics.Rect");
                rect = new Rect((Rect) invoke);
            } catch (IllegalAccessException e2) {
                Log.w("o", e2);
                rect = b(activity);
            } catch (NoSuchFieldException e3) {
                Log.w("o", e3);
                rect = b(activity);
            } catch (NoSuchMethodException e4) {
                Log.w("o", e4);
                rect = b(activity);
            } catch (InvocationTargetException e5) {
                Log.w("o", e5);
                rect = b(activity);
            }
        } else if (i3 >= 28) {
            rect = b(activity);
        } else if (i3 >= 24) {
            rect = new Rect();
            Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            defaultDisplay.getRectSize(rect);
            isInMultiWindowMode = activity.isInMultiWindowMode();
            if (!isInMultiWindowMode) {
                Point point = new Point();
                defaultDisplay.getRealSize(point);
                Resources resources = activity.getResources();
                int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
                int dimensionPixelSize = identifier > 0 ? resources.getDimensionPixelSize(identifier) : 0;
                int i4 = rect.bottom + dimensionPixelSize;
                if (i4 == point.y) {
                    rect.bottom = i4;
                } else {
                    int i5 = rect.right + dimensionPixelSize;
                    if (i5 == point.x) {
                        rect.right = i5;
                    }
                }
            }
        } else {
            Display defaultDisplay2 = activity.getWindowManager().getDefaultDisplay();
            a0.h.d(defaultDisplay2, "defaultDisplay");
            Point point2 = new Point();
            defaultDisplay2.getRealSize(point2);
            Rect rect2 = new Rect();
            int i6 = point2.x;
            if (i6 == 0 || (i2 = point2.y) == 0) {
                defaultDisplay2.getRectSize(rect2);
            } else {
                rect2.right = i6;
                rect2.bottom = i2;
            }
            rect = rect2;
        }
        int i7 = Build.VERSION.SDK_INT;
        if (i7 < 30) {
            b2 = (i7 >= 30 ? new C0077k() : i7 >= 29 ? new C0076j() : new C0074h()).b();
            a0.h.d(b2, "{\n            WindowInse…ilder().build()\n        }");
        } else {
            if (i7 < 30) {
                throw new Exception("Incompatible SDK version");
            }
            b2 = C0105a.f1243a.a(activity);
        }
        return new l(new C0092b(rect), b2);
    }

    public static Rect b(Activity activity) {
        boolean isInMultiWindowMode;
        boolean isInMultiWindowMode2;
        int safeInsetLeft;
        int safeInsetRight;
        int safeInsetTop;
        int safeInsetBottom;
        int safeInsetBottom2;
        int safeInsetRight2;
        boolean isInMultiWindowMode3;
        Rect rect = new Rect();
        Configuration configuration = activity.getResources().getConfiguration();
        DisplayCutout displayCutout = null;
        try {
            Field declaredField = Configuration.class.getDeclaredField("windowConfiguration");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(configuration);
            isInMultiWindowMode3 = activity.isInMultiWindowMode();
            if (isInMultiWindowMode3) {
                Object invoke = obj.getClass().getDeclaredMethod("getBounds", null).invoke(obj, null);
                a0.h.c(invoke, "null cannot be cast to non-null type android.graphics.Rect");
                rect.set((Rect) invoke);
            } else {
                Object invoke2 = obj.getClass().getDeclaredMethod("getAppBounds", null).invoke(obj, null);
                a0.h.c(invoke2, "null cannot be cast to non-null type android.graphics.Rect");
                rect.set((Rect) invoke2);
            }
        } catch (IllegalAccessException e2) {
            Log.w("o", e2);
            activity.getWindowManager().getDefaultDisplay().getRectSize(rect);
        } catch (NoSuchFieldException e3) {
            Log.w("o", e3);
            activity.getWindowManager().getDefaultDisplay().getRectSize(rect);
        } catch (NoSuchMethodException e4) {
            Log.w("o", e4);
            activity.getWindowManager().getDefaultDisplay().getRectSize(rect);
        } catch (InvocationTargetException e5) {
            Log.w("o", e5);
            activity.getWindowManager().getDefaultDisplay().getRectSize(rect);
        }
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        a0.h.d(defaultDisplay, "currentDisplay");
        defaultDisplay.getRealSize(point);
        isInMultiWindowMode = activity.isInMultiWindowMode();
        if (!isInMultiWindowMode) {
            Resources resources = activity.getResources();
            int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
            int dimensionPixelSize = identifier > 0 ? resources.getDimensionPixelSize(identifier) : 0;
            int i2 = rect.bottom + dimensionPixelSize;
            if (i2 == point.y) {
                rect.bottom = i2;
            } else {
                int i3 = rect.right + dimensionPixelSize;
                if (i3 == point.x) {
                    rect.right = i3;
                } else if (rect.left == dimensionPixelSize) {
                    rect.left = 0;
                }
            }
        }
        if (rect.width() < point.x || rect.height() < point.y) {
            isInMultiWindowMode2 = activity.isInMultiWindowMode();
            if (!isInMultiWindowMode2) {
                try {
                    Constructor<?> constructor = Class.forName("android.view.DisplayInfo").getConstructor(null);
                    constructor.setAccessible(true);
                    Object newInstance = constructor.newInstance(null);
                    Method declaredMethod = defaultDisplay.getClass().getDeclaredMethod("getDisplayInfo", newInstance.getClass());
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(defaultDisplay, newInstance);
                    Field declaredField2 = newInstance.getClass().getDeclaredField("displayCutout");
                    declaredField2.setAccessible(true);
                    Object obj2 = declaredField2.get(newInstance);
                    if (AbstractC0011l.r(obj2)) {
                        displayCutout = AbstractC0011l.i(obj2);
                    }
                } catch (ClassNotFoundException e6) {
                    Log.w("o", e6);
                } catch (IllegalAccessException e7) {
                    Log.w("o", e7);
                } catch (InstantiationException e8) {
                    Log.w("o", e8);
                } catch (NoSuchFieldException e9) {
                    Log.w("o", e9);
                } catch (NoSuchMethodException e10) {
                    Log.w("o", e10);
                } catch (InvocationTargetException e11) {
                    Log.w("o", e11);
                }
                if (displayCutout != null) {
                    int i4 = rect.left;
                    safeInsetLeft = displayCutout.getSafeInsetLeft();
                    if (i4 == safeInsetLeft) {
                        rect.left = 0;
                    }
                    int i5 = point.x - rect.right;
                    safeInsetRight = displayCutout.getSafeInsetRight();
                    if (i5 == safeInsetRight) {
                        int i6 = rect.right;
                        safeInsetRight2 = displayCutout.getSafeInsetRight();
                        rect.right = safeInsetRight2 + i6;
                    }
                    int i7 = rect.top;
                    safeInsetTop = displayCutout.getSafeInsetTop();
                    if (i7 == safeInsetTop) {
                        rect.top = 0;
                    }
                    int i8 = point.y - rect.bottom;
                    safeInsetBottom = displayCutout.getSafeInsetBottom();
                    if (i8 == safeInsetBottom) {
                        int i9 = rect.bottom;
                        safeInsetBottom2 = displayCutout.getSafeInsetBottom();
                        rect.bottom = safeInsetBottom2 + i9;
                    }
                }
            }
        }
        return rect;
    }
}
