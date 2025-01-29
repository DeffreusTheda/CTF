package y;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import androidx.window.sidecar.SidecarInterface;
import androidx.window.sidecar.SidecarProvider;
import s.AbstractC0097g;
import s.C0099i;

/* loaded from: classes.dex */
public abstract class g {
    public static IBinder a(Activity activity) {
        Window window;
        WindowManager.LayoutParams attributes;
        if (activity == null || (window = activity.getWindow()) == null || (attributes = window.getAttributes()) == null) {
            return null;
        }
        return attributes.token;
    }

    public static SidecarInterface b(Context context) {
        a0.h.e(context, "context");
        return SidecarProvider.getSidecarImpl(context.getApplicationContext());
    }

    public static C0099i c() {
        try {
            String apiVersion = SidecarProvider.getApiVersion();
            if (TextUtils.isEmpty(apiVersion)) {
                return null;
            }
            C0099i c0099i = C0099i.f1166g;
            return AbstractC0097g.c(apiVersion);
        } catch (NoClassDefFoundError | UnsupportedOperationException unused) {
            return null;
        }
    }
}
