package v;

import android.app.Activity;
import android.content.Context;
import androidx.window.extensions.WindowExtensionsProvider;
import androidx.window.extensions.layout.WindowLayoutComponent;
import r.C0089a;
import r.C0090b;
import s.AbstractC0095e;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final ClassLoader f1190a;

    /* renamed from: b, reason: collision with root package name */
    public final C0090b f1191b;

    /* renamed from: c, reason: collision with root package name */
    public final C0090b f1192c;

    public e(ClassLoader classLoader, C0090b c0090b) {
        this.f1190a = classLoader;
        this.f1191b = c0090b;
        this.f1192c = new C0090b(classLoader);
    }

    public final WindowLayoutComponent a() {
        C0090b c0090b = this.f1192c;
        c0090b.getClass();
        boolean z2 = false;
        try {
            a0.h.d(c0090b.f1148a.loadClass("androidx.window.extensions.WindowExtensionsProvider"), "loader.loadClass(WindowE…XTENSIONS_PROVIDER_CLASS)");
            if (a.a.z("WindowExtensionsProvider#getWindowExtensions is not valid", new C0089a(0, c0090b)) && a.a.z("WindowExtensions#getWindowLayoutComponent is not valid", new d(this, 3)) && a.a.z("FoldingFeature class is not valid", new d(this, 0))) {
                int a2 = AbstractC0095e.a();
                if (a2 == 1) {
                    z2 = b();
                } else if (2 <= a2 && a2 <= Integer.MAX_VALUE && b()) {
                    if (a.a.z("WindowLayoutComponent#addWindowLayoutInfoListener(" + Context.class.getName() + ", androidx.window.extensions.core.util.function.Consumer) is not valid", new d(this, 2))) {
                        z2 = true;
                    }
                }
            }
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
        }
        if (!z2) {
            return null;
        }
        try {
            return WindowExtensionsProvider.getWindowExtensions().getWindowLayoutComponent();
        } catch (UnsupportedOperationException unused2) {
            return null;
        }
    }

    public final boolean b() {
        return a.a.z("WindowLayoutComponent#addWindowLayoutInfoListener(" + Activity.class.getName() + ", java.util.function.Consumer) is not valid", new d(this, 1));
    }
}
