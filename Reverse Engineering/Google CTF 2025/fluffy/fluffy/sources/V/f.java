package v;

import androidx.window.extensions.layout.WindowLayoutComponent;
import r.C0090b;
import s.AbstractC0095e;
import x.C0104a;

/* loaded from: classes.dex */
public final class f extends a0.i implements Z.a {

    /* renamed from: c, reason: collision with root package name */
    public static final f f1193c = new f(0);

    @Override // Z.a
    public final Object a() {
        WindowLayoutComponent a2;
        try {
            ClassLoader classLoader = h.class.getClassLoader();
            e eVar = classLoader != null ? new e(classLoader, new C0090b(classLoader)) : null;
            if (eVar == null || (a2 = eVar.a()) == null) {
                return null;
            }
            a0.h.d(classLoader, "loader");
            C0090b c0090b = new C0090b(classLoader);
            int a3 = AbstractC0095e.a();
            return a3 >= 2 ? new x.d(a2) : a3 == 1 ? new x.c(a2, c0090b) : new C0104a();
        } catch (Throwable unused) {
            g gVar = g.f1194a;
            return null;
        }
    }
}
