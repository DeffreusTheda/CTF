package l;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.util.Objects;

/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public final r f972a;

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            int i2 = q.f969l;
        } else {
            int i3 = r.f970b;
        }
    }

    public s(WindowInsets windowInsets) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 30) {
            this.f972a = new q(this, windowInsets);
            return;
        }
        if (i2 >= 29) {
            this.f972a = new p(this, windowInsets);
        } else if (i2 >= 28) {
            this.f972a = new o(this, windowInsets);
        } else {
            this.f972a = new C0080n(this, windowInsets);
        }
    }

    public static s a(WindowInsets windowInsets, View view) {
        windowInsets.getClass();
        s sVar = new s(windowInsets);
        if (view != null && view.isAttachedToWindow()) {
            int i2 = AbstractC0072f.f948a;
            s a2 = Build.VERSION.SDK_INT >= 23 ? AbstractC0071e.a(view) : AbstractC0070d.j(view);
            r rVar = sVar.f972a;
            rVar.k(a2);
            rVar.d(view.getRootView());
        }
        return sVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        return Objects.equals(this.f972a, ((s) obj).f972a);
    }

    public final int hashCode() {
        r rVar = this.f972a;
        if (rVar == null) {
            return 0;
        }
        return rVar.hashCode();
    }

    public s() {
        this.f972a = new r(this);
    }
}
