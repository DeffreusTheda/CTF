package io.flutter.plugin.platform;

import D.C0012m;
import android.view.MotionEvent;

/* loaded from: classes.dex */
public final class b extends C0012m {

    /* renamed from: g, reason: collision with root package name */
    public a f694g;

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        a aVar = this.f694g;
        if (aVar != null) {
            io.flutter.view.l lVar = aVar.f693a;
            if (lVar == null ? false : lVar.d(motionEvent, true)) {
                return true;
            }
        }
        return super.onHoverEvent(motionEvent);
    }
}
