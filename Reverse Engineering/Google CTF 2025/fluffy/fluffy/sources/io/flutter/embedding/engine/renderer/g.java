package io.flutter.embedding.engine.renderer;

import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.util.ArrayDeque;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final ImageReader f604a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayDeque f605b = new ArrayDeque();

    /* renamed from: c, reason: collision with root package name */
    public boolean f606c = false;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ FlutterRenderer$ImageReaderSurfaceProducer f607d;

    public g(FlutterRenderer$ImageReaderSurfaceProducer flutterRenderer$ImageReaderSurfaceProducer, ImageReader imageReader) {
        this.f607d = flutterRenderer$ImageReaderSurfaceProducer;
        this.f604a = imageReader;
        imageReader.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() { // from class: io.flutter.embedding.engine.renderer.f
            @Override // android.media.ImageReader.OnImageAvailableListener
            public final void onImageAvailable(ImageReader imageReader2) {
                Image image;
                boolean z2;
                g gVar = g.this;
                gVar.getClass();
                try {
                    image = imageReader2.acquireLatestImage();
                } catch (IllegalStateException e2) {
                    Log.e("ImageReaderSurfaceProducer", "onImageAvailable acquireLatestImage failed: " + e2);
                    image = null;
                }
                if (image == null) {
                    return;
                }
                FlutterRenderer$ImageReaderSurfaceProducer flutterRenderer$ImageReaderSurfaceProducer2 = gVar.f607d;
                z2 = flutterRenderer$ImageReaderSurfaceProducer2.released;
                if (z2 || gVar.f606c) {
                    image.close();
                } else {
                    flutterRenderer$ImageReaderSurfaceProducer2.onImage(imageReader2, image);
                }
            }
        }, new Handler(Looper.getMainLooper()));
    }
}
