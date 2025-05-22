package io.flutter.embedding.android;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;

/* loaded from: classes.dex */
public class i extends TextureView implements u.c {

    /* renamed from: a, reason: collision with root package name */
    private boolean f237a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f238b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f239c;

    /* renamed from: d, reason: collision with root package name */
    private u.a f240d;

    /* renamed from: e, reason: collision with root package name */
    private Surface f241e;

    /* renamed from: f, reason: collision with root package name */
    private final TextureView.SurfaceTextureListener f242f;

    class a implements TextureView.SurfaceTextureListener {
        a() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            j.b.f("FlutterTextureView", "SurfaceTextureListener.onSurfaceTextureAvailable()");
            i.this.f237a = true;
            if (i.this.f238b) {
                i.this.l();
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            j.b.f("FlutterTextureView", "SurfaceTextureListener.onSurfaceTextureDestroyed()");
            i.this.f237a = false;
            if (i.this.f238b) {
                i.this.m();
            }
            if (i.this.f241e == null) {
                return true;
            }
            i.this.f241e.release();
            i.this.f241e = null;
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
            j.b.f("FlutterTextureView", "SurfaceTextureListener.onSurfaceTextureSizeChanged()");
            if (i.this.f238b) {
                i.this.k(i2, i3);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    public i(Context context) {
        this(context, null);
    }

    public i(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f237a = false;
        this.f238b = false;
        this.f239c = false;
        this.f242f = new a();
        n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(int i2, int i3) {
        if (this.f240d == null) {
            throw new IllegalStateException("changeSurfaceSize() should only be called when flutterRenderer is non-null.");
        }
        j.b.f("FlutterTextureView", "Notifying FlutterRenderer that Android surface size has changed to " + i2 + " x " + i3);
        this.f240d.u(i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.f240d == null || getSurfaceTexture() == null) {
            throw new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getSurfaceTexture() are non-null.");
        }
        Surface surface = this.f241e;
        if (surface != null) {
            surface.release();
            this.f241e = null;
        }
        Surface surface2 = new Surface(getSurfaceTexture());
        this.f241e = surface2;
        this.f240d.s(surface2, this.f239c);
        this.f239c = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        u.a aVar = this.f240d;
        if (aVar == null) {
            throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
        }
        aVar.t();
        Surface surface = this.f241e;
        if (surface != null) {
            surface.release();
            this.f241e = null;
        }
    }

    private void n() {
        setSurfaceTextureListener(this.f242f);
    }

    @Override // u.c
    public void a(u.a aVar) {
        j.b.f("FlutterTextureView", "Attaching to FlutterRenderer.");
        if (this.f240d != null) {
            j.b.f("FlutterTextureView", "Already connected to a FlutterRenderer. Detaching from old one and attaching to new one.");
            this.f240d.t();
        }
        this.f240d = aVar;
        this.f238b = true;
        if (this.f237a) {
            j.b.f("FlutterTextureView", "Surface is available for rendering. Connecting FlutterRenderer to Android surface.");
            l();
        }
    }

    @Override // u.c
    public void b() {
        if (this.f240d == null) {
            j.b.g("FlutterTextureView", "pause() invoked when no FlutterRenderer was attached.");
            return;
        }
        this.f240d = null;
        this.f239c = true;
        this.f238b = false;
    }

    @Override // u.c
    public void c() {
        if (this.f240d == null) {
            j.b.g("FlutterTextureView", "detachFromRenderer() invoked when no FlutterRenderer was attached.");
            return;
        }
        if (getWindowToken() != null) {
            j.b.f("FlutterTextureView", "Disconnecting FlutterRenderer from Android surface.");
            m();
        }
        this.f240d = null;
        this.f238b = false;
    }

    @Override // u.c
    public u.a getAttachedRenderer() {
        return this.f240d;
    }

    public void setRenderSurface(Surface surface) {
        this.f241e = surface;
    }
}
