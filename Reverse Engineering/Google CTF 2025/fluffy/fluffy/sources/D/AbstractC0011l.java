package D;

import android.app.ActivityManager;
import android.view.DisplayCutout;

/* renamed from: D.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC0011l {
    public static /* synthetic */ ActivityManager.TaskDescription c(String str, int i2) {
        return new ActivityManager.TaskDescription(str, 0, i2);
    }

    public static /* bridge */ /* synthetic */ DisplayCutout i(Object obj) {
        return (DisplayCutout) obj;
    }

    public static /* bridge */ /* synthetic */ boolean r(Object obj) {
        return obj instanceof DisplayCutout;
    }
}
