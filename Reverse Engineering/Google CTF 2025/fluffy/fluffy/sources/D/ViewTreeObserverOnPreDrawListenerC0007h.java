package D;

import android.view.ViewTreeObserver;

/* renamed from: D.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ViewTreeObserverOnPreDrawListenerC0007h implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y f62a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0008i f63b;

    public ViewTreeObserverOnPreDrawListenerC0007h(C0008i c0008i, y yVar) {
        this.f63b = c0008i;
        this.f62a = yVar;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        C0008i c0008i = this.f63b;
        if (c0008i.f70g && c0008i.f68e != null) {
            this.f62a.getViewTreeObserver().removeOnPreDrawListener(this);
            c0008i.f68e = null;
        }
        return c0008i.f70g;
    }
}
