package io.flutter.embedding.engine.renderer;

import io.flutter.embedding.engine.FlutterJNI;

/* loaded from: classes.dex */
public final class h implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final long f608b;

    /* renamed from: c, reason: collision with root package name */
    public final FlutterJNI f609c;

    public h(long j2, FlutterJNI flutterJNI) {
        this.f608b = j2;
        this.f609c = flutterJNI;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FlutterJNI flutterJNI = this.f609c;
        if (flutterJNI.isAttached()) {
            flutterJNI.unregisterTexture(this.f608b);
        }
    }
}
