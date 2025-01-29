package io.flutter.plugin.platform;

import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowMetrics;
import java.util.concurrent.Executor;
import java.util.function.Consumer;

/* loaded from: classes.dex */
public final class r implements WindowManager {

    /* renamed from: a, reason: collision with root package name */
    public final WindowManager f745a;

    /* renamed from: b, reason: collision with root package name */
    public final l f746b;

    public r(WindowManager windowManager, l lVar) {
        this.f745a = windowManager;
        this.f746b = lVar;
    }

    @Override // android.view.WindowManager
    public final void addCrossWindowBlurEnabledListener(Consumer consumer) {
        this.f745a.addCrossWindowBlurEnabledListener(consumer);
    }

    @Override // android.view.ViewManager
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        l lVar = this.f746b;
        if (lVar == null) {
            Log.w("PlatformViewsController", "Embedded view called addView while detached from presentation");
        } else {
            lVar.addView(view, layoutParams);
        }
    }

    @Override // android.view.WindowManager
    public final WindowMetrics getCurrentWindowMetrics() {
        WindowMetrics currentWindowMetrics;
        currentWindowMetrics = this.f745a.getCurrentWindowMetrics();
        return currentWindowMetrics;
    }

    @Override // android.view.WindowManager
    public final Display getDefaultDisplay() {
        return this.f745a.getDefaultDisplay();
    }

    @Override // android.view.WindowManager
    public final WindowMetrics getMaximumWindowMetrics() {
        WindowMetrics maximumWindowMetrics;
        maximumWindowMetrics = this.f745a.getMaximumWindowMetrics();
        return maximumWindowMetrics;
    }

    @Override // android.view.WindowManager
    public final boolean isCrossWindowBlurEnabled() {
        boolean isCrossWindowBlurEnabled;
        isCrossWindowBlurEnabled = this.f745a.isCrossWindowBlurEnabled();
        return isCrossWindowBlurEnabled;
    }

    @Override // android.view.WindowManager
    public final void removeCrossWindowBlurEnabledListener(Consumer consumer) {
        this.f745a.removeCrossWindowBlurEnabledListener(consumer);
    }

    @Override // android.view.ViewManager
    public final void removeView(View view) {
        l lVar = this.f746b;
        if (lVar == null) {
            Log.w("PlatformViewsController", "Embedded view called removeView while detached from presentation");
        } else {
            lVar.removeView(view);
        }
    }

    @Override // android.view.WindowManager
    public final void removeViewImmediate(View view) {
        l lVar = this.f746b;
        if (lVar == null) {
            Log.w("PlatformViewsController", "Embedded view called removeViewImmediate while detached from presentation");
        } else {
            view.clearAnimation();
            lVar.removeView(view);
        }
    }

    @Override // android.view.ViewManager
    public final void updateViewLayout(View view, ViewGroup.LayoutParams layoutParams) {
        l lVar = this.f746b;
        if (lVar == null) {
            Log.w("PlatformViewsController", "Embedded view called updateViewLayout while detached from presentation");
        } else {
            lVar.updateViewLayout(view, layoutParams);
        }
    }

    @Override // android.view.WindowManager
    public final void addCrossWindowBlurEnabledListener(Executor executor, Consumer consumer) {
        this.f745a.addCrossWindowBlurEnabledListener(executor, consumer);
    }
}
