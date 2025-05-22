package io.flutter.plugin.platform;

import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

/* loaded from: classes.dex */
class a {

    /* renamed from: a, reason: collision with root package name */
    private io.flutter.view.c f480a;

    a() {
    }

    public boolean a(MotionEvent motionEvent, boolean z2) {
        io.flutter.view.c cVar = this.f480a;
        if (cVar == null) {
            return false;
        }
        return cVar.K(motionEvent, z2);
    }

    public boolean b(View view, View view2, AccessibilityEvent accessibilityEvent) {
        io.flutter.view.c cVar = this.f480a;
        if (cVar == null) {
            return false;
        }
        return cVar.x(view, view2, accessibilityEvent);
    }

    void c(io.flutter.view.c cVar) {
        this.f480a = cVar;
    }
}
