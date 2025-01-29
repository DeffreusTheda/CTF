package D;

import android.view.Surface;
import android.view.SurfaceControl;
import android.view.WindowInsets;

/* renamed from: D.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC0010k {
    public static /* synthetic */ Surface f(SurfaceControl surfaceControl) {
        return new Surface(surfaceControl);
    }

    public static /* synthetic */ SurfaceControl.Builder g() {
        return new SurfaceControl.Builder();
    }

    public static /* synthetic */ SurfaceControl.Transaction h() {
        return new SurfaceControl.Transaction();
    }

    public static /* bridge */ /* synthetic */ SurfaceControl.Transaction j(Object obj) {
        return (SurfaceControl.Transaction) obj;
    }

    public static /* synthetic */ WindowInsets.Builder l(WindowInsets windowInsets) {
        return new WindowInsets.Builder(windowInsets);
    }

    public static /* synthetic */ void m() {
    }
}
