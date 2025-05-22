package androidx.core.widget;

import android.widget.ListView;

@Deprecated
/* loaded from: classes2.dex */
public final class ListViewCompat {
    @Deprecated
    public static void scrollListBy(ListView listView, int i) {
        listView.scrollListBy(i);
    }

    @Deprecated
    public static boolean canScrollList(ListView listView, int i) {
        return listView.canScrollList(i);
    }

    private ListViewCompat() {
    }
}
