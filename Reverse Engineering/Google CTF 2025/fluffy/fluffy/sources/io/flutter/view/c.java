package io.flutter.view;

import D.v;
import D.y;
import android.view.accessibility.AccessibilityManager;
import io.flutter.embedding.engine.FlutterJNI;

/* loaded from: classes.dex */
public final class c implements AccessibilityManager.AccessibilityStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f748a;

    public c(l lVar) {
        this.f748a = lVar;
    }

    @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
    public final void onAccessibilityStateChanged(boolean z2) {
        l lVar = this.f748a;
        if (lVar.f848t) {
            return;
        }
        boolean z3 = false;
        B.e eVar = lVar.f831b;
        if (z2) {
            b bVar = lVar.u;
            eVar.f10c = bVar;
            ((FlutterJNI) eVar.f9b).setAccessibilityDelegate(bVar);
            ((FlutterJNI) eVar.f9b).setSemanticsEnabled(true);
        } else {
            lVar.h(false);
            eVar.f10c = null;
            ((FlutterJNI) eVar.f9b).setAccessibilityDelegate(null);
            ((FlutterJNI) eVar.f9b).setSemanticsEnabled(false);
        }
        v vVar = lVar.f846r;
        if (vVar != null) {
            boolean isTouchExplorationEnabled = lVar.f832c.isTouchExplorationEnabled();
            y yVar = (y) vVar.f94c;
            if (yVar.f107h.f126b.f627a.getIsSoftwareRenderingEnabled()) {
                yVar.setWillNotDraw(false);
                return;
            }
            if (!z2 && !isTouchExplorationEnabled) {
                z3 = true;
            }
            yVar.setWillNotDraw(z3);
        }
    }
}
