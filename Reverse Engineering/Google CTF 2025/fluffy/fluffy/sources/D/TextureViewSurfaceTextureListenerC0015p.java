package D;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;

/* renamed from: D.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class TextureViewSurfaceTextureListenerC0015p implements TextureView.SurfaceTextureListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0016q f86a;

    public TextureViewSurfaceTextureListenerC0015p(C0016q c0016q) {
        this.f86a = c0016q;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        C0016q c0016q = this.f86a;
        c0016q.f87a = true;
        if ((c0016q.f89c == null || c0016q.f88b) ? false : true) {
            c0016q.e();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        C0016q c0016q = this.f86a;
        boolean z2 = false;
        c0016q.f87a = false;
        io.flutter.embedding.engine.renderer.j jVar = c0016q.f89c;
        if (jVar != null && !c0016q.f88b) {
            z2 = true;
        }
        if (z2) {
            if (jVar == null) {
                throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
            }
            jVar.b();
            Surface surface = c0016q.f90d;
            if (surface != null) {
                surface.release();
                c0016q.f90d = null;
            }
        }
        Surface surface2 = c0016q.f90d;
        if (surface2 != null) {
            surface2.release();
            c0016q.f90d = null;
        }
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        C0016q c0016q = this.f86a;
        io.flutter.embedding.engine.renderer.j jVar = c0016q.f89c;
        if (jVar == null || c0016q.f88b) {
            return;
        }
        if (jVar == null) {
            throw new IllegalStateException("changeSurfaceSize() should only be called when flutterRenderer is non-null.");
        }
        jVar.f627a.onSurfaceChanged(i2, i3);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
