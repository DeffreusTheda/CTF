package io.flutter.embedding.android;

import android.app.Activity;
import androidx.window.java.layout.WindowInfoTrackerCallbackAdapter;
import androidx.window.layout.WindowLayoutInfo;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class z {

    /* renamed from: a, reason: collision with root package name */
    final WindowInfoTrackerCallbackAdapter f340a;

    public z(WindowInfoTrackerCallbackAdapter windowInfoTrackerCallbackAdapter) {
        this.f340a = windowInfoTrackerCallbackAdapter;
    }

    public void a(Activity activity, Executor executor, e.a<WindowLayoutInfo> aVar) {
        this.f340a.addWindowLayoutInfoListener(activity, executor, aVar);
    }

    public void b(e.a<WindowLayoutInfo> aVar) {
        this.f340a.removeWindowLayoutInfoListener(aVar);
    }
}
