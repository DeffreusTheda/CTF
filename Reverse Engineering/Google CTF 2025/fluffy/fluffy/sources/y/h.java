package y;

import android.app.Activity;
import android.os.IBinder;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class h implements View.OnAttachStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final i f1229a;

    /* renamed from: b, reason: collision with root package name */
    public final WeakReference f1230b;

    public h(i iVar, Activity activity) {
        a0.h.e(iVar, "sidecarCompat");
        this.f1229a = iVar;
        this.f1230b = new WeakReference(activity);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        Window window;
        WindowManager.LayoutParams attributes;
        a0.h.e(view, "view");
        view.removeOnAttachStateChangeListener(this);
        Activity activity = (Activity) this.f1230b.get();
        IBinder iBinder = (activity == null || (window = activity.getWindow()) == null || (attributes = window.getAttributes()) == null) ? null : attributes.token;
        if (activity == null || iBinder == null) {
            return;
        }
        this.f1229a.g(iBinder, activity);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        a0.h.e(view, "view");
    }
}
