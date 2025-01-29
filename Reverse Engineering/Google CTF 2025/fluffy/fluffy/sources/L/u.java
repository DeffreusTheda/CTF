package l;

import android.view.View;
import android.view.Window;

/* loaded from: classes.dex */
public class u extends t {
    @Override // a.a
    public final void w(boolean z2) {
        Window window = this.f973e;
        if (!z2) {
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & (-8193));
        } else {
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() | 8192);
        }
    }
}
