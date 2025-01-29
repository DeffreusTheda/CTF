package io.flutter.plugin.editing;

import android.view.View;
import android.view.WindowInsets;

/* loaded from: classes.dex */
public final class a implements View.OnApplyWindowInsetsListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImeSyncDeferringInsetsCallback f634a;

    public a(ImeSyncDeferringInsetsCallback imeSyncDeferringInsetsCallback) {
        this.f634a = imeSyncDeferringInsetsCallback;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        WindowInsets windowInsets2;
        ImeSyncDeferringInsetsCallback imeSyncDeferringInsetsCallback = this.f634a;
        imeSyncDeferringInsetsCallback.view = view;
        if (imeSyncDeferringInsetsCallback.needsSave) {
            imeSyncDeferringInsetsCallback.lastWindowInsets = windowInsets;
            imeSyncDeferringInsetsCallback.needsSave = false;
        }
        if (!imeSyncDeferringInsetsCallback.animating) {
            return view.onApplyWindowInsets(windowInsets);
        }
        windowInsets2 = WindowInsets.CONSUMED;
        return windowInsets2;
    }
}
