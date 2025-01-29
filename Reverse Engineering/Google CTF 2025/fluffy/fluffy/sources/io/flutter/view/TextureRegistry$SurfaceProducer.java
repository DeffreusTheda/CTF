package io.flutter.view;

import android.view.Surface;

/* loaded from: classes.dex */
public interface TextureRegistry$SurfaceProducer {
    int getHeight();

    Surface getSurface();

    int getWidth();

    boolean handlesCropAndRotation();

    /* synthetic */ long id();

    /* synthetic */ void release();

    void scheduleFrame();

    void setCallback(q qVar);

    void setSize(int i2, int i3);
}
