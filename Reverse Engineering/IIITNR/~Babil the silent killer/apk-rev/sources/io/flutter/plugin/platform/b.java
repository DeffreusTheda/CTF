package io.flutter.plugin.platform;

import android.content.Context;
import android.view.MotionEvent;
import io.flutter.embedding.android.g;

/* loaded from: classes.dex */
public class b extends io.flutter.embedding.android.g {

    /* renamed from: g, reason: collision with root package name */
    private a f481g;

    public b(Context context, int i2, int i3, a aVar) {
        super(context, i2, i3, g.b.overlay);
        this.f481g = aVar;
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        a aVar = this.f481g;
        if (aVar == null || !aVar.a(motionEvent, true)) {
            return super.onHoverEvent(motionEvent);
        }
        return true;
    }
}
