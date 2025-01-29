package l;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;

/* renamed from: l.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ViewOnApplyWindowInsetsListenerC0069c implements View.OnApplyWindowInsetsListener {

    /* renamed from: a, reason: collision with root package name */
    public s f946a = null;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f947b;

    public ViewOnApplyWindowInsetsListenerC0069c(View view, InterfaceC0068b interfaceC0068b) {
        this.f947b = view;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        s a2 = s.a(windowInsets, view);
        if (Build.VERSION.SDK_INT < 30) {
            AbstractC0070d.a(windowInsets, this.f947b);
            if (a2.equals(this.f946a)) {
                throw null;
            }
        }
        this.f946a = a2;
        throw null;
    }
}
