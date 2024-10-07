package androidx.core.widget;

import android.widget.ListView;

@Deprecated
/* loaded from: classes.dex */
public final class ListViewCompat {
    @Deprecated
    public static void scrollListBy(ListView listView, int y) {
        listView.scrollListBy(y);
    }

    @Deprecated
    public static boolean canScrollList(ListView listView, int direction) {
        return listView.canScrollList(direction);
    }

    private ListViewCompat() {
    }
}
