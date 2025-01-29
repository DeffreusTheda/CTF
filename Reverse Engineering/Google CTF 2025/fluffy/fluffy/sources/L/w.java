package l;

import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;

/* loaded from: classes.dex */
public final class w extends a.a {

    /* renamed from: e, reason: collision with root package name */
    public final WindowInsetsController f974e;

    /* renamed from: f, reason: collision with root package name */
    public final Window f975f;

    public w(Window window) {
        WindowInsetsController insetsController;
        insetsController = window.getInsetsController();
        this.f974e = insetsController;
        this.f975f = window;
    }

    @Override // a.a
    public final void v(boolean z2) {
        Window window = this.f975f;
        if (z2) {
            if (window != null) {
                View decorView = window.getDecorView();
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 16);
            }
            this.f974e.setSystemBarsAppearance(16, 16);
            return;
        }
        if (window != null) {
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() & (-17));
        }
        this.f974e.setSystemBarsAppearance(0, 16);
    }

    @Override // a.a
    public final void w(boolean z2) {
        Window window = this.f975f;
        if (z2) {
            if (window != null) {
                View decorView = window.getDecorView();
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 8192);
            }
            this.f974e.setSystemBarsAppearance(8, 8);
            return;
        }
        if (window != null) {
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() & (-8193));
        }
        this.f974e.setSystemBarsAppearance(0, 8);
    }
}
