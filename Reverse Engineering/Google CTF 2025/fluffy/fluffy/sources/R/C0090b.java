package r;

import a0.e;
import a0.h;
import android.app.Activity;
import java.lang.reflect.Proxy;
import s.C0093c;
import s.C0094d;

/* renamed from: r.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0090b {

    /* renamed from: a, reason: collision with root package name */
    public final ClassLoader f1148a;

    public C0094d a(Object obj, e eVar, Activity activity, x.b bVar) {
        Object newProxyInstance = Proxy.newProxyInstance(this.f1148a, new Class[]{b()}, new C0093c(eVar, bVar));
        h.d(newProxyInstance, "newProxyInstance(loader,…onsumerClass()), handler)");
        obj.getClass().getMethod("addWindowLayoutInfoListener", Activity.class, b()).invoke(obj, activity, newProxyInstance);
        return new C0094d(obj.getClass().getMethod("removeWindowLayoutInfoListener", b()), obj, newProxyInstance);
    }

    public Class b() {
        Class<?> loadClass = this.f1148a.loadClass("java.util.function.Consumer");
        h.d(loadClass, "loader.loadClass(\"java.util.function.Consumer\")");
        return loadClass;
    }
}
