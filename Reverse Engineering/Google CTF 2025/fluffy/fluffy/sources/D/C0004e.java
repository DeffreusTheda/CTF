package D;

import android.util.Log;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;

/* renamed from: D.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0004e implements OnBackAnimationCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbstractActivityC0005f f54a;

    public C0004e(AbstractActivityC0005f abstractActivityC0005f) {
        this.f54a = abstractActivityC0005f;
    }

    @Override // android.window.OnBackAnimationCallback
    public final void onBackCancelled() {
        AbstractActivityC0005f abstractActivityC0005f = this.f54a;
        if (abstractActivityC0005f.k("cancelBackGesture")) {
            C0008i c0008i = abstractActivityC0005f.f57b;
            c0008i.c();
            E.c cVar = c0008i.f65b;
            if (cVar != null) {
                cVar.f134j.f223a.f("cancelBackGesture", null, null);
            } else {
                Log.w("FlutterActivityAndFragmentDelegate", "Invoked cancelBackGesture() before FlutterFragment was attached to an Activity.");
            }
        }
    }

    @Override // android.window.OnBackInvokedCallback
    public final void onBackInvoked() {
        AbstractActivityC0005f abstractActivityC0005f = this.f54a;
        if (abstractActivityC0005f.k("commitBackGesture")) {
            C0008i c0008i = abstractActivityC0005f.f57b;
            c0008i.c();
            E.c cVar = c0008i.f65b;
            if (cVar != null) {
                cVar.f134j.f223a.f("commitBackGesture", null, null);
            } else {
                Log.w("FlutterActivityAndFragmentDelegate", "Invoked commitBackGesture() before FlutterFragment was attached to an Activity.");
            }
        }
    }

    @Override // android.window.OnBackAnimationCallback
    public final void onBackProgressed(BackEvent backEvent) {
        AbstractActivityC0005f abstractActivityC0005f = this.f54a;
        if (abstractActivityC0005f.k("updateBackGestureProgress")) {
            C0008i c0008i = abstractActivityC0005f.f57b;
            c0008i.c();
            E.c cVar = c0008i.f65b;
            if (cVar == null) {
                Log.w("FlutterActivityAndFragmentDelegate", "Invoked updateBackGestureProgress() before FlutterFragment was attached to an Activity.");
                return;
            }
            K.b bVar = cVar.f134j;
            bVar.getClass();
            bVar.f223a.f("updateBackGestureProgress", K.b.a(backEvent), null);
        }
    }

    @Override // android.window.OnBackAnimationCallback
    public final void onBackStarted(BackEvent backEvent) {
        AbstractActivityC0005f abstractActivityC0005f = this.f54a;
        if (abstractActivityC0005f.k("startBackGesture")) {
            C0008i c0008i = abstractActivityC0005f.f57b;
            c0008i.c();
            E.c cVar = c0008i.f65b;
            if (cVar == null) {
                Log.w("FlutterActivityAndFragmentDelegate", "Invoked startBackGesture() before FlutterFragment was attached to an Activity.");
                return;
            }
            K.b bVar = cVar.f134j;
            bVar.getClass();
            bVar.f223a.f("startBackGesture", K.b.a(backEvent), null);
        }
    }
}
