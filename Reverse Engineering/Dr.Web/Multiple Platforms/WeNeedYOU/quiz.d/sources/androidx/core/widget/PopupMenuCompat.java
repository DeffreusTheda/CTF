package androidx.core.widget;

import android.view.View;
import android.widget.PopupMenu;

/* loaded from: classes2.dex */
public final class PopupMenuCompat {
    private PopupMenuCompat() {
    }

    public static View.OnTouchListener getDragToOpenListener(Object obj) {
        return ((PopupMenu) obj).getDragToOpenListener();
    }
}
