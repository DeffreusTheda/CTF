package androidx.window.layout;

import android.app.Activity;
import kotlin.jvm.internal.i;

/* loaded from: classes.dex */
public final class WindowInfoTrackerImpl implements WindowInfoTracker {
    private static final int BUFFER_CAPACITY = 10;
    public static final Companion Companion = new Companion(null);
    private final WindowBackend windowBackend;
    private final WindowMetricsCalculator windowMetricsCalculator;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.e eVar) {
            this();
        }
    }

    public WindowInfoTrackerImpl(WindowMetricsCalculator windowMetricsCalculator, WindowBackend windowBackend) {
        i.e(windowMetricsCalculator, "windowMetricsCalculator");
        i.e(windowBackend, "windowBackend");
        this.windowMetricsCalculator = windowMetricsCalculator;
        this.windowBackend = windowBackend;
    }

    @Override // androidx.window.layout.WindowInfoTracker
    public t0.b<WindowLayoutInfo> windowLayoutInfo(Activity activity) {
        i.e(activity, "activity");
        return t0.d.a(new WindowInfoTrackerImpl$windowLayoutInfo$1(this, activity, null));
    }
}
