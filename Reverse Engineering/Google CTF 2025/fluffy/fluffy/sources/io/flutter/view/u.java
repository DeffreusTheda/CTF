package io.flutter.view;

import android.hardware.display.DisplayManager;
import io.flutter.embedding.engine.FlutterJNI;
import java.util.Objects;

/* loaded from: classes.dex */
public final class u {

    /* renamed from: e, reason: collision with root package name */
    public static u f864e;

    /* renamed from: f, reason: collision with root package name */
    public static s f865f;

    /* renamed from: b, reason: collision with root package name */
    public final FlutterJNI f867b;

    /* renamed from: a, reason: collision with root package name */
    public long f866a = -1;

    /* renamed from: c, reason: collision with root package name */
    public t f868c = new t(this, 0);

    /* renamed from: d, reason: collision with root package name */
    public final b f869d = new b(this);

    public u(FlutterJNI flutterJNI) {
        this.f867b = flutterJNI;
    }

    public static u a(DisplayManager displayManager, FlutterJNI flutterJNI) {
        if (f864e == null) {
            f864e = new u(flutterJNI);
        }
        if (f865f == null) {
            u uVar = f864e;
            Objects.requireNonNull(uVar);
            s sVar = new s(uVar, displayManager);
            f865f = sVar;
            displayManager.registerDisplayListener(sVar, null);
        }
        if (f864e.f866a == -1) {
            float refreshRate = displayManager.getDisplay(0).getRefreshRate();
            f864e.f866a = (long) (1.0E9d / refreshRate);
            flutterJNI.setRefreshRateFPS(refreshRate);
        }
        return f864e;
    }
}
