package io.flutter.plugin.platform;

import D.AbstractActivityC0005f;
import D.v;
import android.os.Build;
import android.view.Window;
import l.t;
import l.u;
import l.w;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractActivityC0005f f699a;

    /* renamed from: b, reason: collision with root package name */
    public final B.a f700b;

    /* renamed from: c, reason: collision with root package name */
    public final AbstractActivityC0005f f701c;

    /* renamed from: d, reason: collision with root package name */
    public K.f f702d;

    /* renamed from: e, reason: collision with root package name */
    public int f703e;

    public e(AbstractActivityC0005f abstractActivityC0005f, B.a aVar, AbstractActivityC0005f abstractActivityC0005f2) {
        v vVar = new v(28, this);
        this.f699a = abstractActivityC0005f;
        this.f700b = aVar;
        aVar.f5d = vVar;
        this.f701c = abstractActivityC0005f2;
        this.f703e = 1280;
    }

    public final void a(K.f fVar) {
        Window window = this.f699a.getWindow();
        window.getDecorView();
        int i2 = Build.VERSION.SDK_INT;
        a.a wVar = i2 >= 30 ? new w(window) : i2 >= 26 ? new l.v(window) : i2 >= 23 ? new u(window) : new t(window);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 30) {
            window.addFlags(Integer.MIN_VALUE);
            window.clearFlags(201326592);
        }
        if (i3 >= 23) {
            int i4 = fVar.f232b;
            if (i4 != 0) {
                int a2 = n.e.a(i4);
                if (a2 == 0) {
                    wVar.w(false);
                } else if (a2 == 1) {
                    wVar.w(true);
                }
            }
            Integer num = fVar.f231a;
            if (num != null) {
                window.setStatusBarColor(num.intValue());
            }
        }
        Boolean bool = fVar.f233c;
        if (bool != null && i3 >= 29) {
            window.setStatusBarContrastEnforced(bool.booleanValue());
        }
        if (i3 >= 26) {
            int i5 = fVar.f235e;
            if (i5 != 0) {
                int a3 = n.e.a(i5);
                if (a3 == 0) {
                    wVar.v(false);
                } else if (a3 == 1) {
                    wVar.v(true);
                }
            }
            Integer num2 = fVar.f234d;
            if (num2 != null) {
                window.setNavigationBarColor(num2.intValue());
            }
        }
        Integer num3 = fVar.f236f;
        if (num3 != null && i3 >= 28) {
            window.setNavigationBarDividerColor(num3.intValue());
        }
        Boolean bool2 = fVar.f237g;
        if (bool2 != null && i3 >= 29) {
            window.setNavigationBarContrastEnforced(bool2.booleanValue());
        }
        this.f702d = fVar;
    }

    public final void b() {
        this.f699a.getWindow().getDecorView().setSystemUiVisibility(this.f703e);
        K.f fVar = this.f702d;
        if (fVar != null) {
            a(fVar);
        }
    }
}
