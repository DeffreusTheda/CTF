package androidx.lifecycle;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import androidx.lifecycle.u;

/* loaded from: classes.dex */
public final class i extends c {
    @Override // androidx.lifecycle.c, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        a0.h.e(activity, "activity");
        int i2 = u.f429b;
        if (Build.VERSION.SDK_INT >= 29) {
            u.a.Companion.getClass();
            activity.registerActivityLifecycleCallbacks(new u.a());
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new u(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }
}
