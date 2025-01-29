package v;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import androidx.window.extensions.core.util.function.Consumer;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* loaded from: classes.dex */
public final class d extends a0.i implements Z.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1188c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ e f1189d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(e eVar, int i2) {
        super(0);
        this.f1188c = i2;
        this.f1189d = eVar;
    }

    @Override // Z.a
    public final Object a() {
        Class<?> cls = null;
        e eVar = this.f1189d;
        boolean z2 = false;
        switch (this.f1188c) {
            case 0:
                Class<?> loadClass = eVar.f1190a.loadClass("androidx.window.extensions.layout.FoldingFeature");
                a0.h.d(loadClass, "loader.loadClass(FOLDING_FEATURE_CLASS)");
                Method method = loadClass.getMethod("getBounds", null);
                Method method2 = loadClass.getMethod("getType", null);
                Method method3 = loadClass.getMethod("getState", null);
                a0.h.d(method, "getBoundsMethod");
                if (a.a.g(method, a0.l.a(Rect.class)) && Modifier.isPublic(method.getModifiers())) {
                    a0.h.d(method2, "getTypeMethod");
                    Class cls2 = Integer.TYPE;
                    if (a.a.g(method2, a0.l.a(cls2)) && Modifier.isPublic(method2.getModifiers())) {
                        a0.h.d(method3, "getStateMethod");
                        if (a.a.g(method3, a0.l.a(cls2)) && Modifier.isPublic(method3.getModifiers())) {
                            z2 = true;
                        }
                    }
                }
                return Boolean.valueOf(z2);
            case 1:
                try {
                    cls = eVar.f1191b.b();
                } catch (ClassNotFoundException unused) {
                }
                if (cls == null) {
                    return Boolean.FALSE;
                }
                Class<?> loadClass2 = eVar.f1190a.loadClass("androidx.window.extensions.layout.WindowLayoutComponent");
                a0.h.d(loadClass2, "loader.loadClass(WINDOW_LAYOUT_COMPONENT_CLASS)");
                Method method4 = loadClass2.getMethod("addWindowLayoutInfoListener", Activity.class, cls);
                Method method5 = loadClass2.getMethod("removeWindowLayoutInfoListener", cls);
                a0.h.d(method4, "addListenerMethod");
                if (Modifier.isPublic(method4.getModifiers())) {
                    a0.h.d(method5, "removeListenerMethod");
                    if (Modifier.isPublic(method5.getModifiers())) {
                        z2 = true;
                    }
                }
                return Boolean.valueOf(z2);
            case 2:
                Class<?> loadClass3 = eVar.f1190a.loadClass("androidx.window.extensions.layout.WindowLayoutComponent");
                a0.h.d(loadClass3, "loader.loadClass(WINDOW_LAYOUT_COMPONENT_CLASS)");
                Method method6 = loadClass3.getMethod("addWindowLayoutInfoListener", Context.class, Consumer.class);
                Method method7 = loadClass3.getMethod("removeWindowLayoutInfoListener", Consumer.class);
                a0.h.d(method6, "addListenerMethod");
                if (Modifier.isPublic(method6.getModifiers())) {
                    a0.h.d(method7, "removeListenerMethod");
                    if (Modifier.isPublic(method7.getModifiers())) {
                        z2 = true;
                    }
                }
                return Boolean.valueOf(z2);
            default:
                Class<?> loadClass4 = eVar.f1192c.f1148a.loadClass("androidx.window.extensions.WindowExtensions");
                a0.h.d(loadClass4, "loader.loadClass(WindowE….WINDOW_EXTENSIONS_CLASS)");
                Method method8 = loadClass4.getMethod("getWindowLayoutComponent", null);
                Class<?> loadClass5 = eVar.f1190a.loadClass("androidx.window.extensions.layout.WindowLayoutComponent");
                a0.h.d(loadClass5, "loader.loadClass(WINDOW_LAYOUT_COMPONENT_CLASS)");
                a0.h.d(method8, "getWindowLayoutComponentMethod");
                if (Modifier.isPublic(method8.getModifiers()) && method8.getReturnType().equals(loadClass5)) {
                    z2 = true;
                }
                return Boolean.valueOf(z2);
        }
    }
}
