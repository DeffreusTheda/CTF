package D;

import android.view.SurfaceHolder;

/* renamed from: D.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class SurfaceHolderCallbackC0013n implements SurfaceHolder.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0014o f81a;

    public SurfaceHolderCallbackC0013n(C0014o c0014o) {
        this.f81a = c0014o;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        C0014o c0014o = this.f81a;
        io.flutter.embedding.engine.renderer.j jVar = c0014o.f84c;
        if (jVar == null || c0014o.f83b) {
            return;
        }
        if (jVar == null) {
            throw new IllegalStateException("changeSurfaceSize() should only be called when flutterRenderer is non-null.");
        }
        jVar.f627a.onSurfaceChanged(i3, i4);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        C0014o c0014o = this.f81a;
        c0014o.f82a = true;
        if ((c0014o.f84c == null || c0014o.f83b) ? false : true) {
            c0014o.e();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        C0014o c0014o = this.f81a;
        boolean z2 = false;
        c0014o.f82a = false;
        io.flutter.embedding.engine.renderer.j jVar = c0014o.f84c;
        if (jVar != null && !c0014o.f83b) {
            z2 = true;
        }
        if (z2) {
            if (jVar == null) {
                throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
            }
            jVar.b();
        }
    }
}
