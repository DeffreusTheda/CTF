package androidx.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

/* loaded from: classes.dex */
public final class q extends c {
    final /* synthetic */ r this$0;

    public static final class a extends c {
        final /* synthetic */ r this$0;

        public a(r rVar) {
            this.this$0 = rVar;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity) {
            a0.h.e(activity, "activity");
            this.this$0.b();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity) {
            a0.h.e(activity, "activity");
            r rVar = this.this$0;
            int i2 = rVar.f421a + 1;
            rVar.f421a = i2;
            if (i2 == 1 && rVar.f424d) {
                rVar.f426f.c(f.ON_START);
                rVar.f424d = false;
            }
        }
    }

    public q(r rVar) {
        this.this$0 = rVar;
    }

    @Override // androidx.lifecycle.c, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        a0.h.e(activity, "activity");
        if (Build.VERSION.SDK_INT < 29) {
            int i2 = u.f429b;
            Fragment findFragmentByTag = activity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
            a0.h.c(findFragmentByTag, "null cannot be cast to non-null type androidx.lifecycle.ReportFragment");
            ((u) findFragmentByTag).f430a = this.this$0.f428h;
        }
    }

    @Override // androidx.lifecycle.c, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        a0.h.e(activity, "activity");
        r rVar = this.this$0;
        int i2 = rVar.f422b - 1;
        rVar.f422b = i2;
        if (i2 == 0) {
            Handler handler = rVar.f425e;
            a0.h.b(handler);
            handler.postDelayed(rVar.f427g, 700L);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreCreated(Activity activity, Bundle bundle) {
        a0.h.e(activity, "activity");
        p.a(activity, new a(this.this$0));
    }

    @Override // androidx.lifecycle.c, android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        a0.h.e(activity, "activity");
        r rVar = this.this$0;
        int i2 = rVar.f421a - 1;
        rVar.f421a = i2;
        if (i2 == 0 && rVar.f423c) {
            rVar.f426f.c(f.ON_STOP);
            rVar.f424d = true;
        }
    }
}
