package io.flutter.embedding.android;

import android.content.Context;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/* loaded from: classes.dex */
public class h extends SurfaceView implements u.c {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f228a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f229b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f230c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f231d;

    /* renamed from: e, reason: collision with root package name */
    private u.a f232e;

    /* renamed from: f, reason: collision with root package name */
    private final SurfaceHolder.Callback f233f;

    /* renamed from: g, reason: collision with root package name */
    private final u.b f234g;

    class a implements SurfaceHolder.Callback {
        a() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
            j.b.f("FlutterSurfaceView", "SurfaceHolder.Callback.surfaceChanged()");
            if (h.this.f231d) {
                h.this.j(i3, i4);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            j.b.f("FlutterSurfaceView", "SurfaceHolder.Callback.startRenderingToSurface()");
            h.this.f229b = true;
            if (h.this.f231d) {
                h.this.k();
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            j.b.f("FlutterSurfaceView", "SurfaceHolder.Callback.stopRenderingToSurface()");
            h.this.f229b = false;
            if (h.this.f231d) {
                h.this.l();
            }
        }
    }

    class b implements u.b {
        b() {
        }

        @Override // u.b
        public void c() {
            j.b.f("FlutterSurfaceView", "onFlutterUiDisplayed()");
            h.this.setAlpha(1.0f);
            if (h.this.f232e != null) {
                h.this.f232e.p(this);
            }
        }

        @Override // u.b
        public void e() {
        }
    }

    private h(Context context, AttributeSet attributeSet, boolean z2) {
        super(context, attributeSet);
        this.f229b = false;
        this.f230c = false;
        this.f231d = false;
        this.f233f = new a();
        this.f234g = new b();
        this.f228a = z2;
        m();
    }

    public h(Context context, boolean z2) {
        this(context, null, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i2, int i3) {
        if (this.f232e == null) {
            throw new IllegalStateException("changeSurfaceSize() should only be called when flutterRenderer is non-null.");
        }
        j.b.f("FlutterSurfaceView", "Notifying FlutterRenderer that Android surface size has changed to " + i2 + " x " + i3);
        this.f232e.u(i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.f232e == null || getHolder() == null) {
            throw new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getHolder() are non-null.");
        }
        this.f232e.s(getHolder().getSurface(), this.f230c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        u.a aVar = this.f232e;
        if (aVar == null) {
            throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
        }
        aVar.t();
    }

    private void m() {
        if (this.f228a) {
            getHolder().setFormat(-2);
            setZOrderOnTop(true);
        }
        getHolder().addCallback(this.f233f);
        setAlpha(0.0f);
    }

    @Override // u.c
    public void a(u.a aVar) {
        j.b.f("FlutterSurfaceView", "Attaching to FlutterRenderer.");
        if (this.f232e != null) {
            j.b.f("FlutterSurfaceView", "Already connected to a FlutterRenderer. Detaching from old one and attaching to new one.");
            this.f232e.t();
            this.f232e.p(this.f234g);
        }
        this.f232e = aVar;
        this.f231d = true;
        aVar.f(this.f234g);
        if (this.f229b) {
            j.b.f("FlutterSurfaceView", "Surface is available for rendering. Connecting FlutterRenderer to Android surface.");
            k();
        }
        this.f230c = false;
    }

    @Override // u.c
    public void b() {
        if (this.f232e == null) {
            j.b.g("FlutterSurfaceView", "pause() invoked when no FlutterRenderer was attached.");
            return;
        }
        this.f232e = null;
        this.f230c = true;
        this.f231d = false;
    }

    @Override // u.c
    public void c() {
        if (this.f232e == null) {
            j.b.g("FlutterSurfaceView", "detachFromRenderer() invoked when no FlutterRenderer was attached.");
            return;
        }
        if (getWindowToken() != null) {
            j.b.f("FlutterSurfaceView", "Disconnecting FlutterRenderer from Android surface.");
            l();
        }
        setAlpha(0.0f);
        this.f232e.p(this.f234g);
        this.f232e = null;
        this.f231d = false;
    }

    @Override // android.view.SurfaceView, android.view.View
    public boolean gatherTransparentRegion(Region region) {
        if (getAlpha() < 1.0f) {
            return false;
        }
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        region.op(iArr[0], iArr[1], (iArr[0] + getRight()) - getLeft(), (iArr[1] + getBottom()) - getTop(), Region.Op.DIFFERENCE);
        return true;
    }

    @Override // u.c
    public u.a getAttachedRenderer() {
        return this.f232e;
    }
}
