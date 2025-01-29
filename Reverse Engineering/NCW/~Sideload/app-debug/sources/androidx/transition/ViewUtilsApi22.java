package androidx.transition;

import android.view.View;

/* loaded from: classes.dex */
class ViewUtilsApi22 extends ViewUtilsApi21 {
    private static boolean sTryHiddenSetLeftTopRightBottom = true;

    ViewUtilsApi22() {
    }

    @Override // androidx.transition.ViewUtilsApi19
    public void setLeftTopRightBottom(View v, int left, int top, int right, int bottom) {
        if (sTryHiddenSetLeftTopRightBottom) {
            try {
                Api29Impl.setLeftTopRightBottom(v, left, top, right, bottom);
            } catch (NoSuchMethodError e) {
                sTryHiddenSetLeftTopRightBottom = false;
            }
        }
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static void setLeftTopRightBottom(View view, int left, int top, int right, int bottom) {
            view.setLeftTopRightBottom(left, top, right, bottom);
        }
    }
}
