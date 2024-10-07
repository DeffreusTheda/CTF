package androidx.transition;

import android.os.Build;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
class ViewGroupUtils {
    private static Method sGetChildDrawingOrderMethod;
    private static boolean sGetChildDrawingOrderMethodFetched;
    private static boolean sTryHiddenSuppressLayout = true;

    static void suppressLayout(ViewGroup group, boolean suppress) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.suppressLayout(group, suppress);
        } else {
            hiddenSuppressLayout(group, suppress);
        }
    }

    private static void hiddenSuppressLayout(ViewGroup group, boolean suppress) {
        if (sTryHiddenSuppressLayout) {
            try {
                Api29Impl.suppressLayout(group, suppress);
            } catch (NoSuchMethodError e) {
                sTryHiddenSuppressLayout = false;
            }
        }
    }

    static int getChildDrawingOrder(ViewGroup viewGroup, int i) {
        if (Build.VERSION.SDK_INT >= 29) {
            return Api29Impl.getChildDrawingOrder(viewGroup, i);
        }
        if (!sGetChildDrawingOrderMethodFetched) {
            try {
                Method declaredMethod = ViewGroup.class.getDeclaredMethod("getChildDrawingOrder", Integer.TYPE, Integer.TYPE);
                sGetChildDrawingOrderMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            sGetChildDrawingOrderMethodFetched = true;
        }
        Method method = sGetChildDrawingOrderMethod;
        if (method != null) {
            try {
                return ((Integer) method.invoke(viewGroup, Integer.valueOf(viewGroup.getChildCount()), Integer.valueOf(i))).intValue();
            } catch (IllegalAccessException e2) {
            } catch (InvocationTargetException e3) {
            }
        }
        return i;
    }

    private ViewGroupUtils() {
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static void suppressLayout(ViewGroup viewGroup, boolean suppress) {
            viewGroup.suppressLayout(suppress);
        }

        static int getChildDrawingOrder(ViewGroup viewGroup, int drawingPosition) {
            return viewGroup.getChildDrawingOrder(drawingPosition);
        }
    }
}
