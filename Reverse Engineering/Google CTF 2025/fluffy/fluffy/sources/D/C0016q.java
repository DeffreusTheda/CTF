package D;

import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import io.flutter.embedding.engine.FlutterJNI;

/* renamed from: D.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0016q extends TextureView implements io.flutter.embedding.engine.renderer.l {

    /* renamed from: a, reason: collision with root package name */
    public boolean f87a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f88b;

    /* renamed from: c, reason: collision with root package name */
    public io.flutter.embedding.engine.renderer.j f89c;

    /* renamed from: d, reason: collision with root package name */
    public Surface f90d;

    @Override // io.flutter.embedding.engine.renderer.l
    public final void a(io.flutter.embedding.engine.renderer.j jVar) {
        io.flutter.embedding.engine.renderer.j jVar2 = this.f89c;
        if (jVar2 != null) {
            jVar2.b();
        }
        this.f89c = jVar;
        b();
    }

    @Override // io.flutter.embedding.engine.renderer.l
    public final void b() {
        if (this.f89c == null) {
            Log.w("FlutterTextureView", "resume() invoked when no FlutterRenderer was attached.");
            return;
        }
        if (this.f87a) {
            e();
        }
        this.f88b = false;
    }

    @Override // io.flutter.embedding.engine.renderer.l
    public final void c() {
        if (this.f89c == null) {
            Log.w("FlutterTextureView", "pause() invoked when no FlutterRenderer was attached.");
        } else {
            this.f88b = true;
        }
    }

    @Override // io.flutter.embedding.engine.renderer.l
    public final void d() {
        if (this.f89c == null) {
            Log.w("FlutterTextureView", "detachFromRenderer() invoked when no FlutterRenderer was attached.");
            return;
        }
        if (getWindowToken() != null) {
            io.flutter.embedding.engine.renderer.j jVar = this.f89c;
            if (jVar == null) {
                throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
            }
            jVar.b();
            Surface surface = this.f90d;
            if (surface != null) {
                surface.release();
                this.f90d = null;
            }
        }
        this.f89c = null;
    }

    public final void e() {
        if (this.f89c == null || getSurfaceTexture() == null) {
            throw new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getSurfaceTexture() are non-null.");
        }
        Surface surface = this.f90d;
        if (surface != null) {
            surface.release();
            this.f90d = null;
        }
        Surface surface2 = new Surface(getSurfaceTexture());
        this.f90d = surface2;
        io.flutter.embedding.engine.renderer.j jVar = this.f89c;
        boolean z2 = this.f88b;
        if (!z2) {
            jVar.b();
        }
        jVar.f628b = surface2;
        FlutterJNI flutterJNI = jVar.f627a;
        if (z2) {
            flutterJNI.onSurfaceWindowChanged(surface2);
        } else {
            flutterJNI.onSurfaceCreated(surface2);
        }
    }

    @Override // io.flutter.embedding.engine.renderer.l
    public io.flutter.embedding.engine.renderer.j getAttachedRenderer() {
        return this.f89c;
    }

    public void setRenderSurface(Surface surface) {
        this.f90d = surface;
    }
}
