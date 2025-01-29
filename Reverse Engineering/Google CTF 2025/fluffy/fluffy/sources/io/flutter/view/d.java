package io.flutter.view;

import D.v;
import D.y;
import android.view.accessibility.AccessibilityManager;

/* loaded from: classes.dex */
public final class d implements AccessibilityManager.TouchExplorationStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AccessibilityManager f749a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f750b;

    public d(l lVar, AccessibilityManager accessibilityManager) {
        this.f750b = lVar;
        this.f749a = accessibilityManager;
    }

    @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
    public final void onTouchExplorationStateChanged(boolean z2) {
        l lVar = this.f750b;
        if (lVar.f848t) {
            return;
        }
        boolean z3 = false;
        if (!z2) {
            lVar.h(false);
            h hVar = lVar.f842n;
            if (hVar != null) {
                lVar.f(hVar.f802b, 256);
                lVar.f842n = null;
            }
        }
        v vVar = lVar.f846r;
        if (vVar != null) {
            boolean isEnabled = this.f749a.isEnabled();
            y yVar = (y) vVar.f94c;
            if (yVar.f107h.f126b.f627a.getIsSoftwareRenderingEnabled()) {
                yVar.setWillNotDraw(false);
                return;
            }
            if (!isEnabled && !z2) {
                z3 = true;
            }
            yVar.setWillNotDraw(z3);
        }
    }
}
