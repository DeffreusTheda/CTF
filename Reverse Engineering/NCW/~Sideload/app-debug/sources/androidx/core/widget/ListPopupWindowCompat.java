package androidx.core.widget;

import android.view.View;
import android.widget.ListPopupWindow;

/* loaded from: classes.dex */
public final class ListPopupWindowCompat {
    private ListPopupWindowCompat() {
    }

    @Deprecated
    public static View.OnTouchListener createDragToOpenListener(Object listPopupWindow, View src) {
        return createDragToOpenListener((ListPopupWindow) listPopupWindow, src);
    }

    public static View.OnTouchListener createDragToOpenListener(ListPopupWindow listPopupWindow, View src) {
        return listPopupWindow.createDragToOpenListener(src);
    }
}
