package androidx.core.app;

import android.os.Bundle;
import android.os.IBinder;

@Deprecated
/* loaded from: classes.dex */
public final class BundleCompat {
    private BundleCompat() {
    }

    public static IBinder getBinder(Bundle bundle, String key) {
        return bundle.getBinder(key);
    }

    public static void putBinder(Bundle bundle, String key, IBinder binder) {
        bundle.putBinder(key, binder);
    }
}
