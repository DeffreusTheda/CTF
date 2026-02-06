package io.flutter.view;

import android.annotation.TargetApi;
import android.hardware.display.DisplayManager;
import android.view.Choreographer;
import io.flutter.embedding.engine.FlutterJNI;

/* loaded from: classes.dex */
public class e {

    /* renamed from: e, reason: collision with root package name */
    private static e f708e;

    /* renamed from: f, reason: collision with root package name */
    private static b f709f;

    /* renamed from: b, reason: collision with root package name */
    private FlutterJNI f711b;

    /* renamed from: a, reason: collision with root package name */
    private long f710a = -1;

    /* renamed from: c, reason: collision with root package name */
    private c f712c = new c(0);

    /* renamed from: d, reason: collision with root package name */
    private final FlutterJNI.b f713d = new a();

    class a implements FlutterJNI.b {
        a() {
        }

        private Choreographer.FrameCallback b(long j2) {
            if (e.this.f712c == null) {
                return e.this.new c(j2);
            }
            e.this.f712c.f717a = j2;
            c cVar = e.this.f712c;
            e.this.f712c = null;
            return cVar;
        }

        @Override // io.flutter.embedding.engine.FlutterJNI.b
        public void a(long j2) {
            Choreographer.getInstance().postFrameCallback(b(j2));
        }
    }

    @TargetApi(17)
    class b implements DisplayManager.DisplayListener {

        /* renamed from: a, reason: collision with root package name */
        private DisplayManager f715a;

        b(DisplayManager displayManager) {
            this.f715a = displayManager;
        }

        void a() {
            this.f715a.registerDisplayListener(this, null);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i2) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i2) {
            if (i2 == 0) {
                float refreshRate = this.f715a.getDisplay(0).getRefreshRate();
                e eVar = e.this;
                double d2 = refreshRate;
                Double.isNaN(d2);
                eVar.f710a = (long) (1.0E9d / d2);
                e.this.f711b.setRefreshRateFPS(refreshRate);
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i2) {
        }
    }

    private class c implements Choreographer.FrameCallback {

        /* renamed from: a, reason: collision with root package name */
        private long f717a;

        c(long j2) {
            this.f717a = j2;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j2) {
            long nanoTime = System.nanoTime() - j2;
            e.this.f711b.onVsync(nanoTime < 0 ? 0L : nanoTime, e.this.f710a, this.f717a);
            e.this.f712c = this;
        }
    }

    private e(FlutterJNI flutterJNI) {
        this.f711b = flutterJNI;
    }

    public static e f(float f2, FlutterJNI flutterJNI) {
        if (f708e == null) {
            f708e = new e(flutterJNI);
        }
        flutterJNI.setRefreshRateFPS(f2);
        e eVar = f708e;
        double d2 = f2;
        Double.isNaN(d2);
        eVar.f710a = (long) (1.0E9d / d2);
        return eVar;
    }

    @TargetApi(17)
    public static e g(DisplayManager displayManager, FlutterJNI flutterJNI) {
        if (f708e == null) {
            f708e = new e(flutterJNI);
        }
        if (f709f == null) {
            e eVar = f708e;
            eVar.getClass();
            b bVar = eVar.new b(displayManager);
            f709f = bVar;
            bVar.a();
        }
        if (f708e.f710a == -1) {
            float refreshRate = displayManager.getDisplay(0).getRefreshRate();
            e eVar2 = f708e;
            double d2 = refreshRate;
            Double.isNaN(d2);
            eVar2.f710a = (long) (1.0E9d / d2);
            flutterJNI.setRefreshRateFPS(refreshRate);
        }
        return f708e;
    }

    public void h() {
        this.f711b.setAsyncWaitForVsyncDelegate(this.f713d);
    }
}
