package s;

import a0.l;
import androidx.window.extensions.WindowExtensionsProvider;

/* renamed from: s.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0095e {
    static {
        l.a(AbstractC0095e.class).b();
    }

    public static int a() {
        try {
            return WindowExtensionsProvider.getWindowExtensions().getVendorApiLevel();
        } catch (NoClassDefFoundError | UnsupportedOperationException unused) {
            return 0;
        }
    }
}
