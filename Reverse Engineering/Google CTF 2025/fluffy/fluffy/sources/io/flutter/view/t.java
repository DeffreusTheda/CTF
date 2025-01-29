package io.flutter.view;

import android.view.Choreographer;

/* loaded from: classes.dex */
public final class t implements Choreographer.FrameCallback {

    /* renamed from: a, reason: collision with root package name */
    public long f862a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ u f863b;

    public t(u uVar, long j2) {
        this.f863b = uVar;
        this.f862a = j2;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j2) {
        long nanoTime = System.nanoTime() - j2;
        long j3 = nanoTime < 0 ? 0L : nanoTime;
        u uVar = this.f863b;
        uVar.f867b.onVsync(j3, uVar.f866a, this.f862a);
        uVar.f868c = this;
    }
}
