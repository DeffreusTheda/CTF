package androidx.lifecycle;

import D.v;
import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;

/* loaded from: classes.dex */
public class u extends Fragment {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f429b = 0;

    /* renamed from: a, reason: collision with root package name */
    public v f430a;

    public static final class a implements Application.ActivityLifecycleCallbacks {
        public static final t Companion = new t();

        public static final void registerIn(Activity activity) {
            Companion.getClass();
            a0.h.e(activity, "activity");
            activity.registerActivityLifecycleCallbacks(new a());
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            a0.h.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            a0.h.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            a0.h.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostCreated(Activity activity, Bundle bundle) {
            a0.h.e(activity, "activity");
            int i2 = u.f429b;
            s.a(activity, f.ON_CREATE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity) {
            a0.h.e(activity, "activity");
            int i2 = u.f429b;
            s.a(activity, f.ON_RESUME);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity) {
            a0.h.e(activity, "activity");
            int i2 = u.f429b;
            s.a(activity, f.ON_START);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreDestroyed(Activity activity) {
            a0.h.e(activity, "activity");
            int i2 = u.f429b;
            s.a(activity, f.ON_DESTROY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPrePaused(Activity activity) {
            a0.h.e(activity, "activity");
            int i2 = u.f429b;
            s.a(activity, f.ON_PAUSE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreStopped(Activity activity) {
            a0.h.e(activity, "activity");
            int i2 = u.f429b;
            s.a(activity, f.ON_STOP);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            a0.h.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            a0.h.e(activity, "activity");
            a0.h.e(bundle, "bundle");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            a0.h.e(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            a0.h.e(activity, "activity");
        }
    }

    public final void a(f fVar) {
        if (Build.VERSION.SDK_INT < 29) {
            Activity activity = getActivity();
            a0.h.d(activity, "activity");
            s.a(activity, fVar);
        }
    }

    @Override // android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a(f.ON_CREATE);
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        a(f.ON_DESTROY);
        this.f430a = null;
    }

    @Override // android.app.Fragment
    public final void onPause() {
        super.onPause();
        a(f.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        v vVar = this.f430a;
        if (vVar != null) {
            ((r) vVar.f94c).b();
        }
        a(f.ON_RESUME);
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        v vVar = this.f430a;
        if (vVar != null) {
            r rVar = (r) vVar.f94c;
            int i2 = rVar.f421a + 1;
            rVar.f421a = i2;
            if (i2 == 1 && rVar.f424d) {
                rVar.f426f.c(f.ON_START);
                rVar.f424d = false;
            }
        }
        a(f.ON_START);
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        a(f.ON_STOP);
    }
}
