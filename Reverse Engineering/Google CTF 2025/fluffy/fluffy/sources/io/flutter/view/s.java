package io.flutter.view;

import android.hardware.display.DisplayManager;

/* loaded from: classes.dex */
public final class s implements DisplayManager.DisplayListener {

    /* renamed from: a, reason: collision with root package name */
    public final DisplayManager f860a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ u f861b;

    public s(u uVar, DisplayManager displayManager) {
        this.f861b = uVar;
        this.f860a = displayManager;
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayAdded(int i2) {
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayChanged(int i2) {
        if (i2 == 0) {
            float refreshRate = this.f860a.getDisplay(0).getRefreshRate();
            u uVar = this.f861b;
            uVar.f866a = (long) (1.0E9d / refreshRate);
            uVar.f867b.setRefreshRateFPS(refreshRate);
        }
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public final void onDisplayRemoved(int i2) {
    }
}
