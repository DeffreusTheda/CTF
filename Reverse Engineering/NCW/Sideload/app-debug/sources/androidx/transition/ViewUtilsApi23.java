package androidx.transition;

import android.os.Build;
import android.view.View;

/* loaded from: classes.dex */
class ViewUtilsApi23 extends ViewUtilsApi22 {
    private static boolean sTryHiddenSetTransitionVisibility = true;

    ViewUtilsApi23() {
    }

    @Override // androidx.transition.ViewUtilsApi19
    public void setTransitionVisibility(View view, int visibility) {
        if (Build.VERSION.SDK_INT == 28) {
            super.setTransitionVisibility(view, visibility);
        } else if (sTryHiddenSetTransitionVisibility) {
            try {
                Api29Impl.setTransitionVisibility(view, visibility);
            } catch (NoSuchMethodError e) {
                sTryHiddenSetTransitionVisibility = false;
            }
        }
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static void setTransitionVisibility(View view, int visibility) {
            view.setTransitionVisibility(visibility);
        }
    }
}
