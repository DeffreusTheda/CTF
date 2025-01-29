package D;

import android.graphics.Region;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceView;
import io.flutter.embedding.engine.FlutterJNI;

/* renamed from: D.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0014o extends SurfaceView implements io.flutter.embedding.engine.renderer.l {

    /* renamed from: a, reason: collision with root package name */
    public boolean f82a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f83b;

    /* renamed from: c, reason: collision with root package name */
    public io.flutter.embedding.engine.renderer.j f84c;

    /* renamed from: d, reason: collision with root package name */
    public final C0006g f85d;

    public C0014o(AbstractActivityC0005f abstractActivityC0005f, boolean z2) {
        super(abstractActivityC0005f, null);
        this.f82a = false;
        this.f83b = false;
        SurfaceHolderCallbackC0013n surfaceHolderCallbackC0013n = new SurfaceHolderCallbackC0013n(this);
        this.f85d = new C0006g(1, this);
        if (z2) {
            getHolder().setFormat(-2);
            setZOrderOnTop(true);
        }
        getHolder().addCallback(surfaceHolderCallbackC0013n);
        setAlpha(0.0f);
    }

    @Override // io.flutter.embedding.engine.renderer.l
    public final void a(io.flutter.embedding.engine.renderer.j jVar) {
        io.flutter.embedding.engine.renderer.j jVar2 = this.f84c;
        if (jVar2 != null) {
            jVar2.b();
            this.f84c.f627a.removeIsDisplayingFlutterUiListener(this.f85d);
        }
        this.f84c = jVar;
        b();
    }

    @Override // io.flutter.embedding.engine.renderer.l
    public final void b() {
        io.flutter.embedding.engine.renderer.j jVar = this.f84c;
        if (jVar == null) {
            Log.w("FlutterSurfaceView", "resume() invoked when no FlutterRenderer was attached.");
            return;
        }
        FlutterJNI flutterJNI = jVar.f627a;
        C0006g c0006g = this.f85d;
        flutterJNI.addIsDisplayingFlutterUiListener(c0006g);
        if (jVar.f629c) {
            c0006g.a();
        }
        if (this.f82a) {
            e();
        }
        this.f83b = false;
    }

    @Override // io.flutter.embedding.engine.renderer.l
    public final void c() {
        if (this.f84c == null) {
            Log.w("FlutterSurfaceView", "pause() invoked when no FlutterRenderer was attached.");
        } else {
            this.f83b = true;
        }
    }

    @Override // io.flutter.embedding.engine.renderer.l
    public final void d() {
        if (this.f84c == null) {
            Log.w("FlutterSurfaceView", "detachFromRenderer() invoked when no FlutterRenderer was attached.");
            return;
        }
        if (getWindowToken() != null) {
            io.flutter.embedding.engine.renderer.j jVar = this.f84c;
            if (jVar == null) {
                throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
            }
            jVar.b();
        }
        setAlpha(0.0f);
        this.f84c.f627a.removeIsDisplayingFlutterUiListener(this.f85d);
        this.f84c = null;
    }

    public final void e() {
        if (this.f84c == null || getHolder() == null) {
            throw new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getHolder() are non-null.");
        }
        io.flutter.embedding.engine.renderer.j jVar = this.f84c;
        Surface surface = getHolder().getSurface();
        boolean z2 = this.f83b;
        if (!z2) {
            jVar.b();
        }
        jVar.f628b = surface;
        FlutterJNI flutterJNI = jVar.f627a;
        if (z2) {
            flutterJNI.onSurfaceWindowChanged(surface);
        } else {
            flutterJNI.onSurfaceCreated(surface);
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    public final boolean gatherTransparentRegion(Region region) {
        if (getAlpha() < 1.0f) {
            return false;
        }
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        int i2 = iArr[0];
        region.op(i2, iArr[1], (getRight() + i2) - getLeft(), (getBottom() + iArr[1]) - getTop(), Region.Op.DIFFERENCE);
        return true;
    }

    @Override // io.flutter.embedding.engine.renderer.l
    public io.flutter.embedding.engine.renderer.j getAttachedRenderer() {
        return this.f84c;
    }
}
