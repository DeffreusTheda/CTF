package io.flutter.view;

import android.graphics.SurfaceTexture;

/* loaded from: classes.dex */
public interface d {

    public interface a {
        void a();
    }

    public interface b {
        void onTrimMemory(int i2);
    }

    public interface c {
        void a(b bVar);

        long b();

        void c(a aVar);

        SurfaceTexture d();
    }

    c a();
}
